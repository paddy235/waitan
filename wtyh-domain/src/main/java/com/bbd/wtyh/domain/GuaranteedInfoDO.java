package com.bbd.wtyh.domain;

public class GuaranteedInfoDO extends BaseDO {
    private Integer id;

    private Integer guaranteeCompany;

    private Integer guaranteedCompany;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGuaranteeCompany() {
        return guaranteeCompany;
    }

    public void setGuaranteeCompany(Integer guaranteeCompany) {
        this.guaranteeCompany = guaranteeCompany;
    }

    public Integer getGuaranteedCompany() {
        return guaranteedCompany;
    }

    public void setGuaranteedCompany(Integer guaranteedCompany) {
        this.guaranteedCompany = guaranteedCompany;
    }
}