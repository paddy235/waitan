package com.bbd.wtyh.domain.dto;

import java.util.ArrayList;
import java.util.List;


/**
* 折线图树状图集合对象
* @author Ian.Su
* @since 2016年8月9日 下午3:18:50
*/
public class XAxisSeriesBarLineDTO<T,TX> {
	
	private String title;
	
	private List<TX> xAxis = new ArrayList<>();
	
	private Series<T> series = new Series<T>();
	
	private int code = 1;

	public List<TX> getxAxis() {
		return xAxis;
	}
	
	

	
	public String getTitle() {
		return title;
	}


	
	public void setTitle(String title) {
		this.title = title;
	}




	public void setxAxis(List<TX> xAxis) {
		this.xAxis = xAxis;
	}

	public Series<T> getSeries() {
		return series;
	}

	
	public void setSeries(Series<T> series) {
		this.series = series;
	}


	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}




	public static class Series<T>{
		
		List<T> bar = new ArrayList<>(); //柱状图
		List<T> line = new ArrayList<>();//折线图
		
		public List<T> getBar() {
			return bar;
		}
		
		public void setBar(List<T> bar) {
			this.bar = bar;
		}
		
		public List<T> getLine() {
			return line;
		}
		
		public void setLine(List<T> line) {
			this.line = line;
		};
		
		
	}
	
}
