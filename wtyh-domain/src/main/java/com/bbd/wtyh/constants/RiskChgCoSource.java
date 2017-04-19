package com.bbd.wtyh.constants;

/**
 * 公司风险变化来源
 *
 * @author Created by LiYao on 2017-04-19 17:57.
 */
public enum RiskChgCoSource {
	MANUAL_MODIFY(1, "手工修改"),
	MODEL_SCORE(2, "模型评分");

	private int type;
	private String desc;

	RiskChgCoSource(int type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public Integer type() {
		return this.type;
	}

	public String desc() {
		return this.desc;
	}
}
