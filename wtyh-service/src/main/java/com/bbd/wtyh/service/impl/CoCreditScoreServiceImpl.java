package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bbd.shanghai.credit.utils.CreditConfig;
import com.bbd.shanghai.credit.utils.XyptWebServiceUtil;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.constants.TaskState;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.credit.CompanyCreditFailInfoDO;
import com.bbd.wtyh.domain.dto.CompanyCreditRawInfoDTO;
import com.bbd.wtyh.domain.dto.CreditInfoDTO;
import com.bbd.wtyh.domain.dto.CreditRiskDataDTO;
import com.bbd.wtyh.mapper.*;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.CoCreditScoreService;
import com.bbd.wtyh.service.TaskService;
import com.bbd.wtyh.web.PageBean;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

/**
 * 公司信用评分接口实现类
 *
 * @author Created by LiYao on 2017-04-25 14:54.
 */
@Service
public class CoCreditScoreServiceImpl extends BaseServiceImpl implements CoCreditScoreService,TaskService {

	@Autowired
	CompanyCreditRawInfoMapper ccriMapper;

	@Autowired
	private RedisDAO redisDao;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private CompanyCreditFailInfoMapper companyCreditFailInfoMapper;
	@Autowired
	private CompanyCreditInformationMapper companyCreditInformationMapper;
	@Autowired
	private CompanyCreditMapper companyCreditMapper;

	private static final Logger LOGGER = LoggerFactory.getLogger(CoCreditScoreService.class);
	// 已执行的公司ID
	public static final String REDIS_KEY_CREDIT_COMPANY = "wtyh:credit:company";
	public static final String REDIS_KEY_CREDIT_REHANDLE_COMPANY = "wtyh:credit:rehandle:company";
	// 执行成功的企业笔数
	public static final String REDIS_KEY_CREDIT_SUCCESS_COMPANY = "wtyh:credit:success:company";

	public static final String REDIS_KEY_COMPANY_CREDIT_ITEMS = "company-credit-items";

	private volatile boolean isShutdown = false;
	private volatile int maxCompanyId = 0;
	private static String RESULT_CODE_9999 = "9999";// 502,504
	private static String RESULT_CODE_9998 = "9998";// 公信返回的数据格式错误，如包含错误字符
	private static String RESULT_CODE_9997 = "9997";// 入库错误（锁等待 等）
	private static String RESULT_CODE_9996 = "9996";// 其他网络错误

	@Override
	public void colseScoreCalculate() {
		isShutdown = true;
	}

	@Override
	public TaskResultDO creditScoreCalculate(Integer taskId, Integer runMode) {
		LOGGER.info("--- credit data job begin ---");
		TaskResultDO taskResultDO = new TaskResultDO();
		CreditConfig.read();
		int isHandle = 0;// 0正常执行 1自动重试 //正常执行isHandle设置为0,会将失败企业记录到失败表
		isShutdown = false;
		maxCompanyId = this.companyMapper.maxCompanyId();

		List<CompanyDO> companyList = this.getCompanyList();

		taskResultDO.setPlanCount(companyList.size());

		try {

			// 本地模型加分项目
			final Map<String, Integer> pointMap = this.getCompanyCreditPointItems();

			// 取公信数据并进行分值计算
			calculateProcess(pointMap, companyList, taskId, isHandle, runMode, "wtyh-credit-score-", CreditConfig.threadNum());

			// 在规定的时间内正常执行完成，且笔数等于计划笔数，才进行补偿。否则算失败，不再进行补偿。
			int failCount = companyCreditMapper.countCreditFailInfo(taskId);
			int succCount = companyCreditMapper.countCreditRawInfo(taskId);

			Integer planCount = taskResultDO.getPlanCount();
			if (planCount != null && planCount.equals(failCount + succCount)) {
				// 自动补偿isHandle设置为1，后续不会再将失败的企业重复记录到失败表
				isHandle = 1;

				untreatedCompanyFromDb(pointMap, taskId, isHandle);
			} else {
				taskResultDO.setState(TaskState.ERROR);
			}

		} catch (Exception e) {
			taskResultDO.setState(TaskState.ERROR);
			LOGGER.error("creditScoreCalculate：" , e);
		} finally {

			endProcess(taskResultDO, taskId);

		}
		LOGGER.info("--- credit data job end ---");
		taskResultDO.setPlanCount(taskResultDO.getFailCount()+taskResultDO.getSuccessCount());
		return taskResultDO;
	}

