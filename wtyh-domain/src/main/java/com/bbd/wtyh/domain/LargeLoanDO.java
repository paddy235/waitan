package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "large_loan")
public class LargeLoanDO extends BaseDO {

	@Id
	private Integer id;

	@Column(name = "borrower_id")
	private Integer borrowerId;

	@Column(name = "lender_id")
	private Integer lenderId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(Integer borrowerId) {
		this.borrowerId = borrowerId;
	}

	public Integer getLenderId() {
		return lenderId;
	}

	public void setLenderId(Integer lenderId) {
		this.lenderId = lenderId;
	}
}