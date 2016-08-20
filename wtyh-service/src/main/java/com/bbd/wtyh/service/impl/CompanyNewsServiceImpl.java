package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bbd.higgs.utils.ListUtil;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.RelatedCompanyDO;
import com.bbd.wtyh.domain.RelatedCompanyStatisticDO;
import com.bbd.wtyh.domain.dto.ShareholderRiskDTO;
import com.bbd.wtyh.domain.vo.CompanyNewsVO;
import com.bbd.wtyh.domain.vo.StatisticsVO;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.RelatedCompanyMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.CompanyNewsService;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.ShareholderRiskService;
import com.bbd.wtyh.util.relation.HttpClientUtils;
import com.bbd.wtyh.web.relationPara.param.RelatedParameters;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    @Value("${api.baidu.news.url}")
    private String url;

    @Value("${api.baidu.batch.news.ak}")
    private String ak;

    @Value("${api.baidu.batch.news.ktype}")
    private int ktype;

    @Value("${api.baidu.batch.news.url}")
    private String batchNewsUrl;

    @Value("${api.baidu.batch.news.start}")
    private String start;
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
        try {
            if(!StringUtils.isEmpty(company)){
                List<NameValuePair> list = new ArrayList<>();
                list.add(new BasicNameValuePair("keys", company));
                list.add(new BasicNameValuePair("ktype", ""+ktype));
                list.add(new BasicNameValuePair("start", start));
                list.add(new BasicNameValuePair("ak",ak));
                try {
                    String data = HttpClientUtils.httpPost(batchNewsUrl, list);
                    return data;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
            list.add(new BasicNameValuePair("keys", names.substring(0, names.length()-1) +",贵阳市城市建设投资有限责任公司,贵州詹阳动力重工有限公司"   ));
            list.add(new BasicNameValuePair("ktype", ""+ktype));
            list.add(new BasicNameValuePair("start", start));
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
            list.add(new BasicNameValuePair("keys", names.substring(0, names.length()-1) +",贵阳市城市建设投资有限责任公司,贵州詹阳动力重工有限公司"   ));
            list.add(new BasicNameValuePair("ktype", ""+ktype));
            list.add(new BasicNameValuePair("start", start));
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
