package com.bbd.wtyh.domain;

import java.math.BigDecimal;
import java.util.Date;

public class StaticRiskDataDO extends BaseDO {
    private String area;//区域
    private String companyName; // 公司名称
    private String dataVersion; // 数据版本号
    private Date riskDate; // 风险时间
    private BigDecimal staticRiskIndex; // 静态风险指数
    private float maxCompanyNum; // 单个一度关联自然人最大控制企业数量
    private float averagePersonNum;//平均每位一度关联自然人控制企业数量',
    private String oneLevelPerson;//核心一度关联自然人',
    private float realControlRisk;//实际控制人风险',
    private float childCompnayControlPerson_num;//控股子公司自然人股东数量',
    private float childChildControlNum;//控股子公司企业法人数量',
    private String coreChildCompany;//核心子公司',
    private float companyExpandRisk;//公司扩张路径风险',
    private float controlChildCompanyNum;//控股子公司数量',
    private float oneCompanyNum;//一度关联企业数量',
    private String controlCompany;//控股子公司',
    private float relationInRisk;//关联方中心积聚化风险',
    private float threePersonNum;//三度关联自然人节点数',
    private float twoCompanyNum;//二度关联企业法人节点数',
    private String coreTwoCompany;//核心二度关联公司',
    private float illegalFinancingRisk;//非法融资衍生风险',
    private float sixMonthNewCompanyNum;//6个月以内新成立公司数量',
    private float toYearNewComapnyNum;//6个月~1年以内新成立公司数量',
    private String sixMonthNewCompany;//6个月以内新成立的公司',
    private float relationCompanySum;//关联方公司总数',
    private float shortRisk;//短期逐利风险',
    private float investment;//投资类',
    private float advisory;//咨询类',
    private float trade;//贸易类',
    private float lease;//租赁类',
    private float factoring;//保理类',
    private String companyList;//公司名单',
    private float illegalMoneyFinancingRisk;//非法融资违规风险',
    private float capitalBgRisk;//资本背景风险',
    private float maxPersonCompanyNum3;//单个3度及3度以下关联自然人最大控制企业数量
    private float maxLegalCompanyNum3;//单个3度及3度以下法人最大控制（控股、高层管理人员）企业数量
    private float averagePersonCompanyNum3;//平均每位3度及3度以下关联自然人控制企业数量
    private float averageLegalCompanyNum3;//平均每位3度及3度以下关联法人控制企业数量
    private float realControlRiskV2;//实际控制人风险v2
    private float relationInRiskV2;//关联方中心积聚化风险
    private float illegalFinancingRiskV2;//非法融资衍生风险v2
    private float shortRiskV2;//短期逐利风险v2
    private float illegalMoneyFinancingRiskV2;//非法融资违规风险v2
    private float undergraduateNum;//本科人次',
    private float uperUndergraduateNum;//硕士以上人次(包括硕士)',
    private float followUndergraduateNum;//本科以下人次',
    private float recruitmentSum;//招聘总人次
    private String top5RecruitmentSum; // top5岗位和招聘人次
    private float personStructureRisk;//人才结构风险
    private float personStructureRiskV2;//人才结构风险v2
    private float creditInfoRisk;//信用信息风险
    private String isExposure;

    public float getMaxPersonCompanyNum3() {
        return maxPersonCompanyNum3;
    }

    public void setMaxPersonCompanyNum3(float maxPersonCompanyNum3) {
        this.maxPersonCompanyNum3 = maxPersonCompanyNum3;
    }

    public float getMaxLegalCompanyNum3() {
        return maxLegalCompanyNum3;
    }

    public void setMaxLegalCompanyNum3(float maxLegalCompanyNum3) {
        this.maxLegalCompanyNum3 = maxLegalCompanyNum3;
    }

    public float getAveragePersonCompanyNum3() {
        return averagePersonCompanyNum3;
    }

    public void setAveragePersonCompanyNum3(float averagePersonCompanyNum3) {
        this.averagePersonCompanyNum3 = averagePersonCompanyNum3;
    }

    public float getAverageLegalCompanyNum3() {
        return averageLegalCompanyNum3;
    }

    public void setAverageLegalCompanyNum3(float averageLegalCompanyNum3) {
        this.averageLegalCompanyNum3 = averageLegalCompanyNum3;
    }

    public float getRealControlRiskV2() {
        return realControlRiskV2;
    }

