package com.bbd.wtyh.domain.vo;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class StatisticsVO implements Serializable {

	private String riskName;
	private BigDecimal riskIndex;
	private BigDecimal avgRiskIndex;
	private String date;

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public BigDecimal getRiskIndex() {
		return riskIndex.divide(BigDecimal.ONE, 1, BigDecimal.ROUND_HALF_UP);
	}

	public void setRiskIndex(BigDecimal riskIndex) {
		this.riskIndex = riskIndex;
	}

	public BigDecimal getAvgRiskIndex() {
		return avgRiskIndex.divide(BigDecimal.ONE, 1, BigDecimal.ROUND_HALF_UP);
	}

	public void setAvgRiskIndex(BigDecimal avgRiskIndex) {
		this.avgRiskIndex = avgRiskIndex;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
