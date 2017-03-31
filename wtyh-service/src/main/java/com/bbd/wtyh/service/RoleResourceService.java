package com.bbd.wtyh.service;

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
public interface RoleResourceService {

	Set<String> queryResourceCodeByLoginName(String userName);

	Set<String> queryResourceCodeByUserId(Integer userId);

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

	void addUserRoleResource(UserInfoTableDo userInfoTableDo, String resourceSet, String loginName);

	UserRoleDo getUserRoleRelation(Integer userId, Integer roleId);

	void addUserRoleRelation(Integer userId, Integer roleId, String loginName);

	void deleteUserRoleRelation(Integer userId, Integer roleId);

	void updateUserRoleResource(UserInfoTableDo userInfoTableDo, String resourceSet, String loginName);

	void deleteUserRoleResource(Integer userId, String loginName);

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

	// 浏览角色列表
	List<RoleDo> listRoleBase(String roleType, int pageLimit, Integer pageNumber);

	// 取角色
	RoleDo getRoleBase(Integer roleId, String roleName, String roleType);

	// 取子角色
	List<RoleDo> listSonRoleBase(Integer parentId);

	// 通过角色ID取对应的权限集
	List<ResourceDo> listResourceByRoleId(Integer roleId);

	/**
	 * 获取所有权限资源
	 * 
	 * @return
	 * @throws Exception
	 */
	List<ResourceDo> getAllResource() throws Exception;

	/**
	 * 获取所有父级角色
	 * 
	 * @return
	 * @throws Exception
	 */
	List<RoleDo> getParentRole() throws Exception;

	/**
	 * 根据角色类别获取角色及权限
	 * 
	 * @param parentId
	 *            角色类别ID
	 * @return
	 * @throws Exception
	 */
	List<RoleDo> getRoleResource(Integer parentId) throws Exception;

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
}