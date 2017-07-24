package com.bbd.bgo.web.controller;

import com.bbd.bgo.quartz.TaskUtil;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyCreditPointItemsDO;
import com.bbd.wtyh.domain.dto.CreditInfoDTO;
import com.bbd.wtyh.excel.ExportExcel;
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
 * Created by suyin on 2016/8/27.
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

	private static String TASK_NAME = "shangHaiCreditJob";
	private static String TASK_GROUP = "credit_work";

	@RequestMapping("/execCredit")
	@ResponseBody
	public ResponseBean creditScoreCalculate() {
		Map map;
		Integer taskId;
		Integer planCount = null;// 计划执行笔数。 可在任务结束时更新
		Integer successCount = null;
		Integer failCount = null;

		String dataVersion = null;// 有版本号的传版本号，没有的不传，根据自己的业务规则定
		Integer runMode = 0;// 运行方式：0 自动执行， 1 手动执行
		taskId = TaskUtil.taskStart("shangHaiCreditJob", "credit_work", dataVersion, runMode, null, null);

		map = coCreditScoreService.creditScoreCalculate(taskId, runMode);

		if (null != map) {
			planCount = map.get("planCount") == null ? null : (Integer) map.get("planCount");
			successCount = map.get("successCount") == null ? null : (Integer) map.get("successCount");
			failCount = map.get("failCount") == null ? null : (Integer) map.get("failCount");
		}
		TaskUtil.taskEnd(taskId, planCount, successCount, failCount, null, 1);

		return ResponseBean.successResponse(map);
	}

	@RequestMapping("/execByTaskId")
	@ResponseBody
	public ResponseBean execFailCompanyByTaskId(Integer taskId, HttpServletRequest request) {

		String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
		Map map;
		Integer newTaskId;
		Integer planCount = null;// 计划执行笔数。 可在任务结束时更新
		Integer successCount = null;
		Integer failCount = null;
		String dataVersion = null;// 有版本号的传版本号，没有的不传，根据自己的业务规则定
		Integer runMode = 1;// 运行方式：0 自动执行， 1 手动执行

		newTaskId = TaskUtil.taskStart("shangHaiCreditJob", "credit_work", dataVersion, runMode, planCount, loginName);

		map = coCreditScoreService.executeFailCompanyByTaskId(runMode, taskId, newTaskId);
		if (null != map) {
			planCount = map.get("planCount") == null ? null : (Integer) map.get("planCount");
			successCount = map.get("successCount") == null ? null : (Integer) map.get("successCount");
			failCount = map.get("failCount") == null ? null : (Integer) map.get("failCount");
		}
		TaskUtil.taskEnd(newTaskId, planCount, successCount, failCount, loginName, 1);

		return ResponseBean.successResponse(map);
	}

	@RequestMapping("/getCompany")
	@ResponseBody
	public ResponseBean getCompany(String companyName, HttpServletRequest request) {

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

			return ResponseBean.successResponse(list);
		} catch (Exception e) {

			return ResponseBean.errorResponse(null);
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
			exportExcel.createSheet(list);
			exportExcel.exportExcel();
			return ResponseBean.successResponse(exportExcel.getDownloadURL());
		} catch (Exception e) {
			return ResponseBean.errorResponse(null);
		}

	}

	@RequestMapping("/getCreditDataType")
	@ResponseBody
	public ResponseBean getCreditDataType() {

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
			return ResponseBean.successResponse(list);

		} catch (Exception e) {

			return ResponseBean.errorResponse(null);
		}

	}

}
