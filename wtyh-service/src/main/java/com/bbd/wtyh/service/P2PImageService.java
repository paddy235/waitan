package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.wangDaiAPI.SearchCompany1;

import java.util.List;
import java.util.Map;

/**
 * P2P平台状态业务层接口
 *
 * @author wangchenge
 * @since 2016.8.5
 */
public interface P2PImageService {
    /**
     * P2P检测平台状态信息
     *
     * @return
     */
    Map<String, Object> platFormStatus();

    /**
     * 舆情信息
     *
     * @return
     */
    Map<String, Object> platFormConsensus();

    /**
     * 诉讼信息
     *
     * @return
     */
    Map<String, Object> lawsuitMsg();

    /**
     * 雷达评分
     *
     * @return
     */
    Map<String, Object> radarScore(String dataType, String plat_name);
    
    Map<String, Object> baseInfo(String companyName, String akId , String platName);

    Map<String, String> coreDataInfo(String dataType);

    List<List<String>> coreDataDealTrend();

    List<List<String>> coreDataInterestRateTrend();

    List<List<String>> coreDataLoanOverage();

    SearchCompany1 hasOrNotCompany(String plat_name);
}
