package com.bbd.wtyh.dao.impl;

import com.bbd.wtyh.dao.P2PMonitorDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, Object> score = new HashMap<>();
        score.put("总评分", 88);
        score.put("违约成本", 88);
        score.put("信息披露", 88);
        score.put("资本充足", 88);
        score.put("运营能力", 88);
        score.put("流动性", 88);
        score.put("分散度", 88);
        return score;
    }

    @Override
    public Map<String, String> baseInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("p2pName", "陆金所");
        info.put("companyName", "上海陆家嘴国际金融资产交易市场股份有限公司");
        info.put("legalPeople", "郑森");
        info.put("capital", "83667");
        info.put("address", "上海浦东新区陆家嘴环路1333号");
        info.put("openedTime", "2011-11-9");
        info.put("verifiedTime", "2011-11-9");
        info.put("registerOffice", "上海市工商局");
        info.put("companyCode", "79361521");

        return info;
    }

    @Override
    public Map<String, String> coreDataInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("p2pName", "陆金所");
        info.put("companyName", "上海陆家嘴国际金融资产交易市场股份有限公司");
        info.put("legalPeople", "郑森");
        info.put("capital", "83667");
        info.put("address", "上海浦东新区陆家嘴环路1333号");
        info.put("openedTime", "2011-11-9");
        info.put("verifiedTime", "2011-11-9");
        info.put("registerOffice", "上海市工商局");
        info.put("companyCode", "79361521");

        return info;
    }

}
