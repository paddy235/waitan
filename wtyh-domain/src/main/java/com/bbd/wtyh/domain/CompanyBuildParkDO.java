package com.bbd.wtyh.domain;


public class CompanyBuildParkDO {

	private Integer comAreaId;
	private Integer parkAreaId;
	private String parkName;
	private String buildName;

	public Integer getComAreaId() {
		return comAreaId;
	}

	public void setComAreaId(Integer comAreaId) {
		this.comAreaId = comAreaId;
	}

	public Integer getParkAreaId() {
		return parkAreaId;
	}

	public void setParkAreaId(Integer parkAreaId) {
		this.parkAreaId = parkAreaId;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
}