package com.bbd.wtyh.domain.vo;

public class SearchResultVO {

	private String companyName; // 公司名称
	private int relSum; // 关联方总数
	private int rel1; // 1度关联方
	private int rel2; // 2度关联方
	private String legalPerson; // 法人代表
	private String regDate; // 注册时间

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getRelSum() {
		return relSum;
	}

	public void setRelSum(int relSum) {
		this.relSum = relSum;
	}

	public int getRel1() {
		return rel1;
	}

	public void setRel1(int rel1) {
		this.rel1 = rel1;
	}

	public int getRel2() {
		return rel2;
	}

	public void setRel2(int rel2) {
		this.rel2 = rel2;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

}
