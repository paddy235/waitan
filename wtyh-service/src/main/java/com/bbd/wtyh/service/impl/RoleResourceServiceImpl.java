package com.bbd.wtyh.service.impl;

import com.bbd.higgs.utils.DateUtils;
import com.bbd.wtyh.common.comenum.UserType;
import com.bbd.wtyh.constants.Constants;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.dto.UserRoleDTO;
import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.mapper.RoleResourceMapper;
import com.bbd.wtyh.service.RoleResourceService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Date;

/**
 * 角色权限接口实现类
 */
@Service
public class RoleResourceServiceImpl extends BaseServiceImpl implements RoleResourceService {

	@Autowired
	private RoleResourceMapper roleResourceMapper;

	@Override
	public Set<String> queryResourceCodeByLoginName(String userName) {
		Set set = new HashSet();
		List list = roleResourceMapper.queryResourceCodeByLoginName(userName);
		set.addAll(list);
		return set;
	}

	@Override
	public Set<String> queryResourceCodeByUserId(Integer userId) {
		Set set = new HashSet();
		List list = roleResourceMapper.queryResourceCodeByUserId(userId);
		set.addAll(list);
		return set;
	}

	@Override
	public RoleDo addRoleBase(String roleName, String roleDes, String userType, String loginName) {
		RoleDo roleDo = new RoleDo();
		roleDo.setName(roleName);
		roleDo.setDescription(roleDes);
		roleDo.setType(Constants.role.TYPE_REGULAR);// 正式角色
		roleDo.setCreateBy(loginName);
		roleDo.setUserType(userType);
		roleDo.setCreateDate(new Date());
		roleResourceMapper.addRoleBase(roleDo);
		return roleDo;
	}

	@Override
	public void deleteRoleBase(Integer roleId) {
		this.excuteDel("DELETE FROM role WHERE id = " + roleId);
	}

	/*
	 * 新建用户的角色基本信息、角色-权限关系、角色-用户关系
	 */
	@Override
	public void addUserRoleResource(UserInfoTableDo userInfoTableDo, String resourceSet, String loginName) {
		// 如果 用户ID为空 或者权限为空，则不创建
		Integer userId = userInfoTableDo.getId();
		if (null == userId || StringUtils.isEmpty(resourceSet)) {
			return;
		}
		// 新增角色基本信息
		RoleDo roleDo = this.addRoleBase(null, null, null, loginName);

		// 新增角色用户关系
		UserRoleDo userRoleDo = new UserRoleDo();
		userRoleDo.setUserId(userId);
		userRoleDo.setRoleId(roleDo.getId());
		userRoleDo.setCreateBy(loginName);
		userRoleDo.setCreateDate(DateUtils.parserDate(DateUtils.format(new Date(), "yyyyMMddHHmmss"), "yyyyMMddHHmmss"));
		roleResourceMapper.addUserRoleRelation(userRoleDo);

		// 新增角色权限关系
		addRoleResourceRelation(roleDo.getId(), resourceSet, loginName);

	}

	@Override
	public UserRoleDo getUserRoleRelation(Integer userId, Integer roleId) {
		// 查询角色用户关系
		return roleResourceMapper.getUserRoleRelation(userId, roleId);
	}

	@Override
	public void addUserRoleRelation(Integer userId, Integer roleId, String loginName) {
		// 新增角色用户关系
		UserRoleDo userRoleDo = new UserRoleDo();
		userRoleDo.setUserId(userId);
		userRoleDo.setRoleId(roleId);
		userRoleDo.setCreateBy(loginName);
		userRoleDo.setCreateDate(new Date());
		roleResourceMapper.addUserRoleRelation(userRoleDo);
	}

	@Override
	public void deleteUserRoleRelation(Integer userId, Integer roleId) {
		// 删除角色用户关系
		UserRoleDo userRoleDo = new UserRoleDo();
		userRoleDo.setUserId(userId);
		userRoleDo.setRoleId(roleId);
		this.delete(userRoleDo);
	}

	/*
	 * 修改 某用户的角色对应的权限-限删除角色-权限关系，再建立新的角色-权限关系
	 */
	@Override
	public void updateUserRoleResource(UserInfoTableDo userInfoTableDo, String resourceSet, String loginName) {
		// 与陈功杰约定，如果resourceSet==null,则不更新，若为""，则需要删除已有的权限关系
		if (null == resourceSet || null == userInfoTableDo.getId()) {
			return;
		}
		Integer userId = userInfoTableDo.getId();
		List<UserRoleDo> list = roleResourceMapper.getUserRoleByUser(userId);
		for (UserRoleDo userRoleDo : list) {
			// 删除角色权限关系
			roleResourceMapper.deleteRoleResourceRelation(userRoleDo.getRoleId());
			// 新增角色权限关系
			addRoleResourceRelation(userRoleDo.getRoleId(), resourceSet, loginName);

		}
	}

