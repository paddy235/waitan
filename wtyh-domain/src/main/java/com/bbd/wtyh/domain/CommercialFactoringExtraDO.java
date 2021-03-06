package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zhaodongjun on 2017/7/29 0029.
 */
@Table(name = "commercial_factoring_extra")
public class CommercialFactoringExtraDO extends BaseDO{
    @Id
    @Column(name = "company_id")
    private Integer companyId;
    //是否内资
    @Column(name = "domestic")
    private Integer domestic;
    //是否外资
    @Column(name = "foreign_owned")
    private Integer foreignOwned;

    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getDomestic() {
        return domestic;
    }

    public void setDomestic(Integer domestic) {
        this.domestic = domestic;
    }

    public Integer getForeignOwned() {
        return foreignOwned;
    }

    public void setForeignOwned(Integer foreignOwned) {
        this.foreignOwned = foreignOwned;
    }
}
