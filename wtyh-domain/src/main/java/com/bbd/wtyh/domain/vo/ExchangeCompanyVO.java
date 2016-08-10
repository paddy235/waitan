package com.bbd.wtyh.domain.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ExchangeCompanyVO implements Serializable {

	private String name;

	private String approveDepartment;

	private String superviseDepartment;

	private String legalPerson;

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
		this.approveDepartment = approveDepartment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
