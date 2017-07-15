package com.bbd.wtyh.domain.dataLoading;

import java.util.Date;
import java.util.List;

/**
 * Created by wangchenge on 2016/8/21 0021.
 */
public class QyxxBasicDO {
    private Integer id;
    private String address;//'地址'
    private Date approval_date;//'核准日期'
    private Date bbd_dotime;//日期
    private String bbd_history_names;
    private String bbd_qyxx_id;//'企业唯一ID'
    private String bbd_type;//表类型
    private Integer bbd_uptime;//时间戳
    private Date cancel_date;//'抓取时间'
    private String company_companytype;//'企业类型_映射结果'
    private String company_county;//''企业区县''
    private String company_currency;//''注册币种_映射结果''
    private String company_enterprise_status;//''登记状态_映射结果''
    private String company_industry;//''行业分类''
    private String company_name;//'名称'
    private String company_province;//'省份_映射结果'
    private String company_regorg;//'登记机关_映射结果'
    private String company_type;//类型
    private String credit_code;//社会信用代码
    private String enterprise_status;//登记状态
    private Date esdate;//成立日期
    private String form;//'组成形式'
    private String frname;//'法定代表人'
    private String frname_id;//法定代表人唯一ID
    private String invest_cap;//出资额
    private Float investcap_amount;//投资总额_金额
    private String investcap_currency;//'投资总额_币种'
    private String ipo_company;//上市公司标识
    private String openfrom;//'营业期限自'
    private String opento;//'营业期限至'
    private String operate_scope;//'经营范围'
    private String operating_period;//'经营期限'
    private String parent_firm;//'派出企业名称'
    private String realcap;//'实收资本'
    private Float realcap_amount;//'实收资本_金额'
    private String realcap_currency;//'实收资本_币种'
    private String regcap;//'注册资金'
    private Float regcap_amount;//'注册资本_金额'
    private String regcap_currency;//'注册资本_币种'
    private String regcapcur;//'注册币种'
    private String regno;//'注册号'
    private String regno_or_creditcode;//'注册号/统一社会信用代码'
    private String regorg;//'登记机关'
    private Date revoke_date;//'吊销日期'
    private String type;//'爬虫源省份记录（ 中文）'
    private String frname_compid;
    private Date create_time;

    public QyxxBasicDO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getApproval_date() {
        return approval_date;
    }