	/*
	 * 删除某用户的 角色-权限关系、角色基本信息、用户-角色关系
	 */
	@Override
	public void deleteUserRoleResource(Integer userId, String loginName) {
		// 如果 用户ID为空 则不执行
		if (userId == null) {
			return;
		}
		List<UserRoleDo> list = roleResourceMapper.getUserRoleByUser(userId);
		for (UserRoleDo userRoleDo : list) {
			// 删除角色权限关系
			roleResourceMapper.deleteRoleResourceRelation(userRoleDo.getRoleId());
			// 删除角色基本信息
			roleResourceMapper.deleteRoleBase(userRoleDo.getRoleId());

		}
		// 删除角色用户关系
		roleResourceMapper.deleteUserRoleRelation(userId);
	}

	/*
	 * 删除角色权限关系
	 */
	@Override
	public void deleteRoleResourceRelation(Integer roleId) {
		if (roleId == null) {
			return;
		}

		// 删除角色权限关系
		roleResourceMapper.deleteRoleResourceRelation(roleId);

	}

	/*
	 * 新增角色权限关系
	 */
	@Override
	public void addRoleResourceRelation(Integer roleId, String resourceSet, String loginName) {
		if (null == roleId || StringUtils.isEmpty(resourceSet)) {
			return;
		}
		// 新增角色权限关系
		String[] resourceArr = resourceSet.split(",");
		RoleResourceDo roleResourceDo = null;
		ResourceDo resourceDo = null;
		for (int i = 0; i < resourceArr.length; i++) {
			resourceDo = roleResourceMapper.getResourceByCode(resourceArr[i]);
			if (resourceDo == null) {
				continue;
			}
			roleResourceDo = new RoleResourceDo();
			roleResourceDo.setRoleId(roleId);
			roleResourceDo.setResourceId(resourceDo.getId());
			roleResourceDo.setCreateBy(loginName);
			roleResourceDo.setCreateDate(new Date());
			roleResourceMapper.addRoleResourceRelation(roleResourceDo);
		}
	}

	@Override
	public void addUserRoleMapping(UserInfoTableDo userDo, String roleIdSet, String createBy) throws Exception {
		if (StringUtils.isBlank(roleIdSet)) {
			return;
		}
		String[] roleIds = roleIdSet.split(",");
		List<UserRoleDo> urList = new ArrayList<>(roleIds.length);

		for (String id : roleIds) {
			UserRoleDo userRoleDo = new UserRoleDo();
			userRoleDo.setUserId(userDo.getId());
			userRoleDo.setRoleId(Integer.parseInt(id));
			userRoleDo.setCreateBy(createBy);
			userRoleDo.setCreateDate(new Date());
			urList.add(userRoleDo);
		}
		// 删除该用户与角色所有的对应关系
		this.excuteDel("DELETE FROM user_role WHERE user_id = " + userDo.getId());
		this.insertList(urList);
	}

	@Override
	public RoleDo addUserResourceMapping(UserInfoTableDo userDo, String resourceIdSet, String createBy) throws Exception {
		if (StringUtils.isBlank(resourceIdSet)) {
			return null;
		}
		RoleDo roleDo = this.roleResourceMapper.getTempRoleByUser(userDo.getId(), Constants.role.TYPE_TEMP);
		if (roleDo == null) {
			roleDo = this.addRoleBase("临时角色", userDo.getLoginName(), Constants.role.TYPE_TEMP, createBy);
		}
		this.addRoleResourceMapping(roleDo.getId(), resourceIdSet, createBy);
		return roleDo;
	}

	@Override
	public void addRoleResourceMapping(Integer roleId, String resourceIdSet, String createBy) throws Exception {
		String[] resourceIds = resourceIdSet.split(",");
		List<RoleResourceDo> rrList = new ArrayList<>(resourceIds.length);

		for (String id : resourceIds) {
			RoleResourceDo rr = new RoleResourceDo();
			rr.setRoleId(roleId);
			rr.setResourceId(Integer.parseInt(id));
			rr.setCreateBy(createBy);
			rr.setCreateDate(new Date());
			rrList.add(rr);
		}
		// 删除该角色与权限所有的对应关系
		this.excuteDel("DELETE FROM role_resource WHERE role_id = " + roleId);
		this.insertList(rrList);
	}

