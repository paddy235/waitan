package com.bbd.wtyh.domain;

public class PrivateFundLogisticDO extends BaseDO {
    private Byte typeId;

    private Integer amount;

    public Byte getTypeId() {
        return typeId;
    }

    public void setTypeId(Byte typeId) {
        this.typeId = typeId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}