package com.bbd.wtyh.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * 企业类型
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
    TYPE_RZZL_13(13, "融资租赁"),
    TYPE_WT_30(30, "外滩网络借贷"),
    TYPE_WT_31(31, "外滩众筹"),
    TYPE_WT_32(32, "外滩网银"),
    TYPE_WT_33(33, "外滩支付"),
    TYPE_WT_34(34, "外滩预付卡"),
    TYPE_WT_35(35, "外滩融资租赁");


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

    public static CompanyType companyType(String desc) {
        if (StringUtils.isBlank(desc)) {
            return null;
        }
        CompanyType[] companyTypes = values();
        for (CompanyType type : companyTypes) {
            if (type.desc().equals(desc)) {
                return type;
            }
        }
        return null;
    }
}
