package com.bbd.wtyh.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

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

	@Column(name = "parent_id")
	private Integer parentId;

	@Column
	private String description;

	@Column
	private String type;

	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "update_date")
	private Date updateDate;

	@Column(name = "create_by")
	private String createBy;

	@Column(name = "update_by")
	private String updateBy;

	/** 是否选中 */
	private boolean checked;

	/** 权限集 */
	@JSONField(serialize = false)
	private List<ResourceDo> resources;

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

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
	 * 获取 是否选中
	 *
	 * @return checked 是否选中
	 */
	public boolean isChecked() {
		return this.checked;
	}

	/**
	 * 设置 是否选中
	 *
	 * @param checked
	 *            是否选中
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}