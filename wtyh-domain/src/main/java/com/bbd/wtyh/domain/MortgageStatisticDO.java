package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "mortgage_statistic")
public class MortgageStatisticDO extends BaseDO {
    @Id
    @Column(name = "year")
    private Integer year;

    @Column(name = "company_number")
    private Integer companyNumber;

    @Column(name = "balance")
    private Integer balance;

    @Column(name = "register_capital")
    private Integer registerCapital;

    @Column(name = "total_income")
    private Integer totalIncome;

    @Column(name = "total_amout")
    private Integer totalAmout;

    @Column(name = "number")
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