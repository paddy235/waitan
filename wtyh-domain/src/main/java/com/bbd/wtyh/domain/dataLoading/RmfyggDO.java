package com.bbd.wtyh.domain.dataLoading;

import java.util.Date;

/**
 * Created by wangchenge on 2016/8/21 0021.
 */
public class RmfyggDO {
    private Integer id;
    private String attachment;//附件
    private Date bbd_dotime;//抓取时间
    private String bbd_source;//数据源
    private String bbd_type;//bbd_type
    private Integer bbd_uptime;//时间戳
    private String bbd_url;//链接
    private String bbd_xgxx_id;//相关信息唯一ID
    private String litigant;//当事人
    private String notice_content;//公告内容
    private String notice_people;//公告人
    private String notice_time;//公告时间
    private String notice_type;//公告类型
    private String bbd_qyxx_id;//企业唯一ID
    private Date create_time;

    public RmfyggDO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Date getBbd_dotime() {
        return bbd_dotime;
    }

    public void setBbd_dotime(Date bbd_dotime) {
        this.bbd_dotime = bbd_dotime;
    }

    public String getBbd_source() {
        return bbd_source;
    }

    public void setBbd_source(String bbd_source) {
        this.bbd_source = bbd_source;
    }

    public String getBbd_type() {
        return bbd_type;
    }

    public void setBbd_type(String bbd_type) {
        this.bbd_type = bbd_type;
    }

    public Integer getBbd_uptime() {
        return bbd_uptime;
    }

    public void setBbd_uptime(Integer bbd_uptime) {
        this.bbd_uptime = bbd_uptime;
    }

    public String getBbd_url() {
        return bbd_url;
    }

    public void setBbd_url(String bbd_url) {
        this.bbd_url = bbd_url;
    }

    public String getBbd_xgxx_id() {
        return bbd_xgxx_id;
    }

    public void setBbd_xgxx_id(String bbd_xgxx_id) {
        this.bbd_xgxx_id = bbd_xgxx_id;
    }

    public String getLitigant() {
        return litigant;
    }

    public void setLitigant(String litigant) {
        this.litigant = litigant;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public String getNotice_people() {
        return notice_people;
    }

    public void setNotice_people(String notice_people) {
        this.notice_people = notice_people;
    }

    public String getNotice_time() {
        return notice_time;
    }

    public void setNotice_time(String notice_time) {
        this.notice_time = notice_time;
    }

    public String getNotice_type() {
        return notice_type;
    }

    public void setNotice_type(String notice_type) {
        this.notice_type = notice_type;
    }

    public String getBbd_qyxx_id() {
        return bbd_qyxx_id;
    }

    public void setBbd_qyxx_id(String bbd_qyxx_id) {
        this.bbd_qyxx_id = bbd_qyxx_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}