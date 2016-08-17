package com.bbd.wtyh.domain;

/**
 * Created by Marco on 2016/8/8.
 */
public class RelatedCompanyStatisticDO extends BaseDO{
    private String area_name;
    private String related_company;

    public RelatedCompanyStatisticDO() {
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getRelated_company() {
        return related_company;
    }

    public void setRelated_company(String related_company) {
        this.related_company = related_company;
    }
}
