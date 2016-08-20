package com.bbd.wtyh.domain.dto;

import java.io.Serializable;

/**
 * Created by Marco on 2016/8/8.
 */
public class ShareholderRiskDTO implements Serializable{

    private Integer companyId;
    private String companyName;
    private Integer p2p;
    private Integer privateFund;
    private Integer offlineFinance;


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getP2p() {
        return p2p;
    }

    public void setP2p(Integer p2p) {
        this.p2p = p2p;
    }

    public Integer getPrivateFund() {
        return privateFund;
    }

    public void setPrivateFund(Integer privateFund) {
        this.privateFund = privateFund;
    }

    public Integer getOfflineFinance() {
        return offlineFinance;
    }

    public void setOfflineFinance(Integer offlineFinance) {
        this.offlineFinance = offlineFinance;
    }
}
