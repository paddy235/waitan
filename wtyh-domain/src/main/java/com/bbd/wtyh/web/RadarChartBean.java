package com.bbd.wtyh.web;


/**
 * 雷达图返回值
 * @author wangchenge
 */
public class RadarChartBean<T> {
    private T indicator;
    private T series;
    private T score;
    private T code;

    public T getIndicator() {
        return indicator;
    }

    public void setIndicator(T indicator) {
        this.indicator = indicator;
    }

    public T getSeries() {
        return series;
    }

    public void setSeries(T series) {
        this.series = series;
    }

    public T getScore() {
        return score;
    }

    public void setScore(T score) {
        this.score = score;
    }

    public T getCode() {
        return code;
    }

    public void setCode(T code) {
        this.code = code;
    }
}
