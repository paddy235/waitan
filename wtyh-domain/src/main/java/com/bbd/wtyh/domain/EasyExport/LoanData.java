package com.bbd.wtyh.domain.EasyExport;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 小额贷款
 * Created by YanWenyuan on 2017/7/19.
 */
public class LoanData {
    // 公司名
    private String name;
    // 行业
    private Byte industry;
    // 外部评级
    private String outLevel;
    // 内部评级
    private String innnerLevel;
    // 现场检查
    private String liveLevel;
    // 法人
    private String legalPerson;
    // 注册时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date registeredDate;
    // 注册资本
    private String registeredCapital;
    // 注册地址
    private String address = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getIndustry() {
        return industry;
    }

    public void setIndustry(Byte industry) {
        this.industry = industry;
    }

    public String getOutLevel() {
        return outLevel;
    }

    public void setOutLevel(String outLevel) {
        this.outLevel = outLevel;
    }

    public String getInnnerLevel() {
        return innnerLevel;
    }

    public void setInnnerLevel(String innnerLevel) {
        this.innnerLevel = innnerLevel;
    }

    public String getLiveLevel() {
        return liveLevel;
    }

    public void setLiveLevel(String liveLevel) {
        this.liveLevel = liveLevel;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