	/**
	 * 浏览角色列表
	 * 
	 * @param userType
	 * @return
	 */
	@Override
	public List<RoleDo> listRoleBase(String userType, int pageLimit, Integer pageNumber) {
		HashMap<String, Object> params = new HashMap<>();
		if (null != UserType.getUserTypeByCode(userType)) {
			params.put("userType", userType);
		}
		if (pageLimit <= 0 || pageNumber < 1) {
			params.put("listing", null);
		} else {
			params.put("pageLimit", pageLimit);
			if ((null != pageNumber) && (pageNumber > 0)) {
				pageNumber = (pageNumber - 1) * pageLimit; // pageNumber的意义已经变为了“Offset”
				params.put("pageNumber", pageNumber);
			}
			params.put("listing", 1);

		}
		return roleResourceMapper.listRoleBase(params);
	}

	/**
	 * 查询角色基本信息
	 * 
	 * @param
	 * @return
	 */
	@Override
	public RoleDo getRoleBase(Integer roleId, String roleName) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (null != roleId) {
			params.put("roleId", roleId);
		}
		if (null != roleName) {
			params.put("roleName", roleName);
		}
		return roleResourceMapper.getRoleBaseByIdNameType(params);
	}

	/**
	 * 修改角色基本信息
	 *
	 * @param
	 * @return
	 */

	public void updateRoleBase(Integer roleId, String roleName, String roleDes, String loginName) {

		RoleDo roleDo = new RoleDo();
		roleDo.setId(roleId);
		roleDo.setName(roleName);
		roleDo.setDescription(roleDes);
		roleDo.setUpdateBy(loginName);
		roleDo.setUpdateDate(new Date());
		roleResourceMapper.updateRoleBase(roleDo);
	}

	@Override
	public List<ResourceDo> listResourceByRoleId(Integer roleId) {
		return roleResourceMapper.listResourceByRoleId(roleId);
	}

	@Override
	public List<ResourceDo> getAllResource(String type) {
		return this.roleResourceMapper.getAllResource(type);
	}

	@Override
	public List<RoleDo> getParentRole() throws Exception {
		return this.selectAll(RoleDo.class, "parent_id = -1");
	}

	@Override
	public List<RoleDo> getRoleResource(String userType) throws Exception {
		return this.roleResourceMapper.getRoleResource(userType, Constants.role.TYPE_REGULAR);
	}

	@Override
	public Map<String, Object> getUserRoleResource(Integer userId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		List<RoleDo> roles = this.roleResourceMapper.getRoleByUser(userId, Constants.role.TYPE_REGULAR);
		map.put("role", roles);
		Set<String> resourceCodes = this.roleResourceMapper.getUserResourceCode(userId);
		map.put("resourceCode", resourceCodes);
		return map;
	}

	@Override
	public Map<String, List<UserRoleDTO>> listRoleAssign(Integer roleId) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("roleId", roleId);
		RoleDo roleDo = roleResourceMapper.getRoleBaseByIdNameType(params);
		if (null == roleDo) {
			throw new BusinessException("角色不存在");
		}
		params.put("userType", roleDo.getType());

		List<UserRoleDTO> list = this.roleResourceMapper.listRoleAssign(params);
		Map<String, List<UserRoleDTO>> rstMap = new HashMap<>();
		// 已分配该角色的用户
		List<UserRoleDTO> assignList = new ArrayList<>();
		// 未分配该角色的用户
		List<UserRoleDTO> unassignList = new ArrayList<>();
		for (UserRoleDTO userRoleDTO : list) {
			if (null != userRoleDTO.getUserId()) {
				assignList.add(userRoleDTO);
			} else {
				unassignList.add(userRoleDTO);
			}
		}
		rstMap.put("assign", assignList);
		rstMap.put("unassign", unassignList);

		return rstMap;
	}

	@Override
	public void saveUserRoleResource(UserInfoTableDo userDo, String roleIdSet, String resourceIdSet, String createBy) throws Exception {
		if (userDo == null) {
			return;
		}
		RoleDo roleDo = this.addUserResourceMapping(userDo, resourceIdSet, createBy);
		if (roleDo != null) {
			roleIdSet += ("," + roleDo.getId());
		}
		this.addUserRoleMapping(userDo, roleIdSet, createBy);
	}

	@Override
	public void delUserRoleResource(UserInfoTableDo userDo) throws Exception {
		if (userDo == null) {
			return;
		}
		// 删除该用户与角色所有的对应关系
		this.excuteDel("DELETE FROM user_role WHERE user_id = " + userDo.getId());

		RoleDo roleDo = this.roleResourceMapper.getTempRoleByUser(userDo.getId(), Constants.role.TYPE_TEMP);
		if (roleDo != null) {
			// 删除该角色与权限所有的对应关系
			this.excuteDel("DELETE FROM role_resource WHERE role_id = " + roleDo.getId());
			this.delete(roleDo);
		}
	}
}
