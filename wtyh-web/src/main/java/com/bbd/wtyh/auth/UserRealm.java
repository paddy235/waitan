package com.bbd.wtyh.auth;


import com.bbd.wtyh.common.comenum.UserType;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.service.RoleResourceService;
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
            AuthenticationToken authenticationToken) throws AuthenticationException  {
        // TODO Auto-generated method stub
        System.out.println("身份验证");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username=token.getUsername();
        char[] password=token.getPassword();
        int rst =-1000;
        try {
            rst =userInfoService.compareUserNameAndPassword(username,String.copyValueOf(password),
                    Operation.System.front, new UserType[]{UserType.general} );
        } catch (Exception e) {
            e.printStackTrace();
        }
        if( 0 ==rst ) {//如果身份认证验证成功，返回一个AuthenticationInfo实现；
            return new SimpleAuthenticationInfo(username, password, getName());
        }
        if(rst <= -5) { //用户不存在（-5）
            throw new UnknownAccountException(); //如果用户名错误;
        }
        //用户处于非活动状态(-4),用户类型和指定类型不匹配(-3),库中密码字符串为空(-2),不匹配(-1)
        throw new IncorrectCredentialsException();
    }
    /*{
        // TODO Auto-generated method stub
        System.out.println("身份验证");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username=token.getUsername();
        char[] password=token.getPassword();
        String pwd = "";
        String type= "";
        try {
            UserInfoTableDo uitd = userInfoService.getOnlyUserInfoByLoginNameOrId(username, -1);
            if( null ==uitd ) {
                throw new UnknownAccountException(); //如果用户名错误;
            }
            pwd = uitd.getForePwd();//前台密码
            type= uitd.getUserType();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        if (StringUtils.isEmpty(pwd)) {
//            throw new UnknownAccountException(); //如果用户名错误;
//        }
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
    }*/

    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
