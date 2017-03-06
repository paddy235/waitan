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
	private UserInfoMapper userInfoMapper;

	@Autowired
	private RoleResourceService roleResourceService;

	@Override
	public void createUser(UserInfoTableDo uitd, String resourceSet) throws Exception {
		if( null ==uitd ) {
			throw new BusinessException("用户信息表对象为空");
		}
		uitd.setId(null);
		uitd.setStatus("A");
		if (StringUtils.isBlank(uitd.getUserType())) {
			throw new BusinessException("用户状态为空");
		}
		if (StringUtils.isBlank(uitd.getLoginName()) || !rexCheckUserName( uitd.getLoginName() ) ) {
			throw new BusinessException("新建的登录名为空或不合法");
		}
		List<Map<String, Object>> uPwdId = userInfoMapper.selectUserInfoSummaryByLoginName( uitd.getLoginName() );
		if( uPwdId.size() >1 ) {
			throw new BusinessException("登录名同名用户数异常，请联系管理员排查！！");
		}
		else if( uPwdId.size() >0 ) {
			throw new BusinessException("新建的登录名已存在");
		}
		if (StringUtils.isBlank(uitd.getRealName()) || !rexCheckUserName(uitd.getRealName()) ) {
			throw new BusinessException("真实姓名为空或不合法");
		} else {
			//uitd.setRealName(CipherUtils.encrypt(uitd.getRealName()));
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
			if( !rexCheckEmailAddress(uitd.getEmail()) ) {
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
		uitd.setUpdateDate(uitd.getCreateDate());
		uitd.setUpdateBy(uitd.getUpdateBy());

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
			uitd.setBackPwd("");
		} else if ( uitd.getUserType().equals("B") ) {
			uitd.setForePwd("");
			if( StringUtils.isBlank(uitd.getBackPwd()) || !rexCheckPassword(uitd.getBackPwd()) )
				throw new BusinessException("后端密码为空或不合法");
			uitd.setBackPwd(userPasswordEncrypt(uitd.getBackPwd()));
		} else if ( uitd.getUserType().equals("U") ) {
			uitd.setForePwd("");
			uitd.setBackPwd("");
		} else  {
			throw new BusinessException("用户类型不合法");
		}
		userInfoMapper.saveU(uitd);
		//创建孙黎明这边的权限项
		roleResourceService.addUserRoleResource(uitd , resourceSet, uitd.getCreateBy());
	}

	//更新用户信息
	@Override
	public void updateUserInfo(UserInfoTableDo uitd, String resourceSet) throws Exception {
		if( null ==uitd ) {
			throw new BusinessException("用户信息表对象为空");
		}
		if( null==uitd.getId() ) {
			throw new BusinessException("没有指定待更新的用户信息的id");
		}
		UserInfoTableDo selUitd = userInfoMapper.selectUserAllInfoById(uitd.getId());
		if( null ==selUitd ) {
			throw new BusinessException("提供的用户id不存在");
		}

/*		if ( StringUtils.isNotBlank(uitd.getForePwd()) 	&&(selUitd.getUserType().equals("F")||selUitd.getUserType().equals("A"))  )
		{ //前端修改密码，验证原密码
			if (StringUtils.isBlank(uitd.getOldPwd())) {
				throw new BusinessException("原密码不合法");
			}
			if( null ==selUitd ) {
				throw new BusinessException("未找到待更新的记录");
			}
			if( StringUtils.isBlank(selUitd.getForePwd()) ||
					!(selUitd.getForePwd().equals( userPasswordEncrypt(uitd.getOldPwd())))	) {
				throw new BusinessException("原密码校验失败");
			}
			uitd.setOldPwd(null); //后面不在需要此字段
		}*/

		int updateCount =0; //更新条目计数器

		if( StringUtils.isBlank(uitd.getStatus()) ) {
			uitd.setStatus(null); //不更新用户状态
		} else {
			if (!uitd.getStatus().equals("F") && !uitd.getStatus().equals("A")) {
				throw new BusinessException("用户状态参数不合法");
			}
			if ( ( uitd.getStatus().equals("F") )&&( 1 == uitd.getId()) ) { // id号为1的为超级管理员，禁止删除
				throw new BusinessException("supper管理员，禁止删除！");
			}
			updateCount++;
		}

		if (StringUtils.isBlank(uitd.getLoginName()) ) {
			uitd.setLoginName(null); //不更新登录名
		} else {
			if (!rexCheckUserName(uitd.getLoginName())) {
				throw new BusinessException("新指定的登录名不合法");
			}
			List<Map<String, Object>> uPwdId = userInfoMapper.selectUserInfoSummaryByLoginName( uitd.getLoginName() );
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
				//uitd.setRealName( CipherUtils.encrypt(uitd.getRealName()) );
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
			if( !rexCheckEmailAddress(uitd.getEmail()) ) {
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

		String uType =selUitd.getUserType();
		boolean oldBY =false; //旧的后台属性
		boolean oldFY =false; //旧的前台属性
		if( uType.equals("A") || uType.equals("B" ) ){
			oldBY =true;
		}
		if(  uType.equals("A") || uType.equals("F" ) ) {
			oldFY =true;
		}
		if (StringUtils.isBlank(uitd.getUserType())) { //未指定userType
			uitd.setUserType(null);
			if( true ==oldFY )	{
				if( StringUtils.isBlank(uitd.getForePwd()) ) {
					uitd.setForePwd(null); //前端密码为空则不更新
				} else {
					if( !rexCheckPassword(uitd.getForePwd()) ) {
						throw new BusinessException("前台密码不合法 ");
					} else {
						uitd.setForePwd(userPasswordEncrypt(uitd.getForePwd()));
						updateCount++;
					}
				}
			} else {
				uitd.setForePwd(null);
			}
			if( true ==oldBY )	{
				if( StringUtils.isBlank(uitd.getBackPwd()) ) {
					uitd.setBackPwd(null); //前端密码为空则不更新
				} else {
					if( !rexCheckPassword(uitd.getBackPwd()) ) {
						throw new BusinessException("后台密码不合法 ");
					} else {
						uitd.setBackPwd(userPasswordEncrypt(uitd.getBackPwd()));
						updateCount++;
					}
				}
			} else {
				uitd.setBackPwd(null);
			}
		} else { //已指定
			boolean newBY = false; //新的后台属性
			boolean newFY = false; //新的前台属性
			String newType = uitd.getUserType();
			if (newType.equals("A") || newType.equals("B")) {
				newBY = true;
			}
			if (newType.equals("A") || newType.equals("F")) {
				newFY = true;
			}
			//处理前台密码
			if ((true == oldFY) && (true == newFY)) { //选择性更新
				if (StringUtils.isBlank(uitd.getForePwd())) {
					uitd.setForePwd(null); //前端密码为空则不更新
				} else {
					if (!rexCheckPassword(uitd.getForePwd())) {
						throw new BusinessException("待更新的前台密码不合法 ");
					} else {
						uitd.setForePwd(userPasswordEncrypt(uitd.getForePwd()));
						updateCount++;
					}
				}
			} else if ((true == oldFY) && (false == newFY)) { //必须更新
				uitd.setForePwd("");
				updateCount++;
			} else if ((false == oldFY) && (true == newFY)) { //必须更新
				if (StringUtils.isBlank(uitd.getForePwd()) || !rexCheckPassword(uitd.getForePwd()))
					throw new BusinessException("待更新的前台密码为空或不合法 ");
				uitd.setForePwd(userPasswordEncrypt(uitd.getForePwd()));
				updateCount++;
			} else { //不更新
				uitd.setForePwd(null);
			}
			//处理后台密码
			if ((true == oldBY) && (true == newBY)) { //选择性更新
				if (StringUtils.isBlank(uitd.getBackPwd())) {
					uitd.setBackPwd(null); //前端密码为空则不更新
				} else {
					if (!rexCheckPassword(uitd.getBackPwd())) {
						throw new BusinessException("待更新的后台密码不合法 ");
					} else {
						uitd.setBackPwd(userPasswordEncrypt(uitd.getBackPwd()));
						updateCount++;
					}
				}
			} else if ((true == oldBY) && (false == newBY)) { //必须更新
				uitd.setBackPwd("");
				updateCount++;
			} else if ((false == oldBY) && (true == newBY)) { //必须更新
				if (StringUtils.isBlank(uitd.getBackPwd()) || !rexCheckPassword(uitd.getBackPwd()))
					throw new BusinessException("待更新的后台密码为空或不合法 ");
				uitd.setBackPwd(userPasswordEncrypt(uitd.getBackPwd()));
				updateCount++;
			} else { //不更新
				uitd.setBackPwd(null);
			}
		}

		if (StringUtils.isNotBlank(resourceSet)) {  //权限集有更新
			updateCount++;
		}

		uitd.setCreateDate(null);
		uitd.setCreateBy(null);
		if ( updateCount >0 ) { //更新用户信息
			if (StringUtils.isBlank(uitd.getUpdateBy()) || !rexCheckUserName(uitd.getUpdateBy())) {
				throw new BusinessException("修改人为空");
			}
			uitd.setUpdateDate(new Date());
				try {
					userInfoMapper.updateU(uitd);
				} catch (Exception ee) {
					throw new BusinessException("update is err");
				}
		}
		if(  StringUtils.isNotBlank(uitd.getStatus()) && uitd.getStatus().equals("F") ) { //逻辑删除用户，连带物理删除权限表
			roleResourceService.deleteUserRoleResource(uitd.getId(), uitd.getUpdateBy() );
		} else {
			roleResourceService.updateUserRoleResource(uitd, resourceSet, uitd.getUpdateBy());
		}
	}

	@Override
	public Map<String,Object> getUserInfoByLoginName(String loginName /*, boolean foreYes*/) throws Exception {
//		Map<String, Object> m1 =new HashMap<String, Object>();
		if (StringUtils.isBlank(loginName) || !rexCheckUserName( loginName ) ) {
			throw new BusinessException("登录名为空或不合法");
		}
		UserInfoTableDo uitd =null;
	/*	if ( true == foreYes ) {
			uitd =userInfoMapper.selectForeUserInfoAll(loginName);
		} else {
			uitd =userInfoMapper.selectBackUserInfoAll(loginName);
		}*/
		uitd = userInfoMapper.selectUserInfoAllByLoginName(loginName);
		decryptUserInfo( uitd );
		Set<String> rC = roleResourceService.queryResourceCodeByLoginName(loginName);
		Map<String,Object> rstMap =new HashMap<String, Object>();
		rstMap.put("userInfo",uitd);
		rstMap.put("resourceCode",rC);
		return rstMap;
	}

	@Override
	public Map<String,Object> getUserInfoById(int id /*, boolean foreYes*/) throws Exception {
		UserInfoTableDo uitd = userInfoMapper.selectUserAllInfoById(id);
		decryptUserInfo( uitd );
		Set<String> rC = roleResourceService.queryResourceCodeByUserId(id);
		Map<String,Object> rstMap =new HashMap<String, Object>();
		rstMap.put("userInfo",uitd);
		rstMap.put("resourceCode",rC);
		return rstMap;
	}

	@Override
	public Map<String, Object> getUserInfoSummaryByLoginName( String loginName) throws Exception {
		if (StringUtils.isBlank(loginName) || !rexCheckUserName( loginName ) ) {
			throw new BusinessException("登录名为空或不合法");
		}
		List<Map<String, Object>> lm = userInfoMapper.selectUserInfoSummaryByLoginName(loginName);
		if( lm.size() >1 ) {
			throw new BusinessException("登录名同名用户数异常，请联系管理员排查！！");
		}
		else if( lm.size() <1 ) {
			throw new BusinessException("无此登录名对应的记录");
		}
		return lm.get(0);
	}


	@Override
	public Map<String,Object> listUserInfo( String selectType, String selectObject, int pageLimit, Integer pageNumber ) throws Exception  {
		if( StringUtils.isBlank(selectType) ) {
			throw new BusinessException("selectType参数为空");
		}
		if( pageLimit <1 ) {
			throw new BusinessException("pageLimit参数小于1，无意义");
		}
		if( !selectType.equals("default") && !selectType.equals("loginName") && !selectType.equals("realName")
				&& !selectType.equals("department")  && !selectType.equals("userType") ) {
			throw new BusinessException("selectType参数不合法");
		}
		if( !selectType.equals("default") && StringUtils.isBlank(selectObject) ) {
			//throw new BusinessException("selectObject参数不合法");
			selectType ="default";
		}
		if (selectType.equals("userType") ) {
			if( selectObject.equals("后台系统管理员") ) {
				selectObject = "'A','B'";
			} else  if( selectObject.equals("普通用户") ) {
				selectObject = "'F'";
			} else if( selectObject.equals("预分配用户") ) {
				selectObject = "'U'";
			} else {
				throw new BusinessException("userType对应的selectObject参数不合法");
			}
		}
		HashMap<String,Object> params =new HashMap<String, Object>();
		params.put( selectType, selectObject );
		params.put( "pageLimit", pageLimit );
		List<Map<String, Object>> lm =userInfoMapper.selectUserInfoList(params);
		Long ltn = (Long)( lm.get(0).get("recordTotal") );
		if( (null !=pageNumber) &&( pageNumber >0 ) ) {
			pageNumber =(pageNumber -1) * pageLimit;
			params.put("pageNumber", pageNumber);
		}
		params.put( "listing", 1 );
		lm =userInfoMapper.selectUserInfoList(params);
		UserInfoTableDo uitd =new UserInfoTableDo();
		for( Map<String, Object> itr : lm  ) {
			Object tmpObj =itr.get("realName");
			if( null !=tmpObj  ) {
				uitd.setRealName( (String)tmpObj );
			}
			tmpObj =itr.get("mobile");
			if( null !=tmpObj  ) {
				uitd.setMobile( (String)tmpObj );
			}
			decryptUserInfo( uitd );
			itr.put("realName", uitd.getRealName());
			itr.put("mobile", uitd.getMobile());
		}

		Map<String,Object> rstMap =new HashMap<String, Object>();
		rstMap.put("listTotalNum",ltn);
		rstMap.put("list",lm);
		return rstMap;
	}


	@Override
	public List<Map<String, Object>> getUserTemplate (String loginName) throws Exception {
		List<Map<String, Object>> rstList = userInfoMapper.selectUserTemplate(loginName);
//		for( Map<String, Object> itr :rstList ) {
//			itr.put("")
//		}
		return rstList;
	}

	@Override
	public List<Map<String, Object>> getShanghaiAreaCodeTable() throws Exception {
		return userInfoMapper.selectShanghaiAreaCodeTable( );
	}

	@Override
	public String userPasswordEncrypt(String plaintext) {
		return new SimpleHash("md5", plaintext, ByteSource.Util.bytes("123456"), 2).toHex();
	}

	@Override
	public boolean compareUserNameMatchPassword(String loginName, String password, String userType) throws  Exception {
		if (StringUtils.isBlank(loginName) || StringUtils.isBlank(password) || StringUtils.isBlank(userType))
			return false; //用户输入的参数不合法
		Object selPassword = (userInfoMapper.selectUserInfoSummaryByLoginName(loginName)).get(0).get(userType); //"fore_pwd"
		if( null == selPassword ) {
			throw new BusinessException("未检索到密码字段");
		}
		if (StringUtils.isEmpty((String)selPassword))
			return false; //数据库返回的结果为空
		if (password.equals( userPasswordEncrypt((String)selPassword)))
			return false; //密码不匹配
		return true;
	}

	//解密需要解密的用户数据
	private void decryptUserInfo( UserInfoTableDo uitd ) throws Exception {
		if( null !=uitd ) {
			if (StringUtils.isNotBlank(uitd.getRealName())) {
				//uitd.setRealName(CipherUtils.decrypt(uitd.getRealName()));
			} else {
				uitd.setRealName(null);
			}
			if (StringUtils.isNotBlank(uitd.getMobile())) {
				uitd.setMobile(CipherUtils.decrypt(uitd.getMobile()));
			} else {
				uitd.setMobile(null);
			}
		}
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
		String regStr = "^([\\u4e00-\\u9fa5]|[a-z]|[A-Z]|[0-9]|[-_.@]){5,60}$";
		return emailAddress.matches(regStr);
	}

	/**
	 * 验证 电话号码
	 * @param mobileNO
	 * @return
	 */
	private boolean rexCheckMobileNO(String mobileNO) {
		String regStr = "^[0-9-+ ]{1,30}$";
		return mobileNO.matches(regStr);
	}

	/**
	 * 验证 地区代码
	 * @param areaCode
	 * @return
	 */
	private boolean rexCheckAreaCode(String areaCode) {
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
		List<Map<String, Object>> lm = userInfoMapper.selectUserPassword1("admin511", "F");
		for (Map<String,Object> mp : lm) {
			for (Map.Entry m : mp.entrySet()) {
				System.out.println("key:" + m.getKey() + "-----   value:" + m.getValue());
			}
		}*/

/*	public static void main(String args[]) throws Exception {
		System.out.println(rexCheckPassword("111s"));
	}*/
}
