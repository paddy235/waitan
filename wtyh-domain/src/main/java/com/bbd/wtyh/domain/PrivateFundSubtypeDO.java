package com.bbd.wtyh.domain;

public class PrivateFundSubtypeDO {
    private Byte subTypeId;

    private String typeName;

    public Byte getSubTypeId() {
        return subTypeId;
    }

    public void setSubTypeId(Byte subTypeId) {
        this.subTypeId = subTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
}