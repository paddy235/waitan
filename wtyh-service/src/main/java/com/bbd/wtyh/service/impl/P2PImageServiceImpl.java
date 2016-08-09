package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.dao.P2PImageDao;
import com.bbd.wtyh.service.P2PImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
    public Map<String, Object> radarScore() {
        return p2PImageDao.radarScore();
    }

    @Override
    public Map<String, String> baseInfo() {
        return p2PImageDao.baseInfo();
    }

    @Override
    public Map<String, String> coreDataInfo() {
        Map<String, String> data = p2PImageDao.coreDataInfo();
        Map<String, String> info = new HashMap<>();
        info.put("累计成交量", data.get("calulateDealNumber"));
        info.put("贷款余额", data.get("loanOverage"));     //
        info.put("平均利率", data.get("averageInterestRate"));     //
        info.put("近30日资产流入", data.get("recent30DaysIncome"));     // 近30日资产流入
        info.put("待收投资人数", data.get("waitingInvesterNumber"));     // 待收投资人数
        info.put("待还借款人数", data.get("waitingRepaymenterNumber"));     // 待还借款人数
        info.put("最大单户借款额", data.get("maxSingleLoanNumber"));     // 最大单户借款额
        info.put("最大十户借款额", data.get("top10LoanNumber"));     // 最大十户借款额

        return info;
    }

    @Override
    public List<List<String>> coreDataDealTrend() {
        // 处理数据转换
        Map<String, String> data = p2PImageDao.coreDataDealTrend();
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
    public List<List<String>> coreDataLoanOverage() {
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
}
