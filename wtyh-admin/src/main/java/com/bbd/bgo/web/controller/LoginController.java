package com.bbd.bgo.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.service.UserService;
import com.bbd.wtyh.web.ResponseBean;

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
			return ResponseBean.errorResponse("false");
		}
		
		//String dataPwd =  new SimpleHash("md5", password ,ByteSource.Util.bytes("123456"),2).toHex();
		String dataPwd =  userSer.encryptPassword(password);



//		System.out.println("admin1"+":admin123456 "+new SimpleHash("md5", "admin123456" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin2"+":admin234561 "+new SimpleHash("md5", "admin234561" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin3"+":admin345612 "+new SimpleHash("md5", "admin345612" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin4"+":admin456123 "+new SimpleHash("md5", "admin456123" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin5"+":admin561234 "+new SimpleHash("md5", "admin561234" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin6"+":admin612345 "+new SimpleHash("md5", "admin612345" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin7"+":admin654321 "+new SimpleHash("md5", "admin654321" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin8"+":admin543216 "+new SimpleHash("md5", "admin543216" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin9"+":admin432165 "+new SimpleHash("md5", "admin432165" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin10"+":admin321654 "+new SimpleHash("md5", "admin321654" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin11"+":admin216543 "+new SimpleHash("md5", "admin216543" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin12"+":admin165432 "+new SimpleHash("md5", "admin165432" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin13"+":admin654321 "+new SimpleHash("md5", "admin654321" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin14"+":admin123456 "+new SimpleHash("md5", "admin123456" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin15"+":admin234561 "+new SimpleHash("md5", "admin234561" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin16"+":admin345621 "+new SimpleHash("md5", "admin345621" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin17"+":admin345621 "+new SimpleHash("md5", "admin456321" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin18"+":admin564321 "+new SimpleHash("md5", "admin564321" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin19"+":admin654321 "+new SimpleHash("md5", "admin654321" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin20"+":admin123456 "+new SimpleHash("md5", "admin123456" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin21"+":admin234561 "+new SimpleHash("md5", "admin234561" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin22"+":admin345612 "+new SimpleHash("md5", "admin345612" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin23"+":admin456321 "+new SimpleHash("md5", "admin456321" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin24"+":admin564321 "+new SimpleHash("md5", "admin564321" ,ByteSource.Util.bytes("123456"),2).toHex());
//		System.out.println("admin25"+":admin612345 "+new SimpleHash("md5", "admin612345" ,ByteSource.Util.bytes("123456"),2).toHex());





		
		if(!dataPwd.equals(pwd)){
			return ResponseBean.errorResponse("false");
		}
		
		request.getSession().setAttribute(Constants.SESSION.loginName, name);
		
		return ResponseBean.successResponse("data/showTables.do");
		
	}
	
}
