package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "finance_lease_extra")
public class FinanceLeaseExtraDO extends BaseDO {
    @Id
    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "free_trade_zone")
    private boolean freeTradeZone;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public boolean isFreeTradeZone() {
        return freeTradeZone;
    }

    public void setFreeTradeZone(boolean freeTradeZone) {
        this.freeTradeZone = freeTradeZone;
    }
}