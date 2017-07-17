package com.bbd.wtyh.domain;

/**
 * Created by lixudong on 2017/7/15.
 */
public class IndustryProblemDO extends BaseDO{

    private String area;
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
