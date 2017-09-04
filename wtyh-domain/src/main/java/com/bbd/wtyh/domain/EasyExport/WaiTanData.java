package com.bbd.wtyh.domain.EasyExport;

import java.util.Arrays;
import java.util.Date;

import com.bbd.wtyh.constants.RegisteredCapitalType;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 外滩其他类型
 * Created by YanWenyuan on 2017/7/19.
 */
public class WaiTanData {
    @Excel(exportName = "公司名")
    private String name;
    private String industry;
    @Excel(exportName = "行业类别")
    private String industryName;
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


    public String getIndustryName() {
        String name = "";
        try{
            if (null == industry || industry.equals("")) {
                return name;
            }
            String[] types = industry.split(",");
            Arrays.sort(types);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < types.length; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(CompanyInfo.companyTypeCN(Byte.valueOf(types[i])));
            }
            name = sb.toString();
        }catch (Exception e){
            name = "";
        }
        return name;

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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
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
