package com.bbd.wtyh.dao;


import com.bbd.wtyh.domain.bbdAPI.BaiDuYuQingDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.CourtAnnouncementDO;
import com.bbd.wtyh.domain.bbdAPI.JudgeDocDO;

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

    BaseDataDO businessInfo(String companyName);

    Map<String, Object> shareholdersSenior();

    CourtAnnouncementDO openCourtAnnouncement(String company);

    Map<String, Object> recruitMsg();

    JudgeDocDO judgeDoc(String company);
}
