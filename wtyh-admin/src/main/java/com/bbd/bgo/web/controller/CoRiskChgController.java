package com.bbd.bgo.web.controller;

import com.bbd.wtyh.constants.JYSCoRiskLevel;
import com.bbd.wtyh.constants.PrepaidCoRiskLevel;
import com.bbd.wtyh.constants.RZZLCoRiskLevel;
import com.bbd.wtyh.constants.RiskChgCoSource;
import com.bbd.wtyh.core.entity.Pagination;
import com.bbd.wtyh.core.utils.ParamUtil;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.RiskChgCoDo;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.excel.ExportExcel;
import com.bbd.wtyh.excel.Sheet;
import com.bbd.wtyh.exception.ExceptionHandler;
import com.bbd.wtyh.service.CoRiskChgService;
import com.bbd.wtyh.util.CoRiskchgUtil;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.HSSFCellUtil;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企业变化监测-风险变化企业
 *
 * @author Created by LiYao on 2017-04-19 16:03.
 */
@Controller
@RequestMapping("/co-chg-monitor/co-risk-chg")
public class CoRiskChgController {

	@Autowired
	private CoRiskChgService coRiskChgService;

	/**
	 * 企业变化监测-风险变化企业-页面下拉列表数据
	 *
	 * @return
	 */
	@RequestMapping("/drop-down-data")
	@ResponseBody
	public Object riskChgCoDropDownData() {
		Map<String, Object> data = new HashMap<>();
		// 金融类型
		data.put("financialType", this.riskChgCoFinancialType());
		// 风险等级
		// data.put("riskLevel", this.riskChgCoRiskLevel((int)
		// CompanyDO.TYPE_P2P_1));
		// 来源
		data.put("source", this.riskChgCoSource());

		return ResponseBean.successResponse(data);
	}

	/**
	 * 企业变化监测-风险变化企业-风险状态下拉列表
	 *
	 * @return
	 */
	@RequestMapping("/risk-drop-down")
	@ResponseBody
	private Object riskChgCoRiskLevel(@RequestParam Integer companyType) {
		byte type = companyType.byteValue();

		// 网络借贷 线下理财
		if (type == CompanyDO.TYPE_P2P_1 || type == CompanyDO.TYPE_XXLC_4) {
			return ResponseBean.successResponse(CompanyAnalysisResult.getListMap());
		}
		// 交易所
		if (CompanyDO.TYPE_JYS_9 == type) {
			return ResponseBean.successResponse(JYSCoRiskLevel.getListMap());
		}
		// 预付卡
		if (CompanyDO.TYPE_YFK_11 == type) {
			return ResponseBean.successResponse(PrepaidCoRiskLevel.getListMap());
		}
		// 融资租赁
		if (CompanyDO.TYPE_RZZL_13 == type) {
			return ResponseBean.successResponse(RZZLCoRiskLevel.getListMap());
		}
		return ResponseBean.errorResponse("没有对应的公司类型");
	}

	/**
	 * 企业变化监测-风险变化企业-楼宇
	 *
	 * @return
	 */
	@RequestMapping("/build-drop-down-data")
	@ResponseBody
	public Object buildDropDownData(String areaSet) {
		List<Map<String, Object>> mapList = this.coRiskChgService.riskChgCoBuilding(areaSet);
		return ResponseBean.successResponse(mapList);
	}

	/**
	 * 企业变化监测-风险变化企业-数据查询
	 * 
	 * @param sdate
	 *            开始时间
	 * @param edate
	 *            结束时间
	 * @param areaSet
	 *            区域ID集合，逗号分割
	 * @param financialType
	 *            金融类别
	 * @param buildId
	 *            楼宇ID
	 * @param riskLevel
	 *            风险等级
	 * @param source
	 *            来源
	 * @param statusSort
	 *            原始状态排序。DESC：降序，ASC：升序，DEFAULT：默认排序
	 * @param pageIndex
	 *            页码
	 * @param pageSize
	 *            每页大小，默认20
	 * @return
	 */
	@RequestMapping("/query-data")
	@ResponseBody
	public Object queryData(HttpServletRequest request, Pagination page) {

		Map<String, String> paramMap = ParamUtil.getRequestParamMap(request);

		this.coRiskChgService.queryPageData(paramMap, page);

		return ResponseBean.successResponse(page);
	}

