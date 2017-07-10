package com.bbd.wtyh.test;

import com.bbd.wtyh.service.P2PImageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by lixudong on 2017/7/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class YuQingTest {
    @Resource(name = "p2PImageService")
    private P2PImageService p2PImageService;

    @Test
    public void yuqingTest(){
        p2PImageService.updateWangDaiYuQingTask();
    }
}
