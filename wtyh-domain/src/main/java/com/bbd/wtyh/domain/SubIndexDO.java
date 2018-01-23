package com.bbd.wtyh.domain;



public class SubIndexDO {
    //上海非正常户认定指标
    private String normalHousehold;
    private int normalHouseholdNum;//条数

    //上海用人单位欠缴社会保险费指标
    private String UnpaidInsurancePremium;
    private int UnpaidInsurancePremiumNum;//条数

    //上海失信曝光指标
    private String DiscreditExposure;
    private int DiscreditExposureNum;//条数

    //上海市场监管类行政处罚指标
    private String AdministrativeSanction;
    private int AdministrativeSanctionNum;//条数


    //信用信息风险
    //限制出境
    private Integer restrictedExit;
    //限制高消费
    private Integer LimetingHighConsumption;
    //网上追讨
    private Integer onlineRecovery;
    //经营异常名录
    private Integer exceptionList;
    //行政处罚
    private Integer administrativeSanction2;
    //对不正当行为处罚
    private Integer behaviorPunishment;

    private String companyName;

    private String dataVersion;

    public Integer getExceptionList() {
        return exceptionList;
    }

    public void setExceptionList(Integer exceptionList) {
        this.exceptionList = exceptionList;
    }

    public Integer getAdministrativeSanction2() {
        return administrativeSanction2;
    }

    public void setAdministrativeSanction2(Integer administrativeSanction2) {
        this.administrativeSanction2 = administrativeSanction2;
    }

    public Integer getBehaviorPunishment() {
        return behaviorPunishment;
    }

    public void setBehaviorPunishment(Integer behaviorPunishment) {
        this.behaviorPunishment = behaviorPunishment;
    }

    public Integer getRestrictedExit() {
        return restrictedExit;
    }

    public void setRestrictedExit(Integer restrictedExit) {
        this.restrictedExit = restrictedExit;
    }

    public Integer getLimetingHighConsumption() {
        return LimetingHighConsumption;
    }

    public void setLimetingHighConsumption(Integer limetingHighConsumption) {
        LimetingHighConsumption = limetingHighConsumption;
    }

    public Integer getOnlineRecovery() {
        return onlineRecovery;
    }

    public void setOnlineRecovery(Integer onlineRecovery) {
        this.onlineRecovery = onlineRecovery;
    }

    public String getNormalHousehold() {
        return normalHousehold;
    }

    public void setNormalHousehold(String normalHousehold) {
        this.normalHousehold = normalHousehold;
    }

    public int getNormalHouseholdNum() {
        return normalHouseholdNum;
    }

    public void setNormalHouseholdNum(int normalHouseholdNum) {
        this.normalHouseholdNum = normalHouseholdNum;
    }

    public String getUnpaidInsurancePremium() {
        return UnpaidInsurancePremium;
    }

    public void setUnpaidInsurancePremium(String unpaidInsurancePremium) {
        UnpaidInsurancePremium = unpaidInsurancePremium;
    }

    public int getUnpaidInsurancePremiumNum() {
        return UnpaidInsurancePremiumNum;
    }

    public void setUnpaidInsurancePremiumNum(int unpaidInsurancePremiumNum) {
        UnpaidInsurancePremiumNum = unpaidInsurancePremiumNum;
    }

    public String getDiscreditExposure() {
        return DiscreditExposure;
    }

    public void setDiscreditExposure(String discreditExposure) {
        DiscreditExposure = discreditExposure;
    }

    public int getDiscreditExposureNum() {
        return DiscreditExposureNum;
    }

    public void setDiscreditExposureNum(int discreditExposureNum) {
        DiscreditExposureNum = discreditExposureNum;
    }

    public String getAdministrativeSanction() {
        return AdministrativeSanction;
    }

    public void setAdministrativeSanction(String administrativeSanction) {
        AdministrativeSanction = administrativeSanction;
    }

    public int getAdministrativeSanctionNum() {
        return AdministrativeSanctionNum;
    }

    public void setAdministrativeSanctionNum(int administrativeSanctionNum) {
        AdministrativeSanctionNum = administrativeSanctionNum;
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
}
