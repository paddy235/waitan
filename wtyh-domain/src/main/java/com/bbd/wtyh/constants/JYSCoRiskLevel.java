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

	NORMAL(1, "正常"),
	HAVE(2, "已出风险");

	private int type;
	private String desc;

	JYSCoRiskLevel(int type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public int type() {
		return this.type;
	}

	public String desc() {
		return this.desc;
	}

	public static JYSCoRiskLevel getRiskLevel(Integer level) {
		if (level == null) {
			return JYSCoRiskLevel.NORMAL;
		}
		if (level.equals(JYSCoRiskLevel.HAVE.type)) {
			return JYSCoRiskLevel.HAVE;
		}
		return JYSCoRiskLevel.NORMAL;
	}

	public static List<Map<String, Object>> getListMap() {
		JYSCoRiskLevel[] levels = JYSCoRiskLevel.values();
		List<Map<String, Object>> riskList = new ArrayList<>();
		for (JYSCoRiskLevel rl : levels) {
			Map<String, Object> map = new HashMap<>();
			map.put("type", rl.type());
			map.put("desc", rl.desc());
			riskList.add(map);
		}
		return riskList;
	}
}
