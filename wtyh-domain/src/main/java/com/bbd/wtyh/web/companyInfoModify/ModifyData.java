package com.bbd.wtyh.web.companyInfoModify;

/**
 * Created by YanWenyuan on 2017/7/22.
 */
public class ModifyData {
    // 公司名称
    private String name;
    // 风险等级
    // TODO: 2017/7/22 整理每个行业的风险等级值
    /**
     * 1. 网络借贷：正常4，一般关注3，重点关注2，问题1
     *
     * 2. 小额贷款： Enum类
     *   AAA_p("AAA+"), AAA("AAA"), AAA_m("AAA-"),
         AA_p("AA+"), AA("AA"), AA_m("AA-"),
         A_p("A+"), A("A"), A_m("A-"),
         BBB_p("BBB+"), BBB("BBB"), BBB_m("BBB-"),
         BB_p("BB+"), BB("BB"), BB_m("BB-"),
         B_p("B+"), B("B"), B_m("B-"),
         CCC_p("CCC+"), CCC("CCC"), CCC_m("CCC-"),
         CC_p("CC+"), CC("CC"), CC_m("CC-"),
         C_p("C+"), C("C"), C_m("C-"),
         D("D");
     */
    private String level;
    // 外部评级 - 小额贷款、融资担保
    private String outLevel;
    // 内部评级 - 小额贷款、融资担保
    private String innnerLevel;
    // 现场检查 - 小额贷款、融资担保
    private String liveLevel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOutLevel() {
        return outLevel;
    }

    public void setOutLevel(String outLevel) {
        this.outLevel = outLevel;
    }

    public String getInnnerLevel() {
        return innnerLevel;
    }

    public void setInnnerLevel(String innnerLevel) {
        this.innnerLevel = innnerLevel;
    }

    public String getLiveLevel() {
        return liveLevel;
    }

    public void setLiveLevel(String liveLevel) {
        this.liveLevel = liveLevel;
    }
}
