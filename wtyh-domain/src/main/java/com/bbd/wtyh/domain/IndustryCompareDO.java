package com.bbd.wtyh.domain;

/**
 * Created by lixudong on 2017/7/11.
 */
public class IndustryCompareDO extends BaseDO{

    private String date;
    private String area;
    private double amount;//成交量
    private double balanceLoans;//贷款余额

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalanceLoans() {
        return balanceLoans;
    }

    public void setBalanceLoans(double balanceLoans) {
        this.balanceLoans = balanceLoans;
    }

    @Override
    public String toString() {
        return "IndustryCompareDO{" +
                "date='" + date + '\'' +
                ", area='" + area + '\'' +
                ", amount=" + amount +
                ", balanceLoans=" + balanceLoans +
                '}';
    }
}
