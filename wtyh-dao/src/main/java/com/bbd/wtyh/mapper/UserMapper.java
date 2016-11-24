package com.bbd.wtyh.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 *
 * @author Ian.Su
 * @since 2016年8月15日 下午6:10:57
 */
public interface UserMapper {

    Date getUpdateDate(String loginName);

    String getPassword(String loginName);

    String getPasswordHistory(String loginName);

    int updatePassword(@Param("loginName") String loginName, @Param("password") String password, @Param("passwordHistory") String passwordHistory);

}
