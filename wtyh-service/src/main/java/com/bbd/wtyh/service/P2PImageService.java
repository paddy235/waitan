package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.wangDaiAPI.SearchCompanyDO;
import com.bbd.wtyh.domain.wangDaiAPI.YuQingDO;

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
    Map<String, Object> platFormStatus(String platName);

    /**
     * 舆情信息
     *
     * @return
     * @param platName
     */
    YuQingDO platformConsensus(String platName);

    /**
     * 诉讼信息
     *
     * @return
     */
    Map<String, Object> lawsuitMsg(String companys);

    /**
     * 雷达评分
     *
     * @return
     */
    Map<String, Object> radarScore(String plat_name);
    
    Map<String, Object> baseInfo(String platName);

    Map<String, Object> coreDataInfo(String platName);

    List<List<String>> coreDataDealTrend(String platNmae);

    List<List<String>> coreDataInterestRateTrend(String plat_name);

    List<List<String>> coreDataLoadOverage(String plat_name);

    SearchCompanyDO hasOrNotCompany(String plat_name);
}
