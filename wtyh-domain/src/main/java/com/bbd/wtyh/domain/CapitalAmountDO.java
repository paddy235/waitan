package com.bbd.wtyh.domain;

public class CapitalAmountDO extends BaseDO {
    private Integer investmentTypeId;

    private Float manageCapitalAmount;

    public Integer getInvestmentTypeId() {
        return investmentTypeId;
    }

    public void setInvestmentTypeId(Integer investmentTypeId) {
        this.investmentTypeId = investmentTypeId;
    }

    public Float getManageCapitalAmount() {
        return manageCapitalAmount;
    }

    public void setManageCapitalAmount(Float manageCapitalAmount) {
        this.manageCapitalAmount = manageCapitalAmount;
    }
}