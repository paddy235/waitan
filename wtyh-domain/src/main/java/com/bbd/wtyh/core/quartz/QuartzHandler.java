package com.bbd.wtyh.core.quartz;

import com.bbd.wtyh.core.base.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Quartz 处理器
 *
 * @author Created by LiYao on 2017-06-14 10:20.
 */
@Component
public class QuartzHandler extends BaseServiceImpl {

	@Autowired
	private SchedulerFactoryBean schedulerFactory;
	@Autowired
	private TimeZone timeZone;

	private QuartzHandler() {
	}

	private static final String SEPARATOR = "@_@";
	private final Map<String, TaskInfoDo> TASK_MAP = new ConcurrentHashMap<>();

	public void init() {
        System.out.println("hell");
        List<TaskInfoDo> taskList = this.selectAll(TaskInfoDo.class, "");
		taskList.forEach(taskInfo -> {
			TASK_MAP.put(taskInfo.getTaskKey() + SEPARATOR + taskInfo.getTaskGroup(), taskInfo);
			addJob(taskInfo);
		});
	}

	public List<TaskInfoDo> getAllTask() {
		List<TaskInfoDo> taskList = new ArrayList<>();
		TASK_MAP.forEach((mapKey, taskInfo) -> {
			taskList.add(taskInfo);
		});
		return taskList;
	}

	public TaskInfoDo getTaskInfo(String key, String group) {
		String mapKey = key + SEPARATOR + group;
		String where = "key = '" + key + "' AND group = '" + group + "'";
		return TASK_MAP.computeIfAbsent(mapKey, (String k) -> this.selectOne(TaskInfoDo.class, where));
	}

	public void updateJob(TaskInfoDo taskInfo) {
		this.update(taskInfo);
		TASK_MAP.put(taskInfo.getTaskKey() + SEPARATOR + taskInfo.getTaskGroup(), taskInfo);
	}

	public void addJob(TaskInfoDo taskInfo) {
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

			taskInfo.setStartDate(trigger.getNextFireTime());
			taskInfo.setEndDate(null);
			taskInfo.setState(TaskState.NORMAL.state());
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
		this.executeCUD("DELETE FROM timing_task_info WHERE task_key = ? AND task_group = ?", key, group);
	}

	public void updateTaskEndDate(String key, String group) {
		TaskInfoDo taskInfo = this.getTaskInfo(key, group);
		taskInfo.setEndDate(new Date());
		this.update(taskInfo);
	}

	public void updateTaskState(String key, String group, TaskState taskState) throws Exception {
		if (taskState == null) {
			taskState = getTaskState(key, group);
		}

		TaskInfoDo taskInfo = this.getTaskInfo(key, group);
		taskInfo.setState(taskState.state());
		this.updateJob(taskInfo);
	}

	public void businessStart(String key, String group, TaskState taskState) throws Exception {
		if (taskState == null) {
			taskState = getTaskState(key, group);
		}

		TaskInfoDo taskInfo = this.getTaskInfo(key, group);
		taskInfo.setState(taskState.state());
		taskInfo.setStartDate(new Date());
		taskInfo.setEndDate(null);
		this.updateJob(taskInfo);
	}

	public void businessFinish(String key, String group, TaskState taskState) throws Exception {
		if (taskState == null) {
			taskState = getTaskState(key, group);
		}

		TaskInfoDo taskInfo = this.getTaskInfo(key, group);
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
