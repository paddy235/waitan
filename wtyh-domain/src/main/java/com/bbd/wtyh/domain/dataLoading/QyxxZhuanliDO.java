package com.bbd.wtyh.domain.dataLoading;

import y.util.D;

import java.util.Date;

/**
 * Created by wangchenge on 2016/8/21 0021.
 */
public class QyxxZhuanliDO {
    private Integer id;
    private String bbd_qyxx_id;//企业唯一ID
    private String address;//申请人地址
    private String agent_name;//代理人
    private String application_code;//申请（专利）号
    private String application_code_wanfang;//申请（专利）_万方
    private Date application_date;//申请日期
    private String class_code;//分类号
    private String class_code_wanfang;//分类号_万方
    private String company_name;//名称
    private String inventor;//发明（设计）人
    private String patent_type;//专利类型
    private String patent_agency;//专利代理机构
    private String title;//专利名称
    private String public_code;//公开（公告）号
    private Date publidate;//公开（公告）日
    private String applicant;//申请（专利权）人
    private String independent_claim;//主权项
    private String law_state;//法律状态
    private String main_classcode;//主分类号
    private String npc_code;//国别省市代码
    private Date approval_issue_date;//审定公告日
    private String approval_num;//审定号
    private String bg_publication_date;//更正文献出版日
    private String biology_preserve;//生物保藏
    private String compare_file;//对比文件
    private Date decode_announce_date;//解密公告日
    private String division_application;//分案原申请
    private String fmgb;//fmgb
    private String fmsq;//fmsq
    private String homeland_prority;//本国优先权
    private String pct_application_data;//PCT申请数据
    private String pct_enter_national;//PCT进入国家阶段日
    private String pct_publish_data;//PCT公布数据
    private String priority;//优先权
    private String wgsq;//wgsq
    private String xxsq;//xxsq
    private String bbd_source;//数据源
    private Date bbd_dotime;//抓取时间
    private String bbd_type;//表名
    private Integer bbd_uptime;//时间戳
    private String bbd_url;//url
    private String create_by;//创建人
    private Date create_time;//入库时间
    private String sumconam;//数据源
    private Integer task_id;

    public QyxxZhuanliDO() {
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getApplication_code() {
        return application_code;
    }

    public void setApplication_code(String application_code) {
        this.application_code = application_code;
    }

    public String getApplication_code_wanfang() {
        return application_code_wanfang;
    }

    public void setApplication_code_wanfang(String application_code_wanfang) {
        this.application_code_wanfang = application_code_wanfang;
    }

    public Date getApplication_date() {
        return application_date;
    }

    public void setApplication_date(Date application_date) {
        this.application_date = application_date;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public String getClass_code_wanfang() {
        return class_code_wanfang;
    }

    public void setClass_code_wanfang(String class_code_wanfang) {
        this.class_code_wanfang = class_code_wanfang;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getInventor() {
        return inventor;
    }

    public void setInventor(String inventor) {
        this.inventor = inventor;
    }

    public String getPatent_type() {
        return patent_type;
    }

    public void setPatent_type(String patent_type) {
        this.patent_type = patent_type;
    }

    public String getPatent_agency() {
        return patent_agency;
    }

    public void setPatent_agency(String patent_agency) {
        this.patent_agency = patent_agency;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublic_code() {
        return public_code;
    }

    public void setPublic_code(String public_code) {
        this.public_code = public_code;
    }

    public Date getPublidate() {
        return publidate;
    }

    public void setPublidate(Date publidate) {
        this.publidate = publidate;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getIndependent_claim() {
        return independent_claim;
    }

    public void setIndependent_claim(String independent_claim) {
        this.independent_claim = independent_claim;
    }

    public String getLaw_state() {
        return law_state;
    }

    public void setLaw_state(String law_state) {
        this.law_state = law_state;
    }

    public String getMain_classcode() {
        return main_classcode;
    }

    public void setMain_classcode(String main_classcode) {
        this.main_classcode = main_classcode;
    }

    public String getNpc_code() {
        return npc_code;
    }

    public void setNpc_code(String npc_code) {
        this.npc_code = npc_code;
    }

    public Date getApproval_issue_date() {
        return approval_issue_date;
    }

    public void setApproval_issue_date(Date approval_issue_date) {
        this.approval_issue_date = approval_issue_date;
    }

    public String getApproval_num() {
        return approval_num;
    }

    public void setApproval_num(String approval_num) {
        this.approval_num = approval_num;
    }

    public String getBg_publication_date() {
        return bg_publication_date;
    }

    public void setBg_publication_date(String bg_publication_date) {
        this.bg_publication_date = bg_publication_date;
    }

    public String getBiology_preserve() {
        return biology_preserve;
    }

    public void setBiology_preserve(String biology_preserve) {
        this.biology_preserve = biology_preserve;
    }

    public String getCompare_file() {
        return compare_file;
    }

    public void setCompare_file(String compare_file) {
        this.compare_file = compare_file;
    }

    public Date getDecode_announce_date() {
        return decode_announce_date;
    }

    public void setDecode_announce_date(Date decode_announce_date) {
        this.decode_announce_date = decode_announce_date;
    }

    public String getDivision_application() {
        return division_application;
    }

    public void setDivision_application(String division_application) {
        this.division_application = division_application;
    }

    public String getFmgb() {
        return fmgb;
    }

    public void setFmgb(String fmgb) {
        this.fmgb = fmgb;
    }

    public String getFmsq() {
        return fmsq;
    }

    public void setFmsq(String fmsq) {
        this.fmsq = fmsq;
    }

    public String getHomeland_prority() {
        return homeland_prority;
    }

    public void setHomeland_prority(String homeland_prority) {
        this.homeland_prority = homeland_prority;
    }

    public String getPct_application_data() {
        return pct_application_data;
    }

    public void setPct_application_data(String pct_application_data) {
        this.pct_application_data = pct_application_data;
    }

    public String getPct_enter_national() {
        return pct_enter_national;
    }

    public void setPct_enter_national(String pct_enter_national) {
        this.pct_enter_national = pct_enter_national;
    }

    public String getPct_publish_data() {
        return pct_publish_data;
    }

    public void setPct_publish_data(String pct_publish_data) {
        this.pct_publish_data = pct_publish_data;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getWgsq() {
        return wgsq;
    }

    public void setWgsq(String wgsq) {
        this.wgsq = wgsq;
    }

    public String getXxsq() {
        return xxsq;
    }

    public void setXxsq(String xxsq) {
        this.xxsq = xxsq;
    }

    public String getBbd_source() {
        return bbd_source;
    }

    public void setBbd_source(String bbd_source) {
        this.bbd_source = bbd_source;
    }

    public Date getBbd_dotime() {
        return bbd_dotime;
    }

    public void setBbd_dotime(Date bbd_dotime) {
        this.bbd_dotime = bbd_dotime;
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