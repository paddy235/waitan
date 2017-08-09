package com.bbd.wtyh.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bbd.wtyh.domain.recrut.CommonData;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.util.CalculateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.domain.PrepaidCompanyDO;
import com.bbd.wtyh.domain.PrepaidCompanyStatisticDO;
import com.bbd.wtyh.service.PrepaidCompanyStaticService;
import com.bbd.wtyh.web.HistogramBean;
import com.bbd.wtyh.web.PieChartBean;
import com.bbd.wtyh.web.ResponseBean;

/**
 * 预付卡controller
 *
 * @author Ian.Su
 * @since 2016年8月12日 上午9:51:25
 */
@Controller
@RequestMapping("/prepaid")
public class PrepaidCompanyController {
	private static final Logger logger = LoggerFactory.getLogger(PrepaidCompanyController.class);

	@Autowired
	private PrepaidCompanyStaticService pcsSer;

	/**
	 * 备案企业预付金额总额
	 *
	 * @return ResponseBean
	 */
	@RequestMapping("/amount")
	@ResponseBody
	@LogRecord(logMsg = "浏览预付卡页面", page = Operation.Page.prepaid)
	public ResponseBean amount() {

		HistogramBean<Integer, Double> bean = new HistogramBean<>();

		List<PrepaidCompanyStatisticDO> list = pcsSer.prepaidAll();

		if (CollectionUtils.isEmpty(list)) {
			return ResponseBean.successResponse(bean);
		}

		int amount = 0;

		for (PrepaidCompanyStatisticDO pcs : list) {
			bean.getxAxis().add(pcs.getYear());
			bean.getseries().add(CalculateUtils.divide((amount += pcs.getAmount()), 10000, 2));
		}

		return ResponseBean.successResponse(bean);

	}

	/**
	 * 备案企业行业类型，备案企业信息公告 综合接口
	 *
	 * @return ResponseBean
	 */
	@RequestMapping("/listAndPieChart")
	@ResponseBody
	public ResponseBean listAndPieChart() {

		Map<String, Object> returnMap = new HashMap<>();

		List<PrepaidCompanyDO> list = pcsSer.prepaidCompanyAll();

		PieChartBean<String, Integer> pie = new PieChartBean<>();
		pie.setTitle("备案企业行业类型");
		returnMap.put("pie", pie);
		returnMap.put("companys", list);

		if (CollectionUtils.isEmpty(list)) {
			return ResponseBean.successResponse(returnMap);
		}
		Map<String, Integer> pieMap = new TreeMap<>();
		for (PrepaidCompanyDO pcd : list) {
			if (pcd.getBusinessType() == null) {
				continue;
			}
			Integer btNum = pieMap.get(pcd.getBusinessType());
			if (btNum == null) {
				btNum = 1;
			} else {
				btNum++;
			}
			pieMap.put(pcd.getBusinessType(), btNum);
		}

		pie.getLegend().addAll(pieMap.keySet());
		pie.getSeries().addAll(pieMap.values());

		return ResponseBean.successResponse(returnMap);

	}

}
