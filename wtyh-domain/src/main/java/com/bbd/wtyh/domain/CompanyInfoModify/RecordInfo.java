package com.bbd.wtyh.domain.CompanyInfoModify;

/**
 * Created by YanWenyuan on 2017/7/24.
 */
public class RecordInfo {
    private Integer companyId;
    // 公司名称
    private String name;
    // 平台名称
    private String platName;
    // 变化前状态
    private String beforeLevel;
    // 变化后状态
    private String afterLevel;

    // 外部评级 - 小额贷款、融资担保
    private String beforeOutLevel;
    // 内部评级 - 小额贷款、融资担保
    private String beforeInnnerLevel;
    // 现场检查 - 小额贷款、融资担保
    private String beforeLiveLevel;

    // 外部评级 - 小额贷款、融资担保
    private String afterOutLevel;
    // 内部评级 - 小额贷款、融资担保
    private String afterInnnerLevel;
    // 现场检查 - 小额贷款、融资担保
    private String afterLiveLevel;

    // 变化前行业
    private Byte beforeIndustry;
    // 变化后行业
    private Byte afterIndustry;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public String getBeforeLevel() {
        return beforeLevel;
    }

    public void setBeforeLevel(String beforeLevel) {
        this.beforeLevel = beforeLevel;
    }

    public String getAfterLevel() {
        return afterLevel;
    }

    public void setAfterLevel(String afterLevel) {
        this.afterLevel = afterLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeforeOutLevel() {
        return beforeOutLevel;
    }

    public void setBeforeOutLevel(String beforeOutLevel) {
        this.beforeOutLevel = beforeOutLevel;
    }

    public String getBeforeInnnerLevel() {
        return beforeInnnerLevel;
    }

    public void setBeforeInnnerLevel(String beforeInnnerLevel) {
        this.beforeInnnerLevel = beforeInnnerLevel;
    }

    public String getBeforeLiveLevel() {
        return beforeLiveLevel;
    }

    public void setBeforeLiveLevel(String beforeLiveLevel) {
        this.beforeLiveLevel = beforeLiveLevel;
    }

    public String getAfterOutLevel() {
        return afterOutLevel;
    }

    public void setAfterOutLevel(String afterOutLevel) {
        this.afterOutLevel = afterOutLevel;
    }

    public String getAfterInnnerLevel() {
        return afterInnnerLevel;
    }

    public void setAfterInnnerLevel(String afterInnnerLevel) {
        this.afterInnnerLevel = afterInnnerLevel;
    }

    public String getAfterLiveLevel() {
        return afterLiveLevel;
    }

    public void setAfterLiveLevel(String afterLiveLevel) {
        this.afterLiveLevel = afterLiveLevel;
    }

    public Byte getBeforeIndustry() {
        return beforeIndustry;
    }

    public void setBeforeIndustry(Byte beforeIndustry) {
        this.beforeIndustry = beforeIndustry;
    }

    public Byte getAfterIndustry() {
        return afterIndustry;
    }

    public void setAfterIndustry(Byte afterIndustry) {
        this.afterIndustry = afterIndustry;
    }
}
