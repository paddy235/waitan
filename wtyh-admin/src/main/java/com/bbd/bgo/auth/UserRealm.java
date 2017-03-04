package com.bbd.bgo.auth;


import com.bbd.wtyh.service.RoleResourceService;
import com.bbd.wtyh.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created by Administrator on 2017/2/27 0027.
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
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
            //根据此用户名查询是否拥有此角色 返回的是一个字符串集合
            //authorizationInfo.setRoles(roleResourceService.queryRoleCodeByLoginName(userName));
            //根据用户名查询是否拥有此权限 返回的是一个字符串集合
            authorizationInfo.setStringPermissions(roleResourceService.queryResourceCodeByLoginName(userName));

            return authorizationInfo;
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
        String pwd = userService.getPassword(username);
        if (StringUtils.isEmpty(pwd)) {
            throw new UnknownAccountException(); //如果用户名错误;
        }
        String dataPwd =userService.encryptPassword(String.copyValueOf(password));
        //String dataPwd = new SimpleHash("md5", password, ByteSource.Util.bytes(Constants.SALT), 2).toHex();

        if (!dataPwd.equals(pwd)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
