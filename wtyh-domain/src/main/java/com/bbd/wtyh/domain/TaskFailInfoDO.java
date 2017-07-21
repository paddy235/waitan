package com.bbd.wtyh.domain;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public class TaskFailInfoDO extends BaseDO{

    private  Integer taskId;

    private String failName;

    private String failReason;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getFailName() {
        return failName;
    }

    public void setFailName(String failName) {
        this.failName = failName;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }
}
