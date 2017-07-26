package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Marco
 */
@Table(name = "private_fund_extra")
public class PrivateFundExtraDO extends BaseDO {
    @Id
    @Column(name = "company_id")
    private Integer companyId;
    @Column(name = "website")
    private String website;//机构网站
    @Column(name = "paidin_capital")
    private Integer paidinCapital;//实缴资本
    @Column(name = "managed_fund")
    private Integer managedFund;//管理基金数量
    @Column(name = "record_status")
    private Integer recordStatus;//备案状态

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