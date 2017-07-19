package com.bbd.wtyh.domain.EasyExport;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 融资担保
 * Created by YanWenyuan on 2017/7/19.
 */
public class GuaranteeData {
    // 公司名
    private String name;
    // 行业类别
    private Byte industry;
    // 企业背景
    private Byte background;
    // 风险等级
    private String currentLevel;
    // 风险值
    // TODO: 2017/7/19
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

    public Byte getBackground() {
        return background;
    }

    public void setBackground(Byte background) {
        this.background = background;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
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
