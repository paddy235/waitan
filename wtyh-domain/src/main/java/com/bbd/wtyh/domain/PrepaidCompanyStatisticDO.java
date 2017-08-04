package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 预付卡统计信息
 */
@Table(name = "prepaid_company_statistic")
public class PrepaidCompanyStatisticDO extends BaseDO {
    @Id
    @Column(name = "year")
    private Integer year;

    private Integer prepaidCompanyNumber;

    @Column(name = "amount")
    private Integer amount;

    private Integer registerCapital;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPrepaidCompanyNumber() {
        return prepaidCompanyNumber;
    }

    public void setPrepaidCompanyNumber(Integer prepaidCompanyNumber) {
        this.prepaidCompanyNumber = prepaidCompanyNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getRegisterCapital() {
        return registerCapital;
    }

    public void setRegisterCapital(Integer registerCapital) {
        this.registerCapital = registerCapital;
    }
}