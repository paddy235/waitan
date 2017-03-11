package com.bbd.bgo.web.controller;

import com.bbd.bgo.auth.UserRealm;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
    public Object updateUserInfo(UserInfoTableDo uitd, @RequestParam String resourceSet, HttpServletRequest request) {
        String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        uitd.setUpdateBy(loginName);
        try {
            uis.updateUserInfo(uitd, resourceSet);
            userRealm.clearCached();
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
    public Object deleteUser(@RequestParam Integer deleteId, HttpServletRequest request) {
        try {
            UserInfoTableDo uitd = new UserInfoTableDo();
            String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
            uitd.setUpdateBy(loginName);
            uitd.setId(deleteId);
            uitd.setStatus("F"); //逻辑删除
            uis.updateUserInfo(uitd, null);
            userRealm.clearCached();
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
            @RequestParam int areaCode,
            @RequestParam String selectType,
            String selectObject,
            @RequestParam int pageSize,
            Integer pageNumber,
            HttpServletRequest request) {
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
    public Object queryUserInfoById(@RequestParam int queryId, HttpServletRequest request) {
        Map<String, Object> rstMap = null;
        try {
            rstMap = uis.getUserInfoById(queryId);
        } catch (BusinessException be) {
            return ResponseBean.errorResponse(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse("服务器异常：" + e);
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

    @RequestMapping("/myTest.do")
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
    }


}
