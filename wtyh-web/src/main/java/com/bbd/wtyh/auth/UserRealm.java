package com.bbd.wtyh.auth;

import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.service.UserInfoService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Set;

/**
 * 
 * Created by Administrator on 2017/2/27 0027.
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前登入的用户名
        String userName = (String) principalCollection.getPrimaryPrincipal();
        if (StringUtils.isEmpty(userName)) {
            return null;
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //根据用户名查询是否拥有此权限 返回的是一个字符串集合
        try {
            Map<String, Object> m = userInfoService.getUserInfoByLoginName(userName);
            Set res = (Set) m.get("resourceCode");
            authorizationInfo.setStringPermissions(res);
            return authorizationInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        char[] password = token.getPassword();
        int rst = -1000;
        try {
            rst = userInfoService.compareUserNameAndPassword(username, String.copyValueOf(password), Operation.System.front);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (0 == rst) {//如果身份认证验证成功，返回一个AuthenticationInfo实现；
            return new SimpleAuthenticationInfo(username, password, getName());
        }
        if (rst >= -3) {//用户类型和指定类型不匹配(-3),库中密码字符串为空(-2),不匹配(-1)
            throw new IncorrectCredentialsException();
        }
        if (-4 == rst) { //用户处于非活动状态(-4)
            throw new LockedAccountException();
        }
        if (-5 == rst) { //用户不存在（-5）
            throw new UnknownAccountException();
        }
        throw new AccountException(); //系统异常，可能是参数调用方法时传参不合法
    }

    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
