package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.service.DataomApiBbdservice;
import com.bbd.wtyh.util.relation.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by win7 on 2016/8/25.
 */
@Service
public class DataomApiBbdserviceImpl implements DataomApiBbdservice {

     private static Logger log = LoggerFactory.getLogger(DataomApiBbdserviceImpl.class);


    @Value("${api.dataom.news.url}")
    private String url;


    public String bbdQyxgYuqing(String key){
        try {
            String result = HttpClientUtils.httpGet(url+key);
            log.info("舆情"+url+key+" 返回值："+result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("舆情错误"+url+key,e);
            return null;
        }
    }
}
