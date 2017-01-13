package com.bbd.wtyh.domain.dto;

import com.bbd.wtyh.web.relationVO.SubGraphVO;

import java.io.Serializable;

/**
 * description:
 * author:liaohao
 * date:2016/12/16 0016 10:29.
 */
public class RelationRealDTO implements Serializable {

    private String           success;
    private String           msg;
    private String           statusCode;
    private SubGraphVO data;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public SubGraphVO getData() {
        return data;
    }

    public void setData(SubGraphVO data) {
        this.data = data;
    }
}
