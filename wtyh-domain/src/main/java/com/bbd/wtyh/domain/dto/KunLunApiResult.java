package com.bbd.wtyh.domain.dto;

/**
 *
 * KunLun 接口返回的数据结构
 * Created by zhaoyuan
 * 2016/5/23.
 */
public class KunLunApiResult<T> {

    private String status;

    private int errcode;

    private String errmsg;

    private T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
