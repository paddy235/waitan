package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;

import com.bbd.wtyh.domain.*;

import com.bbd.wtyh.mapper.*;

import com.bbd.wtyh.service.SyncDataService;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 数据同步
 * @author tracy zhou
 * @since  2016/8/20
*/
@Service
public class SyncDataServiceImpl implements SyncDataService {
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


	@Override
	public void receiveFileData(MultipartFile file) throws Exception{
		if (file != null) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			String fileName = file.getOriginalFilename();
			File f = new File("/data/wtyh/admin/" + fileName);
			FileUtils.forceMkdirParent(f);
			OutputStream outputStream = new FileOutputStream(f);
			IOUtils.copyLarge(file.getInputStream(), outputStream);
		    InputStream inputStream = new FileInputStream(f);
			LineIterator lineIterator = IOUtils.lineIterator(inputStream, "utf-8");
			while (lineIterator.hasNext()) {
				String string = lineIterator.next();
				SyncDataInformationDO syncDataInformationDO = new SyncDataInformationDO();
				syncDataInformationDO = gson.fromJson(string, SyncDataInformationDO.class);
				Integer type = syncDataInformationDO.getType();
				System.out.println("----type------"+type);
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
						String area = indexDataDO.getArea();
						IndexDataDO isExistDO = indexDataMapper.selectByPrimaryKey(companyName, area);
						if (isExistDO == null) {
							indexDataMapper.save(indexDataDO);
						} else {
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
	}
}
