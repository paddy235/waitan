package com.bbd.wtyh.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constants {

	public static Long cacheDay;
	
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
