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
            for (Map map : list) {
                Map result = new HashedMap();
                int status = (int)map.get("status");
                String statusName = "";
                if (status == 1) {
                    statusName = "市政府批复设立";
                } else if (status == 2) {
                    statusName = "自行设立";
                } else if (status == 3) {
                    statusName = "主管单位批设但未经会商";
                } else if (status == 4) {
                    statusName = "取得合规意见或经过会商";
                } else if (status == 5) {
                    statusName = "通过验收";
                } else {
                    //do nothing;
                }
                result.put(statusName, map.get("number"));
                resultList.add(result);
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
