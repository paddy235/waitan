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
        //qyxxTagMapper.clearTable("qyxx_tag");
        tagUpdateService.operateData();
        //qyxxTagMapper.clearTable("qyxx_tag_black");
        //qyxxTagMapper.oldTableIntoNewTable("qyxx_tag", "qyxx_tag_new");
        //qyxxTagMapper.renameTable("qyxx_tag_whitexx", "qyxx_tag_white_yy");
        //qyxxTagMapper.deleteTable("qyxx_tag_white_yy");
    }


}
