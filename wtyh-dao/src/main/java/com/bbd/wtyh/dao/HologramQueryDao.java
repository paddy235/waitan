package com.bbd.wtyh.dao;

import com.bbd.wtyh.domain.bbdAPI.BaiDuYuQingDo;
import com.bbd.wtyh.domain.bbdAPI.BaseData;

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

    BaseData outlineMsg(String platName);

    BaiDuYuQingDo newsConsensus(String company);

    Map<String, Object> businessInfo();

    Map<String, Object> shareholdersSenior();

    Map<String, Object> lawsuitRecord();

    Map<String, Object> recruitMsg();
}
