package com.bbd.wtyh.auth;


import com.bbd.wtyh.service.RoleResourceService;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.service.UserService;
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
 * Created by Administrator on 2017/2/27 0027.
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RoleResourceService roleResourceService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principalCollection) {
        System.out.println("角色权限检查");
        //获取当前登入的用户名
        String userName=(String)principalCollection.getPrimaryPrincipal();
        if(!StringUtils.isEmpty(userName)){
            SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
            //根据用户名查询是否拥有此权限 返回的是一个字符串集合
            try {
                Map<String,Object> m=userInfoService.getUserInfoByLoginName(userName);
                Set res= (Set) m.get("resourceCode");
                authorizationInfo.setStringPermissions(res);
                return authorizationInfo;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        // TODO Auto-generated method stub
        System.out.println("身份验证");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username=token.getUsername();
        char[] password=token.getPassword();
        String pwd = "";
        String type= "";
        try {
            Map map = userInfoService.getUserInfoSummaryByLoginName(username);
            pwd =(String) map.get("fore_pwd");//前台密码
            type=(String) map.get("user_type");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isEmpty(pwd)) {
            throw new UnknownAccountException(); //如果用户名错误;
        }
        //MD5加密
        String dataPwd =userInfoService.userPasswordEncrypt(String.copyValueOf(password));
        //验证密码
        if (!dataPwd.equals(pwd) ) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //必须是前台用户或者全用户才能通过身份验证
        if (!Constants.FRONT.equals(type) && !Constants.ALL.equals(type)) {
            throw new IncorrectCredentialsException();
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }

    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
