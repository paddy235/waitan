package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.SysConfigDo;

import java.util.List;

/**
 * 系统配置操作接口
 *
 * @author Created by LiYao on 2017-06-07 11:29.
 */
public interface SysConfigService {

	String getValue(String key);

	String getValueByCache(String key);

	SysConfigDo getConfig(String key);

	SysConfigDo getConfigByCache(String key);

	List<SysConfigDo> getAllByGroup(String group);

	void saveConfig(String key, String value, String group, String desc);

	void updateConfig(String key, String value, String group, String desc);

	String findByKey(String key);


}
