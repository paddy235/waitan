package com.bbd.bgo.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bbd.wtyh.service.RoleResourceService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.service.UserService;
import com.bbd.wtyh.web.ResponseBean;

import java.util.Set;

/**
* 
* @author Ian.Su
* @since 2016年8月15日 下午5:30:39
*/
@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private RoleResourceService roleResourceService;
	@Autowired
	private UserService userSer;

	@RequestMapping("/login")
	@ResponseBody
	public Object login(@RequestParam String name,@RequestParam String password,HttpServletRequest request){

		UsernamePasswordToken token = new UsernamePasswordToken(name, password);
		token.setRememberMe(true);
		//获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		try {
			currentUser.login(token);
			logger.info(name+"身份验证通过,登录后台系统!");
			Set set=roleResourceService.queryResourceCodeByLoginName(name);
			Session session=currentUser.getSession();
			session.setAttribute("resource",set);//权限列表
			session.setAttribute(Constants.SESSION.loginName, name);//登录用户名
			session.setAttribute("area","");//用户所属地区编号


		}catch(Exception e){

			//通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			e.printStackTrace();
			//request.setAttribute("message_login", "用户名或密码不正确");
			return ResponseBean.errorResponse("false");
		}

		return ResponseBean.successResponse("data/showTables.do");
		
	}

	@RequestMapping("/logout")
	@ResponseBody
	public Object logout(HttpServletRequest request) {

		Subject currentUser = SecurityUtils.getSubject();
		logger.info(currentUser.getPrincipal()+"登出后台系统!");
		currentUser.logout();

		return ResponseBean.successResponse(true);
	}
}
