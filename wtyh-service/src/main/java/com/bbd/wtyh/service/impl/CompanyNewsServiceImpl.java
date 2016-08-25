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
            String companyNewsJsonData = (String)redisDAO.getObject(Constants.REDIS_KEY_NEWS_DATA);
            if (!StringUtils.isEmpty(companyNewsJsonData)) {
                return companyNewsJsonData;
            } else {
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if( !org.springframework.util.StringUtils.hasText(result) ){
            return dataomApiBbdservice.bbdQyxgYuqing("上海自贸区");
        }

        if(result.contains("\"total\": 0")){
            return dataomApiBbdservice.bbdQyxgYuqing("上海自贸区");
        }

        return result;
    }
    @Override
    public String getCompanyNews() {
        String companyNewsJsonData = (String)redisDAO.getObject(Constants.REDIS_KEY_NEWS_DATA);
        if (!StringUtils.isEmpty(companyNewsJsonData)) {
            return companyNewsJsonData;
        } else {
            String names = companyMapper.queryCompanyNames(null, null);
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
                if (!StringUtils.isEmpty(data)) {
                    redisDAO.addObject(Constants.REDIS_KEY_NEWS_DATA, data, Constants.cacheDay, String.class);
                    return data;
                }
            } catch (Exception e) {
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
            list.add(new BasicNameValuePair("keys", names.substring(0, names.length()-1) +",DCM投资管理咨询（北京）有限公司上海分公司,GMS中国办事处,I.TCHINA,《国际金融报》社有限公司,一创（上海）投资管理中心（有限合伙）,一半堂投资管理（上海）有限公司,一尘（上海）投资管理有限公司,一忆（上海）股权投资管理有限公司,一思资产管理（上海）有限公司,一村资产管理有限公司,一村资本有限公司,一欣投资管理（上海）有限公司,一济投资管理有限公司,一溪投资管理（上海）有限公司,一炫定稚资产管理（上海）有限公司,一片蓝（上海）投资管理合伙企业（有限合伙）,一翼（上海）互联网金融信息服务有限公司,一诺千诚投资管理（上海）有限公司,一诺千诚金融信息服务（上海）有限公司,一财众联财富管理有限公司,一财长富资产管理有限公司"   ));
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
