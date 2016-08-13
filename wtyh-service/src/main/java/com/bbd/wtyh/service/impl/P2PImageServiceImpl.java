package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.dao.P2PImageDao;
import com.bbd.wtyh.domain.wangDaiAPI.PlatData;
import com.bbd.wtyh.domain.wangDaiAPI.SearchCompany;
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
    public Map<String, Object> platFormStatus(String platName) {
        PlatData pn = p2PImageDao.getPlatData(platName);
        Map<String, Object> result = new HashMap<>();
        result.put("评分",pn.getPlat_score());
        result.put("平台名称",pn.getPlat_name());
        result.put("营业状态",pn.getPlat_status());
        return result;
    }

    @Override
    public Map<String, Object> platFormConsensus() {
        return p2PImageDao.platFormConsensus();
    }

    @Override
    public Map<String, Object> lawsuitMsg(String company) {
        return p2PImageDao.lawsuitMsg(company);
    }

    @Override
    public Map<String, Object> radarScore(String platName) {
        PlatData platData = p2PImageDao.getPlatData(platName);
        Map<String, Object> data = p2PImageDao.radarScore(platName);
        data.put("sumScore",platData.getPlat_score());
        return data;
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
        PlatData data = p2PImageDao.getPlatData(platName);
        List<PlatData.PlatDataSixMonth> platDataSixMonth = data.getPlat_data_six_month();
        List<String> days = new ArrayList<>();
        List<String> amounts = new ArrayList<>();
        for (PlatData.PlatDataSixMonth pdsm : platDataSixMonth) {
            days.add(pdsm.getDate());
            amounts.add(String.valueOf(pdsm.getDay_amount()));
        }
        
        List<List<String>> result = new ArrayList<>();
        result.add(days);
        result.add(amounts);
        return result;
    }

    @Override
    public List<List<String>> coreDataInterestRateTrend(String plat_name) {
        // 处理数据转换
        PlatData data = p2PImageDao.getPlatData(plat_name);
        List<PlatData.PlatDataSixMonth> platDataSixMonth = data.getPlat_data_six_month();
        List<String> days = new ArrayList<>();
        List<String> interestRates = new ArrayList<>();
        for (PlatData.PlatDataSixMonth pdsm : platDataSixMonth) {
            days.add(pdsm.getDate());
            interestRates.add(String.valueOf(pdsm.getDay_interest_rate()));
        }

        List<List<String>> result = new ArrayList<>();
        result.add(days);
        result.add(interestRates);
        return result;
    }

    @Override
    public List<List<String>> coreDataLoadOverage(String plat_name) {
        // 处理数据转换
        PlatData data = p2PImageDao.getPlatData(plat_name);
        List<PlatData.PlatDataSixMonth> platDataSixMonth = data.getPlat_data_six_month();
        List<String> days = new ArrayList<>();
        List<String> loanOverages = new ArrayList<>();
        for (PlatData.PlatDataSixMonth pdsm : platDataSixMonth) {
            days.add(pdsm.getDate());
            loanOverages.add(String.valueOf(pdsm.getDay_money_stock()));
        }

        List<List<String>> result = new ArrayList<>();
        result.add(days);
        result.add(loanOverages);
        return result;
    }

    @Override
    public SearchCompany hasOrNotCompany(String plat_name) {
        return p2PImageDao.hasOrNotCompany(plat_name);
    }
}
