package com.bbd.wtyh.domain.dto;

/**
 * Created by suyin on 2016/9/22.
 */
public class BaseDTO {

    private String msg;

    private int    rsize;

    private int    total;

    private int    errCode;

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

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
