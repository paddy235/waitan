package com.bbd.wtyh.common;

import com.bbd.wtyh.util.relation.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Constants {

	public static final String REDIS_KEY_STATIC_RISK_INDEX = "RK_SRI";
	public static final String REDIS_KEY_SJKZR_RISK = "RK_SJKZRR";
	public static final String REDIS_KEY_GSKZLJ_RISK = "RK_GSKZLJR";
	public static final String REDIS_KEY_ZXJJH_RISK = "RK_ZXJJHR";
	public static final String REDIS_KEY_FFRZYS_RISK = "RK_FFRZYSR";
	public static final String REDIS_KEY_DQZL_RISK = "RK_DQZLR";
	public static final String REDIS_KEY_FFRZWG_RISK = "RK_FFRZWGR";
	public static final String REDIS_KEY_RCJG_RISK = "RK_RCJGR";
	public static final String REDIS_KEY_BASE_INFO_BBD_DATA = "BASE_INFO_BBD_DATA";
	public static final String REDIS_KEY_COMPANY_CREDIT_POINT_ITEMS = "BASE_INFO_COMPANY_CREDIT_POINT_ITEMS";
	public static final String characterCode = "utf-8";
	public static final String REDIS_KEY_BUSINESS_CHART_SHOW_P2P = "REDIS_KEY_BUSINESS_CHART_SHOW_P2P";
	public static final String REDIS_KEY_BUSINESS_CHART_SHOW_FINANCE = "REDIS_KEY_BUSINESS_CHART_SHOW_FINANCE";
	public static final String REDIS_KEY_BUSINESS_CHART_SHOW_EXCHANGE = "REDIS_KEY_BUSINESS_CHART_SHOW_EXCHANGE";
	public static final String REDIS_KEY_BUSINESS_CHART_SHOW_CROWD = "REDIS_KEY_BUSINESS_CHART_SHOW_CROWD";
	public static final String REDIS_KEY_BUSINESS_CHART_SHOW_MORTGAGE = "REDIS_KEY_BUSINESS_CHART_SHOW_MORTGAGE";
	public static final String REDIS_KEY_BUSINESS_CHART_SHOW_FACTORING = "REDIS_KEY_BUSINESS_CHART_SHOW_FACTORING";
	public static final String REDIS_KEY_BUSINESS_CHART_SHOW_PREPAID = "REDIS_KEY_BUSINESS_CHART_SHOW_PREPAID";
	public static final String REDIS_KEY_BUSINESS_CHART_SHOW_GUARANTEE = "REDIS_KEY_BUSINESS_CHART_SHOW_GUARANTEE";
	public static final String REDIS_KEY_BUSINESS_CHART_SHOW_LOAN = "REDIS_KEY_BUSINESS_CHART_SHOW_LOAN";
	public static final String REDIS_KEY_BUSINESS_CHART_SHOW_PRIVATE = "REDIS_KEY_BUSINESS_CHART_SHOW_PRIVATE";
	public static final String REDIS_KEY_BUSINESS_CHART_SHOW_INDUSTRY_SHANGHAI = "REDIS_KEY_BUSINESS_CHART_SHOW_INDUSTRY_SHANGHAI";
	/**
	 * 线下理财关联数据使用 start
	 */
	public static String SEARCH_API_DATA_VERSION = "";
	public static String DATA_VERSION = "20160430";
	public static String RELATION_DATA_VERSION = "";
	public static String systemAesScret;//系统公司加密
	public static final String SYSTEM_CODE = "system";
	public static String SSJL_DATA_VERSION = ""; // 诉讼记录API版本号
	public static String shareDir;//分享附件文件夹
	public static String mappingPath;//附件文件夹映射到服务器的目录
	public static String attDir = "att";//
	// 系统自带的方法，所有人都有此功能
	public static Map<String, String> SystemActionMethod = new HashMap<String, String>();
	
	// redis缓存时间
	public static final long REDIS_10 = 864000l; // 10天
	public static final long REDIS_7 = 604800l; // 7天
	public static final long REDIS_5 = 432000l; // 5天
	public static final long REDIS_3 = 259200l; // 3天

	public static final class SESSION {
		public static final String loginName = "loginName";
		public static final String loginUserId = "loginUserId";
		public static final String loginNameCn = "loginNameCn";
		public static final String userType = "userType";
		public static final String email = "email";
		public static final String ctx = "ctx";
		public static final String cpuCode = "cpuCode";// cpu编码
		public static final String mainBoardCode = "mainBoardCode";// 主板编码
		public static final String AREA_CODE = "areaCode"; // 地区编码
		public static final String showLoginName = "showLoginName";  //前台用户名
	}

	//占比变为百分比
	public static float INT100 = 100;
	public static int INT10000 = 10000;
	/**
	 * 线下理财关联数据使用 end
	 */
	public static Long cacheDay = 7l;

	public static Long cacheDay_One_Day = 1l;

	private static String [] docSort;
	
	public static String [] docSort(){
		if(docSort==null){
			loadProperties();
		}
		return docSort;
	}
	
	
	public static void loadProperties() {
		Properties system = new Properties();
		Properties priviledgeProp = new Properties();

		InputStream is = null;
		try {
			is = Constants.class.getClassLoader().getResource("config/online.properties").openStream();
			system.load(is);

			cacheDay = Long.parseLong(system.getProperty("cache.day", "").trim()) * 86400;
			
			docSort = (system.getProperty("doc.sort", "").trim()).split(",");

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
			systemAesScret = system.getProperty("system.aes.scret", "").trim();
			shareDir = system.getProperty("share.path", "").trim();
			mappingPath = system.getProperty("mapping.path", "").trim();
			SSJL_DATA_VERSION = system.getProperty("api.ssjl.data.version", "").trim();
			RELATION_DATA_VERSION = system.getProperty("relation.data.version", "").trim();
			SEARCH_API_DATA_VERSION = system.getProperty("search.api.data.version", "").trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
