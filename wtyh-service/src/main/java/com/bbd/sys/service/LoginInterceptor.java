package com.bbd.sys.service;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bbd.wtyh.common.Constants;

/**
 * 用户登录
 * 
 * @author Ian.Su
 * @since 2016年8月12日 下午5:32:00
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        RequestMapping annotation = method.getAnnotation(RequestMapping.class);
        if (annotation == null) {
            return true;
        }

        if ("/login".equals(annotation.value()[0]) || "/logout".equals(annotation.value()[0])) {
            return true;
        }
        if ("/exportLogFile".equals(annotation.value()[0])) {
            return true;
        }

        if ("updateIndexData.do".equals(annotation.value()[0])) {
            return true;
        }

        if ("updateStaticRiskData.do".equals(annotation.value()[0])) {
            return true;
        }

        if ("updateCompanyRiskLevel.do".equals(annotation.value()[0])) {
            return true;
        }

        if ("saveCompanyCreditRisk.do".equals(annotation.value()[0])) {
            return true;
        }
        HttpSession session = request.getSession(false);
        if (null == session) {
            response.getWriter().write("{success:false,msg:'no login'}");
            return false;
        }
        Object loginName = request.getSession().getAttribute(Constants.SESSION.loginName);
        if (loginName == null) {
            response.getWriter().write("{success:false,msg:'no login'}");
            return false;
        }

        return true;
    }

}