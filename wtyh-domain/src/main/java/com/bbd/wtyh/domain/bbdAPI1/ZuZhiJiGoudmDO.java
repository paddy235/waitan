package com.bbd.wtyh.domain.bbdAPI1;

import java.util.List;

/**
 * Created by wangchenge on 2016/8/16 0016.
 */
public class ZuZhiJiGoudmDO {
    private String err_code;
    private String msg;
    private List<Result> results;
    private Integer rsize;
    private String total;

    public ZuZhiJiGoudmDO() {
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
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

    public class Result{
        private String bbd_xgxx_id;
        private String jgdjzh;
        private String jgdm;
        private String jgmc;

        public Result() {
        }

        public String getBbd_xgxx_id() {
            return bbd_xgxx_id;
        }

        public void setBbd_xgxx_id(String bbd_xgxx_id) {
            this.bbd_xgxx_id = bbd_xgxx_id;
        }

        public String getJgdjzh() {
            return jgdjzh;
        }

        public void setJgdjzh(String jgdjzh) {
            this.jgdjzh = jgdjzh;
        }

        public String getJgdm() {
            return jgdm;
        }

        public void setJgdm(String jgdm) {
            this.jgdm = jgdm;
        }

        public String getJgmc() {
            return jgmc;
        }

        public void setJgmc(String jgmc) {
            this.jgmc = jgmc;
        }
    }

}
