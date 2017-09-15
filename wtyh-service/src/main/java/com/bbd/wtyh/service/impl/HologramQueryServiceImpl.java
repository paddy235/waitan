package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;
import com.bbd.higgs.utils.ListUtil;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.dao.HologramQueryDao;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.bbdAPI.*;
import com.bbd.wtyh.domain.bbdAPI.BaiDuYuQingDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.CourtAnnouncementDO;
import com.bbd.wtyh.domain.bbdAPI.IndustryCodeDO;
import com.bbd.wtyh.domain.dataLoading.QyxgYuqingDO;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.PlatformNameInformationMapper;
import com.bbd.wtyh.report.util.MultiExeService;
import com.bbd.wtyh.service.DataomApiBbdservice;
import com.bbd.wtyh.service.HologramQueryService;
import com.bbd.wtyh.util.DateUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.*;

/**
 * 企业全息信息查询平台业务层实现类
 *
 * @author wangchenge
 * @since 2016.08.09
 */
@Service("hologramQueryService")
public class HologramQueryServiceImpl extends BaseServiceImpl implements HologramQueryService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HologramQueryDao hologramQueryDao;

    @Autowired
    private DataomApiBbdservice dabservice;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private PlatformNameInformationMapper platformNameInformationMapper;

    private HashMap<String, String> salaryHashMap = new LinkedHashMap<String, String>() {

        {
            put("LevelOne", "小于2K");
            put("LevelTwo", "2K-5K");
            put("LevelThree", "5K-10K");
            put("LevelFour", "10K-20K");
            put("LevelFive", "20K-30K");
            put("LevelSix", "30K以上");
            put("Others", "其他");
        }
    };

    @Override
    public SearchComanyDO search(String company, int page_no, int page_size) {
        SearchComanyDO companyDO = hologramQueryDao.search(company, page_no - 1, page_size); // page_no减1是因为数据平台首页从0开始
        if (null != companyDO && ListUtil.isNotEmpty(companyDO.getRdata())) {
            companyDO.getRdata().forEach((SearchComanyDO.Rdata rdata) -> {
                if (ListUtil.isNotEmpty(rdata.getBbdHistoryName())) {
                    for (String hisName : rdata.getBbdHistoryName()) {
                        if (null != hisName && hisName.equals(company))
                            rdata.setShowHisName(company);
                    }
                    if (StringUtils.isEmpty(rdata.getShowHisName()))
                        rdata.setShowHisName(rdata.getBbdHistoryName().get(0));
                }
            });
        }
        return companyDO;
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
        List<QyxgYuqingDO> list = this.selectAll(QyxgYuqingDO.class, "search_key = ? ORDER BY pubdate DESC", company);
        if (CollectionUtils.isEmpty(list)) {
            return hologramQueryDao.newsConsensus(company);
        }
        BaiDuYuQingDO baiDuYuQingDO = new BaiDuYuQingDO();
        baiDuYuQingDO.setMsg("ok");
        baiDuYuQingDO.setRsize(list.size());
        baiDuYuQingDO.setTotal(list.size() + "");

        List<BaiDuYuQingDO.Results> results = new ArrayList<>(list.size());
        BeanCopier beanCopier = BeanCopier.create(QyxgYuqingDO.class, BaiDuYuQingDO.Results.class, false);
        list.forEach(yuqingDO -> {
            BaiDuYuQingDO.Results result = new BaiDuYuQingDO.Results();
            beanCopier.copy(yuqingDO, result, null);
            result.setContent(yuqingDO.getArticleAbstract());
            result.setPubdate(DateFormatUtils.format(yuqingDO.getPubdate(), "yyyy-MM-dd HH:mm:ss"));
            results.add(result);
        });
        baiDuYuQingDO.setResults(results);
        return baiDuYuQingDO;
    }

    @Override
    public CompanyDO tag(String company) {
        CompanyDO companyDO = companyMapper.queryCompanyByName(company);
        if (companyDO != null) {
            companyDO.setPlatName(
                    platformNameInformationMapper.getPlatName(company) == null ? "" : platformNameInformationMapper.getPlatName(company));
        }
        return companyDO;
    }

    @Override
    public Map<String, Object> businessInfo(String companyName) {
        BaseDataDO baseDataDO = hologramQueryDao.businessInfo(companyName);
        Map<String, Object> data = new HashMap<>();
        ZuZhiJiGoudmDO zuZhiJiGoudmDO = hologramQueryDao.baseInfoZuZhiJiGou(companyName);
        if (zuZhiJiGoudmDO != null) {
            for (ZuZhiJiGoudmDO.Result result : zuZhiJiGoudmDO.getResults()) {
                data.put("组织机构代码", result.getJgdm());
            }
        }
        if (baseDataDO != null) {
            for (BaseDataDO.Results result : baseDataDO.getResults()) {
                data.put("企业名称", result.getJbxx().getCompany_name());
                data.put("法定代表人", result.getJbxx().getFrname());
                data.put("注册资本", result.getJbxx().getRegcap());
                data.put("注册地址", result.getJbxx().getAddress());
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
    public List<OpenCourtAnnouncementDO.Results> openCourtAnnouncement(String company, Integer page, Integer pageSize) {
        OpenCourtAnnouncementDO courtAnnouncementDO = hologramQueryDao.openCourtAnnouncement(company, page, pageSize);
        if (null == courtAnnouncementDO) {
            return null;
        }
        return courtAnnouncementDO.getResults();
    }

    @Override
    public OpenCourtAnnouncementDO openCourtAnnouncement1(String company, Integer page, Integer pageSize) {
        return hologramQueryDao.openCourtAnnouncement(company, page, pageSize);
    }

    @Override
    public List<JudgeDocDO.Results> judgeDoc(String company, Integer page, Integer pageSize) {
        JudgeDocDO courtAnnouncementDO = hologramQueryDao.judgeDoc(company, page, pageSize);
        return courtAnnouncementDO.getResults();
    }

    @Override
    public JudgeDocDO judgeDoc1(String company, Integer page, Integer pageSize) {
        return hologramQueryDao.judgeDoc(company, page, pageSize);
    }

    @Override
    public DebtorDO debtor(String company, Integer page, Integer pageSize) {
        return hologramQueryDao.debtor(company, page, pageSize);
    }

    @Override
    public NoCreditDebtorDO noCreditDebtor(String company, Integer page, Integer pageSize) {
        return hologramQueryDao.noCreditDebtor(company, page, pageSize);
    }

    @Override
    public CourtAnnouncementDO courtAnnouncement(String company, Integer page, Integer pageSize) {
        return hologramQueryDao.courtAnnouncement(company, page, pageSize);
    }

    @Override
    public RecruitPeopleNumberDO recruitPeopleNumber(String company, String timeTag) {
        if (StringUtils.isEmpty(timeTag)) {
            timeTag = DateUtils.formatDate(org.apache.commons.lang3.time.DateUtils.addMonths(new Date(), -1));
        }
        RecruitPeopleNumberDO recruitPeopleNumberDO = new RecruitPeopleNumberDO();
        recruitPeopleNumberDO.setMsg("ok");
        List list = new ArrayList();
        RecruitDataDO recruitDataDO = hologramQueryDao.getRecruitData(company, timeTag);
        if (recruitDataDO.getErr_code() != 0) {
            recruitPeopleNumberDO.setMsg(recruitDataDO.getMsg());
            return recruitPeopleNumberDO;
        }
        if (CollectionUtils.isEmpty(recruitDataDO.getResults().get(0).getIndex())) {
            timeTag = DateUtils.formatDate(org.apache.commons.lang3.time.DateUtils.addMonths(new Date(), -2));
            recruitDataDO = hologramQueryDao.getRecruitData(company, timeTag);
        }
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
            timeTag = DateUtils.formatDate(org.apache.commons.lang3.time.DateUtils.addMonths(new Date(), -1));
        }
        RecruitPeopleDistributeDO recruitPeopleDistributeDO = new RecruitPeopleDistributeDO();
        recruitPeopleDistributeDO.setMsg("ok");
        List list = new ArrayList();
        RecruitDataDO recruitDataDO = hologramQueryDao.getRecruitData(company, timeTag);
        if (recruitDataDO.getErr_code() != 0) {
            logger.error("bbd_kpi_recruit is failling:[{}]", recruitDataDO.getMsg());
            recruitPeopleDistributeDO.setMsg("error");
            return recruitPeopleDistributeDO;
        }
        if (CollectionUtils.isEmpty(recruitDataDO.getResults().get(0).getIndustry_ratio())) {
            timeTag = DateUtils.formatDate(org.apache.commons.lang3.time.DateUtils.addMonths(new Date(), -2));
            recruitDataDO = hologramQueryDao.getRecruitData(company, timeTag);
        }
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
            timeTag = DateUtils.formatDate(org.apache.commons.lang3.time.DateUtils.addMonths(new Date(), -1));
        }
        RecruitPeopleSalaryDO recruitPeopleSalaryDO = new RecruitPeopleSalaryDO();
        recruitPeopleSalaryDO.setMsg("ok");
        List list = new ArrayList();
        RecruitDataDO recruitDataDO = hologramQueryDao.getRecruitData(company, timeTag);
        if (recruitDataDO.getErr_code() != 0) {
            logger.error("bbd_kpi_recruit is failling:[{}]", recruitDataDO.getMsg());
            recruitPeopleSalaryDO.setMsg("error");
            return recruitPeopleSalaryDO;
        }
        if (CollectionUtils.isEmpty(recruitDataDO.getResults().get(0).getSalary_ratio())) {
            timeTag = DateUtils.formatDate(org.apache.commons.lang3.time.DateUtils.addMonths(new Date(), -2));
            recruitDataDO = hologramQueryDao.getRecruitData(company, timeTag);
        }
        if (!CollectionUtils.isEmpty(recruitDataDO.getResults().get(0).getSalary_ratio())) {
            Map<String, String> indexMap = recruitDataDO.getResults().get(0).getSalary_ratio();
            for (String key : salaryHashMap.keySet()) {
                if (indexMap.get(key) != null) {
                    RecruitPeopleSalaryDO.Rdata rdata = new RecruitPeopleSalaryDO.Rdata();
                    rdata.setX_value(salaryHashMap.get(key));
                    rdata.setY_value(indexMap.get(key));
                    list.add(rdata);
                }

            }
        }
        recruitPeopleSalaryDO.setTotal(String.valueOf(list.size()));
        recruitPeopleSalaryDO.setRdata(list);
        return recruitPeopleSalaryDO;
    }

    //    private String getSalaryData(String key) {
    //        String salary = "";
    //        if ("LevelOne".equals(key)) {
    //            salary = "小于2K";
    //        } else if ("LevelTwo".equals(key)) {
    //            salary = "2K-5K";
    //        } else if ("LevelThree".equals(key)) {
    //            salary = "5K-10K";
    //        } else if ("LevelFour".equals(key)) {
    //            salary = "10K-20K";
    //        } else if ("LevelFive".equals(key)) {
    //            salary = "20K-30K";
    //        } else if ("LevelSix".equals(key)) {
    //            salary = "30K以上";
    //        } else if ("Others".equals(key)) {
    //            salary = "其他";
    //        }
    //        return salary;
    //    }

    /**
     * 企业信息详情-专利信息
     *
     * @return
     * @param company
     * @param page
     * @param pageSize
     */
    @Override
    public PatentDO getPatentData(String company, Integer page, Integer pageSize) {
        if (null == page || page <= 0) {
            page = 1;
        }
        if (null == pageSize || pageSize <= 0) {
            pageSize = 20;
        }
        return hologramQueryDao.getPatentData(company, page, pageSize);
    }

    @Override
    public Map<String, Object> getBbdQyxxBatch(String companySerial) {
        return hologramQueryDao.getBbdQyxxBatch(companySerial);
    }

    @Override
    public List<CompanyDO> getBbdQyxxBatchAll(List<String> names) {
        List<CompanyDO> rstList = new LinkedList<>();
        List<BaseDataDO.Results> resultsList = getBbdQyxxAll(names);
        if (resultsList != null) {
            for (BaseDataDO.Results results : resultsList) {
                if (results != null) {
                    BaseDataDO.Jbxx jb = results.getJbxx();
                    if (jb != null) {
                        CompanyDO cd = new CompanyDO();
                        rstList.add(cd);
                        //下面是手工对应的字段
                        cd.setName(jb.getCompany_name());
                        cd.setBusinessType("");
                        for (IndustryCodeDO in : IndustryCodeDO.values()) {
                            if (String.valueOf(in).equals(String.valueOf(jb.getCompany_industry()))) {
                                cd.setBusinessType(in.getValue());
                                break;
                            }
                        }
                    }
                }
            }
        }
        return rstList;
    }

    @Override
    public List<BaseDataDO.Results> getBbdQyxxAll(List<String> names) {
        List<BaseDataDO.Results> rstList = new ArrayList<>();
        final int pageSz = 200;
        StringBuilder strNames = new StringBuilder();
        for (int idx = 0; idx < names.size();) {
            strNames.append(names.get(idx)).append(",");
            idx++;
            if (idx % pageSz == 0 || idx == (names.size())) {
                strNames.deleteCharAt(strNames.length() - 1);
                //                Date start = new Date();
                BaseDataDO batchData = hologramQueryDao.getBbdQyxxBatchByPostCD(strNames.toString());
                //                long dltSec = (new Date()).getTime() - start.getTime();
                strNames = new StringBuilder();
                //
                if (batchData == null || batchData.getErr_code() == null || !(batchData.getErr_code().equals("0"))) {
                    continue;
                }
                List<BaseDataDO.Results> resultsList = batchData.getResults();
                if (resultsList != null) {
                    rstList.addAll(resultsList);
                    //logger.info("getBbdQyxxBatchByPostCD--num[{}]--{}ms", resultsList.size(), dltSec );
                }
            }
        }
        return rstList;
    }

    @Override
    public List<CompanySearch2DO.Rdata> getNaturalPersonList(String nalName, String type) {
        List<CompanySearch2DO.Rdata> csList = new LinkedList<>();
        if (StringUtils.isEmpty(nalName) || StringUtils.isEmpty(type)
                || (!type.equals("mix") && !type.equals("gdxx") && !type.equals("baxx"))) {
            return csList;
        }
        Map<String, String> parameters = new HashMap<String, String>() {

            {
                put("highlight", "false");
                put("page_size", "200");
                put("type", type);
            }
        };
        for (int idx = 0; idx < 5; idx++) {
            parameters.put("page_no", "" + idx);
            //            Date start = new Date();
            CompanySearch2DO cs2 = hologramQueryDao.companySearch2(nalName, parameters);
            //            long dltSec = (new Date()).getTime() - start.getTime();
            if (null == cs2 || cs2.getErr_code() == null || !(cs2.getErr_code().equals("0"))) {
                return csList;
            }
            //logger.info("companySearch2--nalName[{}]--type[{}]--num[{}]--{}ms", nalName, type, cs2.getRdata().size(), dltSec );
            csList.addAll(cs2.getRdata());
            if (csList.size() >= Integer.decode(null == cs2.getSum() ? "0" : cs2.getSum())
                    || (null != cs2.getTotal() && cs2.getTotal().equals("0"))) {
                break;
            }
        }
        return csList;
    }

    @Override
    public List<CompanySearch2DO.Rdata> getNaturalPersonListMul(String nalName, boolean isProvince, String type, Integer maxGet) {
        List<CompanySearch2DO.Rdata> csList = new LinkedList<>();
        if (StringUtils.isEmpty(nalName) || StringUtils.isEmpty(type)
                || (!type.equals("mix") && !type.equals("gdxx") && !type.equals("baxx"))) {
            return csList;
        }
        final int pgSz = 200;
        Map<String, String> parameters = new HashMap<String, String>() {

            {
                put("highlight", "true");
                put("page_size", "" + pgSz);
                put("type", type);
                if (isProvince) {
                    put("province", "上海市");
                }
            }
        };
        if (null == maxGet || maxGet > 10000) { //每一单搜索结果数据平台最多允许取1w条记录
            maxGet = 30; // 获取30*pgSz 条数据
        } else {
            maxGet = maxGet / pgSz + 1;
        }
        parameters.put("page_no", "" + 0);
        Date start = new Date();
        CompanySearch2DO cs2 = hologramQueryDao.companySearch2(nalName, parameters);
        long dltSec = (new Date()).getTime() - start.getTime();
        if (null == cs2 || cs2.getErr_code() == null || !(cs2.getErr_code().equals("0"))) {
            if (cs2.getErr_code() != null) {
                logger.error("dataapi--searchCompany2--Err_code[{}]", cs2.getErr_code());
            }
            return csList;
        }
        csList.addAll(cs2.getRdata());
        int rtnTotal = Integer.decode(null == cs2.getSum() ? "0" : cs2.getSum());
        logger.info("companySearch2--nalName-A[{}]--type[{}]--isProvince[{}]--rtnTotal[{}]--{}ms", nalName, type, isProvince, rtnTotal,
                dltSec);
        if (rtnTotal <= pgSz) {
            return csList;
        }
        //rtnTotal -=pgSz;
        int pgTotal = rtnTotal / pgSz;
        if (rtnTotal % pgSz > 0) {
            pgTotal++;
        }
        MultiExeService mes = new MultiExeService(false);
        //ExecutorService exeSer = Executors.newWorkStealingPool(8);
        ConcurrentSkipListMap<Integer, List<CompanySearch2DO.Rdata>> cslMap = new ConcurrentSkipListMap<>();
        start = new Date();
        for (int idxA = 1; idxA < pgTotal && idxA < maxGet; idxA++) {
            /*
             * if( idxA %50 ==0 ) { mes.waiting(); //try {Thread.sleep(6000);} catch (Exception e){}; }
             */
            final int idx = idxA;
            //logger.info("companySearch2--nalName--Create--idxIn[{}]", idx );
            mes.runThreadFun/* exeSer.submit */(() -> {
                //logger.info("companySearch2--nalName--Start--idxIn1[{}]", idx);
                Map<String, String> par = new HashMap<>(parameters);
                par.put("page_no", "" + idx);
                CompanySearch2DO cs2x = hologramQueryDao.companySearch2(nalName, par);
                if (null == cs2x || cs2x.getErr_code() == null || !(cs2x.getErr_code().equals("0"))) {
                    if (cs2.getErr_code() != null) {
                        logger.error("dataapi--searchCompany2--Err_code[{}]", cs2.getErr_code());
                    }
                    //logger.info("companySearch2--nalName--End--idxIn1[{}]--cs2x ==null", idx);
                    return;
                }
                cslMap.put(idx, cs2x.getRdata());
                //logger.info("companySearch2--nalName--End--idx[{}]--num[{}]", idx, cs2x.getRdata().size());
            });
            mes.waitingNew(6);
        }
        //exeSer.shutdown();
        //try {exeSer.awaitTermination( pgTotal *30, TimeUnit.SECONDS);} catch (Exception e){ logger.error(e.getMessage()); }
        mes.waiting();
        dltSec = (new Date()).getTime() - start.getTime();
        for (List<CompanySearch2DO.Rdata> itr : cslMap.values()) {
            csList.addAll(itr);
        }
        logger.info("companySearch2--nalName--B[{}]--type[{}]--num[{}]--{}ms", nalName, type, csList.size(), dltSec);
        return csList;
    }

}
