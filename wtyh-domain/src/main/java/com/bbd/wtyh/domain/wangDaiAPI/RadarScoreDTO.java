package com.bbd.wtyh.domain.wangDaiAPI;

/**
 * Created by lixudong on 2017/7/13.
 */
public class RadarScoreDTO {

    private String plat_name;

    private double info_disclosure;

    private double fluidity;

    private double dispersion;

    private double capital;

    private double penalty_cost;

    private double operation;

    public String getPlat_name() {
        return plat_name;
    }

    public void setPlat_name(String plat_name) {
        this.plat_name = plat_name;
    }

    public double getInfo_disclosure() {
        return info_disclosure;
    }

    public void setInfo_disclosure(double info_disclosure) {
        this.info_disclosure = info_disclosure;
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

    public double getPenalty_cost() {
        return penalty_cost;
    }

    public void setPenalty_cost(double penalty_cost) {
        this.penalty_cost = penalty_cost;
    }

    public double getOperation() {
        return operation;
    }

    public void setOperation(double operation) {
        this.operation = operation;
    }
}
