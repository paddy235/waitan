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
    Map<String, Object> outlineMsg(String companyName,String bbdQyxxId);

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
    Map<String, Object> businessInfo(String companyName,String bbdQyxxId);

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
    List<OpenCourtAnnouncementDO.Results> openCourtAnnouncement(String company, Integer page, Integer pageSize);

    /**
     * 企业信息详情-诉讼记录
     *
     * @return
     * @param company
     */
    OpenCourtAnnouncementDO openCourtAnnouncement1(String company, Integer page, Integer pageSize);

    /**
     * 企业信息详情-诉讼记录 - 裁判文书
     * @param company
     * @return
     */
    List<JudgeDocDO.Results> judgeDoc(String company, Integer page, Integer pageSize);

    /**
     * 企业信息详情-诉讼记录 - 裁判文书
     * @param company
     * @return
     */
    JudgeDocDO judgeDoc1(String company, Integer page, Integer pageSize);

    /**
     * 企业信息详情-诉讼记录 - 被执行人
     * @param company
     * @return
     */
    DebtorDO debtor(String company, Integer page, Integer pageSize);

    /**
     * 企业信息详情-诉讼记录 - 失信被执行人
     * @param company
     * @return
     */
    NoCreditDebtorDO noCreditDebtor(String company, Integer page, Integer pageSize);

    /**
     * 企业信息详情-诉讼记录 - 法院公告
     *
     * @param company
     * @return
     */
    CourtAnnouncementDO courtAnnouncement(String company, Integer page, Integer pageSize);


    /**
     * 企业信息详情-诉讼记录 - 招聘人数指数
     *
     * @return
     * @param company
     */
    RecruitPeopleNumberDO recruitPeopleNumber(String company, String timeTag);

    RecruitPeopleDistributeDO recruitPeopleDistribute(String company, String timeTag);

    RecruitPeopleSalaryDO recruitPeopleSalary(String company, String timeTag);

    BaiDuYuQingDO newsConsensusList(String company,String bbdQyxxId);

    CompanyDO tag(String company);
    /**
     * 企业信息详情-专利信息
     *
     * @return
     * @param company
     * @param page
     * @param pageSize
     */
    PatentDO getPatentData(String company,String bbdQyxxId ,Integer page, Integer pageSize);

    Map<String, Object> getBbdQyxxBatch(String companySerial);

    /**
     * 根据名称列表返回结果，调用底层接口多次查询，拼接结果，不受最大200条限制
     * 目前手工匹配了极少量需用的字段，具体见源码
     * @param names
     * @return
     */
    List<CompanyDO> getBbdQyxxBatchAll( List<String>names );


    /**
     * 根据名称列表返回企业详情列表，调用底层接口多次查询，拼接结果，不受最大200条限制
     * @param names 企业名称列表
     * @return 返回企业详情列表
     */
    List<BaseDataDO.Results> getBbdQyxxAll( List<String>names );

    /**
     *
     * @param nalName
     * @param type gdxx:股东信息; baxx:董监高
     * @return
     */
    List<CompanySearch2DO.Rdata> getNaturalPersonList( String nalName, String type );

    /**
     *
     * @param nalName
     * @param isProvince 查询范围是否是省内
     * @param type mix:混合搜索； gdxx:股东信息; baxx:董监高
     * @return
     */
    List<CompanySearch2DO.Rdata> getNaturalPersonListMul( String nalName, boolean isProvince, String type, Integer maxGet );

}
