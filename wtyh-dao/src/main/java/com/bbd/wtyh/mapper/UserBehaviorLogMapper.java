package com.bbd.wtyh.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bbd.wtyh.domain.UserInfoTableDo;

/**
 * Created by cgj on 2017/3/20.
 */

public interface UserBehaviorLogMapper {

	public List<Map<String, Object>> selectUserBehaviorLogList(HashMap<String, Object> params);

	//public List<Map<String, Object>> selectUserTemplate(@Param("loginName") String loginName);

	// List<UserInfoTableDo> findByPage(Map<String, Object> params);
}