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
	private Integer riskA;//
	private Integer riskB;//
	private Integer riskC;//
	private Integer riskD;//

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

	public Integer getRiskA() {
		return riskA;
	}

	public void setRiskA(Integer riskA) {
		this.riskA = riskA;
	}

	public Integer getRiskB() {
		return riskB;
	}

	public void setRiskB(Integer riskB) {
		this.riskB = riskB;
	}

	public Integer getRiskC() {
		return riskC;
	}

	public void setRiskC(Integer riskC) {
		this.riskC = riskC;
	}

	public Integer getRiskD() {
		return riskD;
	}

	public void setRiskD(Integer riskD) {
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
