package com.bbd.wtyh.web.controller;

import java.io.InputStream;

import com.bbd.wtyh.report.util.DocxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.web.ResponseBean;

/**
 * word报告文档导出
 *  Created by cgj on 2017-5-25
 */
@Controller
@RequestMapping("/reportDocx/")
public class ReportDocxController {
	
	@Autowired
	private AreaService areaService;


	@RequestMapping(value = "t1.do")
	@ResponseBody
	public ResponseBean getAreaByParentId() {
		InputStream aa = DocxUtils.class.getResourceAsStream("/config/shanghai-company-anti-fraud-template.docx");
		byte [] te = new byte[100];
		try {
			int aar = aa.read(te);
			aar ++;
		} catch (Exception e) {}
		return ResponseBean.successResponse(null);
	}

}
