package com.bbd.wtyh.domain;

public class GuaranteeBalanceDO extends BaseDO {
    private Integer id;

    private Integer guaranteeBalance;

    private Integer year;

    private Integer month;

    private Integer number;

    private Integer companyAmount;

    private Integer steelBalance;

    private Integer compositeBalance;

    private Integer policyBalance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGuaranteeBalance() {
        return guaranteeBalance;
    }

    public void setGuaranteeBalance(Integer guaranteeBalance) {
        this.guaranteeBalance = guaranteeBalance;
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

    public void setMonth(Integer month) {
        this.month = month;
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
}