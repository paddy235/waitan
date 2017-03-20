package com.bbd.wtyh.log.user.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLog;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 用户日志拦截器
 *
 * @author Created by LiYao on 2017-03-11 10:08.
 */
public class UserLogInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger("userLog");

	private Operation.System operationSys;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		LogRecord logRecord = this.logRecordAnnotation(handler);
		return request.getSession().getAttribute("loginUser") == null || logRecord == null || !logRecord.before()
				|| this.logRecord(request, logRecord);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		LogRecord logRecord = this.logRecordAnnotation(handler);
		if (logRecord == null || !logRecord.after()) {
			return;
		}
		this.logRecord(request, logRecord);
	}

	private boolean logRecord(HttpServletRequest request, LogRecord logRecord) {
		// 需要查询的参数。用于从请求中获取参数替换占位符
		String[] params = logRecord.params();
		// 用户操作类型
		Operation.Type operationType = logRecord.type();
		// 用户操作页面
		Operation.Page operationPage = logRecord.page();

		// 请求中的全部参数
		Map<String, String> paramMap = this.getParameterMap(request);
		// 替换占位符的具体内容数组
		Object[] placeholderReplace = new Object[params.length];
		for (int i = 0; i < params.length; i++) {
			placeholderReplace[i] = this.getParamValue(params[i], paramMap, request);
		}

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
		// 消息格式化，可能有%s占位符
		userLog.setLogContent(String.format(logRecord.logMsg(), placeholderReplace));

		userLog.setSysCode(operationSys.sysCode());
		userLog.setSysName(operationSys.sysName());

		userLog.setRequestIP(this.getRemoteAddress(request));
		userLog.setRequestURI(request.getRequestURI());

		if (operationPage.code() == 0) {
			Operation.Page oPage = (Operation.Page) request.getSession().getAttribute("pageHistory");
			userLog.setRequestCode(oPage != null ? oPage.code() : 0);
			userLog.setRequestDesc(oPage != null ? oPage.page() : "");
		} else {
			request.getSession().setAttribute("pageHistory", operationPage);
			userLog.setRequestCode(operationPage.code());
			userLog.setRequestDesc(operationPage.page());
		}

		userLog.setRequestParam(paramMap);

		// 日志记录
		logger.info(JSON.toJSONString(userLog, SerializerFeature.WriteDateUseDateFormat));

		// TODO
		System.err.println(JSON.toJSONString(userLog, SerializerFeature.PrettyFormat, SerializerFeature.WriteDateUseDateFormat));

		return true;
	}

	/**
	 * 获取参数值。取值顺序<br>
	 * 1.请求参数中获取<br>
	 * 2.request域中获取<br>
	 * 3.session域中获取
	 * 
	 * @param paramName
	 *            参数名
	 * @param paramMap
	 *            全部请求参数集合
	 * @param request
	 *            request
	 * @return paramValue
	 */
	private Object getParamValue(String paramName, Map<String, String> paramMap, HttpServletRequest request) {
		if (paramName == null) {
			return null;
		}
		Object paramValue = paramMap.get(paramName);
		paramValue = this.paramValueIsBlank(paramValue, request.getAttribute(paramName));
		paramValue = this.paramValueIsBlank(paramValue, request.getSession().getAttribute(paramName));

		if (paramValue != null && !"".equals(paramValue)) {
			return paramValue;
		}

		// 处理从对象中获取参数的情况。如：loginUser.loginName
		String[] strs = paramName.split("\\.");
		if (strs.length <= 1) {
			return paramValue;
		}
		paramName = strs[0];
		String jsonStr = JSON.toJSONString(paramMap.get(paramName));
		jsonStr = jsonStrIsBlank(jsonStr, request.getAttribute(paramName));
		jsonStr = jsonStrIsBlank(jsonStr, request.getSession().getAttribute(paramName));

		if ("\"\"".equals(jsonStr) || "null".equals(jsonStr)) {
			return "";
		}

		try {
			return JSON.parseObject(jsonStr).get(strs[1]);
		} catch (Exception e) {
			return null;
		}

	}

	private Object paramValueIsBlank(Object pv1, Object pv2) {
		if (pv1 == null || "".equals(pv1)) {
			return pv2;
		}
		return pv1;
	}

	private String jsonStrIsBlank(String jsonStr, Object obj) {
		if ("\"\"".equals(jsonStr) || "null".equals(jsonStr)) {
			return JSON.toJSONString(obj);
		}
		return jsonStr;
	}

	private LogRecord logRecordAnnotation(Object handler) {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		return method.getAnnotation(LogRecord.class);
	}

	private String getRemoteAddress(HttpServletRequest request) {
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

	private Map<String, String> getParameterMap(HttpServletRequest request) {
		// 返回值Map
		Map<String, String> returnMap = new HashMap<>();
		for (Object parameter : request.getParameterMap().entrySet()) {
			Map.Entry entry = (Map.Entry) parameter;
			returnMap.put(entry.getKey().toString(), getParameterValue(entry.getValue()));
		}
		return returnMap;
	}

	private String getParameterValue(Object valueObj) {
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

	/**
	 * 设置
	 *
	 * @param operationSys
	 */
	@SuppressWarnings("unused")
	public void setOperationSys(Operation.System operationSys) {
		this.operationSys = operationSys;
	}
}
