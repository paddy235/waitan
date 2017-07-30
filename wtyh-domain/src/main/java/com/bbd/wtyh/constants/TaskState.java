package com.bbd.wtyh.constants;

import org.quartz.Trigger;

/**
 * 任务状态
 *
 * @author Created by LiYao on 2017-06-16 9:56.
 */
public enum TaskState {

	NONSTARTER(1, "未开始"),
	EXECUTING(2, "正在执行"),
	SUCCESS(3, "成功"),
	ERROR(4, "失败"),
	STOP(5, "终止"),
	NONE(9, "");

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
