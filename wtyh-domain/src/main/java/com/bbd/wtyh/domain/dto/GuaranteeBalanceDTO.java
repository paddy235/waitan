package com.bbd.wtyh.domain.dto;

/**
 * Created by Marco on 2016/8/8.
 */
public class GuaranteeBalanceDTO {

    private Integer year;

    private Integer month;

    private Double amount;

    private Integer number;

    private Double steelBalance;

    private Double compositeBalance;

    private Double policyBalance;

    private Integer companyAmount;

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
