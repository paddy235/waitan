package com.bbd.bgo.web.controller;



import com.bbd.bgo.service.task.TimingTaskManager;
import com.bbd.wtyh.constants.TaskState;
import com.bbd.wtyh.domain.TaskFailInfoDO;
import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;
import com.bbd.wtyh.domain.dto.TaskInfoDTO;
import com.bbd.wtyh.domain.enums.TaskDataSource;
import com.bbd.wtyh.excel.ExportExcel;
import com.bbd.wtyh.excel.Sheet;
import com.bbd.wtyh.exception.ExceptionHandler;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.mapper.TaskSuccessFailInfoMapper;
import com.bbd.wtyh.service.TimingTaskService;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.commons.lang3.StringUtils;
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
 * Created by 孙黎明 on 2016/8/27.
 */
@Controller
@RequestMapping("/timingTask")
public class TimingTaskController {

	@Autowired
	private TimingTaskService timingTaskService;
    @Autowired
    private TimingTaskManager timingTaskManager;
    @Autowired
    private TaskSuccessFailInfoMapper taskSuccessFailInfoMapper;

	@RequestMapping("/getTaskInfo")
	@ResponseBody
	public ResponseBean getTaskInfo(HttpServletRequest request) {

		List<TaskInfoDTO> list = timingTaskService.getTaskInfo();
        UserLogRecord.record("定时任务列表", Operation.Type.browse, Operation.Page.timingTask,
                Operation.System.back, request);

		return ResponseBean.successResponse(list);
	}

	@RequestMapping("/getLatestTaskInfo")
	@ResponseBody
	public ResponseBean getLatestTaskInfo(String taskState, String taskDataSource,HttpServletRequest request) {

	    if(StringUtils.isEmpty(taskState)){
            taskState="0";
        }
        if(StringUtils.isEmpty(taskDataSource)){
            taskDataSource="0";
        }
		List<TaskInfoDTO> list = timingTaskService.getLatestTaskInfo(taskState,taskDataSource);
        for(TaskInfoDTO task:list){
            Integer failCount=task.getFailCount();
            Integer successCount=task.getSuccessCount();
            if(null==failCount){
                failCount=0;
            }
            if(null==successCount){
                successCount=0;
            }
            task.setPlanCount(failCount+successCount);
        }

        UserLogRecord.record("定时任务最新执行情况", Operation.Type.browse, Operation.Page.timingTask,
                Operation.System.back, request);

		return ResponseBean.successResponse(list);
	}

	@RequestMapping("/getHistoryTask")
	@ResponseBody
	public ResponseBean getHistoryTask(@RequestParam String taskKey, @RequestParam String taskGroup,
                                       String taskState, String taskDataSource, String taskUpdateDate,HttpServletRequest request) {

	    List<TaskInfoDTO> list = timingTaskService.getHistoryTaskInfo(taskKey,taskGroup,taskState,taskDataSource,taskUpdateDate);
        for(TaskInfoDTO task:list){
            Integer failCount=task.getFailCount();
            Integer successCount=task.getSuccessCount();
            if(null==failCount){
                failCount=0;
            }
            if(null==successCount){
                successCount=0;
            }
            task.setPlanCount(failCount+successCount);
        }
        UserLogRecord.record("定时任务详情", Operation.Type.browse, Operation.Page.timingTask,
                Operation.System.back, request);

		return ResponseBean.successResponse(list);
	}


	@RequestMapping("/reExecuteTask")
	@ResponseBody
	public ResponseBean reExecuteTask(@RequestParam Integer taskId, @RequestParam String taskKey,
                                      @RequestParam String taskGroup,@RequestParam String taskName,HttpServletRequest request) {
        TaskSuccessFailInfoDO taskDO=taskSuccessFailInfoMapper.getTaskRecentInfo(taskKey,taskGroup);
        int state=taskDO.getState()==null?-1:taskDO.getState();

        if(taskDO.getUpdateDate()==null || TaskState.EXECUTING.state()==state){
            return ResponseBean.errorResponse("已有任务正在执行中，请稍后再试!");
        }
        timingTaskManager.reExecuteTaskAsyn(taskId,taskKey,taskGroup);
        taskSuccessFailInfoMapper.updateReExecuteById(2,taskId);

        UserLogRecord.record("再次执行【"+taskName+"-"+taskId+"]", Operation.Type.RE_EXECUTE, Operation.Page.timingTask,
                Operation.System.back, request);

	    return ResponseBean.successResponse(null);
	}

    @RequestMapping("/downloadTaskInfo")
    @ResponseBody
    public ResponseBean downloadTaskInfo(@RequestParam Integer taskId, @RequestParam String taskKey,
                                      @RequestParam String taskGroup,@RequestParam String taskName,HttpServletRequest request) {

		try {
            List<TaskFailInfoDO> list= timingTaskManager.downloadTaskInfo(taskId, taskKey, taskGroup);
			String excelName = "定时任务（" + taskName + "）";
			ExportExcel exportExcel = new ExportExcel(excelName);
            ExportExcel.getPageSheet(list,exportExcel,10000,"sheet");
			exportExcel.exportExcel();

            UserLogRecord.record("导出定时任务【" + taskName + "-" + taskId + "]", Operation.Type.DATA_EXPORT, Operation.Page.timingTask,
                    Operation.System.back, request);

			return ResponseBean.successResponse(exportExcel.getDownloadURL());

		} catch (Exception e) {

			return ExceptionHandler.handlerException(e);
		}
    }

    @RequestMapping("/getTaskState")
    @ResponseBody
    public ResponseBean getTaskState() {
        TaskState[] types = TaskState.values();
        Map results = new HashMap();
        List<Map<String, Object>> list = new ArrayList<>();
        setAllElement(list, "code", "name");
        for (TaskState rl : types) {
            if(rl.state()>5){
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


    @RequestMapping("/stopTask")
    @ResponseBody
    public ResponseBean stopTask(@RequestParam Integer taskId, @RequestParam String taskKey,
                                      @RequestParam String taskGroup,@RequestParam String taskName,HttpServletRequest request) {


        boolean isStop=false;
        isStop=timingTaskManager.stopTask(taskId,taskKey,taskGroup);

        UserLogRecord.record("终止定时任务【" + taskName + "-" + taskId + "]", Operation.Type.RE_EXECUTE, Operation.Page.timingTask,
                Operation.System.back, request);

        return ResponseBean.successResponse(isStop);
    }
}
