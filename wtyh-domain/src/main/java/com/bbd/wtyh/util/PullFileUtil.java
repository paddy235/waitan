package com.bbd.wtyh.util;

import com.bbd.wtyh.excel.imp.utils.ProgressUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

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

	public static void getFileList(Integer dataType) {
	}

}
