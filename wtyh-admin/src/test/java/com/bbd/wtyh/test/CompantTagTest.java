package com.bbd.wtyh.test;


import com.bbd.wtyh.service.CompanyTagService;
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
    private  CompanyTagService companyTagService;
    @Test
    public void test(){
        companyTagService.saveCompanyTag();
    }


}
