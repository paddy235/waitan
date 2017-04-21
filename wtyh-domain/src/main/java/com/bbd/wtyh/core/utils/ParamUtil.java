package com.bbd.wtyh.core.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-04-20 9:38.
 */
public class ParamUtil {

	/**
	 * 获取所有请求参数
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> getRequestParamMap(HttpServletRequest request) {
		// 返回值Map
		Map<String, String> returnMap = new HashMap<>();
		for (Object parameter : request.getParameterMap().entrySet()) {
			Map.Entry entry = (Map.Entry) parameter;
			returnMap.put(entry.getKey().toString(), getParameterValue(entry.getValue()));
		}
		return returnMap;
	}

	private static String getParameterValue(Object valueObj) {
		if (null == valueObj) {
			return "";
		} else if (valueObj instanceof String[]) {
			if (ArrayUtils.isEmpty((String[]) valueObj)) {
				return "";
			}
			return StringUtils.join((String[]) valueObj, ",");
		} else {
			return valueObj.toString();
		}
	}
}
