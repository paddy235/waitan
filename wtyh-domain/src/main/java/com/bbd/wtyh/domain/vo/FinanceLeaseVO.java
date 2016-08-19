package com.bbd.wtyh.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.beans.Transient;
import java.io.Serializable;

@SuppressWarnings("serial")
public class FinanceLeaseVO implements Serializable {

	private String company;// 公司或自然人名称
	private String address;//
	private String status;//
	@JsonIgnore
	private Integer riskType;//
	@JsonIgnore
	private Integer riskStatus;
	private String riskA;//
	private String riskB;//
	private String riskC;//
	private String riskD;//

	public Integer getRiskType() {
		return riskType;
	}

	public void setRiskType(Integer riskType) {
		this.riskType = riskType;
	}

	public Integer getRiskStatus() {
		return riskStatus;
	}

	public void setRiskStatus(Integer riskStatus) {
		this.riskStatus = riskStatus;
	}

	public String getRiskA() {
		return riskA;
	}

	public void setRiskA(String riskA) {
		this.riskA = riskA;
	}

	public String getRiskB() {
		return riskB;
	}

	public void setRiskB(String riskB) {
		this.riskB = riskB;
	}

	public String getRiskC() {
		return riskC;
	}

	public void setRiskC(String riskC) {
		this.riskC = riskC;
	}

	public String getRiskD() {
		return riskD;
	}

	public void setRiskD(String riskD) {
		this.riskD = riskD;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
