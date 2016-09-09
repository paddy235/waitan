package com.bbd.wtyh.domain;

/**
 * @author Marco
 */
public class PrivateFundExtraDO extends BaseDO {
    private Integer companyId;

    private String website;

    private Integer paidinCapital;

    private Integer managedFund;

    private Integer recordStatus;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
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