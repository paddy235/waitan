package com.bbd.wtyh.domain.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FinanceLeasecCompanyVO implements Serializable {

	private String companyName;// 公司或自然人名称
	private String address;//
	private String riskStatus;
	private String riskStatusA;//
	private String riskStatusB;//
	private String riskStatusC;//
	private String riskStatusD;//
	private String otherQuertion;//



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

	public String getRiskStatus() {
		return riskStatus;
	}

	public void setRiskStatus(String riskStatus) {
		this.riskStatus = riskStatus;
	}

	public String getRiskStatusA() {
		return riskStatusA;
	}

	public void setRiskStatusA(String riskStatusA) {
		this.riskStatusA = riskStatusA;
	}

	public String getRiskStatusB() {
		return riskStatusB;
	}

	public void setRiskStatusB(String riskStatusB) {
		this.riskStatusB = riskStatusB;
	}

	public String getRiskStatusC() {
		return riskStatusC;
	}

	public void setRiskStatusC(String riskStatusC) {
		this.riskStatusC = riskStatusC;
	}

	public String getRiskStatusD() {
		return riskStatusD;
	}

	public void setRiskStatusD(String riskStatusD) {
		this.riskStatusD = riskStatusD;
	}

	public String getOtherQuertion() {
		return otherQuertion;
	}

	public void setOtherQuertion(String otherQuertion) {
		this.otherQuertion = otherQuertion;
	}
}
