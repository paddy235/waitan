package com.bbd.bgo.web.controller;

import com.bbd.data.service.DataService;
import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;
import com.bbd.wtyh.domain.credit.CompanyCreditFailInfoDO;
import com.bbd.wtyh.mapper.TaskSuccessFailInfoMapper;
import com.bbd.wtyh.service.CoCreditScoreService;
import com.bbd.wtyh.web.ResponseBean;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by suyin on 2016/8/27.
 */
@Controller
@RequestMapping("/credit")
public class CreditController {

	@Autowired
	private DataService dataService;
	@Autowired
	private TaskSuccessFailInfoMapper taskSuccessFailInfoMapper;

	private static String TASK_NAME = "shangHaiCreditJob";
	private static String TASK_GROUP = "credit_work";

	@RequestMapping("/info")
	public String info(String companyName, HttpServletRequest request) {

		if (StringUtils.hasText(companyName)) {
			request.setAttribute("list", dataService.getCredit(companyName));
		}

		return "geo/credit";
	}

	@Autowired
	private CoCreditScoreService coCreditScoreService;

	@RequestMapping("/credit-score-calculate")
	@ResponseBody
	public ResponseBean creditScoreCalculate() {
		Map data = new HashMap();
		coCreditScoreService.creditScoreCalculate(1);
		return ResponseBean.successResponse(data);
	}

	@RequestMapping("/task-progress")
	@ResponseBody
	public ResponseBean taskProgress() {
		Map data = new HashMap();
		String dataVersion = DateFormatUtils.format(new Date(), "yyyyMMdd");
		TaskSuccessFailInfoDO taskSuccessFailInfoDO = taskSuccessFailInfoMapper.getTaskSuccessFailInfo(TASK_NAME, TASK_GROUP, dataVersion);
		int planCount = taskSuccessFailInfoDO.getPlanCount();
		int successCount = taskSuccessFailInfoDO.getSuccessCount();
		int failCount = taskSuccessFailInfoDO.getFailCount();

		data.put("planCount", planCount);
		data.put("successCount", successCount);
		data.put("failCount", failCount);

		return ResponseBean.successResponse(data);
	}

	@RequestMapping("/executeFailCompany")
	@ResponseBody
	public String executeFailCompany(String companyName, String resultCode, Integer taskId, Integer pageNumber, Integer pageSize,
			HttpServletRequest request) {
		String[] companyNames = null;
		if (null != companyName && !companyName.equals("")) {
			companyNames = companyName.split(",");
		}
		coCreditScoreService.executefailCompany(companyNames, resultCode, taskId, pageNumber, pageSize);
		return "OK";
	}

	@RequestMapping("/queryFailCompany")
	@ResponseBody
	public ResponseBean queryFailCompany(String companyName, String resultCode, Integer taskId, Integer pageNumber, Integer pageSize,
			HttpServletRequest request) {
		Map data = new HashMap();
		String[] companyNames = null;
		if (null != companyName && !companyName.equals("")) {
			companyNames = companyName.split(",");
		}
		int total = coCreditScoreService.queryfailCompanyCounts(companyNames, resultCode, taskId, pageNumber, pageSize);
		List<CompanyCreditFailInfoDO> list = coCreditScoreService.queryfailCompany(companyNames, resultCode, taskId, pageNumber,
				pageSize);
		data.put("total", total);
		data.put("list", list);
		return ResponseBean.successResponse(data);
	}
}
