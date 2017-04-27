package com.bbd.wtyh.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-04-27 13:37.
 */
public enum PrepaidCoRiskLevel {

	NORMAL(1, "正常"),
	LATENT(2, "潜在"),
	HAPPEN(3, "已发生");

	private int type;
	private String desc;

	PrepaidCoRiskLevel(int type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public static List<Map<String, Object>> getListMap() {
		PrepaidCoRiskLevel[] levels = PrepaidCoRiskLevel.values();
		List<Map<String, Object>> riskList = new ArrayList<>();
		for (PrepaidCoRiskLevel rl : levels) {
			Map<String, Object> map = new HashMap<>();
			map.put("type", rl.type());
			map.put("desc", rl.desc());
			riskList.add(map);
		}
		return riskList;
	}

	public int type() {
		return this.type;
	}

	public String desc() {
		return this.desc;
	}

}
