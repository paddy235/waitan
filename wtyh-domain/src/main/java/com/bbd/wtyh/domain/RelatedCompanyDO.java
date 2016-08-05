package com.bbd.wtyh.domain;

public class RelatedCompanyDO extends BaseDO {
    private Integer id;

    private Integer companyId;

    private Integer relatedCompanyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getRelatedCompanyId() {
        return relatedCompanyId;
    }

    public void setRelatedCompanyId(Integer relatedCompanyId) {
        this.relatedCompanyId = relatedCompanyId;
    }
}