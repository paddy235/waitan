package com.bbd.wtyh.domain;

import javax.persistence.Id;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * auto create
 *
 * @author ly.sorm
 *
 *		   2017-05-04 10:29:46
 *		   updateby cgj
 */
@Entity
@Table(name = "company_credit_raw_info")
public class CompanyCreditRawInfoDO implements Cloneable{
	@Override
	public CompanyCreditRawInfoDO clone() {
		CompanyCreditRawInfoDO ccri = null;
		try{
			ccri = (CompanyCreditRawInfoDO)super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return ccri;
	}

	/** pk */
	@Id
	@Column(name = "id")
	private Integer id;

	/** company_id,企业ID */
	@Column(name = "company_id")
	private Integer companyId;

	/** name,企业名称 */
	@Column(name = "company_name")
	private String companyName;

	/** zjhm,组织机构代码 */
	@Column(name = "organization_code")
	private String organizationCode;

	/** tydm,社会信用统一代码 */
	@Column(name = "credit_code")
	private String creditCode;

	/** 查询编号 */
	@Column(name = "cxbh")
	private String cxbh;

	/** 资源解析代码 */
	@Column(name = "resources")
	private String resources;

	/** 资源名称 */
	@Column(name = "resource_name")
	private String resourceName;

	/** 资源代码 */
	@Column(name = "resource_code")
	private String resourceCode;

	/** 信息所属单位代码 */
	@Column(name = "xxssdw_code")
	private String xxssdwCode;

	/** 信息所属单位 */
	@Column(name = "xxssdw")
	private String xxssdw;

	/** 信息类别 */
	@Column(name = "xxlb")
	private String xxlb;

	/** 原始正文 */
	@Column(name = "content")
	private String content;

	/** 创建人 */
	@Column(name = "create_by")
	private String createBy;

	/** 创建日期 */
	@Column(name = "create_date")
	private Date createDate;

	/** 任务ID */
	@Column(name = "task_id")
	private Integer taskId;

	/**
	 * 获取 pk
	 *
	 * @return id pk
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置 pk
	 *
	 * @param id pk
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * 获取 name,企业名称
	 *
	 * @return companyName name,企业名称
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 设置 name,企业名称
	 *
	 * @param companyName name,企业名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 获取 zjhm,组织机构代码
	 *
	 * @return organizationCode zjhm,组织机构代码
	 */
	public String getOrganizationCode() {
		return organizationCode;
	}

	/**
	 * 设置 zjhm,组织机构代码
	 *
	 * @param organizationCode zjhm,组织机构代码
	 */
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	/**
	 * 获取 tydm,社会信用统一代码
	 *
	 * @return creditCode tydm,社会信用统一代码
	 */
	public String getCreditCode() {
		return creditCode;
	}

	/**
	 * 设置 tydm,社会信用统一代码
	 *
	 * @param creditCode tydm,社会信用统一代码
	 */
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	/**
	 * 获取 查询编号
	 *
	 * @return cxbh 查询编号
	 */
	public String getCxbh() {
		return cxbh;
	}

	/**
	 * 设置 查询编号
	 *
	 * @param cxbh 查询编号
	 */
	public void setCxbh(String cxbh) {
		this.cxbh = cxbh;
	}

	/**
	 * 获取 资源解析代码
	 *
	 * @return resources 资源解析代码
	 */
	public String getResources() {
		return resources;
	}

	/**
	 * 设置 资源解析代码
	 *
	 * @param resources 资源解析代码
	 */
	public void setResources(String resources) {
		this.resources = resources;
	}

	/**
	 * 获取 资源名称
	 *
	 * @return resourceName 资源名称
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * 设置 资源名称
	 *
	 * @param resourceName 资源名称
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 * 获取 资源代码
	 *
	 * @return resourceCode 资源代码
	 */
	public String getResourceCode() {
		return resourceCode;
	}

	/**
	 * 设置 资源代码
	 *
	 * @param resourceCode 资源代码
	 */
	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	/**
	 * 获取 信息所属单位代码
	 *
	 * @return xxssdwCode 信息所属单位代码
	 */
	public String getXxssdwCode() {
		return xxssdwCode;
	}

	/**
	 * 设置 信息所属单位代码
	 *
	 * @param xxssdwCode 信息所属单位代码
	 */
	public void setXxssdwCode(String xxssdwCode) {
		this.xxssdwCode = xxssdwCode;
	}

	/**
	 * 获取 信息所属单位
	 *
	 * @return xxssdw 信息所属单位
	 */
	public String getXxssdw() {
		return xxssdw;
	}

	/**
	 * 设置 信息所属单位
	 *
	 * @param xxssdw 信息所属单位
	 */
	public void setXxssdw(String xxssdw) {
		this.xxssdw = xxssdw;
	}

	/**
	 * 获取 信息类别
	 *
	 * @return xxlb 信息类别
	 */
	public String getXxlb() {
		return xxlb;
	}

	/**
	 * 设置 信息类别
	 *
	 * @param xxlb 信息类别
	 */
	public void setXxlb(String xxlb) {
		this.xxlb = xxlb;
	}

	/**
	 * 获取 原始正文
	 *
	 * @return content 原始正文
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置 原始正文
	 *
	 * @param content 原始正文
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取 创建人
	 *
	 * @return createBy 创建人
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * 设置 创建人
	 *
	 * @param createBy 创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 获取 创建日期
	 *
	 * @return createDate 创建日期
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置 创建日期
	 *
	 * @param createDate 创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

}