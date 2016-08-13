package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.bbdAPI.BaiDuYuQingDO;
import com.bbd.wtyh.domain.bbdAPI.CourtAnnouncementDO;

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
    Map<String, Object> search();

    /**
     * 信息查询平台导航栏
     *
     * @return
     */
    Map<String, Object> guidance();

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
    BaiDuYuQingDO newsConsensus(String company);

    /**
     * 企业信息详情-工商信息
     *
     * @return
     */
    Map<String, Object> businessInfo();

    /**
     * 企业信息详情-股东高管
     *
     * @return
     */
    Map<String, Object> shareholdersSenior();

    /**
     * 企业信息详情-诉讼记录
     *
     * @return
     * @param company
     */
    CourtAnnouncementDO openCourtAnnouncement(String company);

    /**
     * 企业信息详情-招聘信息
     *
     * @return
     */
    Map<String, Object> recruitMsg();
}
