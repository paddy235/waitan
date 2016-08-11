package com.bbd.wtyh.web;

import java.util.ArrayList;
import java.util.List;

/**
* 饼图
* 
* @author Ian.Su
* @since 2016年8月11日 下午4:24:20
*/
public class PieChartBean<L,S> {
	
	private String title;
	
	private List<L> legend = new ArrayList<>();
	
	private List<S> series = new ArrayList<>();

	
	public String getTitle() {
		return title;
	}


	
	public void setTitle(String title) {
		this.title = title;
	}


	
	public List<L> getLegend() {
		return legend;
	}

	

	
	public void setLegend(List<L> legend) {
		this.legend = legend;
	}


	
	public List<S> getSeries() {
		return series;
	}

	

	public void setSeries(List<S> series) {
		this.series = series;
	}
	
	
	
	
	
	
}
