package com.bbd.bgo.web.controller;


import com.bbd.wtyh.domain.TaskInfoDO;
import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;
import com.bbd.wtyh.domain.dto.TaskInfoDTO;
import com.bbd.wtyh.service.TimingTaskService;
import com.bbd.wtyh.web.ResponseBean;
import net.sf.cglib.beans.BeanCopier;
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

		List<TaskInfoDTO> list = timingTaskService.getTaskInfo();

		return ResponseBean.successResponse(list);
	}

	@RequestMapping("/getLatestTaskInfo")
	@ResponseBody
	public ResponseBean getLatestTaskInfo() {
		List<TaskInfoDTO> list = timingTaskService.getLatestTaskInfo();
		return ResponseBean.successResponse(list);
	}

	@RequestMapping("/getHistoryTask")
	@ResponseBody
	public ResponseBean getHistoryTask(String taskName,String taskGroup) {
		List<TaskInfoDTO> list = timingTaskService.getHistoryTaskInfo(taskName,taskGroup);
		return ResponseBean.successResponse(list);
	}

	@RequestMapping("/getTaskDetail")
	@ResponseBody
	public ResponseBean getTaskDetail(Integer taskId, String taskName, String taskGroup) {

		return ResponseBean.successResponse(null);
	}

	@RequestMapping("/reExecuteTask")
	@ResponseBody
	public ResponseBean reExecuteTask(Integer taskId, String taskName, String taskGroup) {

		return ResponseBean.successResponse(null);
	}

}
