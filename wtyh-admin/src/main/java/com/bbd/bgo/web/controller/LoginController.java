package com.bbd.bgo.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bbd.wtyh.common.comenum.UserRank;
import com.bbd.wtyh.common.comenum.UserType;
import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.RoleResourceService;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.shiro.RedisSessionDAO;
import com.bbd.wtyh.util.Base64Util;
import com.bbd.wtyh.util.IPUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
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

import com.bbd.wtyh.common.Constants;
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
    private UserInfoService userInfoService;
    @Autowired
    private AreaService areaService;

    @RequestMapping("/login")
    @ResponseBody
    @LogRecord(logMsg = "后台用户登录", type = Operation.Type.login, page = Operation.Page.login, after = true, before = false)
    public Object login(@RequestParam String name, @RequestParam String password, HttpServletRequest request) {
        //base64解密
        password=new String(Base64Util.decode(password));
        Map map;
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        token.setRememberMe(true);
        // 获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
            allowLogin(request, name);
            logger.info(name + "身份验证通过,登录后台系统!");

            // Set res=roleResourceService.queryResourceCodeByLoginName(name);
            // 取用户信息、权限
            Map m = userInfoService.getUserInfoByLoginName(name);
            UserInfoTableDo userInfo = (UserInfoTableDo) m.get("userInfo");

            Set res = (Set) m.get("resourceCode");
            String areaCode = userInfo.getAreaCode();
            String areaName = null;
            if (StringUtils.isNotEmpty(areaCode)) {
                AreaDO areaDo = areaService.getAreaByAreaId(Integer.valueOf(areaCode));
                if (null != areaDo) {
                    areaName = areaDo.getName();
                }
            }
            // 用户信息、权限信息保存到session
            Session session = currentUser.getSession();
            session.setAttribute("resource", res);// 权限列表
            session.setAttribute(Constants.SESSION.loginName, name);// 登录用户名
            session.setAttribute("area", areaCode);// 地区编号
            session.setAttribute("areaName", areaName);// 地区名称
            session.setAttribute("loginUser", userInfo);// 日志使用
            UserType ut = UserType.getUserTypeByCode(userInfo.getUserType());
            session.setAttribute("enUserType", ut);// 保存用户类型（枚举值）
            session.setAttribute("userId", userInfo.getId());// 保存用户Id
            session.setAttribute("userName", userInfo.getLoginName());// 保存用户名
            session.setAttribute("userRank", UserType.getUserTypeByCode(userInfo.getUserType()).getUserRank());// 保存用户等级
            session.setAttribute("requestIp", IPUtil.getRemoteAddress(request));
            session.setAttribute("requestUri", request.getRequestURI());

            System.setProperty("loginUserId", userInfo.getId().toString());

            // 用户信息、权限信息传给前端页面
            map = new HashedMap();
            map.put("resource", res);// 权限列表
            map.put("realName", userInfo.getRealName());// 真实姓名
            map.put(Constants.SESSION.loginName, name);// 登录用户名
            map.put("area", areaCode);// 属地区编号
            map.put("areaName", areaName);// 地区名称
            map.put("pwdBeOverdue", userInfoService.testUserPasswordBeOverdue(userInfo.getBackPwdUpDate()));// 密码是否过期
            map.put("userId", userInfo.getId());// 用户ID
        } catch (UnknownAccountException | IncorrectCredentialsException e) { // 用户名不存在
            return ResponseBean.errorResponse("用户名或密码不正确");
        } catch (LockedAccountException e) {
            return ResponseBean.errorResponse("此用户已被锁定，请联系管理员处理");
        } catch (BusinessException e) {
            return ResponseBean.errorResponse(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("", e);
            return ResponseBean.errorResponse("系统异常");
        }
        return ResponseBean.successResponse(map);
    }

    private void allowLogin(HttpServletRequest request, String name) throws BusinessException {
        HttpSession httpSession = request.getSession();
        Object obj = httpSession.getAttribute(Constants.SESSION.loginName);
        if (obj != null) {
            throw new BusinessException("该浏览器已有账号登录，请更换浏览器或者退出已登陆账号");
        }
        if (RedisSessionDAO.isAlreadyLogin(name)) {
            logger.info("拒绝登录：账号[{}]在{}处登录被拒绝，已经在其它地方登录。", name, IPUtil.getRemoteAddress(request));
            throw new BusinessException("该账号已经在其它地方登录");
        }
    }

    @RequestMapping("/logout")
    @ResponseBody
    @LogRecord(logMsg = "后台用户登出", type = Operation.Type.logout)
    public Object logout(HttpServletRequest request) {

        Subject currentUser = SecurityUtils.getSubject();
        logger.info(currentUser.getPrincipal() + "登出后台系统!");
        currentUser.logout();

        return ResponseBean.successResponse(true);
    }
}
