package com.bbd.wtyh.test;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bbd.wtyh.domain.ResourceDo;
import com.bbd.wtyh.domain.dto.UserRoleDTO;
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
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class RoleResourceTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RoleResourceService resourceService;

    @Test
    public void getRoleResourceTest() throws Exception {
        long s = System.currentTimeMillis();
        List<RoleDo> list = this.resourceService.getRoleResource("B");
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
}
