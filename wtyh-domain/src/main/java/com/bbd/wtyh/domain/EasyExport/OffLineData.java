package com.bbd.wtyh.domain.EasyExport;

import com.bbd.wtyh.domain.CompanyBackgroundDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;
import java.util.Date;

/**
 * 线下理财
 * Created by YanWenyuan on 2017/7/19.
 */
public class OffLineData {
    // 公司名
    @Excel(exportName = "公司名")
    private String name;
    // 行业类别
    private Byte industry;
    @Excel(exportName = "行业类别")
    private String industryName;
    // 企业背景
    private String background;
    @Excel(exportName = "企业背景")
    private String backgroundName;// 企业背景名称
    // 风险等级
    private String currentLevel;
    @Excel(exportName = "风险等级")
    private String currentLevelName = "";
    // 风险值
    @Excel(exportName = "风险分值")
    private String staticRiskIndex;
    // 法人
    @Excel(exportName = "法人")
    private String legalPerson;
    // 注册时间
    @Excel(exportName = "注册时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date registeredDate;
    // 注册资本
    @Excel(exportName = "注册资本（万元）")
    private String registeredCapital;
    // 注册地址
    @Excel(exportName = "注册地址")
    private String address = "";



    public String getStaticRiskIndex() {
        return staticRiskIndex;
    }

    public void setStaticRiskIndex(String staticRiskIndex) {
        this.staticRiskIndex = staticRiskIndex;
    }


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

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
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

    public String getCurrentLevelName() {
        String name = "" ;
        if(null != currentLevel){
            try{
                name = CompanyAnalysisResult.getName(Integer.valueOf(currentLevel));
            }catch (Exception e){}
        }

        return name;
    }

    public void setCurrentLevelName(String currentLevelName) {
        this.currentLevelName = currentLevelName;
    }

    public String getBackgroundName() {
        if (null == background || background.equals("")) {
            return "";
        }
        String[] bg = background.split(",");
        Arrays.sort(bg);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bg.length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(CompanyBackgroundDO.Bg.getBg(Byte.valueOf(bg[i])).CN);
        }
        return sb.toString();
    }

    public void setBackgroundName(String backgroundName) {
        this.backgroundName = backgroundName;
    }
}
