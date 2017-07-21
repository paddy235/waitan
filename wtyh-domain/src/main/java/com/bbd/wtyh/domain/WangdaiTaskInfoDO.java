package com.bbd.wtyh.domain;

/**
 * Created by lixudong on 2017/7/20.
 */
public class WangdaiTaskInfoDO extends BaseDO{
    private Integer taskId;
    private String platName;//如果是增量就是平台名称，如果是全量就是api名称
    private Integer taskType;//0全量；1增量
    private String failReason;//失败原因

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    @Override
    public String toString() {
        return "WangdaiTaskInfoDO{" +
                "taskId='" + taskId + '\'' +
                ", platName='" + platName + '\'' +
                ", taskType='" + taskType + '\'' +
                ", failReason='" + failReason + '\'' +
                '}';
    }
}
