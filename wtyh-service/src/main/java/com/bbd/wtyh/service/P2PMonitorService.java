package com.bbd.wtyh.service;

import java.util.Map;

/**
 * P2P平台状态业务层接口
 *
 * @author wangchenge
 * @since 2016.8.5
 */
public interface P2PMonitorService {
    Map<String, Object> platFormStatus();

    Map<String, Object> platFormConsensus();

    Map<String, Object> lawsuitMsg();

    Map<String, Object> radarScore();
}
