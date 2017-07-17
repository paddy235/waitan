package com.bbd.wtyh.domain.dataLoading;

import java.util.Date;

/**
 * Created by wangchenge on 2016/8/21 0021.
 */
public class ZhixingDO {
    private Integer id;
    private Date bbd_dotime;//抓取时间
    private String bbd_source;//数据源
    private String bbd_type;//bbd_type
    private Integer bbd_uptime;//时间戳
    private String bbd_url;//'链接'
    private String bbd_xgxx_id;//'相关信息唯一ID'
    private String case_code;//'案号'
    private Date case_create_time;//'立案时间'
    private String case_state;//'案件状态'
    private String company_name;//名称
    private String exec_court_name;//执行法院
    private Float exec_subject;//'执行标的'
    private String idtype;//证照类型
    private String pname;//'被执行人姓名/名称'
    private String pname_id;//'身份证号码/组织机构代码'
    private String type;//'类型'
    private String bbd_qyxx_id;//企业唯一ID
    private Date create_time;
    private Integer task_id;
    public ZhixingDO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCase_code() {
        return case_code;
    }

    public void setCase_code(String case_code) {
        this.case_code = case_code;
    }

    public Date getCase_create_time() {
        return case_create_time;
    }

    public void setCase_create_time(Date case_create_time) {
        this.case_create_time = case_create_time;
    }

    public String getCase_state() {
        return case_state;
    }

    public void setCase_state(String case_state) {
        this.case_state = case_state;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getExec_court_name() {
        return exec_court_name;
    }

    public void setExec_court_name(String exec_court_name) {
        this.exec_court_name = exec_court_name;
    }

    public Float getExec_subject() {
        return exec_subject;
    }

    public void setExec_subject(Float exec_subject) {
        this.exec_subject = exec_subject;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPname_id() {
        return pname_id;
    }

    public void setPname_id(String pname_id) {
        this.pname_id = pname_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }
}