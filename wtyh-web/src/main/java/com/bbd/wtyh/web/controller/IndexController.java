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

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

	@Autowired
	private SysAnalyzeService sysAnalyzeService;

	@Autowired
	private CompanyService comSer;

	@RequestMapping(value = "/getSysAnalyze")
	@ResponseBody
	@LogRecord(logMsg = "浏览平台首页", page = Operation.Page.home, type = Operation.Type.browse)
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

	@RequestMapping(value = "/index-roll-tip")
	@ResponseBody
	public ResponseBean indexRollTip() {
		Map<String, Object> map = new HashMap<>();
		map.put("tips", new String[] { "仅供工作参考，不作行政执法依据", "严禁泄漏或非法使用平台数据" });
		return ResponseBean.successResponse(map);
	}

}
