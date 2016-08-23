package com.bbd.wtyh.domain.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class StaticRiskDTO implements Serializable {

	private String companyName; // 公司名称
	private String dataVersion; // 数据版本
	private Date riskDate; // 风险时间
	private BigDecimal stcRiskIndex; // 静态风险指数
	private BigDecimal maxComNum; // 单个一度关联自然人最大控制企业数量
	private BigDecimal avgPerNum; // 平均每位一度关联自然人控制企业数量
	private String oneLvlPer; // 核心一度关联自然人
	private BigDecimal realConRisk; // 实际控制人风险
	private BigDecimal cldComConPerNum; // 控股子公司自然人股东数量
	private BigDecimal cldCtlNum; // 控股子公司企业法人数量
	private String coreCldCom; // 核心子公司
	private BigDecimal comExpRisk; // 公司扩张路径风险
	private BigDecimal ctlCldComNum; // 控股子公司数量
	private BigDecimal oneComNum; // 一度关联企业数量
	private String conCom; // 控股子公司
	private BigDecimal relInRisk; // 关联方中心积聚化风险
	private BigDecimal thrPerNum; // 三度关联自然人节点数
	private BigDecimal twoComNum; // 二度关联企业法人节点数
	private String coreTwoCom; // 核心二度关联公司
	private BigDecimal illFinRisk; // 非法融资衍生风险
	private BigDecimal sixMonNewComNum; // 6个月以内新成立公司数量
	private BigDecimal toYearNewComNum; // 6个月~1年以内新成立公司数量
	private String sixMonNewCom; // 6个月以内新成立的公司
	private BigDecimal relCompanySum; // 关联方公司总数
	private BigDecimal shortRisk; // 短期逐利风险
	private BigDecimal investment; // 投资类
	private BigDecimal advisory; // 咨询类
	private BigDecimal trade; // 贸易类
	private BigDecimal lease; // 租赁类
	private BigDecimal factoring; // 保理类
	private String companyList; // 公司名单
	private BigDecimal illMoneyFinRisk; // 非法融资违规风险
	private BigDecimal underNum; // 本科人次
	private BigDecimal upperUnderNum; // 硕士以上人次(包括硕士)
	private BigDecimal flwUnderNum; // 本科以下人次
	private BigDecimal rectSum; // 招聘总人次
	private String top5RecSum; // top5岗位和招聘人次
	private BigDecimal perStructRisk; // 人才结构风险
	private String areaCode; // 地区编码

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDataVersion() {
		return dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

	public Date getRiskDate() {
		return riskDate;
	}

	public void setRiskDate(Date riskDate) {
		this.riskDate = riskDate;
	}

	public BigDecimal getStcRiskIndex() {
		return stcRiskIndex;
	}

	public void setStcRiskIndex(BigDecimal stcRiskIndex) {
		this.stcRiskIndex = stcRiskIndex;
	}

	public BigDecimal getMaxComNum() {
		return maxComNum;
	}

	public void setMaxComNum(BigDecimal maxComNum) {
		this.maxComNum = maxComNum;
	}

	public BigDecimal getAvgPerNum() {
		return avgPerNum;
	}

	public void setAvgPerNum(BigDecimal avgPerNum) {
		this.avgPerNum = avgPerNum;
	}

	public String getOneLvlPer() {
		return oneLvlPer;
	}

	public void setOneLvlPer(String oneLvlPer) {
		this.oneLvlPer = oneLvlPer;
	}

	public BigDecimal getRealConRisk() {
		return realConRisk;
	}

	public void setRealConRisk(BigDecimal realConRisk) {
		this.realConRisk = realConRisk;
	}

	public BigDecimal getCldComConPerNum() {
		return cldComConPerNum;
	}

	public void setCldComConPerNum(BigDecimal cldComConPerNum) {
		this.cldComConPerNum = cldComConPerNum;
	}

	public BigDecimal getCldCtlNum() {
		return cldCtlNum;
	}

	public void setCldCtlNum(BigDecimal cldCtlNum) {
		this.cldCtlNum = cldCtlNum;
	}

	public String getCoreCldCom() {
		return coreCldCom;
	}

	public void setCoreCldCom(String coreCldCom) {
		this.coreCldCom = coreCldCom;
	}

	public BigDecimal getComExpRisk() {
		return comExpRisk;
	}

	public void setComExpRisk(BigDecimal comExpRisk) {
		this.comExpRisk = comExpRisk;
	}

	public BigDecimal getCtlCldComNum() {
		return ctlCldComNum;
	}

	public void setCtlCldComNum(BigDecimal ctlCldComNum) {
		this.ctlCldComNum = ctlCldComNum;
	}

	public BigDecimal getOneComNum() {
		return oneComNum;
	}

	public void setOneComNum(BigDecimal oneComNum) {
		this.oneComNum = oneComNum;
	}

	public String getConCom() {
		return conCom;
	}

	public void setConCom(String conCom) {
		this.conCom = conCom;
	}

	public BigDecimal getRelInRisk() {
		return relInRisk;
	}

	public void setRelInRisk(BigDecimal relInRisk) {
		this.relInRisk = relInRisk;
	}

	public BigDecimal getThrPerNum() {
		return thrPerNum;
	}

	public void setThrPerNum(BigDecimal thrPerNum) {
		this.thrPerNum = thrPerNum;
	}

	public BigDecimal getTwoComNum() {
		return twoComNum;
	}

	public void setTwoComNum(BigDecimal twoComNum) {
		this.twoComNum = twoComNum;
	}

	public String getCoreTwoCom() {
		return coreTwoCom;
	}

	public void setCoreTwoCom(String coreTwoCom) {
		this.coreTwoCom = coreTwoCom;
	}

	public BigDecimal getIllFinRisk() {
		return illFinRisk;
	}

	public void setIllFinRisk(BigDecimal illFinRisk) {
		this.illFinRisk = illFinRisk;
	}

	public BigDecimal getSixMonNewComNum() {
		return sixMonNewComNum;
	}

	public void setSixMonNewComNum(BigDecimal sixMonNewComNum) {
		this.sixMonNewComNum = sixMonNewComNum;
	}

	public BigDecimal getToYearNewComNum() {
		return toYearNewComNum;
	}

	public void setToYearNewComNum(BigDecimal toYearNewComNum) {
		this.toYearNewComNum = toYearNewComNum;
	}

	public String getSixMonNewCom() {
		return sixMonNewCom;
	}

	public void setSixMonNewCom(String sixMonNewCom) {
		this.sixMonNewCom = sixMonNewCom;
	}

	public BigDecimal getRelCompanySum() {
		return relCompanySum;
	}

	public void setRelCompanySum(BigDecimal relCompanySum) {
		this.relCompanySum = relCompanySum;
	}

	public BigDecimal getShortRisk() {
		return shortRisk;
	}

	public void setShortRisk(BigDecimal shortRisk) {
		this.shortRisk = shortRisk;
	}

	public BigDecimal getInvestment() {
		return investment;
	}

	public void setInvestment(BigDecimal investment) {
		this.investment = investment;
	}

	public BigDecimal getAdvisory() {
		return advisory;
	}

	public void setAdvisory(BigDecimal advisory) {
		this.advisory = advisory;
	}

	public BigDecimal getTrade() {
		return trade;
	}

	public void setTrade(BigDecimal trade) {
		this.trade = trade;
	}

	public BigDecimal getLease() {
		return lease;
	}

	public void setLease(BigDecimal lease) {
		this.lease = lease;
	}

	public BigDecimal getFactoring() {
		return factoring;
	}

	public void setFactoring(BigDecimal factoring) {
		this.factoring = factoring;
	}

	public String getCompanyList() {
		return companyList;
	}

	public void setCompanyList(String companyList) {
		this.companyList = companyList;
	}

	public BigDecimal getIllMoneyFinRisk() {
		return illMoneyFinRisk;
	}

	public void setIllMoneyFinRisk(BigDecimal illMoneyFinRisk) {
		this.illMoneyFinRisk = illMoneyFinRisk;
	}

	public BigDecimal getUnderNum() {
		return underNum;
	}

	public void setUnderNum(BigDecimal underNum) {
		this.underNum = underNum;
	}

	public BigDecimal getUpperUnderNum() {
		return upperUnderNum;
	}

	public void setUpperUnderNum(BigDecimal upperUnderNum) {
		this.upperUnderNum = upperUnderNum;
	}

	public BigDecimal getFlwUnderNum() {
		return flwUnderNum;
	}

	public void setFlwUnderNum(BigDecimal flwUnderNum) {
		this.flwUnderNum = flwUnderNum;
	}

	public BigDecimal getRectSum() {
		return rectSum;
	}

	public void setRectSum(BigDecimal rectSum) {
		this.rectSum = rectSum;
	}

	public String getTop5RecSum() {
		return top5RecSum;
	}

	public void setTop5RecSum(String top5RecSum) {
		this.top5RecSum = top5RecSum;
	}

	public BigDecimal getPerStructRisk() {
		return perStructRisk;
	}

	public void setPerStructRisk(BigDecimal perStructRisk) {
		this.perStructRisk = perStructRisk;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}


}
