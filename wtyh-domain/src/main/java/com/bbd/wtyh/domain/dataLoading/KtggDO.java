package com.bbd.wtyh.domain.dataLoading;

import java.util.Date;

/**
 * Created by wangchenge on 2016/8/21 0021.
 */
public class KtggDO {
    private Integer id;
    private String action_cause;//案由
    private Date bbd_dotime;//抓取时间
    private String bbd_qyxx_id;//企业唯一ID
    private String bbd_source;//数据源
    private String bbd_type;//bbd_type
    private Integer bbd_uptime;//时间戳
    private String bbd_version;//version
    private String case_code;//案号
    private String city;//city
    private String litigant;//当事人
    private String main;//main
    private String title;//title
    private Date trial_date;//开庭日期
    private Date create_time;
    private String bbd_url;
    private Date asstarting;//任职起始（上市公司）

    public KtggDO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction_cause() {
        return action_cause;
    }

    public void setAction_cause(String action_cause) {
        this.action_cause = action_cause;
    }

    public Date getBbd_dotime() {
        return bbd_dotime;
    }

    public void setBbd_dotime(Date bbd_dotime) {
        this.bbd_dotime = bbd_dotime;
    }

    public String getBbd_qyxx_id() {
        return bbd_qyxx_id;
    }

    public void setBbd_qyxx_id(String bbd_qyxx_id) {
        this.bbd_qyxx_id = bbd_qyxx_id;
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

    public String getBbd_version() {
        return bbd_version;
    }

    public void setBbd_version(String bbd_version) {
        this.bbd_version = bbd_version;
    }

    public String getCase_code() {
        return case_code;
    }

    public void setCase_code(String case_code) {
        this.case_code = case_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLitigant() {
        return litigant;
    }

    public void setLitigant(String litigant) {
        this.litigant = litigant;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTrial_date() {
        return trial_date;
    }

    public void setTrial_date(Date trial_date) {
        this.trial_date = trial_date;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getBbd_url() {
        return bbd_url;
    }

    public void setBbd_url(String bbd_url) {
        this.bbd_url = bbd_url;
    }

    public Date getAsstarting() {
        return asstarting;
    }

    public void setAsstarting(Date asstarting) {
        this.asstarting = asstarting;
    }
}