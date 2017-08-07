package com.bbd.wtyh.test;

import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.service.PToPMonitorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * p2p监测数据落地
 * Created by lixudong on 2017/7/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class PToPMonitorServiceTest {

    @Autowired
    private PToPMonitorService monitorService;

    @Autowired
    private OfflineFinanceService offlineFinanceService;

    /**
     * 执行p2p检测数据落地
     */
    @Test
    public void monitorDataLanding() {

        Integer taskId = 11;
        TaskResultDO taskResultDO = monitorService.pToPMonitorDataLandTask(taskId);
        System.out.print(taskResultDO);
    }

    /**
     * 重新执行失败的定时任务
     */
    @Test
    public void reExecuteTest() {
        Integer taskId = 12;
        Integer oldTaskId = 11;
        TaskResultDO taskResultDO = monitorService.executeFailTaskByTaskId(0, oldTaskId, taskId);
        System.out.print(taskResultDO);
    }

    /**
     * 根据线下理财数据更新风险等级
     */
    @Test
    public void updateCompanyRiskLevelTest(){
        Integer taskId = 50;
        TaskResultDO taskResultDO=null;
        try {
            taskResultDO = offlineFinanceService.updateCompanyRiskLevel(taskId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print(taskResultDO);
    }

    /**
     * 重新执行失败的定时任务
     */
    @Test
    public void reExecuteCompanyRiskLevel(){
        Integer taskId = 51;
        Integer oldTaskId = 50;
        TaskResultDO taskResultDO=null;
        try {
            taskResultDO = offlineFinanceService.executeFailTaskByTaskId(0,oldTaskId,taskId);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.print(taskResultDO);
    }

}
