package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.IndexDataDO;
import com.bbd.wtyh.domain.RecruitDataDO;

import java.util.Date;

public interface IndexDataMapper {

    public void save(IndexDataDO indexDataDO);

    public Date getNewestUpdateDate();
}