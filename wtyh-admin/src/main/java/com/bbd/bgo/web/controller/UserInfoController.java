package com.bbd.bgo.web.controller;

import com.bbd.wtyh.common.Constants;
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

	@RequestMapping("/createUser")
	@ResponseBody
	public Object createUser1(
			UserInfoTableDo uitd,
			@RequestParam String resourceSet,
			HttpServletRequest request	) {
		// hh.addHeader("aa","1234");
		String loginName = (String)request.getSession().getAttribute(Constants.SESSION.loginName);
		uitd.setCreateBy(loginName);
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

/*	@RequestMapping("/myUserLogin")
	@ResponseBody
	public Object myUserLogin(@RequestParam String loginName, @RequestParam String password, @RequestParam String type) {
		return uis.compareUserNameMatchPassword(loginName, password, type);
	}*/

	@RequestMapping("/updateUserInfo")
	@ResponseBody
	public Object updateUserInfo(
			UserInfoTableDo uitd,
			@RequestParam String resourceSet,
			HttpServletRequest request ) {
		String loginName = (String)request.getSession().getAttribute(Constants.SESSION.loginName);
		uitd.setUpdateBy(loginName);

		return  ResponseBean.successResponse("err");
	}

	@RequestMapping("/myTest.do")
	@ResponseBody
	public Object myTest() {
		//下面是测试代码
		try {
			Map<String,Object> rstMap = uis.getUserInfoByLoginName( "adn-yang3");
			System.out.println(rstMap);
			return rstMap;
		} catch (Exception ee)	{
			;
		}
		return  ResponseBean.successResponse("err");
	}

}
