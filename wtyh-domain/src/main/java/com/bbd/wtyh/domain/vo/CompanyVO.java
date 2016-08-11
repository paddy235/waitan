package com.bbd.wtyh.domain.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CompanyVO implements Serializable {

	private String company;// 公司或自然人名称
	private int relationNumber;// 关联度数
	private boolean isCompany=true;
	private boolean isInfected = false;//是否补感染
	private boolean appearFirst=false;//在关联方返回的数据中，是否出现过在第一列



	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getRelationNumber() {
		return relationNumber;
	}

	public void setRelationNumber(int relationNumber) {
		this.relationNumber = relationNumber;
	}

	public boolean getIsInfected() {
		return isInfected;
	}

	public void setIsInfected(boolean isInfected) {
		this.isInfected = isInfected;
	}

	public boolean getIsCompany() {
		return isCompany;
	}

	public void setIsCompany(boolean isCompany) {
		this.isCompany = isCompany;
	}

	public boolean getAppearFirst() {
		return appearFirst;
	}

	public void setAppearFirst(boolean appearFirst) {
		this.appearFirst = appearFirst;
	}


}
