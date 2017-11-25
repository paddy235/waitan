package com.bbd.wtyh.domain.vo;

public class StaticRiskVO {

	private String companyName; // 公司名称
	private String dataVersion; // 数据版本
	private String stcRiskIndex; // 静态风险指数
	private String maxComNum; // 单个一度关联自然人最大控制企业数量
	private String avgPerNum; // 平均每位一度关联自然人控制企业数量
	private String oneLvlPer; // 核心一度关联自然人
	private String realConRisk; // 实际控制人风险
	private String cldComConPerNum; // 控股子公司自然人股东数量
	private String cldCtlNum; // 控股子公司企业法人数量
	private String coreCldCom; // 核心子公司
	private String comExpRisk; // 公司扩张路径风险
	private String ctlCldComNum; // 控股子公司数量
	private String oneComNum; // 一度关联企业数量
	private String conCom; // 控股子公司
	private String relInRisk; // 关联方中心积聚化风险
	private String thrPerNum; // 三度关联自然人节点数
	private String twoComNum; // 二度关联企业法人节点数
	private String coreTwoCom; // 核心二度关联公司
	private String illFinRisk; // 非法融资衍生风险
	private String sixMonNewComNum; // 6个月以内新成立公司数量
	private String toYearNewComNum; // 6个月~1年以内新成立公司数量
	private String sixMonNewCom; // 6个月以内新成立的公司
	private String relCompanySum; // 关联方公司总数
	private String shortRisk; // 短期逐利风险
	private String investment; // 投资类
	private String advisory; // 咨询类
	private String trade; // 贸易类
	private String lease; // 租赁类
	private String factoring; // 保理类
	private String companyList; // 公司名单
	private String illMoneyFinRisk; // 非法融资违规风险
	private String underNum; // 本科人次
	private String upperUnderNum; // 硕士以上人次(包括硕士)
	private String flwUnderNum; // 本科以下人次
	private String rectSum; // 招聘总人次
	private String top5RecSum; // top5岗位和招聘人次
	private String perStructRisk; // 人才结构风险
	private String rise; // 当前风险指数是否上升
	private String areaCode; // 地区代码

	//新增上海四个参数
	private String normalHousehold;//上海非正常户认定

	private String UnpaidInsurancePremium;//上海用人单位欠缴社会保险费

	private String DiscreditExposure;//上海失信曝光

	private String AdministrativeSanction;//上海市场监管类行政处罚

	public String getNormalHousehold() {
		return normalHousehold;
	}

	public void setNormalHousehold(String normalHousehold) {
		this.normalHousehold = normalHousehold;
	}

	public String getUnpaidInsurancePremium() {
		return UnpaidInsurancePremium;
	}

	public void setUnpaidInsurancePremium(String unpaidInsurancePremium) {
		UnpaidInsurancePremium = unpaidInsurancePremium;
	}

	public String getDiscreditExposure() {
		return DiscreditExposure;
	}

	public void setDiscreditExposure(String discreditExposure) {
		DiscreditExposure = discreditExposure;
	}

	public String getAdministrativeSanction() {
		return AdministrativeSanction;
	}

	public void setAdministrativeSanction(String administrativeSanction) {
		AdministrativeSanction = administrativeSanction;
	}

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

	public String getStcRiskIndex() {
		return stcRiskIndex;
	}

	public void setStcRiskIndex(String stcRiskIndex) {
		this.stcRiskIndex = stcRiskIndex;
	}

	public String getMaxComNum() {
		return maxComNum;
	}

	public void setMaxComNum(String maxComNum) {
		this.maxComNum = maxComNum;
	}

	public String getAvgPerNum() {
		return avgPerNum;
	}

	public void setAvgPerNum(String avgPerNum) {
		this.avgPerNum = avgPerNum;
	}

	public String getOneLvlPer() {
		return oneLvlPer;
	}

	public void setOneLvlPer(String oneLvlPer) {
		this.oneLvlPer = oneLvlPer;
	}

	public String getRealConRisk() {
		return realConRisk;
	}

	public void setRealConRisk(String realConRisk) {
		this.realConRisk = realConRisk;
	}

	public String getCldComConPerNum() {
		return cldComConPerNum;
	}

	public void setCldComConPerNum(String cldComConPerNum) {
		this.cldComConPerNum = cldComConPerNum;
	}

	public String getCldCtlNum() {
		return cldCtlNum;
	}

	public void setCldCtlNum(String cldCtlNum) {
		this.cldCtlNum = cldCtlNum;
	}

	public String getCoreCldCom() {
		return coreCldCom;
	}

