package com.bbd.wtyh.test;


import com.bbd.bgo.service.task.CompanyTagService;
import com.bbd.bgo.service.task.RealTimeMonitorNewsService;
import com.bbd.bgo.service.task.TagUpdateService;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.third.yuqing.ImportRecordDO;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.CompanyTagMapper;
import com.bbd.wtyh.service.third.yuqing.ThirdYuQingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.bbd.wtyh.core.base.BaseServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    CompanyTagMapper companyTagMapper;
    @Autowired
    private TagUpdateService tagUpdateService;
    @Autowired
    private ThirdYuQingService thirdYuQingService;
    @Autowired
    CompanyMapper companyMapper;
    @Test
    public void test5(){
        List<String> names=new ArrayList<>();
        names.add("上海时鸿投资管理有限公司");
        List<CompanyDO> list=companyMapper.findCompanyByName(names);
        System.out.println(list);
    }
    @Test
    public void yuQingTest(){
        Map<String, String> param =  new HashMap<>();
        param.put("fileName",null);
        param.put("orderBy","ASC");
        param.put("source",null);
        param.put("impState","");
        List<ImportRecordDO> list= thirdYuQingService.findImportRecord(param);

    }
    @Test
    public void test(){
       /* Integer companyTd=companyTagMapper.getMaxDtFromCompanyTag();
        System.out.println(companyTd);
        Integer companyTd2=companyTagMapper.getMaxDtFromQyxxTag();
        System.out.println(companyTd2);*/
        tagUpdateService.operateData();
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
