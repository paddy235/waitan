package com.bbd.bgo.web.controller;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.bbd.wtyh.cachetobean.ShanghaiAreaCode;
import com.bbd.wtyh.common.comenum.UserRank;
import com.bbd.wtyh.domain.vo.UseDetailVO;
import com.bbd.wtyh.domain.vo.UseHotPage;
import com.bbd.wtyh.domain.vo.UserSearchVO;
import com.bbd.wtyh.excel.ExportExcel;
import com.bbd.wtyh.excel.ExportExcelExample;
import com.bbd.wtyh.exception.ExceptionHandler;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.map.name.code.CodeNameMap;
import com.bbd.wtyh.service.UserBehaviorLogService;
import com.bbd.wtyh.util.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.web.ResponseBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by cgj on 2017/3/20.
 */

@Controller
@RequestMapping("/userBehaviorLog")
public class UserBehaviorLogController {

	@Autowired
	UserBehaviorLogService ubls;

	@Value("${exportExcel.userOperator}")
	private String userOperator;

	List<UseDetailVO> opeList = new ArrayList<>();





	@RequestMapping("/listUserBehaviorLog.do")
	@ResponseBody
	public Object listUserBehaviorLog(@RequestParam int pageSize, Integer pageNumber, String userName, Integer areaCode, Integer sysCode,
			Integer opTpCd, Integer opPgCd, String beginTime, String endTime, String logContent, String orderBy, boolean doExport,
			HttpServletRequest request, HttpSession session) {
		Map<String, Object> rstMap;
		try {
			String excludeName = null;

			if (((UserRank) (session.getAttribute("userRank"))).getRankVal() < UserRank.SUPER_A.getRankVal()) {
				excludeName = "admin"; // ?????????????????????????????????????????????????????????????????????
			}
			rstMap = ubls.listUserBehaviorLog(pageSize, pageNumber, excludeName, userName, areaCode, sysCode, opTpCd, opPgCd,
					DateUtils.stringToDate(beginTime), DateUtils.stringToDate(endTime), logContent, orderBy);
		} catch (BusinessException be) {
			return ResponseBean.errorResponse(be.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBean.errorResponse("??????????????????" + e);
		}
		// ????????????????????????
		int parCnt = 0;
		String parStr = "";
		if (StringUtils.isNotBlank(userName)) {
			parCnt++;
			parStr += "??????????????????:" + userName + "???";
		}
		if (null != areaCode && areaCode > 0) {
			parCnt++;
			parStr += "?????????:" + ShanghaiAreaCode.getMap().get(areaCode) + "???";
		}
		if (null != sysCode && sysCode > 0) {
			parCnt++;
			parStr += "????????????:" + CodeNameMap.getSysLocationMap().get(sysCode) + "???";
		}
		if (StringUtils.isNotEmpty(logContent)) {
			parCnt++;
			parStr += "????????????:" + logContent + "???";
		}
		if (null != opTpCd && opTpCd > 0) {
			parCnt++;
			parStr += "????????????:" + CodeNameMap.getOpTypeMap().get(opTpCd) + "???";
		}
		if (null != opPgCd && opPgCd > 0) {
			parCnt++;
			parStr += "????????????:" + CodeNameMap.getOpPageMap().get(opPgCd) + "???";
		}
		if (StringUtils.isNotBlank(beginTime)) {
			parCnt++;
			parStr += "????????????:" + beginTime + "???";
		}
		if (StringUtils.isNotBlank(endTime)) {
			parCnt++;
			parStr += "????????????:" + endTime + "???";
		}

		if (doExport) {
			UserLogRecord.record("???????????????????????????????????????[ " + parStr + "]", Operation.Type.LOG_EXPORT, Operation.Page.userLogList,
					Operation.System.back, request); // todo xin leixing
		} else {
			if (0 == parCnt) {
				UserLogRecord.record("??????????????????????????????", Operation.Type.browse, Operation.Page.userLogList, Operation.System.back, request);
			} else {
				UserLogRecord.record("???????????????????????????????????????[ " + parStr + "]", Operation.Type.query, Operation.Page.userLogList,
						Operation.System.back, request);
			}
		}
		// ????????????????????????
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
			String[] columnName = { "??????", "????????????", "?????????", "????????????", "?????????", "????????????", "IP??????", "????????????", "??????", "????????????", "??????", "????????????" };
			String[] dataMapLeys = { "orderNum", "logSN", "loginName", "realName", "area", "department", "IpAddr", "sysLocation", "opType",
					"opPage", "logDetail", "genesicDT" };

			String logFileName = (String) (session.getAttribute("userName"));// ???????????????
			logFileName += "-????????????-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
			ExportExcel ee = new ExportExcel(logFileName);
			try {
				ee.createSheet("??????", columnName, dataMapLeys, lm);
				ee.exportExcel();

				UserLogRecord.record("????????????", Operation.Type.DATA_EXPORT, Operation.Page.userLogList,
						Operation.System.back, request);

				return ResponseBean.successResponse(ee.getDownloadURL());
			} catch (Exception e) {
				return ExceptionHandler.handlerException(e);
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
			case "areaCodeList": // ????????????
				rstObj.put("areaCodeList", ShanghaiAreaCode.quickGetList());
				break;
			case "sysLocationList": // ????????????
				rstObj.put("sysLocationList", CodeNameMap.getSysLocationList());
				break;
			case "opTypeList": // ????????????
				rstObj.put("opTypeList", CodeNameMap.getOpTypeList());
				break;
			case "opPageList": // ????????????
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

	//???????????????????????????
	@RequestMapping(value = "/logStatistics.do", method = RequestMethod.GET)
	@ResponseBody
	public Object logStatistics(@RequestParam(defaultValue = "1")Integer sysCode, String beginTime, String endTime,HttpServletRequest req, HttpServletResponse response,HttpSession session){
		if(-1==sysCode){
			return ResponseBean.errorResponse("??????????????????");
		}

		//
		String excludeName = null;

		if (((UserRank) (session.getAttribute("userRank"))).getRankVal() < UserRank.SUPER_A.getRankVal()) {
			excludeName = "admin"; // ?????????????????????????????????????????????????????????????????????
		}

		//??????list
		opeList.clear();
		HSSFWorkbook workbook = new HSSFWorkbook();
		String sysName = null;
		if(2==sysCode){
			sysName = "??????";
		}else {
			sysName = "??????";
		}
		Date begin = DateUtils.stringToDate(beginTime);
		Date end = DateUtils.stringToDate(endTime);

		String time = null;
		if(StringUtils.isBlank(beginTime)){
			time = "";
		}else{
			time = "("+DateUtils.formatDateYmd2(begin)+"-"+DateUtils.formatDateYmd2(end)+")";
		}

		try{
			int num = 0;

			//??????
			List<Map<String,Object>> list = ubls.listUserOperaLog(begin,end,sysCode,excludeName);

			for (Map<String,Object> map:list) {
//				int total = 0;
				UseDetailVO uDetail = new UseDetailVO();
				uDetail.setNumIndex((++num)+"");
				uDetail.setArea(map.get("name").toString());
				String [] s1 = map.get("operation_type").toString().split(",");
				String [] s2 = map.get("countType").toString().split(",");
//				for(int i=0;i<s2.length;i++){
//						total += Integer.parseInt(s2[i]);
//					}
				Long total = (Long)map.get("total");
				uDetail.setTotal(total.intValue());
				switchType(s1,s2,uDetail);
			}

			//??????excel
			String sheetName = "1????????????????????????"+time;
			HSSFSheet sheet = workbook.createSheet();
			String headTitle = "???????????????????????????"+sysName+"???";
			workbook.setSheetName(0, sheetName);

			Integer [] res = this.totalMethod(opeList);
			HSSFWorkbook hssfWorkbook = ubls.produceExcel(workbook,sheet,opeList,headTitle,res);

			//??????????????????
			List<UseHotPage> hotPageList = null;
			hotPageList = ubls.findHotPage(begin,end,sysCode,excludeName);
			HSSFSheet sheet2 = workbook.createSheet();
			String sheetName2 = "2????????????????????????"+time;
			String headTitle2 = "???????????????????????????"+sysName+"???";
			workbook.setSheetName(1, sheetName2);
			HSSFWorkbook hssfWorkbook2 = ExportExcelExample.extraExcel(hssfWorkbook,sheet2,hotPageList,headTitle2);


			List<UserSearchVO> list2 = null;
			list2 = ubls.findKeyWord(begin,end,sysCode,excludeName);
			HSSFSheet sheet3 = workbook.createSheet();
			String sheetName3 = "3?????????????????????"+time;
			String headTitle3 = "????????????????????????"+sysName+"???";
			workbook.setSheetName(2, sheetName3);
			HSSFWorkbook hssfWorkbook3 = ubls.produceExcel3(hssfWorkbook2,sheet3,list2,headTitle3);

			response.setCharacterEncoding("utf-8");
			if (null != hssfWorkbook3) {
				try {
					// ??????response
					response.reset();
					response.addHeader("Content-Disposition", "attachment;filename=" + getFileName("?????????????????????.xls", req));
//                    response.addHeader("Content-Disposition","attachment;filename=" + new String("??????????????????-??????.xls".getBytes("gb2312"),"iso-8859-1"));
					response.setContentType("application/octet-stream");
					OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
					hssfWorkbook3.write(outputStream);
					outputStream.flush();
					outputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
//					LOGGER.error("??????????????????????????????", e);
				}
			}
		}catch (Exception e) {
			return ExceptionHandler.handlerException(e);
		}
		return ResponseBean.successResponse("????????????");
	}

	public Integer [] totalMethod(List<UseDetailVO> uv){
		Integer [] total = new Integer[17];
		for(int i=0;i<total.length;i++){
			total[i] = 0;
		}
		for(int i=0;i<uv.size();i++){
			total[0] +=(null==uv.get(i).getTotal()?0:uv.get(i).getTotal());
			total[1] +=(null==uv.get(i).getLogIn()?0:uv.get(i).getLogIn());
			total[2] +=(null==uv.get(i).getLogOut()?0:uv.get(i).getLogOut());
			total[3] +=(null==uv.get(i).getSel()?0:uv.get(i).getSel());
			total[4] +=(null==uv.get(i).getSearch()?0:uv.get(i).getSearch());
			total[5] +=(null==uv.get(i).getAdd()?0:uv.get(i).getAdd());
			total[6] +=(null==uv.get(i).getModify()?0:uv.get(i).getModify());
			total[7] +=(null==uv.get(i).getDel()?0:uv.get(i).getDel());
			total[8] +=(null==uv.get(i).getLock()?0:uv.get(i).getLock());
			total[9] +=(null==uv.get(i).getAct()?0:uv.get(i).getAct());
			total[10] +=(null==uv.get(i).getDocuExport()?0:uv.get(i).getDocuExport());
			total[11] +=(null==uv.get(i).getDataExport()?0:uv.get(i).getDataExport());
			total[12] +=(null==uv.get(i).getLogExport()?0:uv.get(i).getLogExport());
			total[13] +=(null==uv.get(i).getInfor()?0:uv.get(i).getInfor());
			total[14] +=(null==uv.get(i).getImple()?0:uv.get(i).getImple());
			total[15] +=(null==uv.get(i).getDown()?0:uv.get(i).getDown());
			total[16] +=(null==uv.get(i).getImpo()?0:uv.get(i).getImpo());
		}
		return total;
	}

	public void switchType(String [] s1,String [] s2,UseDetailVO uDetail){
		for(int i=0;i<s1.length;i++){
			switch (s1[i]){
				case "1":
					uDetail.setLogIn(Integer.parseInt(s2[i]));
					break;
				case "2":
					uDetail.setLogOut(Integer.parseInt(s2[i]));
					break;
				case "3":
					uDetail.setSel(Integer.parseInt(s2[i]));
					break;
				case "4":
					uDetail.setSearch(Integer.parseInt(s2[i]));
					break;
				case "5":
					uDetail.setAdd(Integer.parseInt(s2[i]));
					break;
				case "6":
					uDetail.setModify(Integer.parseInt(s2[i]));
					break;
				case "7":
					uDetail.setDel(Integer.parseInt(s2[i]));
					break;
				case "8":
					uDetail.setLock(Integer.parseInt(s2[i]));
					break;
				case "9":
					uDetail.setAct(Integer.parseInt(s2[i]));
					break;
				case "10":
					uDetail.setDocuExport(Integer.parseInt(s2[i]));
					break;
				case "11":
					uDetail.setDataExport(Integer.parseInt(s2[i]));
					break;
				case "12":
					uDetail.setLogExport(Integer.parseInt(s2[i]));
					break;
				case "13":
					uDetail.setInfor(Integer.parseInt(s2[i]));
					break;
				case "14":
					uDetail.setImple(Integer.parseInt(s2[i]));
					break;
				case "15":
					uDetail.setDown(Integer.parseInt(s2[i]));
					break;
				case "16":
					uDetail.setImpo(Integer.parseInt(s2[i]));
					break;
			}
		}
		opeList.add(uDetail);

	}

	private String getFileName(String fileName, HttpServletRequest req) {
		try {
			String agent = getBrowserName(req.getHeader("User-Agent").toLowerCase());
			if (agent.equals("Firefox")) {
				return new String(fileName.getBytes("utf-8"), "iso-8859-1");
//                return "=?UTF-8?B?" + (new String(Base64.encodeBase64(fileName.getBytes("UTF-8")))) + "?=";
			} else {
				return java.net.URLEncoder.encode(fileName, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
//			LOGGER.error("?????????????????????", e);
			return fileName;
		}
	}

	private String getBrowserName(String agent) {
		if (agent.indexOf("firefox") > 0) {
			return "Firefox";
		} else {
			return "Others";
		}
	}

}
