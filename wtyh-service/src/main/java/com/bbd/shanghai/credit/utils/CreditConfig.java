package com.bbd.shanghai.credit.utils;

import com.alibaba.fastjson.JSON;
import com.bbd.wtyh.domain.SysConfigDo;
import com.bbd.wtyh.service.SysConfigService;
import com.bbd.wtyh.service.impl.SysConfigServiceImpl;
import com.bbd.wtyh.util.ApplicationContextUtil;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 上海公信中心接口配置信息
 *
 * @author Created by LiYao on 2017-06-07 15:13.
 */
public class CreditConfig {

	private static String userName;
	private static String password;
	private static String uname;
	private static String cxyt;
	private static String serviceUrl;
	private static int dailyLimit;
	private static int dataType;

	private static SysConfigService configService = ApplicationContextUtil.getBean(SysConfigServiceImpl.class);

	public static void read() {
		List<SysConfigDo> configList = configService.getAllByGroup("credit_center");
		Map<String, String> map = new HashMap<>();
		configList.forEach(configDo -> map.put(configDo.getKey(), configDo.getValue()));
		userName = map.get("username");
		password = map.get("password");
		uname = map.get("uname");
		cxyt = map.get("cxyt");
		serviceUrl = map.get("serviceUrl");
		dailyLimit = NumberUtils.toInt(map.get("dailyLimit"));
		dataType = NumberUtils.toInt(map.get("dataType"));

	}

	public static String tostring() {
		Map<String, String> map = new HashMap<>();
		map.put("userName", userName);
		map.put("password", password);
		map.put("uname", uname);
		map.put("cxyt", cxyt);
		map.put("serviceUrl", serviceUrl);
		map.put("dailyLimit", dailyLimit + "");
		map.put("dataType", dataType + "");
		return JSON.toJSONString(map);
	}

	public static String userName() {
		return userName;
	}

	public static String password() {
		return password;
	}

	public static String uname() {
		return uname;
	}

	public static String cxyt() {
		return cxyt;
	}

	public static String serviceUrl() {
		return serviceUrl;
	}

	public static int dailyLimit() {
		return dailyLimit;
	}

	public static int dataType() {
		return dataType;
	}

}
