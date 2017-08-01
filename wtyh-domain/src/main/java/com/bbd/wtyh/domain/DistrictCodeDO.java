package com.bbd.wtyh.domain;

import java.io.Serializable;

//@Table(name = "finance_lease_risk")
public class DistrictCodeDO  implements Serializable {
    //@Id
    //@Column(name = "id")
    //区县代码
    private Integer code;
    //区县名称
    private String name;
    //省代码
    private Integer proCode;
    //市代码
    private Integer cityCode;
    //县代码
    private Integer townCode;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProCode() {
        return proCode;
    }

    public void setProCode(Integer proCode) {
        this.proCode = proCode;
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getTownCode() {
        return townCode;
    }

    public void setTownCode(Integer townCode) {
        this.townCode = townCode;
    }
}