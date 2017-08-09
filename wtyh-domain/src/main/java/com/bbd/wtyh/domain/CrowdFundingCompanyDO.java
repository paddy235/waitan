package com.bbd.wtyh.domain;

import com.google.gson.annotations.SerializedName;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "qdlp_progress")
public class CrowdFundingCompanyDO extends BaseDO implements Serializable {
    //@Id
    @Column(name = "company_name")
    @SerializedName("company_name")
    private String  companyName;          //公司名称
    @SerializedName("operation_address")
    private String  address;              //营业地址
    @SerializedName("registration_address")
    private String  areaName;             //注册地
    @SerializedName("website_url")
    private String  websiteUrl;           //网址
    @SerializedName("platform_name")
    private String  platformName;         //平台名称
    @SerializedName("success_number")
    private String successNumber;        //成功项目数
    @SerializedName("funded_amout")
    private String   fundedAmout;          //已筹基金
    @SerializedName("funding_business_type")
    private String  fundingBusinessTypeCN;//业务类型;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getSuccessNumber() {
        return successNumber;
    }

    public void setSuccessNumber(String successNumber) {
        this.successNumber = successNumber;
    }

    public String getFundedAmout() {
        return fundedAmout;
    }

    public void setFundedAmout(String fundedAmout) {
        this.fundedAmout = fundedAmout;
    }

    public String getFundingBusinessTypeCN() {
        return fundingBusinessTypeCN;
    }

    public void setFundingBusinessTypeCN(String fundingBusinessTypeCN) {
        this.fundingBusinessTypeCN = fundingBusinessTypeCN;
    }
}