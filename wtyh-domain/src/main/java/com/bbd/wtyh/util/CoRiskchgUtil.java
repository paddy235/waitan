package com.bbd.wtyh.util;

import com.bbd.wtyh.constants.JYSCoRiskLevel;
import com.bbd.wtyh.constants.RZZLCoRiskLevel;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.PrepaidCompanyDO;
import com.bbd.wtyh.domain.RiskChgCoDo;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.domain.enums.CompanyLevel;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-04-26 11:27.
 */
public class CoRiskchgUtil {

	public static String[] exportName(Integer type) {
		if (type == null) {
			return null;
		}
		switch (type.byteValue()) {

		case CompanyDO.TYPE_P2P_1:// 网络借贷
		case CompanyDO.TYPE_XXLC_4:// 线下理财
			return new String[] { "企业名称", "新金融类别", "所在区域", "所在楼宇", "风险状态", "原始状态", "来源" };

		case CompanyDO.TYPE_XD_2:// 小额贷款
		case CompanyDO.TYPE_RZDB_3:// 融资担保
			return new String[] { "企业名称", "新金融类别", "所在区域", "所在楼宇", "风险评级", "风险状态", "原始状态", "来源" };

		case CompanyDO.TYPE_JYS_9:// 交易所
			return new String[] { "企业名称", "新金融类别", "所在区域", "所在楼宇", "风险状态", "原始状态", "来源" };

		case CompanyDO.TYPE_RZZL_13:// 融资租赁
			return new String[] { "企业名称", "新金融类别", "所在区域", "所在楼宇", "风险状态", "原始状态", "来源" };

		case CompanyDO.TYPE_YFK_11:// 预付卡
			return new String[] { "企业名称", "新金融类别", "所在区域", "所在楼宇", "风险状态", "原始状态", "来源" };
		default:
			return null;
		}
	}

	public static String[] exportKey(Integer type) {
		if (type == null) {
			return null;
		}
		switch (type.byteValue()) {

		case CompanyDO.TYPE_P2P_1:// 网络借贷
		case CompanyDO.TYPE_XXLC_4:// 线下理财
			return new String[] { "companyName", "disCompanyType", "areaName", "buildingName", "disRiskLevel", "disOldRiskLevel",
					"disSource" };

		case CompanyDO.TYPE_XD_2:// 小额贷款
		case CompanyDO.TYPE_RZDB_3:// 融资担保
			return new String[] { "companyName", "disCompanyType", "areaName", "buildingName", "disRiskRating", "disRiskLevel",
					"disOldRiskLevel", "disSource" };

		case CompanyDO.TYPE_JYS_9:// 交易所
			return new String[] { "companyName", "disCompanyType", "areaName", "buildingName", "disRiskLevel", "disOldRiskLevel",
					"disSource" };

		case CompanyDO.TYPE_RZZL_13:// 融资租赁
			return new String[] { "companyName", "disCompanyType", "areaName", "buildingName", "disRiskLevel", "disOldRiskLevel",
					"disSource" };
		case CompanyDO.TYPE_YFK_11:// 预付卡
			return new String[] { "companyName", "disCompanyType", "areaName", "buildingName", "disRiskLevel", "disOldRiskLevel",
					"disSource" };
		default:
			return null;
		}
	}

	/**
	 * 风险评级
	 * 
	 * @param riskChgCoDo
	 * @return
	 */
	public static String getRiskRating(Integer companyType, Integer innerLevel, Integer outLevel, Integer liveLevel) {
		if (companyType == null) {
			return null;
		}
		byte type = companyType.byteValue();
		// 小额贷款 和 融资担保 才有该评级
		if (CompanyDO.TYPE_XD_2 != type && CompanyDO.TYPE_RZDB_3 != type) {
			return null;
		}

		List<String> list = new ArrayList<>();

		if (innerLevel != null) {
			list.add("内部评级");
		} else {
			list.add("--");
		}
		if (outLevel != null) {
			list.add("外部评级");
		} else {
			list.add("--");
		}
		if (liveLevel != null) {
			list.add("现场检查");
		} else {
			list.add("--");
		}
		return StringUtils.join(list, "/");
	}

	/**
	 * 风险状态
	 *
	 * @return
	 */
	public static String getDisRiskLevel(Integer companyType, Integer innerLevel, Integer outLevel, Integer liveLevel) {
		if (companyType == null) {
			return null;
		}
		byte type = companyType.byteValue();
		// 小额贷款 和 融资担保 才有该评级
		if (CompanyDO.TYPE_XD_2 != type && CompanyDO.TYPE_RZDB_3 != type) {
			return null;
		}
		List<String> list = new ArrayList<>();
		if (innerLevel != null) {
			list.add(CompanyLevel.getByOrdinal(innerLevel).getValue());
		} else {
			list.add("--");
		}
		if (outLevel != null) {
			list.add(CompanyLevel.getByOrdinal(outLevel).getValue());
		} else {
			list.add("--");
		}
		if (liveLevel != null) {
			list.add(CompanyLevel.getByOrdinal(liveLevel).getValue());
		} else {
			list.add("--");
		}

		return StringUtils.join(list, "/");
	}

	/**
	 * 风险状态
	 * 
	 * @return
	 */
	public static String getDisRiskLevel(Integer companyType, Integer riskLevel, boolean haveRisk) {
		if (companyType == null) {
			return null;
		}
		byte type = companyType.byteValue();

		switch (type) {

		case CompanyDO.TYPE_P2P_1:// 网络借贷
		case CompanyDO.TYPE_XXLC_4:// 线下理财
			return CompanyAnalysisResult.getColor(riskLevel) + "灯";

		case CompanyDO.TYPE_JYS_9:// 交易所
			return JYSCoRiskLevel.getRiskLevel(riskLevel).desc();

		case CompanyDO.TYPE_RZZL_13:// 融资租赁
			return haveRisk ? RZZLCoRiskLevel.LATENT.desc() : RZZLCoRiskLevel.NORMAL.desc();

		case CompanyDO.TYPE_YFK_11:// 预付卡
			if (riskLevel == null) {
				return null;
			}
			return PrepaidCompanyDO.getAnalysisResultCN(riskLevel.byteValue());
		default:
			return null;
		}
	}

}
