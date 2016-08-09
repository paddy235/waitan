package com.bbd.wtyh.domain;

/**
 * Created by Marco on 2016/8/8.
 */
public class RelatedCompanyStatisticDO {

    private Integer companyId;
    private Integer companyType;
    private Integer amount;


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
