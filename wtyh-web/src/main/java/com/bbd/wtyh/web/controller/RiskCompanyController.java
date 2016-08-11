package com.bbd.wtyh.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.service.RiskCompanyService;
import com.bbd.wtyh.web.ResponseBean;

@Controller
@RequestMapping(value = "/risk")
public class RiskCompanyController {
	
	@Autowired
	private RiskCompanyService riskCompanyService;
	
	@RequestMapping(value = "/getScanner")
	@ResponseBody
	public ResponseBean getScanner(@RequestParam(required=false) String area, @RequestParam(required=false) String minRegCapital, 
			@RequestParam(required=false) String maxRegCapital, @RequestParam(required=false) String companyQualification, 
			@RequestParam(required=false) String minReviewTime, @RequestParam(required=false) String maxReviewTime) {
		Map<String, Object> params = this.fillMap(area, minRegCapital, maxRegCapital, companyQualification, minReviewTime, maxReviewTime);
		return ResponseBean.successResponse(riskCompanyService.getScanner(params));
	}
	
	@RequestMapping(value = "/getScannerCount")
	@ResponseBody
	public ResponseBean getScannerCount(@RequestParam(required=false) String area, @RequestParam(required=false) String minRegCapital, 
			@RequestParam(required=false) String maxRegCapital, @RequestParam(required=false) String companyQualification, 
			@RequestParam(required=false) String minReviewTime, @RequestParam(required=false) String maxReviewTime) {
		Map<String, Object> params = this.fillMap(area, minRegCapital, maxRegCapital, companyQualification, minReviewTime, maxReviewTime);
		return ResponseBean.successResponse(riskCompanyService.getScannerCount(params));
	}
	
	private Map<String, Object> fillMap(String area, String minRegCapital, 
			String maxRegCapital, String companyQualification, 
			String minReviewTime, String maxReviewTime) {
		Map<String, Object> map = new HashMap<>();
		map.put("area", area);
		map.put("minRegCapital", minRegCapital);
		map.put("maxRegCapital", maxRegCapital);
		map.put("companyQualification", companyQualification);
		map.put("minReviewTime", minReviewTime);
		map.put("maxReviewTime", maxReviewTime);
		return map;
	}

}
