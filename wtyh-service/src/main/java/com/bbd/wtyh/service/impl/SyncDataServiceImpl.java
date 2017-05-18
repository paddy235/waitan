package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.*;

import com.bbd.wtyh.mapper.*;

import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.service.SyncDataService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 数据同步
 * 
 * @author tracy zhou
 * @since 2016/8/20
 */
@Service
public class SyncDataServiceImpl implements SyncDataService {

	private Logger logger = LoggerFactory.getLogger(SyncDataServiceImpl.class);
	@Autowired
	private StaticRiskMapper staticRiskMapper;
	@Autowired
	private DynamicRiskMapper dynamicRiskMapper;
	@Autowired
	private RecruitDataMapper recruitDataMapper;
	@Autowired
	private IndexDataMapper indexDataMapper;
	@Autowired
	private RelationDataMapper relationDataMapper;
	@Autowired
	private OfflineFinanceService offlineFinanceService;

	@Override
	public void receiveFileData(File file) throws Exception {
		if (file == null) {
			return;
		}
		InputStream inputStream = new FileInputStream(file);

		LineIterator lineIterator = IOUtils.lineIterator(inputStream, "utf-8");
		ExecutorService dataExecutorService = Executors.newFixedThreadPool(20);
		while (lineIterator.hasNext()) {
			final String string = lineIterator.next();
			dataExecutorService.submit(() -> {
				try {
					insertData(string);
				} catch (Throwable t) {
					logger.error("----------exception------" + string, t);
				}
			});
		}

	}

	private void insertData(String string) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		SyncDataInformationDO syncDataInformationDO = gson.fromJson(string, SyncDataInformationDO.class);
		Integer type = syncDataInformationDO.getType();
		logger.info("----type------" + type);
		String content = syncDataInformationDO.getContent();
		switch (type) {
		case 1:
			StaticRiskDataDO staticRiskDataDO = gson.fromJson(content, StaticRiskDataDO.class);
			String companyName = staticRiskDataDO.getCompanyName();
			BigDecimal oldStaticRiskIndex = staticRiskDataDO.getStaticRiskIndex();
			BigDecimal staticRiskIndex = offlineFinanceService.getSRI(oldStaticRiskIndex, companyName);
			staticRiskDataDO.setStaticRiskIndex(staticRiskIndex);
			staticRiskMapper.save(staticRiskDataDO);
			logger.info("----type---success---" + type);
			break;
		case 2:
			DynamicRiskDataDO dynamicRiskDataDO = gson.fromJson(content, DynamicRiskDataDO.class);
			dynamicRiskMapper.save(dynamicRiskDataDO);
			logger.info("----type---success---" + type);
			break;
		case 3:
			RecruitDataDO recruitDataDO = gson.fromJson(content, RecruitDataDO.class);
			recruitDataMapper.save(recruitDataDO);
			logger.info("----type---success---" + type);
			break;
		case 4:
			IndexDataDO indexDataDO = gson.fromJson(content, IndexDataDO.class);
			String companyNameIndexData = indexDataDO.getCompanyName();
			BigDecimal oldStaticRiskIndexIndexData = indexDataDO.getStaticRiskIndex();
			BigDecimal staticRiskIndexIndexData = offlineFinanceService.getSRI(oldStaticRiskIndexIndexData, companyNameIndexData);
			String area = indexDataDO.getArea();
			IndexDataDO isExistDO = indexDataMapper.selectByPrimaryKey(companyNameIndexData, area);
			indexDataDO.setStaticRiskIndex(staticRiskIndexIndexData);
			if (isExistDO == null) {
				indexDataMapper.save(indexDataDO);
			} else {
				indexDataMapper.update(indexDataDO);
			}
			logger.info("----type---success---" + type);
			break;
		case 5:
			RelationDataDO relationDataDO = gson.fromJson(content, RelationDataDO.class);
			relationDataMapper.save(relationDataDO);
			logger.info("----type---success---" + type);
			break;
		}
	}
}
