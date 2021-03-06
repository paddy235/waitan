package com.bbd.wtyh.domain.bbdAPI;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.*;

/**
 * Created by wangchenge on 2016/8/13 0013.
 */
public class BaseDataDO implements Serializable{
    private String msg;
    private String err_code;
    private Integer rsize;
    private String total;
    private List<Results> results;

    public static class Results implements Serializable{
        private Jbxx jbxx;
        private List<Bgxx> bgxx;
        private List<Baxx> baxx;
        private List<Gdxx> gdxx;

        public Results() {
        }

        public Jbxx getJbxx() {
            return jbxx;
        }

        public void setJbxx(Jbxx jbxx) {
            this.jbxx = jbxx;
        }

        public List<Bgxx> getBgxx() {
            return bgxx;
        }

        public void setBgxx(List<Bgxx> bgxx) {
            this.bgxx = bgxx;
        }

        public List<Baxx> getBaxx() {
            return baxx;
        }

        public void setBaxx(List<Baxx> baxx) {
            this.baxx = baxx;
        }

        public List<Gdxx> getGdxx() {
            return gdxx;
        }

        public void setGdxx(List<Gdxx> gdxx) {
            this.gdxx = gdxx;
        }
    }
    public static class Bgxx implements Serializable {
        private String change_items;
        private String content_before_change;
        private String content_after_change;
        private String change_date;

        public Bgxx() {
        }

        public String getChange_items() {
            return change_items;
        }

        public void setChange_items(String change_items) {
            this.change_items = change_items;
        }

        public String getContent_before_change() {
            return content_before_change;
        }

        public void setContent_before_change(String content_before_change) {
            this.content_before_change = content_before_change;
        }

        public String getContent_after_change() {
            return content_after_change;
        }

        public void setContent_after_change(String content_after_change) {
            this.content_after_change = content_after_change;
        }

        public String getChange_date() {
            return change_date;
        }

        public void setChange_date(String change_date) {
            this.change_date = change_date;
        }
    }

    public static class Baxx implements Serializable {
        private String company_name;
        private String no;
        private String name;
        private String position;
        private String type;

