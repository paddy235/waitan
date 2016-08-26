package com.bbd.wtyh.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class CompanySearchVO implements Serializable {

	private String name;
	private String legalPerson;
	private String address;
	private String registeredCapital;
	private Integer registeredCapitalType;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date registeredDate;
	private Byte companyType;
	private BigDecimal staticRisk;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(String registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public Integer getRegisteredCapitalType() {
		return registeredCapitalType;
	}

	public void setRegisteredCapitalType(Integer registeredCapitalType) {
		this.registeredCapitalType = registeredCapitalType;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public Byte getCompanyType() {
		return companyType;
	}

	public void setCompanyType(Byte companyType) {
		this.companyType = companyType;
	}

	public BigDecimal getStaticRisk() {
		return staticRisk;
	}

	public void setStaticRisk(BigDecimal staticRisk) {
		this.staticRisk = staticRisk;
	}
}
