package com.bbd.wtyh.domain.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FinanceLeaseStatisticVO implements Serializable {
	private Integer year;

	private Integer companyNumber;

	private Integer registeredCapitalType;

	private Integer registeredCapital;

	public Integer getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(Integer registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(Integer companyNumber) {
		this.companyNumber = companyNumber;
	}

	public Integer getRegisteredCapitalType() {
		return registeredCapitalType;
	}

	public void setRegisteredCapitalType(Integer registeredCapitalType) {
		this.registeredCapitalType = registeredCapitalType;
	}
}
