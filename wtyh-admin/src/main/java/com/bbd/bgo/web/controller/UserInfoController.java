package com.bbd.bgo.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.bbd.wtyh.log.user.UserLogRecord;
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
    public Object createUser1(UserInfoTableDo uitd, @RequestParam String resourceSet, HttpServletRequest request) {
        // hh.addHeader("aa","1234");
        String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        uitd.setCreateBy(loginName);
        try {
            uis.createUser(uitd, resourceSet);
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
    		return uis.compareUserNameMatchPassword(loginName, password, type);
    	}*/

    @RequestMapping("/updateUserInfo.do")
    @ResponseBody
    @LogRecord(logMsg = "用户名为“%s”的用户信息被修改，所属部门是：%s）", params = {"modLoginName", "modDepartment"},
            page = Operation.Page.userInfoModify, type = Operation.Type.modify, after = true, before = false)
    public Object updateUserInfo(UserInfoTableDo uitd, @RequestParam String resourceSet, HttpServletRequest request) {
        String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        uitd.setUpdateBy(loginName);
        try {
            uis.updateUserInfo(uitd, resourceSet);
            userRealm.clearCached();
            Map<String, Object> rstMap = uis.getUserInfoById(uitd.getId());
            uitd = (UserInfoTableDo)(rstMap.get("userInfo"));
            request.setAttribute("modLoginName", uitd.getLoginName());
            request.setAttribute("modDepartment", uitd.getDepartment());
        } catch (BusinessException be) {
            return ResponseBean.errorResponse(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse("服务器异常");
        }
        return ResponseBean.successResponse("OK");
    }

    @RequestMapping("/deleteUser.do")
    @ResponseBody
    @LogRecord(logMsg = "用户“%s”被被删除", params = {"delName"}, page = Operation.Page.userList,
            type = Operation.Type.del, after = true, before = false) //todo ！！！4月10日版这项选Operation.Page.userInfoBrowse
    public Object deleteUser(@RequestParam Integer deleteId, HttpServletRequest request) {
        try {
            UserInfoTableDo uitd = new UserInfoTableDo();
            String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
            uitd.setUpdateBy(loginName);
            uitd.setId(deleteId);
            uitd.setStatus("F"); //逻辑删除
            Map<String, Object> rstMap = uis.getUserInfoById(deleteId);
            uis.updateUserInfo(uitd, null);
            userRealm.clearCached();
            String delLoginName = ( (UserInfoTableDo)(rstMap.get("userInfo")) ).getLoginName();
            request.setAttribute("delName", delLoginName);
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
    @LogRecord(logMsg = "搜索用户列表（搜索条件：%s，关键字：%s）", params = {"selectType1", "selectObject1"},
            page = Operation.Page.userList, type = Operation.Type.query, after = true, before = false )
    public Object listUserInfo(
            @RequestParam int areaCode,
            @RequestParam String selectType,
            String selectObject,
            @RequestParam int pageSize,
            Integer pageNumber,
            HttpServletRequest request) {

        String selectType1 ="";
        String selectObject1 ="";
        switch (selectType)
        {
            case "default":
                selectType1 ="全选";
                selectObject1 ="无";
                break;
            case "loginName":
                selectType1 ="用户名";
                break;
            case "realName":
                selectType1 ="真实姓名";
                break;
            case "department":
                selectType1 ="所属部门";
                break;
            case "userType":
                selectType1 ="用户类型";
                break;
            default:
                selectType1 ="";
                selectObject1 ="";
        }
        request.setAttribute("selectType1", selectType1);
        request.setAttribute("selectObject1", selectObject1);

        Map<String, Object> rstMap = null;
        try {
            rstMap = uis.listUserInfo(areaCode,selectType, selectObject, pageSize, pageNumber);
        } catch (BusinessException be) {
            return ResponseBean.errorResponse(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse("服务器异常：" + e);
        }
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
                            Operation.Type.browse, Operation.Page.userInfoBrowse, Operation.System.back, request); //todo ?
                    break;
                case "openUserTemplate": //记录开立模板的选中项目
                    UserLogRecord.record("将“" + ((UserInfoTableDo) rstMap.get("userInfo")).getLoginName() + "”的用户信息选为模板",
                            Operation.Type.query, Operation.Page.userCreate, Operation.System.back, request); //todo ?
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
        List<Map<String, Object>> rstList = null;
        try {
            rstList = uis.getShanghaiAreaCodeTable(type);
        } catch (BusinessException be) {
            return ResponseBean.errorResponse(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse("服务器异常：" + e);
        }
        return ResponseBean.successResponse(rstList);
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

}
