package com.bbd.wtyh.web.companyInfoModify;

/**
 * Created by YanWenyuan on 2017/7/22.
 */
public class ModifyData {

    // 公司名称
    private String name;
    // 风险等级
    private String level;
    // 外部评级 - 小额贷款、融资担保
    private String outLevel;
    // 内部评级 - 小额贷款、融资担保
    private String innerLevel;
    // 现场检查 - 小额贷款、融资担保
    private String liveLevel;
    // 行业变更 - 参数：4，线下理财
    private String industry;

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

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

    public String getInnerLevel() {
        return innerLevel;
    }

    public void setInnerLevel(String innerLevel) {
        this.innerLevel = innerLevel;
    }

    public String getLiveLevel() {
        return liveLevel;
    }

    public void setLiveLevel(String liveLevel) {
        this.liveLevel = liveLevel;
    }
}
