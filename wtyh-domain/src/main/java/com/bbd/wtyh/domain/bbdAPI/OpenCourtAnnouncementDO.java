package com.bbd.wtyh.domain.bbdAPI;

import java.util.List;

/**
 * Created by YanWenyuan on 2016/8/20.
 */
public class OpenCourtAnnouncementDO {
    private String msg;
    private int rsize;
    private int total;
    private List<Results> results;

    public class Results{
        private String main;
        private String city;
        private String action_cause;
        private String litigant;
        private String case_code;
        private String trial_date;
        private String title;

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAction_cause() {
            return action_cause;
        }

        public void setAction_cause(String action_cause) {
            this.action_cause = action_cause;
        }

        public String getLitigant() {
            return litigant;
        }

        public void setLitigant(String litigant) {
            this.litigant = litigant;
        }

        public String getCase_code() {
            return case_code;
        }

        public void setCase_code(String case_code) {
            this.case_code = case_code;
        }

        public String getTrial_date() {
            return trial_date;
        }

        public void setTrial_date(String trial_date) {
            this.trial_date = trial_date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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
