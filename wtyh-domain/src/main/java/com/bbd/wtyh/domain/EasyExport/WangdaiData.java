package com.bbd.wtyh.domain.EasyExport;

import com.bbd.wtyh.constants.RegisteredCapitalType;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.enums.WangDaiRiskLevel;
import com.bbd.wtyh.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 网络借贷
 * Created by YanWenyuan on 2017/7/19.
 */
public class WangdaiData {
    @Excel(exportName="公司名")
    private String name;
    private Byte industry;
    @Excel(exportName="行业类别")
    private String industryName;
    @Excel(exportName="平台名称")
    private String platName;
    private String currentLevel = "";
    @Excel(exportName="风险等级")
    private String currentLevelName = "";
    @Excel(exportName="风险值")
    private String score = "";
    @Excel(exportName="法人")
    private String legalPerson;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(exportName="注册时间")
    private Date registeredDate;
    @Excel(exportName="注册资本（万元）")
    private String registeredCapital;
    private Integer registeredCapitalType;
    @Excel(exportName="注册资本类型")
    private String registeredCapitalTypeName;
    @Excel(exportName="注册地址")
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

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public String getScore() {

        String name = "" ;
        if(null != currentLevel){
            try{
                name = WangDaiRiskLevel.getRiskScore(Integer.valueOf(currentLevel));
            }catch (Exception e){}
        }

        return name;
    }

    public void setScore(String score) {
        this.score = score;
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

    public String getIndustryName() {
        return  CompanyDO.companyTypeCN(industry);
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getCurrentLevelName() {
        String name = "" ;
        if(null != currentLevel){
            try{
                name = WangDaiRiskLevel.getRiskDesc(Integer.valueOf(currentLevel));
            }catch (Exception e){}
        }

        return name;
    }

    public void setCurrentLevelName(String currentLevelName) {
        this.currentLevelName = currentLevelName;
    }

    public Integer getRegisteredCapitalType() {
        return registeredCapitalType;
    }

    public void setRegisteredCapitalType(Integer registeredCapitalType) {
        this.registeredCapitalType = registeredCapitalType;
    }

    public String getRegisteredCapitalTypeName() {
        String name="";
        if(null==registeredCapitalType){
            return  name;
        }

        try {
            name = RegisteredCapitalType.desc(registeredCapitalType);

        }catch (Exception e){}
        return name;
    }

    public void setRegisteredCapitalTypeName(String registeredCapitalTypeName) {
        this.registeredCapitalTypeName = registeredCapitalTypeName;
    }
}
