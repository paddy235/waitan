package com.bbd.wtyh.test;

import com.bbd.bgo.service.task.TagUpdateService;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.mapper.QyxxTagMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cgj on 2017-09-06.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class QyxxTagTest {
    @Autowired
    @Qualifier(value = "baseServiceImpl")
    private BaseService baseService;

    @Autowired
    private TagUpdateService tagUpdateService;

    @Autowired
    private QyxxTagMapper qyxxTagMapper;

    @Test
    public void tagTest1() {
        tagUpdateService.operateData();
        /* 维护subscription_list表
        qyxxTagMapper.clearTable("subscription_list_append");
        qyxxTagMapper.companyNameToSubscriptionListAppend();
        qyxxTagMapper.clearTable("subscription_list_remove");
        qyxxTagMapper.companyNameToSubscriptionListRemove();
        qyxxTagMapper.clearTable("subscription_list");
        qyxxTagMapper.companyNameTagToSubscriptionList();*/
    }


}
