package com.bbd.wtyh.domain;

import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class RiskCompanyInfoDO extends BaseDO {

	private String area; // 区域
	private BigDecimal regCapital; // 注册资本（万元）
	private String companyQualification; // 公司资质（上市公司背景、国企背景）
	private String companyName; // 公司名称
	private BigDecimal staticRiskIndex; // 静态风险指数
	private BigDecimal dynamicRiskIndex; // 动态风险指数
	private String legalRpt; // 法人代表
	private String companyType; // 公司类型
	private Integer reviewTime; // 续存时间
	private String isRise; // 风险指数是否上升（1：上升；0：持平；-1：下降）
	private Date regDate; // 注册时间
	
	private String regDateStr;
	private int ranking;
	private Integer riskLevel;
	private String address;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public BigDecimal getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(BigDecimal regCapital) {
		this.regCapital = regCapital;
	}

	public String getCompanyQualification() {
		return companyQualification;
	}

	public void setCompanyQualification(String companyQualification) {
		this.companyQualification = companyQualification;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public BigDecimal getStaticRiskIndex() {
		if (null != staticRiskIndex) {
			return staticRiskIndex.divide(BigDecimal.ONE, 1, BigDecimal.ROUND_HALF_UP);
		}
		return staticRiskIndex;
	}

	public void setStaticRiskIndex(BigDecimal staticRiskIndex) {
		this.staticRiskIndex = staticRiskIndex;
	}

	public BigDecimal getDynamicRiskIndex() {
		if (null != dynamicRiskIndex) {
			return dynamicRiskIndex.divide(BigDecimal.ONE, 1, BigDecimal.ROUND_HALF_UP);
		}
		return dynamicRiskIndex;
	}

	public void setDynamicRiskIndex(BigDecimal dynamicRiskIndex) {
		this.dynamicRiskIndex = dynamicRiskIndex;
	}

	public String getLegalRpt() {
		return legalRpt;
	}

	public void setLegalRpt(String legalRpt) {
		this.legalRpt = legalRpt;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public Integer getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(Integer reviewTime) {
		this.reviewTime = reviewTime;
	}

	public String getIsRise() {
		return isRise;
	}

	public void setIsRise(String isRise) {
		this.isRise = isRise;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getRegDateStr() {
		return regDateStr;
	}

	public void setRegDateStr(String regDateStr) {
		this.regDateStr = regDateStr;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public Integer getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(Integer riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
