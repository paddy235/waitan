package com.bbd.wtyh.domain.query;

import java.io.Serializable;

/**
 * Created by Barney on 2017/7/5.
 */
public class NaturalPersonQuery implements Serializable {

    private int dutyCode;
    private String personName;
    private String companyName;
    private int status;

    public int getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(int dutyCode) {
        this.dutyCode = dutyCode;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
