package com.bbd.wtyh.domain;


/**
 * Created by Administrator on 2017/9/5 0005.
 */
public class CompanyTagDO extends BaseDO{

    private String companyName;

    private Integer tag;

    private String tagDesc;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getTagDesc() {
        return tagDesc;
    }

    public void setTagDesc(String tagDesc) {
        this.tagDesc = tagDesc;
    }
}
