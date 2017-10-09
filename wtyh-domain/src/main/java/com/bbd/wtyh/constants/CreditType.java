package com.bbd.wtyh.constants;

/**
 * Created by Administrator on 2017/10/9 0009.
 */
public enum CreditType {

    ABNORMAL("abnormal","非正常户认定"),
    EXCEPTION_LIST("exceptionList","经营异常名录"),
    PENALTY_INFO("penaltyInfo","行政处罚信息"),
    UNFAIR_COMPETITION("unfairCompetition","对不正当竞争行为的处罚"),
    MARKET_SUPERVISION("marketSupervision","市场监管类行政处罚（法人）"),
    EMPLOYING_UNIT("employingUnit","用人单位欠缴社会保险费，被依法责令限期缴纳信息");

    private String type;
    private String desc;

    public String type() {
        return this.type;
    }

    public String desc() {
        return this.desc;
    }

    CreditType( String type,String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static String desc(String type) {
        for (CreditType creditType : CreditType.values()) {
            if (creditType.type.equals(type)) {
                return creditType.desc();
            }
        }
        return null;
    }

    public static String type(String desc) {
        for (CreditType creditType : CreditType.values()) {
            if (creditType.desc.equals(desc)) {
                return creditType.type();
            }
        }
        return null;
    }

}
