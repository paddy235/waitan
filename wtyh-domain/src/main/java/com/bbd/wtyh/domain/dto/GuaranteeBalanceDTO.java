package com.bbd.wtyh.domain.dto;

/**
 * Created by Marco on 2016/8/8.
 */
public class GuaranteeBalanceDTO {

    private Integer year;

    private Integer month;

    private Integer amount;

    private Integer number;

    private Integer steelBalance;

    private Integer compositeBalance;

    private Integer policyBalance;

    private Integer companyAmount;

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

    public Integer getCompanyAmount() {
        return companyAmount;
    }

    public void setCompanyAmount(Integer companyAmount) {
        this.companyAmount = companyAmount;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
