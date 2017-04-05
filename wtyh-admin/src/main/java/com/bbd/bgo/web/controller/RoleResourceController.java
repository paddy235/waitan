package com.bbd.bgo.web.controller;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.ResourceDo;
import com.bbd.wtyh.domain.RoleDo;
import com.bbd.higgs.utils.StringUtils;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.dto.UserRoleDTO;
import com.bbd.wtyh.exception.ExceptionHandler;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.RoleResourceService;
import com.bbd.wtyh.web.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 *
 * @author sunliming
 * @since 2017年03月28日
 */
@Controller
@RequestMapping("/role-resource")
public class RoleResourceController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private RoleResourceService roleResourceService;

	/**
	 * 新增角色(正式角色)
	 *
	 * @return
	 */
	@RequestMapping("/add-role")
	@ResponseBody
	@LogRecord(logMsg = "新增角色：%s", params = {"roleName"}, page = Operation.Page.roleCreate, type = Operation.Type.add)
	public Object addRole(@RequestParam String userType, @RequestParam String roleName,  String roleDes,
			@RequestParam String resource, HttpSession session) {
		try {
			String loginName = (String) session.getAttribute(Constants.SESSION.loginName);
			if (StringUtils.isNullOrEmpty(userType) || StringUtils.isNullOrEmpty(roleName) || StringUtils.isNullOrEmpty(resource)) {
				return ResponseBean.errorResponse("数据错误");
			}
			RoleDo roleDo;
			roleDo = roleResourceService.getRoleBase(null, roleName);
			if (null != roleDo && roleDo.getName() != null) {
				return ResponseBean.errorResponse("角色名称已存在");
			}
			//权限代码转权限ID
			String[] resourceArr = resource.split(",");
			for(int i=0;i<resourceArr.length;i++){
				String resId= roleResourceService.resourceCodeToId(resourceArr[i]).toString();
				resourceArr[i]=resId;
			}
			if(this.roleResourceService.listRoleHaveTheSameRes(resourceArr,null)){
				return ResponseBean.errorResponse("已存在相同权限的角色");
			}
			roleDo = roleResourceService.addRoleBase(roleName, roleDes, userType, loginName);
			roleResourceService.addRoleResourceRelation(roleDo.getId(), resourceArr, loginName);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBean.errorResponse("服务器异常：" + e);
		}
		return ResponseBean.successResponse("success");
	}

	/**
	 * 修改角色(正式角色)
	 *
	 * @return
	 */
	@RequestMapping("/update-role")
	@ResponseBody
	@LogRecord(logMsg = "修改角色：%s", params = {"roleName"}, page = Operation.Page.roleModify, type = Operation.Type.modify)
	public Object updateRole(@RequestParam String roleId, @RequestParam String roleName, @RequestParam String roleDes,
			@RequestParam String resource, HttpSession session) {
		try {
			String loginName = (String) session.getAttribute(Constants.SESSION.loginName);
			if (StringUtils.isNullOrEmpty(roleId) || StringUtils.isNullOrEmpty(roleName) || StringUtils.isNullOrEmpty(resource)) {
				return ResponseBean.errorResponse("数据错误");
			}
			Integer id = Integer.parseInt(roleId);
			RoleDo roleDo;
			roleDo = roleResourceService.getRoleBase(null, roleName);
			if (null != roleDo && roleDo.getName() != null) {
				if (roleDo.getId() != id) {
					return ResponseBean.errorResponse("角色名称已存在");
				}

			}
			//权限代码转权限ID
			String[] resourceArr = resource.split(",");
			for(int i=0;i<resourceArr.length;i++){
				String resId= roleResourceService.resourceCodeToId(resourceArr[i]).toString();
				resourceArr[i]=resId;
			}
			if(this.roleResourceService.listRoleHaveTheSameRes(resourceArr,id)){
				return ResponseBean.errorResponse("已存在相同权限的角色");
			}
			roleResourceService.updateRoleBase(id, roleName, roleDes, loginName);
			roleResourceService.deleteRoleResourceRelation(id);
			roleResourceService.addRoleResourceRelation(id, resourceArr, loginName);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBean.errorResponse("服务器异常：" + e);
		}
		return ResponseBean.successResponse("success");
	}

	/**
	 * 删除角色(正式角色)
	 *
	 * @return
	 */
	@RequestMapping("/delete-role")
	@ResponseBody
	public Object deleteRole(@RequestParam String roleId, HttpServletRequest request) {
		try {
			if (StringUtils.isNullOrEmpty(roleId)) {
				return ResponseBean.errorResponse("数据错误");
			}
			Integer id = Integer.parseInt(roleId);
			Map<String, List<UserRoleDTO>> userMap = roleResourceService.listRoleAssign(id);
			List<UserRoleDTO> assignList = userMap.get("assign");
			if (null != assignList && assignList.size() > 0) {

				return ResponseBean.errorResponse("已绑定用户,不能删除该角色");
			}
			RoleDo roleDo=roleResourceService.getRoleBase(id,null);
			roleResourceService.deleteRoleResourceRelation(id);
			roleResourceService.deleteRoleBase(id);
			UserLogRecord.record("删除角色:" +roleDo.getName(),
					Operation.Type.del, Operation.Page.roleBrowse, Operation.System.back, request);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBean.errorResponse("服务器异常：" + e);
		}
		return ResponseBean.successResponse("success");
	}

	/**
	 * 浏览角色(正式角色)
	 *
	 * @return
	 */
	@RequestMapping("/browse-role")
	@ResponseBody
	public Object browseRole(@RequestParam String roleId, HttpServletRequest request) {
		Map<String, Object> rstMap = new HashMap<>();
		try {
			if (StringUtils.isNullOrEmpty(roleId)) {
				return ResponseBean.errorResponse("数据错误");
			}
			Integer id = Integer.parseInt(roleId);
			RoleDo roleDo = roleResourceService.getRoleBase(id, null);
			if (null == roleDo) {
				return ResponseBean.errorResponse("角色不存在");
			}
			UserLogRecord.record("浏览角色:" +roleDo.getName(),
					Operation.Type.browse, Operation.Page.roleBrowse, Operation.System.back, request);

			List<ResourceDo> list = roleResourceService.listResourceByRoleId(id);
			Map<String, List<UserRoleDTO>> map = roleResourceService.listRoleAssign(id);
			rstMap.put("role", roleDo);
			rstMap.put("assign", map.get("assign"));
			rstMap.put("resource", list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBean.errorResponse("服务器异常：" + e);
		}
		return ResponseBean.successResponse(rstMap);
	}

	/**
	 * 角色列表
	 *
	 * @return
	 */
	@RequestMapping("/list-role.do")
	@ResponseBody
	public Object listRole(@RequestParam String userType, @RequestParam int pageSize, Integer pageNumber, HttpServletRequest request) {

		Map<String, Object> rstMap ;
		try {
			if (null == pageNumber) {
				pageNumber = 1;
			}
			UserLogRecord.record("浏览角色列表", Operation.Type.browse, Operation.Page.roleBrowse, Operation.System.back, request);
			rstMap= roleResourceService.listRoleBase(userType, pageSize, pageNumber);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBean.errorResponse("服务器异常：" + e);
		}
		return ResponseBean.successResponse(rstMap);
	}

	/**
	 * 新增角色-选择父角色
	 *
	 * @return
	 */
	@RequestMapping("/template-role")
	@ResponseBody
	public Object templateRole(@RequestParam String userType, HttpServletRequest request) {
		Map<String, Object> rstMap = new HashMap<>();
		try {
		// 取模板角色对应的权限集
			List<ResourceDo> listRes = this.roleResourceService.getAllResource(userType);
			// 取模板角色 子角色
			List<RoleDo> listRole = this.roleResourceService.getRoleResource(userType);
			rstMap.put("resource", listRes);
			rstMap.put("role", listRole);
			return ResponseBean.successResponse(rstMap);
		} catch (Exception e) {
			return ExceptionHandler.handlerException(e);
		}
	}

	/**
	 * 用角色ID查询该角色的权限集合
	 *
	 * @return
	 */
	@RequestMapping("/get-resource-by-role-id")
	@ResponseBody
	public Object getResourceByRoleId(@RequestParam int roleId, HttpServletRequest request) {
		Map<String, Object> rstMap = new HashMap<>();
		List<ResourceDo> listRes = roleResourceService.listResourceByRoleId(roleId);
		rstMap.put("resource", listRes);
		return ResponseBean.successResponse(rstMap);
	}

	/**
	 * 用角色ID组，查询该角色的权限集合
	 *
	 * @return
	 */
	@RequestMapping("/get-resource-by-role-id-list")
	@ResponseBody
	public Object getResourceByRoleIdList(@RequestParam String roleIdList, HttpServletRequest request) {
		Map<String, Object> rstMap = new HashMap<>();
		if(StringUtils.isNullOrEmpty(roleIdList)){
			rstMap.put("resource", null);
			return ResponseBean.successResponse(rstMap);
		}
		String[] roleIds=roleIdList.split(",");
		List<ResourceDo> setRes = roleResourceService.listResourceByRoleIds(roleIds);
		rstMap.put("resource", setRes);
		return ResponseBean.successResponse(rstMap);
	}

	/**
	 * 所有权限资源。
	 *
	 * @return
	 */
	@RequestMapping("/all-resource")
	@ResponseBody
	public Object getAllResource(String userType) {
		try {
			List<ResourceDo> list = this.roleResourceService.getAllResource(userType);
			return ResponseBean.successResponse(list);
		} catch (Exception e) {
			return ExceptionHandler.handlerException(e);
		}
	}

	/**
	 * 由用户类别获取对应的角色及权限。
	 *
	 * @return
	 */
	@RequestMapping("/role-resource-by-type")
	@ResponseBody
	public Object getRoleResourceByUserType(@RequestParam String userType) {
		try {
			List<RoleDo> list = this.roleResourceService.getRoleResource(userType);
			return ResponseBean.successResponse(list);
		} catch (Exception e) {
			return ExceptionHandler.handlerException(e);
		}
	}

	/**
	 * 角色分配-获取该角色已分配和未分配用户集合。
	 *
	 * @return
	 */
	@RequestMapping("/list-role-assign")
	@ResponseBody
	public Object listRoleAssign(@RequestParam Integer roleId,HttpServletRequest request) {
		try {
			if(null!=roleId){
				RoleDo roleDo=this.roleResourceService.getRoleBase(roleId,null);
				if(null!=roleDo){
					UserLogRecord.record("分配角色:"+roleDo.getName(), Operation.Type.browse, Operation.Page.roleAssign, Operation.System.back, request);
				}else {
					UserLogRecord.record("分配角色:该角色不存在!", Operation.Type.browse, Operation.Page.roleAssign, Operation.System.back, request);
				}
			}
			Map<String, List<UserRoleDTO>> rstMap = this.roleResourceService.listRoleAssign(roleId);
			return ResponseBean.successResponse(rstMap);
		} catch (Exception e) {
			return ExceptionHandler.handlerException(e);
		}
	}

	/**
	 * 角色分配-将该角色分配给用户组 和 移除用户组。
	 *
	 * @return
	 */
	@RequestMapping("/reassign-role")
	@ResponseBody
	public Object reassignRole(@RequestParam Integer roleId, @RequestParam String unassign, @RequestParam String assign,
			HttpSession session,HttpServletRequest request) {
		try {
			// 角色ID为空就不处理
			if (null == roleId) {
				return ResponseBean.errorResponse("角色ID为空");
			}

			RoleDo roleDo=this.roleResourceService.getRoleBase(roleId,null);
			if(null!=roleDo){
				UserLogRecord.record("分配角色:"+roleDo.getName(), Operation.Type.modify, Operation.Page.roleAssign, Operation.System.back, request);
			}else {
				UserLogRecord.record("分配角色:该角色不存在!", Operation.Type.modify, Operation.Page.roleAssign, Operation.System.back, request);
			}

			// 本次需要解绑的用户
			String[] unassignArr = new String[] {};
			if (!StringUtils.isNullOrEmpty(unassign)) {
				unassignArr = unassign.split(",");
			}
			// 本次需要绑定的用户
			String[] assignArr = new String[] {};
			if (!StringUtils.isNullOrEmpty(assign)) {
				assignArr = assign.split(",");
			}

			String loginName = (String) session.getAttribute(Constants.SESSION.loginName);

			String userId;
			UserRoleDo userRoleDO;
			// 解绑
			for (int i = 0; i < unassignArr.length; i++) {
				userId = unassignArr[i];
				if (StringUtils.isNullOrEmpty(userId)) {
					continue;
				}
				roleResourceService.deleteUserRoleRelation(Integer.parseInt(userId), roleId);
			}
			// 绑定
			for (int i = 0; i < assignArr.length; i++) {
				userId = assignArr[i];
				if (StringUtils.isNullOrEmpty(userId)) {
					continue;
				}
				userRoleDO = roleResourceService.getUserRoleRelation(Integer.parseInt(userId), roleId);
				if (null == userRoleDO || null == userRoleDO.getId()) {
					roleResourceService.addUserRoleRelation(Integer.parseInt(userId), roleId, loginName);
				}
			}

			return ResponseBean.successResponse("success");
		} catch (Exception e) {
			return ExceptionHandler.handlerException(e);
		}
	}

}
