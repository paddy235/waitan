package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "guarantee_balance")
public class GuaranteeBalanceDO extends BaseDO {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "guarantee_balance")
    private Double guaranteeBalance;

    @Column(name = "year")
    private Integer year;

    @Column(name = "month")
    private Integer month;

    @Column(name = "number")
    private Integer number;//笔数

    @Column(name = "company_amount")
    private Integer companyAmount;

    @Column(name = "steel_balance")
    private Double steelBalance;//钢贸类余额

    @Column(name = "composite_balance")
    private Double compositeBalance;//综合类余额

    @Column(name = "policy_balance")
    private Double policyBalance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getGuaranteeBalance() {
        return guaranteeBalance;
    }

    public void setGuaranteeBalance(Double guaranteeBalance) {
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
}