package com.bbd.wtyh.domain.dto;

import org.apache.commons.lang.StringUtils;

/**
* 上海网贷行业整体数据
* @author Ian.Su
* @since 2016年8月9日 下午2:28:36
*/

public class IndustryShanghaiDTO {
	

	
	/**
	 * 月份，格式’2016-07’
	 * */
	private String date;
	/**
	 * 上海累计P2P平台数量
	 * */
	private int total_plat_num_sh;
	/**
	 * 上海新增P2P平台数量
	 * */
	private int new_plat_num;
	/**
	 * 上海地区P2P成交量
	 * */
	private double amount;
	/**
	 * 上海地区P2P综合利率
	 * */
	private double interest_rate;
	/**
	 * 上海P2P月借款人数
	 * */
	private int borrowed_num;
	/**
	 * 上海P2P月投资人数
	 * */
	private int invest_num;
	
	
	
	private String year;
	
	private String month;
	
	private String season;// 季度，格式如 2014-Q1;
	
	
	
	
	

	
	public String getYear() {
		return year;
	}



	
	
	public void setYear(String year) {
		this.year = year;
	}



	
	
	public String getMonth() {
		return month;
	}



	
	
	public void setMonth(String month) {
		this.month = month;
	}



	public String getDate() {
		return date;
	}
	
	
	
	public void setDate(String date) {
		
		if(StringUtils.isNotEmpty(date)){
			
			String[] ym = date.split("-");
			setYear(ym[0]);
			if(ym.length>1){
				setMonth(ym[1]);
				int mon = Integer.parseInt(ym[1]);
				setSeason(year+"-"+(mon<4?"Q1":(mon<7?"Q2":(mon<10?"Q3":"Q4"))));
			}
				
		}
		
		this.date = date;
	}
	
	
	
	
	/**
	* getter method
	* @return season
	*/
	
	public String getSeason() {
		return season;
	}





	
	/**
	* setter method
	* @param season 
	*/
	
	public void setSeason(String season) {
		this.season = season;
	}





	public int getTotal_plat_num_sh() {
		return total_plat_num_sh;
	}
	
	
	
	public void setTotal_plat_num_sh(int total_plat_num_sh) {
		this.total_plat_num_sh = total_plat_num_sh;
	}
	
	
	
	public int getNew_plat_num() {
		return new_plat_num;
	}
	
	
	public void setNew_plat_num(int new_plat_num) {
		this.new_plat_num = new_plat_num;
	}

	public double getAmount() {
		return amount;
	}
	

	
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getInterest_rate() {
		return interest_rate;
	}
	

	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}
	

	public int getBorrowed_num() {
		return borrowed_num;
	}
	

	public void setBorrowed_num(int borrowed_num) {
		this.borrowed_num = borrowed_num;
	}
	

	public int getInvest_num() {
		return invest_num;
	}
	

	public void setInvest_num(int invest_num) {
		this.invest_num = invest_num;
	}


	
}
