package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.vo.UseHotPage;
import com.bbd.wtyh.domain.vo.UserSearchVO;

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
	List<Map<String, Object>> selectlistUserOperaLog(Map<String, Object> params);

	List<UserSearchVO> findSearchList(Map<String, Object> params);

	List<UseHotPage> findHotPageList(Map<String, Object> params);
}