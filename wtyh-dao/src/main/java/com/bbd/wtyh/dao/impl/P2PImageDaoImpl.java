package com.bbd.wtyh.dao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.dao.P2PImageDao;
import com.bbd.wtyh.domain.wangdaiAPI.SearchCompany;
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
    public Map<String, Object> platFormStatus() {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "数联铭品");
        data.put("score", "88");
        data.put("status", "正常营业");
        return data;
    }

    @Override
    public Map<String, Object> platFormConsensus() {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("舆情名称", "翼鸟贷经营模式风险重重，拖累联想控股");
        data.put("部分内容", "凭着3.69亿元拿下“央视标王”的称号，主打三农借贷的上海同城翼鸟贷网络科技有限公司···");
        data.put("信息来源", "中国经济网");
        data.put("信息时间", "2016年7月22日");
        return data;
    }

    @Override
    public Map<String, Object> lawsuitMsg() {
        Map<String, Object> data = new HashMap<>();
        data.put("lawsuitNum", 5);
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
    public Map<String, String> coreDataInfo(String dataType) {
        String url = String.format("http://localhost:8080/financial_services?dataType=%s&plat_name=1121", dataType);
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            httpTemplate.get(url, new HttpCallback<Object>() {
                @Override
                public boolean valid() {
                    return false;
                }

                @Override
                public Object parse(String result) {
                    System.out.println(result);
                    JSONObject jsonObject = JSON.parseObject(result);
                    System.out.println(jsonObject.get("plat_name"));
                    System.out.println(jsonObject.get("plat_score"));
                    System.out.println(jsonObject.get("other_sum_amount"));
                    System.out.println(jsonObject.get("bor_num_stay_stil"));
                    System.out.println(jsonObject.get("inserest_rate"));
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Map<String, String> coreDataDealTrend() {
        Map<String, String> yearDealNumberKV = new HashMap<>();
        yearDealNumberKV.put("2015-01", "31.21");
        yearDealNumberKV.put("2015-02", "18");
        yearDealNumberKV.put("2015-03", "17");
        yearDealNumberKV.put("2015-04", "6.532");
        yearDealNumberKV.put("2015-05", "9");
        yearDealNumberKV.put("2015-06", "12");
        yearDealNumberKV.put("2015-07", "36");
        yearDealNumberKV.put("2015-08", "48");
        yearDealNumberKV.put("2015-09", "12");
        yearDealNumberKV.put("2015-10", "36");

        return yearDealNumberKV;
    }

    @Override
    public Map<String, String> coreDataInterestRateTrend() {
        Map<String, String> yearInterestRateKV = new HashMap<>();
        yearInterestRateKV.put("2015-01", "31.21");
        yearInterestRateKV.put("2015-02", "18");
        yearInterestRateKV.put("2015-03", "17");
        yearInterestRateKV.put("2015-04", "6.532");
        yearInterestRateKV.put("2015-05", "9");
        yearInterestRateKV.put("2015-06", "12");
        yearInterestRateKV.put("2015-07", "36");
        yearInterestRateKV.put("2015-08", "48");
        yearInterestRateKV.put("2015-09", "12");
        yearInterestRateKV.put("2015-10", "36");

        return yearInterestRateKV;
    }

    @Override
    public Map<String, String> coreDataLoanOverage() {
        Map<String, String> yearLoanOverageKV = new HashMap<>();
        yearLoanOverageKV.put("2015-01", "31.21");
        yearLoanOverageKV.put("2015-02", "18");
        yearLoanOverageKV.put("2015-03", "17");
        yearLoanOverageKV.put("2015-04", "6.532");
        yearLoanOverageKV.put("2015-05", "9");
        yearLoanOverageKV.put("2015-06", "12");
        yearLoanOverageKV.put("2015-07", "36");
        yearLoanOverageKV.put("2015-08", "48");
        yearLoanOverageKV.put("2015-09", "12");
        yearLoanOverageKV.put("2015-10", "36");

        return yearLoanOverageKV;
    }

    @Override
    public SearchCompany hasOrNotCompany(String plat_name) {
        String api = url + "/dataType=plat_list" + "/" + plat_name;
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(url, new HttpCallback<SearchCompany>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public SearchCompany parse(String result) {
                    return JSON.parseObject(result, SearchCompany.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
