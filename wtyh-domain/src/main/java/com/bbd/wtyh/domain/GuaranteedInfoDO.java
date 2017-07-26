package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "guaranteed_info")
public class GuaranteedInfoDO extends BaseDO {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "guarantee_id")
    private Integer guaranteeId;
    @Column(name = "guaranteed_id")
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