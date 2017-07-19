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

    @Column(name = "pull_file_task_id")
    private Integer pullFileTaskId;

    @Column(name = "file_name")
    private String fileName;

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }

    public Integer getPullFileTaskId() {
        return pullFileTaskId;
    }

    public void setPullFileTaskId(Integer pullFileTaskId) {
        this.pullFileTaskId = pullFileTaskId;
    }
}
