package com.bbd.wtyh.domain.bbdAPI1;

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
        private String notice_people;
        private String notice_time;
        private String notice_type;
        private String litigant;
        private String notice_content;

        public String getNotice_people() {
            return notice_people;
        }

        public void setNotice_people(String notice_people) {
            this.notice_people = notice_people;
        }

        public String getNotice_time() {
            return notice_time;
        }

        public void setNotice_time(String notice_time) {
            this.notice_time = notice_time;
        }

        public String getNotice_type() {
            return notice_type;
        }

        public void setNotice_type(String notice_type) {
            this.notice_type = notice_type;
        }

        public String getLitigant() {
            return litigant;
        }

        public void setLitigant(String litigant) {
            this.litigant = litigant;
        }

        public String getNotice_content() {
            return notice_content;
        }

        public void setNotice_content(String notice_content) {
            this.notice_content = notice_content;
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