	public void setCoreCldCom(String coreCldCom) {
		this.coreCldCom = coreCldCom;
	}

	public String getComExpRisk() {
		return comExpRisk;
	}

	public void setComExpRisk(String comExpRisk) {
		this.comExpRisk = comExpRisk;
	}

	public String getCtlCldComNum() {
		return ctlCldComNum;
	}

	public void setCtlCldComNum(String ctlCldComNum) {
		this.ctlCldComNum = ctlCldComNum;
	}

	public String getOneComNum() {
		return oneComNum;
	}

	public void setOneComNum(String oneComNum) {
		this.oneComNum = oneComNum;
	}

	public String getConCom() {
		return conCom;
	}

	public void setConCom(String conCom) {
		this.conCom = conCom;
	}

	public String getRelInRisk() {
		return relInRisk;
	}

	public void setRelInRisk(String relInRisk) {
		this.relInRisk = relInRisk;
	}

	public String getThrPerNum() {
		return thrPerNum;
	}

	public void setThrPerNum(String thrPerNum) {
		this.thrPerNum = thrPerNum;
	}

	public String getTwoComNum() {
		return twoComNum;
	}

	public void setTwoComNum(String twoComNum) {
		this.twoComNum = twoComNum;
	}

	public String getCoreTwoCom() {
		return coreTwoCom;
	}

	public void setCoreTwoCom(String coreTwoCom) {
		this.coreTwoCom = coreTwoCom;
	}

	public String getIllFinRisk() {
		return illFinRisk;
	}

	public void setIllFinRisk(String illFinRisk) {
		this.illFinRisk = illFinRisk;
	}

	public String getSixMonNewComNum() {
		return sixMonNewComNum;
	}

	public void setSixMonNewComNum(String sixMonNewComNum) {
		this.sixMonNewComNum = sixMonNewComNum;
	}

	public String getToYearNewComNum() {
		return toYearNewComNum;
	}

	public void setToYearNewComNum(String toYearNewComNum) {
		this.toYearNewComNum = toYearNewComNum;
	}

	public String getSixMonNewCom() {
		return sixMonNewCom;
	}

	public void setSixMonNewCom(String sixMonNewCom) {
		this.sixMonNewCom = sixMonNewCom;
	}

	public String getRelCompanySum() {
		return relCompanySum;
	}

	public void setRelCompanySum(String relCompanySum) {
		this.relCompanySum = relCompanySum;
	}

	public String getShortRisk() {
		return shortRisk;
	}

	public void setShortRisk(String shortRisk) {
		this.shortRisk = shortRisk;
	}

	public String getInvestment() {
		return investment;
	}

	public void setInvestment(String investment) {
		this.investment = investment;
	}

	public String getAdvisory() {
		return advisory;
	}

	public void setAdvisory(String advisory) {
		this.advisory = advisory;
	}

	public String getTrade() {
		return trade;
	}

	public void setTrade(String trade) {
		this.trade = trade;
	}

	public String getLease() {
		return lease;
	}

	public void setLease(String lease) {
		this.lease = lease;
	}

	public String getFactoring() {
		return factoring;
	}

	public void setFactoring(String factoring) {
		this.factoring = factoring;
	}

	public String getCompanyList() {
		return companyList;
	}

	public void setCompanyList(String companyList) {
		this.companyList = companyList;
	}

	public String getIllMoneyFinRisk() {
		return illMoneyFinRisk;
	}

	public void setIllMoneyFinRisk(String illMoneyFinRisk) {
		this.illMoneyFinRisk = illMoneyFinRisk;
	}

	public String getUnderNum() {
		return underNum;
	}

	public void setUnderNum(String underNum) {
		this.underNum = underNum;
	}

	public String getUpperUnderNum() {
		return upperUnderNum;
	}

	public void setUpperUnderNum(String upperUnderNum) {
		this.upperUnderNum = upperUnderNum;
	}

	public String getFlwUnderNum() {
		return flwUnderNum;
	}

	public void setFlwUnderNum(String flwUnderNum) {
		this.flwUnderNum = flwUnderNum;
	}

	public String getRectSum() {
		return rectSum;
	}

	public void setRectSum(String rectSum) {
		this.rectSum = rectSum;
	}

	public String getTop5RecSum() {
		return top5RecSum;
	}

	public void setTop5RecSum(String top5RecSum) {
		this.top5RecSum = top5RecSum;
	}

	public String getPerStructRisk() {
		return perStructRisk;
	}

	public void setPerStructRisk(String perStructRisk) {
		this.perStructRisk = perStructRisk;
	}

	public String getRise() {
		return rise;
	}

	public void setRise(String rise) {
		this.rise = rise;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

}
