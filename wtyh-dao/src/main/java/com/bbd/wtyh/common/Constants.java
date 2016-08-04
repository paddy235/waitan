package com.bbd.wtyh.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constants {
	
	public static final String [] JUDGE_AND_OFFICE_TITLE = { "序号", "法院", "法官", "律师事务所", "关系案件数", "胜诉案件数", "胜诉率" };
	public static final String [] JUDGE_AND_LAWYER_TITLE = { "序号", "法院", "法官", "律师", "关系案件数", "胜诉率" };

	
	
	public static final String CHARACTER_CODE = "UTF-8";
	public static final String INDEX_MAP_DOC_STAT_KEY = "index:map:doc_stat";
	public static final String INDEX_LAWYER_CASE_TYPE_STAT_KEY = "index:lawyer:case_type_stat";
	public static final String INDEX_LAWYER_PROVINCE_STAT_KEY = "index:lawyer:province_stat";
	public static final String INDEX_JUDGE_STAT_KEY = "index:judge:stat";
	public static final String INDEX_STAT_DOC_COUNT_KEY = "index:stat:doc_count";
	/**
	 * 律师检索模块
	 */
	public static final String LAWYER_SEARCH_ALL_LIST_CACAUSE_ORDER_KEY = "lawyer:search:cause:order:all";//律师检索文书总量排序list
	public static final String LAWYER_SEARCH_ALL_LIST_TOTALNUM_ORDER_KEY = "lawyer:search:total:order:all";//律师检索文书关注类型排序list
	public static final String LAWYER_SEARCH_ALL_LAWYER_COUNT_KEY = "lawyer:search:list:count";//律师检索总量
	public static final String LAWYER_FIGURE_OPPONENT_KEY = "lawyer:figure:opponent";//对手律师
	public static final String LAWYER_FIGURE_PROXY_TYPE_KEY = "lawyer:figure:proxy_type";//代理类型
	public static final String LAWYER_FIGURE_CASE_TYPE_KEY = "lawyer:figure:case_type";//案例类型top10
	public static final String LAWYER_FIGURE_RELATED_GRAPH_KEY = "lawyer:figure:related_graph";//律师关联图谱
	public static final String LAWYER_FIGURE_NATURE_TYPE_KEY = "lawyer:figure:nature_type";//当事人性质
	public static final String LAWYER_FIGURE_PROGRAM_KEY = "lawyer:figure:program";//审理程序
	public static final String LAWYER_FIGURE_CLIENT_KEY = "lawyer:figure:client";//当事人条形图
	public static final String LAWYER_FIGURE_OFTEN_COURT_KEY = "lawyer:figure:often_court";//常去法院
	
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
