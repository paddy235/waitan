package com.bbd.wtyh.service.impl.relation.exception;

public class BbdException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message;
	public boolean isShow = false;// 是否页面提示message
	public boolean showReturn = true;// 是否页面显示【返回首页】【返回上一页】

	/**
	 * 
	 */
	public BbdException() {
		super();
	}

	/**
	 * @param message
	 */
	public BbdException(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * @param message
	 * @param isShow
	 *            为true 页面直接提示message isShow 为false页面直接提示 系统错误
	 */
	public BbdException(String message, boolean isShow) {
		super(message);
		this.message = message;
		this.isShow = isShow;
	}

	/**
	 * @param message
	 * @param isShow
	 *            为true 页面直接提示message isShow 为false页面直接提示 系统错误
	 */
	public BbdException(String message, boolean isShow, boolean showReturn) {
		super(message);
		this.message = message;
		this.isShow = isShow;
		this.showReturn = showReturn;
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BbdException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public BbdException(Throwable cause) {
		super(cause);
	}

	public String getBbdMessage() {
		return message;
	}

	public boolean getShowReturn() {
		return showReturn;
	}
	
}
