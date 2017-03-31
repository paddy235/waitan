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

	RoleDo addRoleBase(String roleName, String roleDes, String roleType, String loginName);

	void addUserRoleResource(UserInfoTableDo userInfoTableDo, String resourceSet, String loginName);

	UserRoleDo getUserRoleRelation(Integer userId,Integer roleId);

	void addUserRoleRelation(Integer userId,Integer roleId,String loginName);

	void deleteUserRoleRelation(Integer userId,Integer roleId);

	void updateUserRoleResource(UserInfoTableDo userInfoTableDo, String resourceSet, String loginName);

	void deleteUserRoleResource(Integer userId, String loginName);

	void addRoleResourceRelation(Integer roleId, String resourceSet, String loginName);

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
	 * 根据角色ID获取已分配该角色和未分配该角色的用户集合
	 *
	 * @param roleId
	 *            角色ID
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> listRoleAssign(Integer roleId) throws Exception;

}