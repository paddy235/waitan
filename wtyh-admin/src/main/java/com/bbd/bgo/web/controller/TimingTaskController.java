package com.bbd.bgo.web.controller;


import com.bbd.wtyh.domain.TaskInfoDO;
import com.bbd.wtyh.service.TimingTaskService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 孙黎明 on 2016/8/27.
 */
@Controller
@RequestMapping("/timingTask")
public class TimingTaskController {

	@Autowired
	private TimingTaskService timingTaskService;

	@RequestMapping("/getTaskInfo")
	@ResponseBody
	public ResponseBean getTaskInfo() {
		List<TaskInfoDO> list = timingTaskService.getTaskInfo();
		return ResponseBean.successResponse(list);
	}

	@RequestMapping("/getLatestTaskInfo")
	@ResponseBody
	public ResponseBean getLatestTaskInfo() {
		List<TaskInfoDO> list = timingTaskService.getLatestTaskInfo();
		return ResponseBean.successResponse(list);
	}

	@RequestMapping("/getHistoryTask")
	@ResponseBody
	public ResponseBean getHistoryTask() {
		List<TaskInfoDO> list = timingTaskService.getLatestTaskInfo();
		return ResponseBean.successResponse(list);
	}

}
