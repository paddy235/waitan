package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.UserInfoDo;
import com.bbd.wtyh.domain.UserInfoTableDo;

/**
 * Created by Administrator on 2017/2/27.
 */
public interface UserInfoService {

    /**
     * 创建用户
     * @param uitd
     * @param resourceSet
     * @throws Exception
     */
    public void createUser(UserInfoTableDo uitd, String resourceSet) throws Exception;

    public void updateUserInfo(UserInfoDo uIfDo) throws Exception;

    public boolean compareUserNameMatchPassword(String loginName, String password, String type);

}
