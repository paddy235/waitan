package com.bbd.wtyh.domain;

/**
 * Created by yanwenyuan on 2016/9/9.
 */
public class RelatedSubsidiaryStatisticDO extends BaseDO{
    private String areaName;
    private Integer relatedSubsidiary;

    public RelatedSubsidiaryStatisticDO() {
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getRelatedSubsidiary() {
        return relatedSubsidiary;
    }

    public void setRelatedSubsidiary(Integer relatedSubsidiary) {
        this.relatedSubsidiary = relatedSubsidiary;
    }
}
