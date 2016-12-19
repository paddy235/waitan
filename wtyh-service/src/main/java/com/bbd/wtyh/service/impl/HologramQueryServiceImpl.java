package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;
import com.bbd.wtyh.dao.HologramQueryDao;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.bbdAPI.*;
import com.bbd.wtyh.domain.bbdAPI.BaiDuYuQingDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.CourtAnnouncementDO;
import com.bbd.wtyh.domain.bbdAPI.IndustryCodeDO;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.PlatformNameInformationMapper;
import com.bbd.wtyh.service.DataomApiBbdservice;
import com.bbd.wtyh.service.HologramQueryService;
import com.bbd.wtyh.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.util.*;

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

    @Autowired
    private DataomApiBbdservice dabservice;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private PlatformNameInformationMapper platformNameInformationMapper;


    @Override
    public SearchComanyDO search(String company, int page_no, int page_size) {
        return hologramQueryDao.search(company, page_no - 1, page_size); // page_no减1是因为数据平台首页从0开始
    }

    @Override
    public Map<String, Object> guidance(String company) {
        Map<String, Object> data = new HashMap<>();
        BaseDataDO baseDataDO = hologramQueryDao.businessInfo(company);
        for (BaseDataDO.Results result : baseDataDO.getResults()) {
            data.put("企业名称", result.getJbxx().getCompany_name());
            data.put("登记状态", result.getJbxx().getEnterprise_status());
        }
        return data;
    }

    @Override
    public Map<String, Object> outlineMsg(String company) {
        BaseDataDO baseDataDO = hologramQueryDao.outlineMsg(company);
        Map<String, Object> data = new HashMap<>();
        for (BaseDataDO.Results result : baseDataDO.getResults()) {
            data.put("公司名称", result.getJbxx().getCompany_name());
            data.put("法定代表人", result.getJbxx().getFrname());
            data.put("注册资本", result.getJbxx().getRegcap());
            data.put("注册地址", result.getJbxx().getAddress());
        }
        BBDLogoDO bbdLogoDO = hologramQueryDao.bbdLogo(company);
        for (BBDLogoDO.Result result : bbdLogoDO.getResults()) {
            data.put("公司logo", result.getCompany_logo());
        }
        return data;
    }

    @Override
    public Map<String, Object> newsConsensus(String company) {
        BaiDuYuQingDO baiDuYuQingDO = hologramQueryDao.newsConsensus(company);

        if (StringUtils.hasText(baiDuYuQingDO.getTotal()) || "0".equals(baiDuYuQingDO.getTotal().trim())) {
            String data = dabservice.bbdQyxgYuqing("上海");
            baiDuYuQingDO = JSON.parseObject(data, BaiDuYuQingDO.class);
        }

        Map<String, Object> data = new HashMap<>();
        for (BaiDuYuQingDO.Results result : baiDuYuQingDO.getResults()) {
            data.put("title", result.getNews_title());
            data.put("content", result.getMain());
            data.put("newsSite", result.getNews_site());
            data.put("pubDate", result.getPubdate());
        }
        return data;
    }

    @Override
    public BaiDuYuQingDO newsConsensusList(String company) {
        BaiDuYuQingDO baiDuYuQingDO = hologramQueryDao.newsConsensus(company);
        return baiDuYuQingDO;
    }

    @Override
    public CompanyDO tag(String company) {
        CompanyDO companyDO = companyMapper.queryCompanyByName(company);
        if (companyDO != null) {
            companyDO.setPlatName(platformNameInformationMapper.getPlatName(company) == null ? "" : platformNameInformationMapper.getPlatName(company));
        }
        return companyDO;
    }


    @Override
    public Map<String, Object> businessInfo(String companyName) {
        BaseDataDO baseDataDO = hologramQueryDao.businessInfo(companyName);
        Map<String, Object> data = new HashMap<>();
        ZuZhiJiGoudmDO zuZhiJiGoudmDO = hologramQueryDao.baseInfoZuZhiJiGou(companyName);
        for (ZuZhiJiGoudmDO.Result result : zuZhiJiGoudmDO.getResults()) {
            data.put("组织机构代码", result.getJgdm());
        }
        for (BaseDataDO.Results result : baseDataDO.getResults()) {
            data.put("法定代表人", result.getJbxx().getFrname());
            data.put("注册资本", result.getJbxx().getRegcap());
            data.put("状态", result.getJbxx().getEnterprise_status());
            data.put("注册时间", result.getJbxx().getEsdate());
            data.put("工商注册号", result.getJbxx().getRegno());
            data.put("企业类型", result.getJbxx().getCompany_type());
            data.put("营业期限", result.getJbxx().getOperating_period());
            data.put("登记机关", result.getJbxx().getRegorg());
            data.put("核准日期", result.getJbxx().getApproval_date());
            data.put("统一信用代码", result.getJbxx().getCredit_code());
            data.put("经营范围", result.getJbxx().getOperate_scope());
            for (IndustryCodeDO in : IndustryCodeDO.values()) {
                if (String.valueOf(in).equals(String.valueOf(result.getJbxx().getCompany_industry()))) {
                    data.put("行业", in.getValue());
                }
            }
        }
        return data;
    }

    @Override
    public Map<String, List> shareholdersSenior(String companyName) {
        BaseDataDO baseDataDo = hologramQueryDao.shareholdersSenior(companyName);
        Map<String, List> content = new HashMap<>();
        for (BaseDataDO.Results result : baseDataDo.getResults()) {
            List<Map> list1 = new ArrayList<>();
            for (BaseDataDO.Gdxx gdxx : result.getGdxx()) {
                Map<String, Object> data = new LinkedHashMap<>();
                data.put("shareholder_name", gdxx.getShareholder_name());
                data.put("shareholder_type", gdxx.getShareholder_type());
                list1.add(data);
            }
            content.put("gdxx", list1);
            List<Map> list2 = new ArrayList<>();
            for (BaseDataDO.Baxx baxx : result.getBaxx()) {
                Map<String, Object> data = new LinkedHashMap<>();
                data.put("name", baxx.getName());
                data.put("position", baxx.getPosition());
                list2.add(data);
            }
            content.put("baxx", list2);
        }
        return content;
    }

    @Override
    public List<OpenCourtAnnouncementDO.Results> openCourtAnnouncement(String company) {
        OpenCourtAnnouncementDO courtAnnouncementDO = hologramQueryDao.openCourtAnnouncement(company);
        return courtAnnouncementDO.getResults();
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

    @Override
    public RecruitPeopleNumberDO recruitPeopleNumber(String company, String timeTag) {
        if (StringUtils.isEmpty(timeTag)) {
            timeTag = DateUtils.formatDate(new Date());
        }
        RecruitDataDO recruitDataDO = hologramQueryDao.getRecruitData(company, timeTag);
        RecruitPeopleNumberDO recruitPeopleNumberDO = new RecruitPeopleNumberDO();
        recruitPeopleNumberDO.setMsg("ok");
        List list = new ArrayList();
        if (!CollectionUtils.isEmpty(recruitDataDO.getResults().get(0).getIndex())) {
            Map<String, String> indexMap = recruitDataDO.getResults().get(0).getIndex();
            for (String key : indexMap.keySet()) {
                RecruitPeopleNumberDO.Rdata rdata = new RecruitPeopleNumberDO.Rdata();
                rdata.setX_value(key);
                rdata.setY_value(indexMap.get(key));
                list.add(rdata);
            }
        }
        recruitPeopleNumberDO.setTotal(String.valueOf(list.size()));
        recruitPeopleNumberDO.setRdata(list);
        return recruitPeopleNumberDO;
    }

    @Override
    public RecruitPeopleDistributeDO recruitPeopleDistribute(String company, String timeTag) {
        if (StringUtils.isEmpty(timeTag)) {
            timeTag = DateUtils.formatDate(new Date());
        }
        RecruitDataDO recruitDataDO = hologramQueryDao.getRecruitData(company, timeTag);
        RecruitPeopleDistributeDO recruitPeopleDistributeDO = new RecruitPeopleDistributeDO();
        recruitPeopleDistributeDO.setMsg("ok");
        List list = new ArrayList();
        if (!CollectionUtils.isEmpty(recruitDataDO.getResults().get(0).getIndustry_ratio())) {
            Map<String, String> indexMap = recruitDataDO.getResults().get(0).getIndustry_ratio();
            for (String key : indexMap.keySet()) {
                RecruitPeopleDistributeDO.Rdata rdata = new RecruitPeopleDistributeDO.Rdata();
                rdata.setName(key);
                rdata.setValue(indexMap.get(key));
                list.add(rdata);
            }
        }
        recruitPeopleDistributeDO.setTotal(String.valueOf(list.size()));
        recruitPeopleDistributeDO.setRdata(list);
        return recruitPeopleDistributeDO;
    }

    @Override
    public RecruitPeopleSalaryDO recruitPeopleSalary(String company, String timeTag) {
        if (StringUtils.isEmpty(timeTag)) {
            timeTag = DateUtils.formatDate(new Date());
        }
        RecruitDataDO recruitDataDO = hologramQueryDao.getRecruitData(company, timeTag);
        RecruitPeopleSalaryDO recruitPeopleSalaryDO = new RecruitPeopleSalaryDO();
        recruitPeopleSalaryDO.setMsg("ok");
        List list = new ArrayList();
        if (!CollectionUtils.isEmpty(recruitDataDO.getResults().get(0).getSalary_ratio())) {
            Map<String, String> indexMap = recruitDataDO.getResults().get(0).getSalary_ratio();
            for (String key : indexMap.keySet()) {
                RecruitPeopleSalaryDO.Rdata rdata = new RecruitPeopleSalaryDO.Rdata();
                rdata.setX_value(getSalaryData(key));
                rdata.setY_value(indexMap.get(key));
                list.add(rdata);
            }
        }
        recruitPeopleSalaryDO.setTotal(String.valueOf(list.size()));
        recruitPeopleSalaryDO.setRdata(list);
        return recruitPeopleSalaryDO;
    }

    private String getSalaryData(String key) {
        String salary = "";
        if ("LevelOne".equals(key)) {
            salary = "小于2K";
        } else if ("LevelTwo".equals(key)) {
            salary = "2K-5K";
        } else if ("LevelThree".equals(key)) {
            salary = "5K-10K";
        } else if ("LevelFour".equals(key)) {
            salary = "10K-20K";
        } else if ("LevelFive".equals(key)) {
            salary = "20K-30K";
        } else if ("LevelSix".equals(key)) {
            salary = "30K以上";
        } else if ("Others".equals(key)) {
            salary = "其他";
        }
        return salary;
    }


}
