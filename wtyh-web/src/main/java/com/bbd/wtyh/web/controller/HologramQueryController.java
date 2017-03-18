package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.bbdAPI.*;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.HologramQueryService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 企业全息信息查询平台控制层
 *
 * @author wangchenge
 * @since 2016.08.09
 */
@Controller
@RequestMapping("/hologram")
public class HologramQueryController {

    @Autowired
    private HologramQueryService hologramQueryService;

    /**
     * 信息查询平台搜索
     *
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    @LogRecord(logMsg = "企业全息信息搜索企业，关键字：%s", params ={"company"}, page = Operation.Page.home, type = Operation.Type.query, before = true)
    public ResponseBean search(@RequestParam(required = true) String company, @RequestParam(defaultValue = "0") int page_no, @RequestParam(defaultValue = "4") int page_size) {
        SearchComanyDO result = hologramQueryService.search(company, page_no, page_size);
        return ResponseBean.successResponse(result);
    }

    /**
     * 信息查询平台导航栏
     *
     * @return
     */
    @RequestMapping("/guidance")
    @ResponseBody
    public ResponseBean guidance(String company) {
        Map<String, Object> result = hologramQueryService.guidance(company);
        return ResponseBean.successResponse(result);
    }

    /**
     * 企业概要信息
     *
     * @return
     */
    @RequestMapping("/outlineMsg")
    @ResponseBody
    public ResponseBean outlineMsg(@RequestParam(required = true) String company) {
        Map<String, Object> result = hologramQueryService.outlineMsg(company);
        return ResponseBean.successResponse(result);
    }

    /**
     * 新闻舆情
     *
     * @return
     */
    @RequestMapping("/newsConsensus")
    @ResponseBody
    public ResponseBean newsConsensus(@RequestParam(required = true) String company) {
        Object result = hologramQueryService.newsConsensusList(company);
        return ResponseBean.successResponse(result);
    }

    /**
     * 企业信息详情-工商信息
     *
     * @return
     */
    @RequestMapping("/businessInfo")
    @ResponseBody
    public ResponseBean businessInfo(@RequestParam(required = true) String company) {
        Map<String, Object> result = hologramQueryService.businessInfo(company);
        return ResponseBean.successResponse(result);
    }

    /**
     * 企业信息详情-股东高管
     *
     * @return
     */
    @RequestMapping("/shareholdersSenior")
    @ResponseBody
    public ResponseBean shareholdersSenior(@RequestParam(required = true) String company) {
        Map<String, List> result = hologramQueryService.shareholdersSenior(company);
        return ResponseBean.successResponse(result);
    }

    /**
     * 企业信息详情-诉讼记录 - 开庭公告
     *
     * @return
     */
    @RequestMapping("/openCourtAnnouncement")
    @ResponseBody
    public ResponseBean openCourtAnnouncement(@RequestParam(required = true) String company) {
        List<OpenCourtAnnouncementDO.Results> result = hologramQueryService.openCourtAnnouncement(company);
        return ResponseBean.successResponse(result);
    }

    /**
     * 企业信息详情-诉讼记录 - 裁判文书
     *
     * @return
     */
    @RequestMapping("/judgeDoc")
    @ResponseBody
    public ResponseBean judgeDoc(@RequestParam(required = true) String company) {
        List<JudgeDocDO.Results> result = hologramQueryService.judgeDoc(company);
        return ResponseBean.successResponse(result);
    }

    /**
     * 企业信息详情-诉讼记录 - 被执行人
     *
     * @return
     */
    @RequestMapping("/debtor")
    @ResponseBody
    public ResponseBean debtor(@RequestParam(required = true) String company) {
        DebtorDO result = hologramQueryService.debtor(company);
        return ResponseBean.successResponse(result);
    }

    /**
     * 企业信息详情-诉讼记录 - 失信被执行人
     *
     * @return
     */
    @RequestMapping("/noCreditDebtor")
    @ResponseBody
    public ResponseBean noCreditDebtor(@RequestParam(required = true) String company) {
        NoCreditDebtorDO result = hologramQueryService.noCreditDebtor(company);
        return ResponseBean.successResponse(result);
    }

    /**
     * 企业信息详情-诉讼记录 - 法院公告
     *
     * @return
     */
    @RequestMapping("/courtAnnouncement")
    @ResponseBody
    public ResponseBean courtAnnouncement(@RequestParam(required = true) String company) {
        CourtAnnouncementDO result = hologramQueryService.courtAnnouncement(company);
        return ResponseBean.successResponse(result);
    }


    /**
     * 企业信息详情-招聘信息 - 招聘人数指数
     *
     * @return
     */
    @RequestMapping("/recruitPeopleNumber")
    @ResponseBody
    public ResponseBean recruitPeopleNumber(@RequestParam(required = true) String company,
                                            @RequestParam(required = false) String timeTag) {
        RecruitPeopleNumberDO result = hologramQueryService.recruitPeopleNumber(company, timeTag);
        return ResponseBean.successResponse(result);
    }

    /**
     * 企业信息详情-招聘信息 - 招聘人员分布
     *
     * @return
     */
    @RequestMapping("/recruitPeopleDistribute")
    @ResponseBody
    public ResponseBean recruitPeopleDistribute(@RequestParam(required = true) String company,
                                                @RequestParam(required = false) String timeTag) {
        RecruitPeopleDistributeDO result = hologramQueryService.recruitPeopleDistribute(company, timeTag);
        return ResponseBean.successResponse(result);
    }

    /**
     * 企业信息详情-招聘信息 - 薪酬分布
     *
     * @return
     */
    @RequestMapping("/recruitPeopleSalary")
    @ResponseBody
    public ResponseBean recruitPeopleSalary(@RequestParam(required = true) String company,
                                            @RequestParam(required = false) String timeTag) {
        RecruitPeopleSalaryDO result = hologramQueryService.recruitPeopleSalary(company, timeTag);
        return ResponseBean.successResponse(result);
    }

    /**
     * 企业标签
     *
     * @return
     */
    @RequestMapping("/tag")
    @ResponseBody
    public ResponseBean tag(@RequestParam(required = true) String company) {
        CompanyDO result = hologramQueryService.tag(company);
        return ResponseBean.successResponse(result);
    }

}
