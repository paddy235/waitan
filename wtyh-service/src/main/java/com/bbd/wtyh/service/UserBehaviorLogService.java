package com.bbd.wtyh.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bbd.wtyh.core.base.BaseService;

/**
 * 用户基本信息服务接口 Created by cgj on 2017/2/27.
 */
public interface UserBehaviorLogService extends BaseService {

	public Map<String, Object> listUserBehaviorLog(int pageSize, Integer pageNumber, String userName, Integer areaCode,
												   Integer sysCode, Integer opTpCd, Integer opPgCd, Date beginTime,
												   Date endTime, Long logSN, String orderBy ) throws Exception;
}
