package com.bbd.wtyh.service;

import java.util.Date;

/**
 * 获取用户信息
 * @author Ian.Su
 * @since 2016年8月15日 下午6:23:04
 */
public interface UserService {

    String getPassword(String loginName);

    Date lastChangePasswordDate(String loginName);

    String changePassword(String loginName, String oldPassword, String newPassword);

    interface ResultCode {
        //账号不存在
        String ACCOUNT_NOT_EXIT          = "account.not.exist";
        //账户名或密码错误
        String PASSWORD_ERROR            = "password.error";
        //新密码不能为历史密码
        String PASSWORD_HISTORY_CONTAINS = "password.history.contains";
        //密码修改成功
        String PASSWORD_CHANGE_SUCCESS   = "password.change.success";
        //密码需要修改
        String PASSWORD_NEED_CHANGE      = "password.need.change";

    }

}