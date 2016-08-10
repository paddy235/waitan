package com.bbd.wtyh.domain;

public class CrowdFundingCompanyDO extends BaseDO {
    private Integer companyId;

    private String platformName;

    private String websiteUrl;

    private String fundingBusinessType;

    private Integer successNumber;

    private Float fundedAmout;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName == null ? null : platformName.trim();
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl == null ? null : websiteUrl.trim();
    }

    public String getFundingBusinessType() {
        return fundingBusinessType;
    }

    public void setFundingBusinessType(String fundingBusinessType) {
        this.fundingBusinessType = fundingBusinessType == null ? null : fundingBusinessType.trim();
    }

    public Integer getSuccessNumber() {
        return successNumber;
    }

    public void setSuccessNumber(Integer successNumber) {
        this.successNumber = successNumber;
    }

    public Float getFundedAmout() {
        return fundedAmout;
    }

    public void setFundedAmout(Float fundedAmout) {
        this.fundedAmout = fundedAmout;
    }
}