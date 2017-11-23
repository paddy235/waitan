package com.bbd.wtyh.domain.bbdAPI;

import java.util.List;

/**
 * Created by Administrator on 2016/8/16 0016.
 */
public class BBDParentCompanyDO {
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
        private String esdate;
        private String regno;
        private String address;
        private String regcap;
        private String company_name;
        private String credit_code;
        private String name;
        private String enterprise_status;
        private String frname;

        public Result() {
        }

        public String getEsdate() {
            return esdate;
        }

        public void setEsdate(String esdate) {
            this.esdate = esdate;
        }

        public String getRegno() {
            return regno;
        }

        public void setRegno(String regno) {
            this.regno = regno;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getRegcap() {
            return regcap;
        }

        public void setRegcap(String regcap) {
            this.regcap = regcap;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getCredit_code() {
            return credit_code;
        }

        public void setCredit_code(String credit_code) {
            this.credit_code = credit_code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEnterprise_status() {
            return enterprise_status;
        }

        public void setEnterprise_status(String enterprise_status) {
            this.enterprise_status = enterprise_status;
        }

        public String getFrname() {
            return frname;
        }

        public void setFrname(String frname) {
            this.frname = frname;
        }
    }
}
