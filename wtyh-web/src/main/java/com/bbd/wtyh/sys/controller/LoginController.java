package com.bbd.wtyh.sys.controller;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.service.UserService;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author Ian.Su
 * @since 2016年8月15日 下午5:30:39
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Object login(@RequestParam String name, @RequestParam String password, HttpServletRequest request) {

        //		String adminpwd =  new SimpleHash("md5", "bbd54321" ,ByteSource.Util.bytes("123456"),2).toHex();
        //		System.out.println(adminpwd);

        //数据库的密码是bbd54321
        String pwd = userService.getPassword(name);
        if (StringUtils.isEmpty(pwd)) {
            return ResponseBean.successResponse(false);
        }

        String dataPwd = new SimpleHash("md5", password, ByteSource.Util.bytes("123456"), 2).toHex();

        if (!dataPwd.equals(pwd)) {
            return ResponseBean.successResponse(false);
        }

        request.getSession().setAttribute(Constants.SESSION.loginName, name);

        ResponseBean responseBean = ResponseBean.successResponse(true);
        Date date = userService.lastChangePasswordDate(name);
        if (null != date && date.before(DateUtils.addDays(new Date(), -30))) {
            responseBean.setMsg(UserService.ResultCode.PASSWORD_NEED_CHANGE);
        }

        return responseBean;

    }

    @RequestMapping("/changePassword")
    @ResponseBody
    public ResponseBean changePassword(@RequestParam String name, @RequestParam String oldPassword, @RequestParam String newPassword) {
        String result = userService.changePassword(name, oldPassword, newPassword);
        return ResponseBean.successResponse(result);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Object logout(HttpServletRequest request) {

        HttpSession se = request.getSession(false);
        if (se != null)
            se.invalidate();

        return ResponseBean.successResponse(true);
    }

}
