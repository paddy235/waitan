package com.bbd.wtyh.test;

import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.service.UpdateWhiteCompanyRiskGradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @Author:WLL
 * @Date:Create on 9:512017/11/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class UpdateWhiteCompanyTest {
    @Autowired
    @Qualifier(value = "baseServiceImpl")
    private BaseService baseService;

    @Autowired
    private UpdateWhiteCompanyRiskGradeService updateWhiteCompanyRiskGradeService;


    @Test
    public void updateTest() {
        Date a = new Date();
        updateWhiteCompanyRiskGradeService.startUpdate();
        Date b = new Date();
        long interval = (b.getTime() - a.getTime())/1000;
        System.out.println("总共用时："+interval+"秒");
    }
}
