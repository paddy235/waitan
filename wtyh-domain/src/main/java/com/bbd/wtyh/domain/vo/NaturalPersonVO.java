package com.bbd.wtyh.domain.vo;

import com.bbd.wtyh.domain.NaturalPersonDO;
import com.bbd.wtyh.excel.annotation.Excel;

/**
 * Created by Barney on 2017/7/4.
 */
public class NaturalPersonVO extends NaturalPersonDO {

    @Excel(exportName = "成立时间", sortNo = 4)
    private String regDate;
    @Excel(exportName = "法定代表人", sortNo = 5)
    private String legalPerson;
    @Excel(exportName = "注册资本", sortNo = 6)
    private String regCapital;
    private int regCapitalType;
    @Excel(exportName = "注册地址", sortNo = 7)
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
