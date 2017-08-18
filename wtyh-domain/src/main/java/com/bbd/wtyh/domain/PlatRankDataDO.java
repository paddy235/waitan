package com.bbd.wtyh.domain;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * Created by lixudong on 2017/7/11. <br>
 * By the LiYao modify on 2017-08-18.
 */
@Entity
@Table(name = "plat_rank_data")
public class PlatRankDataDO extends BaseDO {

	/** ID */
	@Id
	@Column(name = "id")
	private Integer id;

	/** 平台名称 */
	@Column(name = "plat_name")
	private String platName;

	/** 排名 */
	@Column(name = "rank")
	private int rank;

	/** 成交量 */
	@Column(name = "amount")
	private double amount;

	/** 平均利率 */
	@Column(name = "income_rate")
	private double incomeRate;

	/** 平均借款期限 */
	@Column(name = "loan_period")
	private double loanPeriod;

	/** 累计待还金额 */
	@Column(name = "stay_still_of_total")
	private double stayStillOfTotal;

	/** 平台状态 */
	@Column(name = "plat_status")
	private String platStatus;

	/** 注册地址 */
	@Column(name = "registered_address")
	private String registeredAddress;

	/** 地区id */
	@Column(name = "area_id")
	private String areaId;

	@Override
	public String toString() {
		return "PlatRankDataDO{" + "platName='" + platName + '\'' + ", rank=" + rank + ", amount=" + amount + ", incomeRate=" + incomeRate
				+ ", loanPeriod=" + loanPeriod + ", stayStillOfTotal=" + stayStillOfTotal + ", platStatus='" + platStatus + '\''
				+ ", registeredAddress='" + registeredAddress + '\'' + ", areaId='" + areaId + '\'' + '}';
	}

	public String getPlatRank() {
		final String RANK_A = "优良";
		final String RANK_B = "一般关注";
		final String RANK_C = "重点关注";
		final String RANK_D = "问题及停业平台";

		switch (this.platStatus) {
		case RANK_A:
			return "A";
		case RANK_B:
			return "B";
		case RANK_C:
			return "C";
		case RANK_D:
			return "D";
		default:
			return "\\";
		}
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlatName() {
		return platName;
	}

	public void setPlatName(String platName) {
		this.platName = platName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getIncomeRate() {
		return incomeRate;
	}

	public void setIncomeRate(double incomeRate) {
		this.incomeRate = incomeRate;
	}

	public double getLoanPeriod() {
		return loanPeriod;
	}

	public void setLoanPeriod(double loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

	public double getStayStillOfTotal() {
		return stayStillOfTotal;
	}

	public void setStayStillOfTotal(double stayStillOfTotal) {
		this.stayStillOfTotal = stayStillOfTotal;
	}

	public String getPlatStatus() {
		return platStatus;
	}

	public void setPlatStatus(String platStatus) {
		this.platStatus = platStatus;
	}

	public String getRegisteredAddress() {
		return registeredAddress;
	}

	public void setRegisteredAddress(String registeredAddress) {
		this.registeredAddress = registeredAddress;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
}
