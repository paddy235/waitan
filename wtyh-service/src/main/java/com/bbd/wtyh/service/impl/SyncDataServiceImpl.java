package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;

import com.bbd.wtyh.domain.StaticRiskDataDO;
import com.bbd.wtyh.domain.SyncDataInformationDO;

import com.bbd.wtyh.mapper.StaticRiskMapper;

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
							break;
						case 3:
							break;
						case 4:
							break;
						case 5:
							break;
					}
				}
			}
		}
		return null;
	}
}
