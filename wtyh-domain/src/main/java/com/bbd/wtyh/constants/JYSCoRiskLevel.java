package com.bbd.wtyh.constants;

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

	JYSCoRiskLevel() {
	};

	public static List<Map<String, Object>> getListMap() {
		List<Map<String, Object>> riskList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("type", 1);
		map.put("desc", "已出风险");
		riskList.add(map);
		map = new HashMap<>();
		map.put("type", 2);
		map.put("desc", "正常");
		riskList.add(map);
		return riskList;
	}
}
