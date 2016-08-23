package com.bbd.wtyh.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class SyncDataInformationDO extends BaseDO {
    private Integer id;
    private String content;//数据内容
    /**
     * 1:静态风险指数表 static_risk_dat
     * 2:动态风险指数表 dynamic_risk_data
     * 3:招聘信息表 recruit_data
     * 4:风险指数统计表 index_data
     * 5关联方统计信息表relation_data
     */
    private Integer type;//数据类型
    private String dataVersion; //数据版本
    private Date receiveDate;//推送时间
    private Integer status;//同步状态1:已同步0:未同步

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}