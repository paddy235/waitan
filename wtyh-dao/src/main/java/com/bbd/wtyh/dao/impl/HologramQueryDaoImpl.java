package com.bbd.wtyh.dao.impl;

import com.alibaba.fastjson.JSON;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.dao.HologramQueryDao;
import com.bbd.wtyh.domain.bbdAPI.*;
import com.bbd.wtyh.redis.RedisDAO;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 企业全息信息查询平台dao层实现类
 *
 * @author wangchenge
 * @since 2016.08.09
 */
@Repository("hologramQueryDao")
public class HologramQueryDaoImpl implements HologramQueryDao {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${api.court.searchCompany.url}")
    private String searchCompanyURL;     // 搜索

    @Value("${api.court.searchCompany.ak}")
    private String searchCompanyAK;

    @Value("${api.baidu.batch.news.url}")
    private String baiduYuQingURL;     // 百度舆情

    @Value("${api.baidu.batch.news.ak}")
    private String baiduYuqingAK;

    @Value("${api.court.openCourtAnnouncement.url}")
    private String openCourtAnnouncementURL;    // 开庭公告

    @Value("${api.court.openCourtAnnouncement.ak}")
    private String openCourtAnnouncementAK;

    @Value("${api.court.debtor.url}")
    private String debtorURL;    // 被执行人

    @Value("${api.court.debtor.ak}")
    private String debtorAK;

    @Value("${api.court.judgeDoc.url}")
    private String judgeDocURL;    // 裁判文书

    @Value("${api.court.judgeDoc.ak}")
    private String judgeDocAK;

    @Value("${api.court.courtAnnouncement.url}")
    private String courtAnnouncementURL;    //  法院公告

    @Value("${api.court.courtAnnouncement.ak}")
    private String courtAnnouncementAK;

    @Value("${api.court.noCreditDebtor.url}")
    private String noCreditDebtorURL;    // 失信被执行人

    @Value("${api.court.noCreditDebtor.ak}")
    private String noCreditDebtorAK;

    @Value("${api.bbd_qyxx.url}")
    private String bbdQyxxURL;      // 企业信息

    @Value("${api.bbd_qyxx.ak}")
    private String bbdQyxxAK;

    @Value("${api.recruitPeopleNumber.url}")
    private String recruitPeopleNumberURL;      // 招聘人数指数

    @Value("${api.recruitPeopleNumber.ak}")
    private String recruitPeopleNumberAK;

    @Value("${api.recruitPeopleDistribute.url}")
    private String recruitPeopleDistributeURL;      // 招聘人员分布

    @Value("${api.recruitPeopleDistribute.ak}")
    private String recruitPeopleDistributeAK;

    @Value("${api.recruitPeopleSalary.url}")
    private String recruitPeopleSalaryURL;      // 薪酬分布

    @Value("${api.recruitPeopleSalary.ak}")
    private String recruitPeopleSalaryAK;

    @Value("${api.bbdlogo.url}")
    private String bbdLogoURL;

    @Value("${api.bbdlog.ak}")
    private String bbdLogoAK;

    @Value("${api.dataom.yuqing.url}")
    private String apiDataomYuqingUrl;


    @Value("${api.dataom.news.url}")
    private String apiDataomNewsUrl;


    @Autowired
    private RedisDAO redisDAO;





    public String getCompanyNews() {

        String data = null;

        try {
            HttpTemplate ht = new HttpTemplate();
            data = ht.get(apiDataomYuqingUrl, new HttpCallback<String>(){

                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public String parse(String s) {
                    return s;
                }
            });

        } catch (Exception e) {
            logger.error("Method getCompanyNews get Exception." + e.getMessage());
            e.printStackTrace();
        }

        return data;
    }


