package com.bbd.wtyh.test;

import com.bbd.bgo.service.task.SystemDataUpdateService;
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
        systemDataUpdateService.updateCompanyTableAreaIdAndAddress();
    }

    @Test
    public void updateCompanyRiskLevel(){
        offlineFinanceService.updateCompanyRiskLevel();
    }
}
