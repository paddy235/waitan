package com.bbd.wtyh.domain;

public class PrivateFundTypeDO extends BaseDO {
    private Byte typeId;

    private Byte typeParentId;

    private String typeName;

    public Byte getTypeId() {
        return typeId;
    }

    public void setTypeId(Byte typeId) {
        this.typeId = typeId;
    }

    public Byte getTypeParentId() {
        return typeParentId;
    }

    public void setTypeParentId(Byte typeParentId) {
        this.typeParentId = typeParentId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
}