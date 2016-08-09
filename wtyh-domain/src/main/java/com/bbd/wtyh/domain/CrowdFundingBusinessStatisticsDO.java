package com.bbd.wtyh.domain;

public class CrowdFundingBusinessStatisticsDO extends BaseDO {
    private Integer year;

    private Integer month;

    private Integer publicWelfareType;

    private Integer synthesizingType;

    private Integer equityType;

    private Integer profitType;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getPublicWelfareType() {
        return publicWelfareType;
    }

    public void setPublicWelfareType(Integer publicWelfareType) {
        this.publicWelfareType = publicWelfareType;
    }

    public Integer getSynthesizingType() {
        return synthesizingType;
    }

    public void setSynthesizingType(Integer synthesizingType) {
        this.synthesizingType = synthesizingType;
    }

    public Integer getEquityType() {
        return equityType;
    }

    public void setEquityType(Integer equityType) {
        this.equityType = equityType;
    }

    public Integer getProfitType() {
        return profitType;
    }

    public void setProfitType(Integer profitType) {
        this.profitType = profitType;
    }
}