	private List<CompanyDO> getCompanyList() {
		int startId = this.getStartCoId();
		int dailyLimit = CreditConfig.dailyLimit();
		String coType = CreditConfig.dataType();

		// 如果设置的笔数大于实际的企业数，就以实际的企业数为准
		int realCount = this.companyMapper.countAllCompanyByType(coType);
		if (dailyLimit > realCount) {
			dailyLimit = realCount;
		}

		List<CompanyDO> coList = new ArrayList<>(dailyLimit);

		List<CompanyDO> tmpLisst1 = this.companyMapper.getCompanyList(startId, coType, dailyLimit);

		if (CollectionUtils.isEmpty(tmpLisst1)) {
			startId = 0;
			this.resetBeginNum(startId);
			tmpLisst1 = this.companyMapper.getCompanyList(startId, coType, dailyLimit);
		}
		coList.addAll(tmpLisst1);

		if (coList.size() < dailyLimit) {
			startId = 0;
			dailyLimit = dailyLimit - coList.size();
			List<CompanyDO> tmpList = this.companyMapper.getCompanyList(startId, coType, dailyLimit);
			coList.addAll(tmpList);
		}

		return coList;

	}

	/**
	 * 起始公司ID
	 * 
	 * @return
	 */
	private int getStartCoId() {
		String str = redisDao.getString(REDIS_KEY_CREDIT_COMPANY);
		if (StringUtils.isNotBlank(str)) {
			return Integer.parseInt(str);
		}
		return 0;
	}

	/**
	 * 重新拉取和计算失败的企业
	 */
	@Override
	public void executefailCompany(String[] companyNames, String resultCode, Integer taskId, Integer pageNumber, Integer pageSize) {

	}

	/**
	 * 手动计算历史task失败的企业
	 */
	@Override
	public TaskResultDO executeFailCompanyByTaskId(Integer runMode, Integer oldTaskId, Integer taskId) {
		LOGGER.info("--- credit data handle begin ---");
		TaskResultDO taskResultDO = new TaskResultDO();
		CreditConfig.read();
		List<CompanyDO> companyList = this.queryFailCompanyByTaskId(oldTaskId);
		int isHandle = 0;// 正常执行isHandle设置为0,会将失败企业记录到失败表

		taskResultDO.setPlanCount(companyList.size());

		try {
			// 本地模型加分项目
			final Map<String, Integer> pointMap = this.getCompanyCreditPointItems();

			// 取公信数据并进行分值计算
			calculateProcess(pointMap, companyList, taskId, isHandle, runMode, "wtyh-credit-handle-", CreditConfig.threadNum());

			// 自动补偿isHandle设置为1，后续不会再将失败的企业重复记录到失败表
			isHandle = 1;

			untreatedCompanyFromDb(pointMap, taskId, isHandle);

		} catch (Exception e) {
			LOGGER.error("executeFailCompanyByTaskId：" , e);

		} finally {

			endProcess(taskResultDO, taskId);

		}
		LOGGER.info("--- credit data handle end ---");
		taskResultDO.setPlanCount(taskResultDO.getFailCount()+taskResultDO.getSuccessCount());
		return taskResultDO;

	}

