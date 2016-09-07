package com.bbd.wtyh.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ExchangeCompanyVO implements Serializable {

	private String name;

	private String approveDepartment;

	private String superviseDepartment;

	private String website;

	private Integer riskLevel;

	public Integer getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(Integer riskLevel) {
		this.riskLevel = riskLevel;
	}

	private String legalPerson;

	private String address;

	private Integer registeredCapital;

	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date registeredDate;

	public String getSuperviseDepartment() {
		return superviseDepartment;
	}

	public void setSuperviseDepartment(String superviseDepartment) {
		this.superviseDepartment = superviseDepartment;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getApproveDepartment() {
		return approveDepartment;
	}

	public void setApproveDepartment(String approveDepartment) {
		if (StringUtils.isEmpty(approveDepartment)) {
			this.approveDepartment = null;
		} else {
			this.approveDepartment = approveDepartment;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
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

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
}
