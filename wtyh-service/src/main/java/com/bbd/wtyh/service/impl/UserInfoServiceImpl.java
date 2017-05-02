package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.cachetobean.ShanghaiAreaCode;
import com.bbd.wtyh.common.comenum.UserType;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.service.RoleResourceService;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.mapper.UserInfoMapper;
import com.bbd.wtyh.util.CipherUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.Date;

/**
 * Created by cgj on 2017/2/27.
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Autowired
	private RoleResourceService roleResourceService;

	@Override
	public void createUser(UserInfoTableDo uitd, String resourceSet, String roleSet) throws Exception {
		if (null == uitd) {
			throw new BusinessException("用户信息表对象为空");
		}
		uitd.setId(null);
		uitd.setStatus(UserStatus.active.getStatusCode()); // 默认创建活动账户
		if (StringUtils.isBlank(uitd.getUserType())) {
			throw new BusinessException("用户状态为空");
		}
		if (StringUtils.isBlank(uitd.getLoginName()) || !rexCheckUserName(uitd.getLoginName())) {
			throw new BusinessException("新创建的登录名为空或不合法");
		}
		UserInfoTableDo utd = getOnlyUserInfoByLoginNameOrId(uitd.getLoginName(), -1);
		if (null != utd) {
			throw new BusinessException("新创建的登录名已存在");
		}
		if (StringUtils.isBlank(uitd.getRealName()) || !rexCheckUserName(uitd.getRealName())) {
			throw new BusinessException("真实姓名不合规");
		} else {
			// uitd.setRealName(CipherUtils.encrypt(uitd.getRealName()));
		}
		if (StringUtils.isBlank(uitd.getFixPhone())) {
			uitd.setFixPhone(null);
		} else {
			if (!rexCheckMobileNO(uitd.getFixPhone())) {
				throw new BusinessException("固话号码不合法");
			} else {
				uitd.setFixPhone(CipherUtils.encrypt(uitd.getFixPhone()));
			}
		}
		if (StringUtils.isBlank(uitd.getMobile())) {
			uitd.setMobile(null);
		} else {
			if (!rexCheckMobileNO(uitd.getMobile())) {
				throw new BusinessException("手机号码不合法");
			} else {
				uitd.setMobile(CipherUtils.encrypt(uitd.getMobile()));
			}
		}
		if (StringUtils.isBlank(uitd.getEmail())) {
			uitd.setEmail(null);
		} else {
			if (!rexCheckEmailAddress(uitd.getEmail())) {
				throw new BusinessException("电子信箱地址不合规");
			}
		}
		if (StringUtils.isBlank(uitd.getDepartment()) || !rexCheckUserName(uitd.getDepartment())) {
			throw new BusinessException("部门名称不合规");
		}
		if (StringUtils.isBlank(uitd.getAreaCode()) || !rexCheckAreaCode(uitd.getAreaCode())) {
			throw new BusinessException("地区代码不合规");
		}
		if (StringUtils.isBlank(uitd.getCreateBy()) || !rexCheckUserName(uitd.getCreateBy())) {
			throw new BusinessException("创建人为空");
		}
		uitd.setUpdateBy(uitd.getUpdateBy());

		UserType createType = UserType.getUserTypeByCode(uitd.getUserType());
		if( null ==createType ) {
			throw new BusinessException("系统中没有指定的用户类型");
		}
		if( UserType.SUPER_ADMIN.equals(createType) ) {
			throw new BusinessException("不能创建超管类型");
		}
		if( createType.isForeMask() ) { //用户类型包含前台属性
			uitd.setBackPwd("");
			if (StringUtils.isBlank(uitd.getForePwd()) || !rexCheckPassword(uitd.getForePwd()))
				throw new BusinessException("前台密码不合规");
			uitd.setForePwd(userPasswordEncrypt(uitd.getForePwd()));
		}
		if( createType.isBackMask() ) { //用户类型包含后台属性
			uitd.setForePwd("");
			if (StringUtils.isBlank(uitd.getBackPwd()) || !rexCheckPassword(uitd.getBackPwd()))
				throw new BusinessException("后台密码不合规");
			uitd.setBackPwd(userPasswordEncrypt(uitd.getBackPwd()));
		}
		uitd.setForePwdUpDate(null); // 创建时置空，表明此用户登录时需要提示用户立即修改密码，下同
		uitd.setBackPwdUpDate(null); //
		uitd.setCreateDate(new Date());
		uitd.setUpdateDate(uitd.getCreateDate());
		userInfoMapper.saveU(uitd);
		roleResourceService.saveUserRoleResource(uitd, roleSet, resourceSet, uitd.getCreateBy());
	}

	// 更新用户信息
	@Override
	public void updateUserInfo(UserInfoTableDo uitd) throws Exception {
		// long ms1 = (new Date()).getTime();
		if (null == uitd) {
			throw new BusinessException("传入的用户信息对象不能为空对象");
		}
		if (null == uitd.getId()) {
			throw new BusinessException("未指定待更新的用户信息的id");
		}
		UserInfoTableDo oldUitd = userInfoMapper.selectUserAllInfoById(uitd.getId());
		if (null == oldUitd) {
			throw new BusinessException("请求的用户id不存在");
		}
		UserType oldUserType = UserType.getUserTypeByCode(oldUitd.getUserType());
		if( null ==oldUserType ) {
			throw new BusinessException("指定Id对应的旧的用户类型无效，数据库可能被串改");
		}

		int updateCount = 0; // 更新条目计数器

		if( 1 !=uitd.getId() && !( oldUserType.equals(UserType.SUPER_ADMIN) ) ) { //超管不能更新花括号内的信息
			if (StringUtils.isBlank(uitd.getStatus())) {
				uitd.setStatus(null); // 不更新用户状态
			} else {
				if (null == UserStatus.getUserStatusByCode(uitd.getStatus())) {
					throw new BusinessException("用户状态参数不合规");
				}
				updateCount++;
			}

			if (true) { //按产品要求，本阶段开始不再更新登录名
				uitd.setLoginName(null);
			} else {
				if (StringUtils.isBlank(uitd.getLoginName())) {
					uitd.setLoginName(null); // 不更新登录名
				} else {
					if (!rexCheckUserName(uitd.getLoginName())) {
						throw new BusinessException("新指定的用户名不合规");
					}
					UserInfoTableDo utd = getOnlyUserInfoByLoginNameOrId(uitd.getLoginName(), -1);
					if (null != utd) {
						throw new BusinessException("新指定的登录名已存在");
					}
					updateCount++;
				}
			}

			if (StringUtils.isBlank(uitd.getRealName())) {
				uitd.setRealName(null); // 不更新真实姓名
			} else {
				if (!rexCheckUserName(uitd.getRealName())) {
					throw new BusinessException("新指定的真实姓名不合规");
				} else {
					//真名不加密了 uitd.setRealName( CipherUtils.encrypt(uitd.getRealName()) );
				}
				updateCount++;
			}

			if (StringUtils.isBlank(uitd.getDepartment())) {
				uitd.setDepartment(null); // 不更新部门
			} else {
				if (!rexCheckUserName(uitd.getDepartment())) {
					throw new BusinessException("新指定的部门名称不合规");
				}
				updateCount++;
			}

			if (StringUtils.isBlank(uitd.getAreaCode())) {
				uitd.setAreaCode(null); // 不更新区域代码
			} else {
				if (!rexCheckAreaCode(uitd.getAreaCode())) {
					throw new BusinessException("地区代码不合规");
				}
				updateCount++;
			}
		} else {
			uitd.setUserType(null); //超管不更新用户类型
		}

		if (null == uitd.getFixPhone()) {
			uitd.setFixPhone(null); // 不更新固定电话号码
		} else if (StringUtils.isEmpty(uitd.getFixPhone())) {
			uitd.setFixPhone(""); // 清除固定电话号码
		} else {
			if (!rexCheckMobileNO(uitd.getFixPhone())) {
				throw new BusinessException("新指定的固话号码不合规");
			} else {
				uitd.setFixPhone(CipherUtils.encrypt(uitd.getFixPhone()));
			}
			updateCount++;
		}

		if (null == uitd.getMobile()) {
			uitd.setMobile(null); // 不更新手机号码
		} else if (StringUtils.isEmpty(uitd.getMobile())) {
			uitd.setMobile(""); // 清除手机号码
		} else {
			if (!rexCheckMobileNO(uitd.getMobile())) {
				throw new BusinessException("新指定的手机号码不合规");
			} else {
				uitd.setMobile(CipherUtils.encrypt(uitd.getMobile()));
			}
			updateCount++;
		}

		if (null == uitd.getEmail()) {
			uitd.setEmail(null); // 不更新电子信箱
		} else if (StringUtils.isEmpty(uitd.getEmail())) {
			uitd.setEmail(""); // 清除电子信箱
		} else {
			if (!rexCheckEmailAddress(uitd.getEmail())) {
				throw new BusinessException("新指定的电子信箱地址不合规");
			}
			updateCount++;
		}

		///////以下是处理密码的代码
		boolean bForePwdUpMk =false; //前台密码更新标志
		boolean bBackPwdUpMk =false; //后台密码更新标志
		boolean oldBY = oldUserType.isBackMask(); // 旧的后台属性
		boolean oldFY = oldUserType.isForeMask(); // 旧的前台属性
		if (StringUtils.isBlank(uitd.getUserType())) { // 未指定userType
			uitd.setUserType(null);
			if ( oldFY && StringUtils.isNotBlank(uitd.getForePwd()) ) {
				bForePwdUpMk = true;
			}
			if ( oldBY && StringUtils.isNotBlank(uitd.getBackPwd()) ) {
				bBackPwdUpMk =true;
			}
		} else { // 已指定
			UserType modifyType = UserType.getUserTypeByCode(uitd.getUserType());
			if( null ==modifyType ) {
				//uitd.setUserType(null);
				throw new BusinessException("新指定的用户类型在系统中不存在");
			} else {
				updateCount++;
			}
			boolean newBY = modifyType.isBackMask(); // 新的后台属性
			boolean newFY = modifyType.isForeMask(); // 新的前台属性
			String newType = uitd.getUserType();
			// 处理前台密码
			if ( oldFY && newFY && StringUtils.isNotBlank(uitd.getForePwd()) ) { // 选择性更新
				bForePwdUpMk =true;
			} else if ( oldFY && !newFY ) {
				//{bForePwdUpMk =true; uitd.setForePwd("");}// 必须清除，但产品说不清除密码
			} else if ( !oldFY && newFY ) {
				if( StringUtils.isBlank(oldUitd.getForePwd()) && StringUtils.isBlank(uitd.getForePwd()) ) { // 必须更新
					throw new BusinessException("待更新的前台密码不能为空");
				}
				if ( StringUtils.isNotBlank(uitd.getForePwd()) ) {
					bForePwdUpMk =true;
				}
			} /*else { bForePwdUpMk =false;	}*/  // 不更新
			// 处理后台密码
			if ( oldBY && newBY && StringUtils.isNotBlank(uitd.getBackPwd()) ) { // 选择性更新
				bBackPwdUpMk =true;
			} else if ( oldBY && !newBY ) {
				//{bBackPwdUpMk =false; uitd.setBackPwd("");}// 必须清除，但产品说不清除密码
			} else if ( !oldBY && newBY ) {
				if( StringUtils.isBlank(oldUitd.getBackPwd()) && StringUtils.isBlank(uitd.getBackPwd()) ) {// 必须更新
					throw new BusinessException("待更新的后台密码不能为空");
				}
				if ( StringUtils.isNotBlank(uitd.getBackPwd()) ) {
					bBackPwdUpMk =true;
				}
			} /*else { bBackPwdUpMk =false;	}*/ // 不更新
		}
		Date updatePwdTime =new Date();
		if( ! uitd.getUpdateBy().equals(oldUitd.getLoginName()) ) { //不等即非自己修改了自己的密码即需要自己重新修改一次
			updatePwdTime =new Date(boTimeMk);
		}
		//对修改前端密码做最后处理
		if (bForePwdUpMk) {
			if (!rexCheckPassword(uitd.getForePwd())) {
				throw new BusinessException("待更新的前台密码不合规 ");
			} else {
				uitd.setForePwd(userPasswordEncrypt(uitd.getForePwd()));
				uitd.setForePwdUpDate(updatePwdTime);
				updateCount++;
			}
		} else {
			uitd.setForePwd(null); // 前端密码为空则不更新
		}
		//对修改后端密码做最后处理
		if(bBackPwdUpMk) {
			if (!rexCheckPassword(uitd.getBackPwd())) {
				throw new BusinessException("待更新的后台密码不合规 ");
			} else {
				uitd.setBackPwd(userPasswordEncrypt(uitd.getBackPwd()));
				uitd.setBackPwdUpDate(updatePwdTime);
				updateCount++;
			}
		} else {
			uitd.setBackPwd(null); //后端密码为空则不更新
		}

		// long ms2 = (new Date()).getTime();
		uitd.setCreateDate(null);
		uitd.setCreateBy(null);
		if (updateCount > 0) { // 更新用户信息
			if (StringUtils.isBlank(uitd.getUpdateBy()) || !rexCheckUserName(uitd.getUpdateBy())) {
				throw new BusinessException("修改人不能为空");
			}
			uitd.setUpdateDate(new Date());
			try {
				userInfoMapper.updateU(uitd);
			} catch (Exception ee) {
				throw new BusinessException("服务器异常(01)");
			}
		}
		// long ms3 = (new Date()).getTime();
		uitd.setLoginName(oldUitd.getLoginName()); //为后面可能调用权限角色方法准备的参数
		// long ms4 = (new Date()).getTime();
		/*
		 * System.out.println("ms2-1:" +(ms2-ms1)); System.out.println("ms3-2:"
		 * +(ms3-ms2)); System.out.println("ms4-3:" +(ms4-ms3));
		 */
	}

	// 更新用户信息和角色权限
	@Override
	public void updateUserInfoAndRoleResource(UserInfoTableDo uitd, String resourceSet, String roleSet) throws Exception {
		updateUserInfo(uitd);
		roleResourceService.saveUserRoleResource(uitd, roleSet, resourceSet, uitd.getUpdateBy());
	}

	@Override
	public void deleteUserById(Integer id) throws Exception {
		if (null == id) {
			throw new BusinessException("用户ID不能为空");
		}
		UserInfoTableDo uitd = userInfoMapper.selectUserAllInfoById(id);
		if (null == uitd) {
			throw new BusinessException("请求的用户id不存在");
		}
		UserType userType = UserType.getUserTypeByCode(uitd.getUserType());
		if( null ==userType ) {
			throw new BusinessException("指定Id对应的用户类型无效，数据库可能被串改，已拒绝删除操作");
		}
		if( 1 ==id || userType.equals(UserType.SUPER_ADMIN) ) { // 确保超管不被删除
			return;
		}
		userInfoMapper.deleteUser(id);
		roleResourceService.delUserRoleResource(uitd);
	}

	@Override
	public Map<String, Object> getUserInfoByLoginName(String loginName) throws Exception {
		if (StringUtils.isBlank(loginName) || !rexCheckUserName(loginName)) {
			throw new BusinessException("登录名为空或不合法");
		}
		return getUserInfoByLoginNameOrId(loginName, -1);
	}

	@Override
	public Map<String, Object> getUserInfoById(int id) throws Exception {
		return getUserInfoByLoginNameOrId(null, id);
	}

	private Map<String, Object> getUserInfoByLoginNameOrId(String loginName, int id) throws Exception {
		UserInfoTableDo uitd;
		if (StringUtils.isBlank(loginName)) { // loginName为空则使用id查询详情
			uitd = userInfoMapper.selectUserAllInfoById(id);
		} else {
			uitd = userInfoMapper.selectUserInfoAllByLoginName(loginName);
		}
		Map<String, Object> rstMap = null;
		if (null != uitd) {
			decryptUserInfo(uitd);
			// uitd.setStatus(null);
			uitd.setForePwd(null);
			uitd.setBackPwd(null);
			// uitd.setForePwdUpDate(null);
			// uitd.setBackPwdUpDate(null);
			rstMap = roleResourceService.getUserRoleResource(uitd.getId());
			rstMap.put("userInfo", uitd);
		}
		return rstMap;
	}

	@Override
	public UserInfoTableDo getOnlyUserInfoByLoginNameOrId(String loginName, int id) throws Exception {
		UserInfoTableDo uitd;
		if (StringUtils.isBlank(loginName) || !rexCheckUserName(loginName)) { // loginName为空则使用id查询详情
			uitd = userInfoMapper.selectUserAllInfoById(id);
		} else {
			uitd = userInfoMapper.selectUserInfoAllByLoginName(loginName);
		}
		if (null != uitd) {
			decryptUserInfo(uitd);
			// uitd.setStatus(null);
			// uitd.setForePwd(null);
			// uitd.setBackPwd(null);
		} // else throw new BusinessException("用户信息不存在");
		return uitd;
	}

	/*
	 * @Override public Map<String, Object> getUserInfoSummaryByLoginName(String
	 * loginName) throws Exception { if (StringUtils.isBlank(loginName) ||
	 * !rexCheckUserName(loginName)) { throw new BusinessException("登录名为空或不合法");
	 * } List<Map<String, Object>> lm =
	 * userInfoMapper.selectUserInfoSummaryByLoginName(loginName); if (lm.size()
	 * > 1) { throw new BusinessException("登录名同名用户数异常，请联系管理员排查！！"); } else if
	 * (lm.size() < 1) { throw new BusinessException("无此登录名对应的记录"); } return
	 * lm.get(0); }
	 */

	@Override
	public Map<String, Object> listUserInfo(String userStatus, List<String> userTypeSet, int areaCode, String selectType,
											String selectObject, int pageLimit, Integer pageNumber) throws Exception {
		if (pageLimit < 1) {
			throw new BusinessException("pageLimit参数小于1，无意义");
		}
		if ( StringUtils.isBlank(selectType) ) {
			throw new BusinessException("selectType的参数为空");
		}
		if (!selectType.equals("default") && !selectType.equals("loginName") && !selectType.equals("realName")
				&& !selectType.equals("department")) {
			throw new BusinessException("selectType参数不合法");
		}
		if (!selectType.equals("default") && StringUtils.isBlank(selectObject)) {
			// throw new BusinessException("selectObject参数不合法");
			selectType = "default";
		}

		HashMap<String, Object> params = new HashMap<String, Object>();
		if (null != UserStatus.getUserStatusByCode(userStatus)) {
			params.put("userStatus", userStatus);
		}
		if( null !=userTypeSet && userTypeSet.size() >0 )
		params.put("userTypeSet", userTypeSet);
		if (areaCode > 0) {
			params.put("areaCode", areaCode);
		}
		params.put(selectType, selectObject);
		params.put("pageLimit", pageLimit);
		List<Map<String, Object>> lm = userInfoMapper.selectUserInfoList(params); // 查询符合条件的记录总条数
		Long ltn = (Long) (lm.get(0).get("recordTotal"));
		int orderNum = 0;
		if ((null != pageNumber) && (pageNumber > 0)) {
			orderNum = (pageNumber - 1) * pageLimit;
			pageNumber = (pageNumber - 1) * pageLimit; // pageNumber的意义已经变为了“Offset”
			params.put("pageNumber", pageNumber);
		}
		params.put("listing", 1);
		lm = userInfoMapper.selectUserInfoList(params);
		UserInfoTableDo uitd = new UserInfoTableDo();
		for (Map<String, Object> itr : lm) {
			orderNum++;
			itr.put("orderNum", orderNum); // 加页面序号
			itr.put( "userStatus", UserStatus.getUserStatusNameByCode( (String)(itr.get("userStatus")) ) ); //状态代码转名称
			itr.put( "userType", UserType.getUserTypeNameByCode((String)(itr.get("userType"))) );
			Object obj = itr.get("areaCode");
			if (null != obj) { // 将区域代码转换成行政区名称
				try {
					int tmp = Integer.parseInt((String) obj);
					obj = ShanghaiAreaCode.getMap().get(tmp);
					if (null != obj) {
						itr.put("areaCode", obj);
					} else {
						itr.put("areaCode", "");
					}
				} catch (Exception e) {
					itr.put("areaCode", "");
				}
			} else {
				itr.put("areaCode", "");
			}
			Object tmpObj = itr.get("realName");
			if (null != tmpObj) {
				uitd.setRealName((String) tmpObj);
			}
			tmpObj = itr.get("fixPhone");
			if (null != tmpObj) {
				uitd.setFixPhone((String) tmpObj);
			}
			tmpObj = itr.get("mobile");
			if (null != tmpObj) {
				uitd.setMobile((String) tmpObj);
			}
			decryptUserInfo(uitd);
			itr.put("realName", uitd.getRealName());
			itr.put("fixPhone", uitd.getFixPhone());
			itr.put("mobile", uitd.getMobile());
		}
		Map<String, Object> rstMap = new HashMap<String, Object>();
		rstMap.put("listTotalNum", ltn);
		rstMap.put("list", lm);
		return rstMap;
	}

	@Override
	public List<Map<String, Object>> getUserTemplate(String loginName, String userTypeStr) throws Exception {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		params.put("userTypeStr", userTypeStr);
		List<Map<String, Object>> rstList = userInfoMapper.selectUserTemplate(params);
		// for( Map<String, Object> itr :rstList ) {
		// itr.put("")
		// }
		return rstList;
	}

	/*@Override
	public List<Map<String, Object>> getShanghaiAreaCodeTable(String type) throws Exception {
		List<Map<String, Object>> lm = userInfoMapper.selectShanghaiAreaCodeTable();
		if (null != lm) {
			for (Map<String, Object> iter : lm) {
				if (null != iter.get("areaId") && 104 == (Integer) iter.get("areaId")) {
					iter.put("cityName", "上海全区");
					break;
				}
			}

		}
		if (StringUtils.isNotBlank(type) && type.equals("0")) {
			Map<String, Object> allArea = new HashMap<String, Object>();
			allArea.put("areaId", (Integer) 0);
			allArea.put("cityName", "全部");
			lm.add(0, allArea);
		}
		return lm;
	}*/

	@Override
	public String userPasswordEncrypt(String plaintext) {
		return new SimpleHash("md5", plaintext, ByteSource.Util.bytes("123456"), 2).toHex();
	}

	@Override
	public boolean isUserNameMatchPassword(String loginName, String password, Operation.System sysType) throws Exception {
		return compareUserNameAndPassword(loginName, password, sysType) < 0 ? false : true;
	}

	@Override
	public boolean isUserDaoMatchPassword(UserInfoTableDo userDao, String password, Operation.System sysType) throws Exception {
		return compareUserDaoAndPassword(userDao, password, sysType) < 0 ? false : true;
	}

	@Override
	public int compareUserNameAndPassword(String loginName, String password, Operation.System sysType) throws Exception {
		if (StringUtils.isBlank(loginName))
			return -999; // 传入的参数不合法
		return compareUserDaoAndPassword(getOnlyUserInfoByLoginNameOrId(loginName, -1), password, sysType);
	}

	@Override
	public int compareUserDaoAndPassword(UserInfoTableDo userDao, String password, Operation.System sysType)
			throws Exception {
		if (StringUtils.isBlank(password))
			return -999; // 传入的参数不合法
		if (null == userDao) {
			return -5; // throw new BusinessException("数据库中不存在此用户(-5)");
		}
		if (null == userDao.getStatus() || !(UserStatus.active.getStatusCode().equals(userDao.getStatus()))) {
			return -4; // 用户非活动状态(-4)
		}
		UserType loginType =UserType.getUserTypeByCode(userDao.getUserType());
		if( null ==loginType ) {
			return -1999; //用户类型无效
		}
		if( ( sysType == Operation.System.front && !(loginType.isForeMask()) )
				||( sysType == Operation.System.back && !(loginType.isBackMask()) ) ) {
			return -3; // 用户类型和指定类型不匹配(-3)
		}
		String selPassword = null;
		if (sysType == Operation.System.front) {
			selPassword = userDao.getForePwd();
		} else if (sysType == Operation.System.back) {
			selPassword = userDao.getBackPwd();
		}
		if (StringUtils.isEmpty(selPassword))
			return -2; // 库中密码字符串为空(-2)
		return selPassword.equals(userPasswordEncrypt(password)) ? 0 : -1; // 密码校验成功(0)、不匹配(-1)
	}

	private static final long boTimeMk =(30L*3600*1000); //用于判断用户是否需要登录即修改密码的标记

	public String testUserPasswordBeOverdue(Date fbPwdUpDate) throws Exception {
		if ( null == fbPwdUpDate || fbPwdUpDate.getTime() <=boTimeMk ) { // 新用户首次登录 //
			return new String("firstTime");
		}
		LocalDateTime oldTime = LocalDateTime.ofInstant(fbPwdUpDate.toInstant(), ZoneId.systemDefault());
		int li = userInfoMapper.selectPwdLapseCycle();
		if (oldTime.plusMonths(li).isBefore(LocalDateTime.now())) { // 用户密码过期
			return new String("BeOverdue");
		}
		return new String("normal"); // 密码状态正常
	}

	/*
	 * public String testUserPasswordBeOverdue1(Date fbPwdUpDate) throws
	 * Exception { if (null == fbPwdUpDate) { // 新用户，需要立即更改密码 return new
	 * String("firstTime"); } Date nowTime = new Date(); long dltTime =
	 * nowTime.getTime() - fbPwdUpDate.getTime(); Integer li
	 * =userInfoMapper.selectPwdLapseCycle(); int pwdLapseCycle =li; //
	 * 用户密码失效的周期，单位是：月（计入闰年合年均730.5小时），由value1记录 long aMonthMs = (2629800000L
	 * *pwdLapseCycle);//730.5小时 =1000 *3600 *730.5 =2,629,800,000ms if (dltTime
	 * > aMonthMs) { // 用户未更新密码超期 return new String("BeOverdue"); } return new
	 * String("normal"); // 密码状态正常 }
	 */

	public Integer getAndSetPwdLapseCycle(Integer pwdLapseCycle) {
		if (null != pwdLapseCycle) {
			userInfoMapper.updatePwdLapseCycle(pwdLapseCycle);
		}
		return userInfoMapper.selectPwdLapseCycle();
	}

