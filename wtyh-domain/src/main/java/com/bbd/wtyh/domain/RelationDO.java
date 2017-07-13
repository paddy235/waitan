package com.bbd.wtyh.domain;

/**
 * Created by Barney on 2017/7/12.
 */
public class RelationDO extends BaseDO {

    private String targetCompany;
    private String investors;
    private String investee;
    private String relationship;
    private int investorsNo;
    private int investeeNo;

    public String getTargetCompany() {
        return targetCompany;
    }

    public void setTargetCompany(String targetCompany) {
        this.targetCompany = targetCompany;
    }

    public String getInvestors() {
        return investors;
    }

    public void setInvestors(String investors) {
        this.investors = investors;
    }

    public String getInvestee() {
        return investee;
    }

    public void setInvestee(String investee) {
        this.investee = investee;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public int getInvestorsNo() {
        return investorsNo;
    }

    public void setInvestorsNo(int investorsNo) {
        this.investorsNo = investorsNo;
    }

    public int getInvesteeNo() {
        return investeeNo;
    }

    public void setInvesteeNo(int investeeNo) {
        this.investeeNo = investeeNo;
    }
}
