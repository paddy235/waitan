package com.bbd.wtyh.domain;

/**
 * 
 * @author Barney
 * @since 2016年8月6日
 *
 * @Copyright © www Inc. All Rights Reserved 2016.
 */
public class SysAnalyzeDO extends BaseDO {

	private Integer dataCount; // 数据分析
	private Integer companyCount; // 企业数量
	private Integer bugCount; // 数据抓取

	public Integer getDataCount() {
		return dataCount;
	}

	public void setDataCount(Integer dataCount) {
		this.dataCount = dataCount;
	}

	public Integer getCompanyCount() {
		return companyCount;
	}

	public void setCompanyCount(Integer companyCount) {
		this.companyCount = companyCount;
	}

	public Integer getBugCount() {
		return bugCount;
	}

	public void setBugCount(Integer bugCount) {
		this.bugCount = bugCount;
	}

}
