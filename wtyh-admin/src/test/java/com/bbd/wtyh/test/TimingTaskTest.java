package com.bbd.wtyh.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bbd.bgo.service.task.PrivateFundTaskService;
import com.bbd.bgo.service.task.SystemDataUpdateService;
import com.bbd.wtyh.domain.TaskInfoDO;
import com.bbd.wtyh.service.CoRiskChgService;
import com.bbd.wtyh.service.TimingTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class TimingTaskTest {
    @Autowired
    private TimingTaskService timingTaskService;
    @Autowired
    private SystemDataUpdateService systemDataUpdateService;

    @Test
    public void test1(){
        List<TaskInfoDO> list =timingTaskService.getTaskInfo();
        System.err.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect));
    }
    @Test
    public void test2(){
        List<TaskInfoDO> list =timingTaskService.getLatestTaskInfo();
        System.err.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect));
    }

    @Test
    public void test3(){
        systemDataUpdateService.updateCompanyTableAreaIdAndAddress();
      //  System.err.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect));
    }
}