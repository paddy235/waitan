package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.domain.PrepaidCompanyDO;
import com.bbd.wtyh.domain.PrepaidCompanyStatisticDO;

public interface PrepaidCompanyStatisticMapper {
	
    PrepaidCompanyStatisticDO selectByPrimaryKey(Integer year);

	List<PrepaidCompanyStatisticDO> prepaidAll();

	List<PrepaidCompanyDO> prepaidCompanyAll();
}