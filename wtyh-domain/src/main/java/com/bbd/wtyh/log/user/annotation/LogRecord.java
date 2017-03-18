package com.bbd.wtyh.log.user.annotation;

import com.bbd.wtyh.log.user.Operation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解：日志记录
 *
 * @author Created by LiYao on 2017-03-17 09:45.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogRecord {

	/**
	 * 日志消息。以%s作为占位符
	 */
	String logMsg();

	/**
	 * 需要查询的参数。用于从请求中获取参数替换logMsg占位符。<br>
	 * 参数获取:<br>
	 * 1、从请求中获取<br>
	 * 2、从request域中获取<br>
	 * 3、从session域中获取
	 * 
	 */
	String[] params() default {};

	/**
	 * 是否在发起操作请求时记录。默认true
	 */
	boolean before() default true;

	/**
	 * 是否在操作请求返回时记录。默认false
	 */
	boolean after() default false;

	/**
	 * 操作类型
	 */
	Operation.Type type() default Operation.Type.browse;

	/**
	 * 操作页面
	 * 
	 */
	Operation.Page page() default Operation.Page.blank;
}
