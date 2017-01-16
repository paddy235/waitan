package com.bbd.wtyh.dao.impl;

import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.dao.CrowdFundingDao;
import com.bbd.wtyh.dao.OfflineFinanceDao;
import com.bbd.wtyh.domain.CrowdFundingCompanyDO;
import com.bbd.wtyh.domain.dto.RelationDTO;
import com.bbd.wtyh.domain.dto.RelationRealDTO;
import com.bbd.wtyh.domain.wangDaiAPI.CrowdFundingStatisticsDTO;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.util.relation.URLEncoder;
import com.bbd.wtyh.web.relationVO.SubGraphVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 *
 */
@Repository("crowdFundingDao")
public class CrowdFundingDaoImpl implements CrowdFundingDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrowdFundingDaoImpl.class);

    @Value("${crowd.funding.url}")
    private String crowdFundingUrl;

    @Autowired
    private HttpTemplate httpTemplate;

    @Override
    public List<CrowdFundingCompanyDO> allCompanys() {
        String api = crowdFundingUrl + 1;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<List<CrowdFundingCompanyDO>>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public List<CrowdFundingCompanyDO> parse(String response) {
                    if (null == response || response.length() == 0) {
                        return null;
                    }
                    return new Gson().fromJson(response, new TypeToken<List<CrowdFundingCompanyDO>>() {}.getType());
                }
            });
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public Map<String, String> lastMonthType(String dataType) {
        String api = crowdFundingUrl + dataType;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<Map<String, String>>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public Map<String, String> parse(String response) {
                    if (null == response || response.length() == 0) {
                        return null;
                    }
                    return new Gson().fromJson(response, new TypeToken<Map<String, String>>() {}.getType());
                }
            });
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

}
