package com.bbd.wtyh.domain;

public class InvestmentStatisticDO extends BaseDO {
    private Integer year;

    private Integer investmentAmount;

    private Integer publishNumber;

    public Integer getPublishNumber() {
        return publishNumber;
    }

    public void setPublishNumber(Integer publishNumber) {
        this.publishNumber = publishNumber;
    }

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