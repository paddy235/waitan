package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;

import com.bbd.wtyh.domain.*;

import com.bbd.wtyh.mapper.*;

import com.bbd.wtyh.service.SyncDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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
	public String receiveData(String syncData) {
		if (!StringUtils.isEmpty(syncData)) {
			List<SyncDataInformationDO> list = JSON.parseArray(syncData, SyncDataInformationDO.class);
			if (!CollectionUtils.isEmpty(list)) {
				for (SyncDataInformationDO syncDataInformationDO : list) {
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
		return null;
	}
}
