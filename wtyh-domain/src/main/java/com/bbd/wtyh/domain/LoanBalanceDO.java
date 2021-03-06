package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "loan_balance")
public class LoanBalanceDO extends BaseDO {

	@Id
	private Integer id;

	/** 年份 */
	@Column
	private Integer year;

	/** 月份 */
	@Column
	private Integer month;

	/** 余额总计 */
	@Column
	private Double amount;

	/** 余额笔数 */
	@Column
	private Integer number;

	/** 公司数量 */
	@Column(name = "company_amount")
	private Integer companyAmount;

	/** 三农余额 */
	@Column(name = "agriculture_balance")
	private Double agricultureBalance;

	/** 小微余额 */
	@Column(name = "small_company_balance")
	private Double smallCompanyBalance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getAgricultureBalance() {
		return agricultureBalance;
	}

	public void setAgricultureBalance(Double agricultureBalance) {
		this.agricultureBalance = agricultureBalance;
	}

	public Double getSmallCompanyBalance() {
		return smallCompanyBalance;
	}

	public void setSmallCompanyBalance(Double smallCompanyBalance) {
		this.smallCompanyBalance = smallCompanyBalance;
	}

	public Integer getCompanyAmount() {
		return companyAmount;
	}

	public void setCompanyAmount(Integer companyAmount) {
		this.companyAmount = companyAmount;
	}
}