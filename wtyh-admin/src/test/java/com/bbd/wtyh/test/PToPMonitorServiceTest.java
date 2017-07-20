package com.bbd.wtyh.test;

import com.bbd.wtyh.service.PToPMonitorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by lixudong on 2017/7/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class PToPMonitorServiceTest {

    @Autowired
    private PToPMonitorService monitorService;

    @Test
    public void industryShanghaiDataLanding() {
        Integer taskId = 1;
        Map map = monitorService.pToPMonitorDataLandTask(taskId);
        System.out.print(map);
    }

}
