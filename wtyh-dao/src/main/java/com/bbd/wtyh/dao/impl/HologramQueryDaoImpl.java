package com.bbd.wtyh.dao.impl;

import com.alibaba.fastjson.JSON;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.dao.HologramQueryDao;
import com.bbd.wtyh.domain.bbdAPI.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 企业全息信息查询平台dao层实现类
 *
 * @author wangchenge
 * @since 2016.08.09
 */
@Repository("hologramQueryDao")
public class HologramQueryDaoImpl implements HologramQueryDao {

    @Value("${api.baidu.news.url}")
    private String baiduYuQingURL;     // 百度舆情

    @Value("${api.baidu.news.ak}")
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

    @Value("${api.court.courtAnnouncement.url}")
    private String noCreditDebtorURL;    // 失信被执行人

    @Value("${api.court.noCreditDebtor.ak}")
    private String noCreditDebtorAK;

    @Value("${api.bbd_qyxx.url}")
    private String bbdQyxxURL;      // 企业信息

    @Value("${api.bbd_qyxx.ak}")
    private String bbdQyxxAK;

    /**
     * 信息查询平台搜索
     *
     * @return
     */
    @Override
    public Map<String, Object> search() {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("含注册号", "876156451231xxx");
        data.put("类型", "有限责任公司");
        data.put("法定代表人", "黄光裕");
        data.put("注册资本", "4万元");
        data.put("成立日期", "2016年08月09日");
        data.put("注册地址", "上海市浦东新区···");
        data.put("企业总数", "101");
        data.put("页数", "101");
        data.put("每页几条", "10");
        return data;
    }

    /**
     * 信息查询平台导航栏
     *
     * @return
     */
    @Override
    public Map<String, Object> guidance() {
        Map<String, Object> data = new HashMap<>();
        data.put("企业名称", "上海明城投资有限公司");
        data.put("登记状态", "存续");
        return data;
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
     * 公司新闻舆情
     *
     * @return
     */
    @Override
    public BaiDuYuQingDO newsConsensus(String company) {
        String api = baiduYuQingURL + "?company=" + company + "&ak=" + baiduYuqingAK;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<BaiDuYuQingDO>() {
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
    public CourtAnnouncementDO openCourtAnnouncement(String company) {
        String api = openCourtAnnouncementURL + "?company=" + company + "&ak=" + openCourtAnnouncementAK;
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
}
