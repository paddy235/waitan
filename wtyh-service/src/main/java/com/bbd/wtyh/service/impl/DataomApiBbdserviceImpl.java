package com.bbd.wtyh.service.impl;

import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.service.DataomApiBbdservice;
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


    public String bbdQyxgYuqing(final String key){
        try {
            HttpTemplate httpTemplate = new HttpTemplate();
            return httpTemplate.get(url+key, new HttpCallback<String>() {
                @Override
                public boolean valid() {
                    return true;
                }
                @Override
                public String parse(String result) {
                    log.info("舆情"+url+key+" 返回值："+result);
                    return result;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
