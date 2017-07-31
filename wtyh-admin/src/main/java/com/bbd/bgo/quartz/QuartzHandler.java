package com.bbd.bgo.quartz;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.bbd.wtyh.constants.TaskState;
import com.bbd.wtyh.domain.TaskInfoDO;
import com.bbd.wtyh.domain.TaskSuccessFailInfoDO;
import com.bbd.wtyh.mapper.TaskSuccessFailInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.quartz.*;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import com.bbd.wtyh.core.base.BaseServiceImpl;

/**
 * Quartz 处理器
 *
 * @author Created by LiYao on 2017-06-14 10:20.
 */
@Component
public class QuartzHandler extends BaseServiceImpl {
	@Autowired
	private TaskSuccessFailInfoMapper taskDetailMapper;//任务执行历史
	@Autowired
	private SchedulerFactoryBean schedulerFactory;
	@Autowired
	private TimeZone timeZone;

	private Logger logger = LoggerFactory.getLogger(QuartzHandler.class);

	private QuartzHandler() {
	}

	private static final String SEPARATOR = "@_@";
	private final Map<String, TaskInfoDO> TASK_MAP = new ConcurrentHashMap<>();

	@Scheduled(cron = "0 0/5 * * * ?")
	public void reLoadJob(){
		Map<String, TaskInfoDO> taskMapCopy=new HashMap<>(TASK_MAP);
		List<TaskInfoDO> taskList = this.selectAll(TaskInfoDO.class, "");

		//有任务的时间被修改
		taskList.forEach(taskInfo -> {

			String key=taskInfo.getTaskKey() + SEPARATOR + taskInfo.getTaskGroup();
			taskMapCopy.remove(key);
			TaskInfoDO oldDO=TASK_MAP.get(key);
			if(null==oldDO){
				addJob(taskInfo);
			}else {
				String newCron=taskInfo.getCron();
				if(!StringUtils.isEmpty(newCron)){
					if(!oldDO.getCron().trim().equals(taskInfo.getCron().trim())){
						modifyJobTime(taskInfo.getTaskKey(),taskInfo.getTaskGroup(), newCron);
					}
				}

			}
		});

		//有任务被移除
		for (TaskInfoDO taskInfoDO : taskMapCopy.values()) {
			try {
				deleteJob(taskInfoDO.getTaskKey(),taskInfoDO.getTaskGroup());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void modifyJobTime(String triggerName,String triggerGroupName, String time) {
		try {
			Scheduler sched = schedulerFactory.getScheduler();
			CronTriggerImpl trigger = (CronTriggerImpl) sched.getTrigger(TriggerKey.triggerKey(triggerName,triggerGroupName));
			if (trigger == null) {
				return;
			}
			String oldTime = trigger.getCronExpression();
			if (!oldTime.equalsIgnoreCase(time)) {
				// 修改时间
				trigger.setCronExpression(time);
				// 重启触发器
				sched.rescheduleJob(trigger.getKey(),trigger);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void init() {

        List<TaskInfoDO> taskList = this.selectAll(TaskInfoDO.class, "");
		taskList.forEach(taskInfo -> {
			TASK_MAP.put(taskInfo.getTaskKey() + SEPARATOR + taskInfo.getTaskGroup(), taskInfo);
			addJob(taskInfo);
		});
		logger.info("timing task init...");
	}

	public List<TaskInfoDO> getAllTask() {
		List<TaskInfoDO> taskList = new ArrayList<>();
		TASK_MAP.forEach((mapKey, taskInfo) -> {
			taskList.add(taskInfo);
		});
		return taskList;
	}

	public TaskInfoDO getTaskInfo(String key, String group) {
		String mapKey = key + SEPARATOR + group;
		String where = "key = '" + key + "' AND group = '" + group + "'";
		return TASK_MAP.computeIfAbsent(mapKey, (String k) -> this.selectOne(TaskInfoDO.class, where));
	}

	public void updateJob(TaskInfoDO taskInfo) {
		this.update(taskInfo);
		TASK_MAP.put(taskInfo.getTaskKey() + SEPARATOR + taskInfo.getTaskGroup(), taskInfo);
	}

	public void addJob(TaskInfoDO taskInfo) {
		String name = taskInfo.getTaskKey();
		assertStringNotNullOrEmpty(name, "任务名称不能为空");

		String targetClass = taskInfo.getTargetClass();
		assertStringNotNullOrEmpty(targetClass, "任务目标类不能为空");

		String targetMethod = taskInfo.getTargetMethod();
		assertStringNotNullOrEmpty(targetMethod, "任务目标方法不能为空");

		String corn = taskInfo.getCron();
		assertStringNotNullOrEmpty(corn, "corn表达式不能为空");

		String group = StringUtils.defaultString(taskInfo.getTaskGroup(), Scheduler.DEFAULT_GROUP);

		Scheduler scheduler = schedulerFactory.getScheduler();

		JobDetail jobDetail = JobBuilder.newJob(MethodInvokingJob.class).withIdentity(name, group).build();// 任务名，任务组，任务执行类
		jobDetail.getJobDataMap().put("targetObject", targetClass);
		jobDetail.getJobDataMap().put("targetMethod", targetMethod);

		CronTriggerImpl trigger = new CronTriggerImpl();
		trigger.setName(name);
		trigger.setGroup(group);
		trigger.setJobKey(jobDetail.getKey());
		trigger.setTimeZone(timeZone);
		try {
			trigger.setCronExpression(corn);
			scheduler.scheduleJob(jobDetail, trigger);

			this.updateJob(taskInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 运行任务一次
	 *
	 * @param key
	 * @param group
	 */
	public void runJob(String key, String group) throws Exception {
		Scheduler scheduler = schedulerFactory.getScheduler();
		JobKey jobKey = JobKey.jobKey(key, group);
		scheduler.triggerJob(jobKey);
	}

	/**
	 * 恢复任务
	 *
	 * @param key
	 * @param group
	 * @throws Exception
	 */
	public void resumeJob(String key, String group) throws Exception {
		Scheduler scheduler = schedulerFactory.getScheduler();
		JobKey jobKey = JobKey.jobKey(key, group);
		scheduler.resumeJob(jobKey);
	}

	/**
	 * 暂停任务
	 *
	 * @param key
	 * @param group
	 * @throws Exception
	 */
	public void pauseJob(String key, String group) throws Exception {
		Scheduler scheduler = schedulerFactory.getScheduler();
		JobKey jobKey = JobKey.jobKey(key, group);
		scheduler.pauseJob(jobKey);
	}

	/**
	 * 删除任务
	 *
	 * @param key
	 * @param group
	 * @throws Exception
	 */
	public void deleteJob(String key, String group) throws Exception {
		Scheduler scheduler = schedulerFactory.getScheduler();
		JobKey jobKey = JobKey.jobKey(key, group);
		// scheduler.interrupt(jobKey)
		scheduler.deleteJob(jobKey);
	}

	public Integer taskStart(String taskName,String taskGroup,String dataVersion,Integer runMode,Integer planCount,String createBy ) {
		TaskSuccessFailInfoDO taskDetail=new TaskSuccessFailInfoDO();
		taskDetail.setBeginDate(new Date());
		taskDetail.setTaskName(taskName);
		taskDetail.setTaskGroup(taskGroup);
		taskDetail.setDataVersion(dataVersion);
		taskDetail.setRunMode(runMode);
		taskDetail.setPlanCount(planCount);
        taskDetail.setState(TaskState.EXECUTING.state());
        taskDetail.setReExecute(0);//0不可执行 1可执行 2 已手动执行'
		taskDetail.setCreateDate(taskDetail.getBeginDate());
		if(createBy==null){
			taskDetail.setCreateBy("system");
		}
		this.taskDetailMapper.addTaskSuccessFailInfo(taskDetail);//任务历史表-取得任务ID

		TaskInfoDO taskInfo = this.getTaskInfo(taskName, taskGroup);
		taskInfo.setStartDate(taskDetail.getBeginDate());
		taskInfo.setEndDate(null);
		taskInfo.setState(TaskState.EXECUTING.state());
		this.update(taskInfo,false,true);
		//this.executeCUD("UPDATE timing_task_info SET start_date=?,end_date=?,state=? WHERE id=?", DateFormatUtils.format(taskDetail.getBeginDate(),"yyyy-MM-dd HH:mm:ss"),null,TaskState.EXECUTING.state(),taskInfo.getId());

		return taskDetail.getId();
	}

	public void taskEnd(Integer taskId,Integer planCount, Integer successCount,Integer failCount,String updateBy,Integer reExecute) {
		TaskSuccessFailInfoDO taskDetail = taskDetailMapper.getTaskInfoById(taskId);
		taskDetail.setEndDate(new Date());
		taskDetail.setPlanCount(planCount);
		taskDetail.setSuccessCount(successCount);
		taskDetail.setFailCount(failCount);
		taskDetail.setUpdateDate(taskDetail.getEndDate());
		if(updateBy==null){
			taskDetail.setUpdateBy("system");
		}

		//被认为停止，不再更新状态
		if(TaskState.STOP.state()!=taskDetail.getState()){

			if(failCount!=null && failCount>0) {
				taskDetail.setState(TaskState.ERROR.state());
				taskDetail.setReExecute(reExecute);
			}else {
				taskDetail.setState(TaskState.SUCCESS.state());
			}
		}


		taskDetailMapper.updateTaskSuccessFailInfo(taskDetail);

		TaskInfoDO taskInfo = this.getTaskInfo(taskDetail.getTaskName(), taskDetail.getTaskGroup());
		taskInfo.setEndDate(taskDetail.getEndDate());
        taskInfo.setState(taskDetail.getState());
		this.update(taskInfo);
	}

	public void updateTaskEndDate(String key, String group) {
		TaskInfoDO taskInfo = this.getTaskInfo(key, group);
		taskInfo.setEndDate(new Date());
		this.update(taskInfo);
	}

	public void updateTaskState(Integer taskId, String key, String group, TaskState taskState) throws Exception {
		TaskSuccessFailInfoDO taskDetail=new TaskSuccessFailInfoDO();
		taskDetail.setId(taskId);
		taskDetail.setState(taskState.state());
		this.update(taskDetail);

		TaskInfoDO taskInfo = this.getTaskInfo(taskDetail.getTaskName(), taskDetail.getTaskGroup());
		taskInfo.setState(taskDetail.getState());
		this.update(taskInfo);
	}

	public void businessStart(String key, String group, TaskState taskState) throws Exception {
		if (taskState == null) {
			taskState = getTaskState(key, group);
		}

		TaskInfoDO taskInfo = this.getTaskInfo(key, group);
		taskInfo.setState(taskState.state());
		taskInfo.setStartDate(new Date());
		taskInfo.setEndDate(null);
		this.updateJob(taskInfo);
	}

	public void businessFinish(String key, String group, TaskState taskState) throws Exception {
		if (taskState == null) {
			taskState = getTaskState(key, group);
		}

		TaskInfoDO taskInfo = this.getTaskInfo(key, group);
		taskInfo.setState(taskState.state());
		taskInfo.setEndDate(new Date());
		this.updateJob(taskInfo);
	}

	public TaskState getTaskState(String key, String group) throws Exception {
		Scheduler scheduler = schedulerFactory.getScheduler();
		Trigger.TriggerState triggerState = scheduler.getTriggerState(TriggerKey.triggerKey(key, group));
		return TaskState.getState(triggerState);
	}

	private void assertStringNotNullOrEmpty(String str, String msg) {
		if (StringUtils.isBlank(str)) {
			throw new IllegalArgumentException(msg);
		}
	}
}