        public Baxx() {
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class Gdxx implements Serializable {
        private String no;
        private String shareholder_name;
        private String shareholder_type;
        private String idtype;
        private String idno;

        /** ????????????*/
        private String shareholder_detail;

        /** ????????????*/
        private String invest_ratio;

        /** ?????????*/
        private String invest_amount;

        /** ????????????*/
        private String invest_name;

        /** ???????????????*/
        private String subscribed_capital;

        /** ???????????????*/
        private String paid_contribution;

        public Gdxx() {
        }

        public String getShareholder_detail() {
            return shareholder_detail;
        }

        public void setShareholder_detail(String shareholder_detail) {
            this.shareholder_detail = shareholder_detail;
        }

        public String getInvest_ratio() {
            return invest_ratio;
        }

        public void setInvest_ratio(String invest_ratio) {
            this.invest_ratio = invest_ratio;
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

        public String getSubscribed_capital() {
            return subscribed_capital;
        }

        public void setSubscribed_capital(String subscribed_capital) {
            this.subscribed_capital = subscribed_capital;
        }

        public String getPaid_contribution() {
            return paid_contribution;
        }

        public void setPaid_contribution(String paid_contribution) {
            this.paid_contribution = paid_contribution;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
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

        public String getIdtype() {
            return idtype;
        }

        public void setIdtype(String idtype) {
            this.idtype = idtype;
        }

        public String getIdno() {
            return idno;
        }

        public void setIdno(String idno) {
            this.idno = idno;
        }
    }

    public static class Jbxx implements Serializable {
        private String credit_code;
        private String _id;
        private String bbd_qyxx_id;
        private String regno_or_creditcode;
        private String regno;
        private String company_gis_lon;
        private String company_name;
        private String company_gis_lat;
        private String company_type;
        private String frname;
        private String regcap;
        //??????????????????
        private Float regcap_amount;
        //??????????????????
        private String regcap_currency;
        private String realcap;
        private String esdate;
        private String company_industry;
        private String approval_date;
        private String openfrom;
        private String opento;
        private String address;
        private String operate_scope;
        private String regorg;
        private String enterprise_status;
        private String revoke_date;
        private String invest_cap;
        private String regcapcur;
        private String realcap_currency;
        private String cancel_date;
        private String operating_period;
        private String form;
        private String company_province;
        private String company_county;
        private String ipo_company;
        private String company_enterprise_status;

        public String getCompany_enterprise_status() {
            return company_enterprise_status;
        }

        public void setCompany_enterprise_status(String company_enterprise_status) {
            this.company_enterprise_status = company_enterprise_status;
        }

        public Jbxx() {
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

        public String getRealcap_currency() {
            return realcap_currency;
        }

        public void setRealcap_currency(String realcap_currency) {
            this.realcap_currency = realcap_currency;
        }

        public String getCredit_code() {
            return credit_code;
        }

        public void setCredit_code(String credit_code) {
            this.credit_code = credit_code;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getBbd_qyxx_id() {
            return bbd_qyxx_id;
        }

        public void setBbd_qyxx_id(String bbd_qyxx_id) {
            this.bbd_qyxx_id = bbd_qyxx_id;
        }

        public String getRegno_or_creditcode() {
            return regno_or_creditcode;
        }

        public void setRegno_or_creditcode(String regno_or_creditcode) {
            this.regno_or_creditcode = regno_or_creditcode;
        }

        public String getRegno() {
            return regno;
        }

        public void setRegno(String regno) {
            this.regno = regno;
        }

        public String getCompany_gis_lon() {
            return company_gis_lon;
        }

        public void setCompany_gis_lon(String company_gis_lon) {
            this.company_gis_lon = company_gis_lon;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getCompany_gis_lat() {
            return company_gis_lat;
        }

        public void setCompany_gis_lat(String company_gis_lat) {
            this.company_gis_lat = company_gis_lat;
        }

        public String getCompany_type() {
            return company_type;
        }

        public void setCompany_type(String company_type) {
            this.company_type = company_type;
        }

        public String getFrname() {
            return frname;
        }

        public void setFrname(String frname) {
            this.frname = frname;
        }

        public String getRegcap() {
            return regcap;
        }

        public void setRegcap(String regcap) {
            this.regcap = regcap;
        }

        public String getRealcap() {
            return realcap;
        }

        public void setRealcap(String realcap) {
            this.realcap = realcap;
        }

        public String getEsdate() {
            return esdate;
        }

        public void setEsdate(String esdate) {
            this.esdate = esdate;
        }

        public String getCompany_industry() {
            return company_industry;
        }

        public void setCompany_industry(String company_industry) {
            this.company_industry = company_industry;
        }

        public String getApproval_date() {
            return approval_date;
        }

        public void setApproval_date(String approval_date) {
            this.approval_date = approval_date;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getOperate_scope() {
            return operate_scope;
        }

        public void setOperate_scope(String operate_scope) {
            this.operate_scope = operate_scope;
        }

        public String getRegorg() {
            return regorg;
        }

        public void setRegorg(String regorg) {
            this.regorg = regorg;
        }

        public String getEnterprise_status() {
            return enterprise_status;
        }

        public void setEnterprise_status(String enterprise_status) {
            this.enterprise_status = enterprise_status;
        }

        public String getRevoke_date() {
            return revoke_date;
        }

        public void setRevoke_date(String revoke_date) {
            this.revoke_date = revoke_date;
        }

        public String getInvest_cap() {
            return invest_cap;
        }

        public void setInvest_cap(String invest_cap) {
            this.invest_cap = invest_cap;
        }

        public String getRegcapcur() {
            return regcapcur;
        }

        public void setRegcapcur(String regcapcur) {
            this.regcapcur = regcapcur;
        }

        public String getCancel_date() {
            return cancel_date;
        }

        public void setCancel_date(String cancel_date) {
            this.cancel_date = cancel_date;
        }

        public String getOperating_period() {
            return operating_period;
        }

        public void setOperating_period(String operating_period) {
            this.operating_period = operating_period;
        }

        public String getForm() {
            return form;
        }

        public void setForm(String form) {
            this.form = form;
        }

        public String getCompany_province() {
            return company_province;
        }

        public void setCompany_province(String company_province) {
            this.company_province = company_province;
        }

        public String getCompany_county() {
            return company_county;
        }

        public void setCompany_county(String company_county) {
            this.company_county = company_county;
        }

        public String getIpo_company() {
            return ipo_company;
        }

        public void setIpo_company(String ipo_company) {
            this.ipo_company = ipo_company;
        }
    }


    public BaseDataDO() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public Integer getRsize() {
        return rsize;
    }

    public void setRsize(Integer rsize) {
        this.rsize = rsize;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}