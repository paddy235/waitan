package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.UserInfoTableDo;

import java.util.Map;

/**
 * Created by cgj on 2017/2/27.
 */
public interface UserInfoService {

    /**
     * 创建用户
     * @param uitd 用户信息表
     * @param resourceSet 用户权限集
     * @throws Exception 各种不合规的参数引发的异常，包括加密转码、持久化对象的异常
     */
    public void createUser(UserInfoTableDo uitd, String resourceSet) throws Exception;

    /**
     * 更新用户信息
     * @param uitd 用户信息表
     * @param resourceSet 用户权限集
     * @throws Exception 各种不合规的参数引发的异常，包括加密转码、持久化对象的异常
     */
    public void updateUserInfo(UserInfoTableDo uitd, String resourceSet) throws Exception ;

    /**
     *  通过登录名查询单条用户详情，给孙黎明调用，不分前后台，由您自己根据userType判断，例如'A'||'B'表明是
     *  后台用户，'A'||'F'表明是前台用户，这样您可灵活使用
     * @param loginName 登录名
     * // @param foreYes 选择前（true）后（false）台用户
     * @return 返回包含权限和用户完整字段，
     * @throws Exception
     */
    public Map<String,Object> getUserInfoByLoginName(String loginName /*, boolean foreYes*/) throws Exception;


    /**
     * 用户密码单向加密
     * @param plaintext 明文
     * @return 加密后的密文
     */
    public String userPasswordEncrypt(String plaintext);


}
