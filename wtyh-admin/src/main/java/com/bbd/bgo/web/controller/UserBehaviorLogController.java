package com.bbd.bgo.web.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.bbd.wtyh.service.UserBehaviorLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.web.ResponseBean;

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
    @LogRecord(logMsg = "浏览用户行为日志列表", page = Operation.Page.userLogList, type = Operation.Type.browse)
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
            String orderBy) {
        Map<String, Object> rstMap = null;
        try {
            rstMap = ubls.listUserBehaviorLog(pageSize, pageNumber, userName, areaCode,
                    sysCode, opTpCd, opPgCd, stringToDate(beginTime),
                    stringToDate(endTime), logSN, orderBy);
        } catch (BusinessException be) {
            return ResponseBean.errorResponse(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse("服务器异常：" + e);
        }
        return ResponseBean.successResponse(rstMap);
    }


    @RequestMapping("/queryListDictionary.do")
    @ResponseBody
    public Object queryListDictionary( @RequestParam String[] queryProject ) {
        Map<String, Object> rstObj = new HashMap<String, Object>();
        try {
            for ( String Prj : queryProject ) {
                switch ( Prj ) {
                    case  "areaCodeList": //区域代码
                        //List<Map<String, Object>> lm =uis.getShanghaiAreaCodeTable("0");
                        rstObj.put("areaCodeList", uis.getShanghaiAreaCodeTable("0") );
                        break;
                    case "sysLocationList": //系统位置
                        List<Map<String, Object>> sll =new ArrayList<Map<String, Object>>() {{
                            add( new  HashMap<String, Object>() {{
                                put("sysCode", (Integer)(-1));
                                put("sysName", "全部");
                            }} );
                            for (  Operation.System opS  : Operation.System.values() ) {
                                add( new  HashMap<String, Object>() {{
                                    put("sysCode", (Integer)opS.sysCode());
                                    put("sysName", opS.sysName());
                                }} );
                            }
                        }};
                        rstObj.put("sysLocationList",sll );
                        break;
                    case "opTypeList": //操作类型
                        List<Map<String, Object>> otl =new ArrayList<Map<String, Object>>() {{
                            add( new  HashMap<String, Object>() {{
                                put("opTpCd", (Integer)(-1));
                                put("opType", "全部");
                            }} );
                            for (  Operation.Type opT  : Operation.Type.values() ) {
                                add(new HashMap<String, Object>() {{
                                    put("opTpCd", (Integer) opT.code());
                                    put("opType", opT.desc());
                                }});
                            }
                        }};
                        rstObj.put("opTypeList",otl );
                        break;
                    case "opPageList": //操作页面
                        List<Map<String, Object>> opl =new ArrayList<Map<String, Object>>() {{
                            add( new  HashMap<String, Object>() {{
                                put("opPgCd", (Integer)(-1));
                                put("opPage", "全部");
                            }} );
                            for (  Operation.Page opP  : Operation.Page.values() ) {
                                if( opP.code() >0 ) {
                                    add(new HashMap<String, Object>() {{
                                        put("opPgCd", (Integer) opP.code());
                                        put("opPage", opP.page());
                                    }});
                                }
                            }
                        }};
                        rstObj.put("opPageList",opl );
                        break;
                }
            }
        } catch (BusinessException be) {
            return ResponseBean.errorResponse(be.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse("服务器异常：" + e);
        }
        return ResponseBean.successResponse(rstObj);
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
