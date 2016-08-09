package com.bbd.wtyh.domain;

public class MortgageStatisticDO extends BaseDO {
    private Integer year;

    private Integer companyNumber;

    private Integer balance;

    private Integer registerCapital;

    private Integer totalIncome;

    private Integer totalAmout;

    private Integer number;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public Integer getRegisterCapital() {
        return registerCapital;
    }

    public void setRegisterCapital(Integer registerCapital) {
        this.registerCapital = registerCapital;
    }

    public Integer getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Integer totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Integer getTotalAmout() {
        return totalAmout;
    }

    public void setTotalAmout(Integer totalAmout) {
        this.totalAmout = totalAmout;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}