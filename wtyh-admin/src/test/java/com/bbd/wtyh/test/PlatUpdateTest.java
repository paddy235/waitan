package com.bbd.wtyh.test;

import com.bbd.bgo.service.task.PlatUpdateTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by zhaohongwen on 2017/7/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class PlatUpdateTest {

    @Autowired
    private PlatUpdateTaskService platUpdateTaskService;

    @Test
    public void updatePlatAutomaticOperate(){
        Map<String,Integer> map = platUpdateTaskService.updatePlatAutomaticOperate(1);
        System.out.println(map);
    }

    @Test
    public void updatePlatManualOperate(){
        Map<String,Integer> map = platUpdateTaskService.updatePlatManualOperate(1,2);
        System.out.println(map);
    }
}
