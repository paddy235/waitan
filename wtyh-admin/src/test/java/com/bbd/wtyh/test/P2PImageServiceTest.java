package com.bbd.wtyh.test;

import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.service.P2PImageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by lixudong on 2017/7/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class P2PImageServiceTest {

    @Autowired
    private P2PImageService p2PImageService;

    @Test
    public void dataLandTest(){
        Integer taskId = 0;
        TaskResultDO taskResultDO = p2PImageService.p2pImageDataLandTask(taskId);
        System.out.print(taskResultDO);
    }

    @Test
    public void reExecuteTest(){
        Integer taskId = 1;
        Integer oldTaskId = 0;
        TaskResultDO taskResultDO = p2PImageService.executeFailTaskByTaskId(1,oldTaskId,taskId);
        System.out.print(taskResultDO);
    }
}
