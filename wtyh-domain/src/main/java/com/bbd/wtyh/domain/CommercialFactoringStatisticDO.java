package com.bbd.wtyh.domain;

public class CommercialFactoringStatisticDO extends BaseDO {
    private Integer year;

    private Integer balance;

    private Integer totalAmout;

    private Integer companyNumber;

    private Integer registerCapital;

    private Integer domestic;

    private Integer international;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public Integer getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(Integer companyNumber) {
        this.companyNumber = companyNumber;
    }

    public Integer getRegisterCapital() {
        return registerCapital;
    }

    public void setRegisterCapital(Integer registerCapital) {
        this.registerCapital = registerCapital;
    }

    public Integer getDomestic() {
        return domestic;
    }

    public void setDomestic(Integer domestic) {
        this.domestic = domestic;
    }

    public Integer getInternational() {
        return international;
    }

    public void setInternational(Integer international) {
        this.international = international;
    }
}