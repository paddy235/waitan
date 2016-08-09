package com.bbd.wtyh.web.relationVO;

public class CompanyDataStatisticsVO {
	
	private String capital;	   //注册资本
	
	private String registation;//登记状态
	
	private String legalPersonNodes;//法人节点数
	
	private String naturalPersonNode;//自然人节点数
	
	private String naturalPersonShareholders; //自然人股东数
	
	private String legalPersonShareholders;//法人股东数
	
	private String subsidiarys;//子公司数
	
	private String litigationRecord;//诉讼记录

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getRegistation() {
		return registation;
	}

	public void setRegistation(String registation) {
		this.registation = registation;
	}

	public String getLegalPersonNodes() {
		return legalPersonNodes;
	}

	public void setLegalPersonNodes(String legalPersonNodes) {
		this.legalPersonNodes = legalPersonNodes;
	}

	public String getNaturalPersonNode() {
		return naturalPersonNode;
	}

	public void setNaturalPersonNode(String naturalPersonNode) {
		this.naturalPersonNode = naturalPersonNode;
	}

	public String getNaturalPersonShareholders() {
		return naturalPersonShareholders;
	}

	public void setNaturalPersonShareholders(String naturalPersonShareholders) {
		this.naturalPersonShareholders = naturalPersonShareholders;
	}

	public String getLegalPersonShareholders() {
		return legalPersonShareholders;
	}

	public void setLegalPersonShareholders(String legalPersonShareholders) {
		this.legalPersonShareholders = legalPersonShareholders;
	}

	public String getSubsidiarys() {
		return subsidiarys;
	}

	public void setSubsidiarys(String subsidiarys) {
		this.subsidiarys = subsidiarys;
	}

	public String getLitigationRecord() {
		return litigationRecord;
	}

	public void setLitigationRecord(String litigationRecord) {
		this.litigationRecord = litigationRecord;
	}
	
	
}
