package com.bbd.wtyh.domain.bbdAPI;

import java.util.List;

/**
 * Created by YanWenyuan on 2016/8/13.
 */
public class CourtAnnouncementDO {
    private String msg;
    private int rsize;
    private int total;
    private List<Results> results;

    public class Results {
        private String main;
        private String trial_date;

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getTrial_date() {
            return trial_date;
        }

        public void setTrial_date(String trial_date) {
            this.trial_date = trial_date;
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
