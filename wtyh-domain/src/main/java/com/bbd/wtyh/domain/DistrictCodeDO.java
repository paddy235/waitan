package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "district_code")
public class DistrictCodeDO  implements Serializable {
    //区县代码
    @Id
    @Column(name = "code")
    private Integer code;

    //区县名称
    @Column(name = "name")
    private String name;

    //省代码
    @Column(name = "pro_code")
    private Integer proCode;

    //市代码
    @Column(name = "city_code")
    private Integer cityCode;

    //县代码
    @Column(name = "town_code")
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