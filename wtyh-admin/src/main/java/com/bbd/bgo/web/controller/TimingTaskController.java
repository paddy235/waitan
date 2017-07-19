package com.bbd.bgo.web.controller;



import com.bbd.bgo.service.task.TimingTaskManager;
import com.bbd.wtyh.constants.TaskState;
import com.bbd.wtyh.domain.dto.TaskInfoDTO;
import com.bbd.wtyh.domain.enums.TaskDataSource;
import com.bbd.wtyh.service.TimingTaskService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
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
    @Autowired
    private TimingTaskManager timingTaskManager;

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
	public ResponseBean getHistoryTask(@RequestParam String taskKey, @RequestParam String taskGroup) {
		List<TaskInfoDTO> list = timingTaskService.getHistoryTaskInfo(taskKey,taskGroup);
		return ResponseBean.successResponse(list);
	}


	@RequestMapping("/reExecuteTask")
	@ResponseBody
	public ResponseBean reExecuteTask(@RequestParam Integer taskId, @RequestParam String taskKey, @RequestParam String taskGroup) {
        timingTaskManager.reExecuteTask(taskId,taskKey,taskGroup);
	    return ResponseBean.successResponse(null);
	}

    @RequestMapping("/getTaskState")
    @ResponseBody
    public ResponseBean getTaskState() {
        TaskState[] types = TaskState.values();
        Map results = new HashMap();
        List<Map<String, Object>> list = new ArrayList<>();
        setAllElement(list, "code", "name");
        for (TaskState rl : types) {
            if(rl.state()>4){
                continue;
            }
            Map<String, Object> map = new HashMap<>();
            map.put("code", rl.state());
            map.put("name", rl.desc());
            list.add(map);
        }
        results.put("results", list);
        return ResponseBean.successResponse(results);
    }

    @RequestMapping("/getTaskDataSource")
    @ResponseBody
    public ResponseBean TaskDataSource() {
        TaskDataSource[] types = TaskDataSource.values();
        Map results = new HashMap();
        List<Map<String, Object>> list = new ArrayList<>();
        setAllElement(list, "code", "name");
        for (TaskDataSource rl : types) {
            Map<String, Object> map = new HashMap<>();
            map.put("code", rl.type());
            map.put("name", rl.desc());
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
