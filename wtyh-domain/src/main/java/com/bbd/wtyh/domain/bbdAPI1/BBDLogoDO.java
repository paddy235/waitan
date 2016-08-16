package com.bbd.wtyh.domain.bbdAPI1;

import java.util.List;

/**
 * Created by Administrator on 2016/8/16 0016.
 */
public class BBDLogoDO {
    private String msg;
    private Integer rsize;
    private String total;
    private List<Result> results;
    private String err_code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public class Result{
        private String key;
        private String _id;
        private String data_source;
        private String bbd_version;
        private String bbd_url;
        private String rawdata;
        private String bbd_uptime;
        private String company_full_name;
        private String source;
        private String company_short;
        private String uuid;
        private String retain1;
        private String retain2;
        private String company_logo;
        private String bbd_dotime;
        private String bbd_qyxx_company_id;
        private String bbd_qyxx_branch_id;

        public Result() {
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getData_source() {
            return data_source;
        }

        public void setData_source(String data_source) {
            this.data_source = data_source;
        }

        public String getBbd_version() {
            return bbd_version;
        }

        public void setBbd_version(String bbd_version) {
            this.bbd_version = bbd_version;
        }

        public String getBbd_url() {
            return bbd_url;
        }

        public void setBbd_url(String bbd_url) {
            this.bbd_url = bbd_url;
        }

        public String getRawdata() {
            return rawdata;
        }

        public void setRawdata(String rawdata) {
            this.rawdata = rawdata;
        }

        public String getBbd_uptime() {
            return bbd_uptime;
        }

        public void setBbd_uptime(String bbd_uptime) {
            this.bbd_uptime = bbd_uptime;
        }

        public String getCompany_full_name() {
            return company_full_name;
        }

        public void setCompany_full_name(String company_full_name) {
            this.company_full_name = company_full_name;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getCompany_short() {
            return company_short;
        }

        public void setCompany_short(String company_short) {
            this.company_short = company_short;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getRetain1() {
            return retain1;
        }

        public void setRetain1(String retain1) {
            this.retain1 = retain1;
        }

        public String getRetain2() {
            return retain2;
        }

        public void setRetain2(String retain2) {
            this.retain2 = retain2;
        }

        public String getCompany_logo() {
            return company_logo;
        }

        public void setCompany_logo(String company_logo) {
            this.company_logo = company_logo;
        }

        public String getBbd_dotime() {
            return bbd_dotime;
        }

        public void setBbd_dotime(String bbd_dotime) {
            this.bbd_dotime = bbd_dotime;
        }

        public String getBbd_qyxx_company_id() {
            return bbd_qyxx_company_id;
        }

        public void setBbd_qyxx_company_id(String bbd_qyxx_company_id) {
            this.bbd_qyxx_company_id = bbd_qyxx_company_id;
        }

        public String getBbd_qyxx_branch_id() {
            return bbd_qyxx_branch_id;
        }

        public void setBbd_qyxx_branch_id(String bbd_qyxx_branch_id) {
            this.bbd_qyxx_branch_id = bbd_qyxx_branch_id;
        }
    }
}
