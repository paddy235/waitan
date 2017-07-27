package com.bbd.wtyh.web;



import java.util.HashMap;
import java.util.Map;

public class ResponseBean {

    private boolean success;

    private Object content;

    private Object msg;

    /**
     * @param content 成功的内容，带分页
     * @param pagination
     * @return ResponseBean
     * @author Ian.Su
     */
    public static ResponseBean successResponseWithPage(Object content, PageBean pagination) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.success = true;
        responseBean.msg = "";
        if (content == null) {
            responseBean.content = "";
        } else {
            Map<String, Object> rst = new HashMap<>();
            rst.put("data", content);
            rst.put("page", pagination);
            responseBean.content = rst;
        }
        return responseBean;
    }

    /**
     * @param content 成功的内容
     * @return ResponseBean
     * @author Ian.Su
     */
    public static ResponseBean successResponse(Object content) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.success = true;
        responseBean.msg = "";
        if (content == null) {
            responseBean.content = "";
        } else {
            responseBean.content = content;
        }
        return responseBean;
    }


    /**
     * @param msg 失败的内容，比如提示语句
     * @return ResponseBean
     * @author Ian.Su
     */
    public static ResponseBean errorResponse(Object msg) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.success = false;
        responseBean.msg = msg;
        return responseBean;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }


}
