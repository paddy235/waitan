package com.bbd.wtyh.constants;

/**
 * 企业背景
 *
 * @author Created by werry on 2018-01-29 9:56.
 */
public enum CompanyBackgroundType {


	STATE_OWNEED(1, "国企"),
	FOREIGN(2, "外企"),
	PRIVATE(3, "民企");

	private int type;
	private String desc;

	CompanyBackgroundType(int type, String desc) {
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
		for (CompanyBackgroundType reg : CompanyBackgroundType.values()) {
			if (type == reg.type) {
				return reg.desc();
			}
		}
		return null;
	}

	public static CompanyBackgroundType getByValue(String value) {
		for (CompanyBackgroundType reg : CompanyBackgroundType.values()) {
			if (value.equals(reg.desc)) {
				return reg;
			}
		}
		return null;
	}
}
