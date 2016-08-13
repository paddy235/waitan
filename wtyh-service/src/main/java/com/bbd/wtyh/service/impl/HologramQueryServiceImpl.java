package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.dao.HologramQueryDao;
import com.bbd.wtyh.domain.bbdAPI.BaseData;
import com.bbd.wtyh.service.HologramQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 企业全息信息查询平台业务层实现类
 *
 * @author wangchenge
 * @since 2016.08.09
 */
@Service("hologramQueryService")
public class HologramQueryServiceImpl implements HologramQueryService {
    @Autowired
    private HologramQueryDao hologramQueryDao;


    @Override
    public Map<String, Object> search() {
        return hologramQueryDao.search();
    }

    @Override
    public Map<String, Object> guidance() {
        return hologramQueryDao.guidance();
    }

    @Override
    public Map<String, Object> outlineMsg(String companyName) {
        BaseData baseData = hologramQueryDao.outlineMsg(companyName);
        System.out.println("");
//        System.out.println(baseData.getRsize());
//        System.out.println(baseData.getTotal());
//        System.out.println(baseData.getMsg());
//        Map<String, Object> data = new HashMap<>();
//        for (BaseData.Jbxx result : baseData.getResults()) {
//            System.out.println("123:"+result.getCompany_name());
//            data.put("企业名称",result.getCompany_name());
//            data.put("法定代表人",result.getFrname());
//            data.put("注册资本",result.getRegcap());
//            data.put("注册地址",result.getAddress());
//        }
        return null;
    }

    @Override
    public Map<String, Object> newsConsensus() {
        return hologramQueryDao.newsConsensus();
    }

    @Override
    public Map<String, Object> businessInfo() {
        return hologramQueryDao.businessInfo();
    }

    @Override
    public Map<String, Object> shareholdersSenior() {
        return hologramQueryDao.shareholdersSenior();
    }

    @Override
    public Map<String, Object> lawsuitRecord() {
        return hologramQueryDao.lawsuitRecord();
    }

    @Override
    public Map<String, Object> recruitMsg() {
        return hologramQueryDao.recruitMsg();
    }


}
