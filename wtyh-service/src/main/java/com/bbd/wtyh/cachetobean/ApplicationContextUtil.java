package com.bbd.wtyh.cachetobean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by Administrator on 2017/4/13.
 */
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    //static ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        ShanghaiAreaCode.setApplicationContext(applicationContext);
    }
}
