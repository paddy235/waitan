package com.bbd.wtyh.domain;

import java.util.Date;

public class DynamicRiskDataDO extends BaseDO {
    private Date riskDate;

    private Float bbdTimeRiskIndex;

    private Float personNum;

    private Float companyNum;

    private Float sumNum;

    private Float agreeActionNum;

    private Float agreeActionProportion;

    private Float oneTwoComapnyNum;

    private Float oneTwoCompanyProportion;

    private Integer threePersonNum;

    private Float threePersonProportion;

    private Integer typeSumNum;

    private Float typeSumProportion;

    private String areaList;

    private String areaCompanyNum;

    private String companyName;

    private String dataVersion;

    private String area;

    private String corePersonList;

    private String controlNum;

    private String agreeCompanyDetail;

    private String companyDetail;

    public String getCorePersonList() {
        return corePersonList;
    }

    public void setCorePersonList(String corePersonList) {
        this.corePersonList = corePersonList == null ? null : corePersonList.trim();
    }

    public String getControlNum() {
        return controlNum;
    }

    public void setControlNum(String controlNum) {
        this.controlNum = controlNum == null ? null : controlNum.trim();
    }

    public String getAgreeCompanyDetail() {
        return agreeCompanyDetail;
    }

    public void setAgreeCompanyDetail(String agreeCompanyDetail) {
        this.agreeCompanyDetail = agreeCompanyDetail == null ? null : agreeCompanyDetail.trim();
    }

    public String getCompanyDetail() {
        return companyDetail;
    }

    public void setCompanyDetail(String companyDetail) {
        this.companyDetail = companyDetail == null ? null : companyDetail.trim();
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion == null ? null : dataVersion.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Date getRiskDate() {
        return riskDate;
    }

    public void setRiskDate(Date riskDate) {
        this.riskDate = riskDate;
    }

    public Float getBbdTimeRiskIndex() {
        return bbdTimeRiskIndex;
    }

    public void setBbdTimeRiskIndex(Float bbdTimeRiskIndex) {
        this.bbdTimeRiskIndex = bbdTimeRiskIndex;
    }

    public Float getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Float personNum) {
        this.personNum = personNum;
    }

    public Float getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(Float companyNum) {
        this.companyNum = companyNum;
    }

    public Float getSumNum() {
        return sumNum;
    }

    public void setSumNum(Float sumNum) {
        this.sumNum = sumNum;
    }

    public Float getAgreeActionNum() {
        return agreeActionNum;
    }

    public void setAgreeActionNum(Float agreeActionNum) {
        this.agreeActionNum = agreeActionNum;
    }

    public Float getAgreeActionProportion() {
        return agreeActionProportion;
    }

    public void setAgreeActionProportion(Float agreeActionProportion) {
        this.agreeActionProportion = agreeActionProportion;
    }

    public Float getOneTwoComapnyNum() {
        return oneTwoComapnyNum;
    }

    public void setOneTwoComapnyNum(Float oneTwoComapnyNum) {
        this.oneTwoComapnyNum = oneTwoComapnyNum;
    }

    public Float getOneTwoCompanyProportion() {
        return oneTwoCompanyProportion;
    }

    public void setOneTwoCompanyProportion(Float oneTwoCompanyProportion) {
        this.oneTwoCompanyProportion = oneTwoCompanyProportion;
    }

    public Integer getThreePersonNum() {
        return threePersonNum;
    }

    public void setThreePersonNum(Integer threePersonNum) {
        this.threePersonNum = threePersonNum;
    }

    public Float getThreePersonProportion() {
        return threePersonProportion;
    }

    public void setThreePersonProportion(Float threePersonProportion) {
        this.threePersonProportion = threePersonProportion;
    }

    public Integer getTypeSumNum() {
        return typeSumNum;
    }

    public void setTypeSumNum(Integer typeSumNum) {
        this.typeSumNum = typeSumNum;
    }

    public Float getTypeSumProportion() {
        return typeSumProportion;
    }

    public void setTypeSumProportion(Float typeSumProportion) {
        this.typeSumProportion = typeSumProportion;
    }

    public String getAreaList() {
        return areaList;
    }

    public void setAreaList(String areaList) {
        this.areaList = areaList == null ? null : areaList.trim();
    }

    public String getAreaCompanyNum() {
        return areaCompanyNum;
    }

    public void setAreaCompanyNum(String areaCompanyNum) {
        this.areaCompanyNum = areaCompanyNum == null ? null : areaCompanyNum.trim();
    }
}