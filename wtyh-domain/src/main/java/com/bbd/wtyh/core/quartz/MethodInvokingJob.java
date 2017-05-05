package com.bbd.wtyh.core.quartz;

import com.bbd.wtyh.util.ApplicationContextUtil;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.Method;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-05-05 11:29.
 */
@DisallowConcurrentExecution
public class MethodInvokingJob extends QuartzJobBean {

	private Class<?> targetObject;
	private String targetMethod;

	@Override
	public void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		Object otargetObject = ApplicationContextUtil.getBean(targetObject);
		try {
			Method m = otargetObject.getClass().getMethod(targetMethod);
			m.invoke(otargetObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Class<?> getTargetObject() {
		return targetObject;
	}

	public void setTargetObject(Class<?> targetObject) {
		this.targetObject = targetObject;
	}

	public String getTargetMethod() {
		return targetMethod;
	}

	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}
}
