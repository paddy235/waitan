package com.bbd.wtyh.domain;

/**
 * Created by Marco on 2016/8/8.
 */
public class RelatedCompanyStatisticDO extends BaseDO{
    private String areaName;
    private Integer relatedCompany;

    public RelatedCompanyStatisticDO() {
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getRelatedCompany() {
        return relatedCompany;
    }

    public void setRelatedCompany(Integer relatedCompany) {
        this.relatedCompany = relatedCompany;
    }
}
