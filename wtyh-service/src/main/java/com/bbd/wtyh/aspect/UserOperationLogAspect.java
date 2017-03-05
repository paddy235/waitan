package com.bbd.wtyh.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Yin Su on 2017/3/5.
 */
@Component
@Aspect
public class UserOperationLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserOperationLogAspect.class);

    @Pointcut("execution(* com.bbd.bgo.web.controller.*Controller.*(..))")
    private void controllerMethod(){}


    @Before("controllerMethod()")
    public void controllerMethodBefore(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        LOGGER.info("用户请求地址为：{},参数为：{}",request.getRequestURL(),request.getParameterMap().keySet());
    }





}
