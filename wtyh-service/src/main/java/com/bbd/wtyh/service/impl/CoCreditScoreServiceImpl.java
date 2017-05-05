package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;
import com.bbd.shanghai.credit.utils.XyptWebServiceUtil;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.mapper.CompanyCreditDetailMapper;
import com.bbd.wtyh.mapper.CompanyCreditInformationMapper;
import com.bbd.wtyh.mapper.CompanyCreditRawInfoMapper;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.CoCreditScoreService;
import net.sf.json.xml.XMLSerializer;
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
public class CoCreditScoreServiceImpl implements CoCreditScoreService {

	@Autowired
	CompanyCreditRawInfoMapper ccriMapper;

	@Autowired
	private RedisDAO redisDao;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private CompanyCreditInformationMapper companyCreditInformationMapper;
	@Autowired
	private CompanyCreditDetailMapper companyCreditDetailMapper;

	private static final Logger LOGGER = LoggerFactory.getLogger(CoCreditScoreService.class);

	private static final int DAILY_LIMIT = 100000;// 10W
	// 已执行的公司ID
	public static final String REDIS_KEY_CREDIT_COMPANY = "wtyh:credit:company";
	public static final String REDIS_KEY_CREDIT_REHANDLE_COMPANY = "wtyh:credit:rehandle:company";

	// 定时任务执行的起始日
	public static final int TASK_BEGIN_DAY = 15;

	@Override
	public void creditScoreCalculate() {
		// 重置 重试列表
		redisDao.delete(REDIS_KEY_CREDIT_REHANDLE_COMPANY);
		int totalCount = this.getCompanyTotal();
		if (totalCount <= 0) {
			return;
		}

		// 上海市信息中心，一般情况下每月10号前更新数据，但不保证10号肯定更新完。定时任务每月15日开始
		// 上海市信息中心，支持24小时10万条记录
		final int pageSize = 10;
		int totalPage = 5;
		// TODO final int pageSize = 1000;
		// TODO int totalPage = (totalCount - 1) / pageSize + 1;

		// 本地模型加分项目
		final Map<String, Integer> pointMap = this.getCompanyCreditPointItems();

		ExecutorService dataExecutorService = Executors.newFixedThreadPool(20, new ThreadFactory() {

			final LongAdder num = new LongAdder();

			@Override
			public Thread newThread(Runnable r) {
				num.increment();
				Thread t = new Thread(r);
				t.setName("wtyh-credit-score" + num.toString());
				// 设置为守护线程
				t.setDaemon(true);
				return t;
			}
		});

		for (int pageNo = 1; pageNo <= totalPage; pageNo++) {
			final int pageIndex = pageNo;
			// 执行线程
			dataExecutorService.execute(() -> {
				Pagination pagination = new Pagination();
				pagination.setPageSize(pageSize);
				pagination.setCount(totalCount);
				pagination.setPageNumber(pageIndex);
				pagination.getLastPageNumber();

				Map<String, Object> params = new HashMap<>();
				params.put("pagination", pagination);

				// 分页查询公司信息
				List<CompanyDO> pageList = companyMapper.findByPage(params);
				if (CollectionUtils.isEmpty(pageList)) {
					return;
				}

				for (CompanyDO companyDO : pageList) {
					LOGGER.info(companyDO.getCompanyId() + "");
					calculateCompanyPoint(companyDO, pointMap);
				}
			});
		}

		dataExecutorService.shutdown();
		try {
			dataExecutorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		untreatedCompany(pointMap);
	}

	private void resetBeginNum(Integer companyId) {
		String str = redisDao.getString(REDIS_KEY_CREDIT_COMPANY);
		if (StringUtils.isNotBlank(str)) {
			Integer beginNum = Integer.parseInt(str);
			if (companyId > beginNum) {
				redisDao.addString(REDIS_KEY_CREDIT_COMPANY, companyId.toString(), Constants.REDIS_10);
			}
		} else {
			redisDao.addString(REDIS_KEY_CREDIT_COMPANY, companyId.toString(), Constants.REDIS_10);
		}
	}

	/**
	 * 对调用上海市信息中心报错的企业，重新处理
	 *
	 *
	 * @return
	 */
	private void untreatedCompany(Map<String, Integer> pointMap) {

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
			calculateCompanyPoint(companyDO, pointMap);
		}

		List<Object> list = redisDao.range(REDIS_KEY_CREDIT_REHANDLE_COMPANY, 0, -1);
		if (CollectionUtils.isNotEmpty(list)) {
			LOGGER.error("查询公司信用信息重新处理结束，但仍然有部分公司失败。公司ID：{}", list);
		}

	}

	/**
	 * 获取公司总数。<br>
	 * 上海市信息中心，支持24小时10万条记录。所以该方法来处理每天查询数量，如果超过10W，将只处理10W，剩下的后面再处理。
	 * 
	 * @return
	 */
	private int getCompanyTotal() {
		int startId = 0;
		int d = Calendar.getInstance().get(Calendar.DATE);
		// 如果是定时任务开始日期，就认为是第一次开始，则置为0;否则从redis中读取要开始执行的ID
		if (TASK_BEGIN_DAY != d) {

			String str = redisDao.getString(REDIS_KEY_CREDIT_COMPANY);
			if (StringUtils.isNotBlank(str)) {
				startId = Integer.parseInt(str);
			}
		}

		int totalCount = this.companyMapper.countCompanyGTId(startId);

		if (totalCount <= DAILY_LIMIT) {
			return totalCount;
		}

		return DAILY_LIMIT;
	}

