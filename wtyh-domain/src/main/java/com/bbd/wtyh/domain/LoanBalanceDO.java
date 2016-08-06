package com.bbd.wtyh.domain;

public class LoanBalanceDO extends BaseDO {
    private Integer id;

    private Integer year;

    private Integer month;

    private Integer amount;

    private Integer number;

    private Integer agricultureBalance;

    private Integer smallCompanyBalance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer mounth) {
        this.month = month;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getAgricultureBalance() {
        return agricultureBalance;
    }

    public void setAgricultureBalance(Integer agricultureBalance) {
        this.agricultureBalance = agricultureBalance;
    }

    public Integer getSmallCompanyBalance() {
        return smallCompanyBalance;
    }

    public void setSmallCompanyBalance(Integer smallCompanyBalance) {
        this.smallCompanyBalance = smallCompanyBalance;
    }
}