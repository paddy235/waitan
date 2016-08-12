package com.bbd.sys.service;


import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.UserHistoryDO;
import com.bbd.wtyh.mapper.UserHistoryMapper;

/**
* 用户行为轨迹记录
* @author Ian.Su
* @since 2016年8月12日 下午5:32:00
*/
public class UserAccessApiInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private UserHistoryMapper userHistoryMapper;
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		RequestMapping annotation = method.getAnnotation(RequestMapping.class);
		if (annotation == null) {
		   return true;
		}
		UserHistoryDO uhDo = new UserHistoryDO();
		
		Integer loginUserId = (Integer) request.getSession().getAttribute(Constants.SESSION.loginUserId);
		String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
		uhDo.setCreateBy(loginName==null?"admin":loginName);
		uhDo.setIp(getRemoteAddress(request));
		uhDo.setIsLogin(loginUserId==null?0:1);
		String query = request.getQueryString();
		uhDo.setKeyword(query==null?"":query);
		uhDo.setOriUrl(request.getHeader("Referer"));
		uhDo.setUpdateBy(loginName==null?"admin":loginName);
		uhDo.setUrl(request.getRequestURI());
		String agent = request.getHeader("user-agent");
		uhDo.setUserAgent(agent == null ? "":agent);
		uhDo.setUserId(loginUserId==null?1:loginUserId);
		
		userHistoryMapper.save(uhDo);
		
		return true;
	}
	
	private String getRemoteAddress(HttpServletRequest request) {  
        String ip = request.getHeader("x-forwarded-for");  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }  
}