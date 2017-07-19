package com.bbd.bgo.web.controller;

import com.bbd.bgo.quartz.TaskUtil;
import com.bbd.data.service.DataService;
import com.bbd.wtyh.common.Constants;
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
		Map map ;
		Integer taskId;
		Integer planCount = null;// 计划执行笔数。 可在任务结束时更新
		Integer successCount=null;
		Integer failCount=null;


		String dataVersion=null;//有版本号的传版本号，没有的不传，根据自己的业务规则定
		Integer runMode = 0;// 运行方式：0 自动执行， 1 手动执行
		taskId= TaskUtil.taskStart("shangHaiCreditJob","credit_work",dataVersion,runMode,null,null);

		map = coCreditScoreService.creditScoreCalculate(taskId,runMode);

		if(null!=map){
			planCount=map.get("planCount")==null?null:(Integer)map.get("planCount");
			successCount=map.get("successCount")==null?null:(Integer)map.get("successCount");
			failCount=map.get("failCount")==null?null:(Integer)map.get("failCount");
		}
		TaskUtil.taskEnd(taskId,planCount,successCount,failCount,null);

		return ResponseBean.successResponse(map);
	}

	@RequestMapping("/execFailCompanyByTaskId")
	@ResponseBody
	public ResponseBean execFailCompanyByTaskId(Integer taskId,HttpServletRequest request) {

		String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
		Map map ;
		Integer newTaskId;
		Integer planCount = null;// 计划执行笔数。 可在任务结束时更新
		Integer successCount=null;
		Integer failCount=null;
		String dataVersion=null;//有版本号的传版本号，没有的不传，根据自己的业务规则定
		Integer runMode = 1;// 运行方式：0 自动执行， 1 手动执行

		newTaskId= TaskUtil.taskStart("shangHaiCreditJob","credit_work",dataVersion,runMode,planCount,loginName);


		map = coCreditScoreService.executeFailCompanyByTaskId(runMode,taskId,newTaskId);
		if(null!=map){
			planCount=map.get("planCount")==null?null:(Integer)map.get("planCount");
			successCount=map.get("successCount")==null?null:(Integer)map.get("successCount");
			failCount=map.get("failCount")==null?null:(Integer)map.get("failCount");
		}
		TaskUtil.taskEnd(newTaskId,planCount,successCount,failCount,loginName);


		return ResponseBean.successResponse(map);
	}

}
