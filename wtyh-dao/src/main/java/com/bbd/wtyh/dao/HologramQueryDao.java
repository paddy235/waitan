package com.bbd.wtyh.dao;

import java.util.Map;

/**
 * 企业全息信息查询平台dao层
 *
 * @author wangchenge
 * @since 2016.08.09
 */
public interface HologramQueryDao {
    Map<String, Object> search();

    Map<String, Object> guidance();

    Map<String, Object> outlineMsg();

    Map<String, Object> newsConsensus();

    Map<String, Object> businessInfo();

    Map<String, Object> shareholdersSenior();

    Map<String, Object> lawsuitRecord();

    Map<String, Object> recruitMsg();
}
