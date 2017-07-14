package com.bbd.wtyh.domain;

import org.docx4j.openpackaging.Base;

/**
 * Created by lixudong on 2017/7/12.
 */
public class AreaIndexDO extends BaseDO{

    private String area;
    double ecosystem;
    double scale;
    double popularity;
    double safety;
    double recognition;
    double competitiveness;
    int rank;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getEcosystem() {
        return ecosystem;
    }

    public void setEcosystem(double ecosystem) {
        this.ecosystem = ecosystem;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getSafety() {
        return safety;
    }

    public void setSafety(double safety) {
        this.safety = safety;
    }

    public double getRecognition() {
        return recognition;
    }

    public void setRecognition(double recognition) {
        this.recognition = recognition;
    }

    public double getCompetitiveness() {
        return competitiveness;
    }

    public void setCompetitiveness(double competitiveness) {
        this.competitiveness = competitiveness;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "AreaIndexDO{" +
                "area='" + area + '\'' +
                ", ecosystem=" + ecosystem +
                ", scale=" + scale +
                ", popularity=" + popularity +
                ", safety=" + safety +
                ", recognition=" + recognition +
                ", competitiveness=" + competitiveness +
                ", rank=" + rank +
                '}';
    }
}
