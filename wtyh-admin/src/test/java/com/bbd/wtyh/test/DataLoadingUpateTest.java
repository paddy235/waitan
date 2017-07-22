package com.bbd.wtyh.test;

import com.bbd.bgo.service.task.DataLoadingService;
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
    private DataLoadingService dataLoadingTaskService;

    @Test
    public void dataLoadingTest(){

        //手动执行错误的数据拉取
        dataLoadingTaskService.dataLoadingManualOperate(4,5);

        //自动执行
        //dataLoadingTaskService.dataLoadingAutomaticOperate(4);
    }
}
