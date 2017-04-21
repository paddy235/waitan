package com.bbd.wtyh.constants;

/**
 * 公司风险变化来源
 *
 * @author Created by LiYao on 2017-04-19 17:57.
 */
public enum CompanyClosedType {

	CLOSE_TYPE_1(1, "吊销"),
	CLOSE_TYPE_2(2, "注销"),
	CLOSE_TYPE_3(3, "拟吊销"),
	CLOSE_TYPE_4(4, "拟注销"),
	CLOSE_TYPE_5(5, "停业"),
	CLOSE_TYPE_6(6, "迁出"),
	CLOSE_TYPE_7(7, "撤销"),
	CLOSE_TYPE_8(8, "清算"),
	CLOSE_TYPE_9(9, "经营期限届满"),
	CLOSE_TYPE_10(10, "其他");

	private int type;
	private String desc;

	CompanyClosedType(int type, String desc) {
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
