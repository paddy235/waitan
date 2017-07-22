package com.bbd.wtyh.web.companyInfoModify;

/**
 * Created by YanWenyuan on 2017/7/22.
 */
public class ModifyData {
    // 公司名称
    private String name;
    // 风险等级
    // TODO: 2017/7/22 整理每个行业的风险等级值
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
