package com.bbd.wtyh.dao;

import com.bbd.wtyh.domain.wangDaiAPI.PlatData;
import com.bbd.wtyh.domain.wangDaiAPI.SearchCompany;

import java.util.Map;

/**
 * p2p检测平台dao层接口
 *
 * @author wangchenge
 * @since 2016.08.05
 */
public interface P2PImageDao {
    Map<String, Object> platFormConsensus();

    Map<String, Object> lawsuitMsg(String company);

    Map<String, Object> radarScore(String plat_name);

    Map<String, Object> baseInfo(String companyName, String akId, String platName);

    Map<String, Object> coreDataInfo(String platName);

    PlatData getPlatData(String platName);

//    Map<String,String> coreDataInterestRateTrend();
//
//    Map<String,String> coreDataLoanOverage();

    SearchCompany hasOrNotCompany(String plat_name);
}
