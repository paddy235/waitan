package com.bbd.wtyh.dao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.dao.P2PImageDao;
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
    public Map<String, Object> radarScore() {
        //数据来源
        Map<String, Object> data = new HashMap<>();
        data.put("违约成本", 88);
        data.put("信息披露", 88);
        data.put("资本充足", 88);
        data.put("运营能力", 88);
        data.put("流动性", 88);
        data.put("分散度", 88);
        //数据格式化
        Map<String, Object> result = new LinkedHashMap<>();
        List<LinkedHashMap<String, Object>> indicator = new ArrayList<>();
        Set<Map.Entry<String, Object>> entries = data.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            LinkedHashMap<String, Object> score = new LinkedHashMap<>();
            score.put("name", entry.getKey());
            score.put("max", entry.getValue());
            indicator.add(score);
        }
        List<List<Integer>> series = new ArrayList<>();
        List<Integer> serie = new ArrayList<>();
        serie.add(5000);
        serie.add(14000);
        serie.add(28000);
        serie.add(31000);
        serie.add(42000);
        serie.add(21000);
        series.add(serie);
        result.put("indicator", indicator);
        result.put("series", series);
        result.put("score", 100);
        result.put("code", "1");
        return result;
    }

    @Override
    public Map<String, Object> baseInfo(String companyName, String akId) {
        String url = String.format("http://dataom.api.bbdservice.com/api/bbd_qyxx/?company=%s&ak=%s", companyName, akId);
        final Map<String, Object> map = new LinkedHashMap<>();
        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            httpTemplate.get(url, new HttpCallback<Object>() {
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
                    map.put("公司名称", jbxx.get("company_name"));
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
    public Map<String, String> coreDataInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("calulateDealNumber", "31.21");     // 累计成交量
        info.put("loanOverage", "18");     // 贷款余额
        info.put("averageInterestRate", "6.532");     // 平均利率
        info.put("recent30DaysIncome", "952638");     // 近30日资产流入
        info.put("waitingInvesterNumber", "21564");     // 待收投资人数
        info.put("waitingRepaymenterNumber", "21564");     // 待还借款人数
        info.put("maxSingleLoanNumber", "1213.65");     // 最大单户借款额
        info.put("top10LoanNumber", "7984.36");     // 最大十户借款额

        return info;
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

}
