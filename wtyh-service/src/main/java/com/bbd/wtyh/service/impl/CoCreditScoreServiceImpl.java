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
	@Autowired
	private CompanyCreditMapper companyCreditMapper;

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
	private static String RESULT_CODE_9999="9999";//502,504
	private static String RESULT_CODE_9998="9998";//公信返回的数据格式错误，如包含错误字符
	private static String RESULT_CODE_9997="9997";//入库错误（锁等待 等）
	private static String RESULT_CODE_9996="9996";//其他网络错误

	@Override
	public void colseScoreCalculate() {
		isShutdown = true;
	}

	@Override
	public void creditScoreCalculate(Integer runMode) {
		CreditConfig.read();
		int isHandle = 0;// 0正常执行  1自动重试
		isShutdown = false;
		maxCompanyId = this.companyMapper.maxCompanyId();

		List<CompanyDO> companyList = this.getCompanyList();
		// 新增任务，更新开始时间、计划、成功、失败笔数
		TaskSuccessFailInfoDO taskSuccessFailInfoDO=taskBegin(TASK_NAME,TASK_GROUP,runMode,companyList.size());
		Integer taskId=taskSuccessFailInfoDO.getId();
		try {

			calculateProcess(companyList , taskId,  isHandle, runMode,"wtyh-credit-score-");

		}catch(Exception e){
			e.printStackTrace();
		}finally {

			endProcess(taskSuccessFailInfoDO, taskId);
		}

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
	public void executefailCompany(String[] companyNames, String resultCode, Integer taskId, Integer pageNumber, Integer pageSize) {

	}

	/**
	 * 手动计算历史task失败的企业
	 */
	@Override
	public void executeFailCompanyByTaskId(Integer runMode,Integer paramTaskId) {
		CreditConfig.read();
		List<CompanyDO> companyList = this.queryFailCompanyByTaskId(paramTaskId);
		int isHandle = 0;//
		// 新增任务，更新开始时间、计划、成功、失败笔数
		TaskSuccessFailInfoDO taskSuccessFailInfoDO=taskBegin(TASK_NAME,TASK_GROUP,runMode,companyList.size());
		Integer taskId=taskSuccessFailInfoDO.getId();

		try {

			calculateProcess(companyList , taskId,  isHandle, runMode,"wtyh-credit-rescore-");

		}catch (Exception e){
			e.printStackTrace();

		}finally {

			endProcess(taskSuccessFailInfoDO, taskId);

		}


	}

	private void calculateProcess(List<CompanyDO>companyList ,Integer taskId, int isHandle,int runMode,String threadName){
		try {

			// 本地模型加分项目
			final Map<String, Integer> pointMap = this.getCompanyCreditPointItems();

			ExecutorService dataExecutorService = Executors.newFixedThreadPool(CreditConfig.threadNum(), new ThreadFactory() {

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
					LOGGER.info("开始处理：" + companyDO.getCompanyId());
					calculateCompanyPoint(companyDO, pointMap, taskId, isHandle, runMode);
				});

			}
			dataExecutorService.shutdown();
			try {
				dataExecutorService.awaitTermination(1, TimeUnit.DAYS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 自动补偿参数传1
			untreatedCompanyFromDb(pointMap, taskId, 1);
		}catch (Exception e2){

			e2.printStackTrace();
		}
	}

	private void endProcess(TaskSuccessFailInfoDO taskSuccessFailInfoDO,Integer taskId){

		//备份成功失败名单到历史表
		this.executeCUD("insert into company_credit_fail_history (company_id,company_name,organization_code,credit_code,result_code,task_id,create_by,create_date) " +
				"SELECT company_id,company_name,organization_code,credit_code,result_code,task_id,create_by,now() FROM company_credit_fail_info WHERE task_id=?",taskId);
		this.executeCUD("insert into company_credit_raw_history (company_id,company_name,organization_code,credit_code,task_id,create_by,create_date) " +
				"SELECT company_id,company_name,organization_code,credit_code,task_id,create_by,now() FROM company_credit_raw_info WHERE task_id=?",taskId);

		//统计成功失败笔数
		int failCount=companyCreditMapper.countCreditFailInfo(taskId);
		int succCount=companyCreditMapper.countCreditRawInfo(taskId);

		//任务结束，更新结束时间、成功失败笔数
		taskEnd(taskSuccessFailInfoDO,succCount,failCount);

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
		if (taskId!=null) {
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
	public int queryfailCompanyCounts(String[] companyNames, String resultCode, Integer taskId, Integer pageNumber, Integer pageSize) {

		Map map = new HashMap();
		if (companyNames != null && companyNames.length > 0) {
			map.put("companyNames", companyNames);
		}
		if (StringUtils.isNotEmpty(resultCode)) {
			map.put("resultCode", resultCode);
		}
		if (taskId!=null) {
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
			calculateCompanyPoint(companyDO, pointMap, taskId, isHandle,1);
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
		List<String> resultCode=new ArrayList<>();
		resultCode.add(RESULT_CODE_9999);
		resultCode.add(RESULT_CODE_9998);
		resultCode.add(RESULT_CODE_9997);
		resultCode.add(RESULT_CODE_9996);
		int retryNum = CreditConfig.retryNum();
		for(int i=0;i<retryNum;i++){
			List<CompanyCreditFailInfoDO> list=this.companyCreditFailInfoMapper.getCompanyCreditFailInfoByTaskId(taskId,resultCode);
			if(list.size()==0){
				break;
			}
			for(CompanyCreditFailInfoDO companyCreditFailInfoDO:list){

				calculateCompanyPoint(transCompanyDO(companyCreditFailInfoDO), pointMap, taskId, isHandle,1);
			}
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
	private void calculateCompanyPoint(CompanyDO companyDO, Map<String, Integer> pointMap, Integer taskId, int isHandle,int runMode) {
		//定时任务才更新redis中保存的最大companyID；手动执行历史失败企业不需要更新redis中的companyID
		if(0==runMode) {
			resetBeginNum(companyDO.getCompanyId());
		}
		List<String> list ;
		try {
			list = getCreditFromShangHai(companyDO, pointMap, taskId, isHandle);
		} catch (Exception e) {
			//正常执行记录到失败表，自动重试不需要再次记录到失败表
			if(0==isHandle){
				// 数据错误9997，其他错误（锁等待 等） ,记录失败的企业
				insertCreditFailInfo(companyDO, RESULT_CODE_9997,  taskId);
			}

			LOGGER.error("公信数据其他错误。公司信息【id：{}，name：{}】。错误信息：{}。", companyDO.getCompanyId(), companyDO.getName(), e.getMessage());

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
		String xmlData = XyptWebServiceUtil.getCreditInfo(coDo.getName(), null, null);
		if (StringUtils.isBlank(xmlData)) {
			//正常执行记录到失败表，自动重试不需要再次记录到失败表
			if(0==isHandle) {
				//网络问题需要重新处理 记录失败的企业
				insertCreditFailInfo(coDo, RESULT_CODE_9996, taskId);
			}
			LOGGER.error("查询公司信用信息失败，已经录等待重试。公司信息【id：{}，name：{}】。返回：{}", coDo.getCompanyId(), coDo.getName(), xmlData);

			return null;
		}
		if("50X".equals(xmlData)){
			//正常执行记录到失败表，自动重试不需要再次记录到失败表
			if(0==isHandle) {
				//502、504问题需要重新处理 记录失败的企业
				insertCreditFailInfo(coDo, RESULT_CODE_9999, taskId);
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
				insertCreditFailInfo(coDo, RESULT_CODE_9998,  taskId);
			}
			LOGGER.error("公信返回格式错误。公司信息【id：{}，name：{}】。错误信息：{}。返回：{}", coDo.getCompanyId(), coDo.getName(), e.getMessage(), xmlData);
			return null;
		}

		Element root = document.getRootElement();
		String resultCode = root.elementText("RESULT");
		// 1005 表示查询成功
		if (!"1005".equals(resultCode)) {
			//正常执行记录到失败表，自动重试不需要再次记录到失败表
			if(0==isHandle) {
				insertCreditFailInfo(coDo, resultCode, taskId);
			}
			LOGGER.error("公信返回错误代码。公司信息【id：{}，name：{}】。返回：{}", coDo.getCompanyId(), coDo.getName(), xmlData);
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

	/**
	 * bean 转换
	 */
	private CompanyDO transCompanyDO(CompanyCreditFailInfoDO companyCreditFailInfoDO){
		CompanyDO companyDO =new CompanyDO();
		companyDO.setCompanyId(companyCreditFailInfoDO.getCompanyId());
		companyDO.setName(companyCreditFailInfoDO.getCompanyName());
		companyDO.setOrganizationCode(companyCreditFailInfoDO.getOrganizationCode());
		companyDO.setCreditCode(companyCreditFailInfoDO.getCreditCode());
		return companyDO;
	}

	private void insertCreditFailInfo(CompanyDO coDo,String resultCode,Integer taskId){
		this.executeCUD(
				"INSERT INTO company_credit_fail_info (company_id,company_name,organization_code,credit_code,result_code,task_id,create_by,create_date)values(?,?,?,?,?,?,?,?)",
				coDo.getCompanyId(), coDo.getName(), coDo.getOrganizationCode(), coDo.getCreditCode(), resultCode,taskId ,
				"system", new Date());
	}

	private TaskSuccessFailInfoDO taskBegin(String taskName,String taskGroup,Integer runMode,Integer planCount){
		//新增任务，更新开始时间、计划、成功、失败笔数
		TaskSuccessFailInfoDO taskSuccessFailInfoDO = new TaskSuccessFailInfoDO();
		taskSuccessFailInfoDO.setTaskName(taskName);
		taskSuccessFailInfoDO.setTaskGroup(taskGroup);
		taskSuccessFailInfoDO.setBeginDate(new Date());//任务开始时间
		taskSuccessFailInfoDO.setRunMode(runMode);
		taskSuccessFailInfoDO.setPlanCount(planCount);
		taskSuccessFailInfoDO.setSuccessCount(0);
		taskSuccessFailInfoDO.setFailCount(0);
		taskSuccessFailInfoDO.setCreateBy("system");
		taskSuccessFailInfoDO.setCreateDate(new Date());
		taskSuccessFailInfoMapper.addTaskSuccessFailInfo(taskSuccessFailInfoDO);
		return taskSuccessFailInfoDO;
	}

	private void taskEnd(TaskSuccessFailInfoDO taskSuccessFailInfoDO,Integer succCount,Integer failCount){
		//新增任务，更新开始时间、计划、成功、失败笔数
		//任务结束，更新结束时间、成功失败笔数
		taskSuccessFailInfoDO.setEndDate(new Date());
		taskSuccessFailInfoDO.setSuccessCount(succCount);
		taskSuccessFailInfoDO.setFailCount(failCount);
		taskSuccessFailInfoDO.setUpdateBy("system");
		taskSuccessFailInfoDO.setUpdateDate(new Date());
		taskSuccessFailInfoMapper.updateTaskSuccessFailInfo(taskSuccessFailInfoDO);
	}

}
