package com.bbd.wtyh.domain;

public class PrepaidCompanyStatisticDO extends BaseDO {
    private Integer year;

    private Integer prepaidCompanyNumber;

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