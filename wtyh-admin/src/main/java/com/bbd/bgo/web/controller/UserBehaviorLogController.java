package com.bbd.bgo.web.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.bbd.wtyh.cachetobean.ShanghaiAreaCode;
import com.bbd.wtyh.common.comenum.UserRank;
import com.bbd.wtyh.excel.ExportExcel;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.map.name.code.CodeNameMap;
import com.bbd.wtyh.service.UserBehaviorLogService;
import com.bbd.wtyh.util.DateUtils;
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
	UserBehaviorLogService ubls;

	@RequestMapping("/listUserBehaviorLog.do")
	@ResponseBody
	public Object listUserBehaviorLog(@RequestParam int pageSize, Integer pageNumber, String userName, Integer areaCode, Integer sysCode,
			Integer opTpCd, Integer opPgCd, String beginTime, String endTime, String logContent, String orderBy, boolean doExport,
			HttpServletRequest request, HttpSession session) {
		Map<String, Object> rstMap;
		try {
			String excludeName = null;

			if (((UserRank) (session.getAttribute("userRank"))).getRankVal() < UserRank.SUPER_A.getRankVal()) {
				excludeName = "admin"; // 滤除超管的行为日志，普管不能查看超管的行为日志
			}
			rstMap = ubls.listUserBehaviorLog(pageSize, pageNumber, excludeName, userName, areaCode, sysCode, opTpCd, opPgCd,
					DateUtils.stringToDate(beginTime), DateUtils.stringToDate(endTime), logContent, orderBy);
		} catch (BusinessException be) {
			return ResponseBean.errorResponse(be.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBean.errorResponse("服务器异常：" + e);
		}
		// 以下用于记录日志
		int parCnt = 0;
		String parStr = "";
		if (StringUtils.isNotBlank(userName)) {
			parCnt++;
			parStr += "用户名关键字:" + userName + "；";
		}
		if (null != areaCode && areaCode > 0) {
			parCnt++;
			parStr += "行政区:" + ShanghaiAreaCode.getMap().get(areaCode) + "；";
		}
		if (null != sysCode && sysCode > 0) {
			parCnt++;
			parStr += "系统位置:" + CodeNameMap.getSysLocationMap().get(sysCode) + "；";
		}
		if (StringUtils.isNotEmpty(logContent)) {
			parCnt++;
			parStr += "搜索内容:" + logContent + "；";
		}
		if (null != opTpCd && opTpCd > 0) {
			parCnt++;
			parStr += "操作类型:" + CodeNameMap.getOpTypeMap().get(opTpCd) + "；";
		}
		if (null != opPgCd && opPgCd > 0) {
			parCnt++;
			parStr += "操作页面:" + CodeNameMap.getOpPageMap().get(opPgCd) + "；";
		}
		if (StringUtils.isNotBlank(beginTime)) {
			parCnt++;
			parStr += "开始时间:" + beginTime + "；";
		}
		if (StringUtils.isNotBlank(endTime)) {
			parCnt++;
			parStr += "结束时间:" + endTime + "；";
		}

		if (doExport) {
			UserLogRecord.record("导出用户行为日志，筛选条件[ " + parStr + "]", Operation.Type.LOG_EXPORT, Operation.Page.userLogList,
					Operation.System.back, request); // todo xin leixing
		} else {
			if (0 == parCnt) {
				UserLogRecord.record("浏览用户行为日志列表", Operation.Type.browse, Operation.Page.userLogList, Operation.System.back, request);
			} else {
				UserLogRecord.record("搜索用户行为日志，搜索条件[ " + parStr + "]", Operation.Type.query, Operation.Page.userLogList,
						Operation.System.back, request);
			}
		}
		// 以上用于记录日志
		return ResponseBean.successResponse(rstMap);
	}

	@RequestMapping("/exportLogFile.do")
	@ResponseBody
	public Object exportBehaviorLogFile(@RequestParam int pageSize, Integer pageNumber, String userName, Integer areaCode, Integer sysCode,
			Integer opTpCd, Integer opPgCd, String beginTime, String endTime, String logContent, String orderBy, HttpServletRequest request,
			HttpSession session) {

		ResponseBean rb = (ResponseBean) listUserBehaviorLog(pageSize, pageNumber, userName, areaCode, sysCode, opTpCd, opPgCd, beginTime,
				endTime, logContent, orderBy, true, request, session);
		if (rb.isSuccess()) {
			Map<String, Object> rstMap = (Map<String, Object>) (rb.getContent());
			List<Map<String, Object>> lm = (List<Map<String, Object>>) (rstMap.get("list"));
			for (Map<String, Object> itr : lm) {
				itr.put("logSN", itr.get("logSN").toString());
			}
			String[] columnName = { "序号", "日志编号", "用户名", "真实姓名", "行政区", "所属部门", "IP地址", "系统位置", "操作", "操作页面", "详情", "发生时间" };
			String[] dataMapLeys = { "orderNum", "logSN", "loginName", "realName", "area", "department", "IpAddr", "sysLocation", "opType",
					"opPage", "logDetail", "genesicDT" };

			String logFileName = (String) (session.getAttribute("userName"));// 获取用户名
			logFileName += "-日志文件-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
			ExportExcel ee = new ExportExcel(logFileName);
			try {
				ee.createSheet("日志", columnName, dataMapLeys, lm);
				ee.exportExcel();
				return ResponseBean.successResponse(ee.getDownloadURL());
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseBean.errorResponse("服务器异常：" + e);
			}
		}
		return rb;
	}

	@RequestMapping("/queryListDictionary.do")
	@ResponseBody
	public Object queryListDictionary(@RequestParam String[] queryProject) {
		Map<String, Object> rstObj = new HashMap<>();
		for (int i = 0; i < queryProject.length; i++) {
			switch (queryProject[i]) {
			case "areaCodeList": // 区域代码
				rstObj.put("areaCodeList", ShanghaiAreaCode.quickGetList());
				break;
			case "sysLocationList": // 系统位置
				rstObj.put("sysLocationList", CodeNameMap.getSysLocationList());
				break;
			case "opTypeList": // 操作类型
				rstObj.put("opTypeList", CodeNameMap.getOpTypeList());
				break;
			case "opPageList": // 操作页面
				List<Map<String, Object>> pageList;
				if ((i + 1) < queryProject.length) {
					String ParamS = queryProject[i + 1];
					switch (ParamS) {
					case "forePage":
						pageList = Operation.Page.getOpPageListBySystem(true, Operation.System.front, false);
						break;
					case "backPage":
						pageList = Operation.Page.getOpPageListBySystem(true, Operation.System.back, false);
						break;
					default:
						pageList = CodeNameMap.getOpPageList();
						break;
					}
				} else {
					pageList = CodeNameMap.getOpPageList();
				}
				rstObj.put("opPageList", pageList);
				break;
			}
		}
		return ResponseBean.successResponse(rstObj);
	}
}
