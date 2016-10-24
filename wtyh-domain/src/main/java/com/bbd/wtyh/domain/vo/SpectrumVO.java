package com.bbd.wtyh.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * Created by YanWenyuan on 2016/9/7.
 */
public class SpectrumVO implements Serializable {
    private String name;
    private Integer registeredCapital;
    private String exposureDate;
    private List location;
    @JsonIgnore
    private Double longitude;
    @JsonIgnore
    private Double latitude;
    private Double staticRiskIndex;

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

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getStaticRiskIndex() {
        return staticRiskIndex;
    }

    public void setStaticRiskIndex(Double staticRiskIndex) {
        this.staticRiskIndex = staticRiskIndex;
    }

    public List getLocation() {
        return location;
    }

    public void setLocation(List location) {
        this.location = location;
    }
}