    public void setRealControlRiskV2(float realControlRiskV2) {
        this.realControlRiskV2 = realControlRiskV2;
    }

    public float getRelationInRiskV2() {
        return relationInRiskV2;
    }

    public void setRelationInRiskV2(float relationInRiskV2) {
        this.relationInRiskV2 = relationInRiskV2;
    }

    public float getIllegalFinancingRiskV2() {
        return illegalFinancingRiskV2;
    }

    public void setIllegalFinancingRiskV2(float illegalFinancingRiskV2) {
        this.illegalFinancingRiskV2 = illegalFinancingRiskV2;
    }

    public float getShortRiskV2() {
        return shortRiskV2;
    }

    public void setShortRiskV2(float shortRiskV2) {
        this.shortRiskV2 = shortRiskV2;
    }

    public float getIllegalMoneyFinancingRiskV2() {
        return illegalMoneyFinancingRiskV2;
    }

    public void setIllegalMoneyFinancingRiskV2(float illegalMoneyFinancingRiskV2) {
        this.illegalMoneyFinancingRiskV2 = illegalMoneyFinancingRiskV2;
    }

    public float getPersonStructureRiskV2() {
        return personStructureRiskV2;
    }

    public void setPersonStructureRiskV2(float personStructureRiskV2) {
        this.personStructureRiskV2 = personStructureRiskV2;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public Date getRiskDate() {
        return riskDate;
    }

    public void setRiskDate(Date riskDate) {
        this.riskDate = riskDate;
    }

    public BigDecimal getStaticRiskIndex() {
        return staticRiskIndex;
    }

    public void setStaticRiskIndex(BigDecimal staticRiskIndex) {
        this.staticRiskIndex = staticRiskIndex;
    }

    public float getMaxCompanyNum() {
        return maxCompanyNum;
    }

    public void setMaxCompanyNum(float maxCompanyNum) {
        this.maxCompanyNum = maxCompanyNum;
    }

    public float getAveragePersonNum() {
        return averagePersonNum;
    }

    public void setAveragePersonNum(float averagePersonNum) {
        this.averagePersonNum = averagePersonNum;
    }

    public String getOneLevelPerson() {
        return oneLevelPerson;
    }

    public void setOneLevelPerson(String oneLevelPerson) {
        this.oneLevelPerson = oneLevelPerson;
    }

    public float getRealControlRisk() {
        return realControlRisk;
    }

    public void setRealControlRisk(float realControlRisk) {
        this.realControlRisk = realControlRisk;
    }

    public float getChildCompnayControlPerson_num() {
        return childCompnayControlPerson_num;
    }

    public void setChildCompnayControlPerson_num(float childCompnayControlPerson_num) {
        this.childCompnayControlPerson_num = childCompnayControlPerson_num;
    }

    public float getChildChildControlNum() {
        return childChildControlNum;
    }

    public void setChildChildControlNum(float childChildControlNum) {
        this.childChildControlNum = childChildControlNum;
    }

    public String getCoreChildCompany() {
        return coreChildCompany;
    }

    public void setCoreChildCompany(String coreChildCompany) {
        this.coreChildCompany = coreChildCompany;
    }

    public float getCompanyExpandRisk() {
        return companyExpandRisk;
    }

    public void setCompanyExpandRisk(float companyExpandRisk) {
        this.companyExpandRisk = companyExpandRisk;
    }

    public float getControlChildCompanyNum() {
        return controlChildCompanyNum;
    }

    public void setControlChildCompanyNum(float controlChildCompanyNum) {
        this.controlChildCompanyNum = controlChildCompanyNum;
    }

    public float getOneCompanyNum() {
        return oneCompanyNum;
    }

    public void setOneCompanyNum(float oneCompanyNum) {
        this.oneCompanyNum = oneCompanyNum;
    }

    public String getControlCompany() {
        return controlCompany;
    }

    public void setControlCompany(String controlCompany) {
        this.controlCompany = controlCompany;
    }

    public float getRelationInRisk() {
        return relationInRisk;
    }

    public void setRelationInRisk(float relationInRisk) {
        this.relationInRisk = relationInRisk;
    }

    public float getThreePersonNum() {
        return threePersonNum;
    }

    public void setThreePersonNum(float threePersonNum) {
        this.threePersonNum = threePersonNum;
    }

    public float getTwoCompanyNum() {
        return twoCompanyNum;
    }

    public void setTwoCompanyNum(float twoCompanyNum) {
        this.twoCompanyNum = twoCompanyNum;
    }

    public String getCoreTwoCompany() {
        return coreTwoCompany;
    }

    public void setCoreTwoCompany(String coreTwoCompany) {
        this.coreTwoCompany = coreTwoCompany;
    }

    public float getIllegalFinancingRisk() {
        return illegalFinancingRisk;
    }

    public void setIllegalFinancingRisk(float illegalFinancingRisk) {
        this.illegalFinancingRisk = illegalFinancingRisk;
    }

    public float getSixMonthNewCompanyNum() {
        return sixMonthNewCompanyNum;
    }

    public void setSixMonthNewCompanyNum(float sixMonthNewCompanyNum) {
        this.sixMonthNewCompanyNum = sixMonthNewCompanyNum;
    }

    public float getToYearNewComapnyNum() {
        return toYearNewComapnyNum;
    }

    public void setToYearNewComapnyNum(float toYearNewComapnyNum) {
        this.toYearNewComapnyNum = toYearNewComapnyNum;
    }

    public String getSixMonthNewCompany() {
        return sixMonthNewCompany;
    }

    public void setSixMonthNewCompany(String sixMonthNewCompany) {
        this.sixMonthNewCompany = sixMonthNewCompany;
    }

    public float getRelationCompanySum() {
        return relationCompanySum;
    }

    public void setRelationCompanySum(float relationCompanySum) {
        this.relationCompanySum = relationCompanySum;
    }

    public float getShortRisk() {
        return shortRisk;
    }

    public void setShortRisk(float shortRisk) {
        this.shortRisk = shortRisk;
    }

    public float getInvestment() {
        return investment;
    }

    public void setInvestment(float investment) {
        this.investment = investment;
    }

    public float getAdvisory() {
        return advisory;
    }

    public void setAdvisory(float advisory) {
        this.advisory = advisory;
    }

    public float getTrade() {
        return trade;
    }

    public void setTrade(float trade) {
        this.trade = trade;
    }

    public float getLease() {
        return lease;
    }

    public void setLease(float lease) {
        this.lease = lease;
    }

    public float getFactoring() {
        return factoring;
    }

    public void setFactoring(float factoring) {
        this.factoring = factoring;
    }

    public String getCompanyList() {
        return companyList;
    }

    public void setCompanyList(String companyList) {
        this.companyList = companyList;
    }

    public float getIllegalMoneyFinancingRisk() {
        return illegalMoneyFinancingRisk;
    }

    public void setIllegalMoneyFinancingRisk(float illegalMoneyFinancingRisk) {
        this.illegalMoneyFinancingRisk = illegalMoneyFinancingRisk;
    }

    public float getCapitalBgRisk() {
        return capitalBgRisk;
    }

    public void setCapitalBgRisk(float capitalBgRisk) {
        this.capitalBgRisk = capitalBgRisk;
    }

    public float getUndergraduateNum() {
        return undergraduateNum;
    }

    public void setUndergraduateNum(float undergraduateNum) {
        this.undergraduateNum = undergraduateNum;
    }

    public float getUperUndergraduateNum() {
        return uperUndergraduateNum;
    }

    public void setUperUndergraduateNum(float uperUndergraduateNum) {
        this.uperUndergraduateNum = uperUndergraduateNum;
    }

    public float getFollowUndergraduateNum() {
        return followUndergraduateNum;
    }

    public void setFollowUndergraduateNum(float followUndergraduateNum) {
        this.followUndergraduateNum = followUndergraduateNum;
    }

    public float getRecruitmentSum() {
        return recruitmentSum;
    }

    public void setRecruitmentSum(float recruitmentSum) {
        this.recruitmentSum = recruitmentSum;
    }

    public String getTop5RecruitmentSum() {
        return top5RecruitmentSum;
    }

    public void setTop5RecruitmentSum(String top5RecruitmentSum) {
        this.top5RecruitmentSum = top5RecruitmentSum;
    }

    public float getPersonStructureRisk() {
        return personStructureRisk;
    }

    public void setPersonStructureRisk(float personStructureRisk) {
        this.personStructureRisk = personStructureRisk;
    }

    public float getCreditInfoRisk() {
        return creditInfoRisk;
    }

    public void setCreditInfoRisk(float creditInfoRisk) {
        this.creditInfoRisk = creditInfoRisk;
    }

    public String getIsExposure() {
        return isExposure;
    }

    public void setIsExposure(String isExposure) {
        this.isExposure = isExposure;
    }
}