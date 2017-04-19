package com.bbd.wtyh.constants;

/**
 * 风险等级
 *
 * @author Created by LiYao on 2017-04-19 17:46.
 */
public enum RiskLevel {
	RISK("已出风险", 1, "黑"),
	IMPORT_FOCUS("重点关注", 2, "红"),
	COMMON_FOCUS("一般关注", 3, "黄"),
	NORMAL("正常", 4, "绿");

	// 成员变量
	private String color;
	private String desc;
	private int type;

	/**
	 *
	 * @param desc
	 * @param type
	 */
	RiskLevel(String desc, int type, String color) {
		this.desc = desc;
		this.type = type;
		this.color = color;
	}

	public Integer type() {
		return this.type;
	}

	public String desc() {
		return this.desc;
	}

	public String color() {
		return this.color;
	}
}
