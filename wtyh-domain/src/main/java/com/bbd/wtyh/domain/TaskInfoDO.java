package com.bbd.wtyh.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bbd.wtyh.domain.enums.TaskDataSource;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * auto create
 *
 * @author ly.sorm
 *
 *         2017-06-14 14:00:34
 */
@Entity
@Table(name = "timing_task_info")
public class TaskInfoDO {

	/** task id */
	@Id
	@Column(name = "id")
	private Integer id;

	/** 任务名称 */
	@Column(name = "task_name")
	private String taskName;

	/** 任务KEY */
	@Column(name = "task_key")
	private String taskKey;

	/**  */
	@Column(name = "task_group")
	private String taskGroup;

	/** 时间表达式 */
	@Column(name = "cron")
	private String cron;

	/** 时间表达式描述 */
	@Column(name = "cron_desc")
	private String cronDesc;

	/** 执行目标类 */
	@Column(name = "target_class")
	private String targetClass;

	/** 执行目标方法 */
	@Column(name = "target_method")
	private String targetMethod;

	/** 任务描述 */
	@Column(name = "description")
	private String description;

	/** 任务开始时间 */
	@Column(name = "start_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startDate;

	/** 任务结束时间 */
	@Column(name = "end_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endDate;

	/** 数据来源 */
	@Column(name = "data_source")
	private Integer dataSource;

	/** 任务状态 */
	@Column(name = "state")
	private Integer state;

	/** 是否显示 */
	@Column(name = "is_show")
	private Integer isShow;

	/** 数据来源名称 */
	private String dataSourceName;

	/** 下一次更新时间 */
	private Date nextStartDate;

	/**
	 * 获取 task id
	 *
	 * @return id task id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置 task id
	 *
	 * @param id
	 *            task id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取 任务名称
	 *
	 * @return taskName 任务名称
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * 设置 任务名称
	 *
	 * @param taskName
	 *            任务名称
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * 获取 任务KEY
	 *
	 * @return taskKey 任务KEY
	 */
	public String getTaskKey() {
		return taskKey;
	}

	/**
	 * 设置 任务KEY
	 *
	 * @param taskKey
	 *            任务KEY
	 */
	public void setTaskKey(String taskKey) {
		this.taskKey = taskKey;
	}

	/**
	 * 获取
	 *
	 * @return taskGroup
	 */
	public String getTaskGroup() {
		return taskGroup;
	}

	/**
	 * 设置
	 *
	 * @param taskGroup
	 */
	public void setTaskGroup(String taskGroup) {
		this.taskGroup = taskGroup;
	}

	/**
	 * 获取 时间表达式
	 *
	 * @return cron 时间表达式
	 */
	public String getCron() {
		return cron;
	}

	/**
	 * 设置 时间表达式
	 *
	 * @param cron
	 *            时间表达式
	 */
	public void setCron(String cron) {
		this.cron = cron;
	}

	/**
	 * 获取 时间表达式描述
	 *
	 * @return cronDesc 时间表达式描述
	 */
	public String getCronDesc() {
		return cronDesc;
	}

	/**
	 * 设置 时间表达式描述
	 *
	 * @param cronDesc
	 *            时间表达式描述
	 */
	public void setCronDesc(String cronDesc) {
		this.cronDesc = cronDesc;
	}

	/**
	 * 获取 执行目标类
	 *
	 * @return targetClass 执行目标类
	 */
	public String getTargetClass() {
		return targetClass;
	}

	/**
	 * 设置 执行目标类
	 *
	 * @param targetClass
	 *            执行目标类
	 */
	public void setTargetClass(String targetClass) {
		this.targetClass = targetClass;
	}

	/**
	 * 获取 执行目标方法
	 *
	 * @return targetMethod 执行目标方法
	 */
	public String getTargetMethod() {
		return targetMethod;
	}

	/**
	 * 设置 执行目标方法
	 *
	 * @param targetMethod
	 *            执行目标方法
	 */
	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}

	/**
	 * 获取 任务描述
	 *
	 * @return description 任务描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置 任务描述
	 *
	 * @param description
	 *            任务描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取 任务开始时间
	 *
	 * @return startDate 任务开始时间
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * 设置 任务开始时间
	 *
	 * @param startDate
	 *            任务开始时间
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * 获取 任务结束时间
	 *
	 * @return endDate 任务结束时间
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * 设置 任务结束时间
	 *
	 * @param endDate
	 *            任务结束时间
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 获取 数据来源
	 *
	 * @return dataSource 数据来源
	 */
	public Integer getDataSource() {
		return dataSource;
	}

	/**
	 * 设置 数据来源
	 *
	 * @param dataSource
	 *            数据来源
	 */
	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 获取 任务状态
	 *
	 * @return state 任务状态
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * 设置 任务状态
	 *
	 * @param state
	 *            任务状态
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取 显示状态
	 *
	 * @return show 显示状态
	 */
	public Integer getIsShow() {
		return isShow;
	}
	/**
	 * 设置 显示状态
	 *
	 * @return show
	 *            显示状态
	 */
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}


	public String getDataSourceName() {
		return TaskDataSource.getDataSourceName(this.dataSource);
	}

	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}


	public Date getNextStartDate() {
		return nextStartDate;
	}

	public void setNextStartDate(Date nextStartDate) {
		this.nextStartDate = nextStartDate;
	}

}