    /**
     * 信息查询平台搜索
     *
     * @return
     */
    @Override
    public SearchComanyDO search(String company, int page_no, int page_size) {
        String api = searchCompanyURL + "?query=" + company + "&type=company&ak=" + searchCompanyAK + "&page_no=" + page_no + "&page_size=" + page_size;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<SearchComanyDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public SearchComanyDO parse(String result) {
                    return JSON.parseObject(result, SearchComanyDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 企业概要信息
     *
     * @return
     */
    @Override
    public BaseDataDO outlineMsg(String companyName) {
        String coreDataDealURL = bbdQyxxURL + "?company=" + companyName + "&ak=" + bbdQyxxAK;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(coreDataDealURL, new HttpCallback<BaseDataDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public BaseDataDO parse(String result) {
                    Gson gson = new Gson();
                    return gson.fromJson(result, BaseDataDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 企业logo信息
     */
    public BBDLogoDO bbdLogo(String company) {
        String coreDataDealURL = bbdLogoURL + "?company=" + company + "&ak=" + bbdLogoAK;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(coreDataDealURL, new HttpCallback<BBDLogoDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public BBDLogoDO parse(String result) {
                    Gson gson = new Gson();
                    return gson.fromJson(result, BBDLogoDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 公司新闻舆情
     *
     * @return
     */
    @Override
    public BaiDuYuQingDO newsConsensus(String company) {
        String api = apiDataomNewsUrl+company;
        HttpTemplate httpTemplate = new HttpTemplate();
        BaiDuYuQingDO bdyqDO = null;
        try {
            bdyqDO = httpTemplate.get(api, new HttpCallback<BaiDuYuQingDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public BaiDuYuQingDO parse(String result) {
                    return JSON.parseObject(result, BaiDuYuQingDO.class);
                }


            });
         } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        if(bdyqDO==null || "0".equals(bdyqDO.getTotal() )){
            String data = getCompanyNews();
            return JSON.parseObject(data, BaiDuYuQingDO.class);
        }


        return bdyqDO;


    }

    /**
     * 企业信息详情-工商信息
     *
     * @return
     */
    @Override
    public BaseDataDO businessInfo(String companyName) {
        String coreDataDealURL = bbdQyxxURL + "?company=" + companyName + "&ak=" + bbdQyxxAK;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(coreDataDealURL, new HttpCallback<BaseDataDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public BaseDataDO parse(String result) {
                    Gson gson = new Gson();
                    return gson.fromJson(result, BaseDataDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 基本信息--组织机构代码api
     */
    public ZuZhiJiGoudmDO baseInfoZuZhiJiGou(String companyName) {
//        String url = zuZhiJiGouURL+"?company="+companyName+"&ak="+zuZhiJiGouURL;
        String URL = "http://dataom.api.bbdservice.com/api/bbd_zuzhijigoudm/?company="+companyName+"&ak=605f60df40668579e939515fef710d2b";
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(URL, new HttpCallback<ZuZhiJiGoudmDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public ZuZhiJiGoudmDO parse(String result) {
                    Gson gson = new Gson();
                    return gson.fromJson(result, ZuZhiJiGoudmDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 企业信息详情-股东高管
     *
     * @return
     */
    @Override
    public BaseDataDO shareholdersSenior(String companyName) {
        String coreDataDealURL = bbdQyxxURL + "?company=" + companyName + "&ak=" + bbdQyxxAK;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(coreDataDealURL, new HttpCallback<BaseDataDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public BaseDataDO parse(String result) {
                    Gson gson = new Gson();
                    return gson.fromJson(result, BaseDataDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 企业信息详情-诉讼记录
     *
     * @param company
     * @return
     */
    @Override
    public OpenCourtAnnouncementDO openCourtAnnouncement(String company) {
        String api = openCourtAnnouncementURL + "?company=" + company + "&ak=" + openCourtAnnouncementAK;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<OpenCourtAnnouncementDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public OpenCourtAnnouncementDO parse(String result) {
                    return JSON.parseObject(result, OpenCourtAnnouncementDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 企业信息详情-招聘信息
     *
     * @return
     */
    public Map<String, Object> recruitMsg() {
        Map<String, Object> data = new HashMap<>();
        data.put("招聘信息", "招聘嘻嘻");
        return data;
    }

    @Override
    public JudgeDocDO judgeDoc(String company) {
        String api = judgeDocURL + "?company=" + company + "&ak=" + judgeDocAK;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<JudgeDocDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public JudgeDocDO parse(String result) {
                    return JSON.parseObject(result, JudgeDocDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public DebtorDO debtor(String company) {
        String api = debtorURL + "?company=" + company + "&ak=" + debtorAK;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<DebtorDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public DebtorDO parse(String result) {
                    return JSON.parseObject(result, DebtorDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public NoCreditDebtorDO noCreditDebtor(String company) {
        String api = noCreditDebtorURL + "?company=" + company + "&ak=" + noCreditDebtorAK;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<NoCreditDebtorDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public NoCreditDebtorDO parse(String result) {
                    return JSON.parseObject(result, NoCreditDebtorDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CourtAnnouncementDO courtAnnouncement(String company) {
        String api = courtAnnouncementURL + "?company=" + company + "&ak=" + courtAnnouncementAK;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<CourtAnnouncementDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public CourtAnnouncementDO parse(String result) {
                    return JSON.parseObject(result, CourtAnnouncementDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public RecruitPeopleNumberDO recruitPeopleNumber(String company) {
        String api = recruitPeopleNumberURL + "&company=" + company + "&access_token=" + recruitPeopleNumberAK;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<RecruitPeopleNumberDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public RecruitPeopleNumberDO parse(String result) {
                    return JSON.parseObject(result, RecruitPeopleNumberDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public RecruitPeopleDistributeDO recruitPeopleDistribute(String company) {
        String api = recruitPeopleDistributeURL + "&company=" + company + "&access_token=" + recruitPeopleDistributeAK;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<RecruitPeopleDistributeDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public RecruitPeopleDistributeDO parse(String result) {
                    return JSON.parseObject(result, RecruitPeopleDistributeDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public RecruitPeopleSalaryDO recruitPeopleSalary(String company) {
        String api = recruitPeopleSalaryURL + "&company=" + company + "&access_token=" + recruitPeopleSalaryAK;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<RecruitPeopleSalaryDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public RecruitPeopleSalaryDO parse(String result) {
                    return JSON.parseObject(result, RecruitPeopleSalaryDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
