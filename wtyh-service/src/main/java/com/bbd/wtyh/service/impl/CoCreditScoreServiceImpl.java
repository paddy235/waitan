package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;
import com.bbd.shanghai.credit.utils.CreditConfig;
import com.bbd.shanghai.credit.utils.XyptWebServiceUtil;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.credit.CompanyCreditFailInfoDO;
import com.bbd.wtyh.mapper.*;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.CoCreditScoreService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
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
public class CoCreditScoreServiceImpl extends BaseServiceImpl implements CoCreditScoreService {

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
	private TaskSuccessFailInfoMapper taskSuccessFailInfoMapper;

	private static final Logger LOGGER = LoggerFactory.getLogger(CoCreditScoreService.class);
	// 已执行的公司ID
	public static final String REDIS_KEY_CREDIT_COMPANY = "wtyh:credit:company";
	public static final String REDIS_KEY_CREDIT_REHANDLE_COMPANY = "wtyh:credit:rehandle:company";
	// 执行成功的企业笔数
	public static final String REDIS_KEY_CREDIT_SUCCESS_COMPANY = "wtyh:credit:success:company";

	private volatile boolean isShutdown = false;
	private volatile int maxCompanyId = 0;
	private static String TASK_NAME = "shangHaiCreditJob";
	private static String TASK_GROUP = "credit_work";

	@Override
	public void colseScoreCalculate() {
		isShutdown = true;
	}

