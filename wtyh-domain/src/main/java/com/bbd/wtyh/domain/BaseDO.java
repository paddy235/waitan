package com.bbd.wtyh.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Marco on 2016/8/5 0005.
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class BaseDO implements Serializable {

    /** 逻辑主键 */
    private Integer id;

    /** 创建人 */
    @Column(name = "create_by", updatable = false)
    private String createBy;

    /** 创建时间 */
    @Column(name = "create_date", updatable = false)
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format = "YYYY-MM-dd HH:mm:ss")
    private Date createDate;
    /** 修改人 */
    @Column(name = "update_by")
    private String updateBy;

    /** 修改时间 */
    @Column(name = "update_date")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format = "YYYY-MM-dd HH:mm:ss")
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
