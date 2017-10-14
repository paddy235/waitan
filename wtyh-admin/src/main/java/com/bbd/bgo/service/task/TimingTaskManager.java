package com.bbd.bgo.service.task;

import com.bbd.bgo.quartz.TaskUtil;
import com.bbd.wtyh.constants.TaskState;
import com.bbd.wtyh.domain.TaskFailInfoDO;
import com.bbd.wtyh.domain.TaskInfoDO;
import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.mapper.ParkAndBuildingMgtMapper;
import com.bbd.wtyh.mapper.TaskFailInfoMapper;
import com.bbd.wtyh.service.*;
import com.bbd.wtyh.util.ApplicationContextUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

/**
 * 所有定时任务统一管理接口实现类
 *
 * @author Created by LiYao on 2017-04-25 14:43.
 */
@Component
public class TimingTaskManager {

	// SyncFileService ; 线下理财
	// OfflineFinanceService; 风险等级
	// SystemDataUpdateService ; 企业基本信息
	// P2PImageService ;  网贷平台画像
	// PToPMonitorService ; 网贷监测
	// DataLoadingService ; 全息
	// CrowdFundingService ; 众筹
	// PlatUpdateTaskService ; 企业与网贷平台
	@Autowired
	private CoCreditScoreService coCreditScoreService;
	@Autowired
	private ParkAndBuildingMgtMapper parkAndBuildingMgtMapper;
	@Autowired
	private TaskFailInfoMapper taskFailInfoMapper;

	private Logger logger = LoggerFactory.getLogger(TimingTaskManager.class);

	private static Integer canRan = 1;

	/**
	 *  定时任务启动程序
	 */
	public void start(TaskInfoDO taskInfo) throws Exception {
		logger.info("sunliming: start");
		Integer taskId = null;
		TaskResultDO taskResultDO = null;
		TaskService taskService;
		int isShow=0;
		try {
			taskService=getTaskServiceBean(taskInfo.getTargetClass());
			String taskKey=taskInfo.getTaskKey();
			String taskGroup=taskInfo.getTaskGroup();
			isShow=taskInfo.getIsShow()==null?-1:taskInfo.getIsShow();
			if(null==taskService || null==taskKey || null==taskGroup){
				return;
			}
			Integer runMode = 0;// 运行方式：0 自动执行， 1 手动执行
			if(1==isShow){
				logger.info("sunliming: start 2");
				taskId = TaskUtil.taskStart(taskKey, taskGroup, null, runMode, null, null);
				logger.info("sunliming: start 3");
			}
			//初始化任务，shutdown设置为false
			taskService.resetTask();
			//需要传 taskId 给业务接口
			logger.info("sunliming: start 4");
			taskResultDO = taskService.autoExecute(taskId,runMode);
			logger.info("sunliming: start 5");
		} catch (Exception e) {
			if(null == taskResultDO){
				taskResultDO=new TaskResultDO();
			}
			taskResultDO.setState(TaskState.ERROR);
			logger.error("start:" , e);
		} finally {
			if(1==isShow){
				taskEnd(taskResultDO, taskId, null, canRan);
			}
		}

	}



	public void reExecuteTaskAsyn(Integer oldTaskId, String taskKey, String taskGroup) {
		new Thread(() -> reExecuteTask(oldTaskId, taskKey, taskGroup)).start();
	}

	/**
	 * 手动重新执行任务
	 */
	public void reExecuteTask(Integer oldTaskId, String taskKey, String taskGroup) {

		Integer runMode = 1;
		Integer newTaskId = null;
		TaskResultDO taskResultDO = null;
		TaskService taskService=getTaskServiceBean(taskKey, taskGroup);
		try {
			newTaskId = TaskUtil.taskStart(taskService.getTaskKey(), taskService.getTaskGroup(), null, runMode, null, null);
			//初始化任务，shutdown设置为false
			taskService.resetTask();
			taskResultDO=taskService.reExecute(oldTaskId,newTaskId,runMode);
		}catch (Exception e) {
			if(null == taskResultDO){
				taskResultDO=new TaskResultDO(0,0,0);
			}
			taskResultDO.setState(TaskState.ERROR);
			logger.error("reExecuteTask-" + e);
		} finally {
			taskEnd(taskResultDO, newTaskId, null, canRan);
		}

	}

	/**
	 * 任务结束
	 */
	public void taskEnd(TaskResultDO taskResultDO, Integer taskId, String creatBy, Integer reExecute) {

		TaskUtil.taskEnd(taskId, taskResultDO, null, reExecute);
	}

	/**
	 * 下载任务的失败明细数据
	 */
	public List<TaskFailInfoDO> downloadTaskInfo(Integer taskId, String taskKey, String taskGroup) {
		List<TaskFailInfoDO> list;
		if (TaskUtil.shangHaiCreditJob[0].equals(taskKey)) {
			// 公信数据落地
			list = coCreditScoreService.getCreditFailInfoByTaskId(taskId);
		} else {
			// BBD数据落地-权限舆情
			// 系统数据更新-企业基本信息和背景
			// 网贷之家数据落地-网络借贷-监测
			// 网贷之家数据落地-网络借贷-平台画像
			// 网贷之家数据落地-众筹
			// 系统数据更新-风险等级
			list = taskFailInfoMapper.getTaskFailInfoByTaskId(taskId);

		}
		return list;
	}

	public boolean stopTask(Integer taskId, String taskKey, String taskGroup){
		boolean isStop=false;
		TaskService taskService=getTaskServiceBean(taskKey, taskGroup);
		if(null==taskService){
			return isStop;
		}
		taskService.stopExecute(taskId);
		TaskUtil.stopTask(taskId,taskKey,taskGroup);
		isStop=true;
		return  isStop;

	}

	/**
	 * 定时任务，删除园区楼宇图片表中使用过的或过期的图片
	 */
	public void delImgByStatus(){
		List<String> statusList = Arrays.asList("0","2");
		parkAndBuildingMgtMapper.delImgByStatus(statusList);
	}

	private TaskService getTaskServiceBean(String taskKey, String taskGroup) {
		TaskService taskService=null;
		TaskInfoDO taskInfoDO = TaskUtil.getTaskInfoDO(taskKey, taskGroup);
		if(null== taskInfoDO|| null==taskInfoDO.getTargetClass()){
			return null;
		}
		taskService=getTaskServiceBean(taskInfoDO.getTargetClass());
		return taskService;

	}

	private TaskService getTaskServiceBean(String targetClass){
		TaskService taskService=null;
		try {
			Class<?> clazz = Class.forName(targetClass);
			String objName = StringUtils.uncapitalize(clazz.getSimpleName());
			Service annotation = clazz.getAnnotation(Service.class);
			if (StringUtils.isNotBlank(annotation.value())) {
				objName = annotation.value();
			}
			Object obj = ApplicationContextUtil.getBean(objName);
			taskService = (TaskService) obj;
		} catch (Exception e) {
			logger.error("getTaskServiceBean-" + e);
		}

		return taskService;
	}
}
