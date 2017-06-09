package com.bbd.bgo.web.controller;

import com.bbd.data.service.DataService;
import com.bbd.wtyh.domain.credit.CompanyCreditFailInfoDO;
import com.bbd.wtyh.service.CoCreditScoreService;
import com.bbd.wtyh.web.ResponseBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
	public String creditScoreCalculate() {
		coCreditScoreService.creditScoreCalculate();
		return "OK";
	}

	@RequestMapping("/end")
	@ResponseBody
	public String end() {
		coCreditScoreService.colseScoreCalculate();
		return "OK";
	}

	@RequestMapping("/start")
	@ResponseBody
	public String start() {
		coCreditScoreService.creditScoreCalculate();
		return "OK";
	}

	@RequestMapping("/executeFailCompany")
	@ResponseBody
	public String executeFailCompany(String companyName, String resultCode, String dataVersion, Integer pageNumber, Integer pageSize,
			HttpServletRequest request) {
		String[] companyNames = null;
		if (null != companyName && !companyName.equals("")) {
			companyNames = companyName.split(",");
		}
		coCreditScoreService.executefailCompany(companyNames, resultCode, dataVersion, pageNumber, pageSize);
		return "OK";
	}

	@RequestMapping("/queryFailCompany")
	@ResponseBody
	public ResponseBean queryFailCompany(String companyName, String resultCode, String dataVersion, Integer pageNumber, Integer pageSize,
			HttpServletRequest request) {
		Map data = new HashMap();
		String[] companyNames = null;
		if (null != companyName && !companyName.equals("")) {
			companyNames = companyName.split(",");
		}
		int total = coCreditScoreService.queryfailCompanyCounts(companyNames, resultCode, dataVersion, pageNumber, pageSize);
		List<CompanyCreditFailInfoDO> list = coCreditScoreService.queryfailCompany(companyNames, resultCode, dataVersion, pageNumber,
				pageSize);
		data.put("total", total);
		data.put("list", list);
		return ResponseBean.successResponse(data);
	}
}
