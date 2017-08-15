package com.bbd.wtyh.dao.impl;

import com.alibaba.fastjson.JSON;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.dao.HologramQueryDao;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.RecruitDO;
import com.bbd.wtyh.domain.bbdAPI.*;
import com.bbd.wtyh.redis.RedisDAO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Value("${api.dataapi_bbd_qyxx.url}")
    private String dataApiBbdQyxxURL;      // 企业信息-数据平台新街口

    @Value("${api.bbd_qyxx.ak}")
    private String bbdQyxxAK;

    @Value("${api.recruit.url}")
    private String recruitURL;

    @Value("${api.recruit.ak}")
    private String recruitAK;

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

    @Value("${api.bbd_patent.url}")
    private String apiBbdPatentUrl;

    @Value("${api.appkey}")
    private String apiAppkey;

    @Value("${api.bbd_recruit.url}")
    private String apiBbdRecruitUrl;

    //@Value("${api.appkey_rec}")
    //private String apiAppKeyRec;

    @Value("${api.bbd_qyxx_batch.url}")
    private String apiBbdQyxxBatchUrl;

    @Autowired
    private RedisDAO redisDAO;

    @Value("${api.bbdZuzhiJiGoudm.url}")
    private String zuZhiJiGouURL;

    @Value("${api.bbdZuzhiJiGoudm.ak}")
    private String zuZhiJiGouAK;

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
        String api = searchCompanyURL + "?query=" + company + "&type=company&appkey=" + searchCompanyAK + "&page_no=" + page_no + "&page_size=" + page_size;
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


    @Override
    public CompanySearch2DO companySearch2(String query, Map<String, String>parameters) {
        StringBuffer sbApi =new StringBuffer( searchCompanyURL + "?appkey=" + searchCompanyAK + "&query=" + query );
        if( null != parameters && parameters.size() >0 ) {
            for (Map.Entry ety :parameters.entrySet() ) {
                sbApi.append("&").append(ety.getKey()).append("=").append(ety.getValue());
            }
        }
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(sbApi.toString(), new HttpCallback<CompanySearch2DO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public CompanySearch2DO parse(String result) {
                    return JSON.parseObject(result, CompanySearch2DO.class);
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
        String coreDataDealURL = bbdQyxxURL + "?internal=true&company=" + companyName + "&appkey=" + bbdQyxxAK;
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
        String coreDataDealURL = bbdLogoURL + "?company=" + company + "&appkey=" + bbdLogoAK;
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
        long start = System.currentTimeMillis();
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
                	Gson gson = new Gson();
                    return gson.fromJson(result, BaiDuYuQingDO.class);
                }


            });
         } catch (Exception e) {
            logger.info("请求失败：地址为{}",api);
            e.printStackTrace();
            return null;
        }
        logger.info("请求响应时间{}ms，地址为{}",System.currentTimeMillis()-start,api);

        return bdyqDO;


    }

    /**
     * 企业信息详情-工商信息
     *
     * @return
     */
    @Override
    public BaseDataDO businessInfo(String companyName) {
        String coreDataDealURL = bbdQyxxURL + "?internal=true&company=" + companyName + "&appkey=" + bbdQyxxAK;
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
        String URL = zuZhiJiGouURL + "?company=" + companyName + "&appkey=" + zuZhiJiGouAK;
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
        String coreDataDealURL = bbdQyxxURL + "?internal=true&company=" + companyName + "&appkey=" + bbdQyxxAK;
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
     * 数据平台企业信息接口
     * @param companyName 企业名称
     * @return BaseDataDO
     */
    @Override
    public BaseDataDO companyQyxxDataApi(String companyName) {
        String coreDataDealURL = dataApiBbdQyxxURL + "?company=" + companyName + "&appkey=" + bbdQyxxAK;
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
        String api = openCourtAnnouncementURL + "?company=" + company + "&appkey=" + openCourtAnnouncementAK;
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
        String api = judgeDocURL + "?company=" + company + "&appkey=" + judgeDocAK;
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
        String api = debtorURL + "?company=" + company + "&appkey=" + debtorAK;
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
        String api = noCreditDebtorURL + "?company=" + company + "&appkey=" + noCreditDebtorAK;
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
        String api = courtAnnouncementURL + "?company=" + company + "&appkey=" + courtAnnouncementAK;
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
    public RecruitDataDO getRecruitData(String company, String timeTag) {
        String api = recruitURL + timeTag + "&value=" + company + "&appkey=" + recruitAK;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<RecruitDataDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public RecruitDataDO parse(String result) {
                    if (null == result || result.length() == 0) {
                        return null;
                    }
                    return new Gson().fromJson(result, new TypeToken<RecruitDataDO>() {
                    }.getType());
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

    @Override
    public PatentDO getPatentData(String company, Integer page, Integer pageSize) {
        String api = apiBbdPatentUrl + "?company=" + company + "&appkey=" + apiAppkey+"&page="+page+"&pageSize="+pageSize;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<PatentDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public PatentDO parse(String result) {
                    return JSON.parseObject(result, PatentDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public RecruitDO getRecruitInfo(String company, Integer page, Integer pageSize) {
        String api = apiBbdRecruitUrl + "?company=" + company + "&appkey=" + apiAppkey+"&page="+page+"&pageSize="+pageSize;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<RecruitDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public RecruitDO parse(String result) {
                    return JSON.parseObject(result, RecruitDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, Object> getBbdQyxxBatch(String companySerial) { //工商数据批量API接口
        return getBbdQyxxBatchByPost(companySerial);
    }

    private Map<String, Object> getBbdQyxxBatchByPost(String companySerial) {
        List<NameValuePair> list = new ArrayList<NameValuePair>(){{
            add( new BasicNameValuePair("keys", companySerial) );
            add( new BasicNameValuePair("appkey", apiAppkey) );
            add( new BasicNameValuePair("ktype", "0") );
            add( new BasicNameValuePair("pageSize", "1000") );
        }};
        String url = apiBbdQyxxBatchUrl;
        HttpTemplate httpTemplate = new HttpTemplate();
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(list,"UTF-8"));
            return httpTemplate.request(httpPost, new HttpCallback<Map<String, Object>>() {
                @Override
                public boolean valid() {
                    return true;
                }
                @Override
                public Map<String, Object> parse(String result) {
                    return JSON.parseObject(result, Map.class);
                }
            }, 20000, 20000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BaseDataDO getBbdQyxxBatchByPostCD(String companySerial) {
        List<NameValuePair> list = new ArrayList<NameValuePair>(){{
            add( new BasicNameValuePair("keys", companySerial) );
            add( new BasicNameValuePair("appkey", apiAppkey) );
            add( new BasicNameValuePair("ktype", "0") );
            add( new BasicNameValuePair("pageSize", "1000") );
        }};
        String url = apiBbdQyxxBatchUrl;
        HttpTemplate httpTemplate = new HttpTemplate();
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(list,"UTF-8"));
            return httpTemplate.request(httpPost, new HttpCallback<BaseDataDO>() {
                @Override
                public boolean valid() {
                    return true;
                }
                @Override
                public BaseDataDO parse(String result) {
                    return JSON.parseObject(result, BaseDataDO.class);
                }
            }, 20000, 20000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private Map<String, Object> getBbdQyxxBatchByGet(String companySerial) {
        String api = apiBbdQyxxBatchUrl + "?ktype=0" + "&pageSize=1000" + "&keys=" +companySerial +"&appkey=" + apiAppkey;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<Map<String, Object>>() {
                @Override
                public boolean valid() {
                    return true;
                }
                @Override
                public Map<String, Object> parse(String result) {
                    return JSON.parseObject(result, Map.class);
                }
            } );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
