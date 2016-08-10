package com.bbd.wtyh.domain.dto;

import java.util.ArrayList;
import java.util.List;


/**
* 折线图树状图集合对象
* @author Ian.Su
* @since 2016年8月9日 下午3:18:50
*/
public class XAxisSeriesLinesDTO<T> {
	
	private String title;
	
	private List<String> xAxis = new ArrayList<>();
	
	private List<T> [] series = null;
	
	private int code = 1;
	
	public XAxisSeriesLinesDTO(@SuppressWarnings("unchecked") List<T> ... series){
		this.series = series;
	}
	
	
	

	
	public List<T>[] getSeries() {
		return series;
	}






	
	public void setSeries(List<T>[] series) {
		this.series = series;
	}






	public List<String> getxAxis() {
		return xAxis;
	}
	
	

	
	public String getTitle() {
		return title;
	}


	
	public void setTitle(String title) {
		this.title = title;
	}




	public void setxAxis(List<String> xAxis) {
		this.xAxis = xAxis;
	}



	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}




	
	
}
