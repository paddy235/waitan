package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.RelatedCompanyDO;
import com.bbd.wtyh.domain.RelatedCompanyStatisticDO;
import com.bbd.wtyh.domain.dto.ShareholderRiskDTO;
import com.bbd.wtyh.domain.vo.CompanyNewsVO;
import com.bbd.wtyh.mapper.RelatedCompanyMapper;
import com.bbd.wtyh.service.CompanyNewsService;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.ShareholderRiskService;
import com.bbd.wtyh.web.relationPara.param.RelatedParameters;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.map.HashedMap;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Resource
    private HttpTemplate httpTemplate;

    @Value("${api.baidu.news.url}")
    private String url;

    @Value("${api.baidu.news.ak}")
    private String ak;

    public HttpGet httpGet;

    public HttpClient client;

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
    public List getCompanyNews(String company) {
        HttpTemplate httpTemplate = new HttpTemplate();

        String Assemble_url = dataAddressCombination(url, company);
        try {
            return  httpTemplate.get(Assemble_url, new HttpCallback<List>() {
                @Override
                public boolean valid() {
                    return false;
                }

                @Override
                public List parse(String result) {
                    JSONObject object = JSON.parseObject(result);
                    System.out.println("--object--------" + object);
                    String results = String.valueOf(object.get("results"));
                    System.out.println("--results--------" + results);
                    List<CompanyNewsVO> list = new ArrayList();
                    list = JSON.parseArray(results, CompanyNewsVO.class);
                    System.out.println("-----" + list.size());
                    return list;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
