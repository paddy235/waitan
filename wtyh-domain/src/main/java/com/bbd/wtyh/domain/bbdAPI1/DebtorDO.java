package com.bbd.wtyh.domain.bbdAPI1;

import java.util.List;

/**
 * Created by YanWenyuan on 2016/8/13.
 */
public class DebtorDO {
    private String msg;
    private int rsize;
    private int total;
    private List<Results> results;

    public class Results {
        private String company_name;    // 被执行人姓名/名称
        private String pname;   // 被执行人姓名/名称
        private String case_state;  // 案件状态
        private String pname_id;    // 身份证号码/组织机构代码
        private String exec_court_name; // 执行法院
        private String case_create_time;    // 立案时间
        private String case_code;   // 案号
        private String exec_subject;    // 执行标的

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getPname() {
            return pname;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public String getCase_state() {
            return case_state;
        }

        public void setCase_state(String case_state) {
            this.case_state = case_state;
        }

        public String getPname_id() {
            return pname_id;
        }

        public void setPname_id(String pname_id) {
            this.pname_id = pname_id;
        }

        public String getExec_court_name() {
            return exec_court_name;
        }

        public void setExec_court_name(String exec_court_name) {
            this.exec_court_name = exec_court_name;
        }

        public String getCase_create_time() {
            return case_create_time;
        }

        public void setCase_create_time(String case_create_time) {
            this.case_create_time = case_create_time;
        }

        public String getCase_code() {
            return case_code;
        }

        public void setCase_code(String case_code) {
            this.case_code = case_code;
        }

        public String getExec_subject() {
            return exec_subject;
        }

        public void setExec_subject(String exec_subject) {
            this.exec_subject = exec_subject;
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
