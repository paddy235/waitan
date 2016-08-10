package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.dao.HologramQueryDao;
import com.bbd.wtyh.service.HologramQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Map<String, Object> outlineMsg() {
        return hologramQueryDao.outlineMsg();
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
