package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "investment_statistic")
public class InvestmentStatisticDO extends BaseDO {
    @Id
    @Column(name = "year")
    private Integer year;

    @Column(name = "investment_amount")
    private Double investmentAmount;

    @Column(name = "publish_number")
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

    public Double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(Double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }
}