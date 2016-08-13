package com.bbd.wtyh.dao;


import com.bbd.wtyh.domain.bbdAPI1.BaiDuYuQingDO;
import com.bbd.wtyh.domain.bbdAPI1.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI1.CourtAnnouncementDO;

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

    BaseDataDO outlineMsg(String platName);

    BaiDuYuQingDO newsConsensus(String company);

    Map<String, Object> businessInfo();

    Map<String, Object> shareholdersSenior();

    CourtAnnouncementDO openCourtAnnouncement(String company);

    Map<String, Object> recruitMsg();
}
