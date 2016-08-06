package com.bbd.wtyh.web;

import java.util.ArrayList;
import java.util.List;

/**
 * 柱状图返回值
 * Created by win7 on 2016/8/6.
 */
public class HistogramBean<T1, T2> {
    private List<T1> xAxis;
    private List<T2> series;

    public HistogramBean() {
        this.xAxis = new ArrayList<>();
        this.series = new ArrayList<>();
    }

    public List<T1> getxAxis() {
        return xAxis;
    }

    public void setxAxis(List<T1> xAxis) {
        if (xAxis.size() != 0) {
            this.xAxis = xAxis;
        }
    }

    public List<T2> getseries() {
        return series;
    }

    public void setseries(List<T2> series) {
        if (series.size() != 0) {
            this.series = series;
        }
    }
}
