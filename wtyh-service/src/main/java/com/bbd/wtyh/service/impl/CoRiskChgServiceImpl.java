package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.constants.JYSCoRiskLevel;
import com.bbd.wtyh.constants.PrepaidCoRiskLevel;
import com.bbd.wtyh.constants.RZZLCoRiskLevel;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.core.entity.Pagination;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.PrepaidCompanyDO;
import com.bbd.wtyh.domain.RiskChgCoDo;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.exception.BusinessException;
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
	public List<Map<String, Object>> riskChgCoBuilding(String areaSet) {

		return this.coRiskChgMapper.riskChgCoBuilding(areaSet);
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

		// 金融类型 financialType
		String financialType = paramMap.get("financialType");

		if (StringUtils.isBlank(financialType)) {
			throw new BusinessException("公司类型不能为空。");
		}

		Integer companyType = Integer.parseInt(financialType);

		StringBuilder dynamicWhere = new StringBuilder();
		dynamicWhere.append("company_type = ").append(companyType);

		// 楼宇 buildId
		String buildId = paramMap.get("buildId");
		if (StringUtils.isNotBlank(buildId)) {
			dynamicWhere.append(" AND building_id = ").append(buildId);
		}

		// 风险等级 riskLevel
		String riskLevel = paramMap.get("riskLevel");
		this.setDynamicRiskWhere(dynamicWhere, companyType, riskLevel);

		// 来源 source
		String source = paramMap.get("source");
		if (StringUtils.isNotBlank(source)) {
			dynamicWhere.append(" AND source = ").append(source);
		}

		// 开始时间 sdate
		String sdate = paramMap.get("sdate");
		if (StringUtils.isNotBlank(sdate)) {
			sdate = sdate + "-01";
			dynamicWhere.append(" AND change_date >= TIMESTAMP('").append(sdate).append(" 00:00:00')");
		}

		// 结束时间 edate
		String edate = paramMap.get("edate");
		if (StringUtils.isNotBlank(edate)) {
			edate = LocalDate.parse(edate + "-01").with(TemporalAdjusters.lastDayOfMonth()).toString();
			dynamicWhere.append(" AND change_date <= TIMESTAMP('").append(edate).append(" 23:59:59')");
		}

		// 选择区域 areaSet
		String areaSet = paramMap.get("areaSet");
		if (StringUtils.isNotBlank(areaSet) && !"0".equals(areaSet)) {
			dynamicWhere.append(" AND area_id IN (").append(areaSet).append(") ");
		}

		// 排序
		String statusSort = paramMap.get("statusSort");
		if (StringUtils.isNotBlank(statusSort) && !"DEFAULT".equals(statusSort)) {
			// 融资租赁 需要按照 old_have_risk 排序
			if (CompanyDO.TYPE_RZZL_13 == companyType.byteValue()) {
				dynamicWhere.append(" ORDER BY old_have_risk ").append(statusSort);
			} else {
				dynamicWhere.append(" ORDER BY old_risk_level ").append(statusSort);
			}
		} else {
			dynamicWhere.append(" ORDER BY change_date DESC");
		}

		return dynamicWhere.toString();
	}

	private void setDynamicRiskWhere(StringBuilder dynamicWhere, Integer companyType, String riskLevel) {
		if (StringUtils.isBlank(riskLevel)) {
			return;
		}

		Integer level = Integer.parseInt(riskLevel);

		byte type = companyType.byteValue();

		switch (type) {

		case CompanyDO.TYPE_P2P_1:// 网络借贷
		case CompanyDO.TYPE_XXLC_4:// 线下理财
			dynamicWhere.append(" AND risk_level = ").append(riskLevel);
			break;

		case CompanyDO.TYPE_JYS_9:// 交易所
			if (level.equals(JYSCoRiskLevel.NORMAL.type())) {
				dynamicWhere.append(" AND risk_level = ").append(JYSCoRiskLevel.NORMAL.type());
			}
			if (level.equals(JYSCoRiskLevel.HAVE.type())) {
				dynamicWhere.append(" AND ").append(JYSCoRiskLevel.NORMAL.type()).append(" != risk_level");
			}
			break;

		case CompanyDO.TYPE_RZZL_13:// 融资租赁
			if (level.equals(RZZLCoRiskLevel.NORMAL.type())) {
				dynamicWhere.append(" AND have_risk = 0");
			}
			if (level.equals(RZZLCoRiskLevel.LATENT.type())) {
				dynamicWhere.append(" AND have_risk = 1");
			}
			break;

		case CompanyDO.TYPE_YFK_11:// 预付卡
			if (level.equals(PrepaidCoRiskLevel.NORMAL.type())) {
				dynamicWhere.append(" AND ").append(CompanyAnalysisResult.IMPORT_FOCUS.getType()).append(" != risk_level");
				dynamicWhere.append(" AND ").append(CompanyAnalysisResult.COMMON_FOCUS.getType()).append(" != risk_level");
			}
			if (level.equals(PrepaidCoRiskLevel.LATENT.type())) {
				dynamicWhere.append(" AND risk_level = ").append(CompanyAnalysisResult.COMMON_FOCUS.getType());
			}
			if (level.equals(PrepaidCoRiskLevel.HAPPEN.type())) {
				dynamicWhere.append(" AND risk_level = ").append(CompanyAnalysisResult.IMPORT_FOCUS.getType());
			}
			break;
		}
	}

}
