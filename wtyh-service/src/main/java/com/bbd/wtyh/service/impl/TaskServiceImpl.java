package com.bbd.wtyh.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.mapper.SysAnalyzeMapper;
import com.bbd.wtyh.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	private static int baseNo = 140;
	@Autowired
	private SysAnalyzeMapper sysAnalyzeMapper;
	
	@Scheduled(cron = "0 0/1 * * * ?")
	@Override
	public void updateSysAnalyze() {
		Map<String, Object> params = new HashMap<>();
		Random random = new Random();
		params.put("dataCount", baseNo + random.nextInt(20));
		params.put("bugCount", baseNo + random.nextInt(20));
		
		sysAnalyzeMapper.updateSysAnalyze(params);
	}

}
