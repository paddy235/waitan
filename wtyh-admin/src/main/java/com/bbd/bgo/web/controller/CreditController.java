package com.bbd.bgo.web.controller;

import com.bbd.bgo.quartz.TaskUtil;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyCreditPointItemsDO;
import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.domain.dto.CreditInfoDTO;
import com.bbd.wtyh.excel.ExportExcel;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.mapper.CompanyCreditInformationMapper;
import com.bbd.wtyh.mapper.CompanyCreditMapper;
import com.bbd.wtyh.service.CoCreditScoreService;
import com.bbd.wtyh.web.ResponseBean;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企业变化监测-风险变化企业
 *
 * @author Created by sun on 2017-04-19 16:03.
 */
@Controller
@RequestMapping("/credit")
public class CreditController {

	@Autowired
	private CompanyCreditMapper companyCreditMapper;

	@Autowired
	private CoCreditScoreService coCreditScoreService;

	@Autowired
	private CompanyCreditInformationMapper companyCreditInformationMapper;


	@RequestMapping("/execCredit")
	@ResponseBody
	public ResponseBean creditScoreCalculate() {
		Integer taskId;
        TaskResultDO taskResultDO;
		Integer runMode = 0;// 运行方式：0 自动执行， 1 手动执行
		taskId = TaskUtil.taskStart("shangHaiCreditJob", "credit_work", null, runMode, null, null);

        taskResultDO = coCreditScoreService.creditScoreCalculate(taskId, runMode);

		TaskUtil.taskEnd(taskId, taskResultDO, null, 1);

		return ResponseBean.successResponse(taskResultDO);
	}

	@RequestMapping("/execByTaskId")
	@ResponseBody
	public ResponseBean execFailCompanyByTaskId(Integer taskId, HttpServletRequest request) {

		String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        TaskResultDO taskResultDO;
		Integer newTaskId;
		Integer runMode = 1;// 运行方式：0 自动执行， 1 手动执行

		newTaskId = TaskUtil.taskStart("shangHaiCreditJob", "credit_work", null, runMode, null, loginName);

        taskResultDO = coCreditScoreService.executeFailCompanyByTaskId(runMode, taskId, newTaskId);

		TaskUtil.taskEnd(newTaskId, taskResultDO, loginName, 1);

		return ResponseBean.successResponse(taskResultDO);
	}

	@RequestMapping("/getCompany")
	@ResponseBody
	public ResponseBean getCompany(String companyName) {

		try {
			if (StringUtils.isEmpty(companyName)) {
				companyName = null;
			}
			List<CreditInfoDTO> list = companyCreditMapper.getCreditCompany(companyName);

			return ResponseBean.successResponse(list);
		} catch (Exception e) {
			return ResponseBean.errorResponse(null);
		}

	}

	@RequestMapping("/getCreditData")
	@ResponseBody
	public ResponseBean getCreditData(String companyName, String dataType, HttpServletRequest request) {

		try {
			if (StringUtils.isEmpty(companyName)) {
				return ResponseBean.errorResponse("请输入企业名称");
			}
			if (StringUtils.isEmpty(dataType)) {
				dataType = null;
			}

			List<CreditInfoDTO> list = coCreditScoreService.getCreditInfo(companyName, dataType);

			UserLogRecord.record("搜索["+companyName+"]", Operation.Type.query, Operation.Page.creditDataManager,
					Operation.System.back, request);
			if(null == list || list.size()==0){
				return ResponseBean.errorResponse("该企业无数据");
			}
			return ResponseBean.successResponse(list);
		} catch (Exception e) {
			return ResponseBean.errorResponse("数据错误");
		}

	}

	@RequestMapping("/downloadCreditData")
	@ResponseBody
	public ResponseBean downloadCreditData(String companyName, String dataType, HttpServletRequest request) {

		try {

			if (StringUtils.isEmpty(companyName)) {
				return ResponseBean.errorResponse("请输入企业名称");
			}
			if (StringUtils.isEmpty(dataType)) {
				dataType = null;
			}
			List<CreditInfoDTO> list = coCreditScoreService.getCreditInfo(companyName, dataType);
			String excelName = "公信数据(" + companyName + ")";
			ExportExcel exportExcel = new ExportExcel(excelName);
			ExportExcel.getPageSheet(list,exportExcel,10000,"sheet");
			exportExcel.exportExcel();

			UserLogRecord.record("导出公信数据["+companyName+"]", Operation.Type.DATA_EXPORT, Operation.Page.creditDataManager,
					Operation.System.back, request);

			return ResponseBean.successResponse(exportExcel.getDownloadURL());
		} catch (Exception e) {
			return ResponseBean.errorResponse(null);
		}

	}

	@RequestMapping("/getCreditDataType")
	@ResponseBody
	public ResponseBean getCreditDataType(HttpServletRequest request) {

		try {

			List<Map<String, String>> list = new ArrayList<>();
			Map<String, String> map = new HashMap<>();
			map.put("code", "0");
			map.put("name", "全部");
			list.add(map);
			List<CompanyCreditPointItemsDO> items = companyCreditInformationMapper.selectCompanyCreditPointItems();
			for (CompanyCreditPointItemsDO c : items) {
				map = new HashMap<>();
				map.put("code", c.getId().toString());
				map.put("name", c.getItem());
				list.add(map);
			}

			UserLogRecord.record("浏览公信中心数据管理", Operation.Type.browse, Operation.Page.creditDataManager,
					Operation.System.back, request);

			return ResponseBean.successResponse(list);

		} catch (Exception e) {

			return ResponseBean.errorResponse(null);
		}

	}

}
