package com.bbd.wtyh.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bbd.wtyh.domain.SysAnalyzeDO;
import com.bbd.wtyh.service.SysAnalyzeService;

@Controller
public class IndexController {
	
	@Autowired
	private SysAnalyzeService sysAnalyzeService;
	
	@RequestMapping(value = "/getSysAnalyze")
	@ResponseBody
	public String getSysAnalyze() {
		SysAnalyzeDO sysAnalyzeDO = sysAnalyzeService.getSysAnalyze();
		return JSONObject.toJSONString(sysAnalyzeDO);
	}

}
