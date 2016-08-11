package com.bbd.wtyh.service.impl;


import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.FinanceLeaseStatisticDO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyAreaVO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyVO;
import com.bbd.wtyh.mapper.ExchangeCompanyMapper;
import com.bbd.wtyh.mapper.FinanceLeaseMapper;
import com.bbd.wtyh.service.ExchangeCompanyService;
import com.bbd.wtyh.service.FinanceLeaseService;
import com.bbd.wtyh.util.CalculateUtils;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public Map leaseCompanyCategory(Integer year) {
        List<FinanceLeaseStatisticDO> list = financeLeaseMapper.queryFinanceLeaseStatisticDO(year);
        Integer inAreaNumber  = 0;
        Integer outAreaNumber = 0;
        Integer companyNumber = 0;
        if (!CollectionUtils.isEmpty(list)) {
            FinanceLeaseStatisticDO financeLeaseStatisticDO = list.get(0);
            financeLeaseStatisticDO.getInAreaNumber();
            financeLeaseStatisticDO.getOutAreaNumber();
            financeLeaseStatisticDO.getCompanyNumber();
        }
        double inRate  = CalculateUtils.divide(inAreaNumber, companyNumber, 2);
        double outRate = CalculateUtils.divide(outAreaNumber, companyNumber, 2);
        Map<String, Double> map = new HashedMap();
        map.put("inRate", inRate);
        map.put("outRate", outRate);
        return map;
    }

    @Override
    public List<FinanceLeaseStatisticDO> leaseCompanyAmount() {
        return null;
    }

    @Override
    public Map leaseCompanyBadRatioAndAmount() {
        List<FinanceLeaseStatisticDO> list = financeLeaseMapper.queryFinanceLeaseStatisticDO(null);
        Map content = new HashedMap();
        Map series = new HashedMap();
        List bar = new ArrayList();
        List line = new ArrayList();
        List xAxis = new ArrayList();
        if (!CollectionUtils.isEmpty(list)) {
            for (FinanceLeaseStatisticDO financeLeaseStatisticDO : list) {
                bar.add(financeLeaseStatisticDO.getBadAmout());
                line.add(financeLeaseStatisticDO.getBadRatio());
                xAxis.add(financeLeaseStatisticDO.getYear());
            }
        }
        series.put("bar",bar);
        series.put("line",line);
        content.put("xAxis", xAxis);
        content.put("series", series);
        return content;
    }
}
