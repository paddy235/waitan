package com.bbd.wtyh.domain.dataLoading;

import java.util.Date;

/**
 * Created by wangchenge on 2016/8/21 0021.
 */
public class QyxxGdxxDO {
    private Integer id;
    private Date bbd_dotime;//抓取时间
    private String bbd_qyxx_id;//企业唯一ID
    private Integer bbd_uptime;//时间戳
    private String company_name;//名称
    private String idno;//证照号码
    private String idtype;//证照类型
    private String invest_amount;//出资额
    private String invest_name;//出资方式
    private String invest_ratio;//出资比例
    private String name_compid;//股东的类别判断
    private String no;//序号
    private String paid_contribution;//实缴出资额
    private String shareholder_detail;//股东详情
    private String shareholder_id;//股东唯一ID
    private String shareholder_name;//股东
    private String shareholder_type;//股东类型
    private String subscribed_capital;//认缴出资额
    private Date create_time;
    private String sumconam;
    private Integer task_id;
    public QyxxGdxxDO() {
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

    public String getBbd_qyxx_id() {
        return bbd_qyxx_id;
    }

    public void setBbd_qyxx_id(String bbd_qyxx_id) {
        this.bbd_qyxx_id = bbd_qyxx_id;
    }

    public Integer getBbd_uptime() {
        return bbd_uptime;
    }

    public void setBbd_uptime(Integer bbd_uptime) {
        this.bbd_uptime = bbd_uptime;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getInvest_amount() {
        return invest_amount;
    }

    public void setInvest_amount(String invest_amount) {
        this.invest_amount = invest_amount;
    }

    public String getInvest_name() {
        return invest_name;
    }

    public void setInvest_name(String invest_name) {
        this.invest_name = invest_name;
    }

    public String getInvest_ratio() {
        return invest_ratio;
    }

    public void setInvest_ratio(String invest_ratio) {
        this.invest_ratio = invest_ratio;
    }

    public String getName_compid() {
        return name_compid;
    }

    public void setName_compid(String name_compid) {
        this.name_compid = name_compid;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPaid_contribution() {
        return paid_contribution;
    }

    public void setPaid_contribution(String paid_contribution) {
        this.paid_contribution = paid_contribution;
    }

    public String getShareholder_detail() {
        return shareholder_detail;
    }

    public void setShareholder_detail(String shareholder_detail) {
        this.shareholder_detail = shareholder_detail;
    }

    public String getShareholder_id() {
        return shareholder_id;
    }

    public void setShareholder_id(String shareholder_id) {
        this.shareholder_id = shareholder_id;
    }

    public String getShareholder_name() {
        return shareholder_name;
    }

    public void setShareholder_name(String shareholder_name) {
        this.shareholder_name = shareholder_name;
    }

    public String getShareholder_type() {
        return shareholder_type;
    }

    public void setShareholder_type(String shareholder_type) {
        this.shareholder_type = shareholder_type;
    }

    public String getSubscribed_capital() {
        return subscribed_capital;
    }

    public void setSubscribed_capital(String subscribed_capital) {
        this.subscribed_capital = subscribed_capital;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getSumconam() {
        return sumconam;
    }

    public void setSumconam(String sumconam) {
        this.sumconam = sumconam;
    }

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }
}