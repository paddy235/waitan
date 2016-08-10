package com.bbd.wtyh.service.impl;


import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyAreaVO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyVO;
import com.bbd.wtyh.mapper.ExchangeCompanyMapper;
import com.bbd.wtyh.mapper.FinanceLeaseMapper;
import com.bbd.wtyh.service.ExchangeCompanyService;
import com.bbd.wtyh.service.FinanceLeaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 融资租赁接口实现层
 * @author zhouxuan
 * @since  2016.08.10
 */
@Service("financeLeaseService")
public class FinanceLeaseServiceImpl implements FinanceLeaseService {
    private Logger logger = LoggerFactory.getLogger(FinanceLeaseServiceImpl.class);

    @Resource
    private FinanceLeaseMapper financeLeaseMapper;


    @Override
    public List<Map> exchangeCompanyCategory() {
        return null;
    }

    @Override
    public List<ExchangeCompanyAreaVO> exchangeCompanyArea() {
        return null;
    }

    @Override
    public List<ExchangeCompanyVO> exchangeCompanyByStatus(Integer status) {
        return null;
    }

    @Override
    public List<CompanyDO> exchangeCompanyListByAreaId(Integer areaId, String orderName, String orderType) {
        return null;
    }
}
