package com.bbd.wtyh.dao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.dao.P2PImageDao;
import com.bbd.wtyh.domain.bbdAPI.BBDLogoDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.ZuZhiJiGoudmDO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatDataDO;
import com.bbd.wtyh.domain.wangDaiAPI.SearchCompanyDO;
import com.bbd.wtyh.domain.wangDaiAPI.YuQingDO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * p2p检测平台dao层实现类
 *
 * @author wangchenge
 * @since 2016.08.05
 */
@Repository("p2PImageDao")
public class P2PImageDaoImpl implements P2PImageDao {

    @Value("${api.finnacial.url}")
    private String url;

    @Value("${api.bbd_qyxx.url}")
    private String bbdQyxxURL;

    @Value("${api.bbd_qyxx.ak}")
    private String bbdQyxxAK;

    @Value("${api.bbdZuzhiJiGoudm.url}")
    private String zuZhiJiGouURL;

    @Value("${api.bbdZuzhiJiGoudm.ak}")
    private String zuZhiJiGouAK;



    @Override
    public YuQingDO platformConsensus(String platName) {
        String yuqingURL = url + "?dataType=yuqing" + "&plat_name=" + platName;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(yuqingURL, new HttpCallback<YuQingDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public YuQingDO parse(String result) {
                    return JSON.parseObject(result, YuQingDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, Object> lawsuitMsg(String company) {
        String URL = String.format("http://dataom.api.bbdservice.com/api/bbd_ktgg/?company=%s&ak=ee372b938ef17a245f6b781beec4499e", company);
        HttpTemplate httpTemplate = new HttpTemplate();
        final Map<String, Object> data = new HashMap<>();
        try {
            httpTemplate.get(URL, new HttpCallback<Object>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public Object parse(String s) {
                    JSONObject jsonObject = JSON.parseObject(s);
                    data.put("total", jsonObject.get("total"));
                    return data;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Map<String, Object> radarScore(String platName) {
        String url = String.format("http://localhost:8080/financial_services.do?dataType=leida&plat_name=%s", platName);
        HttpTemplate httpTemplate = new HttpTemplate();
        final Map<String, Object> source = new LinkedHashMap<>();
        try {
            httpTemplate.get(url, new HttpCallback<Object>() {
                @Override
                public boolean valid() {
                    return false;
                }

                @Override
                public Object parse(String result) {
                    JSONObject object = JSON.parseObject(result);
                    source.put("运营能力", object.get("operation"));
                    source.put("违约成本", object.get("penalty_cost"));
                    source.put("分散度", object.get("dispersion"));
                    source.put("资本充足", object.get("capital"));
                    source.put("流动性", object.get("fluidity"));
                    source.put("信息披露", object.get("info_disclosure"));
                    return source;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        //数据格式化
        Map<String, Object> result = new LinkedHashMap<>();
        List<LinkedHashMap<String, Object>> indicator = new ArrayList<>();
        Set<Map.Entry<String, Object>> entries = source.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            LinkedHashMap<String, Object> score = new LinkedHashMap<>();
            score.put("name", entry.getKey());
            score.put("max", entry.getValue());
            indicator.add(score);
        }
        List<List<Object>> series = new ArrayList<>();
        List<Object> serie = new ArrayList<>();
        serie.add(source.get("违约成本"));
        serie.add(source.get("信息披露"));
        serie.add(source.get("资本充足"));
        serie.add(source.get("运营能力"));
        serie.add(source.get("流动性"));
        serie.add(source.get("分散度"));
        series.add(serie);
        result.put("indicator", indicator);
        result.put("series", series);
        result.put("code", "1");
        return result;
    }

    /**
     * 基本信息--网贷接口数据
     * 暂时数据乱码，可后期网贷提供后处理
     */
    public Map<String, Object> baseInfoWangDaiApi(String platName){
        String platFormName = "http://localhost:8080/financial_services.do?dataType=plat_list&plat_name="+platName;
        final Map<String, Object> data = new HashMap<>();
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            httpTemplate.get(platFormName, new HttpCallback<Object>() {
                @Override
                public boolean valid() {
                    return true;
                }
                @Override
                public Object parse(String result) {
                    JSONObject jsonObject = JSON.parseObject(result);
                    data.put("平台名称", jsonObject.get("plat_name"));
                    data.put("公司名称", jsonObject.get("company_name"));
                    return data;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 基本信息--BBD数据平台接口
     *
     */
    @Override
    public BaseDataDO baseInfoBBDData(String companyName) {
        String baseURL = bbdQyxxURL + "?company=" + companyName + "&ak=" + bbdQyxxAK;
        final Map<String, Object> map = new LinkedHashMap<>();
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(baseURL, new HttpCallback<BaseDataDO>() {
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
     *
     */
    public ZuZhiJiGoudmDO baseInfoZuZhiJiGou(String companyName) {
//        String url = zuZhiJiGouURL+"?company="+companyName+"&ak="+zuZhiJiGouURL;
        String URL = "http://dataom.api.bbdservice.com/api/bbd_zuzhijigoudm/?company=%E6%94%80%E6%9E%9D%E8%8A%B1%E5%B8%82%E4%BA%A4%E9%80%9A%E6%97%85%E6%B8%B8%E5%AE%A2%E8%BF%90%E6%9C%89%E9%99%90%E8%B4%A3%E4%BB%BB%E5%85%AC%E5%8F%B8&ak=605f60df40668579e939515fef710d2b";
        final Map<String, Object> map = new LinkedHashMap<>();
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
     * 企业logo信息
     *
     */
    public BBDLogoDO bbdLogo(String company) {
        String coreDataDealURL = "http://dataom.api.bbdservice.com/api/bbd_ent_logo/?company="+company+"&ak=c541b0bdda84c4b8953682d43c9ef840";
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

    @Override
    public Map<String, Object> coreDataInfo(String platName) {
        String url = String.format("http://localhost:8080/financial_services.do?dataType=plat_data&plat_name=%s", platName);
        final Map<String, Object> data = new HashMap<>();
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            httpTemplate.get(url, new HttpCallback<Object>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public Object parse(String result) {
                    JSONObject jsonObject = JSON.parseObject(result);
                    data.put("累计成交量", jsonObject.get("amount_total"));
                    data.put("借款余额", jsonObject.get("money_stock"));
                    data.put("平均利率", jsonObject.get("interest_rate"));
                    data.put("近30日资金净流入", jsonObject.get("30_day_net_inflow"));
                    data.put("待收投资人数", jsonObject.get("bid_num_stay_stil"));
                    data.put("待还借款人数", jsonObject.get("bor_num_stay_stil"));
                    data.put("最大单户借款额", jsonObject.get("top1_sum_amount"));
                    data.put("最大十户借款额", jsonObject.get("top10_sum_amount"));
                    return data;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public PlatDataDO getPlatData(String platName) {
        String platDataURL = url + "?dataType=plat_data" + "&plat_name=" + platName;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(platDataURL, new HttpCallback<PlatDataDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public PlatDataDO parse(String result) {
                    return JSON.parseObject(result, PlatDataDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public SearchCompanyDO hasOrNotCompany(String plat_name) {
        return null;

    }

    public SearchCompanyDO hasOrNotCompanyBackup(String plat_name) {

        String api = url + "?dataType=plat_list" + "&plat_name=" + plat_name;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(api, new HttpCallback<SearchCompanyDO>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public SearchCompanyDO parse(String result) {
                    return JSON.parseObject(result, SearchCompanyDO.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
