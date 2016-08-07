package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.dao.P2PMonitorDao;
import com.bbd.wtyh.service.P2PMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * P2P平台状态信息业务层
 *
 * @author wangchenge
 * @since 2016.08.05
 */
@Service("p2PMonitorService")
public class P2PMonitorServiceImpl implements P2PMonitorService {
    @Autowired
    private P2PMonitorDao p2PMonitorDao;

    @Override
    public Map<String, Object> platFormStatus() {
        return p2PMonitorDao.platFormStatus();
    }

    @Override
    public Map<String, Object> platFormConsensus() {
        return p2PMonitorDao.platFormConsensus();
    }

    @Override
    public Map<String, Object> lawsuitMsg() {
        return p2PMonitorDao.lawsuitMsg();
    }

    @Override
    public Map<String, Object> radarScore() {
        return p2PMonitorDao.radarScore();
    }

    @Override
    public Map<String, String> baseInfo() {
        return p2PMonitorDao.baseInfo();
    }

    @Override
    public Map<String, String> coreDataInfo() {
        return p2PMonitorDao.coreDataInfo();
    }

    @Override
    public List<List<String>> coreDataDealTrend() {
        // 处理数据转换
        Map<String, String> data = p2PMonitorDao.coreDataDealTrend();
        List<String> years = new ArrayList<>();
        List<String> dealNumbers = new ArrayList<>();
        for (Map.Entry<String, String> entity : data.entrySet()) {
            years.add(entity.getKey());
            dealNumbers.add(entity.getValue());
        }

        List<List<String>> result = new ArrayList<>();
        result.add(years);
        result.add(dealNumbers);
        return result;
    }

    @Override
    public List<List<String>> coreDataInterestRateTrend() {
        // 处理数据转换
        Map<String, String> data = p2PMonitorDao.coreDataInterestRateTrend();
        List<String> years = new ArrayList<>();
        List<String> interestRates = new ArrayList<>();
        for (Map.Entry<String, String> entity : data.entrySet()) {
            years.add(entity.getKey());
            interestRates.add(entity.getValue());
        }

        List<List<String>> result = new ArrayList<>();
        result.add(years);
        result.add(interestRates);
        return result;
    }

    @Override
    public List<List<String>> coreDataLoanOverage() {
        // 处理数据转换
        Map<String, String> data = p2PMonitorDao.coreDataLoanOverage();
        List<String> years = new ArrayList<>();
        List<String> loanOverages = new ArrayList<>();
        for (Map.Entry<String, String> entity : data.entrySet()) {
            years.add(entity.getKey());
            loanOverages.add(entity.getValue());
        }

        List<List<String>> result = new ArrayList<>();
        result.add(years);
        result.add(loanOverages);
        return result;
    }
}
