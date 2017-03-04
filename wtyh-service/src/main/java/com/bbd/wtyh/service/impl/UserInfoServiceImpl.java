package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.service.RoleResourceService;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.mapper.UserInfoMapper;
import com.bbd.wtyh.util.CipherUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by cgj on 2017/2/27.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfo;
	@Autowired
	private RoleResourceService roleResourceService;

	@Override
	public void createUser(UserInfoTableDo uitd, String resourceSet) throws Exception {
		uitd.setId(null);
		uitd.setStatus("A");
		if (StringUtils.isBlank(uitd.getUserType())) {
			throw new BusinessException("用户状态为空");
		}
		if (StringUtils.isBlank(uitd.getLoginName()) || !rexCheckUserName( uitd.getLoginName() ) ) {
			throw new BusinessException("新建的登录名为空或不合法");
		}
		List<Map<String, Object>> uPwdId =userInfo.selectUserPasswordAndId( uitd.getLoginName() );
		if( uPwdId.size() >1 ) {
			throw new BusinessException("登录名同名用户数异常，请联系管理员排查！！");
		}
		else if( uPwdId.size() >0 ) {
			throw new BusinessException("新建的登录名已存在");
		}
		if (StringUtils.isBlank(uitd.getRealName()) || !rexCheckUserName(uitd.getRealName()) ) {
			throw new BusinessException("真实姓名为空或不合法");
		} else {
			uitd.setRealName(CipherUtils.encrypt(uitd.getRealName()));
		}
		if (StringUtils.isBlank(uitd.getMobile())) {
			uitd.setMobile(null);
		} else {
			if( !rexCheckMobileNO(uitd.getMobile()) ) {
				throw new BusinessException("手机号码不合法");
			} else {
				uitd.setMobile(CipherUtils.encrypt(uitd.getMobile()));
			}
		}
		if (StringUtils.isBlank(uitd.getEmail())) {
			uitd.setEmail(null);
		} else {
			if( !rexCheckMobileNO(uitd.getEmail()) ) {
				throw new BusinessException("电子信箱地址不合法");
			}
		}
		if (StringUtils.isBlank(uitd.getDepartment()) || !rexCheckUserName(uitd.getDepartment())) {
			throw new BusinessException("部门名称为空或不合法");
		}
		if (StringUtils.isBlank(uitd.getAreaCode()) || !rexCheckAreaCode(uitd.getAreaCode())) {
			throw new BusinessException("地区代码为空或不合法");
		}
		uitd.setCreateDate(new Date());
		if (StringUtils.isBlank(uitd.getCreateBy()) || !rexCheckUserName(uitd.getCreateBy())) {
			throw new BusinessException("创建人为空");
		}
		uitd.setUpdateDate(null);
		uitd.setUpdateBy(null);

		if( uitd.getUserType().equals("A") ) {
			if( StringUtils.isBlank(uitd.getForePwd()) || !rexCheckPassword(uitd.getForePwd()) )
				throw new BusinessException("前端密码为空或不合法");
			uitd.setForePwd(userPasswordEncrypt(uitd.getForePwd()));
			if( StringUtils.isBlank(uitd.getBackPwd()) || !rexCheckPassword(uitd.getBackPwd()) )
				throw new BusinessException("后端密码为空或不合法");
			uitd.setBackPwd(userPasswordEncrypt(uitd.getBackPwd()));
		} else if ( uitd.getUserType().equals("F") )	{
			if( StringUtils.isBlank(uitd.getForePwd()) || !rexCheckPassword(uitd.getForePwd()) )
				throw new BusinessException("前端密码为空或不合法");
			uitd.setForePwd(userPasswordEncrypt(uitd.getForePwd()));
			uitd.setBackPwd(null);
		} else if ( uitd.getUserType().equals("B") ) {
			uitd.setForePwd(null);
			if( StringUtils.isBlank(uitd.getBackPwd()) || !rexCheckPassword(uitd.getBackPwd()) )
				throw new BusinessException("后端密码为空或不合法");
			uitd.setBackPwd(userPasswordEncrypt(uitd.getBackPwd()));
		} else if ( uitd.getUserType().equals("U") ) {
			uitd.setForePwd(null);
			uitd.setBackPwd(null);
		} else  {
			throw new BusinessException("用户类型不合法");
		}
		userInfo.saveU(uitd);
		//创建孙黎明这边的权限项
		roleResourceService.addUserRoleResource(uitd , resourceSet, uitd.getCreateBy());
	}

	//更新用户信息
	@Override
	public void updateUserInfo(UserInfoTableDo uitd, String resourceSet) throws Exception {
		int updateCount =0; //更新条目计数器
		if( uitd.getId() ==null )
			throw new BusinessException("没有指定待更新的用户信息的id");

		if( StringUtils.isBlank(uitd.getStatus()) ) {
			uitd.setStatus(null); //不更新用户状态
		} else {
			if (!uitd.getStatus().equals("F") || !uitd.getStatus().equals("A")) {
				throw new BusinessException("用户状态参数不合法");
			}
			updateCount++;
		}

		if (StringUtils.isBlank(uitd.getLoginName()) ) {
			uitd.setLoginName(null); //不更新登录名
		} else {
			if (!rexCheckUserName(uitd.getLoginName())) {
				throw new BusinessException("新指定的登录名不合法");
			}
			List<Map<String, Object>> uPwdId =userInfo.selectUserPasswordAndId( uitd.getLoginName() );
			if( uPwdId.size() >1 ) {
				throw new BusinessException("登录名同名用户数异常，请联系管理员排查！！");
			}
			else if( uPwdId.size() >0 ) {
				throw new BusinessException("新指定的登录名已存在");
			}
			updateCount++;
		}

		if (StringUtils.isBlank(uitd.getRealName())) {
			uitd.setRealName(null); //不更新真实姓名
		} else {
			if( !rexCheckUserName(uitd.getRealName()) ) {
				throw new BusinessException("新指定的真实姓名不合法");
			} else {
				uitd.setRealName( CipherUtils.encrypt(uitd.getRealName()) );
			}
			updateCount++;
		}

		if (StringUtils.isBlank(uitd.getMobile())) {
			uitd.setMobile(null); //不更新手机号码
		} else {
			if( !rexCheckMobileNO(uitd.getMobile()) ) {
				throw new BusinessException("新指定的手机号码不合法");
			} else {
				uitd.setMobile(CipherUtils.encrypt(uitd.getMobile()));
			}
			updateCount++;
		}

		if (StringUtils.isBlank(uitd.getEmail())) {
			uitd.setEmail(null); //不更新电子信箱
		} else {
			if( !rexCheckMobileNO(uitd.getEmail()) ) {
				throw new BusinessException("新指定的电子信箱地址不合法");
			}
			updateCount++;
		}

		if (StringUtils.isBlank(uitd.getDepartment()) ) {
			uitd.setDepartment(null); // 不更新部门
		} else {
			if (!rexCheckUserName(uitd.getDepartment())) {
				throw new BusinessException("新指定的部门名称不合法");
			}
			updateCount++;
		}

		if (StringUtils.isBlank(uitd.getAreaCode()) ) {
			uitd.setAreaCode(null); //不更新区域代码
		} else {
			if (!rexCheckAreaCode(uitd.getAreaCode())) {
				throw new BusinessException("地区代码不合法");
			}
			updateCount++;
		}

		uitd.setCreateDate(null);
		uitd.setCreateBy(null);

		if (StringUtils.isBlank(uitd.getUserType())) {

		} else if( uitd.getUserType().equals("A") ) {
			if( StringUtils.isBlank(uitd.getForePwd()) || !rexCheckPassword(uitd.getForePwd()) )
				throw new BusinessException("前端密码为空或不合法 ");
			uitd.setForePwd(userPasswordEncrypt(uitd.getForePwd()));
			if( StringUtils.isBlank(uitd.getBackPwd()) || !rexCheckPassword(uitd.getBackPwd()) )
				throw new BusinessException("后端密码为空或不合法");
			uitd.setBackPwd(userPasswordEncrypt(uitd.getBackPwd()));
		} else if ( uitd.getUserType().equals("F") )	{
			if( StringUtils.isBlank(uitd.getForePwd()) || !rexCheckPassword(uitd.getForePwd()) )
				throw new BusinessException("前端密码为空或不合法 ");
			uitd.setForePwd(userPasswordEncrypt(uitd.getForePwd()));
			uitd.setBackPwd(null);
		} else if ( uitd.getUserType().equals("B") ) {
			uitd.setForePwd(null);
			if( StringUtils.isBlank(uitd.getBackPwd()) || !rexCheckPassword(uitd.getBackPwd()) )
				throw new BusinessException("后端密码为空或不合法 ");
			uitd.setBackPwd(userPasswordEncrypt(uitd.getBackPwd()));
		} else if ( uitd.getUserType().equals("U") ) {
			uitd.setForePwd(null);
			uitd.setBackPwd(null);
		} else  {
			throw new BusinessException("用户类型不合法");
		}




		uitd.setUpdateDate(new Date());
		if ( StringUtils.isBlank(uitd.getUpdateBy()) || !rexCheckUserName(uitd.getUpdateBy()) ) {
			throw new BusinessException("修改人为空");
		}

	}

	// @Override
	// public int deleteUser(String delType, Integer id) {
	//
	// }

