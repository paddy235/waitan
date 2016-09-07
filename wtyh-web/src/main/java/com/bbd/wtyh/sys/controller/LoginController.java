package com.bbd.wtyh.sys.controller;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.service.UserService;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
* 
* @author Ian.Su
* @since 2016年8月15日 下午5:30:39
*/
@Controller
public class LoginController {
	
	@Autowired
	private UserService userSer;

	@RequestMapping("/login")
	@ResponseBody
	public Object login(@RequestParam String name,@RequestParam String password,HttpServletRequest request){
		//数据库的密码是bbd123456
		String pwd = userSer.getPassword(name);
		if( StringUtils.isEmpty(pwd) ){
			return ResponseBean.successResponse(false);
		}
		
		String dataPwd =  new SimpleHash("md5", password ,ByteSource.Util.bytes("123456"),2).toHex();
		
		if(!dataPwd.equals(pwd)){
			return ResponseBean.successResponse(false);
		}
		
		request.getSession().setAttribute(Constants.SESSION.loginName, name);
		
		return ResponseBean.successResponse(true);
		
	}


	@RequestMapping("/logout")
	@ResponseBody
	public Object logout(HttpServletRequest request){


		HttpSession se = request.getSession(false);
		if(se!=null)
		  se.invalidate();

		return ResponseBean.successResponse(true);
	}
	
}
