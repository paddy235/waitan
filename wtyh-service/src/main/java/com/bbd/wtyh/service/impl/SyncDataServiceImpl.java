package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.core.base.BaseServiceImpl;
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
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 数据同步
 * 
 * @author tracy zhou
 * @since 2016/8/20
 */
@Service
public class SyncDataServiceImpl extends BaseServiceImpl implements SyncDataService {

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

	private volatile boolean isShutdown = false;//任务停止标志

	@Override
	public void stopTask() {
		isShutdown = true;
	}

	@Override
	public void resetShutDown() {
		isShutdown = false;
	}

	@Override
	public TaskResultDO receiveFileData(File file) throws Exception {
		isShutdown=false;
		TaskResultDO taskResultDO=new TaskResultDO(0, 0, 0);

		if (file == null) {
			return taskResultDO;
		}
		int totalCount = 0;
		int successCount = 0;
		int failCount = 0;
		InputStream inputStream = new FileInputStream(file);
		LineIterator lineIterator = IOUtils.lineIterator(inputStream, "utf-8");
		ExecutorService dataExecutorService = Executors.newFixedThreadPool(20);

		while (lineIterator.hasNext()) {
			totalCount++;
			final String string = lineIterator.next();
			Future<Boolean> future = dataExecutorService.submit(() -> {
				try {
					if(isShutdown){
						return false;
					}
					insertData(string);
					return true;
				} catch (Throwable t) {
					logger.error("----------exception：{}------", string, t);
					return false;
				}
			});
			if (future.get()) {
				successCount++;
			} else {
				failCount++;
			}
		}
		dataExecutorService.shutdown();
		dataExecutorService.awaitTermination(1, TimeUnit.DAYS);


		taskResultDO.setPlanCount(successCount+failCount);
		taskResultDO.setSuccessCount(successCount);
		taskResultDO.setFailCount(failCount);

		return taskResultDO;
	}

	private void insertData(String string) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		SyncDataInformationDO syncDataInformationDO = gson.fromJson(string, SyncDataInformationDO.class);
		Integer type = syncDataInformationDO.getType();
		logger.info("----type------" + type);
		String content = syncDataInformationDO.getContent();
		String companyName;
		String dataVersion;
		String areaName;
		switch (type) {
		case 1:
			StaticRiskDataDO staticRiskDataDO = gson.fromJson(content, StaticRiskDataDO.class);
			companyName = staticRiskDataDO.getCompanyName();
			dataVersion = staticRiskDataDO.getDataVersion();
			areaName = staticRiskDataDO.getArea();

			BigDecimal oldStaticRiskIndex = staticRiskDataDO.getStaticRiskIndex();
			BigDecimal staticRiskIndex = offlineFinanceService.getSRI(oldStaticRiskIndex, companyName);
			staticRiskDataDO.setStaticRiskIndex(staticRiskIndex);

			String sql = "DELETE FROM static_risk_data WHERE company_name = ? AND data_version = ? AND area = ?";
			this.executeCUD(sql, companyName, dataVersion, areaName);
			staticRiskMapper.save(staticRiskDataDO);
			logger.info("----type---success---" + type);
			break;
		case 2:
			DynamicRiskDataDO dynamicRiskDataDO = gson.fromJson(content, DynamicRiskDataDO.class);
			companyName = dynamicRiskDataDO.getCompanyName();
			dataVersion = dynamicRiskDataDO.getDataVersion();
			areaName = dynamicRiskDataDO.getArea();
			sql = "DELETE FROM dynamic_risk_data WHERE company_name = ? AND data_version = ?  AND area = ?";
			this.executeCUD(sql, companyName, dataVersion, areaName);
			dynamicRiskMapper.save(dynamicRiskDataDO);
			logger.info("----type---success---" + type);
			break;
		case 3:
			RecruitDataDO recruitDataDO = gson.fromJson(content, RecruitDataDO.class);
			companyName = recruitDataDO.getCompanyName();
			dataVersion = recruitDataDO.getDataVersion();
			this.executeCUD("DELETE FROM recruit_data WHERE data_version = ? AND company_name = ?", dataVersion, companyName);
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
			companyName = relationDataDO.getCompanyName();
			dataVersion = relationDataDO.getDataVersion();
			areaName = relationDataDO.getArea();

			sql = "DELETE FROM relation_data WHERE company_name = ? AND data_version = ?  AND area = ?";
			this.executeCUD(sql, companyName, dataVersion, areaName);
			relationDataMapper.save(relationDataDO);
			logger.info("----type---success---" + type);
			break;
		}
	}
}
