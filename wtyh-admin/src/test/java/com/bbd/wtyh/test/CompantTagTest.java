package com.bbd.wtyh.test;


import com.bbd.bgo.service.task.CompanyTagService;
import com.bbd.bgo.service.task.RealTimeMonitorNewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.bbd.wtyh.core.base.BaseServiceImpl;

/**
 * Created by Administrator on 2017/4/26 0026.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class CompantTagTest extends BaseServiceImpl {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CompanyTagService companyTagService;
    @Autowired
    private RealTimeMonitorNewsService realTimeMonitorNewsService;
    @Test
    public void test(){
        companyTagService.saveCompanyTag();
    }

    @Test
    public void test2(){

        try {
            realTimeMonitorNewsService.saveRealTimeMonitorNews();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){

        try {
            companyTagService.updateCompanyTypeFromQyxxTag();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test4(){

        try {
            companyTagService.addCompanyFromQyxxTag();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
