package com.bbd.wtyh.domain.dto;

import java.util.Date;

/**
 * 上海网贷平台数据展示
 *
 * @author Ian.Su
 * @since 2016年8月10日 下午2:50:44
 */
public class PlatInfoDTO {

	private String platName;

	private String companyName;

	private String legalPerson;

	private Date registeredDate;

	private Integer registereCapital;

	private String address;

	private String website;

	private Date createDate;

	public String getPlatName() {
		return platName;
	}

	public void setPlatName(String platName) {
		this.platName = platName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public Integer getRegistereCapital() {
		return registereCapital;
	}

	public void setRegistereCapital(Integer registereCapital) {
		this.registereCapital = registereCapital;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
