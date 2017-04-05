package com.bbd.wtyh.service;

import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.ResourceDo;
import com.bbd.wtyh.domain.RoleDo;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.domain.UserRoleDo;
import com.bbd.wtyh.domain.dto.UserRoleDTO;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 获取用户信息
 * 
 * @author sunliming
 * @since 2016年8月15日 下午6:23:04
 */
public interface RoleResourceService extends BaseService {

	/**
	 * 新增正式角色基本信息
	 */
	RoleDo addRoleBase(String roleName, String roleDes, String roleType, String loginName);

	/**
	 * 更新正式角色基本信息(不更新类型)
	 */
	void updateRoleBase(Integer roleId, String roleName, String roleDes, String loginName);

	/**
	 * 删除正式角色基本信息
	 */
	void deleteRoleBase(Integer roleId);

	UserRoleDo getUserRoleRelation(Integer userId, Integer roleId);

	void addUserRoleRelation(Integer userId, Integer roleId, String loginName);

	void deleteUserRoleRelation(Integer userId, Integer roleId);

	/**
	 * 删除该角色的角色-权限关系
	 */
	void deleteRoleResourceRelation(Integer roleId);

	/**
	 * 新增该角色的角色-权限关系
	 */
	void addRoleResourceRelation(Integer roleId, String resourceSet, String loginName);

	/**
	 * 添加用户和角色的关系映射
	 * 
	 * @param userDo
	 * @param roleIdSet
	 * @param createBy
	 * @throws Exception
	 */
	void addUserRoleMapping(UserInfoTableDo userDo, String roleIdSet, String createBy) throws Exception;

	/**
	 * 添加用户和权限的关系映射
	 * 
	 * @param userDo
	 * @param resourceIdSet
	 * @param createBy
	 * @return
	 * @throws Exception
	 */
	RoleDo addUserResourceMapping(UserInfoTableDo userDo, String resourceIdSet, String createBy) throws Exception;

	/**
	 * 添加角色和权限的映射关系
	 * 
	 * @param roleId
	 * @param resourceIdSet
	 * @param createBy
	 * @throws Exception
	 */
	void addRoleResourceMapping(Integer roleId, String resourceIdSet, String createBy) throws Exception;

	/***
	 * 将权限code转换为ID
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	Integer resourceCodeToId(String code) throws Exception;

	// 浏览角色列表
	Map<String, Object> listRoleBase(String roleType, int pageLimit, Integer pageNumber);

	// 取角色
	RoleDo getRoleBase(Integer roleId, String roleName);

	// 通过角色ID取对应的权限集
	List<ResourceDo> listResourceByRoleId(Integer roleId);

	/**
	 * 获取所有权限资源
	 * 
	 * @return
	 * @throws Exception
	 */
	List<ResourceDo> getAllResource(String type) throws Exception;

	/**
	 * 根据角色类别获取角色及权限
	 * 
	 * @param userType
	 *            角色类别ID
	 * @return
	 * @throws Exception
	 */
	List<RoleDo> getRoleResource(String userType) throws Exception;

	/**
	 * 获取某个用户对应的角色和用户对应的权限code
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getUserRoleResource(Integer userId) throws Exception;

	/**
	 * 根据角色ID获取已分配该角色和未分配该角色的用户集合
	 *
	 * @param roleId
	 *            角色ID
	 * @return
	 * @throws Exception
	 */
	Map<String, List<UserRoleDTO>> listRoleAssign(Integer roleId) throws Exception;

	/**
	 * 保存用户角色权限
	 * 
	 * @param userDo
	 * @param roleIdSet
	 * @param resourceIdSet
	 * @param createBy
	 * @throws Exception
	 */
	void saveUserRoleResource(UserInfoTableDo userDo, String roleIdSet, String resourceIdSet, String createBy) throws Exception;

	/**
	 * 删除用户角色权限
	 *
	 * @param userDo
	 * @throws Exception
	 */
	void delUserRoleResource(UserInfoTableDo userDo) throws Exception;

	/**
	 * 验证准备新增的角色在数据库中是否已存在相同的权限
	 * 
	 * @return
	 */
	boolean listRoleHaveTheSameRes(String resource, Integer selfRoleId) throws Exception;

	/**
	 * 查询多个角色的权限集合
	 * 
	 * @param
	 * @return
	 */
	List<ResourceDo> listResourceByRoleIds(String[] roleIds);
}