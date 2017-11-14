package com.bbd.wtyh.domain.dto;

/**
 * Created by Marco on 2016/8/8.
 */
public class LoanBalanceDTO {

    private Integer year;

    private Integer month;

    private Double amount;

    private Integer number;

    private Double agricultureBalance;

    private Double smallCompanyBalance;

    private Integer companyAmount;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getAgricultureBalance() {
        return agricultureBalance;
    }

    public void setAgricultureBalance(Double agricultureBalance) {
        this.agricultureBalance = agricultureBalance;
    }

    public Double getSmallCompanyBalance() {
        return smallCompanyBalance;
    }

    public void setSmallCompanyBalance(Double smallCompanyBalance) {
        this.smallCompanyBalance = smallCompanyBalance;
    }

    public Integer getCompanyAmount() {
        return companyAmount;
    }

    public void setCompanyAmount(Integer companyAmount) {
        this.companyAmount = companyAmount;
    }
}
