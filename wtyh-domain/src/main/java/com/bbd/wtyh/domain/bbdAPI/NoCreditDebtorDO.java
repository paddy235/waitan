package com.bbd.wtyh.domain.bbdAPI;

import java.util.List;

/**
 * Created by YanWenyuan on 2016/8/15.
 */
public class NoCreditDebtorDO {
    private String msg;
    private int rsize;
    private int total;
    private List<Results> results;

    public class Results {
        private String pname;
        private String frname;
        private String exec_court_name;
        private String province;
        private String exe_code;
        private String case_create_time;
        private String casecode;
        private String exec_basunit;
        private String definiteo_bligation;
        private String perform_degree;
        private String concrete_situation;
        private String pubdate;

        public String getPname() {
            return pname;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public String getFrname() {
            return frname;
        }

        public void setFrname(String frname) {
            this.frname = frname;
        }

        public String getExec_court_name() {
            return exec_court_name;
        }

        public void setExec_court_name(String exec_court_name) {
            this.exec_court_name = exec_court_name;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getExe_code() {
            return exe_code;
        }

        public void setExe_code(String exe_code) {
            this.exe_code = exe_code;
        }

        public String getCase_create_time() {
            return case_create_time;
        }

        public void setCase_create_time(String case_create_time) {
            this.case_create_time = case_create_time;
        }

        public String getCasecode() {
            return casecode;
        }

        public void setCasecode(String casecode) {
            this.casecode = casecode;
        }

        public String getExec_basunit() {
            return exec_basunit;
        }

        public void setExec_basunit(String exec_basunit) {
            this.exec_basunit = exec_basunit;
        }

        public String getDefiniteo_bligation() {
            return definiteo_bligation;
        }

        public void setDefiniteo_bligation(String definiteo_bligation) {
            this.definiteo_bligation = definiteo_bligation;
        }

        public String getPerform_degree() {
            return perform_degree;
        }

        public void setPerform_degree(String perform_degree) {
            this.perform_degree = perform_degree;
        }

        public String getConcrete_situation() {
            return concrete_situation;
        }

        public void setConcrete_situation(String concrete_situation) {
            this.concrete_situation = concrete_situation;
        }

        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRsize() {
        return rsize;
    }

    public void setRsize(int rsize) {
        this.rsize = rsize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
