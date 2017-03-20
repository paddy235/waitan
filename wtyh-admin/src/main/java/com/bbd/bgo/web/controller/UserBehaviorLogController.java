package com.bbd.bgo.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
 * Created by cgj on 2017/3/20.
 */

@Controller
@RequestMapping("/userInfo")
public class UserBehaviorLogController {

    @Autowired
    private UserInfoService uis;
    @Autowired
    private UserRealm userRealm;


    @RequestMapping("/listUserInfo.do")
    @ResponseBody
    @LogRecord(logMsg = "按条件显示用户列表（区域代码：%s, 搜索条件：%s=%s）", params = {"areaCode", "selectType", "selectObject"},
            page = Operation.Page.userList, type = Operation.Type.browse)
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
    @LogRecord(logMsg = "新增用户开立模板（搜索登录名关键字：%s）", params = {"loginName"}, page = Operation.Page.userList, type = Operation.Type.browse)
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
