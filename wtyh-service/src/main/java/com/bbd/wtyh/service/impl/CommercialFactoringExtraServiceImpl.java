package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.CommercialFactoringExtraDO;
import com.bbd.wtyh.mapper.CommercialFactoringExtraMapper;
import com.bbd.wtyh.service.CommercialFactoringExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/31 0031.
 */
@Service
public class CommercialFactoringExtraServiceImpl implements CommercialFactoringExtraService {
    @Autowired
    private CommercialFactoringExtraMapper commercialFactoringExtraMapper;

    @Override
    public CommercialFactoringExtraDO selectById(Integer companyId) {
        return commercialFactoringExtraMapper.selectById(companyId);
    }
}
