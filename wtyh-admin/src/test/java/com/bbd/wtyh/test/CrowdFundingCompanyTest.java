package com.bbd.wtyh.test;

import com.bbd.wtyh.service.CrowdFundingService;
import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.service.SysAnalyzeService;
import com.bbd.wtyh.service.WangdaiTaskInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by lixudong on 2017/7/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class CrowdFundingCompanyTest {
    @Autowired
    private CrowdFundingService crowdFundingService;

    @Autowired
    private WangdaiTaskInfoService wangdaiTaskInfoService;

    @Autowired
    private OfflineFinanceService offlineFinanceService;

    @Test
    public void dataLandTask(){
        Integer taskId = 21;
        crowdFundingService.crowdFundingDataLandTask(taskId);
    }

    @Test
    public void reExecuteTest(){
        Integer taskId = 22;
        Integer oldTaskId = 21;
        Map map = crowdFundingService.executeFailTaskByTaskId(0,oldTaskId,taskId);
        System.out.print(map);
    }

    @Test
    public void wangdaiTaskListTest(){
        List list = wangdaiTaskInfoService.listByTaskId(21);
        System.out.print(list);
    }

    @Test
    public void offlineFinanceServiceTest(){
        Integer taskId = 66;
        Map map = null;
        try {
            map = offlineFinanceService.updateCompanyRiskLevel(taskId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print(map);
    }

}
