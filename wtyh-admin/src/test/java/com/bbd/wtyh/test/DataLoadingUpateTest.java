package com.bbd.wtyh.test;

import com.alibaba.fastjson.JSONObject;
import com.bbd.bgo.service.task.DataLoadingService;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.util.HttpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaohongwen on 2017/7/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class DataLoadingUpateTest {

    @Autowired
    private DataLoadingService dataLoadingTaskService;

    @Test
    public void dataLoadingTest() {

        //手动执行错误的数据拉取
        dataLoadingTaskService.dataLoadingManualOperate(4, 5);

        //自动执行
        //dataLoadingTaskService.dataLoadingAutomaticOperate(4);
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    @Qualifier(value = "baseServiceImpl")
    private BaseService baseService;

    /**
     * 删除全息数据订阅名单
     * 
     * @throws Exception
     */
    @Test
    public void delSubscriptionList() throws Exception {
        modifySubscriptionList(true);
    }

    /**
     * 添加全息数据订阅名单
     * 
     * @throws Exception
     */
    @Test
    public void addSubscriptionList() throws Exception {
        modifySubscriptionList(false);
    }

    /**
     * 修改全息数据订阅名单
     */
    private void modifySubscriptionList(boolean isDel) throws Exception {

        String url = "http://datasub.bbdservice.com/api/bbd_directory/?";

        Map<String, Object> param = new HashMap<>(3);
        param.put("usercode", 10003);
        param.put("del", isDel);

        List<SubscriptionList> list = this.baseService.selectAll(SubscriptionList.class, "");

        ExecutorService executors = Executors.newFixedThreadPool(4);

        logger.info("start");
        for (SubscriptionList slDo : list) {
            executors.execute(() -> {
                String name = slDo.getCompanyName();
                param.put("company", name);

                JSONObject result;
                try {
                    result = HttpUtil.get(url, param, JSONObject.class);
                } catch (Exception e) {
                    if (isDel) {
                        logger.error("删除全息数据订阅名单异常:{}", name, e);
                    } else {
                        logger.error("添加全息数据订阅名单异常:{}", name, e);
                    }
                    return;
                }

                if (result != null && result.getIntValue("err_code") > 0) {
                    logger.error("isDel:{}, {}:{}", isDel, name, result.toJSONString());
                } else {
                    logger.info("isDel:{}, {}:{}", isDel, name, result);
                }
            });
        }
        executors.shutdown();
        executors.awaitTermination(1, TimeUnit.DAYS);
        logger.info("end");

    }

    @Table(name = "subscription_list")
    public static class SubscriptionList {

        @Column(name = "company_name")
        private String companyName;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }
    }

}
