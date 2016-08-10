package com.bbd.wtyh.domain.dto;

/**
* 网贷数据对比
* @author Ian.Su
* @since 2016年8月10日 上午10:36:34
*/
public class IndustryCompareDTO {
	
	private String date;
	private String area;
	private double amount;  
	private double balance_loans;
	

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
	

	public double getAmount() {
		return amount;
	}
	

	public void setAmount(double amount) {
		this.amount = amount;
	}
	

	public double getBalance_loans() {
		return balance_loans;
	}
	

	public void setBalance_loans(double balance_loans) {
		this.balance_loans = balance_loans;
	}
	
	
	
}
