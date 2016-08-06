package com.bbd.wtyh.service;

import java.util.List;
import java.util.Map;

/**
 * P2P平台状态业务层接口
 *
 * @author wangchenge
 * @since 2016.8.5
 */
public interface P2PMonitorService {
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
    Map<String, Object> radarScore();
    
    Map<String, String> baseInfo();

    Map<String, String> coreDataInfo();

    List<List<String>> coreDataDealTrend();
}
