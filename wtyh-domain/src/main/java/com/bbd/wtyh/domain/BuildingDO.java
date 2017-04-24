package com.bbd.wtyh.domain;

import com.bbd.wtyh.util.CalculateUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "building")
public class BuildingDO extends BaseDO {

	@Id
	@Column(name = "building_id")
	private Integer buildingId;

	@Column
	private String name;

	@Column(name = "park_id")
	private Integer parkId;

	@Column(name = "img_url")
	private String imgUrl;

	/**
	 * @Fields finComNum : finance_company_number 新型金融企业数量
	 */
	private Integer finComNum;

	/**
	 * 企业数量
	 */
	private Integer total;

	/**
	 * @Fields ratio : finance_company_ratio 新型金融企业占比
	 */
	private String finComRatio;
	

	/**
	 * 重点关注企业数量
	 */
	@Transient
	private Integer importFocusNum;
	/**
	 * 一般关注企业数量
	 */
	@Transient
	private Integer commonFocusNum;
	
	public Integer getImportFocusNum() {
		return importFocusNum;
	}

	public void setImportFocusNum(Integer importFocusNum) {
		this.importFocusNum = importFocusNum;
	}

	public Integer getCommonFocusNum() {
		return commonFocusNum;
	}

	public void setCommonFocusNum(Integer commonFocusNum) {
		this.commonFocusNum = commonFocusNum;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getFinComNum() {
		return finComNum;
	}

	public void setFinComNum(Integer finComNum) {
		this.finComNum = finComNum;
	}

	public String getFinComRatio() {

		finComRatio = CalculateUtils.divide(finComNum * 100, total, 1) + "%";

		return finComRatio;
	}

	public void setFinComRatio(String finComRatio) {
		this.finComRatio = finComRatio;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getParkId() {
		return parkId;
	}

	public void setParkId(Integer parkId) {
		this.parkId = parkId;
	}
}