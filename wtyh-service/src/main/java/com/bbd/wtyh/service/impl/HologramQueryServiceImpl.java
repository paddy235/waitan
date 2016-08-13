package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.dao.HologramQueryDao;
import com.bbd.wtyh.domain.bbdAPI.BaiDuYuQingDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.CourtAnnouncementDO;
import com.bbd.wtyh.domain.bbdAPI.JudgeDocDO;
import com.bbd.wtyh.service.HologramQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企业全息信息查询平台业务层实现类
 *
 * @author wangchenge
 * @since 2016.08.09
 */
@Service("hologramQueryService")
public class HologramQueryServiceImpl implements HologramQueryService {
    @Autowired
    private HologramQueryDao hologramQueryDao;


    @Override
    public Map<String, Object> search() {
        return hologramQueryDao.search();
    }

    @Override
    public Map<String, Object> guidance() {
        return hologramQueryDao.guidance();
    }

    @Override
    public Map<String, Object> outlineMsg(String companyName) {
        BaseDataDO baseDataDO = hologramQueryDao.outlineMsg(companyName);
        Map<String, Object> data = new HashMap<>();
        for (BaseDataDO.Results result : baseDataDO.getResults()) {
            data.put("公司名称",result.getJbxx().getCompany_name());
            data.put("法定代表人",result.getJbxx().getFrname());
            data.put("注册资本",result.getJbxx().getRegcap());
            data.put("注册地址",result.getJbxx().getAddress());
        }
        return data;
    }

    @Override
    public BaiDuYuQingDO newsConsensus(String company) {
        return hologramQueryDao.newsConsensus(company);
    }

    @Override
    public Map<String, Object> businessInfo() {
        return hologramQueryDao.businessInfo();
    }

    @Override
    public Map<String, Object> shareholdersSenior() {
        return hologramQueryDao.shareholdersSenior();
    }

    @Override
    public List<CourtAnnouncementDO.Results> openCourtAnnouncement(String company) {
        CourtAnnouncementDO courtAnnouncementDO = hologramQueryDao.openCourtAnnouncement(company);
        return courtAnnouncementDO.getResults();
    }

    @Override
    public Map<String, Object> recruitMsg() {
        return hologramQueryDao.recruitMsg();
    }

    @Override
    public List<JudgeDocDO.Results> judgeDoc(String company) {
        JudgeDocDO courtAnnouncementDO = hologramQueryDao.judgeDoc(company);
        return courtAnnouncementDO.getResults();
    }


}
