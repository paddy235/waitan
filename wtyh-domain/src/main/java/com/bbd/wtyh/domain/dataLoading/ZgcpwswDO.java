package com.bbd.wtyh.domain.dataLoading;

import y.util.D;

import java.util.Date;

/**
 * Created by wangchenge on 2016/8/21 0021.
 */
public class ZgcpwswDO {
    private Integer id;
    private String bbd_qyxx_id;//企业唯一ID
    private String action_cause;//案由
    private String applicable_law;//适用法条
    private Date bbd_dotime;//抓取时间
    private String bbd_source;//数据源
    private String bbd_type;//bbd_type
    private Integer bbd_uptime;//时间戳
    private String bbd_url;//链接
    private String bbd_xgxx_id;//相关信息唯一ID
    private String case_type;//案件类型
    private String casecode;//案号
    private String caseout_come;//案件结果
    private String company_name;//company_name
    private String court_acceptance_fee;//受理费
    private String court_litigant;//法院当事人
    private String data_source;//data_source
    private String def_litigant;//被诉方当事人
    private String def_other_related;//被诉方其他相关人
    private String doc_type;//文书类型
    private String historycase;//历审案例
    private String ju_proc;//审理程序
    private String litigant;//当事人
    private String litigant_type;//当事人类型
    private String main;//文书内容
    private String pro_litigant;//起诉方当事人
    private String pro_other_related;//起诉方其他相关人
    private String rawdata;//rawdata
    private String rel_doc;//关联文书
    private String rel_doc_url;//关联文URL
    private Date sentence_date;//裁判日期
    private String title;//案件标题
    private String trial_court;//审理法院
    private String update;//'更新时间
    private Date create_time;

    public ZgcpwswDO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBbd_qyxx_id() {
        return bbd_qyxx_id;
    }

    public void setBbd_qyxx_id(String bbd_qyxx_id) {
        this.bbd_qyxx_id = bbd_qyxx_id;
    }

    public String getAction_cause() {
        return action_cause;
    }

    public void setAction_cause(String action_cause) {
        this.action_cause = action_cause;
    }

    public String getApplicable_law() {
        return applicable_law;
    }

    public void setApplicable_law(String applicable_law) {
        this.applicable_law = applicable_law;
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

    public String getCase_type() {
        return case_type;
    }

    public void setCase_type(String case_type) {
        this.case_type = case_type;
    }

    public String getCasecode() {
        return casecode;
    }

    public void setCasecode(String casecode) {
        this.casecode = casecode;
    }

    public String getCaseout_come() {
        return caseout_come;
    }

    public void setCaseout_come(String caseout_come) {
        this.caseout_come = caseout_come;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCourt_acceptance_fee() {
        return court_acceptance_fee;
    }

    public void setCourt_acceptance_fee(String court_acceptance_fee) {
        this.court_acceptance_fee = court_acceptance_fee;
    }

    public String getCourt_litigant() {
        return court_litigant;
    }

    public void setCourt_litigant(String court_litigant) {
        this.court_litigant = court_litigant;
    }

    public String getData_source() {
        return data_source;
    }

    public void setData_source(String data_source) {
        this.data_source = data_source;
    }

    public String getDef_litigant() {
        return def_litigant;
    }

    public void setDef_litigant(String def_litigant) {
        this.def_litigant = def_litigant;
    }

    public String getDef_other_related() {
        return def_other_related;
    }

    public void setDef_other_related(String def_other_related) {
        this.def_other_related = def_other_related;
    }

    public String getDoc_type() {
        return doc_type;
    }

    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }

    public String getHistorycase() {
        return historycase;
    }

    public void setHistorycase(String historycase) {
        this.historycase = historycase;
    }

    public String getJu_proc() {
        return ju_proc;
    }

    public void setJu_proc(String ju_proc) {
        this.ju_proc = ju_proc;
    }

    public String getLitigant() {
        return litigant;
    }

    public void setLitigant(String litigant) {
        this.litigant = litigant;
    }

    public String getLitigant_type() {
        return litigant_type;
    }

    public void setLitigant_type(String litigant_type) {
        this.litigant_type = litigant_type;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getPro_litigant() {
        return pro_litigant;
    }

    public void setPro_litigant(String pro_litigant) {
        this.pro_litigant = pro_litigant;
    }

    public String getPro_other_related() {
        return pro_other_related;
    }

    public void setPro_other_related(String pro_other_related) {
        this.pro_other_related = pro_other_related;
    }

    public String getRawdata() {
        return rawdata;
    }

    public void setRawdata(String rawdata) {
        this.rawdata = rawdata;
    }

    public String getRel_doc() {
        return rel_doc;
    }

    public void setRel_doc(String rel_doc) {
        this.rel_doc = rel_doc;
    }

    public String getRel_doc_url() {
        return rel_doc_url;
    }

    public void setRel_doc_url(String rel_doc_url) {
        this.rel_doc_url = rel_doc_url;
    }

    public Date getSentence_date() {
        return sentence_date;
    }

    public void setSentence_date(Date sentence_date) {
        this.sentence_date = sentence_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrial_court() {
        return trial_court;
    }

    public void setTrial_court(String trial_court) {
        this.trial_court = trial_court;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}