package com.bbd.wtyh.domain;

/**
 * Created by lixudong on 2017/7/12.
 */
public class PlatCoreDataDO extends BaseDO{

    private String platName;

    private double otherSumAmount;

    private double interestRate;

    private int bidNumStayStil;

    private int borNumStayStil;

    private String companyName;

    private double top10SumAmount;

    private double moneyStock;

    private double day30NetInflow;

    private double top1SumAmount;

    private double amountTotal;

    private String platDataSixMonth;

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public Double getOtherSumAmount() {
        return otherSumAmount;
    }

    public void setOtherSumAmount(Double otherSumAmount) {
        this.otherSumAmount = otherSumAmount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getBidNumStayStil() {
        return bidNumStayStil;
    }

    public void setBidNumStayStil(Integer bidNumStayStil) {
        this.bidNumStayStil = bidNumStayStil;
    }

    public Integer getBorNumStayStil() {
        return borNumStayStil;
    }

    public void setBorNumStayStil(Integer borNumStayStil) {
        this.borNumStayStil = borNumStayStil;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getTop10SumAmount() {
        return top10SumAmount;
    }

    public void setTop10SumAmount(Double top10SumAmount) {
        this.top10SumAmount = top10SumAmount;
    }

    public Double getMoneyStock() {
        return moneyStock;
    }

    public void setMoneyStock(Double moneyStock) {
        this.moneyStock = moneyStock;
    }

    public Double getDay30NetInflow() {
        return day30NetInflow;
    }

    public void setDay30NetInflow(Double day30NetInflow) {
        this.day30NetInflow = day30NetInflow;
    }

    public Double getTop1SumAmount() {
        return top1SumAmount;
    }

    public void setTop1SumAmount(Double top1SumAmount) {
        this.top1SumAmount = top1SumAmount;
    }

    public Double getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(Double amountTotal) {
        this.amountTotal = amountTotal;
    }

    public String getPlatDataSixMonth() {
        return platDataSixMonth;
    }

    public void setPlatDataSixMonth(String platDataSixMonth) {
        this.platDataSixMonth = platDataSixMonth;
    }

    @Override
    public String toString() {
        return "PlatCoreDataDO{" +
                "platName='" + platName + '\'' +
                ", otherSumAmount=" + otherSumAmount +
                ", interestRate=" + interestRate +
                ", bidNumStayStil=" + bidNumStayStil +
                ", borNumStayStil=" + borNumStayStil +
                ", companyName='" + companyName + '\'' +
                ", top10SumAmount=" + top10SumAmount +
                ", moneyStock=" + moneyStock +
                ", day30NetInflow=" + day30NetInflow +
                ", top1SumAmount=" + top1SumAmount +
                ", amountTotal=" + amountTotal +
                ", platDataSixMonth='" + platDataSixMonth + '\'' +
                '}';
    }
}
