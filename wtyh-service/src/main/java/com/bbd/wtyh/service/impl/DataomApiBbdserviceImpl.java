package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.service.DataomApiBbdservice;
import com.bbd.wtyh.util.relation.HttpClientUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by win7 on 2016/8/25.
 */
@Service
public class DataomApiBbdserviceImpl implements DataomApiBbdservice {

    @Value("${api.dataom.news.url}")
    private String url;


    public String bbdQyxgYuqing(String key){
        try {
            return HttpClientUtils.httpGet(url+key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
