package com.bbd.wtyh.service;

import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.UserInfoTableDo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户基本信息服务接口 Created by cgj on 2017/2/27.
 */
public interface UserInfoService extends BaseService {

	/**
	 * 创建用户
	 * 
	 * @param uitd
	 *            用户信息表
	 * @param resourceSet
	 *            用户权限集
	 * @throws Exception
	 *             各种不合规的参数引发的异常，包括加密转码、持久化对象的异常
	 */
	public void createUser(UserInfoTableDo uitd, String resourceSet) throws Exception;

	/**
	 * 更新用户信息
	 * 
	 * @param uitd
	 *            用户信息表
	 * @param resourceSet
	 *            用户权限集
	 * @throws Exception
	 *             各种不合规的参数引发的异常，包括加密转码、持久化对象的异常
	 */
	public void updateUserInfo(UserInfoTableDo uitd, String resourceSet) throws Exception;

	/**
	 * 通过登录名查询单条用户详情（包括用户权限），不分前后台，由调用者根据userType判断，例如'A'||'B'表明是
	 * 后台用户，'A'||'F'表明是前台用户，这样您可灵活使用
	 * 
	 * @param loginName
	 *            登录名 // @param foreYes 选择前（true）后（false）台用户
	 * @return 返回用户信息和含权限的完整字段
	 * @throws Exception
	 *             各种不合规的参数引发的异常，包括解密转码的异常
	 */
	// @Deprecated
	public Map<String, Object> getUserInfoByLoginName(
			String loginName /* , boolean foreYes */) throws Exception;

	/**
	 * 通过id查询单条用户详情（包括用户权限），不分前后台，由调用者根据userType判断，例如'A'||'B'表明是
	 * 
	 * @param id
	 *            用户记录表的id（主键）
	 * @return 返回用户信息和含权限的完整字段
	 * @throws Exception
	 *             各种不合规的参数引发的异常，包括解密转码的异常
	 */
	public Map<String, Object> getUserInfoById(int id) throws Exception;

	/**
	 * 通过用户名查询用户摘要信息
	 * 
	 * @param loginName
	 *            登录名
	 * @return ，目前返回的数据库中的字段有：id, user_type, fore_pwd, back_pwd
	 * @throws Exception
	 */
	public Map<String, Object> getUserInfoSummaryByLoginName(String loginName) throws Exception;

	/**
	 * 获取用户模板
	 * 
	 * @param loginName
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getUserTemplate(String loginName) throws Exception;

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
	 * 用户密码单向加密
	 * 
	 * @param plaintext
	 *            明文
	 * @return 加密后的密文
	 */
	public String userPasswordEncrypt(String plaintext);

	/**
	 * 列出上海行政区划表
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getShanghaiAreaCodeTable(String type) throws Exception;

	/**
	 *
	 * @param loginName
	 * @param password
	 * @param userType
	 *            "fore_pwd" or "back_pwd"
	 * @return
	 */
	public boolean compareUserNameMatchPassword(String loginName, String password, String userType) throws Exception;

	/**
	 * 判断用户密码是否过期，使用示例：
	 * userInfoService.testUserPasswordBeOverdue(userInfo.getBackPwdUpDate());
	 * userInfoService.testUserPasswordBeOverdue(userInfo.getForePwdUpDate());
	 * 
	 * @param fbPwdUpDate
	 *            传入前或后端最近修改密码的日期对象
	 * @return 0：正常； -1：新用户，需要立即更改密码； -2：用户未更新密码超过3个月
	 */
	public static int testUserPasswordBeOverdue(Date fbPwdUpDate) {
		if (null == fbPwdUpDate) { // 新用户，需要立即更改密码
			return -1;
		}
		Date nowTime = new Date();
		long dltTime = nowTime.getTime() - fbPwdUpDate.getTime();
		long threeMonth = (1000L * 3600 * 24 * 91); // 三个月的毫秒数
		if (dltTime > threeMonth) { // 用户未更新密码超过3个月
			return -2;
		}
		return 0; // 密码状态正常
	}

}
