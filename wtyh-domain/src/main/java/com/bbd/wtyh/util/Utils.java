package com.bbd.wtyh.util;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.*;
import java.util.*;


public class Utils {
	/**
	 * 计算真实页数
	 * @param fromPageCount 从页传过来的页码
	 * @param pageSize 每页展示多少条
	 * @param count 数据库查询的总条数
	 * @return
	 */
	public static int getRealPage(int fromPageCount,int pageSize,int count){
		if(fromPageCount==0){
			return 1;
		}
		int pageCount = (count+pageSize-1)/pageSize;
		if(fromPageCount>pageCount){
			return pageCount;
		}else{
			return fromPageCount;
		}
	}
	
	/**
	 * 计算真实页数
	 * @param fromPageCount 从页传过来的页码
	 * @param pageSize 每页展示多少条
	 * @param count 数据库查询的总条数
	 * @return
	 */
	public static int getRealPage(int fromPageCount,int pageCount){
		if(fromPageCount==0){
			return 1;
		}
		if(fromPageCount>pageCount){
			return pageCount;
		}else{
			return fromPageCount;
		}
	}
	
	
	/**
	 * 计算出总页数,以及判断传递过来的页码是否大于总页数
	 * @param params 封装的属性类
	 *//*
	public static StaffTableParam getPageCount(StaffTableParam params) {
		//查询总条数得到总页数
		int count = params.getCount();
		int pageSize = params.getPageSize();
		int pageCount = (count+pageSize-1)/pageSize;
		
		//判断分页数据
		int page = params.getPage();
		if(page<1){
			page=1;
		}
		if(page > pageCount){
			params.setPageCount(pageCount);
			if(pageCount>0){
				params.setPage(pageCount);
			}else{
				params.setPage(1);
			}
			
		}else{
			params.setPageCount(pageCount);
			params.setPage(page);
		}
		
		return params;
				
	}*/
	
	
	public static boolean isNullForString(String s)
	{
		boolean b = false;
		if(null == s || "".equals(s.replace("　", " ").trim()))
		{
			b = true;
		}
		return b;
	}
	public static String convertDateYMDHMSString(Date date)
	{
		String s = null;
		if(date != null)
		{
			SimpleDateFormat sdf_YYYYMMDDHMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			s = sdf_YYYYMMDDHMS.format(date);
		}
		return s;
	}
	public static String convertDateHMSSSSString(Date date)
	{
		String s = null;
		if(date != null)
		{
			SimpleDateFormat sdf_YYYYMMDDHMS = new SimpleDateFormat("HHmmsssss");
			
			s = sdf_YYYYMMDDHMS.format(date);
		}
		return s;
	}
	public static String convertDateYMDString(Date date)
	{
		String s = null;
		if(date != null)
		{
			SimpleDateFormat sdf_YYYYMMDDHMS = new SimpleDateFormat("yyyy-MM-dd");
			
			s = sdf_YYYYMMDDHMS.format(date);
		}
		return s;
	}
	public static String convertDateYMString(Date date)
	{
		String s = null;
		if(date != null)
		{
			SimpleDateFormat sdf_YYYYMMDDHMS = new SimpleDateFormat("yyyy-MM");
			
			s = sdf_YYYYMMDDHMS.format(date);
		}
		return s;
	}
	public static String convertDateYMString2(Date date)
	{
		String s = null;
		if(date != null)
		{
			SimpleDateFormat sdf_YYYYMMDDHMS = new SimpleDateFormat("yyyy 年  MM 月");
			
			s = sdf_YYYYMMDDHMS.format(date);
		}
		return s;
	}
	/**
	 * 获取天数
	 * @param date
	 * @return
	 */
	public static String convertDateDDString(Date date)
	{
		String s = null;
		if(date != null)
		{
			SimpleDateFormat sdf_YYYYMMDDHMS = new SimpleDateFormat("dd");
			
			s = sdf_YYYYMMDDHMS.format(date);
		}
		return s;
	}
	public static String convertDateHmsString(Date date)
	{
		String s = null;
		if(date != null)
		{
			SimpleDateFormat sdf_YYYYMMDDHMS = new SimpleDateFormat("HH:mm:ss");
			
			s = sdf_YYYYMMDDHMS.format(date);
		}
		return s;
	}
	public static String convertDateHmString(Date date)
	{
		String s = null;
		if(date != null)
		{
			SimpleDateFormat sdf_YYYYMMDDHMS = new SimpleDateFormat("HH:mm");
			
			s = sdf_YYYYMMDDHMS.format(date);
		}
		return s;
	}
	public static String trimString(String s )
	{
		if(!isNullForString(s)){
			s = s.trim();
		}
		return s;
	}
	public static Timestamp getCurrentTimestamp(){
		Format sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		Timestamp createDate = Timestamp.valueOf(time);
		return createDate;
	}
	/**
	 * 将字符串转化为日期,字符串格式为yyyy-MM-dd hh:mm
	 * @param str
	 * @return Timestamp
	 */
	public static Timestamp convertFromStr_YMDHM(String str){
		Timestamp timestamp=null;
		if(!Utils.isNullForString(str)){
			try {
				SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date date = sdf.parse(str);
				timestamp=new Timestamp(date.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return timestamp;
	}
	/**
	 * 将字符串转化为日期,字符串格式为yyyy-MM-dd
	 * @param str
	 * @return Timestamp
	 */
	public static Timestamp convertFromStr_YMD2Ts(String str){
		Timestamp timestamp=null;
		if(!Utils.isNullForString(str)){
			try {
				SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(str);
				timestamp=new Timestamp(date.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return timestamp;
	}
	/**
	 * 将字符串转化为日期,字符串格式为yyyy-MM-dd hh:mm:ss
	 * @param str
	 * @return Date
	 */
	public static Date convertFromStr_YMDHMS(String str){
		Date date=null;
		if(!Utils.isNullForString(str)){
			try {
				SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				date = sdf.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}
	/**
	 * 将字符串转化为日期，字符串格式为 yyyyMMddHHmmss
	 * @param str
	 * @return Date
	 */
	public static Date convertFromStr_YMDHMS_NoSplit(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 将字符串转化为日期,字符串格式为yyyy-MM-dd hh:mm
	 * @param str
	 * @return Date
	 */
	public static Date convertFromStr_YMD(String str){
		Date date=null;
		if(!Utils.isNullForString(str)){
			try {
				SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
				date = sdf.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	/**
	 * 根据日期获得星期
	 * @param date
	 * @return
	 */
	public static String getWeekOfDate(Date date) {
		String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五","星期六" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return weekDaysName[intWeek];
	}
	/**
	 * 根据日期获得星期
	 * @param date
	 * @return
	 */
	public static String getWeekOfDate2(Date date) {
		String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return weekDaysCode[intWeek];
	}
	/**
	 * 获取一月的最后一天
	 * @param date
	 * @return
	 */
	public static Date lastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.roll(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }
	/**
	 * 获取一月的最后一天数字
	 * @param date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static int getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.roll(Calendar.DAY_OF_MONTH, -1);
        return  cal.getTime().getDate();
    }
	/**
	 * 将传入的Date加1天返回
	 * @param sourceDate 传入的Date
	 * @return 传入的Date加1天的日期。如传入的Date为空则返回null
	 */
	public static Date addOneDayOnDate(Date sourceDate)
	{
		Date addOneDay = null;
		if(sourceDate != null)
		{
			Calendar c = Calendar.getInstance();
	        c.setTime(sourceDate);   //设置当前日期
	        c.add(Calendar.DATE, 1); //日期加1
	        addOneDay = c.getTime(); //结果
		}
		return addOneDay;
	}
	/**
	 * 将传入的Date加1天返回
	 * @param sourceDate 传入的Date
	 * @param days 相加的天数
	 * @return 传入的Date加days天的日期。如传入的Date为空则返回null
	 */
	public static Date addDaysOnDate(Date sourceDate,int days)
	{
		Date addOneDay = null;
		if(sourceDate != null)
		{
			Calendar c = Calendar.getInstance();
	        c.setTime(sourceDate);   //设置当前日期
	        c.add(Calendar.DATE, days); //日期加days
	        addOneDay = c.getTime(); //结果
		}
		return addOneDay;
	}
	/**
	 * 将传入的timestamp加1天返回
	 * @param timestamp 传入的Timestamp
	 * @return 传入的Timestamp加1天的日期。如传入的Timestamp为空则返回null
	 */
	@SuppressWarnings("deprecation")
	public static Timestamp addOneDayOnTimestamp(Timestamp timestamp)
	{
		Timestamp addDaytimestamp = null;
		if(timestamp != null)
		{
			 timestamp.setDate(timestamp.getDate()+1);
			 addDaytimestamp=timestamp;
		}
		return addDaytimestamp;
	}
	/**
	 * 将Timestamp转化成字符串格式为yyyy-MM-dd hh:mm
	 * @param str
	 * @return String
	 */
	public static String convertFromTimestampToYMDHMStr(Timestamp time) {
		String str = null;
		if (time != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			str = sdf.format(time);
		}
		return str;
	}
	public static String convertFromTimestampToStr(Timestamp time) {
		String str = null;
		if (time != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			str = sdf.format(time);
		}
		return str;
	}
	/**
	 * 将Timestamp转化成字符串格式为yyyy-MM-dd
	 * @param str
	 * @return String
	 */
	public static String convertFromTimestampToYMDStr(Timestamp time) {
		String str = null;
		if (time != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			str = sdf.format(time);
		}
		return str;
	}
	/**
	 * 将Timestamp转化成字符串格式为yyyy-MM-dd
	 * @param str
	 * @return String
	 */
	public static String convertFromTimestampToYMStr(Timestamp time) {
		String str = null;
		if (time != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			str = sdf.format(time);
		}
		return str;
	}
	/**
	 * 将09:30:00这个时间加上分钟数后，又以字符串的格式返回，还回还是09:30:00这种格式
	 * @param time
	 * @param addMinute
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String timeAddMinutes(String time,int addMinute){
		String addStr=null;
		if(!Utils.isNullForString(time)){
			try {
				SimpleDateFormat  sdf = new SimpleDateFormat("HH:mm:ss");
				Date date = sdf.parse(time);
				date.setMinutes(date.getMinutes()+addMinute);
				addStr=sdf.format(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return addStr;
	}
	/**
	 * 获取beginDate和endDate之间相差的分钟数，beginDate和endDate的格式为HH:mm:ss，返回整数的分钟数
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getSumMinitues(String beginDate, String endDate) {
		Date d1 = null;
		Date d2 = null;
		try {
			SimpleDateFormat sim = new SimpleDateFormat("HH:mm:ss");
			d1 = sim.parse(beginDate);
			d2 = sim.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (null != d2 && null != d1)
			return (int) ((d2.getTime() - d1.getTime()) / (60 * 1000));
		return 0;
	}
	/**
	 * 将字符串从ISO8859_1转到UTF-8
	 * @param str
	 * @return
	 */
	public static String EncodeFromIsoToUTF8(String str){
		if(!Utils.isNullForString(str)){
			try {
				str=new String(str.getBytes("ISO8859_1"), "UTF8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
	/**
	 * 处理文件名在IE/FireFox下显示不正常的问题
	 * @param fileName
	 * @param request
	 * @return
	 */
	public static String formatFileName(String fileName,HttpServletRequest request) {
		 String filename = null;    
         try {
			String agent = request.getHeader("USER-AGENT");    
			 if (null != agent){    
			     if (-1 != agent.indexOf("Firefox")) {//Firefox    
			         filename = "=?UTF-8?B?" + (new String(org.apache.commons.codec.binary.Base64.encodeBase64(fileName.getBytes("UTF-8"))))+ "?=";    
			     }else if (-1 != agent.indexOf("Chrome")) {//Chrome    
			         filename = new String(fileName.getBytes(), "ISO8859-1");    
			     }else if (-1 != agent.indexOf("Safari")) {//Safari    
			    	 filename = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);    
			     } else {//IE7+    
			         filename = java.net.URLEncoder.encode(fileName, "UTF-8");    
			         filename = StringUtils.replace(filename, "+", "%20");//替换空格    
			     }    
			 } else {    
			     filename = fileName;    
			 }
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}    
         return filename;   
	}
	
	
	/**
	 * 将map转化成json字符格式
	 * @param map
	 * @return
	 */
	public static String convertMapToJson(Map<String,String> map){
		String jsonString="";
		if(map!=null&&map.size()>0){
    		JSONObject jsonObject = new JSONObject();
    		Set<String> set = map.keySet();
    		for(String key :set){
    			String value = map.get(key);
    			jsonObject.put(key, Utils.trimAndRowStr(value));
    		}
    		jsonString=jsonObject.toString();
    	}
		return jsonString;
	}
	
//	/**
//	 * 打印List里面对像的属性值和类型
//	 * @param List list数组
//	 */
//	@SuppressWarnings("rawtypes")
//	public static void PrintList(List list) {
//		for (int i = 0; i < list.size(); i++) {
//			print(list.get(i));
//		}
//	}

//	/**
//	 * 打印实体类里面的所有属性值和类型
//	 * @param Object t数组
//	 * @return void
//	 */
//	public static void print(Object t) {
//		if(t!=null){
//			Object o = t;// 将类赋给o
//			Method[] sourceMethods = o.getClass().getMethods();
//			for (int i = 0; i < sourceMethods.length; i++) {
//				if (sourceMethods[i].getName().startsWith("get")) {
//					String typeString = sourceMethods[i].getReturnType().getName(); // 类型
//					String type = getReturnType(typeString);
//					String filed = sourceMethods[i].getName().substring(3); // 属性
//					try {
//						String value;
//						if (sourceMethods[i].invoke(o, null) == null) {
//							value = "";
//						} else {
//							value = sourceMethods[i].invoke(o, null).toString();
//						}
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}
//	}

	
	/**
	 * 返回类型，功能性的，被其他函数调用
	 * @param Object type数组
	 * @return String
	 */
	public static String getReturnType(Object type) {
		String string = type.toString();
		int index = string.lastIndexOf(".") + 1;
		return string.substring(index);
	}

	/**
	 * 打印Map，注意，map里面的值，要么全为字符串内型，以键值对的形式打印出来；
	 *  为对像类型时，将对像类型的属性，属性值，属性类型均能打印出来。
	 * @param Map map数组
	 */
	@SuppressWarnings("rawtypes")
	public static void printMap(Map map) {
		Set set = map.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mapentry = (Map.Entry) iterator.next();
			String objectType = mapentry.getValue().getClass().toString();
			int lastIndex = objectType.lastIndexOf(".");
			String type = objectType.substring(lastIndex + 1, objectType
					.length());
			if (type.equals("String")) {
				System.out.println(mapentry.getKey() + " = "
						+ mapentry.getValue() + " "
						+ mapentry.getValue().getClass());
			} else {
				System.out.println("键为：" + mapentry.getKey() + " ;对像为："
						+ mapentry.getValue().getClass());
//				print(mapentry.getValue());
			}

		}
	}
	public static String trimAndRowStr(String s )
	{
		if(!isNullForString(s)){
			return s.trim();
		}
		return s;
	}
	
	/**
	 * 此方法，是从PreLoginAction中复制的
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");  
  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("Proxy-Client-IP");  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("WL-Proxy-Client-IP");  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("HTTP_CLIENT_IP");  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getRemoteAddr();  
            }  
        } else if (ip.length() > 15) {  
            String[] ips = ip.split(",");  
            for (int index = 0; index < ips.length; index++) {  
                String strIp = (String) ips[index];  
                if (!("unknown".equalsIgnoreCase(strIp))) {  
                    ip = strIp;  
                    break;  
                }  
            }  
        }  
        return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;  
    }  
	/**
	 * 将字符通过url解码
	 * @param string
	 * @return
	 */
	public static String decode(String string){
		String returnString=null;
		if(!Utils.isNullForString(string)){
			try {
				returnString = java.net.URLDecoder.decode(string, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return returnString;
	}
	
	/**
	 * 判断是否为空，如果为空，返回空字符串
	 * @param o
	 * @return
	 */
	public static String checkNull(Object o){
		String str="";
		if(o!=null&&!"".equals(o.toString())){
			str=o.toString();
		}
		return str;
	}
	/**
	 * 将BigDecimal格式化为两位小数据字符串输出
	 * @param b
	 * @return
	 */
	public static String formatBigDecimalToString(BigDecimal b){
		if(b!=null){
			DecimalFormat myformat=new DecimalFormat("0.00");
			String str = myformat.format(b);
			return str;
		}else{
			return null;
		}
	}
	/**
	 * 获取6位长度随机数
	 * @return
	 */
	public static String getRanod(){
		String s="100000";
		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			int num = r.nextInt(999999);
			if (num > 100000 && num < 999999) {
				s = String.valueOf(num);
				 break;
			}
		}
		return s;
	}
	/**
	 * 获取随机字母数字组合
	 * 
	 * @param length
	 *            字符串长度
	 * @return
	 */
	public static String getRandomCharAndNumr(Integer length) {
		StringBuffer str = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			boolean b = random.nextBoolean();
			if (b) { // 字符串
				// int choice = random.nextBoolean() ? 65 : 97; 取得65大写字母还是97小写字母
				str.append((char) (65 + random.nextInt(26)));// 取得大写字母
			} else { // 数字
				str.append(String.valueOf(random.nextInt(10)));
			}
		}
		return str.toString();
	}
	/**
	 * 获取随机数字组合
	 * @param length字符串长度
	 * @return
	 */
	public static String getRandomNumr(Integer length) {
		StringBuffer str = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			str.append(String.valueOf(random.nextInt(10)));
		}
		return str.toString();
	}
	
	public static String getLateVersion(List<String> versions) throws ParseException {
		String version = null;
		if (ListUtils.isNotEmpty(versions)) {
			Map<String, String> map = new HashMap<>();
			for (String s : versions) {
				map.put(s.substring(0, 6), s);
			}
			if (versions.size() == 1) {
				version = versions.get(0);
			} else {
				String lastVersion = versions.get(0);
				DateFormat df = new SimpleDateFormat("yyyyMMdd");
				Date lastDate = df.parse(lastVersion);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(lastDate);
				calendar.add(Calendar.MONTH, -2); // 查询2个月前的数据版本
				DateFormat dfs = new SimpleDateFormat("yyyyMM");
				String key = dfs.format(calendar.getTime());
				if (map.containsKey(key)) {
					version = map.get(key);
				} else {
					calendar.add(Calendar.MONTH, 1); // 没有2个月前的数据版本，查询上个月数据版本
					key = dfs.format(calendar.getTime());
					version = map.get(key);
				}
			}
		}
		return version;
	}
	
}
