package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "capital_amount")
public class CapitalAmountDO extends BaseDO {
    @Id
    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "managed_capital_amount")
    private Float managedCapitalAmount;

    @Column(name = "publish_company_number")
    private Integer publishCompanyNumber;

    ////////////not in mysql
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Float getManagedCapitalAmount() {
        return managedCapitalAmount;
    }

    public void setManagedCapitalAmount(Float managedCapitalAmount) {
        this.managedCapitalAmount = managedCapitalAmount;
    }

    public Integer getPublishCompanyNumber() {
        return publishCompanyNumber;
    }

    public void setPublishCompanyNumber(Integer publishCompanyNumber) {
        this.publishCompanyNumber = publishCompanyNumber;
    }
}