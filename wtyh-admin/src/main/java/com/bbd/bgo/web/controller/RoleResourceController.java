package com.bbd.bgo.web.controller;

import com.bbd.bgo.auth.Constants;
import com.bbd.higgs.utils.StringUtils;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.dto.UserRoleDTO;
import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.exception.ExceptionHandler;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.RoleResourceService;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private AreaService areaService;

	@RequestMapping("/listRole.do")
	@ResponseBody
	@LogRecord(logMsg = "浏览角色列表", type = Operation.Type.browse, after = true, before = false)
	public Object listRole(@RequestParam String roleType, @RequestParam int pageSize, Integer pageNumber, HttpServletRequest request) {

		Map<String, Object> rstMap = new HashedMap();
		try {

			List<RoleDo> list = roleResourceService.listRoleBase(roleType, pageSize, pageNumber);
			rstMap.put("roleList", list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBean.errorResponse("服务器异常：" + e);
		}
		return ResponseBean.successResponse(rstMap);
	}

	@RequestMapping("/templateRole")
	@ResponseBody
	public Object templateRole(@RequestParam String roleType, HttpServletRequest request) {
		String roleName = roleType;
		Map<String, Object> rstMap = new HashMap<>();
		// 取模板角色
		RoleDo roleDo = roleResourceService.getRoleBase(null, roleName, null);
		// 取模板角色对应的权限集
		List<ResourceDo> listRes = roleResourceService.listResourceByRoleId(roleDo.getId());
		// 取模板角色子角色
		List<RoleDo> listRole = roleResourceService.listSonRoleBase(roleDo.getId());
		rstMap.put("resource", listRes);
		rstMap.put("role", listRole);
		return ResponseBean.successResponse(rstMap);
	}

	@RequestMapping("/getResourceByRoleId")
	@ResponseBody
	public Object getResourceByRoleId(@RequestParam int roleId, HttpServletRequest request) {
		Map<String, Object> rstMap = new HashMap<>();
		List<ResourceDo> listRes = roleResourceService.listResourceByRoleId(roleId);
		rstMap.put("resource", listRes);
		return ResponseBean.successResponse(rstMap);
	}

	/**
	 * 所有权限资源。
	 *
	 * @return
	 */
	@RequestMapping("/all-resource")
	@ResponseBody
	public Object getAllResource() {
		try {
			List<ResourceDo> list = this.roleResourceService.getAllResource();
			return ResponseBean.successResponse(list);
		} catch (Exception e) {
			return ExceptionHandler.handlerException(e);
		}
	}

	/**
	 * 父级角色。
	 *
	 * @return
	 */
	@RequestMapping("/parent-role")
	@ResponseBody
	public Object getParentRole() {
		try {
			List<RoleDo> list = this.roleResourceService.getParentRole();
			return ResponseBean.successResponse(list);
		} catch (Exception e) {
			return ExceptionHandler.handlerException(e);
		}
	}

	/**
	 * 由父级角色获取下级角色及权限。
	 *
	 * @return
	 */
	@RequestMapping("/role-resource-by-parent")
	@ResponseBody
	public Object getRoleResourceByParent(@RequestParam Integer parentId) {
		try {
			List<RoleDo> list = this.roleResourceService.getRoleResource(parentId);
			return ResponseBean.successResponse(list);
		} catch (Exception e) {
			return ExceptionHandler.handlerException(e);
		}
	}

	@RequestMapping("/e_g_getAllRoleAndResourceTableInSys.do")
	@ResponseBody
	public Object getAllRoleAndResourceTableInSys(HttpServletRequest request) {
		Map<String, Object> rstMap = new HashedMap();
		List<ResourceDo> listRes = roleResourceService.listResourceByRoleId(10);
		rstMap.put("resource", listRes);
		List<Map<String, Object>> lmo = new ArrayList<Map<String, Object>>() {

			{
				add(new HashMap<String, Object>() {

					{
						put("name", "e.g.角色1");
						put("code", "e.g.Role1");
						put("resourceCode", new String[] { "resourceCode6", "resourceCode7", "resourceCode16" });
					}
				});
				add(new HashMap<String, Object>() {

					{
						put("name", "e.g.角色2");
						put("code", "e.g.expRole2");
						put("resourceCode",
								new String[] { "resourceCode1", "resourceCode4", "resourceCode9", "resourceCode11", "resourceCode13" });
					}
				});
				add(new HashMap<String, Object>() {

					{
						put("name", "e.g.角色n");
						put("code", "e.g.expRolen");
						put("resourceCode", new String[] { "resourceCode2", "resourceCode3", "resourceCode5" });
					}
				});
			}
		};

		rstMap.put("role", lmo);

		return ResponseBean.successResponse(rstMap);
	}

	/**
	 * 角色分配-获取该角色已分配和未分配用户集合。
	 *
	 * @return
	 */
	@RequestMapping("/list-role-assign ")
	@ResponseBody
	public Object listRoleAssign(@RequestParam Integer roleId) {
		try {


			Map<String, Object> rstMap = this.roleResourceService.listRoleAssign(roleId);

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
	public Object reassignRole(@RequestParam Integer roleId,@RequestParam String unassign,@RequestParam String assign,HttpServletRequest request) {
		try {
			//角色ID为空就不处理
			if(null==roleId){
				return ResponseBean.errorResponse("角色ID为空");
			}
			//本次需要解绑的用户
			String[] unassignArr=new String[]{};
			if(!StringUtils.isNullOrEmpty(unassign)){
				unassignArr=unassign.split(",");
			}
			//本次需要绑定的用户
			String[] assignArr=new String[]{};
			if(!StringUtils.isNullOrEmpty(assign)){
				assignArr=assign.split(",");
			}

			String loginName= (String) request.getSession().getAttribute("loginName");

			String userId;
			UserRoleDo userRoleDO;
			//解绑
			for(int i=0;i<unassignArr.length;i++){
				userId=unassignArr[i];
				if(StringUtils.isNullOrEmpty(userId)){
					continue;
				}
				roleResourceService.deleteUserRoleRelation(Integer.valueOf(userId),roleId);
			}
			//绑定
			for(int i=0;i<assignArr.length;i++){
				userId=assignArr[i];
				if(StringUtils.isNullOrEmpty(userId)){
					continue;
				}
				userRoleDO= roleResourceService.getUserRoleRelation(Integer.valueOf(userId),roleId);
				if(null==userRoleDO || null==userRoleDO.getId()) {
					roleResourceService.addUserRoleRelation(Integer.valueOf(userId), roleId, loginName);
				}
			}

			return ResponseBean.successResponse("success");
		} catch (Exception e) {
			return ExceptionHandler.handlerException(e);
		}
	}

}
