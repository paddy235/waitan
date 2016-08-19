package com.bbd.wtyh.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.beans.Transient;
import java.io.Serializable;

@SuppressWarnings("serial")
public class FinanceLeaseVO implements Serializable {

	private String companyName;// 公司或自然人名称
	private String address;//
	private String status;//
	private Integer riskStatus;
	private Integer riskStatusA;//
	private Integer riskStatusB;//
	private Integer riskStatusC;//
	private Integer riskStatusD;//



	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public Integer getRiskStatus() {
		return riskStatus;
	}

	public void setRiskStatus(Integer riskStatus) {
		this.riskStatus = riskStatus;
	}

	public Integer getRiskStatusA() {
		return riskStatusA;
	}

	public void setRiskStatusA(Integer riskStatusA) {
		this.riskStatusA = riskStatusA;
	}

	public Integer getRiskStatusB() {
		return riskStatusB;
	}

	public void setRiskStatusB(Integer riskStatusB) {
		this.riskStatusB = riskStatusB;
	}

	public Integer getRiskStatusC() {
		return riskStatusC;
	}

	public void setRiskStatusC(Integer riskStatusC) {
		this.riskStatusC = riskStatusC;
	}

	public Integer getRiskStatusD() {
		return riskStatusD;
	}

	public void setRiskStatusD(Integer riskStatusD) {
		this.riskStatusD = riskStatusD;
	}
}
