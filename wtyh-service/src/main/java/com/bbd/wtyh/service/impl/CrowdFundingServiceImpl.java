package com.bbd.wtyh.service.impl;

import java.util.List;
import java.util.Map;

import com.bbd.wtyh.dao.CrowdFundingDao;
import com.bbd.wtyh.domain.wangDaiAPI.CrowdFundingStatisticsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.domain.CrowdFundingCompanyDO;
import com.bbd.wtyh.domain.CrowdFundingStatisticsDO;
import com.bbd.wtyh.domain.NvDO;
import com.bbd.wtyh.mapper.CrowdFundingBusinessStatisticsMapper;
import com.bbd.wtyh.mapper.CrowdFundingCompanyMapper;
import com.bbd.wtyh.mapper.CrowdFundingStatisticsMapper;
import com.bbd.wtyh.service.CrowdFundingService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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

	@Autowired
	private CrowdFundingDao crowdFundingDao;
	

	@Override
	public List<NvDO> lastMonthData() {
		return cfbsMapper.lastMonthData();
	}

	@Override
	public Map<String, String> lastMonthType(String dataType) {
		return crowdFundingDao.lastMonthType(dataType);
	}

	

	@Override
	public List<CrowdFundingCompanyDO> allCompanys() {
		List<CrowdFundingCompanyDO> list = crowdFundingDao.allCompanys();
		if (!CollectionUtils.isEmpty(list)) {
			for (CrowdFundingCompanyDO crowdFundingCompanyDO : list) {
				String websiteUrl = crowdFundingCompanyDO.getWebsiteUrl();
				if (StringUtils.isEmpty(websiteUrl)) {
					continue;
				}
				if (!websiteUrl.contains("http://")) {
					crowdFundingCompanyDO.setWebsiteUrl("http://" + websiteUrl);
				}
			}
		}
		return list;
	}

	@Override
	public List<String> queryCompany(String keyword){
		return cfcMapper.queryCompany(keyword);
	}

}
