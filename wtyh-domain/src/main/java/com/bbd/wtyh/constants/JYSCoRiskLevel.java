package com.bbd.wtyh.constants;

import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交易场所风险等级
 *
 * @author Created by LiYao on 2017-04-27 10:52.
 */
public enum JYSCoRiskLevel {

	JYSCoRiskLevel(){};
	
	public static List<Map<String, Object>> getListMap() {
		CompanyAnalysisResult[] levels = CompanyAnalysisResult.values();
		List<Map<String, Object>> riskList = new ArrayList<>();
		for (CompanyAnalysisResult rl : levels) {
			Map<String, Object> map = new HashMap<>();
			map.put("type", rl.getType());
			map.put("desc", rl.getName());
			riskList.add(map);
		}
		return riskList;
	}
}
