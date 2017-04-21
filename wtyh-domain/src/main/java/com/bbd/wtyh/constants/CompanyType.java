package com.bbd.wtyh.constants;

/**
 * 公司风险变化来源
 *
 * @author Created by LiYao on 2017-04-19 17:57.
 */
public enum CompanyType {

	TYPE_P2P_1(1, "网络借贷"),
	TYPE_XD_2(2, "小额贷款"),
	TYPE_RZDB_3(3, "融资担保"),
	TYPE_XXLC_4(4, "线下理财"),
	TYPE_SMJJ_5(5, "私募基金"),
	TYPE_ZC_6(6, "众筹"),
	TYPE_JR_7(7, "金融"),
	TYPE_QT_8(8, "其他"),
	TYPE_JYS_9(9, "交易场所"),
	TYPE_SYBL_10(10, "商业保理"),
	TYPE_YFK_11(11, "预付卡"),
	TYPE_DD_12(12, "典当"),
	TYPE_RZZL_13(13, "融资租赁");

	private int type;
	private String desc;

	CompanyType(int type, String desc) {
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
