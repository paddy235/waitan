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
    private Integer guaranteeBalance;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    @Column(name = "number")
    private Integer number;//笔数
    @Column(name = "guarantee_id")
    private Integer companyAmount;
    @Column(name = "steel_balance")
    private Integer steelBalance;//钢贸类余额
    @Column(name = "composite_balance")//综合类余额
    private Integer compositeBalance;
    @Column(name = "guarantee_id")
    private Integer policyBalance;
    @Column(name = "guarantee_id")
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