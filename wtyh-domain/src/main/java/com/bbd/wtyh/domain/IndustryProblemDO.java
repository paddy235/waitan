package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by lixudong on 2017/7/15.
 */
@Table(name = "industry_problem")
public class IndustryProblemDO extends BaseDO{

    private String area;
    @Column(name = "date")
    private String date;
    private int problemPlatNumber;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getProblemPlatNumber() {
        return problemPlatNumber;
    }

    public void setProblemPlatNumber(int problemPlatNumber) {
        this.problemPlatNumber = problemPlatNumber;
    }

    @Override
    public String toString() {
        return "IndustryProblemDO{" +
                "area='" + area + '\'' +
                ", date='" + date + '\'' +
                ", problemPlatNumber=" + problemPlatNumber +
                '}';
    }
}
