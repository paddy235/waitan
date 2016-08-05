package com.bbd.wtyh.domain;

public class LoanBalanceDO {
    private Integer year;

    private Integer mounth;

    private Float amount;

    private Integer number;

    private Float agricultureBalance;

    private Float smallCompanyBalance;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMounth() {
        return mounth;
    }

    public void setMounth(Integer mounth) {
        this.mounth = mounth;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getAgricultureBalance() {
        return agricultureBalance;
    }

    public void setAgricultureBalance(Float agricultureBalance) {
        this.agricultureBalance = agricultureBalance;
    }

    public Float getSmallCompanyBalance() {
        return smallCompanyBalance;
    }

    public void setSmallCompanyBalance(Float smallCompanyBalance) {
        this.smallCompanyBalance = smallCompanyBalance;
    }
}