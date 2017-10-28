package com.bbd.wtyh.test;

import com.bbd.bgo.service.task.SystemDataUpdateService;
import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.service.OfflineFinanceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by lixudong on 2017/7/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class CompanyBackUpateTest {

    @Autowired
    private SystemDataUpdateService systemDataUpdateService;

    @Autowired
    private OfflineFinanceService offlineFinanceService;

    @Test
    public void backgroundTest(){
        Integer taskId = 10;
        //Map<String,Integer> map=systemDataUpdateService.updateCompanyAndBackgroundAutomaticOperate(taskId);
        TaskResultDO taskResultDO =systemDataUpdateService.updateCompanyAndBackgroundManualOperate(10,11);
        System.out.println(taskResultDO);
    }
    @Test
    public void riskLevelTest(){
        Integer taskId = 1018;
        try {
            offlineFinanceService.updateCompanyRiskLevel(taskId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
