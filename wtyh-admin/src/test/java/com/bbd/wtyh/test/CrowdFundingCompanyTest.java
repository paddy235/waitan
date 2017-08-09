package com.bbd.wtyh.test;

import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.service.CrowdFundingService;
import com.bbd.wtyh.service.OfflineFinanceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 众筹数据落地
 * Created by lixudong on 2017/7/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class CrowdFundingCompanyTest {
    @Autowired
    private CrowdFundingService crowdFundingService;


    /**
     * 众筹执行数据落地任务
     */
    @Test
    public void dataLandTask(){
        Integer taskId = 21;
        TaskResultDO taskResultDO = crowdFundingService.crowdFundingDataLandTask(taskId);
        System.out.print(taskResultDO);
    }

    /**
     * 执行众筹失败的数据落地任务
     */
    @Test
    public void reExecuteTest(){
        Integer taskId = 22;
        Integer oldTaskId = 21;
        TaskResultDO taskResultDO = crowdFundingService.executeFailTaskByTaskId(0,oldTaskId,taskId);
        System.out.print(taskResultDO);
    }

    @Test
    public void showDown(){
        crowdFundingService.stopTask();
    }


}
