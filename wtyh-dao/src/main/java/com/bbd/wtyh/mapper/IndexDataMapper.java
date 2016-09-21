package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.IndexDataDO;
import com.bbd.wtyh.domain.RecruitDataDO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IndexDataMapper {

    IndexDataDO selectByPrimaryKey(@Param("companyName") String companyName,  @Param("area") String area);
    
    public void save(IndexDataDO indexDataDO);

    public Date getNewestUpdateDate();

    public void update(IndexDataDO indexDataDO);

    List<IndexDataDO> findByPage(Map<String, Object> params);
}