package com.bbd.wtyh.web;


public class ResponseBean {
	
	private boolean success;
	
	private Object content;
	
	private Object msg;
	
	
	
	/**
	 * @param content 成功的内容
	 * @return
	 * @author Ian.Su
	 */
	public static ResponseBean successResponse(Object content){
		
		ResponseBean responseBean = new ResponseBean();
		
		responseBean.success = true;
		
		responseBean.content = content;
		
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
