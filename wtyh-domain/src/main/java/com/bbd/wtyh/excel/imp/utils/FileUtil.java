package com.bbd.wtyh.excel.imp.utils;

import sun.security.action.GetPropertyAction;

import java.io.File;
import java.security.AccessController;

/**
 * 文件工具类
 *
 * @author Created by LiYao on 2017-07-15 16:16.
 */
public class FileUtil {

	private static final File TMP_DIR = new File(AccessController.doPrivileged(new GetPropertyAction("java.io.tmpdir")));

	private static final String SEPARATOR = File.separator;
	private static final String SUFFIX = ".tmp";

	public static File tempDir() {
		return TMP_DIR;
	}

	public static File createTempFile(String fileName) throws Exception {
		File file = new File(tempDir() + SEPARATOR + fileName + SUFFIX);
		if (file.exists()) {
			return file;
		}
		file.createNewFile();
		file.deleteOnExit();
		return file;
	}

}
