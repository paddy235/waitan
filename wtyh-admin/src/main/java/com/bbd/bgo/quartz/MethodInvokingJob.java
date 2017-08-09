package com.bbd.bgo.quartz;

import java.lang.reflect.Method;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.bbd.wtyh.util.ApplicationContextUtil;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-05-05 11:29.
 */
@DisallowConcurrentExecution
public class MethodInvokingJob extends QuartzJobBean {

	private Class<?> targetObject;
	private String targetMethod;
	private Object[] paramValue;
	private Class<?>[] paramClass;

	@Override
	public void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		Object otargetObject = ApplicationContextUtil.getBean(targetObject);
		try {
			Method m;
			if (paramClass != null && paramValue != null && paramClass.length == paramValue.length && paramClass.length > 0) {
				m = targetObject.getDeclaredMethod(targetMethod, paramClass);
				m.setAccessible(true);
				m.invoke(otargetObject, paramValue);
			} else {
				m = targetObject.getDeclaredMethod(targetMethod);
				m.setAccessible(true);
				m.invoke(otargetObject);
			}
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

	public Object[] getParamValue() {
		return paramValue;
	}

	public void setParamValue(Object[] paramValue) {
		this.paramValue = paramValue;
	}

	public Class<?>[] getParamClass() {
		return paramClass;
	}

	public void setParamClass(Class<?>[] paramClass) {
		this.paramClass = paramClass;
	}
}
