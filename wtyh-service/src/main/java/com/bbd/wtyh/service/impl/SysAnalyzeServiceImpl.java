package com.bbd.wtyh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.domain.SysAnalyzeDO;
import com.bbd.wtyh.mapper.SysAnalyzeMapper;
import com.bbd.wtyh.service.SysAnalyzeService;

@Service
public class SysAnalyzeServiceImpl implements SysAnalyzeService {
	
	@Autowired
	private SysAnalyzeMapper sysAnalyzeMapper;

	@Override
	public SysAnalyzeDO getSysAnalyze() {
		SysAnalyzeDO sd = sysAnalyzeMapper.getSysAnalyze();
		int newDataCount = (int)Math.floor(sd.getCompanyCount()*1024*0.09);
		int newBugCount  = (int)Math.floor(sd.getCompanyCount()*1024*0.18);
		sd.setDataCount(newDataCount);
		sd.setBugCount(newBugCount);
		return sd;
	}

}
