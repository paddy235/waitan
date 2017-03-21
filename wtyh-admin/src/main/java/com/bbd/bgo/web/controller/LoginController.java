package com.bbd.bgo.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.RoleResourceService;
import com.bbd.wtyh.service.UserInfoService;
import org.apache.commons.collections.map.HashedMap;
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

import java.util.Map;
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
	private UserInfoService userInfoService;
	@Autowired
	private AreaService areaService;

	@RequestMapping("/login")
	@ResponseBody
	@LogRecord(logMsg = "后台用户登录", type = Operation.Type.login, after = true, before = false)
	public Object login(@RequestParam String name,@RequestParam String password,HttpServletRequest request){
		Map map=null;
		UsernamePasswordToken token = new UsernamePasswordToken(name, password);
		token.setRememberMe(true);
		//获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		try {
			currentUser.login(token);
			logger.info(name+"身份验证通过,登录后台系统!");

			//Set res=roleResourceService.queryResourceCodeByLoginName(name);
			//取用户信息、权限
			Map m=userInfoService.getUserInfoByLoginName(name);
			UserInfoTableDo userInfo=(UserInfoTableDo) m.get("userInfo");

			Set res= (Set) m.get("resourceCode");
			String areaCode=userInfo.getAreaCode();
			AreaDO areaDo=areaService.getAreaByAreaId(Integer.valueOf(areaCode));
			String areaName=null;
			if(null != areaDo){
				areaName=areaDo.getName();
			}
			//用户信息、权限信息保存到session
			Session session=currentUser.getSession();
			session.setAttribute("resource",res);//权限列表
			session.setAttribute(Constants.SESSION.loginName, name);//登录用户名
			session.setAttribute("area",areaCode);//地区编号
			session.setAttribute("areaName",areaName);//地区名称
			session.setAttribute("loginUser",userInfo);//日志使用

			//用户信息、权限信息传给前端页面
			map=new HashedMap();
			map.put("resource",res);//权限列表
			map.put(Constants.SESSION.loginName, name);//登录用户名
			map.put("area",areaCode);//属地区编号
			map.put("areaName",areaName);//地区名称

		}catch(Exception e){

			//通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			e.printStackTrace();
			return ResponseBean.errorResponse("用户名或密码不正确");
		}

		return ResponseBean.successResponse(map);

	}

	@RequestMapping("/logout")
	@ResponseBody
	@LogRecord(logMsg = "后台用户登出", type = Operation.Type.logout)
	public Object logout(HttpServletRequest request) {

		Subject currentUser = SecurityUtils.getSubject();
		logger.info(currentUser.getPrincipal()+"登出后台系统!");
		currentUser.logout();

		return ResponseBean.successResponse(true);
	}
}
