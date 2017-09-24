package com.bbd.wtyh.domain.EasyExport;

import com.bbd.wtyh.constants.RegisteredCapitalType;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.enums.CompanyLevel;
import com.bbd.wtyh.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 小额贷款
 * Created by YanWenyuan on 2017/7/19.
 */
public class LoanData {
    @Excel(exportName = "公司名")
    private String name;
    private Byte industry;
    @Excel(exportName = "行业类别")
    private String industryName;
    private String outLevel;
    private String innerLevel;
    private String liveLevel;

    @Excel(exportName = "法人")
    private String legalPerson;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(exportName = "注册时间")
    private Date registeredDate;
    @Excel(exportName = "注册资本（万元）")
    private String registeredCapital;
    private Integer registeredCapitalType;
    @Excel(exportName="注册资本类型")
    private String registeredCapitalTypeName;
    @Excel(exportName = "注册地址")
    private String address = "";

    @Excel(exportName = "外部评级")
    private String outLevelName;
    @Excel(exportName = "内部评级")
    private String innnerLevelName;
    @Excel(exportName = "现场检查")
    private String liveLevelName;


    public String getIndustryName() {
        return  CompanyDO.companyTypeCN(industry);
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
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

    public String getOutLevel() {
        return outLevel;
    }

    public void setOutLevel(String outLevel) {
        this.outLevel = outLevel;
    }

    public String getInnerLevel() {
        return innerLevel;
    }

    public void setInnerLevel(String innerLevel) {
        this.innerLevel = innerLevel;
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

    public String getOutLevelName() {
        String name = null;

        if(null != outLevel){
            try{
                name = CompanyLevel.getByOrdinal(Integer.valueOf(outLevel)).getValue();
            }catch (Exception e){

                name = outLevel;
            }
        }

        return name;
    }

    public void setOutLevelName(String outLevelName) {
        this.outLevelName = outLevelName;
    }

    public String getInnnerLevelName() {

        String name = null;

        if(null != innerLevel){
            try{
                name = CompanyLevel.getByOrdinal(Integer.valueOf(innerLevel)).getValue();
            }catch (Exception e){

                name = innerLevel;
            }
        }

        return name;
    }

    public void setInnnerLevelName(String innnerLevelName) {
        this.innnerLevelName = innnerLevelName;
    }

    public String getLiveLevelName() {
        String name = null;

        if(null != liveLevel){
            try{
                name = CompanyLevel.getByOrdinal(Integer.valueOf(liveLevel)).getValue();
            }catch (Exception e){

                name = liveLevel;
            }
        }

        return name;
    }

    public void setLiveLevelName(String liveLevelName) {
        this.liveLevelName = liveLevelName;
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
