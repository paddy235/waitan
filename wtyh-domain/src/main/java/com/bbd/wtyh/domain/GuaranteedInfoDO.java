package com.bbd.wtyh.domain;

public class GuaranteedInfoDO extends BaseDO {
    private Integer id;

    private Integer guaranteeId;

    private Integer guaranteedId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(Integer guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public Integer getGuaranteedId() {
        return guaranteedId;
    }

    public void setGuaranteedId(Integer guaranteedId) {
        this.guaranteedId = guaranteedId;
    }
}