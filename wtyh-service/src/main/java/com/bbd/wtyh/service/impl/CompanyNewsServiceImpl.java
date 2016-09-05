package com.bbd.wtyh.service.impl;

import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.CompanyNewsService;
import com.bbd.wtyh.service.DataomApiBbdservice;
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
 * @since 2016.08.12
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

    @Value("${api.dataom.yuqing.url}")
    private String apiDataomYuqingUrl;


    @Value("${api.dataom.news.url}")
    private String apiDataonNewsUrl;


    @Autowired
    private DataomApiBbdservice dataomApiBbdservice;

    /**
     * @param url     地址
     * @param company 公司名称
     * @return
     * @author David
     */
    public String dataAddressCombination(String url, String company) {
        String query = "";
        query = url + "?" + "company=" + company + "&ak=" + ak;
        return query;
    }

    @Override
    public String getCompanyNews(String company) {
        String result = null;

        try {
            if (!StringUtils.isEmpty(company)) {
                HttpTemplate ht = new HttpTemplate();
                result = ht.get(apiDataonNewsUrl + company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == null || result.contains("\"total\": 0")) {
            return getCompanyNews();
        }

        return result;
    }


    @Override
    public String findCompanyNews(String company) {
        String result = null;

        try {
            if (!StringUtils.isEmpty(company)) {
                HttpTemplate ht = new HttpTemplate();
                result = ht.get(apiDataonNewsUrl + company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getCompanyNews() {
        try {
            return new HttpTemplate().get(apiDataomYuqingUrl);
        } catch (Exception e) {
            logger.error("Method getCompanyNews get Exception." + e.getMessage());
            return null;
        }
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void scheduleQueryCompanyNews() {
        String names = companyMapper.queryCompanyNames(null, null);
        if (!StringUtils.isEmpty(names)) {
            List<NameValuePair> list = new ArrayList<>();
            list.add(new BasicNameValuePair("keys", names.substring(0, names.length() - 1)));
            list.add(new BasicNameValuePair("ktype", "" + ktype));
            list.add(new BasicNameValuePair("pageSize", "100"));
            list.add(new BasicNameValuePair("ak", ak));
            try {
                String data = new HttpTemplate().post(batchNewsUrl, list);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