/*	private int processUserInfo(UserInfoDo uIfDo) throws Exception {
		if (StringUtils.isBlank(opecode) || (!(opecode.equals("F")) && !(opecode.equals("B")) && (!opecode.equals("D")))) {
			//return -1; // 创建类型无效
            throw new BusinessException("创建类型无效");
		}
		if (StringUtils.isNotBlank(uIfDo.getPassword())) {
			uIfDo.setPassword(userPasswordEncrypt(uIfDo.getPassword()));
		} else {
			uIfDo.setPassword(null);
		}
		if (StringUtils.isNotBlank(secPassword)) {
			secPassword = userPasswordEncrypt(secPassword);
		} else {
			secPassword = null;
		}
		uIfDo.setRealName(CipherUtils.encrypt(uIfDo.getRealName())); // 加密真实用户名
		uIfDo.setMobile(CipherUtils.encrypt(uIfDo.getMobile())); // 加密手机号
		return 0;
	}*/

	public Map<String,Object> GetForeUserInfoByLoginName( String loginName ) throws Exception {
		UserInfoTableDo uInfo = userInfo.selectForeUserInfoAll(loginName);
		Set<String> rC = roleResourceService.queryResourceCodeByLoginName(loginName);
		Map<String,Object> rstMap =new HashMap<String, Object>();
		rstMap.put("userInfo",uInfo);
		rstMap.put("resourceCode",rC);
		return rstMap;
	}


	@Override
	public boolean compareUserNameMatchPassword(String loginName, String password, String type) {
		if (StringUtils.isBlank(loginName) || StringUtils.isBlank(password) || StringUtils.isBlank(type))
			return false; //用户输入的参数不合法
		String selPassword = (userInfo.selectUserPassword(loginName, type)).get(0);
		if (StringUtils.isEmpty(selPassword))
			return false; //数据库返回的结果为空
		if (password.equals( userPasswordEncrypt(selPassword)))
			return false; //密码不匹配
		return true;
	}

	public String userPasswordEncrypt(String context) {
		return new SimpleHash("md5", context, ByteSource.Util.bytes("123456"), 2).toHex();
	}

	/**
	 * 验证 登录名、真实姓名、创建人、部门及修改人
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
	 * @param emailAddress
	 * @return
	 */
	private boolean rexCheckEmailAddress(String emailAddress) {
		// 昵称格式：限30个字符，支持中英文、数字、减号、下划线或@
		String regStr = "^[\\u4e00-\\u9fa5_a-zA-Z0-9-@]{1,60}$";
		return emailAddress.matches(regStr);
	}

	/**
	 * 验证 电话号码
	 * @param mobileNO
	 * @return
	 */
	private boolean rexCheckMobileNO(String mobileNO) {
		// 昵称格式：限30个字符，支持数字、减号、加号或空格
		String regStr = "^[0-9-+ ]{1,30}$";
		return mobileNO.matches(regStr);
	}

	/**
	 * 验证 地区代码
	 * @param areaCode
	 * @return
	 */
	private boolean rexCheckAreaCode(String areaCode) {
		// 昵称格式：限30个字符，支持数字
		String regStr = "^[0-9]{1,10}$";
		return areaCode.matches(regStr);
	}

	/**
	 * 正则表达式验证密码
	 * @param input
	 * @return
	 */
	private boolean rexCheckPassword(String input) {
		//String reg = "^([A-Z]|[a-z]|[0-9]|[`-=[];,./~!@#$%^*()_+}{:?]){6,20}$";// 6-20 位，字母、数字、字符
		//String regStr = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]){6,20}$";
		//	用户密码的组成规则：英文+数字（8位到16位）
		String regStr = "^([A-Z]|[a-z]|[0-9]){8,16}$";
		return input.matches(regStr);
	}

		/* 打印Map的key和value
		List<Map<String, Object>> lm = userInfo.selectUserPassword1("admin511", "F");
		for (Map<String,Object> mp : lm) {
			for (Map.Entry m : mp.entrySet()) {
				System.out.println("key:" + m.getKey() + "-----   value:" + m.getValue());
			}
		}*/

/*	public static void main(String args[]) throws Exception {
		System.out.println(rexCheckPassword("111s"));
	}*/
}
