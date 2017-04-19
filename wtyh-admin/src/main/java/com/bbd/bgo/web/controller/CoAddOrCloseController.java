package com.bbd.bgo.web.controller;

import com.bbd.wtyh.domain.CompanyStatusChangeDO;
import com.bbd.wtyh.excel.ExportExcel;
import com.bbd.wtyh.exception.ExceptionHandler;
import com.bbd.wtyh.service.CoAddOrCloseService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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

	@RequestMapping("/query-co-status-chg")
	@ResponseBody
	public ResponseBean queryCompanyStatusChg(Integer areaId, Integer companyType, String beginDate, String endDate, Integer changeTpye,
			Integer source, Integer closedType, @RequestParam Integer page, @RequestParam Integer pageSize) {
		try {
			if (null == page) {
				page = 1;
			}
			if (null == pageSize) {
				pageSize = 10;
			}

			Map<String, Object> map = coAddOrCloseService.queryCompanyStatusChg(areaId, companyType, beginDate, endDate, changeTpye, source,
					closedType, page, pageSize);

			return ResponseBean.successResponse(map);

		} catch (Exception e) {
			return ResponseBean.errorResponse("服务器异常：" + e);
		}

	}

	@RequestMapping("/download-co-status-chg")
	@ResponseBody
	public ResponseBean downloadCompanyStatusChg(Integer areaId, Integer companyType, String beginDate, String endDate, Integer changeTpye,
			Integer source, Integer closedType, @RequestParam Integer page, @RequestParam Integer pageSize) {

		ExportExcel exportExcel = new ExportExcel();
		try {
			if (null == page) {
				page = 1;
			}
			if (null == pageSize) {
				pageSize = 10;
			}

			Map<String, Object> map = coAddOrCloseService.queryCompanyStatusChg(areaId, companyType, beginDate, endDate, changeTpye, source,
					closedType, page, pageSize);
			List<CompanyStatusChangeDO> list = (List<CompanyStatusChangeDO>) map.get("results");
			exportExcel.createSheet(list);
			exportExcel.exportExcel();
			return ResponseBean.successResponse("/download/download-excel.do?name=" + exportExcel.getExcelName());

		} catch (Exception e) {
			return ExceptionHandler.handlerException(e);
		}

	}
}
