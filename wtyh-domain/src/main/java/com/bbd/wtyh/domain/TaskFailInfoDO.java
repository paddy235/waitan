package com.bbd.wtyh.domain;

import com.bbd.wtyh.excel.annotation.Excel;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
@Table(name = "task_fail_info")
public class TaskFailInfoDO extends BaseDO{

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "task_id")
    private Integer taskId;

    @Column(name = "fail_name")
    @Excel(exportName = "名称")
    private String failName;

    @Column(name = "fail_reason")
    @Excel(exportName = "失败原因")
    private String failReason;

    @Column(name = "source_task_id")
    private Integer sourceTaskId;

    @Column(name = "type")
    private Integer type;

    @Column(name = "data_version")
    private String dataVersion;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getSourceTaskId() {
        return sourceTaskId;
    }

    public void setSourceTaskId(Integer sourceTaskId) {
        this.sourceTaskId = sourceTaskId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }
}
