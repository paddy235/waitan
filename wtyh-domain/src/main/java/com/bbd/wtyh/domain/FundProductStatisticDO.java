package com.bbd.wtyh.domain;

public class FundProductStatisticDO extends BaseDO {
    private Integer productTypeId;

    private Integer productNumber;

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }
}