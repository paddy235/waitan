package com.bbd.wtyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.domain.PrepaidCompanyDO;
import com.bbd.wtyh.domain.PrepaidCompanyStatisticDO;
import com.bbd.wtyh.mapper.PrepaidCompanyStatisticMapper;
import com.bbd.wtyh.service.PrepaidCompanyStaticService;

/**
* 
* @author Ian.Su
* @since 2016年8月12日 上午9:35:34
*/
@Service
public class PrepaidCompanyStaticServiceImpl implements PrepaidCompanyStaticService {

	@Autowired
	private PrepaidCompanyStatisticMapper pcsMapper;
	
	@Override
	public List<PrepaidCompanyStatisticDO> prepaidAll() {
		
		return pcsMapper.prepaidAll();
		
	}

	

	
	@Override
	public List<PrepaidCompanyDO> prepaidCompanyAll() {
		return pcsMapper.prepaidCompanyAll();
	}

}
