package com.bbd.wtyh.domain;

public class InvestmentLogisticDO extends BaseDO {
    private Integer year;

    private Integer investmentAmount;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(Integer investmentAmount) {
        this.investmentAmount = investmentAmount;
    }
}