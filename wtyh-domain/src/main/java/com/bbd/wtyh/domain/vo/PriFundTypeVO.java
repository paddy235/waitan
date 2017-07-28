package com.bbd.wtyh.domain.vo;

import java.io.Serializable;

/**
 * Created by lixudong on 2017/7/27.
 */
public class PriFundTypeVO  implements Serializable {

    private static final long serialVersionUID = 172109425233964706L;

    private Integer equityInvestment;

    private Integer portfolioInvestment;

    private Integer vc;

    private Integer fofs;

    private Integer broker;

    private Integer strategy;

    private Integer angel;

    private Integer pe;

    private Integer other;

    public Integer getEquityInvestment() {
        return equityInvestment;
    }

    public void setEquityInvestment(Integer equityInvestment) {
        this.equityInvestment = equityInvestment;
    }

    public Integer getPortfolioInvestment() {
        return portfolioInvestment;
    }

    public void setPortfolioInvestment(Integer portfolioInvestment) {
        this.portfolioInvestment = portfolioInvestment;
    }

    public Integer getVc() {
        return vc;
    }

    public void setVc(Integer vc) {
        this.vc = vc;
    }

    public Integer getFofs() {
        return fofs;
    }

    public void setFofs(Integer fofs) {
        this.fofs = fofs;
    }

    public Integer getBroker() {
        return broker;
    }

    public void setBroker(Integer broker) {
        this.broker = broker;
    }

    public Integer getStrategy() {
        return strategy;
    }

    public void setStrategy(Integer strategy) {
        this.strategy = strategy;
    }

    public Integer getAngel() {
        return angel;
    }

    public void setAngel(Integer angel) {
        this.angel = angel;
    }

    public Integer getPe() {
        return pe;
    }

    public void setPe(Integer pe) {
        this.pe = pe;
    }

    public Integer getOther() {
        return other;
    }

    public void setOther(Integer other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "PriFundTypeVO{" +
                "equityInvestment=" + equityInvestment +
                ", portfolioInvestment=" + portfolioInvestment +
                ", vc=" + vc +
                ", fofs=" + fofs +
                ", broker=" + broker +
                ", strategy=" + strategy +
                ", angel=" + angel +
                ", pe=" + pe +
                ", other=" + other +
                '}';
    }
}
