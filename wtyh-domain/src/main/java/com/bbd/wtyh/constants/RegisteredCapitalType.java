package com.bbd.wtyh.constants;

import org.quartz.Trigger;

/**
 * 任务状态
 *
 * @author Created by LiYao on 2017-06-16 9:56.
 */
public enum RegisteredCapitalType {

	CNY(1, "人民币"),
	USD(2, "美元");

	private int type;
	private String desc;

	RegisteredCapitalType(int type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public Integer type() {
		return this.type;
	}

	public String desc() {
		return this.desc;
	}

	public static String desc(int type) {
		for (RegisteredCapitalType reg : RegisteredCapitalType.values()) {
			if (type == reg.type) {
				return reg.desc();
			}
		}
		return null;
	}
}
