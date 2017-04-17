package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.log.user.UserLog;
import com.bbd.wtyh.service.LogInfoService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/3/18 0018.
 */
@Service
public class LogInfoServiceImpl extends BaseServiceImpl implements LogInfoService {

	@Value("${tomcat.root}")
	private String userActionLogDir;

	Logger logger = LoggerFactory.getLogger(LogInfoServiceImpl.class);

	/**
	 * 将日志文件导入数据库
	 */
	@Override
	public Long exportLogFileToDataBase(String operDate, Long counts) {
		String date = null;
		if (null == operDate) {
			// 定时任务
			date = getPreDay(1);// 处理当前日期前一天的数据
		} else {
			// 手动调用
			date = operDate;
		}
		String logPath = userActionLogDir + File.separator + "userLogs";
		logger.info("将日志文件导入数据库,日志文件路径：" + logPath);
		File fileDir = new File(logPath);
		if (!fileDir.isDirectory()) {
			// fileDir .mkdir(); //创建目录
			logger.info("将日志文件导入数据库:日志文件路径不存在");
			return counts;
		}

		String tempDate = date.replace("-", "").substring(2);
		String[] list;
		String pattern = "^userLog_" + date + "_\\d+.log$";// 匹配
															// userLog_2017-03-18_数字
		list = fileDir.list(filter(pattern));
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		logger.info("将日志文件导入数据库，文件数量：" + ((null != list) ? list.length : 0));
		for (String string : list) {
			counts = loadLogFromFile(logPath + File.separator + string, tempDate, counts);
		}
		return counts;// 返回全局号码，供后续接口使用
	}

	/**
	 * 把日志文件导入数据库
	 */
	public Long loadLogFromFile(String filePath, String logNumDate, Long counts) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		List<UserLog> userLogList = new ArrayList<UserLog>();
		BufferedReader reader = null;
		BufferedWriter writer = null;
		String errFilePath = filePath + ".error";

		try {
			// 读取日志文件
			File fileSource = new File(filePath);
			if (!fileSource.exists()) {
				return counts;
			}
			// 先删除错误日志
			File errFile = new File(errFilePath);
			if (errFile.exists()) {
				errFile.delete();
			}
			InputStreamReader isr = new InputStreamReader(new FileInputStream(fileSource), "UTF-8");
			reader = new BufferedReader(isr);
			String tempString = null;
			tempString = reader.readLine();
			// 一次读入一行，直到读入null为文件结束

			while (tempString != null) {

				if (null == tempString || tempString.equals("")) {
					continue;
				}

				try {
					UserLog userLog = JSON.parseObject(tempString, UserLog.class);

					userLog.setLogNum(Long.parseLong(logNumDate + StringUtils.leftPad(counts.toString(), 6, "0")));
					counts++;
					userLogList.add(userLog);
				} catch (Exception e) {
					list.add(tempString);
					e.printStackTrace();
				}

				if (userLogList.size() >= 1000) {
					addLogs(userLogList);
					userLogList.clear();
				}

				tempString = reader.readLine();
			}
			addLogs(userLogList);
			userLogList.clear();
			reader.close();

			// 备份出错的行到error文件
			if (list.size() > 0) {
				File newErrFile = new File(filePath + ".error");
				OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(newErrFile), "UTF-8");
				writer = new BufferedWriter(osw);
				for (String str : list) {
					if (null != str && !str.equals("")) {
						writer.write(str);
						writer.newLine();
					}

				}
				writer.flush();
				writer.close();
			}

		} catch (Exception e) {
			logger.error("日志入库异常", e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e1) {
				}
			}
		}
		return counts;
	}

	private void addLogs(List<UserLog> list) {
		// TODO Auto-generated method stub
		try {
			insertList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 取当前日期之前后者之后某一天
	 **/
	private static String getPreDay(int size) {
		String preDay = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, -size);
			Date today = c.getTime();
			preDay = sdf.format(today);

		} catch (Exception e) {
		}
		return preDay;
	}

	public static FilenameFilter filter(final String regex) {

		return new FilenameFilter() {

			private Pattern pattern = Pattern.compile(regex);

			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		};
	}

}
