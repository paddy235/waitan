package com.bbd.wtyh.domain.CompanyInfoModify;

/**
 * Created by YanWenyuan on 2017/7/22.
 */
public class OffLineModify {
    // 公司名
    private String name;
    // 变化前状态
    private String beforeLevel;
    // 变化后状态
    private String afterLevel;
    // 变化前行业
    private Byte beforeIndustry;
    // 变化后行业
    private Byte afterIndustry;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Byte getAfterIndustry() {
        return afterIndustry;
    }

    public void setAfterIndustry(Byte afterIndustry) {
        this.afterIndustry = afterIndustry;
    }

    public Byte getBeforeIndustry() {
        return beforeIndustry;
    }

    public void setBeforeIndustry(Byte beforeIndustry) {
        this.beforeIndustry = beforeIndustry;
    }
}