    public void setApproval_date(Date approval_date) {
        this.approval_date = approval_date;
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

    public Date getCancel_date() {
        return cancel_date;
    }

    public void setCancel_date(Date cancel_date) {
        this.cancel_date = cancel_date;
    }

    public String getCompany_companytype() {
        return company_companytype;
    }

    public void setCompany_companytype(String company_companytype) {
        this.company_companytype = company_companytype;
    }

    public String getCompany_county() {
        return company_county;
    }

    public void setCompany_county(String company_county) {
        this.company_county = company_county;
    }

    public String getCompany_currency() {
        return company_currency;
    }

    public void setCompany_currency(String company_currency) {
        this.company_currency = company_currency;
    }

    public String getCompany_enterprise_status() {
        return company_enterprise_status;
    }

    public void setCompany_enterprise_status(String company_enterprise_status) {
        this.company_enterprise_status = company_enterprise_status;
    }

    public String getCompany_industry() {
        return company_industry;
    }

    public void setCompany_industry(String company_industry) {
        this.company_industry = company_industry;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_province() {
        return company_province;
    }

    public void setCompany_province(String company_province) {
        this.company_province = company_province;
    }

    public String getCompany_regorg() {
        return company_regorg;
    }

    public void setCompany_regorg(String company_regorg) {
        this.company_regorg = company_regorg;
    }

    public String getCompany_type() {
        return company_type;
    }

    public void setCompany_type(String company_type) {
        this.company_type = company_type;
    }

    public String getCredit_code() {
        return credit_code;
    }

    public void setCredit_code(String credit_code) {
        this.credit_code = credit_code;
    }

    public String getEnterprise_status() {
        return enterprise_status;
    }

    public void setEnterprise_status(String enterprise_status) {
        this.enterprise_status = enterprise_status;
    }

    public Date getEsdate() {
        return esdate;
    }

    public void setEsdate(Date esdate) {
        this.esdate = esdate;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getFrname() {
        return frname;
    }

    public void setFrname(String frname) {
        this.frname = frname;
    }

    public String getFrname_id() {
        return frname_id;
    }

    public void setFrname_id(String frname_id) {
        this.frname_id = frname_id;
    }

    public String getInvest_cap() {
        return invest_cap;
    }

    public void setInvest_cap(String invest_cap) {
        this.invest_cap = invest_cap;
    }

    public Float getInvestcap_amount() {
        return investcap_amount;
    }

    public void setInvestcap_amount(Float investcap_amount) {
        this.investcap_amount = investcap_amount;
    }

    public String getInvestcap_currency() {
        return investcap_currency;
    }

    public void setInvestcap_currency(String investcap_currency) {
        this.investcap_currency = investcap_currency;
    }

    public String getIpo_company() {
        return ipo_company;
    }

    public void setIpo_company(String ipo_company) {
        this.ipo_company = ipo_company;
    }

    public String getOpenfrom() {
        return openfrom;
    }

    public void setOpenfrom(String openfrom) {
        this.openfrom = openfrom;
    }

    public String getOpento() {
        return opento;
    }

    public void setOpento(String opento) {
        this.opento = opento;
    }

    public String getOperate_scope() {
        return operate_scope;
    }

    public void setOperate_scope(String operate_scope) {
        this.operate_scope = operate_scope;
    }

    public String getOperating_period() {
        return operating_period;
    }

    public void setOperating_period(String operating_period) {
        this.operating_period = operating_period;
    }

    public String getParent_firm() {
        return parent_firm;
    }

    public void setParent_firm(String parent_firm) {
        this.parent_firm = parent_firm;
    }

    public String getRealcap() {
        return realcap;
    }

    public void setRealcap(String realcap) {
        this.realcap = realcap;
    }

    public Float getRealcap_amount() {
        return realcap_amount;
    }

    public void setRealcap_amount(Float realcap_amount) {
        this.realcap_amount = realcap_amount;
    }

    public String getRealcap_currency() {
        return realcap_currency;
    }

    public void setRealcap_currency(String realcap_currency) {
        this.realcap_currency = realcap_currency;
    }

    public String getRegcap() {
        return regcap;
    }

    public void setRegcap(String regcap) {
        this.regcap = regcap;
    }

    public Float getRegcap_amount() {
        return regcap_amount;
    }

    public void setRegcap_amount(Float regcap_amount) {
        this.regcap_amount = regcap_amount;
    }

    public String getRegcap_currency() {
        return regcap_currency;
    }

    public void setRegcap_currency(String regcap_currency) {
        this.regcap_currency = regcap_currency;
    }

    public String getRegcapcur() {
        return regcapcur;
    }

    public void setRegcapcur(String regcapcur) {
        this.regcapcur = regcapcur;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getRegno_or_creditcode() {
        return regno_or_creditcode;
    }

    public void setRegno_or_creditcode(String regno_or_creditcode) {
        this.regno_or_creditcode = regno_or_creditcode;
    }

    public String getRegorg() {
        return regorg;
    }

    public void setRegorg(String regorg) {
        this.regorg = regorg;
    }

    public Date getRevoke_date() {
        return revoke_date;
    }

    public void setRevoke_date(Date revoke_date) {
        this.revoke_date = revoke_date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrname_compid() {
        return frname_compid;
    }

    public void setFrname_compid(String frname_compid) {
        this.frname_compid = frname_compid;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getBbd_history_names() {
        return bbd_history_names;
    }

    public void setBbd_history_names(String bbd_history_names) {
        this.bbd_history_names = bbd_history_names;
    }

}