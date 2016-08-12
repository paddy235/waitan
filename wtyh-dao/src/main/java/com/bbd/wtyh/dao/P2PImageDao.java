package com.bbd.wtyh.dao;

import com.bbd.wtyh.domain.wangdaiAPI.SearchCompany;

import java.util.Map;

/**
 * p2p检测平台dao层接口
 *
 * @author wangchenge
 * @since 2016.08.05
 */
public interface P2PImageDao {
    Map<String, Object> platFormStatus();

    Map<String, Object> platFormConsensus();

    Map<String, Object> lawsuitMsg();

    Map<String, Object> radarScore(String dataType, String plat_name);

    Map<String, Object> baseInfo(String companyName, String akId , String platName);

    Map<String,String> coreDataInfo(String dataType);

    Map<String,String> coreDataDealTrend();

    Map<String,String> coreDataInterestRateTrend();

    Map<String,String> coreDataLoanOverage();

    SearchCompany hasOrNotCompany(String plat_name);
}
