package com.bbd.bgo.web.controller;

import com.bbd.data.service.DataService;
import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;
import com.bbd.wtyh.domain.credit.CompanyCreditFailInfoDO;
import com.bbd.wtyh.mapper.TaskSuccessFailInfoMapper;
import com.bbd.wtyh.service.CoCreditScoreService;
import com.bbd.wtyh.web.ResponseBean;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
	private DataService dataService;
	@Autowired
	private TaskSuccessFailInfoMapper taskSuccessFailInfoMapper;

	private static String TASK_NAME = "shangHaiCreditJob";
	private static String TASK_GROUP = "credit_work";

	@RequestMapping("/info")
	public String info(String companyName, HttpServletRequest request) {

		if (StringUtils.hasText(companyName)) {
			request.setAttribute("list", dataService.getCredit(companyName));
		}

		return "geo/credit";
	}

	@Autowired
	private CoCreditScoreService coCreditScoreService;

	@RequestMapping("/credit-score-calculate")
	@ResponseBody
	public ResponseBean creditScoreCalculate() {
		Map data = new HashMap();
		Integer taskId = coCreditScoreService.creditScoreCalculate(0);
        TaskSuccessFailInfoDO taskSuccessFailInfoDO = taskSuccessFailInfoMapper.getTaskSuccessFailInfo(taskId,null,null,null);
        data.put("taskId",taskSuccessFailInfoDO.getId());
        data.put("successCount",taskSuccessFailInfoDO.getSuccessCount());
        data.put("failCount",taskSuccessFailInfoDO.getFailCount());
		return ResponseBean.successResponse(data);
	}

	@RequestMapping("/execFailCompanyByTaskId")
	@ResponseBody
	public ResponseBean execFailCompanyByTaskId(Integer taskId,HttpServletRequest request) {
        Map data = new HashMap();
        Integer newId = coCreditScoreService.executeFailCompanyByTaskId(1,taskId);
        TaskSuccessFailInfoDO taskSuccessFailInfoDO = taskSuccessFailInfoMapper.getTaskSuccessFailInfo(newId,null,null,null);
        data.put("taskId",taskSuccessFailInfoDO.getId());
        data.put("successCount",taskSuccessFailInfoDO.getSuccessCount());
        data.put("failCount",taskSuccessFailInfoDO.getFailCount());
        return ResponseBean.successResponse(data);
	}

}
