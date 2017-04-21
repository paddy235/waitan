package com.bbd.wtyh.constants;

/**
 * 公司风险变化来源
 *
 * @author Created by LiYao on 2017-04-19 17:57.
 */
public enum SourceType {

	SOURCE_REGISTER(1, "新注册"),
	SOURCE_FIND(2, "新发现"),
	SOURCE_MODIFY(3, "人工修改");

	private int type;
	private String desc;

	SourceType(int type, String desc) {
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
