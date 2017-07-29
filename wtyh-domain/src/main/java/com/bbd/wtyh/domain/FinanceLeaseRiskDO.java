package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "finance_lease_risk")
public class FinanceLeaseRiskDO extends BaseDO {
    @Id
    @Column(name = "id")
    Integer mkId;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "risk_type")
    private Integer riskType;

    @Column(name = "risk_status")
    private Integer riskStatus;

    public Integer getMkId() {
        return mkId;
    }

    public void setMkId(Integer mkId) {
        this.mkId = mkId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getRiskType() {
        return riskType;
    }

    public void setRiskType(Integer riskType) {
        this.riskType = riskType;
    }

    public Integer getRiskStatus() {
        return riskStatus;
    }

    public void setRiskStatus(Integer riskStatus) {
        this.riskStatus = riskStatus;
    }
}