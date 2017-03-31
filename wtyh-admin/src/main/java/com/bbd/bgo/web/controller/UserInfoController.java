package com.bbd.bgo.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.map.name.code.CodeNameMap;
import com.bbd.wtyh.util.CipherUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.bgo.auth.UserRealm;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.web.ResponseBean;

//import javax.servlet.http.HttpServletResponse;

/**
 * Created by cgj on 2017/2/27.
 */

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService uis;
    @Autowired
    private UserRealm userRealm;

    @RequestMapping("/createUser.do")
    @ResponseBody
    @LogRecord(logMsg = "新增用户：%s", params = {"loginName"}, page = Operation.Page.userCreate, type = Operation.Type.add)
    public Object createUser1( UserInfoTableDo uitd,
                               @RequestParam String resourceSet,
                               @RequestParam String[] roleSet,
                               HttpServletRequest request) {
        // hh.addHeader("aa","1234");
        String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        uitd.setCreateBy(loginName);
        try {
            uis.createUser(uitd, resourceSet, roleSet);
        } catch (BusinessException be) {
            return ResponseBean.errorResponse(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse("服务器异常");
        }
        return ResponseBean.successResponse("OK");
    }

    /*	@RequestMapping("/myUserLogin")
    	@ResponseBody
    	public Object myUserLogin(@RequestParam String loginName, @RequestParam String password, @RequestParam String type) {
    		return uis.isUserNameMatchPassword(loginName, password, type);
    	}*/

    @RequestMapping("/updateUserInfo.do")
    @ResponseBody
    public Object updateUserInfo(UserInfoTableDo uitd, String resourceSet, String[] roleSet, HttpServletRequest request) {
        String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        uitd.setUpdateBy(loginName);
        try {
            uitd.setStatus(null);//此接口不允许更新用户状态
            uitd.setLoginName(null); //此接口不允许更新登录名
            uis.updateUserInfo(uitd, resourceSet, roleSet);
            userRealm.clearCached();
            UserInfoTableDo ud =uis.getOnlyUserInfoByLoginNameOrId(null,uitd.getId());
            loginName = ud.getLoginName();
            //request.setAttribute("modLoginName", uitd.getLoginName());
        } catch (BusinessException be) {
            return ResponseBean.errorResponse(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse("服务器异常");
        }
        //以下是日志记录代码
        String parStr ="";
        if( null != uitd.getAreaCode() ) {
            parStr +="/区域 ";
        }
        if( StringUtils.isNoneBlank(uitd.getBackPwd()) ) {
            parStr +="/后台密码 ";
        }
        if( StringUtils.isNoneBlank(uitd.getDepartment()) ) {
            parStr +="/部门 ";
        }
        if( StringUtils.isNoneBlank(uitd.getEmail()) ) {
            parStr +="/邮箱 ";
        }
        if( StringUtils.isNoneBlank(uitd.getFixPhone()) ) {
            parStr +="/固话 ";
        }
        if( StringUtils.isNoneBlank(uitd.getForePwd()) ) {
            parStr +="/前台密码 ";
        }
        if( StringUtils.isNoneBlank(uitd.getLoginName()) ) {
            parStr +="/用户名 ";
        }
        if( StringUtils.isNoneBlank(uitd.getMobile()) ) {
            parStr +="/手机 ";
        }
        if( StringUtils.isNoneBlank(uitd.getRealName()) ) {
            parStr +="/真实姓名 ";
        }
        if( StringUtils.isNoneBlank(uitd.getUserType()) ) {
            parStr +="/用户类型 ";
        }
        if( null !=resourceSet ) {
            parStr +="/权限 ";
        }
        UserLogRecord.record("修改了用户“" +loginName +"”的这些信息：" +parStr,
                Operation.Type.modify, Operation.Page.userInfoModify, Operation.System.back, request);

        return ResponseBean.successResponse("OK");
    }

    @RequestMapping("/deleteUser.do")
    @ResponseBody
    @LogRecord(logMsg = "用户“%s”被删除", params = {"delName"}, page = Operation.Page.userInfoBrowse,
            type = Operation.Type.del, after = true, before = false) //
    public Object deleteUser(@RequestParam Integer deleteId, HttpServletRequest request) {
        try {
            //Map<String, Object> rstMap = uis.getUserInfoById(deleteId);
            UserInfoTableDo ud =uis.getOnlyUserInfoByLoginNameOrId(null,deleteId);
            if(null ==ud) {
                throw new BusinessException("此id无对应用户记录");
            }
            uis.deleteUserById(deleteId);
            userRealm.clearCached(); //
            request.setAttribute("delName", ud.getLoginName());
        } catch (BusinessException be) {
            return ResponseBean.errorResponse(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse("服务器异常：" + e);
        }
        return ResponseBean.successResponse("OK");
    }

    @RequestMapping("/lockUser.do")
    @ResponseBody
    @LogRecord(logMsg = "用户“%s”被锁定", params = {"lockName"}, page = Operation.Page.userInfoBrowse,
            type = Operation.Type.lock, after = true, before = false) //
    public Object lockUser(@RequestParam Integer lockId, HttpServletRequest request) {
        try {
            UserInfoTableDo ud =uis.getOnlyUserInfoByLoginNameOrId(null,lockId);
            if(null ==ud) {
                throw new BusinessException("此id无对应用户记录");
            }
            UserInfoTableDo uitd = new UserInfoTableDo();
            String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
            uitd.setUpdateBy(loginName);
            uitd.setId(lockId);
            uitd.setStatus(UserInfoService.UserStatus.lock.getStatusCode()); //"F"
            uis.updateUserInfo(uitd, null, null);
            userRealm.clearCached();
            request.setAttribute("lockName", ud.getLoginName());
        } catch (BusinessException be) {
            return ResponseBean.errorResponse(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse("服务器异常：" + e);
        }
        return ResponseBean.successResponse("OK");
    }

    @RequestMapping("/activeUser.do")
    @ResponseBody
    @LogRecord(logMsg = "激活用户“%s”", params = {"activeName"}, page = Operation.Page.userInfoBrowse,
            type = Operation.Type.active, after = true, before = false) //
    public Object activeUser(@RequestParam Integer activeId, HttpServletRequest request) {
        try {
            UserInfoTableDo ud =uis.getOnlyUserInfoByLoginNameOrId(null,activeId);
            if(null ==ud) {
                throw new BusinessException("此id无对应用户记录");
            }
            UserInfoTableDo uitd = new UserInfoTableDo();
            String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
            uitd.setUpdateBy(loginName);
            uitd.setId(activeId);
            uitd.setStatus(UserInfoService.UserStatus.active.getStatusCode()); //"A"
            uis.updateUserInfo(uitd, null, null);
            userRealm.clearCached();
            request.setAttribute("activeName", ud.getLoginName());
        } catch (BusinessException be) {
            return ResponseBean.errorResponse(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse("服务器异常：" + e);
        }
        return ResponseBean.successResponse("OK");
    }

    @RequestMapping("/listUserInfo.do")
    @ResponseBody
    public Object listUserInfo(
            @RequestParam String userStatus,
            @RequestParam String userType,
            @RequestParam int areaCode,
            @RequestParam String selectType,
            String selectObject,
            @RequestParam int pageSize,
            Integer pageNumber,
            HttpServletRequest request) {

        Map<String, Object> rstMap = null;
        try {
            rstMap = uis.listUserInfo(userStatus, userType, areaCode, selectType, selectObject, pageSize, pageNumber);
        } catch (BusinessException be) {
            return ResponseBean.errorResponse(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse("服务器异常：" + e);
        }
        //以下用于日志记录
        if( selectType.equals("default")&& 0 ==areaCode ) {
            UserLogRecord.record("浏览用户列表", Operation.Type.browse, Operation.Page.userList, Operation.System.back, request);
        } else {
            switch (selectType) {
                case "default":
                    selectType = "全选";
                    selectObject = "无";
                    break;
                case "loginName":
                    selectType = "用户名";
                    break;
                case "realName":
                    selectType = "真实姓名";
                    break;
                case "department":
                    selectType = "所属部门";
                    break;
            }
            UserLogRecord.record("搜索用户列表（条件：" +selectType +"，关键字：" +selectObject +"，区域："
                    +CodeNameMap.getShanghaiAreaCodeMap().get(areaCode) +"）",
                    Operation.Type.query, Operation.Page.userList, Operation.System.back, request);
        }
        //以上用于日志记录
        return ResponseBean.successResponse(rstMap);
    }

    @RequestMapping("/queryUserInfoById.do")
    @ResponseBody
    public Object queryUserInfoById(@RequestParam int queryId, String anchor, HttpServletRequest request) {
        Map<String, Object> rstMap = null;
        try {
            rstMap = uis.getUserInfoById(queryId);
        } catch (BusinessException be) {
            return ResponseBean.errorResponse(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse("服务器异常：" + e);
        }
        if(StringUtils.isNoneBlank(anchor) ) { //按条件记录用户日志
            switch (anchor) {
                case "userInfoBrowse": //记录用户信息浏览日志
                    UserLogRecord.record("访问“" + ((UserInfoTableDo) rstMap.get("userInfo")).getLoginName() + "”的用户信息",
                            Operation.Type.browse, Operation.Page.userInfoBrowse, Operation.System.back, request); //
                    break;
                case "openUserTemplate": //记录开立模板的选中项目
                    UserLogRecord.record("将“" + ((UserInfoTableDo) rstMap.get("userInfo")).getLoginName() + "”的用户信息选为模板",
                            Operation.Type.query, Operation.Page.userCreate, Operation.System.back, request); //
                    break;
            }
        }
        return ResponseBean.successResponse(rstMap);
    }

    @RequestMapping("/queryUserTemplate.do")
    @ResponseBody
    public Object queryUserTemplate(@RequestParam String loginName, HttpServletRequest request) {
        List<Map<String, Object>> rstList = null;
        try {
            rstList = uis.getUserTemplate(loginName);
        } catch (BusinessException be) {
            return ResponseBean.errorResponse(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse("服务器异常：" + e);
        }
        return ResponseBean.successResponse(rstList);
    }

    @RequestMapping("/queryShanghaiAreaCodeTable.do")
    @ResponseBody
    public Object queryShanghaiAreaCodeTable( String type, HttpServletRequest request) {
        List<Map<String, Object>> rstList = new
                ArrayList<Map<String, Object>>(CodeNameMap.getAndUpdateShanghaiAreaCodeTable(false));
        if( null ==type || !type.equals("0") ) {
            rstList.remove(0);
        }
        return  ResponseBean.successResponse(rstList);
        /*List<Map<String, Object>> rstList = null;
        try {
            rstList = uis.getShanghaiAreaCodeTable(type);
        } catch (BusinessException be) {
            return ResponseBean.errorResponse(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse("服务器异常：" + e);
        }
        CodeNameMap.setShanghaiAreaCodeList(rstList, false);
        return ResponseBean.successResponse(rstList);
        return  ResponseBean.successResponse(CodeNameMap.getAndUpdateShanghaiAreaCodeTable(false));*/
    }

    @RequestMapping("/queryUserListDictionary.do")
    @ResponseBody
    public Object queryListDictionary( @RequestParam String[] queryProject ) {
        Map<String, Object> rstObj = new HashMap<String, Object>();
        for ( String Prj : queryProject ) {
            switch ( Prj ) {
                case  "areaCodeList": //上海区域代码
                    rstObj.put("areaCodeList", CodeNameMap.getAndUpdateShanghaiAreaCodeTable(false) );
                    break;
                case "userTypeList": //用户类型
                    rstObj.put("userTypeList",CodeNameMap.getUserTypeList() );
                    break;
                case "userStatusList": //用户状态
                    rstObj.put("userStatusList",CodeNameMap.getUserStatusList() );
                    break;
            }
        }
        return ResponseBean.successResponse(rstObj);
    }

    @RequestMapping("/queryPwdLapseCycle.do")
    @ResponseBody
    public Object queryPwdLapseCycle(  HttpServletRequest request) {
        return  ResponseBean.successResponse(uis.getAndSetPwdLapseCycle(null));
    }

    @RequestMapping("/modifyPwdLapseCycle.do")
    @ResponseBody
    public Object modifyPwdLapseCycle( @RequestParam int pwdLapseCycle, HttpServletRequest request) {
        if( pwdLapseCycle <1 || pwdLapseCycle >100 ) {
            return  ResponseBean.errorResponse("参数不合法，正确范围[1,100]");
        }
        return  ResponseBean.successResponse( uis.getAndSetPwdLapseCycle(pwdLapseCycle) );
    }

/*    @RequestMapping("/myTest.do")
    @ResponseBody
    public Object myTest() {
        //下面是测试代码
        try {
            Map<String, Object> rstMap = uis.listUserInfo(0,"realName", "ad", 10, null);
            System.out.println(rstMap);
            return rstMap;
        } catch (Exception ee) {
            ;
        }
        return ResponseBean.successResponse("err");
    }*/

    @RequestMapping("/query.do")
    @ResponseBody
    @LogRecord(logMsg = "浏览个人中心", page = Operation.Page.userOwnInfo)
    public Object query(HttpSession session) throws Exception {
        String userName = (String) session.getAttribute(Constants.SESSION.loginName);
        if (org.apache.commons.lang.StringUtils.isEmpty(userName)) {
            return ResponseBean.errorResponse("请先登录。");
        }
        UserInfoTableDo user = uis.getOnlyUserInfoByLoginNameOrId(userName, -1);
        user.setForePwd(null);
        user.setBackPwd(null);
        return ResponseBean.successResponse(user);
    }

    @RequestMapping("/update.do")
    @ResponseBody
    @LogRecord(logMsg = "修改个人中心：%s%s%s", params = { "m_mobile", "m_fixPhone",
            "m_email" }, type = Operation.Type.modify, page = Operation.Page.userOwnInfo, after = true, before = false)
    public Object updateInfo(@RequestParam Integer id, @RequestParam String mobile, @RequestParam String email,
                             @RequestParam String fixPhone, HttpSession session, HttpServletRequest request) throws Exception {

        UserInfoTableDo oldUitd = this.uis.selectById(UserInfoTableDo.class, id);
        if (oldUitd != null) {
            request.setAttribute("m_mobile", " ");
            request.setAttribute("m_fixPhone", " ");
            request.setAttribute("m_email", " ");

            if (!org.apache.commons.lang.StringUtils.equals(mobile, CipherUtils.decrypt(oldUitd.getMobile()))) {
                request.setAttribute("m_mobile", "【联系电话(手机)】");
            }
            if (!org.apache.commons.lang.StringUtils.equals(fixPhone, CipherUtils.decrypt(oldUitd.getFixPhone()))) {
                request.setAttribute("m_fixPhone", "【联系电话(固话)】");
            }
            if (!org.apache.commons.lang.StringUtils.equals(email, oldUitd.getEmail())) {
                request.setAttribute("m_email", "【邮箱】");
            }
        }

        UserInfoTableDo user = new UserInfoTableDo();
        user.setId(id);
        user.setMobile(mobile);
        user.setEmail(email);
        user.setFixPhone(fixPhone);
        user.setUpdateBy((String) session.getAttribute(Constants.SESSION.loginName));

        uis.updateUserInfo(user, null, null);

        return ResponseBean.successResponse("用户信息修改成功。");
    }

    @RequestMapping("/update/password.do")
    @ResponseBody
    @LogRecord(logMsg = "修改自己密码", type = Operation.Type.modify, page = Operation.Page.userOwnPwdModify, after = true, before = false)
    public Object updatePassword(/* @RequestParam Integer id, */
                                 @RequestParam String loginName, @RequestParam String oldPassword, @RequestParam String newPassword, HttpSession session)
            throws Exception {

        if (oldPassword.equals(newPassword)) {
            return ResponseBean.successResponse("password.history.contains"); // 新设置密码不可与原密码设置相同
        }
        UserInfoTableDo ud = uis.getOnlyUserInfoByLoginNameOrId(loginName,-1);
        int rst = uis.compareUserDaoAndPassword(ud, newPassword, Operation.System.back, null);
        if( rst <=-5 ) {
            return ResponseBean.successResponse("account.not.exist"); // 账号不存在 // BusinessException("未查询到id字段");
        }
        else if( rst <0 ) {
            return ResponseBean.successResponse("password.error"); // 密码错误 //BusinessException("原密码验证失败");
        }
        UserInfoTableDo user = new UserInfoTableDo();
        user.setUpdateBy(loginName); // user.setUpdateBy((String)session.getAttribute(Constants.SESSION.loginName));
        user.setBackPwd(newPassword);
        user.setId( ud.getId() );
        uis.updateUserInfo(user, null, null);
        userRealm.clearCached();
        return ResponseBean.successResponse("password.change.success"); // 用户密码修改成功。
    }
}
