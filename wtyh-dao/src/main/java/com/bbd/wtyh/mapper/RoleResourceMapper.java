package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.dto.UserRoleDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ian.Su
 * @since 2016年8月15日 下午6:10:57
 */
public interface RoleResourceMapper {

	List<String> queryResourceCodeByLoginName(@Param("loginName") String loginName);

	List<String> queryResourceCodeByUserId(@Param("userId") int userId);

	ResourceDo getResourceByCode(@Param("resourceCode") String resourceCode);

	void addRoleBase(RoleDo roleDo);

	void addRoleResourceRelation(RoleResourceDo roleResourceDo);

	void addUserRoleRelation(UserRoleDo userRoleDo);

	void deleteRoleResourceRelation(@Param("roleId") int roleId);

	void deleteRoleBase(@Param("roleId") int roleId);

	void deleteUserRoleRelation(@Param("userId") int userId);

	UserRoleDo getUserRoleRelation(@Param("userId") int userId,@Param("roleId") int roleId);

	int getRoleAreaRelationByRoleIdAndAreaId(@Param("roleId") int roleId, @Param("areaId") int areaId);

	List<UserRoleDo> getUserRoleByUser(@Param("userId") int userId);

	List<RoleDo> listRoleBase(Map<String, Object> params);

	RoleDo getRoleBaseByIdNameType(Map<String, Object> params);

	List<RoleDo> listSonRoleBase(@Param("parentId") int parentId);

	// 通过角色ID取对应的权限集
	List<ResourceDo> listResourceByRoleId(@Param("roleId") int roleId);

	List<ResourceDo> getAllResource();

	List<RoleDo> getRoleResource(@Param("parentId") Integer parentId);

	List<UserRoleDTO> listRoleAssign(Map<String, Object> params);


}
