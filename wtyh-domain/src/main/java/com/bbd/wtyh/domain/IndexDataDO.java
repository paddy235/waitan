package com.bbd.wtyh.domain;

import java.util.Date;

public class IndexDataDO extends BaseDO {
    private String regCapital;

    private String companyQualification;

    private Float staticRiskIndex;

    private Float dynamicRiskIndex;

    private String legalRpt;

    private String companyType;

    private Date regDate;

    private String reviewTime;

    private Integer isRise;

    private String companyName;

    private String area;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital == null ? null : regCapital.trim();
    }

    public String getCompanyQualification() {
        return companyQualification;
    }

    public void setCompanyQualification(String companyQualification) {
        this.companyQualification = companyQualification == null ? null : companyQualification.trim();
    }

    public Float getStaticRiskIndex() {
        return staticRiskIndex;
    }

    public void setStaticRiskIndex(Float staticRiskIndex) {
        this.staticRiskIndex = staticRiskIndex;
    }

    public Float getDynamicRiskIndex() {
        return dynamicRiskIndex;
    }

    public void setDynamicRiskIndex(Float dynamicRiskIndex) {
        this.dynamicRiskIndex = dynamicRiskIndex;
    }

    public String getLegalRpt() {
        return legalRpt;
    }

    public void setLegalRpt(String legalRpt) {
        this.legalRpt = legalRpt == null ? null : legalRpt.trim();
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(String reviewTime) {
        this.reviewTime = reviewTime == null ? null : reviewTime.trim();
    }

    public Integer getIsRise() {
        return isRise;
    }

    public void setIsRise(Integer isRise) {
        this.isRise = isRise;
    }
}