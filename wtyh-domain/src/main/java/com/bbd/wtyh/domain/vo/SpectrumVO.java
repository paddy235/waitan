package com.bbd.wtyh.domain.vo;

/**
 * Created by YanWenyuan on 2016/9/7.
 */
public class SpectrumVO {
    private String name;
    private Integer registeredCapital;
    private String exposureDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(Integer registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getExposureDate() {
        return exposureDate;
    }

    public void setExposureDate(String exposureDate) {
        this.exposureDate = exposureDate;
    }
}
