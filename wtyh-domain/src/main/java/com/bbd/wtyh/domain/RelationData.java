package com.bbd.wtyh.domain;

import java.util.Date;

public class RelationData extends RelationDataKey {
    private Date riskDate;

    private Integer relationPersonNum;

    private Integer companyPersonNum;

    private Integer childCompanyNum;

    private Integer onePersonNum;

    private Integer oneCompanyNum;

    private Integer twoPersonNum;

    private Integer twoCompanyNum;

    private Integer threePersonNum;

    private Integer threeCompanyNum;

    public Date getRiskDate() {
        return riskDate;
    }

    public void setRiskDate(Date riskDate) {
        this.riskDate = riskDate;
    }

    public Integer getRelationPersonNum() {
        return relationPersonNum;
    }

    public void setRelationPersonNum(Integer relationPersonNum) {
        this.relationPersonNum = relationPersonNum;
    }

    public Integer getCompanyPersonNum() {
        return companyPersonNum;
    }

    public void setCompanyPersonNum(Integer companyPersonNum) {
        this.companyPersonNum = companyPersonNum;
    }

    public Integer getChildCompanyNum() {
        return childCompanyNum;
    }

    public void setChildCompanyNum(Integer childCompanyNum) {
        this.childCompanyNum = childCompanyNum;
    }

    public Integer getOnePersonNum() {
        return onePersonNum;
    }

    public void setOnePersonNum(Integer onePersonNum) {
        this.onePersonNum = onePersonNum;
    }

    public Integer getOneCompanyNum() {
        return oneCompanyNum;
    }

    public void setOneCompanyNum(Integer oneCompanyNum) {
        this.oneCompanyNum = oneCompanyNum;
    }

    public Integer getTwoPersonNum() {
        return twoPersonNum;
    }

    public void setTwoPersonNum(Integer twoPersonNum) {
        this.twoPersonNum = twoPersonNum;
    }

    public Integer getTwoCompanyNum() {
        return twoCompanyNum;
    }

    public void setTwoCompanyNum(Integer twoCompanyNum) {
        this.twoCompanyNum = twoCompanyNum;
    }

    public Integer getThreePersonNum() {
        return threePersonNum;
    }

    public void setThreePersonNum(Integer threePersonNum) {
        this.threePersonNum = threePersonNum;
    }

    public Integer getThreeCompanyNum() {
        return threeCompanyNum;
    }

    public void setThreeCompanyNum(Integer threeCompanyNum) {
        this.threeCompanyNum = threeCompanyNum;
    }
}