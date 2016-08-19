package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.service.CompanyNewsService;
import com.bbd.wtyh.web.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* 公司舆情
* @author tracy zhou
* @since  2016.8.12
*/
@RestController
@RequestMapping("/companyNews")
public class CompanyNewsController {
	
	@Autowired
	private CompanyNewsService companyNewsService;

	@RequestMapping("getCompanyNews.do")
	@ResponseBody
	public ResponseBean getCompanyNews() {
		String companyName = "贵阳市城市建设投资有限责任公司";
		List list = companyNewsService.getCompanyNews(companyName);
		return ResponseBean.successResponse(list);
	}
}
