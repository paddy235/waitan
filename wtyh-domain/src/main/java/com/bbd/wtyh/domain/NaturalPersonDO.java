package com.bbd.wtyh.domain;

import javax.persistence.Column;

/**
 * Created by Barney on 2017/7/4.
 */
public class NaturalPersonDO extends BaseDO {

    @Column(name = "person_name")
    private String personName;
    @Column(name = "duty")
    private String duty;
    @Column(name = "duty_code")
    private String dutyCode;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "status")
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
