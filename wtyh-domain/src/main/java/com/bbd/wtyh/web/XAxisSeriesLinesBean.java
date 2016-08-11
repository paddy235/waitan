package com.bbd.wtyh.web;

import java.util.ArrayList;
import java.util.List;


/**
* 折线图树状图集合对象
* @author Ian.Su
* @since 2016年8月9日 下午3:18:50
*/
public class XAxisSeriesLinesBean<T,TX> {
	
	private String title;
	
	private List<TX> xAxis = new ArrayList<>();
	
	private List<T> [] series = null;
	
	private int code = 1;
	
	public XAxisSeriesLinesBean(@SuppressWarnings("unchecked") List<T> ... series){
		this.series = series;
	}
	
	
	

	
	public List<T>[] getSeries() {
		return series;
	}






	
	public void setSeries(List<T>[] series) {
		this.series = series;
	}






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



	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}




	
	
}
