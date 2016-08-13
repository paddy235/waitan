package com.bbd.wtyh.dao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.dao.P2PImageDao;
import com.bbd.wtyh.domain.wangDaiAPI.PlatDataDO;
import com.bbd.wtyh.domain.wangDaiAPI.SearchCompanyDO;
import com.bbd.wtyh.domain.wangDaiAPI.YuQingDO;
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
                    System.out.println(data);
                    return data;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Map<String, Object> radarScore(String dataType, String plat_name) {
        String url = "http://localhost:8080/financial_services?dataType=leida&plat_name=1121";
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
//                    source.put("平台名",object.get("plat_name"));
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
        result.put("score", 100);
        result.put("code", "1");
        return result;
    }

    @Override
    public Map<String, Object> baseInfo(String companyName, String akId, String platName) {
        String platFormName = String.format("http://localhost:8080/financial_services?dataType=%s&plat_name=1121", platName);//网贷之家
        String cn = String.format("http://dataom.api.bbdservice.com/api/bbd_qyxx/?company=%s&ak=%s", companyName, akId);//数据平台
        final Map<String, Object> map = new LinkedHashMap<>();
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            httpTemplate.get(platFormName, new HttpCallback<Object>() {
                @Override
                public boolean valid() {
                    return false;
                }

                @Override
                public Object parse(String result) {
                    System.out.println(result);
                    String str = result.substring(1, result.length() - 1);
                    //乱码问题没有解决
                    JSONObject object = JSON.parseObject(str);
                    map.put("平台名称", object.get("plat_name"));
                    map.put("公司名称", object.get("company_name"));
                    return map;
                }
            });
            httpTemplate.get(cn, new HttpCallback<Object>() {
                @Override
                public boolean valid() {
                    return false;
                }

                @Override
                public Object parse(String result) {
                    JSONObject object = JSON.parseObject(result);
                    String results = String.valueOf(object.get("results"));
                    JSONObject data = JSON.parseObject(results.substring(1, results.length() - 1));
                    JSONObject jbxx = JSON.parseObject(String.valueOf(data.get("jbxx")));
                    map.put("法人代表", jbxx.get("frname"));
//                    map.put("公司名称", jbxx.get("company_name"));
                    map.put("注册资本", jbxx.get("regcap"));
                    map.put("注册地址", jbxx.get("address"));
                    map.put("开业日期", jbxx.get("esdate"));
                    map.put("核准日期", jbxx.get("approval_date"));
                    map.put("登记机关", jbxx.get("regorg"));
                    return map;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map<String, Object> coreDataInfo(String platName) {
        String url = String.format("http://localhost:8080/financial_services?dataType=plat_data&plat_name=%s", platName);
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
