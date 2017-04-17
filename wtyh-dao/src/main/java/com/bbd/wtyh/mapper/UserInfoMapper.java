package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.UserInfoTableDo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cgj on 2017/2/29.
 */

public interface UserInfoMapper {

	public void saveU(UserInfoTableDo userInfoTableDo);

	public void updateU(UserInfoTableDo userInfoTableDo);

	//@Delete("DELETE FROM zt_user_info WHERE id =#{id}")
	public void deleteUser( @Param("id") Integer id );

	public UserInfoTableDo selectUserInfoAllByLoginName(@Param("loginName") String loginName ); //sued sun

	public UserInfoTableDo selectUserAllInfoById( @Param("id") Integer id );

	//public List<Map<String, Object>> selectUserInfoSummaryByLoginName(@Param("loginName") String loginName);

	//public Integer selectUserInfoTotalNum( );

	public List<Map<String, Object>> selectUserInfoList(HashMap<String, Object> params);

/*	public List<Map<String, Object>> selectUserTemplate (@Param("loginName") String loginName,
														 @Param("userTypeStr") String userTypeStr);*/
	public List<Map<String, Object>> selectUserTemplate (HashMap<String, Object> params);

	public List<Map<String, Object>> selectShanghaiAreaCodeTable( );

	public Integer selectPwdLapseCycle( );

	public void updatePwdLapseCycle(@Param("valueA") Integer valueA);

	//public List<String> selectUserPassword(@Param("loginName") String loginName, @Param("type") String type);

//	public UserInfoTableDo selectForeUserInfoAll( @Param("loginName") String loginName ); //used sun

//	public UserInfoTableDo selectBackUserInfoAll( @Param("loginName") String loginName ); //sued sun

	// List<UserInfoTableDo> findByPage(Map<String, Object> params);
}