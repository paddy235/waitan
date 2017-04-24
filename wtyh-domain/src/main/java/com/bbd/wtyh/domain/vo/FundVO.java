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

        public String getFund_manager_chinese() {
            return fund_manager_chinese;
        }

        public void setFund_manager_chinese(String fund_manager_chinese) {
            this.fund_manager_chinese = fund_manager_chinese;
        }

        private String fund_manager_chinese;//

    }
}
