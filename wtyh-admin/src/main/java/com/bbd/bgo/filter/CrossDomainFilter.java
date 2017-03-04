package com.bbd.bgo.filter;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class CrossDomainFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");//跨域访问
        response.setHeader("Access-Control-Allow-Credentials", "true");//跨域访问

//        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
//        if (wac != null) {
//            Properties propertiesConfig = (Properties) wac.getBean("propertiesConfig");
//            String restApiPath = propertiesConfig.getProperty("REST_API_PATH", "http://localhost");
//            request.setAttribute("REST_API_PATH", restApiPath);
//        }

        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
