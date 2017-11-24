package com.bbd.wtyh.domain.bbdAPI;

import java.util.List;

/**
 * @Author:WLL
 * @Date:Create on 16:002017/11/24
 */
public class RecordCompanyDO {
    private String msg;
    private Integer rsize;
    private String total;
    private List results;
    private String err_code;
    private String order_id;
    private String client_id;

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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List getResults() {
        return results;
    }

    public void setResults(List results) {
        this.results = results;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    @Override
    public String toString() {
        return "RecordCompanyDO{" +
                "msg='" + msg + '\'' +
                ", results=" + results +
                ", err_code='" + err_code + '\'' +
                '}';
    }
}
