package com.bbd.wtyh.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * auto create
 * 排查信息
 * @author ly.sorm
 *
 *		   2017-04-18 16:04:07
 */
@Entity
@Table(name = "investigation_info")
public class InvestigationInfoDO {

	/** id */
	@Column(name = "id")
	private Integer id;

	/** 企业ID */
	@Column(name = "company_id")
	private Integer companyId;

	/** 企业名称 */
	@Column(name = "company_name")
	private String companyName;

	/**  */
	@Column(name = "title")
	private String title;

	/** 详情 */
	@Column(name = "detail")
	private String detail;

	/**  */
	@Column(name = "create_by")
	private String createBy;

	/**  */
	@Column(name = "create_date")
	private Date createDate;

	/**  */
	@Column(name = "update_by")
	private String updateBy;

	/**  */
	@Column(name = "update_date")
	private Date updateDate;

	/**
	 * 获取 id
	 *
	 * @return id id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置 id
	 *
	 * @param id id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取 企业ID
	 *
	 * @return companyId 企业ID
	 */
	public Integer getCompanyId() {
		return companyId;
	}

	/**
	 * 设置 企业ID
	 *
	 * @param companyId 企业ID
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * 获取 企业名称
	 *
	 * @return companyName 企业名称
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 设置 企业名称
	 *
	 * @param companyName 企业名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 获取 
	 *
	 * @return title 
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置 
	 *
	 * @param title 
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取 详情
	 *
	 * @return detail 详情
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * 设置 详情
	 *
	 * @param detail 详情
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * 获取 
	 *
	 * @return createBy 
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * 设置 
	 *
	 * @param createBy 
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 获取 
	 *
	 * @return createDate 
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置 
	 *
	 * @param createDate 
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取 
	 *
	 * @return updateBy 
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * 设置 
	 *
	 * @param updateBy 
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 获取 
	 *
	 * @return updateDate 
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置 
	 *
	 * @param updateDate 
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}