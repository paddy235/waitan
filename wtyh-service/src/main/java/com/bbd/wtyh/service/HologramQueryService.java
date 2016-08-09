package com.bbd.wtyh.service;

import java.util.Map;

/**
 * 企业全息信息查询平台业务层接口
 *
 * @author wangchenge
 * @since 2016.08.09
 */
public interface HologramQueryService {
    /**
     * 信息查询平台搜索
     *
     * @return
     */
    Map<String, Object> search();

    /**
     * 信息查询平台导航栏
     *
     * @return
     */
    Map<String, Object> guidance();

    /**
     * 新闻舆情
     *
     * @return
     */
    Map<String, Object> newsConsensus();
}
