package com.bbd.wtyh.sys.controller;

import com.bbd.wtyh.shiro.RedisSessionDAO;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.RoleResourceService;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.util.IPUtil;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    private AreaService areaService;

    @RequestMapping("/login")
    @ResponseBody
    @LogRecord(logMsg = "用户登录", type = Operation.Type.login, page = Operation.Page.login, after = true, before = false)
    public Object login(@RequestParam String name, @RequestParam String password, HttpServletRequest request) {

        HttpSession httpSession = request.getSession();
        Object obj = httpSession.getAttribute(Constants.SESSION.loginName);
        if (obj != null) {
            return ResponseBean.errorResponse("该浏览器已有账号登录，请更换浏览器或者退出已登陆账号");
        }

        Map map;
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        token.setRememberMe(true);
        // 获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
            logger.info(name + "身份验证通过,登录业务系统!");
            RedisSessionDAO.forcedLogout(request, name);

            // Set res=roleResourceService.queryResourceCodeByLoginName(name);
            // 取用户信息、权限
            Map m = userInfoService.getUserInfoByLoginName(name);
            UserInfoTableDo userInfo = (UserInfoTableDo) m.get("userInfo");

            Set res = (Set) m.get("resourceCode");
            String areaCode = userInfo.getAreaCode();
            AreaDO areaDo = areaService.getAreaByAreaId(Integer.valueOf(areaCode));
            String areaName = null;
            if (null != areaDo) {
                areaName = areaDo.getName();
            }
            // 用户信息、权限信息保存到session
            Session session = currentUser.getSession();
            session.setAttribute("resource", res);// 权限列表
            session.setAttribute(Constants.SESSION.loginName, name);// 登录用户名
            session.setAttribute("area", areaCode);// 地区编号
            session.setAttribute("areaName", areaName);// 地区名称
            session.setAttribute("loginUser", userInfo);
            session.setAttribute("userId", userInfo.getId());
            session.setAttribute("requestIp", IPUtil.getRemoteAddress(request));
            session.setAttribute("requestUri", request.getRequestURI());

            System.setProperty("loginUserId", userInfo.getId().toString());

            // 用户信息、权限信息传给前端页面
            map = new HashedMap();
            map.put("resource", res);// 权限列表
            map.put(Constants.SESSION.loginName, name);// 登录用户名
            map.put("area", areaCode);// 属地区编号
            map.put("areaName", areaName);// 地区名称
            map.put("pwdBeOverdue", userInfoService.testUserPasswordBeOverdue(userInfo.getForePwdUpDate()));// 密码是否过期
            map.put("userId", userInfo.getId());// 用户ID
            map.put("userType", userInfo.getUserType());// 用户类型
        } catch (UnknownAccountException e) { // 用户名不存在
            //e.printStackTrace();
            return ResponseBean.errorResponse("用户名或密码不正确");
        } catch (IncorrectCredentialsException e) { // 用户类型或密码不匹配
            //e.printStackTrace();
            return ResponseBean.errorResponse("用户名或密码不正确");
        } catch (LockedAccountException e) {
            //e.printStackTrace();
            return ResponseBean.errorResponse("此用户已被锁定，请联系管理员处理");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("", e);
            return ResponseBean.errorResponse("系统异常");
        }
        return ResponseBean.successResponse(map);
    }

    @RequestMapping("/logout")
    @ResponseBody
    @LogRecord(logMsg = "用户登出", type = Operation.Type.logout)
    public Object logout() {

        Subject currentUser = SecurityUtils.getSubject();
        logger.info(currentUser.getPrincipal() + "登出业务系统!");
        currentUser.logout();

        return ResponseBean.successResponse(true);
    }

}
