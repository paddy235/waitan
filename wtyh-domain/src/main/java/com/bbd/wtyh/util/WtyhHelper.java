package com.bbd.wtyh.util;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.util.ResourceBundle;

/**
 * 
 * @author Created by LiYao on 2017-04-17 10:35.
 */
public class WtyhHelper {

	public static String tomcatPath = "";
	public static String exportPath = "";
	public static String userName = "";
	public static String password = "";
	public static String brokerIp = "";
	public static String adminImgPath = "";
	public static String webImgPath = "";
	public static String BeijingServerIp = "";
	public static String datashateIp = "";
	public static String fileRootPath = "";

	static {
		load();
	}

	public static void load() {
		loadProperties("config/wtyh");
		loadSystem();
	}

	public static void loadProperties(String name) {
		ResourceBundle bundle = ResourceBundle.getBundle(name);
		if (bundle == null) {
			throw new IllegalArgumentException("[" + name + ".properties] not found");
		}
		exportPath = bundle.getString("wtyh.export.excel.path");
		brokerIp = bundle.getString("api.bbd.broker.ip");
		adminImgPath = bundle.getString("wtyh.admin.update.img.path");
		webImgPath = bundle.getString("wtyh.web.update.img.path");
		BeijingServerIp = bundle.getString("wtyh.beijing.server.ip");
		datashateIp = bundle.getString("wtyh.datashare.ip");
		fileRootPath = bundle.getString("wtyh.file.root.path");

	}

	public static void loadSystem() {
		tomcatPath = System.getProperty("tomcat.root");
	}

	private static final String OS_NAME = System.getProperty("os.name");

	public static String pathWrap(String path) {
		if (StringUtils.isNotBlank(OS_NAME) && OS_NAME.toUpperCase().startsWith("WIN")) {
			File[] listRoots = File.listRoots();
			return listRoots[listRoots.length - 1] + File.separator + path;
		}
		return path;
	}
}
