package com.bbd.wtyh.dao.impl;

import com.bbd.wtyh.dao.P2PMonitorDao;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * p2p检测平台dao层实现类
 *
 * @author wangchenge
 * @since 2016.08.05
 */
@Repository("p2PMonitorDao")
public class P2PMonitorDaoImpl implements P2PMonitorDao {

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
        Map<String, Object> data = new HashMap<>();
        data.put("platFormConsensus", "pfConsensus");
        return data;
    }

    @Override
    public Map<String, Object> lawsuitMsg() {
        Map<String, Object> data = new HashMap<>();
        data.put("lawsuit", 5);
        return data;
    }

    @Override
    public Map<String, Object> radarScore() {
        //数据来源
        Map<String ,Object> data = new HashMap<>();
        data.put("违约成本", 88);
        data.put("信息披露", 88);
        data.put("资本充足", 88);
        data.put("运营能力", 88);
        data.put("流动性", 88);
        data.put("分散度", 88);
        //数据格式化
        Map<String , Object> result = new LinkedHashMap<>();
        List<LinkedHashMap<String, Object>> indicator = new ArrayList<>();
        Set<Map.Entry<String, Object>> entries = data.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            LinkedHashMap<String, Object> score = new LinkedHashMap<>();
            score.put("name" , entry.getKey());
            score.put("max" , entry.getValue());
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
        result.put("indicator" , indicator);
        result.put("series" , series);
        result.put("score" , 100);
        result.put("code" , "1");
        return result;
    }

    @Override
    public Map<String, String> baseInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("p2pName", "陆金所");     // 平台名称
        info.put("companyName", "上海陆家嘴国际金融资产交易市场股份有限公司");   // 公司名称
        info.put("legalPeople", "郑森");  // 法人代表
        info.put("capital", "83667");   // 注册资本
        info.put("address", "上海浦东新区陆家嘴环路1333号");    // 注册地址
        info.put("openedTime", "2011-11-9");    // 开业时间
        info.put("verifiedTime", "2011-11-9");  // 核准时间
        info.put("registerOffice", "上海市工商局");   // 等级机关
        info.put("companyCode", "79361521");    // 组织结构代码

        return info;
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

}
