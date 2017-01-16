package com.bbd.wtyh.domain.wangDaiAPI;

import com.bbd.wtyh.domain.BaseDO;

public class CrowdFundingStatisticsDTO {

    private String amount;

    private String typeCN;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTypeCN() {
        return typeCN;
    }

    public void setTypeCN(String typeCN) {
        this.typeCN = typeCN;
    }
}