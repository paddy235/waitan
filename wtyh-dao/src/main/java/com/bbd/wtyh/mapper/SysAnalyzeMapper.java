package com.bbd.wtyh.mapper;

import java.util.Map;

import com.bbd.wtyh.domain.SysAnalyzeDO;

public interface SysAnalyzeMapper {
	
	SysAnalyzeDO getSysAnalyze();
	
	void updateSysAnalyze(Map<String, Object> params);

}
