package com.bbd.wtyh.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bbd.wtyh.core.base.BaseService;

/**
 * 用户基本信息服务接口 Created by cgj on 2017/2/27.
 */
public interface UserBehaviorLogService extends BaseService {
	/**
	 *
	 * @param selectType
	 * @param selectObject
	 * @param pageLimit
	 * @param pageOffset
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> listUserInfo(int areaCode, String selectType, String selectObject, int pageLimit, Integer pageOffset)
			throws Exception;


	/**
	 * 列出上海行政区划表
	 * 
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> get(String type) throws Exception;

}
