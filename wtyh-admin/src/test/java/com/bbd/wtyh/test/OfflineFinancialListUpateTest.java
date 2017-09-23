package com.bbd.wtyh.test;

import com.bbd.bgo.service.task.DataLoadingService;
import com.bbd.bgo.service.task.OfflineFinancialListTaskService;
import com.bbd.bgo.service.task.SyncFileService;
import com.bbd.bgo.service.task.SystemDataUpdateService;
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
public class OfflineFinancialListUpateTest {

    @Autowired
    private OfflineFinancialListTaskService offlineFinancialListTaskService;
    @Autowired
    private SyncFileService syncFileService;
    @Autowired
    private DataLoadingService dataLoadingService;

    @Test
    public void dataLoadingTest(){
        offlineFinancialListTaskService.offlineFinancialListUpdate(1L);
    }
    @Test
    public void pullFileTest(){
        syncFileService.pullFile(0);

    }
    @Test
    public void pullFileTest2(){
        dataLoadingService.dataLoadingAutomaticOperate(0);

    }


}
