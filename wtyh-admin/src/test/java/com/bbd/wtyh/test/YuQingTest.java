package com.bbd.wtyh.test;

import com.bbd.wtyh.service.P2PImageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by lixudong on 2017/7/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class YuQingTest {

    @Resource(name = "p2PImageService")
    private P2PImageService p2PImageService;

    @Test
    public void yuqingTest() {
        try {
            p2PImageService.updateWangDaiYuQingTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void platList(){
        try {
            p2PImageService.platListDataLandingTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void platCoreDataTest(){
        try {
            p2PImageService.platCoreDataLandingTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void radarScoreTest(){
        try {
            p2PImageService.radarScoreDataLandingTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}