package com.bbd.wtyh.domain;

/**
 * Created by Administrator on 2017/4/14 0014.
 */
public class ParkCompanyDo {

    private Integer companyId;//企业ID

    private String companyName;//企业名称

    private String legalPerson;//法人

    private Byte companyType;//企业类型

    private String companyTypeName;//企业类型名称

    private Integer riskLevel;//风险等级

    private String riskLevelName;//风险等级名称

    private Integer isNew;//是否新增

    private Integer buildingId;//楼宇ID

    private String buildingName;//楼宇名称

    private Byte background;//企业背景

    private String backgroundName;//企业背景名称


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public Byte getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Byte companyType) {
        this.companyType = companyType;
    }

    public String getCompanyTypeName() {
        return CompanyDO.companyTypeCN(this.companyType);
    }

    public void setCompanyTypeName(String companyTypeName) {
        this.companyTypeName = companyTypeName;
    }

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRiskLevelName() {
        return riskLevelName;
    }

    public void setRiskLevelName(String riskLevelName) {
        this.riskLevelName = riskLevelName;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Byte getBackground() {
        return background;
    }

    public void setBackground(Byte background) {
        this.background = background;
    }

    public String getBackgroundName() {
        if (null == background) {
            return "";
        }
        return CompanyBackgroundDO.Bg.getBg(this.background).CN;
    }

    public void setBackgroundName(String backgroundName) {
        this.backgroundName = backgroundName;
    }
}
