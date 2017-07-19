package com.bbd.wtyh.test;

import com.bbd.wtyh.service.PToPMonitorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lixudong on 2017/7/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class PToPMonitorServiceTest {

    @Autowired
    private PToPMonitorService monitorService;

    @Test
    public void industryShanghaiDataLanding() {
        try {
            monitorService.industryShanghaiDataLandingTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void industryCompareDataLanding() {
        try {
            monitorService.industryCompareDataLandingTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void platRankDataLanding(){
        try {
            monitorService.platRankDataLandingTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void areaIndexDataLanding(){
        try {
            monitorService.areaIndexDataLandingTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void industryProblem(){
        try {
            monitorService.industryProblemDataLandingTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
