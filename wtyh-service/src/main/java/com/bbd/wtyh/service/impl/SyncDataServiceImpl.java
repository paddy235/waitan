package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;

import com.bbd.wtyh.domain.*;

import com.bbd.wtyh.mapper.*;

import com.bbd.wtyh.service.SyncDataService;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
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
			Gson gson = new Gson();
			String fileName = file.getOriginalFilename();
			File f = new File("/data/wtyh/" + fileName + ".txt");
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
				String content = syncDataInformationDO.getContent();
				switch (type) {
					case 1:
						StaticRiskDataDO staticRiskDataDO = new StaticRiskDataDO();
						staticRiskDataDO = JSON.parseObject(content, StaticRiskDataDO.class);
						staticRiskMapper.save(staticRiskDataDO);
						break;
					case 2:
						DynamicRiskDataDO dynamicRiskDataDO = new DynamicRiskDataDO();
						dynamicRiskDataDO = JSON.parseObject(content, DynamicRiskDataDO.class);
						dynamicRiskMapper.save(dynamicRiskDataDO);
						break;
					case 3:
						RecruitDataDO recruitDataDO = new RecruitDataDO();
						recruitDataDO = JSON.parseObject(content, RecruitDataDO.class);
						recruitDataMapper.save(recruitDataDO);
						break;
					case 4:
						IndexDataDO indexDataDO = new IndexDataDO();
						indexDataDO = JSON.parseObject(content, IndexDataDO.class);
						indexDataMapper.save(indexDataDO);
						break;
					case 5:
						RelationDataDO relationDataDO = new RelationDataDO();
						relationDataDO = JSON.parseObject(content, RelationDataDO.class);
						relationDataMapper.save(relationDataDO);
						break;
				}
			}
		}
	}
}
