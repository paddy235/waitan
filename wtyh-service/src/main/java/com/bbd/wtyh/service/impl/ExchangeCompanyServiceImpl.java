package com.bbd.wtyh.service.impl;


import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.enums.ExchangeCompanyStatus;
import com.bbd.wtyh.domain.vo.ExchangeCompanyAreaVO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyVO;
import com.bbd.wtyh.mapper.ExchangeCompanyMapper;
import com.bbd.wtyh.service.ExchangeCompanyService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * 交易所接口实现层
 * @author zhouxuan
 * @since  2016.08.10
 */
@Service("exchangeCompanyService")
public class ExchangeCompanyServiceImpl implements ExchangeCompanyService {
    private Logger logger = LoggerFactory.getLogger(ExchangeCompanyServiceImpl.class);

    @Resource
    private ExchangeCompanyMapper exchangeCompanyMapper;


    @Override
    public List<Map> exchangeCompanyCategory() {
        List<Map> list = exchangeCompanyMapper.queryExchangeCompanyCategory();
        List<Map> resultList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)) {
            Map<String, Integer> resultMap = new HashedMap();
            for (Map map : list) {
                int status = (int)map.get("status");
                int number = Integer.parseInt(map.get("number").toString());
                String statusName = "";
                if (status == 2) {
                    statusName = "企业自行设立";
                    resultMap.put(statusName, number);
                } else if (status == 1 || status == 3 || status == 4) {
                    statusName = "市政府及市相关主管单位批复设立";
                    if (resultMap.get(statusName) == null) {
                        resultMap.put(statusName, number);
                    } else {
                        resultMap.put(statusName, resultMap.get(statusName) + number);
                    }
                } else if (status == 5) {
                    statusName = "2013年通过清整联办验收";
                    resultMap.put(statusName, number);
                } else {
                    //do nothing;
                }
            }
            for (String key : resultMap.keySet()) {
                Map temp = new HashedMap();
                temp.put(key, resultMap.get(key));
                resultList.add(temp);
            }
        }
        return resultList;
    }

    @Override
    public List<ExchangeCompanyAreaVO> exchangeCompanyArea() {
        List<ExchangeCompanyAreaVO> list = exchangeCompanyMapper.queryExchangeCompanyArea();
        return list;
    }

    @Override
    public List<ExchangeCompanyVO> exchangeCompanyByStatus(String statusName) {
        Integer status = 1;
        if ("市政府批复设立".equals(statusName)) {
            status = 1;
        } else if ("自行设立".equals(statusName)) {
            status = 2;
        } else if ("主管单位批设但未经会商".equals(statusName)) {
            status = 3;
        } else if ("取得合规意见或经过会商".equals(statusName)) {
            status = 4;
        } else if ("通过验收".equals(statusName)) {
            status = 5;
        } else {
            //do nothing
        }
        List<ExchangeCompanyVO> list = exchangeCompanyMapper.queryExchangeCompanyByStatus(status);
        return list;
    }

    @Override
    public List<CompanyDO> exchangeCompanyListByAreaId(String areaName, String orderName, String orderType) {
        Map map = new HashMap();
        map.put("areaName", areaName);
        map.put("orderName", orderName);
        map.put("orderType", orderType);
        List<CompanyDO> list = exchangeCompanyMapper.queryExchangeCompanyListByAreaId(map);
        return list;
    }
}
