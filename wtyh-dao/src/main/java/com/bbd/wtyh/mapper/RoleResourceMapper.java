package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

	int getRoleAreaRelationByRoleIdAndAreaId(@Param("roleId") int roleId, @Param("areaId") int areaId);

	List<UserRoleDo> getUserRoleByUser(@Param("userId") int userId);

	List<RoleDo> listRoleBase(HashMap<String, Object> params);

	RoleDo getRoleBaseByIdNameType(HashMap<String, Object> params);

	List<RoleDo> listSonRoleBase(@Param("parentId") int parentId);

	// 通过角色ID取对应的权限集
	List<ResourceDo> listResourceByRoleId(@Param("roleId") int roleId);

	List<ResourceDo> getAllResource();

	List<RoleDo> getRoleResource(@Param("parentId") Integer parentId);

	/**
	 * 查询某个用户对应的角色
	 * 
	 * @param userId
	 * @return
	 */
	@Select("SELECT r.id,r.name,r.type FROM role r JOIN user_role ur ON ur.role_id = r.id AND ur.user_id = #{userId} ")
	List<RoleDo> getRoleByUser(@Param("userId") Integer userId);

	/**
	 * 查找某个用户对用的权限code
	 * 
	 * @param userId
	 * @return
	 */
	@Select("SELECT re.code FROM resource re JOIN role_resource rr ON rr.resource_id = re.id JOIN user_role ur ON "
			+ "ur.role_id = rr.role_id AND ur.user_id = #{userId} GROUP BY re.`code`")
	List<String> getUserResourceCode(@Param("userId") Integer userId);

}
