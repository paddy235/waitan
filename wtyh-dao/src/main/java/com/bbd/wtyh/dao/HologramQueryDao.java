package com.bbd.wtyh.dao;


import com.bbd.wtyh.domain.bbdAPI.*;

import java.util.Map;

/**
 * 企业全息信息查询平台dao层
 *
 * @author wangchenge
 * @since 2016.08.09
 */
public interface HologramQueryDao {
    SearchComanyDO search(String company);

    Map<String, Object> guidance();

    BaseDataDO outlineMsg(String platName);

    BBDLogoDO bbdLogo(String company);

    BaiDuYuQingDO newsConsensus(String company);

    BaseDataDO businessInfo(String companyName);

    BaseDataDO shareholdersSenior(String companyName);

    CourtAnnouncementDO openCourtAnnouncement(String company);

    Map<String, Object> recruitMsg();

    JudgeDocDO judgeDoc(String company);

    DebtorDO debtor(String company);

    NoCreditDebtorDO noCreditDebtor(String company);

    CourtAnnouncementDO courtAnnouncement(String company);
}