	private void calculateProcess(Map<String, Integer> pointMap, List<CompanyDO> companyList, Integer taskId, int isHandle, int runMode,
			String threadName, int threadNum) {

		ExecutorService dataExecutorService = Executors.newFixedThreadPool(threadNum, new ThreadFactory() {

			final LongAdder num = new LongAdder();

			@Override
			public Thread newThread(Runnable r) {
				num.increment();
				Thread t = new Thread(r);
				t.setName(threadName + num.toString());
				// 设置为守护线程
				t.setDaemon(true);
				return t;
			}
		});

		for (CompanyDO companyDO : companyList) {

			dataExecutorService.execute(() -> {
				if (isShutdown) {
					return;
				}
				calculateCompanyPoint(companyDO, pointMap, taskId, isHandle, runMode);
			});

		}
		dataExecutorService.shutdown();
		try {
			dataExecutorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void endProcess(TaskResultDO taskResultDO, Integer taskId) {

		// 备份失败名单到历史表
		this.executeCUD(
				"insert into company_credit_fail_history (company_id,company_name,organization_code,credit_code,result_code,task_id,create_by,create_date) "
						+ "SELECT company_id,company_name,organization_code,credit_code,result_code,task_id,create_by,now() FROM company_credit_fail_info WHERE task_id=?",
				taskId);

		// 统计成功失败笔数
		int failCount = companyCreditMapper.countCreditFailInfo(taskId);
		int succCount = companyCreditMapper.countCreditRawInfo(taskId);

		taskResultDO.setSuccessCount(succCount);
		taskResultDO.setFailCount(failCount);

		if (null == taskResultDO.getState()) {
			int fail999Count = companyCreditMapper.countCreditFailInfoBy999(taskId);
			// 计划笔数=成功+失败笔数 且 没有999错误，才定义为成功
			Integer planCount = taskResultDO.getPlanCount();
			if (planCount != null && planCount.equals(failCount + succCount) && 0 == fail999Count) {
				taskResultDO.setState(TaskState.SUCCESS);
			}
		}

	}

	/**
	 * 查询失败的企业
	 */
	@Override
	public List<CompanyCreditFailInfoDO> queryfailCompany(String[] companyNames, String resultCode, Integer taskId, Integer pageNumber,
			Integer pageSize) {
		Map map = new HashMap();
		if (companyNames != null && companyNames.length > 0) {
			map.put("companyNames", companyNames);
		}
		if (StringUtils.isNotEmpty(resultCode)) {
			map.put("resultCode", resultCode);
		}
		if (taskId != null) {
			map.put("taskId", taskId);
		}
		if (pageNumber != null && pageNumber > 0 && pageSize != null && pageSize > 0) {
			pageNumber = (pageNumber - 1) * pageSize;
			map.put("pageNumber", pageNumber);
			map.put("pageSize", pageSize);
		}

		return companyCreditFailInfoMapper.getCompanyCreditFailInfo(map);
	}

	/**
	 * 查询历史task失败的企业
	 */
	public List<CompanyDO> queryFailCompanyByTaskId(Integer taskId) {

		return companyCreditMapper.getCompanyCreditFailByTaskId(taskId);
	}

	@Override
	public List<TaskFailInfoDO> getCreditFailInfoByTaskId(Integer taskId) {
		return companyCreditMapper.getCreditFailInfoByTaskId(taskId);
	}

	@Override
	public List<CreditInfoDTO> getCreditInfo(String companyName, String dataType, PageBean pageBean) {

		Map<Integer, String> items;
		List<CreditInfoDTO> list;
		List<String> types = null;
		if (dataType != null && !"0".equals(dataType)) {
			types = new ArrayList<>();
			String[] arrDataType = dataType.split(",");
			Object obj = redisDao.getObject(REDIS_KEY_COMPANY_CREDIT_ITEMS);

			if (obj != null) {
				items = (Map<Integer, String>) obj;
				for (String anArrDataType : arrDataType) {
					Integer it = Integer.valueOf(anArrDataType);
					types.add(items.get(it));
				}

			} else {

				items = new HashMap();
				List<CompanyCreditPointItemsDO> itemList = companyCreditInformationMapper.selectCompanyCreditPointItems();
				for (CompanyCreditPointItemsDO c : itemList) {
					items.put(c.getId(), c.getItem());
				}
				redisDao.addObject(REDIS_KEY_COMPANY_CREDIT_ITEMS, items, Constants.cacheDay_One_Day, Map.class);
				for (String anArrDataType : arrDataType) {
					Integer it = Integer.valueOf(anArrDataType);
					types.add(items.get(it));
				}

			}
		}
		if(null != pageBean){
			pageBean.setTotalCount(companyCreditMapper.countCreditInfo(companyName, types));
		}
		list = companyCreditMapper.getCreditInfo(companyName, types, pageBean);
		List<CompanyCreditDataItemsDO> dataItemList = companyCreditMapper.getCreditDataItems();
		Map<String, String> dataItemMap = new HashMap<>();
		for (CompanyCreditDataItemsDO itemsDO : dataItemList) {
			dataItemMap.put(itemsDO.getResourceName() + "-" + itemsDO.getDataItem(), itemsDO.getDataItemName());
		}
		for (CreditInfoDTO creditInfoDTO : list) {
			try {
				StringBuilder sb = new StringBuilder();
				String content = creditInfoDTO.getContent();
				JSONObject jsonObject = JSON.parseObject(content);
				Set<String> keys = new TreeSet(jsonObject.keySet());

				for (Object obj : keys) {
					String key = creditInfoDTO.getResourceName() + "-" + obj;
					String str = dataItemMap.get(key);
					if (str != null) {
						sb.append(str);
					} else {
						sb.append(obj);
					}
					sb.append(":");
					sb.append("\"");
					sb.append(jsonObject.get(obj + ""));
					sb.append("\"");
					sb.append(",");
				}
				String contentTemp = sb.toString();
				contentTemp = contentTemp.substring(0, contentTemp.length() - 1);
				creditInfoDTO.setContent(contentTemp);
			} catch (Exception e) {
				LOGGER.error("getCreditInfo:" + e);
			}
		}
		return list;
	}

	@Override
	public List<CompanyCreditRawInfoDTO> getCreditInfoByCompanyAndType(String companyName, String dataType, PageBean pageBean) {

		List<CompanyCreditRawInfoDTO> list;
		if(null != pageBean){
			pageBean.setTotalCount(companyCreditMapper.countCreditInfoByCompanyAndType(companyName, dataType));
		}
		list = companyCreditMapper.getCreditInfoByCompanyAndType(companyName, dataType, pageBean);

		return list;
	}

    @Override
    public List<CreditRiskDataDTO> getResourceCounts(Integer companyId, String companyName) {
        List<CreditRiskDataDTO> list = companyCreditMapper.getResourceCounts(companyId,companyName);
        return list;
    }

    @Override
	public int queryfailCompanyCounts(String[] companyNames, String resultCode, Integer taskId, Integer pageNumber, Integer pageSize) {

		Map map = new HashMap();
		if (companyNames != null && companyNames.length > 0) {
			map.put("companyNames", companyNames);
		}
		if (StringUtils.isNotEmpty(resultCode)) {
			map.put("resultCode", resultCode);
		}
		if (taskId != null) {
			map.put("taskId", taskId);
		}
		if (pageNumber != null && pageNumber > 0 && pageSize != null && pageSize > 0) {
			pageNumber = (pageNumber - 1) * pageSize;
			map.put("pageNumber", pageNumber);
			map.put("pageSize", pageSize);
		}

		return companyCreditFailInfoMapper.getCompanyCreditFailInfoCounts(map);

	}

	private static final Object LOCK = "";

	private void resetBeginNum(int companyId) {
		synchronized (LOCK) {
			String str = redisDao.getString(REDIS_KEY_CREDIT_COMPANY);
			if (StringUtils.isNotBlank(str)) {
				Integer beginNum = Integer.parseInt(str);
				// 当缓存ID和最大ID一致时，更新新的ID进去
				if (beginNum.equals(maxCompanyId) || companyId > beginNum) {
					redisDao.set(REDIS_KEY_CREDIT_COMPANY, companyId + "", Constants.REDIS_10);
				}
			} else {
				redisDao.addString(REDIS_KEY_CREDIT_COMPANY, companyId + "", Constants.REDIS_10);
			}
		}

	}

	/**
	 * redis 记录执行成功的企业笔数
	 * 
	 * @param dataVersion
	 */
	@SuppressWarnings("unused")
	private void saveSuccessCompanyByRedis(String dataVersion) {
		synchronized (LOCK) {
			String str = (String) redisDao.getHashField(REDIS_KEY_CREDIT_SUCCESS_COMPANY + ":" + dataVersion, "success");
			if (StringUtils.isNotBlank(str)) {
				Integer counts = Integer.parseInt(str);
				// 当缓存ID和最大ID一致时，更新新的ID进去
				counts = counts + 1;
				redisDao.addHash(REDIS_KEY_CREDIT_SUCCESS_COMPANY + ":" + dataVersion, "success", counts + "", Constants.REDIS_3);
			} else {
				redisDao.addHash(REDIS_KEY_CREDIT_SUCCESS_COMPANY + ":" + dataVersion, "success", "1", Constants.REDIS_3);
			}
		}

	}

	/**
	 * 对调用上海市信息中心报错的企业，重新处理
	 *
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private void untreatedCompanyFromRedis(Map<String, Integer> pointMap, Integer taskId, int isHandle) {

		Long length = redisDao.length(REDIS_KEY_CREDIT_REHANDLE_COMPANY);

		if (length == null || length <= 0) {
			return;
		}

		for (long i = 0; i < length; i++) {
			String str = redisDao.out(REDIS_KEY_CREDIT_REHANDLE_COMPANY);
			if (StringUtils.isBlank(str)) {
				continue;
			}
			CompanyDO companyDO = JSON.parseObject(str, CompanyDO.class);
			LOGGER.info(companyDO.getCompanyId() + " rehandle ");
			calculateCompanyPoint(companyDO, pointMap, taskId, isHandle, 1);
		}

		List<Object> list = redisDao.range(REDIS_KEY_CREDIT_REHANDLE_COMPANY, 0, -1);
		if (CollectionUtils.isNotEmpty(list)) {
			LOGGER.error("查询公司信用信息重新处理结束，但仍然有部分公司失败。公司ID：{}", list);
		}

	}

	/**
	 * 对调用上海市信息中心报错的企业，重新处理
	 *
	 *
	 * @return
	 */
	private void untreatedCompanyFromDb(Map<String, Integer> pointMap, Integer taskId, int isHandle) {
		List<String> resultCode = new ArrayList<>();
		resultCode.add(RESULT_CODE_9999);
		resultCode.add(RESULT_CODE_9998);
		resultCode.add(RESULT_CODE_9997);
		resultCode.add(RESULT_CODE_9996);
		int retryNum = CreditConfig.retryNum();
		int retryThreadNum = CreditConfig.retryThreadNum();
		int runMode = 1;// 手动执行或自动补偿
		for (int i = 0; i < retryNum; i++) {
			List<CompanyDO> companyList = this.companyCreditFailInfoMapper.getCompanyDoByTaskId(taskId, resultCode);
			if (companyList.size() == 0) {
				break;
			}
			int j = i + 1;
			LOGGER.info("自动补偿开始：" + j);

			// 取公信数据并进行分值计算
			calculateProcess(pointMap, companyList, taskId, isHandle, runMode, "wtyh-credit-retry" + j + "-", retryThreadNum);

		}

	}

	/**
	 * 计算分值
	 * 
	 * @param companyDO
	 *            公司名称
	 * @param pointMap
	 *            加分项
	 */
	private void calculateCompanyPoint(CompanyDO companyDO, Map<String, Integer> pointMap, Integer taskId, int isHandle, int runMode) {
		// 定时任务才更新redis中保存的最大companyID；手动执行历史失败企业不需要更新redis中的companyID
		if (0 == runMode) {
			resetBeginNum(companyDO.getCompanyId());
		}
		List<String> list;
		try {
			list = getCreditFromShangHai(companyDO, pointMap, taskId, isHandle);
		} catch (Exception e) {
			// 正常执行记录到失败表，自动重试不需要再次记录到失败表
			if (0 == isHandle) {
				// 数据错误9997，其他错误（锁等待 等） ,记录失败的企业
				insertCreditFailInfo(companyDO, RESULT_CODE_9997, taskId);
			}

			LOGGER.error("公信数据9997错误。公司信息【id：{}，name：{}】。错误信息：{}。", companyDO.getCompanyId(), companyDO.getName(), e.getMessage());

			return;
		}

		if (CollectionUtils.isEmpty(list)) {
			return;
		}
		final Integer creditInfoRisk = this.getCompanyRiskInfo(pointMap, list);

		CompanyCreditDetailDO companyCreditDetailDO = this.selectById(CompanyCreditDetailDO.class, companyDO.getCompanyId());

		if (companyCreditDetailDO == null) {
			companyCreditDetailDO = new CompanyCreditDetailDO();
			companyCreditDetailDO.setCreateBy("system");
			companyCreditDetailDO.setCreateDate(new Date());
		} else {
			companyCreditDetailDO.setUpdateBy("system");
			companyCreditDetailDO.setUpdateDate(new Date());
		}
		companyCreditDetailDO.setCompanyRiskInfo(creditFormula(creditInfoRisk).floatValue());

		if (companyCreditDetailDO.getCompanyId() == null) {
			companyCreditDetailDO.setCompanyId(companyDO.getCompanyId());
			this.insert(companyCreditDetailDO);
		} else {
			this.update(companyCreditDetailDO);
		}
		LOGGER.info("----saveCompanyCreditRisk----saveU----{}", companyDO.getCompanyId());

	}

	/**
	 * 从上海市信息中心获取公司信用信息
	 *
	 * @param coDo
	 * @param pointMap
	 */
	private List<String> getCreditFromShangHai(CompanyDO coDo, Map<String, Integer> pointMap, Integer taskId, int isHandle) {
		String xmlData = XyptWebServiceUtil.getCreditInfo(coDo.getName(), "", "");
		if (StringUtils.isBlank(xmlData)) {
			// 正常执行记录到失败表，自动重试不需要再次记录到失败表
			if (0 == isHandle) {
				// 网络问题需要重新处理 记录失败的企业
				insertCreditFailInfo(coDo, RESULT_CODE_9996, taskId);
			}
			LOGGER.error("公信数据9996错误。公司信息【id：{}，name：{}】。返回：{}", coDo.getCompanyId(), coDo.getName(), xmlData);

			return null;
		}
		if ("50X".equals(xmlData)) {
			// 正常执行记录到失败表，自动重试不需要再次记录到失败表
			if (0 == isHandle) {
				// 502、504问题需要重新处理 记录失败的企业
				insertCreditFailInfo(coDo, RESULT_CODE_9999, taskId);
			}
			LOGGER.error("公信数据9999错误。公司信息【id：{}，name：{}】。返回：{}", coDo.getCompanyId(), coDo.getName(), xmlData);

			return null;
		}

		Document document;
		try {

			xmlData = xmlData.replaceAll("&", "&amp;");

			document = DocumentHelper.parseText(xmlData);
		} catch (DocumentException e) {
			if (0 == isHandle) {
				// 未知错误9998，公信接口返回数据格式错误 ,记录失败的企业
				insertCreditFailInfo(coDo, RESULT_CODE_9998, taskId);
			}
			LOGGER.error("公信数据9998错误。公司信息【id：{}，name：{}】。错误信息：{}。返回：{}", coDo.getCompanyId(), coDo.getName(), e.getMessage(), xmlData);
			return null;
		}

		Element root = document.getRootElement();
		String resultCode = root.elementText("RESULT");
		// 1005 表示查询成功
		if (!"1005".equals(resultCode)) {

			// 若这家企业执行成功，则从失败企业表中删除。
			this.executeCUD("DELETE FROM company_credit_fail_info WHERE company_id = ?", coDo.getCompanyId());

			insertCreditFailInfo(coDo, resultCode, taskId);

			LOGGER.error("公信数据100X错误。公司信息【id：{}，name：{}】。返回：{}", coDo.getCompanyId(), coDo.getName(), xmlData);
			return null;
		}

		// 先删除成功表里的原始数据，后面再新增进去
		this.executeCUD("DELETE FROM company_credit_raw_info WHERE company_id = ?", coDo.getCompanyId());

		List<CompanyCreditRawInfoDO> lCcrids = new ArrayList<>();
		CompanyCreditRawInfoDO ccridTemplet = new CompanyCreditRawInfoDO();
		ccridTemplet.setTaskId(taskId);
		// 这4个字段，存我们自己的内容(company表)
		ccridTemplet.setCompanyId(coDo.getCompanyId());
		ccridTemplet.setCompanyName(coDo.getName());
		ccridTemplet.setOrganizationCode(coDo.getOrganizationCode());
		ccridTemplet.setCreditCode(coDo.getCreditCode());

		String rst = root.attributeValue("cxbh");
		if (StringUtils.isNotBlank(rst)) {
			ccridTemplet.setCxbh(rst.trim());
		}
		List<String> pointNameList = new ArrayList<>();
		List nodes = root.elements("RESOURCE");
		for (Object node : nodes) {
			CompanyCreditRawInfoDO ccrid = ccridTemplet.clone();
			Element resource = (Element) node;
			// 信息事项名称
			String value = resource.attributeValue("RESOURCENAME");
			if (StringUtils.isBlank(value)) {
				continue;
			}
			value = value.trim();
			ccrid.setResourceName(value);
			rst = resource.attributeValue("XXLB");
			if (StringUtils.isNotBlank(rst)) {
				ccrid.setXxlb(rst.trim());
			}
			rst = resource.attributeValue("XXSSDW");
			if (StringUtils.isNotBlank(rst)) {
				ccrid.setXxssdw(rst.trim());
			}
			rst = resource.attributeValue("XXSSDWDM");
			if (StringUtils.isNotBlank(rst)) {
				ccrid.setXxssdwCode(rst.trim());
			}
			rst = resource.attributeValue("RESOURCECODE");
			if (StringUtils.isNotBlank(rst)) {
				ccrid.setResourceCode(rst.trim());
			}
			rst = resource.attributeValue("RESOURCES");
			if (StringUtils.isNotBlank(rst)) {
				ccrid.setResources(rst.trim());
			}

			List contentElements = resource.elements();
			Map<String, String> map = new HashMap<>();
			contentElements.forEach(o -> {
				Element e = (Element) o;
				map.put(e.getName(), e.getText());
			});
			ccrid.setContent(JSON.toJSONString(map));

			lCcrids.add(ccrid);
			// 不保留不存在加分项的数据，减少数据集
			if (pointMap.get(value) == null || pointMap.get(value) <= 0) {
				continue;
			}
			pointNameList.add(value);
		}
		if (lCcrids.size() > 0) {

			for (CompanyCreditRawInfoDO cd : lCcrids) {
				ccriMapper.saveCompanyCreditRawInfo(cd);
			}
		} else {
			ccriMapper.saveCompanyCreditRawInfo(ccridTemplet);
		}

		// 若这家企业执行成功，则从失败企业表中删除。
		this.executeCUD("DELETE FROM company_credit_fail_info WHERE company_id = ?", coDo.getCompanyId());

		return pointNameList;
	}

	/**
	 * 获取本地模型条目
	 *
	 * @return
	 */
	private Map<String, Integer> getCompanyCreditPointItems() {
		List<CompanyCreditPointItemsDO> items = companyCreditInformationMapper.selectCompanyCreditPointItems();
		Map<String, Integer> tempMap = new HashMap<>();
		if (!CollectionUtils.isEmpty(items)) {
			for (CompanyCreditPointItemsDO companyCreditPointItemsDO : items) {
				tempMap.put(companyCreditPointItemsDO.getItem(), companyCreditPointItemsDO.getPoint());
			}
		}
		return tempMap;
	}

	/**
	 * 统计本地模型总分
	 *
	 * @param
	 * @param pointMap
	 * @param list
	 * @return
	 */
	private Integer getCompanyRiskInfo(Map<String, Integer> pointMap, List<String> list) {
		Integer creditInfoRisk = 0;

		if (CollectionUtils.isEmpty(list) || MapUtils.isEmpty(pointMap)) {
			return creditInfoRisk;
		}

		for (String value : list) {
			if (pointMap.get(value) != null && pointMap.get(value) > 0) {
				creditInfoRisk += pointMap.get(value);
			}
		}
		return creditInfoRisk;
	}

	/**
	 * 本地模型分数统计逻辑 本地模型分数 开3次方 再乘以5
	 *
	 * @param creditInfoRisk
	 * @return
	 */
	private BigDecimal creditFormula(Integer creditInfoRisk) {
		return new BigDecimal(Math.pow(creditInfoRisk, 1.0 / 3) * 5);
	}

	private void insertCreditFailInfo(CompanyDO coDo, String resultCode, Integer taskId) {
		this.executeCUD(
				"INSERT INTO company_credit_fail_info (company_id,company_name,organization_code,credit_code,result_code,task_id,create_by,create_date)values(?,?,?,?,?,?,?,?)",
				coDo.getCompanyId(), coDo.getName(), coDo.getOrganizationCode(), coDo.getCreditCode(), resultCode, taskId, "system",
				new Date());
	}

	@Override
	public String getTaskKey() {
		return "shangHaiCreditJob";
	}

	@Override
	public String getTaskGroup() {
		return "credit_work";
	}

	@Override
	public TaskResultDO autoExecute(Integer taskId, Integer runMode) {
		TaskResultDO taskResultDO=creditScoreCalculate(taskId, runMode);
		return taskResultDO;
	}

	@Override
	public TaskResultDO reExecute(Integer oldTaskId, Integer newTaskId, Integer runMode) {
		TaskResultDO taskResultDO=executeFailCompanyByTaskId(runMode, oldTaskId, newTaskId);
		return taskResultDO;
	}

	@Override
	public void stopExecute(Integer taskId) {
		colseScoreCalculate();
	}

    @Override
    public void resetTask() {
        this.isShutdown=false;
    }
}
