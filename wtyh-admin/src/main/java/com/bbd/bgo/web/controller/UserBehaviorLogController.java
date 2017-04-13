package com.bbd.bgo.web.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.bbd.wtyh.common.comenum.UserRank;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.map.name.code.CodeNameMap;
import com.bbd.wtyh.service.UserBehaviorLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.web.ResponseBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by cgj on 2017/3/20.
 */

@Controller
@RequestMapping("/userBehaviorLog")
public class UserBehaviorLogController {

    @Autowired
    private UserInfoService uis;

    @Autowired
    UserBehaviorLogService ubls;

    private Date stringToDate(String strDate) throws Exception {
        if(StringUtils.isBlank(strDate)) {
            return null;
        }
        SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.parse(strDate);
    }

    @RequestMapping("/listUserBehaviorLog.do")
    @ResponseBody
    public Object listUserBehaviorLog(
            @RequestParam int pageSize,
            Integer pageNumber,
            String userName,
            Integer areaCode,
            Integer sysCode,
            Integer opTpCd,
            Integer  opPgCd,
            String beginTime,
            String endTime,
            Long logSN,
            String orderBy,
            HttpServletRequest request, HttpSession session) {
        Map<String, Object> rstMap = null;
        try {
            String excludeName =null;

            if( UserRank.ADMIN.equals ( (session.getAttribute("userRank")) ) ) {
                excludeName ="admin"; //滤除超管的行为日志，普管不能查看超管的行为日志
            }
            rstMap = ubls.listUserBehaviorLog(pageSize, pageNumber, excludeName ,userName, areaCode,
                    sysCode, opTpCd, opPgCd, stringToDate(beginTime),
                    stringToDate(endTime), logSN, orderBy);
        } catch (BusinessException be) {
            return ResponseBean.errorResponse(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse("服务器异常：" + e);
        }
        int parCnt =0;
        String parStr ="";
        if (StringUtils.isNotBlank(userName)) {
            parCnt++;
            parStr += "用户名关键字:" +userName +"；";
        }
        if (null !=areaCode && areaCode >0) {
            parCnt++;
            parStr += "行政区:" +CodeNameMap.getShanghaiAreaCodeMap().get(areaCode) +"；";
        }
        if (null !=sysCode && sysCode >0) {
            parCnt++;
            parStr += "系统位置:" +CodeNameMap.getSysLocationMap().get(sysCode) +"；";
        }
        if (null !=logSN && logSN >0) {
            parCnt++;
            parStr += "日志编号:" +logSN.toString() +"；";
        }
        if (null !=opTpCd && opTpCd >0) {
            parCnt++;
            parStr += "操作类型:" +CodeNameMap.getOpTypeMap().get(opTpCd) +"；";
        }
        if (null !=opPgCd && opPgCd >0) {
            parCnt++;
            parStr += "操作页面:" +CodeNameMap.getOpPageMap().get(opPgCd) +"；";
        }
        if ( StringUtils.isNotBlank(beginTime) ) {
            parCnt++;
            parStr += "开始时间:" +beginTime +"；";
        }
        if (StringUtils.isNotBlank(endTime)) {
            parCnt++;
            parStr += "结束时间:" +endTime +"；";
        }

        if( 0 ==parCnt ) {
            UserLogRecord.record("浏览用户行为日志列表",
                    Operation.Type.browse, Operation.Page.userLogList, Operation.System.back, request);
        } else {
            UserLogRecord.record("搜索用户行为日志，搜索条件[ " +parStr +"]",
                    Operation.Type.query, Operation.Page.userLogList, Operation.System.back, request);
        }
        return ResponseBean.successResponse(rstMap);
    }


    @RequestMapping("/queryListDictionary.do")
    @ResponseBody
    public Object queryListDictionary( @RequestParam String[] queryProject ) {
        Map<String, Object> rstObj = new HashMap<String, Object>();
        for ( String Prj : queryProject ) {
            switch ( Prj ) {
                case  "areaCodeList": //区域代码
                    rstObj.put("areaCodeList", CodeNameMap.quickGetShanghaiAreaCodeTable() );
                    break;
                case "sysLocationList": //系统位置
                    rstObj.put("sysLocationList",CodeNameMap.getSysLocationList() );
                    break;
                case "opTypeList": //操作类型
                    rstObj.put("opTypeList",CodeNameMap.getOpTypeList() );
                    break;
                case "opPageList": //操作页面
                    rstObj.put("opPageList", CodeNameMap.getOpPageList() );
                    break;
            }
        }
        return ResponseBean.successResponse(rstObj);
    }

/*    @RequestMapping(value = "/fileUp.do", method = RequestMethod.POST)
    @ResponseBody
    public Object fileUp(
            HttpServletRequest request,
            @RequestParam String description,
            @RequestParam MultipartFile file
            ) throws  Exception{
        String pa =request.getContextPath();
        String fiNa =file.getOriginalFilename();
        File fp =new File(pa +fiNa);

        return ResponseBean.successResponse("ok");
    }*/


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
