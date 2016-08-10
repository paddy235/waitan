package com.bbd.wtyh.domain.dto;


/**
* 问题平台DTO
* @author Ian.Su
* @since 2016年8月10日 上午9:44:42
*/
public class IndustryProblemDTO {

	/**
	 * 月份，格式：2016-07
	 * */
	private String date;
	
	
	/**
	 * “全国” or 上海
	 * */
	private String area; 
	
	
	/**
	 * 问题平台数量
	 * */
	private int problem_plat_number;
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	public int getProblem_plat_number() {
		return problem_plat_number;
	}
	
	public void setProblem_plat_number(int problem_plat_number) {
		this.problem_plat_number = problem_plat_number;
	} 
	
	
	
}

	
