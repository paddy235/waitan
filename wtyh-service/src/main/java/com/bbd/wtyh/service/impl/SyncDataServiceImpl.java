package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;

import com.bbd.wtyh.domain.*;

import com.bbd.wtyh.mapper.*;

import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.service.SyncDataService;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 数据同步
 * @author tracy zhou
 * @since  2016/8/20
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
	public void receiveFileData(MultipartFile file) throws Exception{
		if (file != null) {
			String fileName = file.getOriginalFilename();
			File f = new File("/data/wtyh/admin/" + fileName);
			FileUtils.forceMkdirParent(f);
			OutputStream outputStream = new FileOutputStream(f);
			IOUtils.copyLarge(file.getInputStream(), outputStream);
		    InputStream inputStream = new FileInputStream(f);
			LineIterator lineIterator = IOUtils.lineIterator(inputStream, "utf-8");
			ExecutorService dataExecutorService = Executors.newFixedThreadPool(20);
			while (lineIterator.hasNext()) {
				final String string = lineIterator.next();
				dataExecutorService.submit(new Runnable() {
					@Override
					public void run() {
						try {
							insertData(string);
						}catch (Throwable t){
							t.printStackTrace();
						}
					}
				});
			}
		}
	}

	private void insertData(String string) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		SyncDataInformationDO syncDataInformationDO = new SyncDataInformationDO();
		syncDataInformationDO = gson.fromJson(string, SyncDataInformationDO.class);
		Integer type = syncDataInformationDO.getType();
		logger.info("----type------"+type);
		String content = syncDataInformationDO.getContent();
		switch (type) {
            case 1:
                StaticRiskDataDO staticRiskDataDO = new StaticRiskDataDO();
                staticRiskDataDO = gson.fromJson(content, StaticRiskDataDO.class);
                staticRiskMapper.save(staticRiskDataDO);
                break;
            case 2:
                DynamicRiskDataDO dynamicRiskDataDO = new DynamicRiskDataDO();
                dynamicRiskDataDO = gson.fromJson(content, DynamicRiskDataDO.class);
                dynamicRiskMapper.save(dynamicRiskDataDO);
                break;
            case 3:
                RecruitDataDO recruitDataDO = new RecruitDataDO();
                recruitDataDO = gson.fromJson(content, RecruitDataDO.class);
                recruitDataMapper.save(recruitDataDO);
                break;
            case 4:
                IndexDataDO indexDataDO = new IndexDataDO();
                indexDataDO = gson.fromJson(content, IndexDataDO.class);
				String companyName = indexDataDO.getCompanyName();
				BigDecimal oldStaticRiskIndex = indexDataDO.getStaticRiskIndex();
				BigDecimal staticRiskIndex = offlineFinanceService.getSRI(oldStaticRiskIndex, companyName);
                String area = indexDataDO.getArea();
                IndexDataDO isExistDO = indexDataMapper.selectByPrimaryKey(companyName, area);
                indexDataDO.setStaticRiskIndex(staticRiskIndex);
                if (isExistDO == null) {
					logger.info("------save-----"+indexDataDO.getCompanyName());
                    indexDataMapper.save(indexDataDO);
                } else {
					logger.info("------update-----"+indexDataDO.getCompanyName());
                    indexDataMapper.update(indexDataDO);
                }
                break;
            case 5:
                RelationDataDO relationDataDO = new RelationDataDO();
                relationDataDO = gson.fromJson(content, RelationDataDO.class);
                relationDataMapper.save(relationDataDO);
                break;
        }
	}
}
