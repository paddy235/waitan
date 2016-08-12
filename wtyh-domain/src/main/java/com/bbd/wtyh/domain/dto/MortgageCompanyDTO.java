package com.bbd.wtyh.domain.dto;

/**
 * Created by Marco on 2016/8/11.
 */
public class MortgageCompanyDTO {

    private Integer companyId;

    private String companyName;

    private String legalPerson;

    private String address;

    private Integer registeredCapital;

    private Integer registeredCapitalType;


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

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(Integer registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public Integer getRegisteredCapitalType() {
        return registeredCapitalType;
    }

    public void setRegisteredCapitalType(Integer registeredCapitalType) {
        this.registeredCapitalType = registeredCapitalType;
    }
}
