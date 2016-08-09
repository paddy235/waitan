package com.bbd.wtyh.domain;

public class FinanceLeaseStatisticDO extends BaseDO {
    private Integer year;

    private Integer inAreaNumber;

    private Integer outAreaNumber;

    private Integer companyNumber;

    private Integer balance;

    private Integer totalAmout;

    private Integer badAmout;

    private Float badRatio;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getInAreaNumber() {
        return inAreaNumber;
    }

    public void setInAreaNumber(Integer inAreaNumber) {
        this.inAreaNumber = inAreaNumber;
    }

    public Integer getOutAreaNumber() {
        return outAreaNumber;
    }

    public void setOutAreaNumber(Integer outAreaNumber) {
        this.outAreaNumber = outAreaNumber;
    }

    public Integer getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(Integer companyNumber) {
        this.companyNumber = companyNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getTotalAmout() {
        return totalAmout;
    }

    public void setTotalAmout(Integer totalAmout) {
        this.totalAmout = totalAmout;
    }

    public Integer getBadAmout() {
        return badAmout;
    }

    public void setBadAmout(Integer badAmout) {
        this.badAmout = badAmout;
    }

    public Float getBadRatio() {
        return badRatio;
    }

    public void setBadRatio(Float badRatio) {
        this.badRatio = badRatio;
    }
}