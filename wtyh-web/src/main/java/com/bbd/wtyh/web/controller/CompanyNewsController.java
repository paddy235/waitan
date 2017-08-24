package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.vo.NewsVO;
import com.bbd.wtyh.service.CompanyNewsService;
import com.bbd.wtyh.web.*;
import com.google.gson.Gson;
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

		NewsVO vo = companyNewsService.mutilTypeNews("qyxg_weiyangwang," +
				                                     "qyxg_shanghai_finance," +
				                                     "qyxg_chinesefinance," +
				                                     "qyxg_financial_times," +
				                                     "qyxg_sinafinance," +
				                                     "qyxg_national_economy",20);

		Gson gson = new Gson();

		return ResponseBean.successResponse(gson.toJson(vo));

	}
}
