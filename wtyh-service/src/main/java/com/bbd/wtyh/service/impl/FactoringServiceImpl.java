package com.bbd.wtyh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.domain.CommercialFactoringStatisticDO;
import com.bbd.wtyh.domain.CompanyAndRiskDO;
import com.bbd.wtyh.domain.CompanyCountDO;
import com.bbd.wtyh.mapper.FactoringMapper;
import com.bbd.wtyh.service.FactoringService;

/**
* 
* @author Ian.Su
* @since 2016年8月10日 下午3:33:46
*/
@Service
public class FactoringServiceImpl implements FactoringService {

	@Autowired
	private FactoringMapper facMapper;

	@Override
	public List<CommercialFactoringStatisticDO> companyCountByYear() {
		
		return facMapper.companyCountByYear();
	}


	@Override
	public List<CompanyAndRiskDO> queryFactoringCompanys() {
		return facMapper.queryFactoringCompanys();
	}



	@Override
	public List<Map<String,Object>> distribute() {
		return facMapper.distribute();
	}



	@Override
	public List<Map<String, Object>> geogDistribute() {
		return facMapper.geogDistribute();
	}


	
	@Override
	public List<CompanyCountDO> countCapitalBySeason() {
		return facMapper.countCapitalBySeason();
	}

}
