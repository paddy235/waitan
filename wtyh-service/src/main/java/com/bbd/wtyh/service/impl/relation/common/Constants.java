package com.bbd.wtyh.service.impl.relation.common;

import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;


/**
 * 常量类
 * 
 * @author Barney
 *
 */
public class Constants {

	//2016年1月5日  占比变为百分比
	public static long cacheDays;// redis缓存天数
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

}
