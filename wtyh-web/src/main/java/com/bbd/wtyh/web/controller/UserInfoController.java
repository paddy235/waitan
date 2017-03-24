package com.bbd.wtyh.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bbd.wtyh.auth.UserRealm;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.service.UserService;
import com.bbd.wtyh.util.CipherUtils;
import com.bbd.wtyh.web.ResponseBean;

/**
 * 用户信息维护
 * 
 * @author Yin Su
 * @since 2016/8/20
 */
@RestController
@RequestMapping("/user/info")
public class UserInfoController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private UserRealm userRealm;

	@RequestMapping("/query")
	@LogRecord(logMsg = "浏览自己的用户信息", page = Operation.Page.userOwnInfo)
	public Object query(HttpSession session) {

		String userName = (String) session.getAttribute(Constants.SESSION.loginName);

		if (StringUtils.isEmpty(userName)) {
			return ResponseBean.errorResponse("请先登录。");
		}

		UserInfoTableDo user = userService.queryUserInfo(userName);
		user.setMobile(CipherUtils.decrypt(user.getMobile()));
		user.setFixPhone(CipherUtils.decrypt(user.getFixPhone()));
		// user.setRealName(CipherUtils.decrypt(user.getRealName()));
		user.setForePwd(null);
		user.setBackPwd(null);

		return ResponseBean.successResponse(user);
	}

	@RequestMapping("/update")
	@LogRecord(logMsg = "修改自己的用户信息：%s%s%s", params = { "m_mobile", "m_fixPhone",
			"m_email" }, type = Operation.Type.modify, page = Operation.Page.userOwnInfo, after = true, before = false)
	public Object updateInfo(@RequestParam Integer id, @RequestParam String mobile, @RequestParam String email,
			@RequestParam String fixPhone, HttpSession session, HttpServletRequest request) throws Exception {

		UserInfoTableDo oldUitd = this.userInfoService.selectById(UserInfoTableDo.class, id);
		if (oldUitd != null) {
			request.setAttribute("m_mobile", " ");
			request.setAttribute("m_fixPhone", " ");
			request.setAttribute("m_email", " ");

			if (!StringUtils.equals(mobile, CipherUtils.decrypt(oldUitd.getMobile()))) {
				request.setAttribute("m_mobile", "【联系电话(手机)】");
			}
			if (!StringUtils.equals(fixPhone, CipherUtils.decrypt(oldUitd.getFixPhone()))) {
				request.setAttribute("m_fixPhone", "【联系电话(固话)】");
			}
			if (!StringUtils.equals(email, oldUitd.getEmail())) {
				request.setAttribute("m_email", "【邮箱】");
			}
		}

		UserInfoTableDo user = new UserInfoTableDo();
		user.setId(id);
		user.setMobile(mobile);
		user.setEmail(email);
		user.setFixPhone(fixPhone);
		user.setUpdateBy((String) session.getAttribute(Constants.SESSION.loginName));

		userInfoService.updateUserInfo(user, null);

		return ResponseBean.successResponse("用户信息修改成功。");
	}

	@RequestMapping("/update/password")
	@LogRecord(logMsg = "修改自己密码", type = Operation.Type.modify, page = Operation.Page.userOwnPwdModify, after = true, before = false)
	public Object updatePassword(/* @RequestParam Integer id, */
			@RequestParam String loginName, @RequestParam String oldPassword, @RequestParam String newPassword, HttpSession session)
			throws Exception {

		if (oldPassword.equals(newPassword)) {
			return ResponseBean.successResponse("password.history.contains"); // 新设置密码不可与原密码设置相同
		}
		Object obj = (userInfoService.getUserInfoSummaryByLoginName(loginName)).get("id");
		if (null == obj) {
			return ResponseBean.successResponse("account.not.exist"); // 账号不存在
																		// //throw
																		// new
																		// BusinessException("未查询到id字段");
		}
		if (!userInfoService
				.compareUserNameMatchPassword( /* user.getUpdateBy() */loginName, oldPassword, "fore_pwd")) {
			return ResponseBean.successResponse("password.error"); // 密码错误
																	// //throw
																	// new
																	// BusinessException("原密码验证失败");
		}
		UserInfoTableDo user = new UserInfoTableDo();
		user.setUpdateBy(loginName); // user.setUpdateBy((String)session.getAttribute(Constants.SESSION.loginName));
		user.setForePwd(newPassword);
		user.setId((Integer) obj);
		userInfoService.updateUserInfo(user, null);
		userRealm.clearCached();
		return ResponseBean.successResponse("password.change.success"); // 用户密码修改成功。
	}
}
