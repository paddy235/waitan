package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.mapper.UserMapper;
import com.bbd.wtyh.service.UserService;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Ian.Su
 * @since 2016年8月15日 下午6:23:15
 */
@Service
public class UserServiceImpl implements UserService {
    private static final String PASSWORD_HISTORY_SPLITTER = "|";
    @Autowired
    private UserMapper userMapper;

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
        List<String> historyList = Lists.newArrayList();
        String passwordHistory = userMapper.getPasswordHistory(loginName);
        if (StringUtils.isNotEmpty(passwordHistory)) {
            historyList = Lists.newArrayList(Splitter.on(PASSWORD_HISTORY_SPLITTER).omitEmptyStrings().trimResults().split(passwordHistory));
        }
        for (String history : historyList) {
            if (encryptPassword(newPassword).equals(history)) {
                return ResultCode.PASSWORD_HISTORY_CONTAINS;
            }
        }
        if (historyList.size() >= 2) {
            historyList.remove(0);
        }
        historyList.add(password);
        userMapper.updatePassword(loginName, encryptPassword(newPassword), StringUtils.join(historyList, "|"));
        return ResultCode.PASSWORD_CHANGE_SUCCESS;
    }

    private String encryptPassword(String password) {
        return new SimpleHash("md5", password, ByteSource.Util.bytes("123456"), 2).toHex();
    }

}
