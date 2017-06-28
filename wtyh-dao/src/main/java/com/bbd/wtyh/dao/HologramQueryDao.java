package com.bbd.wtyh.dao;


import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.bbdAPI.*;

import java.util.List;
import java.util.Map;

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

    /**
     * 数据平台企业信息接口
     * @param companyName 企业名称
     * @return BaseDataDO
     */
    public BaseDataDO companyQyxxDataApi(String companyName);

    OpenCourtAnnouncementDO openCourtAnnouncement(String company);

    JudgeDocDO judgeDoc(String company);

    DebtorDO debtor(String company);

    NoCreditDebtorDO noCreditDebtor(String company);

    CourtAnnouncementDO courtAnnouncement(String company);

    RecruitPeopleNumberDO recruitPeopleNumber(String company);

    RecruitPeopleDistributeDO recruitPeopleDistribute(String company);

    RecruitPeopleSalaryDO recruitPeopleSalary(String company);

    RecruitDataDO getRecruitData(String company, String timeTag);

    PatentDO getPatentData(String company, Integer page, Integer pageSize);

    Map<String, Object> getBbdQyxxBatch(String companySerial);

    public BaseDataDO getBbdQyxxBatchByPostCD(String companySerial);

}
