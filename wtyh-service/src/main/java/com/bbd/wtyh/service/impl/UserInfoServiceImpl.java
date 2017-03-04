package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.UserInfoDo;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.mapper.UserInfoMapper;
import com.bbd.wtyh.util.CipherUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfo;
/*	@Autowired
	private RoleResourceService roleResourceService;*/ //TODO

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
/*		//创建孙黎明这边的权限项
		roleResourceService.addUserRoleResource(uitd , resourceSet, uitd.getCreateBy()); */ //TODO
	}

	/**
	 * 更新用户信息
	 * @param uIfDo
	 * @throws Exception
	 */
	@Override
	public void updateUserInfo(UserInfoDo uIfDo) throws Exception {
		if (StringUtils.isBlank(uIfDo.getLoginName()) || !rexCheckUserName( uIfDo.getLoginName() ) ) {
			throw new BusinessException("登录名为空或不合法");
		}
		List<Map<String, Object>> uPwdId =userInfo.selectUserPasswordAndId( uIfDo.getLoginName() );
		if( uPwdId.size() <1 ) {
			throw new BusinessException("登录名不存在！");
		}
		else if( uPwdId.size() >2 ) {
			throw new BusinessException("登录名同名用户数异常，请联系管理员排查！！");
		}
		if( StringUtils.isNotBlank(uIfDo.getNewLoginName()) ) { //新指定的登录名存在
			if(  !rexCheckUserName( uIfDo.getNewLoginName() )  ) {
				throw new BusinessException("新指定的登录名不合法");
			}
		}
		else { //新指定的登录名不存在
			uIfDo.setNewLoginName(null);
		}
		if( StringUtils.isBlank(uIfDo.getForePassword()) ) {
			uIfDo.setForePassword(null);
		}
		else if (!rexCheckPassword(uIfDo.getForePassword()) ) {
			throw new BusinessException("前端密码为空或不合法");
		}
		if( StringUtils.isBlank(uIfDo.getBackPassword()) ) {
			uIfDo.setForePassword(null);
		}
		else if (!rexCheckPassword(uIfDo.getBackPassword()) ) {
			throw new BusinessException("后端密码为空或不合法");
		}
		if (StringUtils.isBlank(uIfDo.getRealName())) {
			uIfDo.setRealName(null);
		}
		if (StringUtils.isBlank(uIfDo.getDepartment())) {
			uIfDo.setDepartment(null);
		}
		if (StringUtils.isBlank(uIfDo.getUpdateBy())) {
			throw new BusinessException("修改人为空");
		}

		UserInfoTableDo uit =new UserInfoTableDo();

		uit.setLoginName(uIfDo.getNewLoginName()); //待更新的登录名
		uit.setRealName(CipherUtils.encrypt(uIfDo.getRealName()));
		uit.setMobile(CipherUtils.encrypt(uIfDo.getMobile()));
		uit.setEmail(uIfDo.getEmail());
		uit.setDepartment(uIfDo.getDepartment());
		uit.setCreateBy(null);
		uit.setCreateDate(null);
		uit.setUpdateDate(new Date());
		uit.setUpdateBy(uIfDo.getUpdateBy());

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

	private String userPasswordEncrypt(String context) {
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
