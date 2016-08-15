package com.bbd.bgo.web.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.web.ResponseBean;

/**
* 
* @author Ian.Su
* @since 2016年8月15日 下午5:30:39
*/
@Controller
public class LoginController {

	@RequestMapping("/login")
	@ResponseBody
	public Object login(String name,String password){
		
		
		
		String dataPwd =  new SimpleHash("md5", password ,ByteSource.Util.bytes("123456"),2).toHex();
		
		return ResponseBean.successResponse("data/showTables");
		
	}
	
}
