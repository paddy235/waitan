package com.bbd.wtyh.service;

import java.util.List;

import com.bbd.wtyh.domain.CommercialFactoringStatisticDO;
import com.bbd.wtyh.domain.CompanyAndRiskDO;

/**
* 商业保理相关接口
* @author Ian.Su
* @since 2016年8月10日 下午3:31:21
*/
public interface FactoringService {
	
	public List<CommercialFactoringStatisticDO> companyCountByYear();
	
	public List<CompanyAndRiskDO> queryFactoringCompanys();
	
}
