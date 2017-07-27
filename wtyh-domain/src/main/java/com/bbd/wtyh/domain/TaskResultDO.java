package com.bbd.wtyh.domain;

/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class TaskResultDO {

	private Integer planCount = 0;

	private Integer successCount = 0;

	private Integer failCount = 0;

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
}
