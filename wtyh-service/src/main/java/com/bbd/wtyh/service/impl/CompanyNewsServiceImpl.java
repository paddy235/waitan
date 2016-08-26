package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.CompanyNewsService;
import com.bbd.wtyh.service.DataomApiBbdservice;
import com.bbd.wtyh.util.relation.HttpClientUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tracy zhou
 * @since  2016.08.12
 */
@Service
public class CompanyNewsServiceImpl implements CompanyNewsService {
    @Autowired
    private RedisDAO redisDAO;
    @Autowired
    private CompanyMapper companyMapper;

    @Value("${api.baidu.batch.news.ak}")
    private String ak;

    @Value("${api.baidu.batch.news.ktype}")
    private int ktype;

    @Value("${api.baidu.batch.news.url}")
    private String batchNewsUrl;

    @Autowired
    private DataomApiBbdservice dataomApiBbdservice;

    /**
     * @param url        地址
     * @param company    公司名称
     * @return
     * @author David
     */
    public String dataAddressCombination(String url, String company) {
        String query = "";
        query = url+"?"+"company="+company+"&ak="+ak;
        return query;
    }

    @Override
    public String getCompanyNews(String company) {
        String result = null;

        try {

            if (!StringUtils.isEmpty(company)) {
                List<NameValuePair> list = new ArrayList<>();
                list.add(new BasicNameValuePair("keys", company));
                list.add(new BasicNameValuePair("ktype", "" + ktype));
                list.add(new BasicNameValuePair("pageSize", "20"));
                list.add(new BasicNameValuePair("page", "1"));
                list.add(new BasicNameValuePair("ak", ak));
                try {
                    result = HttpClientUtils.httpPost(batchNewsUrl, list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if( !org.springframework.util.StringUtils.hasText(result) ){
            return dataomApiBbdservice.bbdQyxgYuqing("金融");
        }

        if(result.contains("\"total\": 0")){
            return dataomApiBbdservice.bbdQyxgYuqing("金融");
        }

        return result;
    }
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public String getCompanyNews() {
        String companyNewsJsonData = (String)redisDAO.getObject(Constants.REDIS_KEY_NEWS_DATA);
        if (false && !StringUtils.isEmpty(companyNewsJsonData)) {
        	logger.info("Get in redis." + companyNewsJsonData);
            return companyNewsJsonData;
        } else {
            String names = companyMapper.queryCompanyNames(null, null);
            logger.info("Query company names." + names);
            if(StringUtils.isEmpty(names)){
                return null;
            }
            List<NameValuePair> list = new ArrayList<>();
            list.add(new BasicNameValuePair("keys", names.substring(0, names.length()-1) ));
            list.add(new BasicNameValuePair("ktype", ""+ktype));
            list.add(new BasicNameValuePair("pageSize", "100"));
            list.add(new BasicNameValuePair("ak",ak));
            try {
                String data = HttpClientUtils.httpPost(batchNewsUrl, list);
                if(data==null || data.contains("\"total\"")){
                    data = dataomApiBbdservice.bbdQyxgYuqing("上海");
                }

                if( !org.springframework.util.StringUtils.hasText(data) ){
                    data = dataomApiBbdservice.bbdQyxgYuqing("上海");

                }else if(data.contains("\"total\": 0")){
                    data = dataomApiBbdservice.bbdQyxgYuqing("上海");
                }

                if (!StringUtils.isEmpty(data)) {
                	logger.info("Set in redis." + data);
                    redisDAO.addObject(Constants.REDIS_KEY_NEWS_DATA, data, Constants.cacheDay, String.class);
                    return data;
                }
            } catch (Exception e) {
            	logger.error("Method getCompanyNews get Exception." + e.getMessage());
                e.printStackTrace();
            }
        }
        return null;
    }

    @Scheduled(cron="0 0 0 * * *")
    public void scheduleQueryCompanyNews() {
        String names = companyMapper.queryCompanyNames(null, null);
        if(!StringUtils.isEmpty(names)){
            List<NameValuePair> list = new ArrayList<>();
            list.add(new BasicNameValuePair("keys", names.substring(0, names.length()-1)  ));
            list.add(new BasicNameValuePair("ktype", ""+ktype));
            list.add(new BasicNameValuePair("pageSize", "100"));
            list.add(new BasicNameValuePair("ak",ak));
            try {
                String data = HttpClientUtils.httpPost(batchNewsUrl, list);
                if (!StringUtils.isEmpty(data)) {
                    redisDAO.addObject(Constants.REDIS_KEY_NEWS_DATA, data, Constants.cacheDay, String.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
