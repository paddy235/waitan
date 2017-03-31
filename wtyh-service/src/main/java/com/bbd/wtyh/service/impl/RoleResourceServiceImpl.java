package com.bbd.wtyh.service.impl;

import com.bbd.higgs.utils.DateUtils;
import com.bbd.wtyh.constants.Constants;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.dto.UserRoleDTO;
import com.bbd.wtyh.mapper.RoleResourceMapper;
import com.bbd.wtyh.service.RoleResourceService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
	public RoleDo addRoleBase(String roleName, String roleDes, String roleType, String loginName) {
		RoleDo roleDo = new RoleDo();
		roleDo.setName(roleName);
		roleDo.setDescription(roleDes);
		roleDo.setType(roleType);
		roleDo.setCreateBy(loginName);
		roleDo.setCreateDate(DateUtils.parserDate(DateUtils.format(new Date(), "yyyyMMddHHmmss"), "yyyyMMddHHmmss"));
		roleResourceMapper.addRoleBase(roleDo);
		return roleDo;
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
		Date currentDate = DateUtils.parserDate(DateUtils.format(new Date(), "yyyyMMddHHmmss"), "yyyyMMddHHmmss");
		for (int i = 0; i < resourceArr.length; i++) {
			resourceDo = roleResourceMapper.getResourceByCode(resourceArr[i]);
			if (resourceDo == null) {
				continue;
			}
			roleResourceDo = new RoleResourceDo();
			roleResourceDo.setRoleId(roleId);
			roleResourceDo.setResourceId(resourceDo.getId());
			roleResourceDo.setCreateBy(loginName);
			roleResourceDo.setCreateDate(currentDate);
			roleResourceMapper.addRoleResourceRelation(roleResourceDo);
		}
	}

	/**
	 * 浏览角色列表
	 * 
	 * @param roleType
	 * @return
	 */
	@Override
	public List<RoleDo> listRoleBase(String roleType, int pageLimit, Integer pageNumber) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("roleType", roleType);
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
	 * 取模板权限集
	 * 
	 * @param
	 * @return
	 */
	@Override
	public RoleDo getRoleBase(Integer roleId, String roleName, String roleType) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (null != roleId) {
			params.put("roleId", roleId);
		}
		if (null != roleName) {
			params.put("roleName", roleName);
		}
		if (null != roleType) {
			params.put("roleType", roleType);
		}
		return roleResourceMapper.getRoleBaseByIdNameType(params);
	}

	@Override
	public List<RoleDo> listSonRoleBase(Integer parentId) {
		return roleResourceMapper.listSonRoleBase(parentId);
	}

	@Override
	public List<ResourceDo> listResourceByRoleId(Integer roleId) {
		return roleResourceMapper.listResourceByRoleId(roleId);
	}

	@Override
	public List<ResourceDo> getAllResource() {
		return this.roleResourceMapper.getAllResource();
	}

	@Override
	public List<RoleDo> getParentRole() throws Exception {
		return this.selectAll(RoleDo.class, "parent_id = -1");
	}

	@Override
	public List<RoleDo> getRoleResource(Integer parentId) throws Exception {
		return this.roleResourceMapper.getRoleResource(parentId);
	}

	@Override
	public Map<String, Object> getUserRoleResource(Integer userId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		List<RoleDo> roles = this.roleResourceMapper.getRoleByUser(userId);
		map.put("role", roles);
		List<String> resourceCodes = this.roleResourceMapper.getUserResourceCode(userId);
		map.put("resourceCode", resourceCodes);
		return map;
	}

	@Override
	public Map<String, Object> listRoleAssign(Integer roleId) throws Exception {
		Map<String, Object> rstMap = new HashMap<>();
		// 已分配该角色的用户
		List<UserRoleDTO> assignList = new ArrayList<>();
		// 未分配该角色的用户
		List<UserRoleDTO> unassignList = new ArrayList<>();

		List<UserRoleDTO> list = this.roleResourceMapper.listRoleAssign(roleId);
		for (UserRoleDTO userRoleDTO : list) {
			if (null != userRoleDTO.getRoleId()) {
				assignList.add(userRoleDTO);
			} else {
				unassignList.add(userRoleDTO);
			}
		}
		rstMap.put("assign", assignList);
		rstMap.put("unassign", unassignList);

		return rstMap;
	}

	public void addUserRoleMapping() {
	}

	public Integer addUserResourceMapping(UserInfoTableDo userDo, String resourceIdSet) {
		if (StringUtils.isBlank(resourceIdSet)) {
			return 0;
		}

		return null;
	}

	public void saveUserRoleResource(UserInfoTableDo userDo, String roleIdSet, String resourceIdSet) {
	}

}
