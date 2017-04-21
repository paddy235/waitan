package com.bbd.wtyh.constants;

/**
 * 公司风险变化来源
 *
 * @author Created by LiYao on 2017-04-19 17:57.
 */
public enum ChangeType {

	CHANGE_NEW(1, "新增"),
	CHANGE_CLOSE(2, "停业");

	private int type;
	private String desc;

	ChangeType(int type, String desc) {
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
