package com.bbd.wtyh.domain.dto;

import java.util.Date;


import com.bbd.wtyh.domain.enums.TaskDataSource;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * auto create
 *
 * @author ly.sorm
 *
 *         2017-06-14 14:00:34
 */

public class TaskInfoDTO {

	/** task id */
	private Integer id;

	/** 任务名称 */
	private String taskName;

	/** 任务KEY */
	private String taskKey;

	/**  */
	private String taskGroup;

	/** 时间表达式 */
	private String cron;

	/** 时间表达式描述 */
	private String cronDesc;

	/** 任务描述 */
	private String description;
	/** 更新日期 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date updateDate;
	/** 任务开始时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startDate;

	/** 任务结束时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endDate;

	/** 数据来源 */
	private Integer dataSource;

	/** 任务状态 */
	private Integer state;

	/** 是否显示 */
	private Integer isShow;

	/** 数据来源名称 */
	private String dataSourceName;

	/** 下一次更新时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date nextStartDate;

	/** 重新执行 */
	private Integer reExecute;

	private Integer planCount;

	private Integer successCount;

	private Integer failCount;

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


	public Integer getReExecute() {
		return reExecute;
	}

	public void setReExecute(Integer reExecute) {
		this.reExecute = reExecute;
	}

	public Integer getPlanCount() {
		return planCount;
	}

	public void setPlanCount(Integer planCount) {
		this.planCount = planCount;
	}

	public Integer getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(Integer successCount) {
		this.successCount = successCount;
	}

	public Integer getFailCount() {
		return failCount;
	}

	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}