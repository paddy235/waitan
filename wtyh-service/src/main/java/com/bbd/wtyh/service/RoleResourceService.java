package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.RoleDo;
import com.bbd.wtyh.domain.UserInfoTableDo;

import java.util.Set;

/**
 * 获取用户信息
 * @author sunliming
 * @since 2016年8月15日 下午6:23:04
 */
public interface RoleResourceService {

    Set<String> queryResourceCodeByLoginName(String userName);
    Set<String> queryResourceCodeByUserId(Integer userId);
    RoleDo addRoleBase(String roleName, String roleDes, String roleType, String loginName);
    void addUserRoleResource(UserInfoTableDo userInfoTableDo, String resourceSet, String loginName);
    void updateUserRoleResource(UserInfoTableDo userInfoTableDo, String resourceSet, String loginName);
    void deleteUserRoleResource(Integer userId, String loginName);
    void addRoleResourceRelation(Integer roleId, String resourceSet, String loginName);

}