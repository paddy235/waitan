package com.bbd.wtyh.service;

import com.bbd.wtyh.common.comenum.UserType;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.log.user.Operation;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户基本信息服务接口 Created by cgj on 2017/2/27.
 */
public interface UserInfoService extends BaseService {

	/*public static final*/ int superId =1; //超管的用户Id


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
	public void createUser(UserInfoTableDo uitd, String resourceSet, String roleSet) throws Exception;

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
	public void updateUserInfo(UserInfoTableDo uitd, String resourceSet, String roleSet) throws Exception;

	public void deleteUserById( Integer id ) throws Exception;

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
	 *
	 * @param loginName loginName为空则使用id查询详情
	 * @param id
	 * @return 返回UserInfoTableDo类型的用户详情
	 * @throws Exception
	 */
	public UserInfoTableDo getOnlyUserInfoByLoginNameOrId(String loginName, int id ) throws Exception;

//	/**
//	 * 通过用户名查询用户摘要信息
//	 *
//	 * @param loginName
//	 *            登录名
//	 * @return ，目前返回的数据库中的字段有：id, user_type, fore_pwd, back_pwd
//	 * @throws Exception
//	 */
//	 public Map<String, Object> getUserInfoSummaryByLoginName(String loginName) throws Exception;

	/**
	 * 获取用户模板
	 * 
	 * @param loginName
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getUserTemplate(String loginName, String userTypeStr) throws Exception;

	/**
	 *
	 * @param userStatus
	 * @param userType
	 * @param areaCode
	 * @param selectType
	 * @param selectObject
	 * @param pageLimit
	 * @param pageNumber
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> listUserInfo(String userStatus, String userType, int areaCode, String selectType,
											String selectObject, int pageLimit, Integer pageNumber) throws Exception ;

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
	 *用户密码匹配测试
	 * @param loginName
	 * @param password
	 * @param sysType 系统类型：前台或后台系统。用于指定提请数据库中前台或后台密码跟当前密码做比较。
	 * @return 匹配成功（true），失败（false）
	 */
	public boolean isUserNameMatchPassword(String loginName, String password, Operation.System sysType) throws Exception;

	public boolean isUserDaoMatchPassword(UserInfoTableDo userDao, String password, Operation.System sysType) throws Exception;

	/**
	 * 比较用户账户和密码是否正确
	 * @param loginName
	 * @param password
	 * @param sysType 系统类型：前台或后台系统。用于指定提请数据库中前台或后台密码跟当前密码做比较。
	 * @param auType 若非空，则会验证用户类型是否匹配
	 * @return 成功（0）；不匹配(-1)；库中密码字符串为空(-2)；用户类型和指定类型不匹配(-3)；用户处于非活动状态(-4)；
	 * 			用户不存在(-5)；传入的参数不合法(-999)
	 * @throws Exception
	 */
	public int compareUserNameAndPassword(String loginName, String password,  Operation.System sysType, UserType[] auType) throws Exception;

	/**
	 * 比较userDao对应的账户和密码是否正确
	 * @param userDao 传入对象
	 * @param password
	 * @param sysType 系统类型：前台或后台系统。用于指定提请数据库中前台或后台密码跟当前密码做比较。
	 * @param auType 若非空，则会验证用户类型是否匹配
	 * @return 成功（0）；不匹配(-1)；库中密码字符串为空(-2)；用户类型和指定类型不匹配(-3)；用户处于非活动状态(-4)；
	 * 			用户不存在(-5)；传入的参数不合法(-999)
	 * @throws Exception
	 */
	public int compareUserDaoAndPassword(UserInfoTableDo userDao, String password, Operation.System sysType, UserType[] auType) throws Exception;

	/**
	 * 判断用户密码是否过期，使用示例：
	 * userInfoService.testUserPasswordBeOverdue(userInfo.getBackPwdUpDate());
	 * userInfoService.testUserPasswordBeOverdue(userInfo.getForePwdUpDate());
	 *
	 * @param fbPwdUpDate 传入前台或后台用户最近修改密码的日期对象
	 * @return "normal"：正常； "firstTime"：新用户首次登录； "BeOverdue"：用户密码过期
	 * @throws Exception
	 */
	public String testUserPasswordBeOverdue(Date fbPwdUpDate) throws Exception;

	/**
	 * 获取和设置用户密码过期周期值
	 * @param pwdLapseCycle
	 * @return
	 */
	public Integer getAndSetPwdLapseCycle(Integer pwdLapseCycle);


	public enum UserStatus {
		lock("F", "锁定"),
		active("A", "激活");

		private String statusCode;
		private String StatusName;

		UserStatus(String statusCode, String statusName) {
			this.statusCode = statusCode;
			StatusName = statusName;
		}

		public String getStatusCode() {
			return statusCode;
		}

		public String getStatusName() {
			return StatusName;
		}

		static public UserStatus getUserStatusByCode(String stsCode) {
			if( null ==stsCode ) {
				return  null;
			}
			for( UserStatus us: UserStatus.values() ) {
				if( us.getStatusCode().equals(stsCode) ) {
					return  us;
				}
			}
			return null;
		}
	}

}
