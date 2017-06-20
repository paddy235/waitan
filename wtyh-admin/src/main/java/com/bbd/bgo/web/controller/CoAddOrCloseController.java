package com.bbd.bgo.web.controller;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.constants.ChangeType;
import com.bbd.wtyh.constants.CompanyClosedType;
import com.bbd.wtyh.constants.CompanyType;
import com.bbd.wtyh.constants.SourceType;
import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyStatusChangeDO;
import com.bbd.wtyh.excel.ExportExcel;
import com.bbd.wtyh.excel.Sheet;
import com.bbd.wtyh.exception.ExceptionHandler;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.CoAddOrCloseService;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.HSSFCellUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 企业变化监测-企业增销
 * 
 * Created by Administrator on 2017/4/18 0018.
 */
@Controller
@RequestMapping("/co-chg-monitor/co-add-close")
public class CoAddOrCloseController {

	@Autowired
	private CoAddOrCloseService coAddOrCloseService;
	@Autowired
	private AreaService areaService;

	@RequestMapping("/query-co-status-chg")
	@ResponseBody
	public ResponseBean queryCompanyStatusChg(String areaIds, String companyTypes, String beginDate, String endDate, Integer changeType,
			Integer source, Integer closedType, @RequestParam Integer page, @RequestParam Integer pageSize) {
		try {
			if (null == page) {
				page = 1;
			}
			if (null == pageSize) {
				pageSize = 20;
			}

			Map<String, Object> map = coAddOrCloseService.queryCompanyStatusChg(areaIds, companyTypes, beginDate, endDate, changeType,
					source, closedType, page, pageSize);

			return ResponseBean.successResponse(map);

		} catch (Exception e) {
			return ResponseBean.errorResponse("服务器异常：" + e);
		}

	}

	@RequestMapping("/download-co-status-chg")
	@ResponseBody
	public ResponseBean downloadCompanyStatusChg(String areaIds, String companyTypes, String beginDate, String endDate, Integer changeType,
			Integer source, Integer closedType, Integer page, Integer pageSize, HttpServletRequest request) {

		try {
			page=-1;
			pageSize=-1;

			// page=-1;//按条件下载全部数据
			Map<String, Object> map = coAddOrCloseService.queryCompanyStatusChg(areaIds, companyTypes, beginDate, endDate, changeType,
					source, closedType, page, pageSize);
			List<CompanyStatusChangeDO> list = (List<CompanyStatusChangeDO>) map.get("results");

			String loginName = request.getSession().getAttribute(Constants.SESSION.loginName) + "";
			String date = StringUtils.remove(beginDate, "-") + "-" + StringUtils.remove(endDate, "-");
			String excelName = "增销企业列表（" + date + "）";
			String nowTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
			excelName = loginName + "-" + excelName + "-" + nowTime;

			ExportExcel exportExcel = new ExportExcel(excelName);
			Sheet sheet = exportExcel.createSheet(list);
			// 合并单元格
			HSSFSheet hssfSheet = sheet.getHSSFSheet();
			HSSFRow titleRow = hssfSheet.createRow(0);
			titleRow.setHeight((short) 400);

			HSSFCell titleCell = HSSFCellUtil.getCell(titleRow, 0);
			titleCell.setCellStyle(exportExcel.createDefaultStyle());
			titleCell.setCellValue("筛选时间");

			HSSFCell titleCell1 = HSSFCellUtil.getCell(titleRow, 1);
			titleCell1.setCellValue(beginDate);
			titleCell1.setCellStyle(exportExcel.createDefaultStyle());

			HSSFCell titleCell2 = HSSFCellUtil.getCell(titleRow, 2);
			titleCell2.setCellValue(endDate);
			titleCell2.setCellStyle(exportExcel.createDefaultStyle());

			exportExcel.exportExcel();



			UserLogRecord.record("导出企业增销", Operation.Type.DATA_EXPORT, Operation.Page.companyAddClose,
					Operation.System.back, request);

			return ResponseBean.successResponse(exportExcel.getDownloadURL());
		} catch (Exception e) {
			return ExceptionHandler.handlerException(e);
		}

	}

	@RequestMapping("/get-closed-type")
	@ResponseBody
	public ResponseBean getClosedType() {
		CompanyClosedType[] types = CompanyClosedType.values();
		Map results = new HashMap();
		List<Map<String, Object>> list = new ArrayList<>();
		setAllElement(list, "code", "name");
		for (CompanyClosedType rl : types) {
			Map<String, Object> map = new HashMap<>();
			map.put("code", rl.type());
			map.put("name", rl.desc());
			list.add(map);
		}
		results.put("results", list);
		return ResponseBean.successResponse(results);
	}

	@RequestMapping("/get-change-type")
	@ResponseBody
	public ResponseBean getChangeType() {
		ChangeType[] types = ChangeType.values();
		Map results = new HashMap();
		List<Map<String, Object>> list = new ArrayList<>();
		setAllElement(list, "code", "name");
		for (ChangeType rl : types) {
			Map<String, Object> map = new HashMap<>();
			map.put("code", rl.type());
			map.put("name", rl.desc());
			list.add(map);
		}
		results.put("results", list);
		return ResponseBean.successResponse(results);
	}

	@RequestMapping("/get-source-type")
	@ResponseBody
	public ResponseBean getSourceType() {
		SourceType[] types = SourceType.values();
		Map results = new HashMap();
		List<Map<String, Object>> list = new ArrayList<>();
		setAllElement(list, "code", "name");
		for (SourceType rl : types) {
			Map<String, Object> map = new HashMap<>();
			map.put("code", rl.type());
			map.put("name", rl.desc());
			list.add(map);
		}
		results.put("results", list);
		return ResponseBean.successResponse(results);
	}

	@RequestMapping("/get-company-type")
	@ResponseBody
	public ResponseBean getCompanyType() {
		CompanyType[] types = CompanyType.values();
		Map results = new HashMap();
		List<Map<String, Object>> list = new ArrayList<>();
		setAllElement(list, "code", "name");
		for (CompanyType rl : types) {
			Map<String, Object> map = new HashMap<>();
			map.put("code", rl.type());
			map.put("name", rl.desc());
			list.add(map);
		}
		results.put("results", list);
		return ResponseBean.successResponse(results);
	}

	@RequestMapping("/get-all-area")
	@ResponseBody
	public ResponseBean getAllArea() {
		List<AreaDO> areaList = areaService.areaListAll(Constants.SH_AREAID);
		Map results = new HashMap();
		List<Map<String, Object>> list = new ArrayList<>();
		setAllElement(list, "areaId", "name");
		for (AreaDO area : areaList) {
			Map<String, Object> map = new HashMap<>();
			map.put("areaId", area.getAreaId());
			map.put("name", area.getName());
			list.add(map);
		}
		results.put("results", list);
		return ResponseBean.successResponse(results);
	}

	private void setAllElement(List list, String codeKey, String nameKey) {
		Map<String, Object> map = new HashMap<>();
		map.put(codeKey, "0");
		map.put(nameKey, "全部");
		list.add(map);
	}
}
