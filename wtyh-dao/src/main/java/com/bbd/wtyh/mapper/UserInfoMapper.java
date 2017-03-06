package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.UserInfoTableDo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cgj on 2017/2/29.
 */

public interface UserInfoMapper {

	public void saveU(UserInfoTableDo userInfoTableDo);

	public void updateU(UserInfoTableDo userInfoTableDo);

	public UserInfoTableDo selectUserInfoAllByLoginName(@Param("loginName") String loginName ); //sued sun

	public UserInfoTableDo selectUserAllInfoById( @Param("id") Integer id );

	public List<Map<String, Object>> selectUserInfoSummaryByLoginName(@Param("loginName") String loginName);

	public Integer selectUserInfoTotalNum( );

	public List<Map<String, Object>> selectUserInfoList(HashMap<String, Object> params);

	public List<Map<String, Object>> selectUserTemplate (@Param("loginName") String loginName);

	public List<Map<String, Object>> selectShanghaiAreaCodeTable( );

	//public List<String> selectUserPassword(@Param("loginName") String loginName, @Param("type") String type);

//	public UserInfoTableDo selectForeUserInfoAll( @Param("loginName") String loginName ); //used sun

//	public UserInfoTableDo selectBackUserInfoAll( @Param("loginName") String loginName ); //sued sun

	// List<UserInfoTableDo> findByPage(Map<String, Object> params);
}