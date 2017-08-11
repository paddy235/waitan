package com.bbd.bgo.quartz;

import com.bbd.wtyh.constants.TaskState;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.TaskInfoDO;
import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.util.ApplicationContextUtil;

/**
 * 定时任务相关工具类
 *
 * @author Created by LiYao on 2017-06-14 14:10.
 */
public class TaskUtil extends BaseServiceImpl {

	private static QuartzHandler quartzHandler = ApplicationContextUtil.getBean(QuartzHandler.class);
	//公信数据落地任务
	public static String[] shangHaiCreditJob= {"shangHaiCreditJob","credit_work"};

	/**
	 * 任务开始
	 **/
	public static Integer taskStart(String taskName,String taskGroup,String dataVersion,Integer runMode,Integer planCount,String createBy ) {
		return quartzHandler.taskStart(taskName,taskGroup,dataVersion,runMode,planCount,createBy);
	}
	/**
	 * 任务结束
	**/
	public static void taskEnd(Integer taskId, TaskResultDO taskResultDO, String updateBy, Integer reExecute) {
		if(null==taskResultDO){
			taskResultDO= new TaskResultDO(0,0,0);
            taskResultDO.setState(TaskState.ERROR);
		}else{
			taskResultDO.setPlanCount(taskResultDO.getPlanCount()==null?0:taskResultDO.getPlanCount());
			taskResultDO.setSuccessCount(taskResultDO.getSuccessCount()==null?0:taskResultDO.getSuccessCount());
			taskResultDO.setFailCount(taskResultDO.getFailCount()==null?0:taskResultDO.getFailCount());
		}
		quartzHandler.taskEnd(taskId,taskResultDO,updateBy,reExecute);
	}

	/**
	 * 停止任务-更新任务状态
	 **/

	public static void stopTask(Integer taskId,String taskName,String taskGroup){
		try {
			quartzHandler.updateTaskState(taskId,taskName,taskGroup, TaskState.STOP);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static TaskInfoDO getTaskInfoDO(String taskName,String taskGroup){
		TaskInfoDO taskInfoDO;
		try {
			taskInfoDO= quartzHandler.getTaskInfo(taskName,taskGroup);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return  taskInfoDO;
	}



}
