package com.bbd.wtyh.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.service.RiskCompanyService;
import com.bbd.wtyh.web.ResponseBean;

@Controller
@RequestMapping(value = "/riskCompany")
public class RiskCompanyController {
	
	@Autowired
	private RiskCompanyService riskCompanyService;
	
	@RequestMapping(value = "/getScanner")
	@ResponseBody
	public ResponseBean getScanner() {
		Map<String, Object> params = new HashMap<>();
		return ResponseBean.successResponse(riskCompanyService.getScanner(params));
	}

}
