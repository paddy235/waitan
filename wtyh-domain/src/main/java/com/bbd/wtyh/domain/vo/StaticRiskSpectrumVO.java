package com.bbd.wtyh.domain.vo;


import java.math.BigDecimal;
import java.util.Date;

public class StaticRiskSpectrumVO {
	private String name; // 公司名称
	private Date riskDate; // 风险时间
	private BigDecimal stcRiskIndex; // 静态风险指数
	private String registered_capital;

	public String getRegistered_capital() {
		return registered_capital;
	}

	public void setRegistered_capital(String registered_capital) {
		this.registered_capital = registered_capital;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRiskDate() {
		return riskDate;
	}

	public void setRiskDate(Date riskDate) {
		this.riskDate = riskDate;
	}

	public BigDecimal getStcRiskIndex() {
		return stcRiskIndex;
	}

	public void setStcRiskIndex(BigDecimal stcRiskIndex) {
		this.stcRiskIndex = stcRiskIndex;
	}
}
