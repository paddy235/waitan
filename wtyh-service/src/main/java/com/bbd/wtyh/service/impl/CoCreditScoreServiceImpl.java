package com.bbd.wtyh.service.impl;

import com.bbd.shanghai.credit.utils.XyptWebServiceUtil;
import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.CompanyCreditDetailDO;
import com.bbd.wtyh.domain.CompanyCreditPointItemsDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.mapper.CompanyCreditDetailMapper;
import com.bbd.wtyh.mapper.CompanyCreditInformationMapper;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.service.CoCreditScoreService;
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
import org.springframework.util.CollectionUtils;

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
	private CompanyMapper companyMapper;
	@Autowired
	private CompanyCreditInformationMapper companyCreditInformationMapper;
	@Autowired
	private CompanyCreditDetailMapper companyCreditDetailMapper;

	private static final Logger LOGGER = LoggerFactory.getLogger(CoCreditScoreService.class);

	private static final int DAILY_LIMIT = 100000;// 10W

	@Override
	public void creditScoreCalculate() {
		int totalCount = this.getCompanyTotal();
		if (totalCount <= 0) {
			return;
		}

		// TODO 上海市信息中心，一般情况下每月10号前更新数据，但不保证10号肯定更新完。定时任务每月15日开始
		// TODO 上海市信息中心，支持24小时10万条记录
		final int pageSize = 10;
		// TODO int totalPage = (totalCount - 1) / pageSize + 1;
		int totalPage = 5;

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
		// TODO 补偿机制
	}

	/**
	 * 获取公司总数。<br>
	 * 上海市信息中心，支持24小时10万条记录。所以该方法来处理每天查询数量，如果超过10W，将只处理10W，剩下的后面再处理。
	 * 
	 * @return
	 */
	private int getCompanyTotal() {
		// TODO 取起始值
		// TODO 如果是定时任务开始日期，就认为是第一次开始，则置为0
		int startId = 0;

		int totalCount = this.companyMapper.countCompanyGTId(startId);

		if (totalCount <= DAILY_LIMIT) {
			return totalCount;
		}
		totalCount = DAILY_LIMIT;
		// 查出最后一条数据的ID，保存起来

		return DAILY_LIMIT;
	}

	/**
	 * 计算分值
	 * 
	 * @param companyName
	 *            公司名称
	 * @param pointMap
	 *            加分项
	 */
	private void calculateCompanyPoint(CompanyDO companyDO, Map<String, Integer> pointMap) {

		List<String> list = getCreditFromShangHai(companyDO.getName(), pointMap);

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
	 * @param companyName
	 * @param pointMap
	 */
	private List<String> getCreditFromShangHai(String companyName, Map<String, Integer> pointMap) {
		String xmlData = XyptWebServiceUtil.getCreditInfo(companyName, null, null);
		if (StringUtils.isBlank(xmlData)) {
			// TODO 错误信息记录
			return null;
		}

		Document document = null;
		try {
			document = DocumentHelper.parseText(xmlData);
		} catch (DocumentException e) {
			e.printStackTrace();
			// TODO 错误信息记录。返回数据格式错误
			return null;
		}

		Element root = document.getRootElement();
		String resultCode = root.elementText("RESULT");
		// 1005 表示查询成功
		if (!"1005".equals(resultCode)) {
			// TODO 错误信息记录
			return null;
		}

		List<String> pointNameList = new ArrayList<>();

		List nodes = root.elements("RESOURCE");
		for (Object node : nodes) {
			Element resource = (Element) node;
			// 信息事项名称
			String value = resource.attributeValue("RESOURCENAME");
			if (StringUtils.isBlank(value)) {
				continue;
			}
			value = value.trim();
			// 不保留不存在加分项的数据，减少数据集
			if (pointMap.get(value) == null || pointMap.get(value) <= 0) {
				continue;
			}
			pointNameList.add(value);
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
