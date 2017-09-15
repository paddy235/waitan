package com.bbd.wtyh.dao;


import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.RecruitDO;
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

    /**
     * 数据平台companySearch2接口
     * @param query 待搜索的关键字
     * @param parameters 辅助参数 详见：http://docs.bbdops.com:8102/api/bbd_companysearch2/
     * @return CompanySearch2DO
     */
    public CompanySearch2DO companySearch2(String query, Map<String, String>parameters);

    BaseDataDO outlineMsg(String platName,String bbdQyxxId);

    BBDLogoDO bbdLogo(String company,String bbdQyxxId);

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

    OpenCourtAnnouncementDO openCourtAnnouncement(String company, Integer page, Integer pageSize);

    JudgeDocDO judgeDoc(String company, Integer page, Integer pageSize);

    DebtorDO debtor(String company, Integer page, Integer pageSize);

    NoCreditDebtorDO noCreditDebtor(String company, Integer page, Integer pageSize);

    CourtAnnouncementDO courtAnnouncement(String company, Integer page, Integer pageSize);

    RecruitPeopleNumberDO recruitPeopleNumber(String company);

    RecruitPeopleDistributeDO recruitPeopleDistribute(String company);

    RecruitPeopleSalaryDO recruitPeopleSalary(String company);

    RecruitDataDO getRecruitData(String company, String timeTag);

    PatentDO getPatentData(String company, Integer page, Integer pageSize);

    public RecruitDO getRecruitInfo(String company, Integer page, Integer pageSize);

    Map<String, Object> getBbdQyxxBatch(String companySerial);

    public BaseDataDO getBbdQyxxBatchByPostCD(String companySerial);

}
