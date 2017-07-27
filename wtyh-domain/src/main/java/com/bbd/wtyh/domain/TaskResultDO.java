package com.bbd.wtyh.domain;

/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class TaskResultDO {

    private Integer planCount;

    private Integer successCount;

    private Integer failCount;

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
