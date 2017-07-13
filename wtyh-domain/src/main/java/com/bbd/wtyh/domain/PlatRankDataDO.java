package com.bbd.wtyh.domain;


/**
 * Created by lixudong on 2017/7/11.
 */
public class PlatRankDataDO extends BaseDO {
    private String platName;//平台名称
    private int rank;//排名
    private double amount;
    private double incomeRate;
    private double loanPeriod;
    private double stayStillOfTotal;
    private String platStatus;
    private String registeredAddress;
    private String areaId;

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getIncomeRate() {
        return incomeRate;
    }

    public void setIncomeRate(double incomeRate) {
        this.incomeRate = incomeRate;
    }

    public double getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(double loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public double getStayStillOfTotal() {
        return stayStillOfTotal;
    }

    public void setStayStillOfTotal(double stayStillOfTotal) {
        this.stayStillOfTotal = stayStillOfTotal;
    }

    public String getPlatStatus() {
        return platStatus;
    }

    public void setPlatStatus(String platStatus) {
        this.platStatus = platStatus;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "PlatRankDataDO{" +
                "platName='" + platName + '\'' +
                ", rank=" + rank +
                ", amount=" + amount +
                ", incomeRate=" + incomeRate +
                ", loanPeriod=" + loanPeriod +
                ", stayStillOfTotal=" + stayStillOfTotal +
                ", platStatus='" + platStatus + '\'' +
                ", registeredAddress='" + registeredAddress + '\'' +
                ", areaId='" + areaId + '\'' +
                '}';
    }
}
