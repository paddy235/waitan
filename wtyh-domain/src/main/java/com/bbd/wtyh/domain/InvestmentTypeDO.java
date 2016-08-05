package com.bbd.wtyh.domain;

public class InvestmentTypeDO extends BaseDO {
    private Integer investmentTypeId;

    private String investmentTypeName;

    public Integer getInvestmentTypeId() {
        return investmentTypeId;
    }

    public void setInvestmentTypeId(Integer investmentTypeId) {
        this.investmentTypeId = investmentTypeId;
    }

    public String getInvestmentTypeName() {
        return investmentTypeName;
    }

    public void setInvestmentTypeName(String investmentTypeName) {
        this.investmentTypeName = investmentTypeName == null ? null : investmentTypeName.trim();
    }
}