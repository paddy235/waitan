package com.bbd.wtyh.domain;

import com.bbd.wtyh.constants.TaskState;

/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class TaskResultDO {

	private Integer planCount = 0;

	private Integer successCount = 0;

	private Integer failCount = 0;

	private TaskState state;

	public TaskResultDO() {
	}

	public TaskResultDO(Integer planCount, Integer successCount, Integer failCount) {
		this.planCount = planCount;
		this.successCount = successCount;
		this.failCount = failCount;
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


	public TaskState getState() {
		return state;
	}

	public void setState(TaskState state) {
		this.state = state;
	}
}
