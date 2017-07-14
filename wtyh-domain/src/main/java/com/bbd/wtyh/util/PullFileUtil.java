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

	private static final String PATH = "d:\\wtyh\\datashare\\";

	private static final String DATA_SHARE_URL = "https://10.28.100.48:8989/client/files?file=";
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

	private static String brokerIp = WtyhHelper.brokerIp;
	private static String fileNameListUri = "/syncFile/pull-file-list.do?dataType=";

	public static List<File> getFileList(Integer dataType) throws Exception{
		logger.info("--------- pull data file list start --------");
		//String url = brokerIp + fileNameListUri+dataType;
		String url="http://10.28.200.239:7778/syncFile/pull-file-list.do?dataType=1";
		String result = new HttpTemplate().get(url);
		JSONObject jsonObject = JSONObject.fromObject(result);
		Object content = jsonObject.get("content");
		List<String> strList = JSONArray.parseArray(String.valueOf(content), String.class);
		logger.info("--------- pull data file list end --------");
		List<File> fileList = new ArrayList<File>();
		for(String str:strList){
			File file = pullFile(str);
			if(null!=file&&file.exists()){
				fileList.add(file);
			}
		}
		return fileList;
	}


}
