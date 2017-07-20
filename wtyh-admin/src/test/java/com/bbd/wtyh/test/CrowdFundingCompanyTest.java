package com.bbd.wtyh.test;

import com.bbd.wtyh.service.CrowdFundingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lixudong on 2017/7/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class CrowdFundingCompanyTest {
    @Autowired
    CrowdFundingService crowdFundingService;

    @Test
    public void dataLandTask(){
        Integer taskId = null;
        crowdFundingService.crowdFundingDataLandTask(taskId);
    }

}
