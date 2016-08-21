package com.bbd.wtyh.web;

import java.util.ArrayList;
import java.util.List;

/**
 * 折现图返回值
 * Created by yanwenyuan on 2016/8/6.
 */
public class LineChartBean<T1, T2> {
    private List<T1> xAxis;
    private List<T2> series;
    private String title;

    public LineChartBean() {
        this.xAxis = new ArrayList<>();
        this.series = new ArrayList<>();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