	/**
	 * 计算分值
	 * 
	 * @param companyDO
	 *            公司名称
	 * @param pointMap
	 *            加分项
	 */
	private void calculateCompanyPoint(CompanyDO companyDO, Map<String, Integer> pointMap) {
		resetBeginNum(companyDO.getCompanyId());
		List<String> list = getCreditFromShangHai(companyDO, pointMap);

		if (CollectionUtils.isEmpty(list)) {
			return;
		}
		final Integer creditInfoRisk = this.getCompanyRiskInfo(pointMap, list);

		CompanyCreditDetailDO companyCreditDetailDO = new CompanyCreditDetailDO();
		companyCreditDetailDO.setCompanyId(companyDO.getCompanyId());
		companyCreditDetailDO.setCompanyRiskInfo(creditFormula(creditInfoRisk).floatValue());
		companyCreditDetailDO.setCreateBy("system");
		companyCreditDetailDO.setCreateDate(new Date());
		companyCreditDetailMapper.save(companyCreditDetailDO);
		System.out.println("----saveCompanyCreditRisk----saveU----" + companyDO.getCompanyId());

	}

	/**
	 * 从上海市信息中心获取公司信用信息
	 *
	 * @param coDo
	 * @param pointMap
	 */
	private List<String> getCreditFromShangHai(CompanyDO coDo, Map<String, Integer> pointMap) {
		String xmlData = XyptWebServiceUtil.getCreditInfo(coDo.getName(), null, null);
		if (StringUtils.isBlank(xmlData)) {
			// 只对请求异常的公司做重新处理。
			// 网络中断等问题需要重新处理。
			CompanyDO newCodo = new CompanyDO();
			newCodo.setCompanyId(coDo.getCompanyId());
			newCodo.setName(coDo.getName());
			redisDao.in(REDIS_KEY_CREDIT_REHANDLE_COMPANY, JSON.toJSONString(newCodo));
			LOGGER.error("查询公司信用信息失败，已经录等待重试。公司信息【id：{}，name：{}】。返回：{}", coDo.getCompanyId(), coDo.getName(), xmlData);
			return null;
		}

		Document document;
		try {
			document = DocumentHelper.parseText(xmlData);
		} catch (DocumentException e) {
			LOGGER.error("查询公司信用信息报错。公司信息【id：{}，name：{}】。错误信息：{}。返回：{}", coDo.getCompanyId(), coDo.getName(), e.getMessage(), xmlData);
			return null;
		}

		Element root = document.getRootElement();
		String resultCode = root.elementText("RESULT");
		// 1005 表示查询成功
		if (!"1005".equals(resultCode)) {
			// 正常情况下都会有返回，对非1005的返回，不需要做重新处理，因为再次请求也是一样的结果
			LOGGER.error("查询公司信用信息失败。公司信息【id：{}，name：{}】。返回：{}", coDo.getCompanyId(), coDo.getName(), xmlData);
			return null;
		}
		List<CompanyCreditRawInfoDO> lCcrids =new ArrayList<>();
		CompanyCreditRawInfoDO ccridTemplet = new CompanyCreditRawInfoDO();
		String rst = root.attributeValue("name");
		String companyNameTemp =null;
		if (StringUtils.isNotBlank(rst)) {
			ccridTemplet.setCompanyName(rst.trim());
			companyNameTemp =rst;
		}
		rst = root.attributeValue("zjhm");
		if (StringUtils.isNotBlank(rst.trim())) {
			ccridTemplet.setOrganizationCode(rst);
		}
		rst = root.attributeValue("tydm");
		if (StringUtils.isNotBlank(rst)) {
			ccridTemplet.setCreditCode(rst.trim());
		}
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
			rst =resource.getText();
			if (StringUtils.isNotBlank(rst)) {
				String xmlAll ="<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>" +rst +"</root>";
				try {
					ccrid.setContent((new XMLSerializer()).read(xmlAll).toString());
				} catch (Exception e) {
				}
			}
			lCcrids.add(ccrid);
			// 不保留不存在加分项的数据，减少数据集
			if (pointMap.get(value) == null || pointMap.get(value) <= 0) {
				continue;
			}
			pointNameList.add(value);
		}
		if( lCcrids.size() >0 ) {
			if(null ==companyNameTemp) {
				ccriMapper.removeCompanyCreditRawInfoByCompanyName(companyNameTemp);
			}
			for( CompanyCreditRawInfoDO cd : lCcrids ) {
				ccriMapper.saveCompanyCreditRawInfo(cd);
			}
		}
		return pointNameList;
	}

	public static void main(String []argc) {
		String rst ="<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>" +
				"<punishmeasures>处罚种类:药包材;处罚内容:罚款</punishmeasures>\n" +
				"\t\t<licensestatus></licensestatus>\n" +
				"\t\t<illegaldate></illegaldate>\n" +
				"\t\t<illegalcontext>使用不合格药包材</illegalcontext>\n" +
				"\t\t<punishdate>2011-01-04 00:00:00.0</punishdate>\n" +
				"\t\t<punishlimit></punishlimit>\n" +
				"\t\t<punishbasis>《管理办法》第六十五条</punishbasis>\n" +
				"</root>";
		XMLSerializer xs =new XMLSerializer();
		String aaa = xs.read(rst).toString();
		CompanyCreditRawInfoDO cd1 =new CompanyCreditRawInfoDO();
		cd1.setResourceName("srcName");
		CompanyCreditRawInfoDO cd2= cd1.clone();
		cd2.setResourceName("ss");
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
