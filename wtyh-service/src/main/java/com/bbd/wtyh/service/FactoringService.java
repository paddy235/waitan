package com.bbd.wtyh.service;

import java.util.List;
import java.util.Map;
import com.bbd.wtyh.domain.CommercialFactoringStatisticDO;
import com.bbd.wtyh.domain.CompanyAndRiskDO;
import com.bbd.wtyh.domain.CompanyCountDO;

/**
* 商业保理相关接口
* @author Ian.Su
* @since 2016年8月10日 下午3:31:21
*/
public interface FactoringService {
	
	public List<CommercialFactoringStatisticDO> companyCountByYear();
	
	public List<CompanyAndRiskDO> queryFactoringCompanys();

	public List<Map<String,Object>> distribute();
	
	public List<Map<String, Object>> geogDistribute();

	public List<CompanyCountDO> countCapitalBySeason();
	
}
