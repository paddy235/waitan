package com.bbd.wtyh.domain.dto;

/**
 * Created by Marco on 2016/9/18.
 */
public class GuaranteeBalanceByQuaterDTO {

    private Integer amount;

    private Integer year;

    private Integer quarter;

    private Integer number;

    private Integer steelBalance;

    private Integer compositeBalance;

    private Integer policyBalance;

    private Integer companyAmount;

    public Integer getCompanyAmount() {
        return companyAmount;
    }

    public void setCompanyAmount(Integer companyAmount) {
        this.companyAmount = companyAmount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
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

    public Integer getSteelBalance() {
        return steelBalance;
    }

    public void setSteelBalance(Integer steelBalance) {
        this.steelBalance = steelBalance;
    }

    public Integer getCompositeBalance() {
        return compositeBalance;
    }

    public void setCompositeBalance(Integer compositeBalance) {
        this.compositeBalance = compositeBalance;
    }

    public Integer getPolicyBalance() {
        return policyBalance;
    }

    public void setPolicyBalance(Integer policyBalance) {
        this.policyBalance = policyBalance;
    }
}