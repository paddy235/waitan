package com.bbd.wtyh.domain.bbdAPI;

import java.util.List;

/**
 * Created by YanWenyuan on 2016/8/13.
 */
public class JudgeDocDO {
    private String msg;
    private int rsize;
    private int total;
    private List<Results> results;

    public class Results {
        private String company_name;
        private String title;   // 标题
        private String main;    // 内容
        private String action_cause;    // 案由
        private String case_type;   // 案件类型
        private String sentence_date; // 审判时间
        private String litigant_type;  // 当事人类型
        private String caseout_come;    // 案件结果
        private String casecode;

        public String getCasecode() {
            return casecode;
        }

        public void setCasecode(String casecode) {
            this.casecode = casecode;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getAction_cause() {
            return action_cause;
        }

        public void setAction_cause(String action_cause) {
            this.action_cause = action_cause;
        }

        public String getCase_type() {
            return case_type;
        }

        public void setCase_type(String case_type) {
            this.case_type = case_type;
        }

        public String getSentence_date() {
            return sentence_date;
        }

        public void setSentence_date(String sentence_date) {
            this.sentence_date = sentence_date;
        }

        public String getLitigant_type() {
            return litigant_type;
        }

        public void setLitigant_type(String litigant_type) {
            this.litigant_type = litigant_type;
        }

        public String getCaseout_come() {
            return caseout_come;
        }

        public void setCaseout_come(String caseout_come) {
            this.caseout_come = caseout_come;
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
