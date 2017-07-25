package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "investment_return_statistic")
public class InvestmentReturnStatisticDO extends BaseDO {
    @Id
    @Column(name = "year")
    private Integer year;

    @Column(name = "quit_number")
    private Integer quitNumber;

    @Column(name = "less_number")
    private Integer lessNumber;

    @Column(name = "between_number")
    private Integer betweenNumber;

    @Column(name = "greater_number")
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