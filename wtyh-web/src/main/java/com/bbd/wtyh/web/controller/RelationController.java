package com.bbd.wtyh.web.controller;


import com.bbd.wtyh.service.impl.relation.RegisterUniversalFilterChainImp;
import com.bbd.wtyh.service.impl.relation.RelationService;
import com.bbd.wtyh.service.impl.relation.SearchAPIandRelatedPartyService;
import com.bbd.wtyh.util.relation.StringUtils;
import com.bbd.wtyh.web.relationVO.AjaxVO;
import com.bbd.wtyh.web.relationVO.CompanyDataStatisticsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 关联方动态图谱控制器
 * 
 * @author Barney Lau
 *
 */
@Controller
public class RelationController {
	
	@Autowired
	private RegisterUniversalFilterChainImp registerUniversalFilterChainImp;
	@Autowired
	private RelationService relationService;
	@Autowired
	private SearchAPIandRelatedPartyService searchAPIandRelatedPartyService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/queryDynamicPicData")
	public @ResponseBody Map<String, List> queryDynamicPicData(HttpServletRequest request) {
		try {
			String companyName = request.getParameter("companyName");
			String dataVersion = request.getParameter("dataVersion");
			if (StringUtils.isNullOrEmpty(dataVersion)) {
				dataVersion = (String) request.getSession().getAttribute("defaultVersion");
			}
			return registerUniversalFilterChainImp.queryRelation(companyName, dataVersion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * 动态关联方 目标公司数据基本信息
	 *            目标公司名称
	 *            被查询公司名称
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping("relatedPartyStatistics")
	public @ResponseBody
	AjaxVO relatedPartyStatistics(HttpServletRequest request) throws Exception {
		String origCompanyName = request.getParameter("origCompanyName");
		String dataVersion = request.getParameter("dataVersion");
		String tarCompanyName = request.getParameter("tarCompanyName");
		if (StringUtils.isNullOrEmpty(dataVersion)) {
			dataVersion = (String) request.getSession().getAttribute("defaultVersion");
		}
		AjaxVO ajax = new AjaxVO();
		Map<String, List> map = registerUniversalFilterChainImp.queryRelation(origCompanyName, dataVersion);
		if (null != map) {
			CompanyDataStatisticsVO routeList = searchAPIandRelatedPartyService.relatedPartyStatistics(origCompanyName, tarCompanyName, map.get("lineList"));
			if (null != routeList) {
				ajax.setSuccess(1);
				ajax.setObj(routeList);
			} else {
				ajax.setSuccess(0);
			}
		} else {
			ajax.setSuccess(0);
		}
		return ajax;
	}

}
