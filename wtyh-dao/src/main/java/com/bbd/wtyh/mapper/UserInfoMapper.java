package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.UserInfoTableDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by cgj on 2017/2/29.
 */

public interface UserInfoMapper {

	public void saveU(UserInfoTableDo userInfoTableDo);

	public void updateU(UserInfoTableDo userInfoTableDo);

	public List<String> selectUserPassword(@Param("loginName") String loginName, @Param("type") String type);

	public List<Map<String, Object>> selectUserPasswordAndId(@Param("loginName") String loginName);

	public UserInfoTableDo selectForeUserInfoAll( @Param("loginName") String loginName );

	// List<UserInfoTableDo> findByPage(Map<String, Object> params);
}