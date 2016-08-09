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
     * 新闻舆情
     *
     * @return
     */
    Map<String, Object> newsConsensus();
}
