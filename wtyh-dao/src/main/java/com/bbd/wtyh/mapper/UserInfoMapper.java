package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.UserInfoTableDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {

	// UserInfoTableDo selectByPrimaryKey(@Param("companyName") String companyName,
	// @Param("area") String area);

	public void saveU(UserInfoTableDo userInfoTableDo);

	public void updateU(UserInfoTableDo userInfoTableDo);

	public List<String> selectUserPassword(@Param("loginName") String loginName, @Param("type") String type);

	public List<Map<String, Object>> selectUserPasswordAndId(@Param("loginName") String loginName);

	// List<UserInfoTableDo> findByPage(Map<String, Object> params);
}