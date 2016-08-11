package com.bbd.wtyh.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constants {

	public static final String REDIS_KEY_STATIC_RISK_INDEX = "RK_SRI";
	public static final String REDIS_KEY_SJKZR_RISK = "RK_SJKZRR";
	public static final String REDIS_KEY_GSKZLJ_RISK = "RK_GSKZLJR";
	public static final String REDIS_KEY_ZXJJH_RISK = "RK_ZXJJHR";
	public static final String REDIS_KEY_FFRZYS_RISK = "RK_FFRZYSR";
	public static final String REDIS_KEY_DQZL_RISK = "RK_DQZLR";
	public static final String REDIS_KEY_FFRZWG_RISK = "RK_FFRZWGR";
	public static final String REDIS_KEY_RCJG_RISK = "RK_RCJGR";
	public static Long cacheDay;


	public static String shareDir;//分享附件文件夹
	public static String attDir = "att";//

	private static String [] docSort;
	
	public static String [] docSort(){
		if(docSort==null){
			loadProperties();
		}
		return docSort;
	}
	
	
	public static void loadProperties() {
		Properties system = new Properties();
		InputStream is = null;
		try {
			is = Constants.class.getClassLoader().getResource("config/system.properties").openStream();
			system.load(is);

			cacheDay = Long.parseLong(system.getProperty("cache.day", "").trim()) * 86400;
			
			docSort = (system.getProperty("doc.sort", "").trim()).split(",");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
