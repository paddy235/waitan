package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/6/12 0012.
 */
@Table(name = "data_loading_fail_info")
public class DataLoadingFailInfoDO extends BaseDO {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "task_id")
    private Integer taskId;

    @Column(name = "source_task_id")
    private Integer sourceTaskId;

    @Column(name = "error_name")
    private String errorName;

    @Column(name = "type")
    private String type;

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

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }

    public Integer getSourceTaskId() {
        return sourceTaskId;
    }

    public void setSourceTaskId(Integer sourceTaskId) {
        this.sourceTaskId = sourceTaskId;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
