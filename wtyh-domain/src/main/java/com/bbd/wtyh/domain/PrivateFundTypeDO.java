package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "private_fund_type")
public class PrivateFundTypeDO extends BaseDO {
    @Id
    @Column(name = "type_id")
    private Byte typeId;

    @Column(name = "type_parent_id")
    private Byte typeParentId;

    @Column(name = "type_name")
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