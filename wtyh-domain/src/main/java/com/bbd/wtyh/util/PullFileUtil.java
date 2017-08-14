package com.bbd.wtyh.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件拉取
 *
 * @author Created by LiYao on 2017-07-12 11:43.
 */
public class PullFileUtil {

	private static final String PATH;

	private static final String DATA_SHARE_URL;
	private static final String BROKER_IP;
	private static final String FILE_NAME_LIST_URI;

	static {
		PATH = WtyhHelper.pathWrap(WtyhHelper.fileRootPath + "/datashare");
		DATA_SHARE_URL = WtyhHelper.datashateIp + "/client/files?file=";
		BROKER_IP = WtyhHelper.brokerIp;
		FILE_NAME_LIST_URI = "/syncFile/pull-file-list.do?dataType=";
	}

	private static Logger logger = LoggerFactory.getLogger(PullFileUtil.class);

	public static File pullFile(String fileName) {
		logger.info("--------- pull data file start :{}--------", fileName);
		String url = DATA_SHARE_URL + fileName;
		File file = new File(PATH + fileName);

		try {
			InputStream inputStream = HttpUtil.get(url, InputStream.class);
			FileUtils.forceMkdirParent(file);
			IOUtils.copyLarge(inputStream, new FileOutputStream(file));
		} catch (Exception e) {
			logger.info("--------- pull data file have error ：", e);
			return null;
		}

		logger.info("--------- pull data file end :{}--------", fileName);
		return file;
	}

	public static List<Map<String, String>> getFileList(Integer dataType, Integer dataVersion) {
		logger.info("--------- pull data file list start --------");
		String url = BROKER_IP + FILE_NAME_LIST_URI + dataType + "&dataVersion=" + dataVersion;

		String result;
		try {
			result = HttpUtil.get(url);
		} catch (Exception e) {
			logger.error("--------- pull data file list have error:", e);
			return null;
		}
		if (StringUtils.isBlank(result)) {
			logger.error("--------- pull data file list result is blank. result:{}", result);
			return null;
		}
		JSONObject jsonObject = JSONObject.parseObject(result);
		JSONArray content = jsonObject.getJSONArray("content");

		List<Map<String, String>> fileNameList = new ArrayList<>();

		for (int i = 0; i < content.size(); i++) {
			Map<String, String> map = content.getObject(i, Map.class);
			fileNameList.add(map);
		}
		logger.info("--------- pull data file list end --------");
		return fileNameList;
	}

}
