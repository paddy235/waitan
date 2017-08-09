package com.bbd.wtyh.util;

import com.alibaba.fastjson.JSONArray;
import com.bbd.higgs.utils.http.HttpTemplate;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
		DATA_SHARE_URL = WtyhHelper.BeijingServerIp + ":" + WtyhHelper.datashatePort + "/client/files?file=";
		BROKER_IP = WtyhHelper.brokerIp;
		FILE_NAME_LIST_URI = "/syncFile/pull-file-list.do?dataType=";
	}

	private static Logger logger = LoggerFactory.getLogger(PullFileUtil.class);

	public static File pullFile(String fileName) throws Exception {
		logger.info("--------- pull data file start --------");
		String url = DATA_SHARE_URL + fileName;
		InputStream inputStream = HttpUtil.get(url, InputStream.class);
		File file = new File(PATH + fileName);
		FileUtils.forceMkdirParent(file);
		IOUtils.copyLarge(inputStream, new FileOutputStream(file));
		logger.info("--------- pull data file end --------");
		return file;
	}

	public static List<File> getFileList(Integer dataType) throws Exception {
		logger.info("--------- pull data file list start --------");
		String url = BROKER_IP + FILE_NAME_LIST_URI + dataType;
		String result = new HttpTemplate().get(url);
		JSONObject jsonObject = JSONObject.fromObject(result);
		Object content = jsonObject.get("content");
		List<String> strList = JSONArray.parseArray(String.valueOf(content), String.class);
		logger.info("--------- pull data file list end --------");
		List<File> fileList = new ArrayList<>();
		for (String str : strList) {
			File file = pullFile(str);
			if (null != file && file.exists()) {
				fileList.add(file);
			}
		}
		return fileList;
	}

}
