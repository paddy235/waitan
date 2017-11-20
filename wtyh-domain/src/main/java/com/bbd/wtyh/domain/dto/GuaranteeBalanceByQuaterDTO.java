package com.bbd.wtyh.domain.dto;

/**
 * Created by Marco on 2016/9/18.
 */
public class GuaranteeBalanceByQuaterDTO {

    private Double amount;

    private Integer year;

    private Integer quarter;

    private Integer number;

    private Double steelBalance;

    private Double compositeBalance;

    private Double policyBalance;

    private Integer companyAmount;

    public Integer getCompanyAmount() {
        return companyAmount;
    }

    public void setCompanyAmount(Integer companyAmount) {
        this.companyAmount = companyAmount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getSteelBalance() {
        return steelBalance;
    }

    public void setSteelBalance(Double steelBalance) {
        this.steelBalance = steelBalance;
    }

    public Double getCompositeBalance() {
        return compositeBalance;
    }

    public void setCompositeBalance(Double compositeBalance) {
        this.compositeBalance = compositeBalance;
    }

    public Double getPolicyBalance() {
        return policyBalance;
    }

    public void setPolicyBalance(Double policyBalance) {
        this.policyBalance = policyBalance;
    }
}