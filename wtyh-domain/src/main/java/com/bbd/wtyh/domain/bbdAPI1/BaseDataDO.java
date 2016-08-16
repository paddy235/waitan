package com.bbd.wtyh.domain.bbdAPI1;

import java.util.*;

/**
 * Created by wangchenge on 2016/8/13 0013.
 */
public class BaseDataDO {
    private String msg;
    private String err_code;
    private Integer rsize;
    private String total;
    private List<Results> results;

    public static class Results {
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
    public static class Bgxx {
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

    public static class Baxx {
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

    public static class Gdxx {
        private String no;
        private String shareholder_name;
        private String shareholder_type;
        private String idtype;
        private String idno;

        public Gdxx() {
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

    public static class Jbxx {
        private String credit_code;
        private String _id;
        private String regno_or_creditcode;
        private String regno;
        private String company_gis_lon;
        private String company_name;
        private String company_gis_lat;
        private String company_type;
        private String frname;
        private String regcap;
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
        private String cancel_date;
        private String operating_period;
        private String form;
        private String company_province;
        private String company_county;
        private String ipo_company;

        public Jbxx() {
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