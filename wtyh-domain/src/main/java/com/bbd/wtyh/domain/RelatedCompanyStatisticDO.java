package com.bbd.wtyh.domain;

/**
 * Created by Marco on 2016/8/8.
 */
public class RelatedCompanyStatisticDO {
    private String areaName;
    private int relatedCompany;

    public RelatedCompanyStatisticDO() {
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getRelatedCompany() {
        return relatedCompany;
    }

    public void setRelatedCompany(int relatedCompany) {
        this.relatedCompany = relatedCompany;
    }
}
