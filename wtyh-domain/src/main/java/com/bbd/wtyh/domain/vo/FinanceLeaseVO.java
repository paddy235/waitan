package com.bbd.wtyh.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.beans.Transient;
import java.io.Serializable;

@SuppressWarnings("serial")
public class FinanceLeaseVO implements Serializable {

	private String companyName;// 公司或自然人名称
	private String address;//
	private Integer riskType;
	private Integer riskStatus;//
	private String otherQuestion;


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

	public String getOtherQuestion() {
		return otherQuestion;
	}

	public void setOtherQuestion(String otherQuestion) {
		this.otherQuestion = otherQuestion;
	}
}
