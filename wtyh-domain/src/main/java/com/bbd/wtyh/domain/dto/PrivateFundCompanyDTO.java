package com.bbd.wtyh.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Marco on 2016/9/9.
 */
public class PrivateFundCompanyDTO {

    private Integer companyId;

    private String name;

    private String website;

    private Integer registeredCapital;

    @JsonFormat(pattern = "yyyyMMdd", timezone = "GMT+8")
    private Date registeredDate;

    private Integer paidinCapital;

    private Integer managedFund;

    private Integer recordStatus;


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(Integer registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Integer getPaidinCapital() {
        return paidinCapital;
    }

    public void setPaidinCapital(Integer paidinCapital) {
        this.paidinCapital = paidinCapital;
    }

    public Integer getManagedFund() {
        return managedFund;
    }

    public void setManagedFund(Integer managedFund) {
        this.managedFund = managedFund;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }
}
