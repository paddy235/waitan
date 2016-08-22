package com.bbd.bgo.mapper;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.RelationDataDO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyAreaVO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyVO;
import com.bbd.wtyh.domain.vo.RelationDataIndexVO;

import java.util.List;
import java.util.Map;

public interface RelationDataMapper {

    public void save(RelationDataDO relationDataDO);
}