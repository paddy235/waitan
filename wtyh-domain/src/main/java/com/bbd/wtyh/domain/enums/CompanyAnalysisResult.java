package com.bbd.wtyh.domain.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企业监控状态
 * 
 * @author tracy zhou.
 */
public enum CompanyAnalysisResult {
	RISK("已出风险", 1, "黑"),
	IMPORT_FOCUS("重点关注", 2, "红"),
	COMMON_FOCUS("一般关注", 3, "黄"),
	NORMAL("正常", 4, "绿");

	// 成员变量
	private String color;
	private String name;
	private int type;

	/**
	 *
	 * @param name
	 * @param type
	 */
	private CompanyAnalysisResult(String name, int type, String color) {
		this.name = name;
		this.type = type;
		this.color = color;
	}

	/**
	 *
	 * @param type
	 * @return
	 */
	public static String getName(int type) {
		for (CompanyAnalysisResult c : CompanyAnalysisResult.values()) {
			if (c.getType() == type) {
				return c.name;
			}
		}
		return null;
	}

	/**
	 *
	 * @param name
	 * @return
	 */
	public static int getType(String name) {
		for (CompanyAnalysisResult c : CompanyAnalysisResult.values()) {
			if (name.trim().equals(c.getName())) {
				return c.type;
			}
		}
		return 0;
	}

	/**
	 *
	 * @param color
	 * @return
	 */
	public static String getColor(Integer type) {
		if (type == null) {
			return null;
		}
		for (CompanyAnalysisResult c : CompanyAnalysisResult.values()) {
			if (type.equals(c.type)) {
				return c.color;
			}
		}
		return null;
	}

	public static List<Map<String, Object>> getListMap() {
		List<Map<String, Object>> riskList = new ArrayList<>();
		CompanyAnalysisResult[] risks = CompanyAnalysisResult.values();
		Map<String, Object> map = new HashMap<>();
		map.put("type", 0);
		map.put("desc", "全部状态");
		riskList.add(map);
		for (CompanyAnalysisResult rl : risks) {
			map = new HashMap<>();
			map.put("type", rl.getType());
			map.put("desc", rl.getColor() + "灯");
			riskList.add(map);
		}
		return riskList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}