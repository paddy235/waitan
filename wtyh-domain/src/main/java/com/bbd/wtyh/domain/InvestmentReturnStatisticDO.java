package com.bbd.wtyh.domain;

public class InvestmentReturnStatisticDO extends BaseDO {
    private Integer year;

    private Integer quitNumber;

    private Integer lessNumber;

    private Integer betweenNumber;

    private Integer greaterNumber;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getQuitNumber() {
        return quitNumber;
    }

    public void setQuitNumber(Integer quitNumber) {
        this.quitNumber = quitNumber;
    }

    public Integer getLessNumber() {
        return lessNumber;
    }

    public void setLessNumber(Integer lessNumber) {
        this.lessNumber = lessNumber;
    }

    public Integer getBetweenNumber() {
        return betweenNumber;
    }

    public void setBetweenNumber(Integer betweenNumber) {
        this.betweenNumber = betweenNumber;
    }

    public Integer getGreaterNumber() {
        return greaterNumber;
    }

    public void setGreaterNumber(Integer greaterNumber) {
        this.greaterNumber = greaterNumber;
    }
}