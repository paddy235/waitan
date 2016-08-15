package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.dao.HologramQueryDao;
import com.bbd.wtyh.domain.bbdAPI.*;
import com.bbd.wtyh.domain.bbdAPI.BaiDuYuQingDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.CourtAnnouncementDO;
import com.bbd.wtyh.domain.bbdAPI.IndustryCodeDO;
import com.bbd.wtyh.service.HologramQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Map<String, Object> businessInfo(String companyName) {
        BaseDataDO baseDataDO = hologramQueryDao.businessInfo(companyName);
        Map<String, Object> data = new HashMap<>();
        for (BaseDataDO.Results result : baseDataDO.getResults()) {
            data.put("法定代表人",result.getJbxx().getFrname());
            data.put("注册资本",result.getJbxx().getRegcap());
            data.put("状态",result.getJbxx().getEnterprise_status());
            data.put("注册时间",result.getJbxx().getEsdate());
            data.put("工商注册号",result.getJbxx().getRegno());
            data.put("企业类型",result.getJbxx().getCompany_type());
            data.put("组织机构代码","fskfjdksfjklsdjfk123");//// TODO: 2016/8/13 0013 查找字典表
            data.put("营业期限",result.getJbxx().getOperating_period());
            data.put("登记机关",result.getJbxx().getRegorg());
            data.put("核准日期",result.getJbxx().getApproval_date());
            data.put("统一信用代码",result.getJbxx().getCredit_code());
            data.put("经营范围",result.getJbxx().getOperate_scope());
            for (IndustryCodeDO in : IndustryCodeDO.values()) {
                if (String.valueOf(in).equals(String.valueOf(result.getJbxx().getCompany_industry()))) {
                    data.put("行业",in.getValue());
                }
            }
        }
        return data;
    }

    @Override
    public Map<String, Map<String, Object>> shareholdersSenior(String companyName) {
        BaseDataDO baseDataDo = hologramQueryDao.shareholdersSenior(companyName);
        Map<String, Map<String, Object>> list = new HashMap<>();
        Map<String, Object> data1 = new HashMap<>();
        Map<String, Object> data2 = new HashMap<>();
        for (BaseDataDO.Results result : baseDataDo.getResults()) {
            for (BaseDataDO.Gdxx gdxx : result.getGdxx()) {
                data1.put("shareholder_name",gdxx.getShareholder_name());
                data1.put("shareholder_type",gdxx.getShareholder_type());
                list.put("gdxx", data1);
            }
            for (BaseDataDO.Baxx baxx : result.getBaxx()) {
                data2.put("company_name",baxx.getCompany_name());
                data2.put("name",baxx.getName());
                data2.put("position",baxx.getPosition());
                data2.put("type",baxx.getType());
                list.put("bgxx", data2);
            }
        }
        return list;
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

    @Override
    public DebtorDO debtor(String company) {
        return hologramQueryDao.debtor(company);
    }

    @Override
    public NoCreditDebtorDO noCreditDebtor(String company) {
        return hologramQueryDao.noCreditDebtor(company);
    }

    @Override
    public CourtAnnouncementDO courtAnnouncement(String company) {
        return hologramQueryDao.courtAnnouncement(company);
    }


}
