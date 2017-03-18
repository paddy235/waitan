package com.bbd.wtyh.log.user;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.Map;

/**
 * 用户日志实体
 *
 * @author Created by LiYao on 2017-03-13 09:27.
 */
@Table(name = "user_behavior_log")
public class UserLog {

	/** 日志ID */
	@Id
	private Integer id;

	/** 操作者 */
	private String operator;

	/** 操作者真实姓名 */
	private String realName;

	/** 操作者所属部门 */
	private String department;

	/** 操作发生时间 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date date;

	/** 操作类型描述 */
	private String operationDesc;

	/** 操作类型 */
	private Integer operationType;

	/** 日志内容 */
	private String LogContent;

	/** 发生操作的系统代码 */
	private Integer sysCode;

	/** 发生操作的系统名称 */
	private String sysName;

	/** 请求IP */
	private String requestIP;

	/** 请求地址 */
	private String requestURI;

	/** 请求地址描述 */
	private String requestDesc;

	/** 全部请求参数 */
	@Transient
	private Map<String, String> requestParam;

	/**
	 * 获取 日志ID
	 *
	 * @return id 日志ID
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * 设置 日志ID
	 *
	 * @param id
	 *            日志ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取 操作者
	 *
	 * @return operator 操作者
	 */
	public String getOperator() {
		return this.operator;
	}

	/**
	 * 设置 操作者
	 *
	 * @param operator
	 *            操作者
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * 获取 操作者真实姓名
	 *
	 * @return realName 操作者真实姓名
	 */
	public String getRealName() {
		return this.realName;
	}

	/**
	 * 设置 操作者真实姓名
	 *
	 * @param realName
	 *            操作者真实姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * 获取 操作者所属部门
	 *
	 * @return department 操作者所属部门
	 */
	public String getDepartment() {
		return this.department;
	}

	/**
	 * 设置 操作者所属部门
	 *
	 * @param department
	 *            操作者所属部门
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * 获取 操作发生时间
	 *
	 * @return date 操作发生时间
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * 设置 操作发生时间
	 *
	 * @param date
	 *            操作发生时间
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * 获取 操作类型描述
	 *
	 * @return operationDesc 操作类型描述
	 */
	public String getOperationDesc() {
		return this.operationDesc;
	}

	/**
	 * 设置 操作类型描述
	 *
	 * @param operationDesc
	 *            操作类型描述
	 */
	public void setOperationDesc(String operationDesc) {
		this.operationDesc = operationDesc;
	}

	/**
	 * 获取 操作类型
	 *
	 * @return operationType 操作类型
	 */
	public Integer getOperationType() {
		return this.operationType;
	}

	/**
	 * 设置 操作类型
	 *
	 * @param operationType
	 *            操作类型
	 */
	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}

	/**
	 * 获取 日志内容
	 *
	 * @return LogContent 日志内容
	 */
	public String getLogContent() {
		return this.LogContent;
	}

	/**
	 * 设置 日志内容
	 *
	 * @param LogContent
	 *            日志内容
	 */
	public void setLogContent(String LogContent) {
		this.LogContent = LogContent;
	}

	/**
	 * 获取 请求IP
	 *
	 * @return requestIP 请求IP
	 */
	public String getRequestIP() {
		return this.requestIP;
	}

	/**
	 * 设置 请求IP
	 *
	 * @param requestIP
	 *            请求IP
	 */
	public void setRequestIP(String requestIP) {
		this.requestIP = requestIP;
	}

	/**
	 * 获取 请求地址
	 *
	 * @return requestURI 请求地址
	 */
	public String getRequestURI() {
		return this.requestURI;
	}

	/**
	 * 设置 请求地址
	 *
	 * @param requestURI
	 *            请求地址
	 */
	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}

	/**
	 * 获取 请求描述
	 *
	 * @return requestDesc 请求描述
	 */
	public String getRequestDesc() {
		return this.requestDesc;
	}

	/**
	 * 设置 请求描述
	 *
	 * @param requestDesc
	 *            请求描述
	 */
	public void setRequestDesc(String requestDesc) {
		this.requestDesc = requestDesc;
	}

	/**
	 * 获取 全部请求参数
	 *
	 * @return requestParam 全部请求参数
	 */
	public Map<String, String> getRequestParam() {
		return this.requestParam;
	}

	/**
	 * 设置 全部请求参数
	 *
	 * @param requestParam
	 *            全部请求参数
	 */
	public void setRequestParam(Map<String, String> requestParam) {
		this.requestParam = requestParam;
	}

	/**
	 * 获取 发生操作的系统代码
	 *
	 * @return sysCode 发生操作的系统代码
	 */
	public Integer getSysCode() {
		return this.sysCode;
	}

	/**
	 * 设置 发生操作的系统代码
	 *
	 * @param sysCode
	 *            发生操作的系统代码
	 */
	public void setSysCode(Integer sysCode) {
		this.sysCode = sysCode;
	}

	/**
	 * 获取 发生操作的系统名称
	 *
	 * @return sysName 发生操作的系统名称
	 */
	public String getSysName() {
		return this.sysName;
	}

	/**
	 * 设置 发生操作的系统名称
	 *
	 * @param sysName
	 *            发生操作的系统名称
	 */
	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
}
