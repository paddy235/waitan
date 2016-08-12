package com.bbd.wtyh.service.impl;

import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.RelatedCompanyDO;
import com.bbd.wtyh.domain.RelatedCompanyStatisticDO;
import com.bbd.wtyh.domain.dto.ShareholderRiskDTO;
import com.bbd.wtyh.mapper.RelatedCompanyMapper;
import com.bbd.wtyh.service.CompanyNewsService;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.ShareholderRiskService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Value("${aip.baidu.news.url}")
    private String url;

    public HttpGet httpGet;

    public HttpClient client;

    @Override
    public List getCompanyNews() {
        return null;
    }
}
