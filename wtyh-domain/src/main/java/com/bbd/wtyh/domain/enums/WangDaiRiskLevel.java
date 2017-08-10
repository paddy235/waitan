package com.bbd.wtyh.domain.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 公司风险变化来源
 *
 * @author Created by sun on 2017-8-10 .
 */
public enum WangDaiRiskLevel {

	RISK(1,"问题及停业平台","D"),
	IMPORT_FOCUS(2,"重点关注","C"),
	COMMON_FOCUS(3,"一般关注","B"),
	NORMAL(4,"优良","A");

	private int type;
	private String desc;
	private String score;

	WangDaiRiskLevel(int type, String desc,String score) {
		this.type = type;
		this.desc = desc;
		this.score = score;
	}

	public Integer type() {
		return this.type;
	}

	public String desc() {
		return this.desc;
	}

	public String score() {
		return this.score;
	}

	public static Map<String, Integer> getMap() {
		Map<String, Integer> rst = new HashMap();
		for (WangDaiRiskLevel wangDaiRiskLevel : WangDaiRiskLevel.values()) {
			rst.put(wangDaiRiskLevel.desc,wangDaiRiskLevel.type());
		}
		return rst;
	}

	public static String getRiskDesc(int type) {
		for (WangDaiRiskLevel wangDaiRiskLevel : WangDaiRiskLevel.values()) {
			if (type == wangDaiRiskLevel.type) {
				return wangDaiRiskLevel.desc();
			}
		}
		return null;
	}

	public static String getRiskScore(int type) {
		for (WangDaiRiskLevel wangDaiRiskLevel : WangDaiRiskLevel.values()) {
			if (type == wangDaiRiskLevel.type) {
				return wangDaiRiskLevel.score();
			}
		}
		return null;
	}
}
