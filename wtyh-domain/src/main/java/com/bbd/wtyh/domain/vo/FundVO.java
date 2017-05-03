package com.bbd.wtyh.domain.vo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 輿情VO
 * Created by suyin on 2016/8/27.
 */
public class FundVO {
    private String msg;//: "ok",
    private Integer rsize=0;//: 19,
    private Integer total=0;//: 19,
    private List<Result> results = new ArrayList<>();//:

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }


    public FundVO(){

    }

    public static class Result{


        private String company_name;//

        private String table_name;//

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getTable_name() {
            return table_name;
        }

        public void setTable_name(String table_name) {
            this.table_name = table_name;
        }
    }
}
