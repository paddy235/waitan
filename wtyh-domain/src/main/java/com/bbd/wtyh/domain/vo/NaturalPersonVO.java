package com.bbd.wtyh.domain.vo;

import com.bbd.wtyh.domain.NaturalPersonDO;

/**
 * Created by Barney on 2017/7/4.
 */
public class NaturalPersonVO extends NaturalPersonDO {

    private String regDate;
    private String legalPerson;
    private String regCapital;
    private int regCapitalType;
    private String regAddress;

    public int getRegCapitalType() {
        return regCapitalType;
    }

    public void setRegCapitalType(int regCapitalType) {
        this.regCapitalType = regCapitalType;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital;
    }

    public String getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
    }

}
