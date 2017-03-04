package com.bbd.wtyh.sys.controller;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.service.RoleResourceService;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.service.UserService;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
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
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Object login(@RequestParam String name, @RequestParam String password, HttpServletRequest request) {

        //		String adminpwd =  new SimpleHash("md5", "bbd54321" ,ByteSource.Util.bytes("123456"),2).toHex();
        //		System.out.println(adminpwd);

      /*  //数据库的密码是bbd54321
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
        if (null != date && date.before(DateUtils.addMonths(new Date(), -3))) {
            responseBean.setMsg(UserService.ResultCode.PASSWORD_NEED_CHANGE);
        }

        return responseBean;*/

        Map map=null;
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        token.setRememberMe(true);
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
            logger.info(name+"身份验证通过,登录业务系统!");
            map=new HashedMap();
            Set set=roleResourceService.queryResourceCodeByLoginName(name);
            Session session=currentUser.getSession();
            session.setAttribute("resource",set);//权限列表
            session.setAttribute(Constants.SESSION.loginName, name);//登录用户名
            session.setAttribute("area","等功杰提供接口");//用户所属地区编号

            map.put("resource",set);//给前端权限列表
            map.put(Constants.SESSION.loginName, name);//给前端录用户名
            map.put("area","等功杰提供接口");//给前端权限地区编号

        }catch(Exception e){

            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            e.printStackTrace();
            //request.setAttribute("message_login", "用户名或密码不正确");
            return ResponseBean.errorResponse("用户名或密码不正确");
        }

        return ResponseBean.successResponse(map);

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

        /*HttpSession se = request.getSession(false);
        if (se != null)
            se.invalidate();

        return ResponseBean.successResponse(true);*/

        Subject currentUser = SecurityUtils.getSubject();
        logger.info(currentUser.getPrincipal()+"登出业务系统!");
        currentUser.logout();

        return ResponseBean.successResponse(true);
    }

}
