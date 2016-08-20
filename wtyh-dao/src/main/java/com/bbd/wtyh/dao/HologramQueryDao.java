package com.bbd.wtyh.dao;


import com.bbd.wtyh.domain.bbdAPI.*;

/**
 * 企业全息信息查询平台dao层
 *
 * @author wangchenge
 * @since 2016.08.09
 */
public interface HologramQueryDao {
    SearchComanyDO search(String company, int page_no, int page_size);

    BaseDataDO outlineMsg(String platName);

    BBDLogoDO bbdLogo(String company);

    BaiDuYuQingDO newsConsensus(String company);

    BaseDataDO businessInfo(String companyName);

    ZuZhiJiGoudmDO baseInfoZuZhiJiGou(String companyName);

    BaseDataDO shareholdersSenior(String companyName);

    OpenCourtAnnouncementDO openCourtAnnouncement(String company);

    JudgeDocDO judgeDoc(String company);

    DebtorDO debtor(String company);

    NoCreditDebtorDO noCreditDebtor(String company);

    CourtAnnouncementDO courtAnnouncement(String company);

    RecruitPeopleNumberDO recruitPeopleNumber(String company);

    RecruitPeopleDistributeDO recruitPeopleDistribute(String company);

    RecruitPeopleSalaryDO recruitPeopleSalary(String company);
}
