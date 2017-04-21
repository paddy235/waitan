package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.bbdAPI.*;

import java.util.List;
import java.util.Map;

/**
 * 企业全息信息查询平台业务层接口
 *
 * @author wangchenge
 * @since 2016.08.09
 */
public interface HologramQueryService {
    /**
     * 信息查询平台搜索
     *
     * @return
     */
    SearchComanyDO search(String company, int page_no, int page_size);

    /**
     * 信息查询平台导航栏
     *
     * @return
     */
    Map<String, Object> guidance(String company);

    /**
     * 企业概要信息
     *
     * @return
     */
    Map<String, Object> outlineMsg(String companyName);

    /**
     * 新闻舆情
     *
     * @return
     * @param company
     */
    Map<String, Object> newsConsensus(String company);

    /**
     * 企业信息详情-工商信息
     *
     * @return
     */
    Map<String, Object> businessInfo(String companyName);

    /**
     * 企业信息详情-股东高管
     *
     * @return
     */
    Map<String, List> shareholdersSenior(String companyName);

    /**
     * 企业信息详情-诉讼记录
     *
     * @return
     * @param company
     */
    List<OpenCourtAnnouncementDO.Results> openCourtAnnouncement(String company);

    /**
     * 企业信息详情-诉讼记录 - 裁判文书
     * @param company
     * @return
     */
    List<JudgeDocDO.Results> judgeDoc(String company);

    /**
     * 企业信息详情-诉讼记录 - 被执行人
     * @param company
     * @return
     */
    DebtorDO debtor(String company);

    /**
     * 企业信息详情-诉讼记录 - 失信被执行人
     * @param company
     * @return
     */
    NoCreditDebtorDO noCreditDebtor(String company);

    /**
     * 企业信息详情-诉讼记录 - 失信被执行人
     *
     * @param company
     * @return
     */
    CourtAnnouncementDO courtAnnouncement(String company);


    /**
     * 企业信息详情-诉讼记录 - 招聘人数指数
     *
     * @return
     * @param company
     */
    RecruitPeopleNumberDO recruitPeopleNumber(String company, String timeTag);

    RecruitPeopleDistributeDO recruitPeopleDistribute(String company, String timeTag);

    RecruitPeopleSalaryDO recruitPeopleSalary(String company, String timeTag);

    BaiDuYuQingDO newsConsensusList(String company);

    CompanyDO tag(String company);
    /**
     * 企业信息详情-专利信息
     *
     * @return
     * @param company
     * @param page
     * @param pageSize
     */
    PatentDO getPatentData(String company, Integer page, Integer pageSize);

    Map<String, Object> getBbdQyxxBatch(String companySerial);
}
