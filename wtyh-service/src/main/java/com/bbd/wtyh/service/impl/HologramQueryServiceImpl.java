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
    public Map<String, Object> newsConsensus() {
        return hologramQueryDao.newsConsensus();
    }
}
