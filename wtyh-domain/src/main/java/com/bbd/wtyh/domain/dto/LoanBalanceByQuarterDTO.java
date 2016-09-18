package com.bbd.wtyh.domain.dto;

/**
 * Created by Marco on 2016/9/18.
 */
public class LoanBalanceByQuarterDTO {

    private Integer year;

    private Integer quarter;

    private Integer amount;

    private Integer number;

    private Integer agricultureBalance;

    private Integer smallCompanyBalance;

    private Integer companyAmount;

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public Integer getCompanyAmount() {
        return companyAmount;
    }

    public void setCompanyAmount(Integer companyAmount) {
        this.companyAmount = companyAmount;
    }
}
