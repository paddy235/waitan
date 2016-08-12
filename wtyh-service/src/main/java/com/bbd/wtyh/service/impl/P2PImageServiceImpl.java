package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.dao.P2PImageDao;
import com.bbd.wtyh.domain.wangDaiAPI.SearchCompany;
import com.bbd.wtyh.service.P2PImageService;
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
@Service("p2PImageService")
public class P2PImageServiceImpl implements P2PImageService {
    @Autowired
    private P2PImageDao p2PImageDao;

    @Override
    public Map<String, Object> platFormStatus() {
        return p2PImageDao.platFormStatus();
    }

    @Override
    public Map<String, Object> platFormConsensus() {
        return p2PImageDao.platFormConsensus();
    }

    @Override
    public Map<String, Object> lawsuitMsg() {
        return p2PImageDao.lawsuitMsg();
    }

    @Override
    public Map<String, Object> radarScore(String dataType, String plat_name) {
        return p2PImageDao.radarScore(dataType, plat_name);
    }

    @Override
    public Map<String, Object> baseInfo(String companyName, String akId , String platName) {
        return p2PImageDao.baseInfo(companyName, akId , platName);
    }

    @Override
    public Map<String, Object> coreDataInfo(String platName) {
        Map<String, Object> data = p2PImageDao.coreDataInfo(platName);
        return data;
    }

    @Override
    public List<List<String>> coreDataDealTrend(String platName) {
        // 处理数据转换
        Map<String, String> data = p2PImageDao.coreDataDealTrend(platName);
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
        Map<String, String> data = p2PImageDao.coreDataInterestRateTrend();
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
    public List<List<String>> coreDataLoadOverage() {
        // 处理数据转换
        Map<String, String> data = p2PImageDao.coreDataLoanOverage();
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

    @Override
    public SearchCompany hasOrNotCompany(String plat_name) {
        return p2PImageDao.hasOrNotCompany(plat_name);
    }
}
