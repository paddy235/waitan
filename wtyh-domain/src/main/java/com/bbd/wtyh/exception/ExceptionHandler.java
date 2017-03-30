package com.bbd.wtyh.exception;

import com.bbd.wtyh.web.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.UndeclaredThrowableException;
import java.text.ParseException;

/**
 * 异常处理器
 *
 * @author Created by LiYao on 2017-03-30 14:40.
 */
public class ExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

	public static ResponseBean handlerException(Exception e) {

		if (e instanceof UndeclaredThrowableException) {

			UndeclaredThrowableException ute = (UndeclaredThrowableException) e;
			return handlerException((Exception) ute.getUndeclaredThrowable());
		} else if (e instanceof BusinessException) {

			BusinessException be = (BusinessException) e;
			return ResponseBean.errorResponse(be.getMessage());

		} else if (e instanceof NumberFormatException) {

			LOGGER.error("非法的数据格式,请检查后重新输入!", e);
			return ResponseBean.errorResponse("非法的数据格式,请检查后重新输入!");

		} else if (e instanceof ParseException) {

			LOGGER.error("非法的格式,请检查后重新输入!", e);
			return ResponseBean.errorResponse("非法的格式,请检查后重新输入!");

		} else {

			LOGGER.error(e.getMessage(), e);
			return ResponseBean.errorResponse("服务器异常！");
		}
	}
}
