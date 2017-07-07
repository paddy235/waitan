package com.bbd.wtyh.test;

import com.bbd.bgo.service.task.DataLoadingTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhaohongwen on 2017/7/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class DataLoadingUpateTest {

    @Autowired
    private DataLoadingTaskService dataLoadingTaskService;

    @Test
    public void dataLoadingTest(){
        dataLoadingTaskService.dataLoading();
    }
}
