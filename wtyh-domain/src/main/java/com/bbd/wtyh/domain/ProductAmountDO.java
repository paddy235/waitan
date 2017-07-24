package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;

public class ProductAmountDO extends BaseDO {

    @Id
    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "product_number")
    private Integer productNumber;

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

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }
}