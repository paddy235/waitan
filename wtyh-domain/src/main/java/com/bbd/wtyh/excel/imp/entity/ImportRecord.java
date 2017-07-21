package com.bbd.wtyh.excel.imp.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.bbd.wtyh.excel.imp.constants.ImpRecord;
import com.bbd.wtyh.excel.imp.utils.FileUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Id;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 导入进度
 *
 * @author Created by LiYao on 2017-07-19 15:44.
 *
 */
@Entity
@Table(name = "import_record")
public class ImportRecord {

	/** ID */
	@Id
	@Column(name = "id", updatable = false)
	private String id;

	/** 文件名 */
	@Column(name = "file_name", updatable = false)
	private String fileName;

	/**  */
	@Column(name = "file_size", updatable = false)
	private Long fileSize;

	/** 导入时间 */
	@Column(name = "imp_date", updatable = false)
	@JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format = "YYYY-MM-dd HH:mm:ss")
	private Date impDate;

	/** 导入状态 */
	@Column(name = "imp_state")
	private Integer impState;

	@Column(name = "imp_type", updatable = false)
	private Integer impType;

	/** 备注 */
	@Column(name = "remark")
	private String remark;

	/**
	 * 获取 ID
	 *
	 * @return id ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置 ID
	 *
	 * @param id
	 *            ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取 文件名
	 *
	 * @return fileName 文件名
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * 设置 文件名
	 *
	 * @param fileName
	 *            文件名
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 获取
	 *
	 * @return fileSize
	 */
	public Long getFileSize() {
		return fileSize;
	}

	/**
	 * 设置
	 *
	 * @param fileSize
	 */
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * 获取 导入时间
	 *
	 * @return impDate 导入时间
	 */
	public Date getImpDate() {
		return impDate;
	}

	/**
	 * 设置 导入时间
	 *
	 * @param impDate
	 *            导入时间
	 */
	public void setImpDate(Date impDate) {
		this.impDate = impDate;
	}

	/**
	 * 获取 导入状态
	 *
	 * @return impState 导入状态
	 */
	public Integer getImpState() {
		return impState;
	}

	/**
	 * 设置 导入状态
	 *
	 * @param impState
	 *            导入状态
	 */
	public void setImpState(Integer impState) {
		this.impState = impState;
	}

	/**
	 * 获取 备注
	 *
	 * @return remark 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置 备注
	 *
	 * @param remark
	 *            备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getImpType() {
		return this.impType;
	}

	public void setImpType(Integer impType) {
		this.impType = impType;
	}

	public boolean isImpSuccess() {
		return ImpRecord.OK.equals(ImpRecord.getRecord(this.getImpState()));
	}

	public boolean isImpFinish() {
		Integer state = ImpRecord.ING.state();
		return state.compareTo(this.getImpState()) == -1;
	}

	public String getImpStateDesc() {
		return ImpRecord.getRecord(this.getImpState()).desc();
	}

	public String getFileSizeDesc() {
		double fileSize = this.getFileSize();
		return FileUtil.fileSizeDesc(fileSize);
	}

}