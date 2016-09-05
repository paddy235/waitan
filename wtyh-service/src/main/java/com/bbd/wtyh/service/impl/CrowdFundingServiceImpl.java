package com.bbd.wtyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.domain.CrowdFundingCompanyDO;
import com.bbd.wtyh.domain.CrowdFundingStatisticsDO;
import com.bbd.wtyh.domain.NvDO;
import com.bbd.wtyh.mapper.CrowdFundingBusinessStatisticsMapper;
import com.bbd.wtyh.mapper.CrowdFundingCompanyMapper;
import com.bbd.wtyh.mapper.CrowdFundingStatisticsMapper;
import com.bbd.wtyh.service.CrowdFundingService;

/**
* 
* @author Ian.Su
* @since 2016年8月11日 下午4:13:50
*/
@Service
public class CrowdFundingServiceImpl implements CrowdFundingService {

	
	@Autowired
	private CrowdFundingBusinessStatisticsMapper cfbsMapper;
	
	@Autowired
	private CrowdFundingStatisticsMapper cfsMapper;
	
	@Autowired
	private CrowdFundingCompanyMapper cfcMapper;
	

	@Override
	public List<NvDO> lastMonthData() {
		return cfbsMapper.lastMonthData();
	}

	@Override
	public List<CrowdFundingStatisticsDO> lastMonthType() {
		return cfsMapper.lastMonthType();
	}

	

	@Override
	public List<CrowdFundingCompanyDO> allCompanys() {
		return cfcMapper.allCompanys();
	}

	@Override
	public List<String> queryCompany(String keyword){
		return cfcMapper.queryCompany(keyword);
	}

}
