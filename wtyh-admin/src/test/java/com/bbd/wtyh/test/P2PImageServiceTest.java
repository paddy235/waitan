package com.bbd.wtyh.test;

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
        Map map = p2PImageService.p2pImagineDataLandTask(taskId);
        System.out.print(map);
    }
}
