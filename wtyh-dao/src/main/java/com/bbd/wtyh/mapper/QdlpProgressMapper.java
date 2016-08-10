package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.QdlpProgressDO;

import java.util.List;

public interface QdlpProgressMapper {
    QdlpProgressDO selectByPrimaryKey(Integer companyId);

    List<QdlpProgressDO> selectAll();
}