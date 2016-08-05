package com.bbd.wtyh.domain;

public class CompanyBackgroundDO extends BaseDO {
    private Integer id;

    private Integer companyId;

    private Byte background;

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

    public Byte getBackground() {
        return background;
    }

    public void setBackground(Byte background) {
        this.background = background;
    }
}