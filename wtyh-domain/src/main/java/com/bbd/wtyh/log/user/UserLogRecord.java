package com.bbd.wtyh.log.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bbd.wtyh.core.utils.ParamUtil;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.util.IPUtil;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 用户日志记录
 *
 * @author Created by LiYao on 2017-03-23 16:45.
 */
public class UserLogRecord {

    private static final Logger LOGGER = LoggerFactory.getLogger("userLog");

    /**
     * 使用 Shiro session 记录日志
     */
    public static void recordForShiroSession(String msg, Operation.Type operationType, Operation.Page operationPage,
            Operation.System operationSys, Session session) {
        recordForShiroSession(msg, operationType, operationPage, operationSys, null, session);
    }

    /**
     * 使用ShiroSession记录日志-参数处理
     */
    public static void recordForShiroSession(String msg, Operation.Type operationType, Operation.Page operationPage,
            Operation.System operationSys, Map<String, String> paramMap, Session session) {

        UserInfoTableDo user = (UserInfoTableDo) session.getAttribute("loginUser");
        UserLog userLog = new UserLog();
        userLog.setUuid(UUID.randomUUID().toString().replace("-", "").toUpperCase());
        userLog.setOperator(user == null ? "" : user.getLoginName());
        userLog.setRealName(user == null ? "" : user.getRealName());
        userLog.setDepartment(user == null ? "" : user.getDepartment());
        userLog.setAreaCode(user == null ? "" : user.getAreaCode());
        userLog.setOperationDate(new Date());
        userLog.setOperationType(operationType.code());
        userLog.setOperationDesc(operationType.desc());

        userLog.setLogContent(msg);

        userLog.setSysCode(operationSys.sysCode());
        userLog.setSysName(operationSys.sysName());

        userLog.setRequestIP((String) session.getAttribute("requestIp"));
        userLog.setRequestURI((String) session.getAttribute("requestUri"));

        if (operationPage.code() == 0) {
            Operation.Page oPage = (Operation.Page) session.getAttribute("pageHistory");
            userLog.setRequestCode(oPage != null ? oPage.code() : Operation.Page.blank.code());
            userLog.setRequestDesc(oPage != null ? oPage.page() : Operation.Page.blank.page());
        } else {
            session.setAttribute("pageHistory", operationPage);
            userLog.setRequestCode(operationPage.code());
            userLog.setRequestDesc(operationPage.page());
        }

        userLog.setRequestParam(paramMap);

        // 日志记录
        LOGGER.info(JSON.toJSONString(userLog, SerializerFeature.WriteDateUseDateFormat));
    }

    /**
     * 使用 session 记录日志
     */
    public static void record(String msg, Operation.Type operationType, Operation.Page operationPage, Operation.System operationSys,
            HttpSession session) {
        record(msg, operationType, operationPage, operationSys, null, session);
    }

    /**
     * 使用request记录日志
     */
    public static void record(String msg, Operation.Type operationType, Operation.Page operationPage, Operation.System operationSys,
            HttpServletRequest request) {
        record(msg, operationType, operationPage, operationSys, ParamUtil.getRequestParamMap(request), request);
    }

    /**
     * 使用request记录日志-参数处理
     */
    public static void record(String msg, Operation.Type operationType, Operation.Page operationPage, Operation.System operationSys,
            Map<String, String> paramMap, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("requestIp", IPUtil.getRemoteAddress(request));
        session.setAttribute("requestUri", request.getRequestURI());
        record(msg, operationType, operationPage, operationSys, paramMap, session);
    }

    /**
     * 使用HttpSession记录日志-参数处理
     */
    public static void record(String msg, Operation.Type operationType, Operation.Page operationPage, Operation.System operationSys,
            Map<String, String> paramMap, HttpSession session) {

        UserInfoTableDo user = (UserInfoTableDo) session.getAttribute("loginUser");
        UserLog userLog = new UserLog();
        userLog.setUuid(UUID.randomUUID().toString().replace("-", "").toUpperCase());
        userLog.setOperator(user == null ? "" : user.getLoginName());
        userLog.setRealName(user == null ? "" : user.getRealName());
        userLog.setDepartment(user == null ? "" : user.getDepartment());
        userLog.setAreaCode(user == null ? "" : user.getAreaCode());
        userLog.setOperationDate(new Date());
        userLog.setOperationType(operationType.code());
        userLog.setOperationDesc(operationType.desc());

        userLog.setLogContent(msg);

        userLog.setSysCode(operationSys.sysCode());
        userLog.setSysName(operationSys.sysName());

        userLog.setRequestIP((String) session.getAttribute("requestIp"));
        userLog.setRequestURI((String) session.getAttribute("requestUri"));

        if (operationPage.code() == 0) {
            Operation.Page oPage = (Operation.Page) session.getAttribute("pageHistory");
            userLog.setRequestCode(oPage != null ? oPage.code() : Operation.Page.blank.code());
            userLog.setRequestDesc(oPage != null ? oPage.page() : Operation.Page.blank.page());
        } else {
            session.setAttribute("pageHistory", operationPage);
            userLog.setRequestCode(operationPage.code());
            userLog.setRequestDesc(operationPage.page());
        }

        userLog.setRequestParam(paramMap);

        // 日志记录
        LOGGER.info(JSON.toJSONString(userLog, SerializerFeature.WriteDateUseDateFormat));
    }

    /**
     * 使用HttpSession记录日志-参数处理
     */
    public static void record(String msg, Operation.Type operationType, Operation.Page operationPage, Operation.System operationSys) {

        UserLog userLog = new UserLog();
        userLog.setUuid(UUID.randomUUID().toString().replace("-", "").toUpperCase());
        userLog.setOperator("");
        userLog.setRealName("");
        userLog.setDepartment("");
        userLog.setAreaCode("");
        userLog.setOperationDate(new Date());
        userLog.setOperationType(operationType.code());
        userLog.setOperationDesc(operationType.desc());

        userLog.setLogContent(msg);

        userLog.setSysCode(operationSys.sysCode());
        userLog.setSysName(operationSys.sysName());
        if (operationPage.code() == 0) {
            userLog.setRequestCode(Operation.Page.blank.code());
            userLog.setRequestDesc(Operation.Page.blank.page());
        } else {
            userLog.setRequestCode(operationPage.code());
            userLog.setRequestDesc(operationPage.page());
        }
        // 日志记录
        LOGGER.info(JSON.toJSONString(userLog, SerializerFeature.WriteDateUseDateFormat));
    }

}
