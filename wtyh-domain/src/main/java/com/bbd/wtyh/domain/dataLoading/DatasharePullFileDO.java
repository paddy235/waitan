package com.bbd.wtyh.domain.dataLoading;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by wangchenge on 2016/8/21 0021.
 */
@Table(name = "datashare_pull_file")
public class DatasharePullFileDO {

	@Id
	@Column
	private Integer file_id;

	@Column
	private String file_name;

	@Column
	private String file_url;

	@Column
	private Integer data_version;

	@Column(name = "is_pull")
	private boolean pull;

	@Column
	private Integer task_id;

	@Column
	private String create_by;

	@Column
	private Date create_date;

	@Column
	private String update_by;

	@Column
	private Date update_date;

	public DatasharePullFileDO() {
	}

	public Integer getFile_id() {
		return file_id;
	}

	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_url() {
		return file_url;
	}

	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}

	public Integer getTask_id() {
		return task_id;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public Integer getData_version() {
		return data_version;
	}

	public void setData_version(Integer data_version) {
		this.data_version = data_version;
	}

	public boolean isPull() {
		return pull;
	}

	public void setPull(boolean pull) {
		this.pull = pull;
	}
}