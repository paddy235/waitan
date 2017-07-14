package com.bbd.bgo.quartz;

import org.quartz.Trigger;

/**
 * 任务状态
 *
 * @author Created by LiYao on 2017-06-16 9:56.
 */
public enum TaskState {

	NONE(0, ""),
	NORMAL(1, "未开始"),
	PAUSED(2, "暂停中"),
	COMPLETE(3, "成功"),
	ERROR(4, "失败"),
	BLOCKED(5, "正在更新");

	private int state;
	private String desc;

	TaskState(int state, String desc) {
		this.state = state;
		this.desc = desc;
	}

	public int state() {
		return this.state;
	}

	public String desc() {
		return this.desc;
	}

	public static TaskState getState(Trigger.TriggerState state) {
		TaskState[] tasks = TaskState.values();
		for (TaskState taskstate : tasks) {
			if (taskstate.name().equals(state.name())) {
				return taskstate;
			}
		}
		return TaskState.NONE;
	}
}
