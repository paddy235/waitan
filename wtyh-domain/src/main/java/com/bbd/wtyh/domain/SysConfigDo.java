package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-06-07 10:58.
 */
@Entity
@Table(name = "sys_config")
public class SysConfigDo {

	/** ID */
	@Id
	@Column(name = "id")
	private Long id;

	/** 键 */
	@Column(name = "config_key")
	private String key;

	/** 值 */
	@Column(name = "config_value")
	private String value;

	/** 组 */
	@Column(name = "config_group")
	private String group;

	/** 描述 */
	@Column(name = "description")
	private String desc;

	/**
	 * 获取 ID
	 *
	 * @return id @Id@Column(name = "id")
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * 设置 ID
	 *
	 * @param id
	 * @Id@Column(name = "id")
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取 键
	 *
	 * @return key 键
	 */
	public String getKey() {
		return this.key;
	}

	/**
	 * 设置 键
	 *
	 * @param key
	 *            键
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 获取 值
	 *
	 * @return value 值
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * 设置 值
	 *
	 * @param value
	 *            值
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 获取 组
	 *
	 * @return group 组
	 */
	public String getGroup() {
		return this.group;
	}

	/**
	 * 设置 组
	 *
	 * @param group
	 *            组
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * 获取 描述
	 *
	 * @return desc 描述
	 */
	public String getDesc() {
		return this.desc;
	}

	/**
	 * 设置 描述
	 *
	 * @param desc
	 *            描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
