package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "company_level")
public class CompanyLevelDO extends BaseDO {

	@Id
	@Column(name = "company_id")
	private Integer companyId;

	@Column(name = "out_level")
	private Integer outLevel;

	@Column(name = "inner_level")
	private Integer innerLevel;

	@Column(name = "live_level")
	private Integer liveLevel;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getOutLevel() {
		return outLevel;
	}

	public void setOutLevel(Integer outLevel) {
		this.outLevel = outLevel;
	}

	public Integer getInnerLevel() {
		return innerLevel;
	}

	public void setInnerLevel(Integer innerLevel) {
		this.innerLevel = innerLevel;
	}

	public Integer getLiveLevel() {
		return liveLevel;
	}

	public void setLiveLevel(Integer liveLevel) {
		this.liveLevel = liveLevel;
	}
}