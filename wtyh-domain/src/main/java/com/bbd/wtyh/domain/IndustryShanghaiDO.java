package com.bbd.wtyh.domain;

import com.bbd.wtyh.domain.BaseDO;

/**
 * Created by lixudong on 2017/7/11.
 */
public class IndustryShanghaiDO extends BaseDO{

    private int newPlatNum;

    private double interestRate;

    private int totalPlatNum;

    private int borrowedNum;

    private int investNum;

    private double amount;

    private String areaNum;

    private String date;

    public int getNewPlatNum() {
        return newPlatNum;
    }

    public void setNewPlatNum(int newPlatNum) {
        this.newPlatNum = newPlatNum;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTotalPlatNum() {
        return totalPlatNum;
    }

    public void setTotalPlatNum(int totalPlatNum) {
        this.totalPlatNum = totalPlatNum;
    }

    public int getBorrowedNum() {
        return borrowedNum;
    }

    public void setBorrowedNum(int borrowedNum) {
        this.borrowedNum = borrowedNum;
    }

    public int getInvestNum() {
        return investNum;
    }

    public void setInvestNum(int investNum) {
        this.investNum = investNum;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "IndustryShanghaiDO{" +
                "newPlatNum=" + newPlatNum +
                ", interestRate=" + interestRate +
                ", totalPlatNum=" + totalPlatNum +
                ", borrowedNum=" + borrowedNum +
                ", investNum=" + investNum +
                ", amount=" + amount +
                ", areaNum='" + areaNum + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getAreaNum() {
        return areaNum;
    }

    public void setAreaNum(String areaNum) {
        this.areaNum = areaNum;
    }
}
