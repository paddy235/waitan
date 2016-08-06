package com.bbd.wtyh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bbd.wtyh.domain.CompanyNewsDO;

public interface CompanyNewsMapper {
    CompanyNewsDO selectByPrimaryKey(Integer newsId);
    
    List<CompanyNewsDO> queryParkNews(@Param(value="areaId") Integer areaId,
							    		@Param(value="start") Integer start,
							    		@Param(value="pageSize") Integer pageSize);
}