	/**
	 * 下载风险变化企业数据
	 * 
	 * @param 同queryData()的方法
	 * @return
	 */
	@RequestMapping("/download-data")
	@ResponseBody
	public Object downloadData(HttpServletRequest request, @RequestParam Integer financialType, boolean isPaging, Pagination page) {

		List<RiskChgCoDo> list;

		try {
			Map<String, String> paramMap = ParamUtil.getRequestParamMap(request);

			if (isPaging) {
				list = this.coRiskChgService.queryPageData(paramMap, page);
			} else {
				list = this.coRiskChgService.queryAllData(paramMap);
			}
			String date = paramMap.get("sdate") + "~" + paramMap.get("edate");
			String excelName = "风险变化企业列表（" + CompanyDO.companyTypeCN(financialType.byteValue()) + date + "）";
			ExportExcel exportExcel = new ExportExcel(excelName);
			Sheet sheet = exportExcel.createSheet(list);
			sheet.setColumnName(CoRiskchgUtil.exportName(financialType));
			sheet.setDataMapKeys(CoRiskchgUtil.exportKey(financialType));
			// 合并单元格
			HSSFSheet hssfSheet = sheet.getHSSFSheet();
			// 合并单元格第一行
			CellRangeAddress cra = new CellRangeAddress(0, 0, 1, sheet.getDataMapKeys().length - 1);
			hssfSheet.addMergedRegion(cra);
			HSSFRow titleRow = hssfSheet.createRow(0);
			titleRow.setHeight((short) 400);
			for (int j = cra.getFirstColumn(); j <= cra.getLastColumn(); j++) {
				HSSFCell singleCell = HSSFCellUtil.getCell(titleRow, j);
				singleCell.setCellStyle(sheet.getHeaderStyle());
			}

			HSSFCell titleCell = HSSFCellUtil.getCell(titleRow, 0);
			titleCell.setCellStyle(sheet.getHeaderStyle());
			titleCell.setCellValue("筛选时间");

			HSSFCell titleCell1 = HSSFCellUtil.getCell(titleRow, 1);
			titleCell1.setCellValue(date);

			exportExcel.exportExcel();
			return ResponseBean.successResponse(exportExcel.getDownloadURL());
		} catch (Exception e) {
			return ExceptionHandler.handlerException(e);
		}
	}

	/**
	 * 企业变化监测-风险变化企业-新金融类别
	 * 
	 * @return
	 */
	private Object riskChgCoFinancialType() {
		byte[] typeNums = { CompanyDO.TYPE_P2P_1, CompanyDO.TYPE_XD_2, CompanyDO.TYPE_RZDB_3, CompanyDO.TYPE_XXLC_4, CompanyDO.TYPE_JYS_9,
				CompanyDO.TYPE_YFK_11, CompanyDO.TYPE_RZZL_13 };

		List<Map<String, Object>> typeList = new ArrayList<>();
		for (byte type : typeNums) {
			Map<String, Object> map = new HashMap<>();
			map.put("type", type);
			map.put("typeName", CompanyDO.companyTypeCN(type));
			typeList.add(map);
		}
		return typeList;
	}

	/**
	 * 企业变化监测-风险变化企业-来源
	 *
	 * @return
	 */

	private Object riskChgCoSource() {
		RiskChgCoSource[] risks = RiskChgCoSource.values();
		List<Map<String, Object>> riskList = new ArrayList<>();
		for (RiskChgCoSource rl : risks) {
			Map<String, Object> map = new HashMap<>();
			map.put("type", rl.type());
			map.put("desc", rl.desc());
			riskList.add(map);
		}
		return riskList;
	}
}
