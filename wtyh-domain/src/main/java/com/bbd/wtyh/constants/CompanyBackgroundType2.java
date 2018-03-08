package com.bbd.wtyh.constants;

/**
 * 企业背景修改
 *
 * @author Created by werry on 2018-01-29 9:56.
 */
public enum CompanyBackgroundType2 {


	STATE_OWNEED(1, "国有企业"),
	FOREIGN(2, "民营企业"),
	PRIVATE(3, "外资企业");

	private int type;
	private String desc;

	CompanyBackgroundType2(int type, String desc) {
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
		for (CompanyBackgroundType2 reg : CompanyBackgroundType2.values()) {
			if (type == reg.type) {
				return reg.desc();
			}
		}
		return null;
	}

	public static CompanyBackgroundType2 getByValue(String value) {
		for (CompanyBackgroundType2 reg : CompanyBackgroundType2.values()) {
			if (value.equals(reg.desc)) {
				return reg;
			}
		}
		return null;
	}
}
