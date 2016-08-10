package com.bbd.wtyh.domain.dto;


/**
* 上海网贷平台数据展示
* @author Ian.Su
* @since 2016年8月10日 下午2:50:44
*/
public class PlatRankDataDTO {
	
	private int rank;
	
	private String plat_name;
	
	private double amount;
	
	private double income_rate;
	
	private double loan_period;
	
	private double stay_still_of_total;
	
	
	public int getRank() {
		return rank;
	}
	
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	public String getPlat_name() {
		return plat_name;
	}
	
	public void setPlat_name(String plat_name) {
		this.plat_name = plat_name;
	}
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	public double getIncome_rate() {
		return income_rate;
	}
	
	
	public void setIncome_rate(double income_rate) {
		this.income_rate = income_rate;
	}
	
	public double getLoan_period() {
		return loan_period;
	}
	
	public void setLoan_period(double loan_period) {
		this.loan_period = loan_period;
	}
	
	public double getStay_still_of_total() {
		return stay_still_of_total;
	}
	
	public void setStay_still_of_total(double stay_still_of_total) {
		this.stay_still_of_total = stay_still_of_total;
	}
	
	
	
}