	@Override
	public void creditScoreCalculate() {
		String dataVersion = DateFormatUtils.format(new Date(), "yyyyMMdd");
		int isHandle = 0;
		CreditConfig.read();
		isShutdown = false;
		maxCompanyId = this.companyMapper.maxCompanyId();

		// 重置 重试列表-重试机制暂时不需要，有手动重试
		// redisDao.delete(REDIS_KEY_CREDIT_REHANDLE_COMPANY);

		List<CompanyDO> companyList = this.getCompanyList();
		// 新增或重置 本次任务计划、成功、失败笔数
		TaskSuccessFailInfoDO taskSuccessFailInfoDO = taskSuccessFailInfoMapper.getTaskSuccessFailInfo(TASK_NAME, TASK_GROUP, dataVersion);
		if (taskSuccessFailInfoDO == null || taskSuccessFailInfoDO.getId() == null) {
			taskSuccessFailInfoDO = new TaskSuccessFailInfoDO();
			taskSuccessFailInfoDO.setTaskName(TASK_NAME);
			taskSuccessFailInfoDO.setTaskGroup(TASK_GROUP);
			taskSuccessFailInfoDO.setDataVersion(dataVersion);
			taskSuccessFailInfoDO.setPlanCount(companyList.size());
			taskSuccessFailInfoDO.setSuccessCount(0);
			taskSuccessFailInfoDO.setFailCount(0);
			taskSuccessFailInfoDO.setCreateBy("system");
			taskSuccessFailInfoDO.setCreateDate(new Date());
			taskSuccessFailInfoMapper.addTaskSuccessFailInfo(taskSuccessFailInfoDO);
		} else {
			taskSuccessFailInfoDO.setPlanCount(companyList.size());
			taskSuccessFailInfoDO.setSuccessCount(0);
			taskSuccessFailInfoDO.setFailCount(0);
			taskSuccessFailInfoDO.setUpdateBy("system");
			taskSuccessFailInfoDO.setUpdateDate(new Date());
			taskSuccessFailInfoMapper.updateTaskSuccessFailInfo(taskSuccessFailInfoDO);
		}

		// 本地模型加分项目
		final Map<String, Integer> pointMap = this.getCompanyCreditPointItems();

		ExecutorService dataExecutorService = Executors.newFixedThreadPool(50, new ThreadFactory() {

			final LongAdder num = new LongAdder();

			@Override
			public Thread newThread(Runnable r) {
				num.increment();
				Thread t = new Thread(r);
				t.setName("wtyh-credit-score-" + num.toString());
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
				LOGGER.info("开始处理：" + companyDO.getCompanyId());
				calculateCompanyPoint(companyDO, pointMap, dataVersion, isHandle);
			});

		}
		dataExecutorService.shutdown();
		try {
			dataExecutorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 取消自动补偿，改为手动补偿
		// untreatedCompany(pointMap, dataVersion, isHandle);
	}

	private List<CompanyDO> getCompanyList() {
		int startId = this.getStartCoId();
		int dailyLimit = CreditConfig.dailyLimit();
		String coType = CreditConfig.dataType();

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
	public void executefailCompany(String[] companyNames, String resultCode, String dataVersion, Integer pageNumber, Integer pageSize) {
		List<CompanyCreditFailInfoDO> list = this.queryfailCompany(companyNames, resultCode, dataVersion, pageNumber, pageSize);
		// 本地模型加分项目
		final Map<String, Integer> pointMap = this.getCompanyCreditPointItems();
		int isHandle = 1;// isHandle 为0表示由定时任务执行 1表示手动补偿失败的企业、
		CreditConfig.read();
		for (CompanyCreditFailInfoDO companyCreditFailInfoDO : list) {
			CompanyDO companyDO = new CompanyDO();
			companyDO.setCompanyId(companyCreditFailInfoDO.getCompanyId());
			companyDO.setName(companyCreditFailInfoDO.getCompanyName());
			companyDO.setOrganizationCode(companyCreditFailInfoDO.getOrganizationCode());
			companyDO.setCreditCode(companyCreditFailInfoDO.getCreditCode());
			calculateCompanyPoint(companyDO, pointMap, dataVersion, isHandle);
		}
	}

	/**
	 * 查询失败的企业
	 */
	@Override
	public List<CompanyCreditFailInfoDO> queryfailCompany(String[] companyNames, String resultCode, String dataVersion, Integer pageNumber,
			Integer pageSize) {
		Map map = new HashMap();
		if (companyNames != null && companyNames.length > 0) {
			map.put("companyNames", companyNames);
		}
		if (StringUtils.isNotEmpty(resultCode)) {
			map.put("resultCode", resultCode);
		}
		if (StringUtils.isNotEmpty(dataVersion)) {
			map.put("dataVersion", dataVersion);
		}
		if (pageNumber != null && pageNumber > 0 && pageSize != null && pageSize > 0) {
			pageNumber = (pageNumber - 1) * pageSize;
			map.put("pageNumber", pageNumber);
			map.put("pageSize", pageSize);
		}

		return companyCreditFailInfoMapper.getCompanyCreditFailInfo(map);
	}

	@Override
	public int queryfailCompanyCounts(String[] companyNames, String resultCode, String dataVersion, Integer pageNumber, Integer pageSize) {

		Map map = new HashMap();
		if (companyNames != null && companyNames.length > 0) {
			map.put("companyNames", companyNames);
		}
		if (StringUtils.isNotEmpty(resultCode)) {
			map.put("resultCode", resultCode);
		}
		if (StringUtils.isNotEmpty(dataVersion)) {
			map.put("dataVersion", dataVersion);
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
	 * db 记录执行成功的企业笔数
	 * 
	 * @param dataVersion
	 */
	private synchronized void saveSuccessCompanyByDb(String dataVersion) {
		this.executeCUD(
				"UPDATE task_success_fail_info SET success_count=success_count+1 WHERE TASK_NAME=? AND task_group=? AND data_version=?",
				TASK_NAME, TASK_GROUP, dataVersion);

	}

	/**
	 * db 记录执行失败的企业笔数
	 * 
	 * @param dataVersion
	 */
	private synchronized void saveFailCompanyByDb(String dataVersion) {
		this.executeCUD("UPDATE task_success_fail_info SET fail_count=fail_count+1 WHERE TASK_NAME=? AND task_group=? AND data_version=?",
				TASK_NAME, TASK_GROUP, dataVersion);

	}

	/**
	 * 对调用上海市信息中心报错的企业，重新处理
	 *
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private void untreatedCompany(Map<String, Integer> pointMap, String dataVersion, int isHandle) {

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
			calculateCompanyPoint(companyDO, pointMap, dataVersion, isHandle);
		}

		List<Object> list = redisDao.range(REDIS_KEY_CREDIT_REHANDLE_COMPANY, 0, -1);
		if (CollectionUtils.isNotEmpty(list)) {
			LOGGER.error("查询公司信用信息重新处理结束，但仍然有部分公司失败。公司ID：{}", list);
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
	private void calculateCompanyPoint(CompanyDO companyDO, Map<String, Integer> pointMap, String dataVersion, int isHandle) {
		resetBeginNum(companyDO.getCompanyId());
		List<String> list = null;
		try {
			list = getCreditFromShangHai(companyDO, pointMap, dataVersion, isHandle);
		} catch (Exception e) {

			if (0 == isHandle) {
				// 数据错误9997，入库错误（锁等待 等） ,记录失败的企业
				this.executeCUD(
						"INSERT INTO company_credit_fail_info (company_id,company_name,organization_code,credit_code,result_code,data_version,create_by,create_date)values(?,?,?,?,?,?,?,?)",
						companyDO.getCompanyId(), companyDO.getName(), companyDO.getOrganizationCode(), companyDO.getCreditCode(), "9997",
						dataVersion, "system", new Date());
				// 记录失败笔数
				this.saveFailCompanyByDb(dataVersion);
			}
			LOGGER.error("查询公司信用信息报错。公司信息【id：{}，name：{}】。错误信息：{}。", companyDO.getCompanyId(), companyDO.getName(), e.getMessage());
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
	private List<String> getCreditFromShangHai(CompanyDO coDo, Map<String, Integer> pointMap, String dataVersion, int isHandle) {
		String xmlData = XyptWebServiceUtil.getCreditInfo(coDo.getName(), null, null);
		if (StringUtils.isBlank(xmlData)) {
			// 只对请求异常的公司做重新处理。
			// 网络中断等问题需要重新处理。
			CompanyDO newCodo = new CompanyDO();
			newCodo.setCompanyId(coDo.getCompanyId());
			newCodo.setName(coDo.getName());
			// 自动重试暂时屏蔽，改为手动重试
			// redisDao.in(REDIS_KEY_CREDIT_REHANDLE_COMPANY,
			// JSON.toJSONString(newCodo));

			// isHandle 为0表示由定时任务执行 1表示手动补偿失败的企业
			if (0 == isHandle) {
				// 未知错误9999,公信接口无返回 ,记录失败的企业
				this.executeCUD(
						"INSERT INTO company_credit_fail_info (company_id,company_name,organization_code,credit_code,result_code,data_version,create_by,create_date)values(?,?,?,?,?,?,?,?)",
						coDo.getCompanyId(), coDo.getName(), coDo.getOrganizationCode(), coDo.getCreditCode(), "9999", dataVersion,
						"system", new Date());
				// 记录失败笔数
				this.saveFailCompanyByDb(dataVersion);
			}

			LOGGER.error("查询公司信用信息失败，已经录等待重试。公司信息【id：{}，name：{}】。返回：{}", coDo.getCompanyId(), coDo.getName(), xmlData);
			return null;
		}

		Document document;
		try {

			xmlData = xmlData.replaceAll("&", "&amp;");

			document = DocumentHelper.parseText(xmlData);
		} catch (DocumentException e) {
			if (0 == isHandle) {
				// 未知错误9998，公信接口返回数据格式错误 ,记录失败的企业
				this.executeCUD(
						"INSERT INTO company_credit_fail_info (company_id,company_name,organization_code,credit_code,result_code,data_version,create_by,create_date)values(?,?,?,?,?,?,?,?)",
						coDo.getCompanyId(), coDo.getName(), coDo.getOrganizationCode(), coDo.getCreditCode(), "9998", dataVersion,
						"system", new Date());
				// 记录失败笔数
				this.saveFailCompanyByDb(dataVersion);
			}
			LOGGER.error("查询公司信用信息报错。公司信息【id：{}，name：{}】。错误信息：{}。返回：{}", coDo.getCompanyId(), coDo.getName(), e.getMessage(), xmlData);
			return null;
		}

		Element root = document.getRootElement();
		String resultCode = root.elementText("RESULT");
		// 1005 表示查询成功
		if (!"1005".equals(resultCode)) {
			if (0 == isHandle) {
				this.executeCUD(
						"INSERT INTO company_credit_fail_info (company_id,company_name,organization_code,credit_code,result_code,data_version,create_by,create_date)values(?,?,?,?,?,?,?,?)",
						coDo.getCompanyId(), coDo.getName(), coDo.getOrganizationCode(), coDo.getCreditCode(), resultCode, dataVersion,
						"system", new Date());
			}
			// 正常情况下都会有返回，对非1005的返回，不需要做重新处理，因为再次请求也是一样的结果
			LOGGER.error("查询公司信用信息失败。公司信息【id：{}，name：{}】。返回：{}", coDo.getCompanyId(), coDo.getName(), xmlData);
			// 记录失败笔数
			this.saveFailCompanyByDb(dataVersion);
			return null;
		}

		// 先删除成功表里的原始数据，后面再新增进去
		this.executeCUD("DELETE FROM company_credit_raw_info WHERE company_id = ?", coDo.getCompanyId());

		List<CompanyCreditRawInfoDO> lCcrids = new ArrayList<>();
		CompanyCreditRawInfoDO ccridTemplet = new CompanyCreditRawInfoDO();
		String rst = root.attributeValue("name");

		// 这4个字段，存我们自己的内容(company表)
		ccridTemplet.setCompanyId(coDo.getCompanyId());
		ccridTemplet.setCompanyName(coDo.getName());
		ccridTemplet.setOrganizationCode(coDo.getOrganizationCode());
		ccridTemplet.setCreditCode(coDo.getCreditCode());

		rst = root.attributeValue("cxbh");
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

		if (0 == isHandle) {
			// 定时任务，记录成功笔数
			saveSuccessCompanyByDb(dataVersion);
		}

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

}
