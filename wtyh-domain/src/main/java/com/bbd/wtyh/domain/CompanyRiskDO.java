package com.bbd.wtyh.domain;

public class CompanyRiskDO extends BaseDO {
    private Integer companyId;

    private Byte riskLevel;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Byte getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Byte riskLevel) {
        this.riskLevel = riskLevel;
    }
}