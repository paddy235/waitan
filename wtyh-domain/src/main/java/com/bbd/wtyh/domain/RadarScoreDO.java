package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lixudong on 2017/7/13.
 */
@Entity
@Table(name = "radar_score")
public class RadarScoreDO extends BaseDO {

    @Id
    private Integer id;

    @Column(name = "plat_name")
    private String platName;

    @Column(name = "info_disclosure")
    private double infoDisclosure;// 信息披露

    @Column
    private double fluidity;// 流动性

    @Column
    private double dispersion;// 分散度

    @Column
    private double capital;// 资本充足

    @Column(name = "penalty_cost")
    private double penaltyCost;// 违约成本

    @Column
    private double operation;// 运营能力

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

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
        return "RadarScoreDO{" + "platName='" + platName + '\'' + ", infoDisclosure=" + infoDisclosure + ", fluidity=" + fluidity
                + ", dispersion=" + dispersion + ", capital=" + capital + ", penaltyCost=" + penaltyCost + ", operation=" + operation + '}';
    }
}
