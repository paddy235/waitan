package com.bbd.wtyh.common;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResponseBean implements Serializable {
	
	private boolean success;
	private Object data;
	private Object msg;
	private PageInfo pageInfo;

	/**
	 * @param data 成功的内容
	 * @return
	 * @author Ian.Su
	 */
	public static ResponseBean successResponse(Object data, PageInfo pageInfo){
		ResponseBean responseBean = new ResponseBean();
		responseBean.success = true;
		responseBean.data = data;
		if (null != pageInfo) {
			responseBean.setPageInfo(pageInfo);
		}
		return responseBean;
	}

	/**
	 * 没有page对象的返回
	 * @param data 成功的内容
	 * @return
	 * @author tracy zhou
	 */
	public static ResponseBean successResponse(Object data){
		ResponseBean responseBean = new ResponseBean();
		responseBean.success = true;
		responseBean.data = data;
		return responseBean;
	}
	
	/**
	 * @param msg 失败的内容，比如提示语句
	 * @return
	 * @author Ian.Su
	 */
	public static ResponseBean errorResponse(Object msg){
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}	
	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	
}
