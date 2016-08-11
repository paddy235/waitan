package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.domain.CommercialFactoringStatisticDO;

/**
* 
* @author Ian.Su
* @since 2016年8月10日 下午3:34:26
*/
public interface FactoringMapper {
	public List<CommercialFactoringStatisticDO> companyCountByYear();
}
