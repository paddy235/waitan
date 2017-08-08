package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "exchange_company")
public class ExchangeCompanyDO extends BaseDO {
    @Id
    @Column(name = "company_id")
    private Integer companyId;

    private String approveDepartment;

    private String superviseDepartment;

    private Byte status;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getApproveDepartment() {
        return approveDepartment;
    }

    public void setApproveDepartment(String approveDepartment) {
        this.approveDepartment = approveDepartment == null ? null : approveDepartment.trim();
    }

    public String getSuperviseDepartment() {
        return superviseDepartment;
    }

    public void setSuperviseDepartment(String superviseDepartment) {
        this.superviseDepartment = superviseDepartment == null ? null : superviseDepartment.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}