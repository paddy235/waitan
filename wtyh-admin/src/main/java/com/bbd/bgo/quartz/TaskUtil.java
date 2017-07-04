package com.bbd.bgo.quartz;

import com.bbd.wtyh.util.ApplicationContextUtil;

/**
 * 定时任务相关工具类
 *
 * @author Created by LiYao on 2017-06-14 14:10.
 */
public class TaskUtil {

	private static QuartzHandler quartzHandler = ApplicationContextUtil.getBean(QuartzHandler.class);

	public static void updateTaskEndDate(String key, String group) {
		quartzHandler.updateTaskEndDate(key, group);
	}

	public static void updateTaskState(String key, String group, TaskState taskState) throws Exception {
		quartzHandler.updateTaskState(key, group, taskState);
	}

	public static void updateTaskState(String key, String group) throws Exception {
		updateTaskState(key, group, null);
	}
}
