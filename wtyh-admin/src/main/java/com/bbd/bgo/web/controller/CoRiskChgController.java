package com.bbd.bgo.web.controller;

import com.bbd.wtyh.constants.RiskChgCoSource;
import com.bbd.wtyh.constants.RiskLevel;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.service.CoRiskChgService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

		data.put("financialType", this.riskChgCoFinancialType());
		data.put("building", this.riskChgCoBuilding());
		data.put("riskLevel", this.riskChgCoRiskLevel());
		data.put("source", this.riskChgCoSource());

		return ResponseBean.successResponse(data);
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
		List<Map<String, Object>> buildList = this.coRiskChgService.riskChgCoBuilding();
		return buildList;
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
