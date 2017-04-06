package com.bbd.wtyh.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * 角色Bean
 */
@Table(name = "role")
public class RoleDo extends BaseDO {

	@Id
	private Integer id;

	@Column
	private String name;
	/** 角色类型（用户类型） */
	@Column(name = "user_type")
	private String userType;

	@Column
	private String description;

	@Column
	private String type;

	@Column(name = "create_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;

	@Column(name = "update_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate;

	@Column(name = "create_by")
	private String createBy;

	@Column(name = "update_by")
	private String updateBy;

	/** 权限集 */
	@JSONField(serialize = false)
	private List<ResourceDo> resources;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy == null ? null : updateBy.trim();
	}

	/**
	 * 获取 权限集
	 *
	 * @return resources 权限集
	 */
	public List<ResourceDo> getResources() {
		return this.resources;
	}

	/**
	 * 设置 权限集
	 *
	 * @param resources
	 *            权限集
	 */
	public void setResources(List<ResourceDo> resources) {
		this.resources = resources;
	}

	/**
	 * 获取 角色类型（用户类型）
	 *
	 * @return UserType 角色类型（用户类型）
	 */
	public String getUserType() {
		return this.userType;
	}

	/**
	 * 设置 角色类型（用户类型）
	 *
	 * @param userType
	 *            角色类型（用户类型）
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
}