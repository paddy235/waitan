package com.bbd.wtyh.log.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.bbd.wtyh.domain.BaseDO;

import javax.persistence.Column;
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
public class UserLog extends BaseDO {

	/** 日志ID */
	@Id
	@Column(name = "id")
	private Long logId;
	/** 日志NUM */
	@Column(name = "log_num")
	private Long logNum;

	/** 操作者 */
	@Column
	private String operator;

	/** 操作者真实姓名 */
	@Column(name = "real_name")
	private String realName;

	/** 操作者所属部门 */
	@Column
	private String department;

	/** 地区代码 */
	@Column(name = "area_code")
	private String areaCode;

	/** 操作发生时间 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "operation_date")
	private Date operationDate;

	/** 操作类型描述 */
	@Column(name = "operation_desc")
	private String operationDesc;

	/** 操作类型 */
	@Column(name = "operation_type")
	private Integer operationType;

	/** 日志内容 */
	@Column(name = "log_content")
	private String LogContent;

	/** 发生操作的系统代码 */
	@Column(name = "sys_code")
	private Integer sysCode;

	/** 发生操作的系统名称 */
	@Column(name = "sys_name")
	private String sysName;

	/** 请求IP */
	@Column(name = "request_ip")
	private String requestIP;

	/** 请求地址 */
	@Transient
	private String requestURI;

	/** 请求地址描述 */
	@Column(name = "request_code")
	private Integer requestCode;

	/** 请求地址描述 */
	@Column(name = "request_desc")
	private String requestDesc;

	/** 全部请求参数 */
	@Transient
	private Map<String, String> requestParam;


	@Transient
	private String uuid;

	/**
	 * 获取 日志ID
	 *
	 * @return logId 日志ID
	 */
	public Long getLogId() {
		return this.logId;
	}

	/**
	 * 设置 日志ID
	 *
	 * @param logId
	 *            日志ID
	 */
	public void setLogId(Long logId) {
		this.logId = logId;
	}

	/**
	 * 获取 日志编号
	 *
	 * @return logId 日志编号
	 */
	public Long getLogNum() {
		return this.logNum;
	}

	/**
	 * 设置 日志编号
	 *
	 * @param logNum
	 *            日志编号
	 */
	public void setLogNum(Long logNum) {
		this.logNum = logNum;
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
	 * @return operationDate 操作发生时间
	 */
	public Date getOperationDate() {
		return this.operationDate;
	}

	/**
	 * 设置 操作发生时间
	 *
	 * @param operationDate
	 *            操作发生时间
	 */
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
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
	 * 获取 请求地址描述
	 *
	 * @return requestCode 请求地址描述
	 */
	public Integer getRequestCode() {
		return this.requestCode;
	}

	/**
	 * 设置 请求地址描述
	 *
	 * @param requestCode
	 *            请求地址描述
	 */
	public void setRequestCode(Integer requestCode) {
		this.requestCode = requestCode;
	}

	/**
	 * 获取 请求地址描述
	 *
	 * @return requestDesc 请求地址描述
	 */
	public String getRequestDesc() {
		return this.requestDesc;
	}

	/**
	 * 设置 请求地址描述
	 *
	 * @param requestDesc
	 *            请求地址描述
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
	 * 获取 地区代码
	 *
	 * @return areaCode 地区代码
	 */
	public String getAreaCode() {
		return this.areaCode;
	}

	/**
	 * 设置 地区代码
	 *
	 * @param areaCode
	 *            地区代码
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
