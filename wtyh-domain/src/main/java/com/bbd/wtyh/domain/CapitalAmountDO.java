package com.bbd.wtyh.domain;

public class CapitalAmountDO extends BaseDO {
    private Integer typeId;

    private Float manageCapitalAmount;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Float getManageCapitalAmount() {
        return manageCapitalAmount;
    }

    public void setManageCapitalAmount(Float manageCapitalAmount) {
        this.manageCapitalAmount = manageCapitalAmount;
    }
}