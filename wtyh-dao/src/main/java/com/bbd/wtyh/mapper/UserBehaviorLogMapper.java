package com.bbd.wtyh.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by cgj on 2017/3/20.
 */

public interface UserBehaviorLogMapper {

	List<Map<String, Object>> selectUserBehaviorLogList(Map<String, Object> params);

	// public List<Map<String, Object>> selectUserTemplate(@Param("loginName")
	// String loginName);

	// List<UserInfoTableDo> findByPage(Map<String, Object> params);
}