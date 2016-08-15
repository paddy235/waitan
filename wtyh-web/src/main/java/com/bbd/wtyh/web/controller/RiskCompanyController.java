package com.bbd.wtyh.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.RiskCompanyService;
import com.bbd.wtyh.web.ResponseBean;

@Controller
@RequestMapping(value = "/risk")
public class RiskCompanyController {

	@Autowired
	private RiskCompanyService riskCompanyService;
	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/getScanner")
	@ResponseBody
	public ResponseBean getScanner(@RequestParam(required = false) String area,
			@RequestParam(required = false) String minRegCapital, @RequestParam(required = false) String maxRegCapital,
			@RequestParam(required = false) String companyQualification,
			@RequestParam(required = false) String minReviewTime,
			@RequestParam(required = false) String maxReviewTime) {
		Map<String, Object> params = this.fillMap(area, minRegCapital, maxRegCapital, companyQualification,
				minReviewTime, maxReviewTime, null);
		return ResponseBean.successResponse(riskCompanyService.getScanner(params));
	}

	@RequestMapping(value = "/getTop")
	@ResponseBody
	public ResponseBean getTop(@RequestParam(required = false) String area,
			@RequestParam(required = false) String minRegCapital, @RequestParam(required = false) String maxRegCapital,
			@RequestParam(required = false) String companyQualification,
			@RequestParam(required = false) String minReviewTime, @RequestParam(required = false) String maxReviewTime,
			@RequestParam(defaultValue = "0") String sortType) {
		Map<String, Object> params = this.fillMap(area, minRegCapital, maxRegCapital, companyQualification,
				minReviewTime, maxReviewTime, sortType);
		return ResponseBean.successResponse(riskCompanyService.getTop(params));
	}

	private Map<String, Object> fillMap(String area, String minRegCapital, String maxRegCapital,
			String companyQualification, String minReviewTime, String maxReviewTime, String sortType) {
		Map<String, Object> map = new HashMap<>();
		map.put("area", area);
		map.put("minRegCapital", minRegCapital);
		map.put("maxRegCapital", maxRegCapital);
		map.put("companyQualification", companyQualification);
		map.put("minReviewTime", minReviewTime);
		map.put("maxReviewTime", maxReviewTime);
		map.put("sortType", sortType);
		return map;
	}
	
	@RequestMapping(value = "/doSearch")
	@ResponseBody
	public ResponseBean doSearch(@RequestParam(required = false) String keyword, @RequestParam int pageNo) {
		int count = companyService.searchCompanyNameCount(keyword);
		Pagination pagination = new Pagination();
		pagination.setCount(count >= 201 ? 200 : count); // 搜索结果最多保留200条数据
		if (pageNo >= 21) {
			pagination.setList(null);
			return ResponseBean.errorResponse("错误的分页请求参数！");
		}
		pagination.setPageNumber(pageNo);
		Map<String, Object> params = new HashMap<>();
		params.put("keyword", keyword);
		params.put("pagination", pagination);
		List<String> nameList = companyService.searchCompanyName(params);
		pagination.setList(nameList);
		return ResponseBean.successResponse(pagination);
	}

}
