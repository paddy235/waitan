package com.bbd.wtyh.domain;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Table(name = "resource")
public class ResourceDo extends BaseDO {

	@Id
	private Integer id;

	@Column
	private String code;

	@Column
	private String name;

	@Column(name = "parent_code")
	private String parentCode;

	@Column
	private String type;

	@Column
	private String url;

	private String resourcePermission;

	@Column(name = "display_order")
	private Integer displayOrder;

	/** 创建人 */
	@Column(name = "create_by")
	private String createBy;

	/** 创建时间 */
	@Column(name = "create_date")
	private Date createDate;
	/** 修改人 */
	@Column(name = "update_by")
	private String updateBy;

	/** 修改时间 */
	@Column(name = "update_date")
	private Date updateDate;

	/** 子权限集 */
	@JSONField(serialize = false)
	private List<ResourceDo> childResource;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode == null ? null : parentCode.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getResourcePermission() {
		return resourcePermission;
	}

	public void setResourcePermission(String resourcePermission) {
		this.resourcePermission = resourcePermission == null ? null : resourcePermission.trim();
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy == null ? null : updateBy.trim();
	}

	/**
	 * 获取 子权限集
	 *
	 * @return childResource 子权限集
	 */
	public List<ResourceDo> getChildResource() {
		return this.childResource;
	}

	/**
	 * 设置 子权限集
	 *
	 * @param childResource
	 *            子权限集
	 */
	public void setChildResource(List<ResourceDo> childResource) {
		this.childResource = childResource;
	}
}