package com.bbd.wtyh.domain;

/**
 * Created by lixudong on 2017/7/11.
 */
public class IndustryShanghaiAreaDO extends BaseDO{

    private String date;

    private String areaName;

    private double areaNum;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public double getAreaNum() {
        return areaNum;
    }

    public void setAreaNum(double areaNum) {
        this.areaNum = areaNum;
    }

    @Override
    public String toString() {
        return "IndustryShanghaiAreaDO{" +
                "date='" + date + '\'' +
                ", areaName='" + areaName + '\'' +
                ", areaNum=" + areaNum +
                '}';
    }
}
