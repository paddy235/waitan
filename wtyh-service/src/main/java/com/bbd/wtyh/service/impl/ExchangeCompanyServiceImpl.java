package com.bbd.wtyh.service.impl;


import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyAreaVO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyVO;
import com.bbd.wtyh.mapper.ExchangeCompanyMapper;
import com.bbd.wtyh.service.ExchangeCompanyService;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;

/**
 * 交易所接口实现层
 * @author zhouxuan
 * @since  2016.08.05
 */
@Service("exchangeCompanyService")
public class ExchangeCompanyServiceImpl implements ExchangeCompanyService {
    private Logger logger = LoggerFactory.getLogger(ExchangeCompanyServiceImpl.class);

    @Resource
    private ExchangeCompanyMapper exchangeCompanyMapper;


    @Override
    public List<Map> exchangeCompanyCategory() {
        List<Map> list = exchangeCompanyMapper.queryExchangeCompanyCategory();
        return list;
    }

    @Override
    public List<ExchangeCompanyAreaVO> exchangeCompanyArea() {
        List<ExchangeCompanyAreaVO> list = exchangeCompanyMapper.queryExchangeCompanyArea();
        return list;
    }

    @Override
    public List<ExchangeCompanyVO> exchangeCompanyByStatus(Integer status) {
        List<ExchangeCompanyVO> list = exchangeCompanyMapper.queryExchangeCompanyByStatus(status);
        return list;
    }

    @Override
    public List<CompanyDO> exchangeCompanyListByAreaId(Integer areaId, String orderName, String orderType) {
        Map map = new HashMap();
        map.put("areaId", areaId);
        map.put("orderName", orderName);
        map.put("orderType", orderType);
        List<CompanyDO> list = exchangeCompanyMapper.queryExchangeCompanyListByAreaId(map);
        return list;
    }
}
