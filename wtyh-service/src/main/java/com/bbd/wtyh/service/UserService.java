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

        String ACCOUNT_NOT_EXIT          = "account.not.exist";
        String PASSWORD_ERROR            = "password.error";
        String PASSWORD_HISTORY_CONTAINS = "password.history.contains";
        String PASSWORD_CHANGE_SUCCESS   = "password.change.success";
        String PASSWORD_NEED_CHANGE      = "password.need.change";

    }

}