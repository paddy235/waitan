package com.bbd.shanghai.credit.utils;

import com.bbd.wtyh.domain.SysConfigDo;
import com.bbd.wtyh.service.CoCreditScoreService;
import com.bbd.wtyh.service.SysConfigService;
import com.bbd.wtyh.service.impl.SysConfigServiceImpl;
import com.bbd.wtyh.util.ApplicationContextUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private static String dataType;
	private static int threadNum = 1;
	private static int timeOut;
	private static int retryNum = 2;
	private static int retryThreadNum = 2;

	private static SysConfigService configService = ApplicationContextUtil.getBean(SysConfigServiceImpl.class);
	private static final Logger LOGGER = LoggerFactory.getLogger(CoCreditScoreService.class);

	public static synchronized void read() {
		List<SysConfigDo> configList = configService.getAllByGroup("credit_center");
		if (CollectionUtils.isEmpty(configList)) {
			LOGGER.error("读取公信接口配置信息失败，未读取到信息");
			return;
		}
		Map<String, String> map = new HashMap<>();
		configList.forEach(configDo -> map.put(configDo.getKey(), configDo.getValue()));
		userName = map.get("username");
		password = map.get("password");
		uname = map.get("uname");
		cxyt = map.get("cxyt");
		serviceUrl = map.get("serviceUrl");
		dailyLimit = NumberUtils.toInt(map.get("dailyLimit"));
		dataType = map.get("dataType");
		int threadNumTmp = NumberUtils.toInt(map.get("threadNum"), 1);
		threadNum = threadNumTmp < 1 ? 1 : threadNumTmp;
		int timeOutTmp = NumberUtils.toInt(map.get("timeOut"), 0);
		timeOut = timeOutTmp;
		int retryNumTmp = NumberUtils.toInt(map.get("retryNum"), 0);
		retryNum = retryNumTmp < 0 ? 2 : retryNumTmp;

		int retryThreadNumTmp = NumberUtils.toInt(map.get("retryThreadNum"), 0);
		retryThreadNum = retryThreadNumTmp < 1 ? 2 : retryThreadNumTmp;

		map.put("password", "***");
		LOGGER.info("读取公信接口配置信息。{}", map.toString());

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

	public static String dataType() {
		return dataType;
	}

	public static int threadNum() {
		return threadNum;
	}

	public static int timeOut() {
		return timeOut;
	}

	public static int retryNum() {
		return retryNum;
	}

	public static int retryThreadNum() {
		return retryThreadNum;
	}


}
