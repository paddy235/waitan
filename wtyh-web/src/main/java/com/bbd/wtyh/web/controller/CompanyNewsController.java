package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.CommercialFactoringStatisticDO;
import com.bbd.wtyh.domain.CompanyAndRiskDO;
import com.bbd.wtyh.service.CompanyNewsService;
import com.bbd.wtyh.service.FactoringService;
import com.bbd.wtyh.web.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
* 公司舆情
* @author tracy zhou
* @since  2016.8.12
*/
@RestController
@RequestMapping("/factoring")
public class CompanyNewsController {
	
	@Autowired
	private CompanyNewsService companyNewsService;

	@RequestMapping("/getCompanyNews")
	@ResponseBody
	public ResponseBean getCompanyNews() {
		List list = companyNewsService.getCompanyNews();
		return ResponseBean.successResponse(list);
	}
}
