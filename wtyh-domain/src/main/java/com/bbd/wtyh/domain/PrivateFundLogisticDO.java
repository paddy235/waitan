package com.bbd.wtyh.domain;

public class PrivateFundLogisticDO {
    private Byte typeId;

    private Byte subTypeId;

    private Integer amount;

    public Byte getTypeId() {
        return typeId;
    }

    public void setTypeId(Byte typeId) {
        this.typeId = typeId;
    }

    public Byte getSubTypeId() {
        return subTypeId;
    }

    public void setSubTypeId(Byte subTypeId) {
        this.subTypeId = subTypeId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}