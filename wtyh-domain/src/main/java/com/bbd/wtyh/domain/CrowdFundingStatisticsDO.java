package com.bbd.wtyh.domain;

public class CrowdFundingStatisticsDO extends BaseDO {
    private Integer year;

    private Float peopleNumber;

    private Integer projectNumber;

    private Float amount;

    private Integer type;

    private Integer month;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Float getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Float peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public Integer getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(Integer projectNumber) {
        this.projectNumber = projectNumber;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}