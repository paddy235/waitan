package com.bbd.wtyh.domain;

import com.bbd.wtyh.excel.annotation.Excel;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public class TaskFailInfoDO extends BaseDO{

    private  Integer taskId;
    @Excel(exportName = "名称")
    private String failName;
    @Excel(exportName = "失败原因")
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
