package com.bbd.wtyh.common.relation;

import com.bbd.wtyh.util.relation.Utils;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 常量类
 * 
 * @author Barney
 *
 */
public class Constants {

	public static final String SEARCH_API_ACCESS_TOKEN = "273601cbd4ef2c358ab728025cb23e33";
	public static final String SEARCH_API_FIELDS = "名称";
	public static final String SEARCH_API_TABLE = "qyxx";
	public static final String SEARCH_API_TYPE = "detail";
	public static String SEARCH_API_DATA_VERSION = "";
	public static final String SEARCH_API_REG_DATE = "成立日期";
	public static final String SEARCH_API_LEGAL_PERSON = "法定代表人";
	public static final String CHARACTER_CODE = "UTF-8";
	public static final String SEARCH_API_COMPANY_URL = "api.search.company.url";
	public static String ctx;
	public static final String REDIS_SEARCH_SUFFIX = "search";
	public static final String REDIS_SCATTER_SUFFIX = "scatter";
	public static final String EXCEL_SUFFIX = ".xlsx";
	public static final String REG_EX = "[`~!@#$%^&*+=|{}':;',//[//].<>/?~！@#￥%……&*——+|{}【】‘；：”“’。，、？]";
	
	public static String DATA_VERSION = "";
	public static String RELATION_DATA_VERSION = "";

	//2016年1月5日  占比变为百分比 
	public static float INT100 = 100;
	public static int INT10000 = 10000;
	
	public static WebApplicationContext context;
	public static String systemAesScret;//系统公司加密
	public static final String SYSTEM_CODE = "system";
	public static final String API_SEARCH_URL = "api.search.baseinfo.url";
	public static long cacheDays;// redis缓存天数
	public static String SSJL_DATA_VERSION = ""; // 诉讼记录API版本号
	public static String shareDir;//分享附件文件夹
	public static String mappingPath;//附件文件夹映射到服务器的目录
	public static String attDir = "att";//

	// 系统自带的方法，所有人都有此功能
	public static Map<String, String> SystemActionMethod = new HashMap<String, String>();

	public static final class SESSION {
		public static final String loginName = "loginName";
		public static final String loginNameCn = "loginNameCn";
		public static final String userType = "userType";
		public static final String email = "email";
		public static final String ctx = "ctx";
		public static final String cpuCode = "cpuCode";// cpu编码
		public static final String mainBoardCode = "mainBoardCode";// 主板编码
		public static final String AREA_CODE = "areaCode"; // 地区编码
	}

	// 是与否
	public static final class YesOrNo {
		public static final String YES = "1";
		public static final String NO = "0";
		public static final String YN = "-1";
	}

	public static void loadProperties() {
		Properties systemProp = new Properties();
		Properties priviledgeProp = new Properties();
		InputStream systemIn = null;
		try {
			systemIn = Constants.class.getClassLoader().getResource("config/system.properties").openStream();
			systemProp.load(systemIn);

			Set<Object> priviledgeKey = priviledgeProp.keySet();
			if (priviledgeKey != null) {
				for (Object o : priviledgeKey) {
					String values=priviledgeProp.getProperty(o.toString()).trim();
					String[] value=values.split(",");
					for(String str:value){
						if(Constants.SYSTEM_CODE.equals(str)){
							SystemActionMethod.put(o.toString(), str);
						}else{
							SystemActionMethod.put(o.toString()+"@"+ Utils.trimString(str), str);
						}
					}
				}
			}
			systemAesScret = systemProp.getProperty("system.aes.scret", "").trim();
			DATA_VERSION = systemProp.getProperty("api.data.version", "").trim();
			cacheDays = Long.parseLong(systemProp.getProperty("cache.days", "").trim()) * 3600 * 24;
			shareDir = systemProp.getProperty("share.path", "").trim();
			mappingPath = systemProp.getProperty("mapping.path", "").trim();
			SSJL_DATA_VERSION = systemProp.getProperty("api.ssjl.data.version", "").trim();
			RELATION_DATA_VERSION = systemProp.getProperty("relation.data.version", "").trim();
			SEARCH_API_DATA_VERSION = systemProp.getProperty("search.api.data.version", "").trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
