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
}
