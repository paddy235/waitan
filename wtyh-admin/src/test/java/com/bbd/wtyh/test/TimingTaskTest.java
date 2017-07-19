package com.bbd.wtyh.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bbd.bgo.quartz.TaskUtil;
import com.bbd.bgo.service.task.PrivateFundTaskService;
import com.bbd.bgo.service.task.SystemDataUpdateService;
import com.bbd.wtyh.domain.TaskInfoDO;
import com.bbd.wtyh.domain.dto.TaskInfoDTO;
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
        List<TaskInfoDTO> list =timingTaskService.getTaskInfo();
        System.err.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect));
    }
    @Test
    public void test2(){
        List<TaskInfoDTO> list =timingTaskService.getLatestTaskInfo("4","3");
        System.err.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect));
    }

    @Test
    public void test3(){//TEST
        List<TaskInfoDTO> list =timingTaskService.getHistoryTaskInfo(TaskUtil.shangHaiCreditJob[0],TaskUtil.shangHaiCreditJob[1],"1","3");
        System.err.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect));
    }
}
