package com.bbd.bgo.web.controller;

import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;

//import javax.servlet.http.HttpServletResponse;


/**
 * Created by cgj on 2017/2/27.
 */

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	private UserInfoService uis;

	@RequestMapping("/CreateUser")
	@ResponseBody
	public Object myCreateUser1(
			UserInfoTableDo uitd,
			@RequestParam String resourceSet,
			HttpServletRequest request
			) {
		// hh.addHeader("aa","1234");
		try {
			uis.createUser(uitd, resourceSet);
		} catch (BusinessException be) {
			return ResponseBean.errorResponse(be.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBean.errorResponse("服务器异常");
		}
		return ResponseBean.successResponse("OK");
	}

	@RequestMapping("/myUserLogin")
	@ResponseBody
	public Object myUserLogin(@RequestParam String loginName, @RequestParam String password, @RequestParam String type) {
		return uis.compareUserNameMatchPassword(loginName, password, type);
	}

	@RequestMapping("/updateUserInfo")
	@ResponseBody
	public Object updateUserInfo(/*@RequestParam String loginName, @RequestParam String password, @RequestParam String type*/) {


		Set<String> obj1 = new HashSet<String>();
		obj1.add("wer123");
		obj1.add("sdf234");

		Map<String, Object> m1 =new HashMap<String, Object>();
		m1.put("we",34);
		m1.put("zx","scvp");
		m1.put("vs",334);
		Map<String, Object> m2 =new HashMap<String, Object>();
		m2.put( "we", 45 );
		m2.put("vb",true);
		List<Map<String, Object>>  objL =new LinkedList<Map<String, Object>>();
		objL.add(m1);
		objL.add(m2);

		Map<String,Object> rstMap =new HashMap<String, Object>();
		rstMap.put("userInfo",objL);
		rstMap.put("ResourceCode",obj1);
		return rstMap;
	}

}
