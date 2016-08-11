package com.bbd.wtyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.domain.CommercialFactoringStatisticDO;
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

}
