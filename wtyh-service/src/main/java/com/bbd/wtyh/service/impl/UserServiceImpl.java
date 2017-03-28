package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.mapper.UserMapper;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Ian.Su
 * @since 2016年8月15日 下午6:23:15
 */
@Service
public class UserServiceImpl implements UserService {
    private static final String PASSWORD_HISTORY_SPLITTER = "|";
    @Autowired
    private UserMapper          userMapper;

    @Autowired
    private UserInfoService uis;

    @Override
    public String getPassword(String loginName) {
        return userMapper.getPassword(loginName);
    }

    @Override
    public Date lastChangePasswordDate(String loginName) {
        return userMapper.getUpdateDate(loginName);
    }

    @Override
    public String changePassword(String loginName, String oldPassword, String newPassword) {
        String password = userMapper.getPassword(loginName);
        if (StringUtils.isEmpty(password)) {
            return ResultCode.ACCOUNT_NOT_EXIT;
        }
        if (!password.equals(encryptPassword(oldPassword))) {
            return ResultCode.PASSWORD_ERROR;
        }
        if (oldPassword.equals(newPassword)) {
            return ResultCode.PASSWORD_EQUALS_OLD;
        }
        userMapper.updatePassword(loginName, encryptPassword(newPassword));
        return ResultCode.PASSWORD_CHANGE_SUCCESS;
    }

    @Override
    public String encryptPassword(String password) {
        //return new SimpleHash("md5", password, ByteSource.Util.bytes("123456"), 2).toHex();
        return uis.userPasswordEncrypt(password);
    }

    @Override
    public UserInfoTableDo queryUserInfo(String userName){
        return userMapper.queryUserInfo(userName);
    }

//    @Override
//    public String decryptPassword(String enPassword) {
//        return "未实现";
//    }

}
