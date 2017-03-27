package com.bbd.wtyh.log.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bbd.wtyh.domain.UserInfoTableDo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 用户日志记录
 *
 * @author Created by LiYao on 2017-03-23 16:45.
 */
public class UserLogRecord {

	private static final Logger LOGGER = LoggerFactory.getLogger("userLog");

	public static void record(String msg, Operation.Type operationType, Operation.Page operationPage, Operation.System operationSys,
			HttpServletRequest request) {
		record(msg, operationType, operationPage, operationSys, getParameterMap(request), request);

	}

	public static void record(String msg, Operation.Type operationType, Operation.Page operationPage, Operation.System operationSys,
			Map<String, String> paramMap, HttpServletRequest request) {

		UserInfoTableDo user = (UserInfoTableDo) request.getSession().getAttribute("loginUser");
		UserLog userLog = new UserLog();
		userLog.setUuid(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		userLog.setOperator(user == null ? "" : user.getLoginName());
		userLog.setRealName(user == null ? "" : user.getRealName());
		userLog.setDepartment(user == null ? "" : user.getDepartment());
		userLog.setAreaCode(user == null ? "" : user.getAreaCode());
		userLog.setOperationDate(new Date());
		userLog.setOperationType(operationType.code());
		userLog.setOperationDesc(operationType.desc());

		userLog.setLogContent(msg);

		userLog.setSysCode(operationSys.sysCode());
		userLog.setSysName(operationSys.sysName());

		userLog.setRequestIP(getRemoteAddress(request));
		userLog.setRequestURI(request.getRequestURI());

		if (operationPage.code() == 0) {
			Operation.Page oPage = (Operation.Page) request.getSession().getAttribute("pageHistory");
			userLog.setRequestCode(oPage != null ? oPage.code() : Operation.Page.blank.code());
			userLog.setRequestDesc(oPage != null ? oPage.page() : Operation.Page.blank.page());
		} else {
			request.getSession().setAttribute("pageHistory", operationPage);
			userLog.setRequestCode(operationPage.code());
			userLog.setRequestDesc(operationPage.page());
		}

		userLog.setRequestParam(paramMap);

		// 日志记录
		LOGGER.info(JSON.toJSONString(userLog, SerializerFeature.WriteDateUseDateFormat));
	}

	private static String getRemoteAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (StringUtils.isBlank(ip) || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isBlank(ip) || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isBlank(ip) || ip.equalsIgnoreCase("unknown")) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static Map<String, String> getParameterMap(HttpServletRequest request) {
		// 返回值Map
		Map<String, String> returnMap = new HashMap<>();
		for (Object parameter : request.getParameterMap().entrySet()) {
			Map.Entry entry = (Map.Entry) parameter;
			returnMap.put(entry.getKey().toString(), getParameterValue(entry.getValue()));
		}
		return returnMap;
	}

	private static String getParameterValue(Object valueObj) {
		StringBuilder sb = new StringBuilder();
		if (null == valueObj) {
			return "";
		} else if (valueObj instanceof String[]) {
			for (String values : (String[]) valueObj) {
				sb.append(",").append(values);
			}
			return sb.substring(1);
		} else {
			return valueObj.toString();
		}
	}
}
