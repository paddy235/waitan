package com.bbd.wtyh.domain;

public class FinanceLeaseRiskDO extends BaseDO {
    private Integer companyId;

    private Integer riskStatus;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getRiskStatus() {
        return riskStatus;
    }

    public void setRiskStatus(Integer riskStatus) {
        this.riskStatus = riskStatus;
    }
}