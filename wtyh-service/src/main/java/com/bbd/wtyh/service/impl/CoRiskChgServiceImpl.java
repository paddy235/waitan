package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.core.entity.Pagination;
import com.bbd.wtyh.domain.RiskChgCoDo;
import com.bbd.wtyh.mapper.CoRiskChgMapper;
import com.bbd.wtyh.service.CoRiskChgService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;

/**
 * 企业变化监测-风险变化企业
 *
 * @author Created by LiYao on 2017-04-19 16:45.
 */
@Service
public class CoRiskChgServiceImpl extends BaseServiceImpl implements CoRiskChgService {

	@Autowired
	private CoRiskChgMapper coRiskChgMapper;

	@Override
	public List<Map<String, Object>> riskChgCoBuilding() {

		return this.coRiskChgMapper.riskChgCoBuilding();
	}

	@Override
	public List<RiskChgCoDo> queryPageData(Map<String, String> paramMap, Pagination page) {

		String where = this.generateDynamicWhere(paramMap);

		List<RiskChgCoDo> list = this.selectByPage(RiskChgCoDo.class, page, where);
		page.setList(list);
		return list;

	}

	@Override
	public List<RiskChgCoDo> queryAllData(Map<String, String> paramMap) {
		String where = this.generateDynamicWhere(paramMap);
		return this.selectAll(RiskChgCoDo.class, where);

	}

	/**
	 * 生产动态where语句
	 * 
	 * @param paramMap
	 * @return
	 */
	private String generateDynamicWhere(Map<String, String> paramMap) {
		StringBuilder dynamicWhere = new StringBuilder("1 = 1");

		// 金融类型 financialType
		String financialType = paramMap.get("financialType");
		if (StringUtils.isNotBlank(financialType)) {
			dynamicWhere.append(" AND company_type = ").append(financialType);
		}

		// 楼宇 buildId
		String buildId = paramMap.get("buildId");
		if (StringUtils.isNotBlank(buildId)) {
			dynamicWhere.append(" AND building_id = ").append(buildId);
		}

		// 风险等级 riskLevel
		String riskLevel = paramMap.get("riskLevel");
		if (StringUtils.isNotBlank(riskLevel)) {
			dynamicWhere.append(" AND risk_level = ").append(riskLevel);
		}

		// 来源 source
		String source = paramMap.get("source");
		if (StringUtils.isNotBlank(source)) {
			dynamicWhere.append(" AND source = ").append(source);
		}

		// 开始时间 sdate
		String sdate = paramMap.get("sdate");
		if (StringUtils.isNotBlank(sdate)) {
			sdate = sdate + "-01";
			dynamicWhere.append(" AND change_date >= DATE('").append(sdate).append("')");
		}

		// 结束时间 edate
		String edate = paramMap.get("edate");
		if (StringUtils.isNotBlank(edate)) {
			edate = LocalDate.parse(edate + "-01").with(TemporalAdjusters.lastDayOfMonth()).toString();
			dynamicWhere.append(" AND change_date <= DATE('").append(edate).append("')");
		}

		// 选择区域 areaSet
		String areaSet = paramMap.get("areaSet");
		if (StringUtils.isNotBlank(areaSet) && !"0".equals(areaSet)) {
			dynamicWhere.append(" AND area_id IN (").append(areaSet).append(") ");
		}

		// 排序
		String statusSort = paramMap.get("statusSort");
		if (StringUtils.isNotBlank(statusSort) && !"DEFAULT".equals(statusSort)) {
			dynamicWhere.append(" ORDER BY old_risk_level ").append(statusSort);
		} else {
			dynamicWhere.append(" ORDER BY change_date DESC");
		}

		return dynamicWhere.toString();
	}
}
