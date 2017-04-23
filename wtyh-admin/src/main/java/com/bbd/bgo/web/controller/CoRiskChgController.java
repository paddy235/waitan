package com.bbd.bgo.web.controller;

import com.bbd.wtyh.constants.RiskChgCoSource;
import com.bbd.wtyh.constants.RiskLevel;
import com.bbd.wtyh.core.entity.Pagination;
import com.bbd.wtyh.core.utils.ParamUtil;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.RiskChgCoDo;
import com.bbd.wtyh.excel.ExportExcel;
import com.bbd.wtyh.exception.ExceptionHandler;
import com.bbd.wtyh.service.CoRiskChgService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企业变化监测-风险变化企业
 *
 * @author Created by LiYao on 2017-04-19 16:03.
 */
@Controller
@RequestMapping("/co-chg-monitor/co-risk-chg")
public class CoRiskChgController {

	@Autowired
	private CoRiskChgService coRiskChgService;

	/**
	 * 企业变化监测-风险变化企业-页面下拉列表数据
	 *
	 * @return
	 */
	@RequestMapping("/drop-down-data")
	@ResponseBody
	public Object riskChgCoDropDownData() {
		Map<String, Object> data = new HashMap<>();
		// 金融类型
		data.put("financialType", this.riskChgCoFinancialType());
		// 楼宇
		data.put("building", this.riskChgCoBuilding());
		// 风险等级
		data.put("riskLevel", this.riskChgCoRiskLevel());
		// 来源
		data.put("source", this.riskChgCoSource());

		return ResponseBean.successResponse(data);
	}

	/**
	 * 企业变化监测-风险变化企业-数据查询
	 * 
	 * @param sdate
	 *            开始时间
	 * @param edate
	 *            结束时间
	 * @param areaSet
	 *            区域ID集合，逗号分割
	 * @param financialType
	 *            金融类别
	 * @param buildId
	 *            楼宇ID
	 * @param riskLevel
	 *            风险等级
	 * @param source
	 *            来源
	 * @param statusSort
	 *            原始状态排序。DESC：降序，ASC：升序，DEFAULT：默认排序
	 * @param pageIndex
	 *            页码
	 * @param pageSize
	 *            每页大小，默认20
	 * @return
	 */
	@RequestMapping("/query-data")
	@ResponseBody
	public Object queryData(HttpServletRequest request, Pagination page) {

		Map<String, String> paramMap = ParamUtil.getRequestParamMap(request);

		this.coRiskChgService.queryPageData(paramMap, page);

		return ResponseBean.successResponse(page);
	}

	/**
	 * 下载风险变化企业数据
	 * 
	 * @param 同queryData()的方法
	 * @return
	 */
	@RequestMapping("/download-data")
	@ResponseBody
	public Object downloadData(HttpServletRequest request, boolean isPaging, Pagination page) {

		ExportExcel exportExcel = new ExportExcel("风险变化企业");
		List<RiskChgCoDo> list;

		try {
			Map<String, String> paramMap = ParamUtil.getRequestParamMap(request);

			if (isPaging) {
				list = this.coRiskChgService.queryPageData(paramMap, page);
			} else {
				list = this.coRiskChgService.queryAllData(paramMap);
			}

			exportExcel.createSheet(list);
			exportExcel.exportExcel();
		} catch (Exception e) {
			return ExceptionHandler.handlerException(e);
		}
		return ResponseBean.successResponse("/download/download-excel.do?name=" + exportExcel.getExcelName());
	}

	/**
	 * 企业变化监测-风险变化企业-新金融类别
	 * 
	 * @return
	 */
	private Object riskChgCoFinancialType() {
		byte[] typeNums = { CompanyDO.TYPE_P2P_1, CompanyDO.TYPE_XD_2, CompanyDO.TYPE_RZDB_3, CompanyDO.TYPE_XXLC_4, CompanyDO.TYPE_JYS_9,
				CompanyDO.TYPE_YFK_11, CompanyDO.TYPE_RZZL_13 };

		List<Map<String, Object>> typeList = new ArrayList<>();
		for (byte type : typeNums) {
			Map<String, Object> map = new HashMap<>();
			map.put("type", type);
			map.put("typeName", CompanyDO.companyTypeCN(type));
			typeList.add(map);
		}
		return typeList;
	}

	/**
	 * 企业变化监测-风险变化企业-楼宇
	 *
	 * @return
	 */

	private Object riskChgCoBuilding() {
		return this.coRiskChgService.riskChgCoBuilding();
	}

	/**
	 * 企业变化监测-风险变化企业-风险状态
	 *
	 * @return
	 */

	private Object riskChgCoRiskLevel() {
		RiskLevel[] risks = RiskLevel.values();
		List<Map<String, Object>> riskList = new ArrayList<>();
		for (RiskLevel rl : risks) {
			Map<String, Object> map = new HashMap<>();
			map.put("type", rl.type());
			map.put("color", rl.color());
			riskList.add(map);
		}
		return riskList;
	}

	/**
	 * 企业变化监测-风险变化企业-来源
	 *
	 * @return
	 */

	private Object riskChgCoSource() {
		RiskChgCoSource[] risks = RiskChgCoSource.values();
		List<Map<String, Object>> riskList = new ArrayList<>();
		for (RiskChgCoSource rl : risks) {
			Map<String, Object> map = new HashMap<>();
			map.put("type", rl.type());
			map.put("desc", rl.desc());
			riskList.add(map);
		}
		return riskList;
	}
}
