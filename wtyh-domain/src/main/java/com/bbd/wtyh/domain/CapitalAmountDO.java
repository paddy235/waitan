package com.bbd.wtyh.domain;

public class CapitalAmountDO extends BaseDO {
    private Integer typeId;

    private Float managedCapitalAmount;

    private Integer publishCompanyNumber;

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