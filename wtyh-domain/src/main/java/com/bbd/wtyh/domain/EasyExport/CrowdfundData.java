package com.bbd.wtyh.domain.EasyExport;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 众筹
 * Created by YanWenyuan on 2017/7/19.
 */
public class CrowdfundData {
    @Excel(exportName = "公司名")
    private String name;
    private Byte industry;
    @Excel(exportName = "行业类别")
    private String industryName;
    @Excel(exportName = "平台名称")
    private String platName;
    @Excel(exportName = "平台连接")
    private String url;
    @Excel(exportName = "法人")
    private String legalPerson;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(exportName = "注册时间")
    private Date registeredDate;
    @Excel(exportName = "注册资本（万元）")
    private String registeredCapital;
    @Excel(exportName = "注册地址")
    private String address = "";


    public String getIndustryName() {
        return  CompanyDO.companyTypeCN(industry);
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }
}