/*	 public static void main(String[] args) throws Exception {
	  //UserInfoService u1 = new UserInfoServiceImpl();
	  Date tsd =new Date();
	  tsd.setTime(0);
	  Thread.sleep(2000); byte aa =127;
	  while (true) { aa++; }
	}*/

	// 解密需要解密的用户数据
	private void decryptUserInfo(UserInfoTableDo uitd) throws Exception {
		if (null != uitd) {
			if (StringUtils.isNotBlank(uitd.getRealName())) {
				// uitd.setRealName(CipherUtils.decrypt(uitd.getRealName()));
			} else {
				uitd.setRealName(null);
			}
			if (StringUtils.isNotBlank(uitd.getMobile())) {
				uitd.setMobile(CipherUtils.decrypt(uitd.getMobile()));
			} else {
				uitd.setMobile(null);
			}
			if (StringUtils.isNotBlank(uitd.getFixPhone())) {
				uitd.setFixPhone(CipherUtils.decrypt(uitd.getFixPhone()));
			} else {
				uitd.setFixPhone(null);
			}
		}
	}

	/**
	 * 验证 登录名、真实姓名、创建人、部门及修改人
	 * 
	 * @param userName
	 * @return
	 */
	private boolean rexCheckUserName(String userName) {
		// 昵称格式：限30个字符，支持中英文、数字、减号或下划线
		String regStr = "^[\\u4e00-\\u9fa5_a-zA-Z0-9-]{1,30}$";
		return userName.matches(regStr);
	}

	/**
	 * 验证 Email 地址
	 * 
	 * @param emailAddress
	 * @return
	 */
	private boolean rexCheckEmailAddress(String emailAddress) {
		String regStr = "^([\\u4e00-\\u9fa5]|[a-z]|[A-Z]|[0-9]|[-_.@]){5,60}$";
		return emailAddress.matches(regStr);
	}

	/**
	 * 验证 电话号码
	 * 
	 * @param mobileNO
	 * @return
	 */
	private boolean rexCheckMobileNO(String mobileNO) {
		String regStr = "^[0-9-+ ]{1,30}$";
		return mobileNO.matches(regStr);
	}

	/**
	 * 验证 地区代码
	 * 
	 * @param areaCode
	 * @return
	 */
	private boolean rexCheckAreaCode(String areaCode) {
		String regStr = "^[0-9]{1,10}$";
		return areaCode.matches(regStr);
	}

	/**
	 * 正则表达式验证密码
	 * 
	 * @param input
	 * @return
	 */
	static private boolean rexCheckPassword(String input) { //用户密码的组成规则：英文+数字（8位到16位）
		boolean a =input.matches( "^(?=.*[0-9].*)(?=.*[A-Za-z].*)([A-Za-z0-9]{8,16})$" );
		//boolean a =input.matches( "^[A-Za-z0-9]{8,16}$" );
		//boolean b =input.matches( "^[A-Za-z]+$" ); 不对
		//boolean c =input.matches( "^\\d+$" ); 不对
		return a /*&& b && c*/;
	}

	/*
	 * 打印Map的key和value List<Map<String, Object>> lm =
	 * userInfoMapper.selectUserPassword1("admin511", "F"); for
	 * (Map<String,Object> mp : lm) { for (Map.Entry m : mp.entrySet()) {
	 * System.out.println("key:" + m.getKey() + "-----   value:" +
	 * m.getValue()); } }
	 */

	 public static void main(String args[]) throws Exception {
	 	System.out.println(rexCheckPassword("12345678") == false);
	 	System.out.println(rexCheckPassword("aaaaaaaa") ==false);
	 	System.out.println(rexCheckPassword("1234abc") ==false);
	 	System.out.println(rexCheckPassword("1234567890abcdefg") ==false);
	 	System.out.println(rexCheckPassword("1234567801234s") ==true);
	 	System.out.println(rexCheckPassword("B12345678") ==true);
	 	System.out.println(rexCheckPassword("1234$7890abcd") ==false);
	 	System.out.println(rexCheckPassword("1234567801234s") ==true);
	 	System.out.println(rexCheckPassword("B12345678") ==true);
	 	System.out.println(rexCheckPassword("1234abcd") ==true);
	 }
}
