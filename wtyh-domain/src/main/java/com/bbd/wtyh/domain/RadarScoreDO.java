package com.bbd.wtyh.domain;

/**
 * Created by lixudong on 2017/7/13.
 */
public class RadarScoreDO extends BaseDO{

    private String platName;
    private double infoDisclosure;//信息披露
    private double fluidity;//流动性
    private double dispersion;//分散度
    private double capital;//资本充足
    private double penaltyCost;//违约成本
    private double operation;//运营能力

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public double getInfoDisclosure() {
        return infoDisclosure;
    }

    public void setInfoDisclosure(double infoDisclosure) {
        this.infoDisclosure = infoDisclosure;
    }

    public double getFluidity() {
        return fluidity;
    }

    public void setFluidity(double fluidity) {
        this.fluidity = fluidity;
    }

    public double getDispersion() {
        return dispersion;
    }

    public void setDispersion(double dispersion) {
        this.dispersion = dispersion;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getPenaltyCost() {
        return penaltyCost;
    }

    public void setPenaltyCost(double penaltyCost) {
        this.penaltyCost = penaltyCost;
    }

    public double getOperation() {
        return operation;
    }

    public void setOperation(double operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "RadarScoreDO{" +
                "platName='" + platName + '\'' +
                ", infoDisclosure=" + infoDisclosure +
                ", fluidity=" + fluidity +
                ", dispersion=" + dispersion +
                ", capital=" + capital +
                ", penaltyCost=" + penaltyCost +
                ", operation=" + operation +
                '}';
    }
}
