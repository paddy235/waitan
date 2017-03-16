package com.bbd.wtyh.core.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * mvntest
 *
 * @author Created by LiYao on 2017-03-08 21:34.
 */
public class ExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		response.setCharacterEncoding("UTF-8");
		Writer writer = null;
		try {
			writer = response.getWriter();
			if (ex instanceof ArithmeticException) {
				System.err.println("ArithmeticException");
				writer.write("ArithmeticException");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		return null;
	}
}
