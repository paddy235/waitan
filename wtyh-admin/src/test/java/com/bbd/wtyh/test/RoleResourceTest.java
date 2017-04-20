package com.bbd.wtyh.test;

import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bbd.bgo.service.task.PrivateFundTaskService;
import com.bbd.bgo.service.task.SystemAnalyzeTaskService;
import com.bbd.wtyh.domain.ResourceDo;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.domain.dto.UserRoleDTO;
import com.bbd.wtyh.service.CoAddOrCloseService;
import com.bbd.wtyh.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbd.wtyh.domain.RoleDo;
import com.bbd.wtyh.service.RoleResourceService;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-03-16 10:39.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class RoleResourceTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private RoleResourceService resourceService;
	@Autowired
	private PrivateFundTaskService privateFundTaskService;
	@Autowired
	private SystemAnalyzeTaskService systemAnalyzeTaskService;
	@Autowired
	private CoAddOrCloseService coChgMonitorService;

	@Test
	public void getRoleResourceTest() throws Exception {
		long s = System.currentTimeMillis();
		List<RoleDo> list = this.resourceService.getRoleResource("F");
		long e = System.currentTimeMillis();
		System.out.println((e - s));
		System.err.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect));
	}

	@Test
	public void getAllResourceTest() throws Exception {
		List<ResourceDo> list = null;
		for (int i = 0; i < 100; i++) {
			long s = System.currentTimeMillis();
			list = this.resourceService.getAllResource("B");
			long e = System.currentTimeMillis();
			System.out.println((e - s));
		}
		System.err.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect));
	}

	@Test
	public void listRoleAssign() throws Exception {
		Map<String, List<UserRoleDTO>> map = this.resourceService.listRoleAssign(Integer.valueOf(1));
		System.err.println(JSON.toJSONString(map, SerializerFeature.PrettyFormat));
	}

	@Test
	public void getRoleResourceByUserTest() throws Exception {
		Map<String, Object> list = this.resourceService.getUserRoleResource(45);
		System.err.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect));
	}

	@Test
	public void resourceCodeToIdTest() throws Exception {
		Integer id = this.resourceService.resourceCodeToId("F_HYJCPT_RZDB");
		System.out.println(id);
	}

	@Autowired
	private UserInfoService userInfoService;

	@Test
	public void createUserTest() throws Exception {
		UserInfoTableDo user = new UserInfoTableDo();
		user.setStatus("A");
		user.setUserType("B");
		user.setLoginName("lytest");
		user.setForePwd("");
		user.setBackPwd("12345678");
		user.setRealName("ly");
		user.setFixPhone("028-88887777");
		user.setMobile("13350079669");
		user.setEmail("123@qq.com");
		user.setDepartment("软件部");
		user.setAreaCode("104");
		user.setCreateDate(new Date());
		user.setCreateBy("ly");

		this.userInfoService.createUser(user, "B_HTGLQX,B_YHRZGL", "");

		System.out.println(user);

	}

	@Test
	public void deleteUserTest() throws Exception {
		this.userInfoService.deleteUserById(143);
	}

	@Test
	public  void updateCompanyStatus()throws Exception{
		privateFundTaskService.updateCompanyStatus();
	}
	@Test
	public  void updateCompanyCount()throws Exception{
		systemAnalyzeTaskService.updateCompanyCount();
	}

	@Test
	public  void queryCompanyStatusChg()throws Exception{
		//Integer areaId,Integer companyType,String beginDate,String endDate,
		//Integer changeTpye,Integer source,Integer closedType,Integer page,Integer pageSize
		Map map=this.coChgMonitorService.queryCompanyStatusChg("1112,1113,1117",null,"2017-01","2017-05",null,null ,null ,1,20);
		System.err.println(JSON.toJSONString(map, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect));
	}

}
