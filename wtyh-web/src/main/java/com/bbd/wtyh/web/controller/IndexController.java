package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.domain.SysAnalyzeDO;
import com.bbd.wtyh.service.SysAnalyzeService;
import com.bbd.wtyh.web.ResponseBean;

@Controller
public class IndexController {

	@Autowired
	private SysAnalyzeService sysAnalyzeService;

	@Autowired
	private CompanyService comSer;

	@RequestMapping(value = "/getSysAnalyze")
	@ResponseBody
	@LogRecord(logMsg = "浏览首页", page = Operation.Page.home, type = Operation.Type.browse)
	public ResponseBean getSysAnalyze() {
		SysAnalyzeDO sysAnalyzeDO = sysAnalyzeService.getSysAnalyze();
		return ResponseBean.successResponse(sysAnalyzeDO);
	}

	@RequestMapping(value = "/areaCount")
	@ResponseBody
	public ResponseBean areaCount() {
		Object r = comSer.countCompanyNum();
		return ResponseBean.successResponse(r);
	}

}
