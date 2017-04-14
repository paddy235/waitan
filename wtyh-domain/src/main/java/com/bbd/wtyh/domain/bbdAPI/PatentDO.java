package com.bbd.wtyh.domain.bbdAPI;

import java.util.List;

/**
 * Created by YanWenyuan on 2016/8/20.
 */
public class PatentDO {
    private String msg;
    private int rsize;
    private int total;
    private List<Results> results;

    public class Results{
        private String title;
        private String patent_type;
        private String application_code;
        private String inventor;
        private String public_code;
        private String application_date;
        private String publidate;
        private String independent_claim;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPatent_type() {
            return patent_type;
        }

        public void setPatent_type(String patent_type) {
            this.patent_type = patent_type;
        }

        public String getApplication_code() {
            return application_code;
        }

        public void setApplication_code(String application_code) {
            this.application_code = application_code;
        }

        public String getInventor() {
            return inventor;
        }

        public void setInventor(String inventor) {
            this.inventor = inventor;
        }

        public String getPublic_code() {
            return public_code;
        }

        public void setPublic_code(String public_code) {
            this.public_code = public_code;
        }

        public String getApplication_date() {
            return application_date;
        }

        public void setApplication_date(String application_date) {
            this.application_date = application_date;
        }

        public String getPublidate() {
            return publidate;
        }

        public void setPublidate(String publidate) {
            this.publidate = publidate;
        }

        public String getIndependent_claim() {
            return independent_claim;
        }

        public void setIndependent_claim(String independent_claim) {
            this.independent_claim = independent_claim;
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
