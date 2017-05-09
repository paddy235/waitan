package com.bbd.wtyh.util;

import java.util.ResourceBundle;

/**
 * 
 * @author Created by LiYao on 2017-04-17 10:35.
 */
public class WtyhHelper {

	public static String tomcatPath = "";
	public static String exportPath = "";
	public static String serviceUrl= "";
	public static String userName= "";
	public static String password= "";


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
		serviceUrl = bundle.getString("sh.credit.info.url");
		userName = bundle.getString("sh.credit.info.name");
		password = bundle.getString("sh.credit.info.password");

	}

	public static void loadSystem() {
		tomcatPath = System.getProperty("tomcat.root");
	}
}
