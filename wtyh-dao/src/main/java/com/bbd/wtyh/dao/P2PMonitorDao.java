package com.bbd.wtyh.dao;

import java.util.Map;

/**
 * p2p检测平台dao层接口
 *
 * @author wangchenge
 * @since 2016.08.05
 */
public interface P2PMonitorDao {
    Map<String, Object> platFormStatus();

    Map<String, Object> platFormConsensus();

    Map<String, Object> lawsuitMsg();

    Map<String, Object> radarScore();

    Map<String, String> baseInfo();
}
