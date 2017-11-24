package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.SysConfigDo;
import com.bbd.wtyh.mapper.SysConfigMapper;
import com.bbd.wtyh.service.SysConfigService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 系统配置操作接口 实现
 *
 * @author Created by LiYao on 2017-06-07 11:29.
 */
@Service
public class SysConfigServiceImpl extends BaseServiceImpl implements SysConfigService {

	private static final Map<String, SysConfigDo> CONFIG_MAP = new ConcurrentHashMap<>();
	@Autowired
	private SysConfigMapper sysConfigMapper;


	@Override
	public String getValue(String key) {
		SysConfigDo configDo = this.getConfig(key);
		if (configDo != null) {
			return configDo.getValue();
		}
		return null;
	}

	@Override
	public String getValueByCache(String key) {
		SysConfigDo configDo = this.getConfigByCache(key);
		if (configDo != null) {
			return configDo.getValue();
		}
		return null;
	}

	@Override
	public SysConfigDo getConfig(String key) {
		return this.selectOne(SysConfigDo.class, "config_key = '" + key + "'");
	}

	@Override
	public SysConfigDo getConfigByCache(String key) {
		SysConfigDo configDo = CONFIG_MAP.get(key);
		if (configDo != null) {
			return configDo;
		}
		configDo = this.getConfig(key);
		if (configDo != null) {
			CONFIG_MAP.put(key, configDo);
			return configDo;
		}
		return null;
	}

	@Override
	public List<SysConfigDo> getAllByGroup(String group) {
		return this.selectAll(SysConfigDo.class, "config_group = '" + group + "'");
	}

	@Override
	public void saveConfig(String key, String value, String group, String desc) {
		if (StringUtils.isBlank(key)) {
			throw new IllegalArgumentException("config key must not be null or empty");
		}
		SysConfigDo configDo = new SysConfigDo();
		configDo.setKey(key);
		configDo.setValue(value);
		configDo.setGroup(group);
		configDo.setDesc(desc);
		this.insert(configDo);
		CONFIG_MAP.put(key, configDo);
	}

	@Override
	public void updateConfig(String key, String value, String group, String desc) {
		SysConfigDo configDo = this.getConfigByCache(key);
		if (configDo == null) {
			return;
		}
		configDo.setValue(value);
		configDo.setGroup(group);
		configDo.setDesc(desc);
		this.update(configDo);
		CONFIG_MAP.put(key, configDo);
	}

	/**
	 * 根据key获取链接
	 * @param key
	 * @return
	 */
	@Override
	public String findByKey(String key) {
		return this.sysConfigMapper.findByKey(key);
	}

}
