package com.bbd.wtyh.excel.imp.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bbd.wtyh.excel.imp.entity.ImportError;
import com.bbd.wtyh.excel.imp.entity.Sheet;
import com.bbd.wtyh.excel.imp.importer.AbstractImporter;
import com.bbd.wtyh.excel.imp.importer.ImportConfiguration;
import com.bbd.wtyh.excel.imp.utils.ProgressUtil;

/**
 * 抽象导入处理器
 *
 * @author Created by LiYao on 2017-05-17 11:13.
 */
public abstract class AbstractImportHandler<T> implements ImportHandler<T> {

	protected AbstractImporter abstractImporter;
	protected ImportConfiguration configuration;
	protected Sheet sheet;
	protected HttpServletRequest request;
	protected int rowNumber;

	@Override
	public final void init(ImportConfiguration configuration, Sheet sheet, HttpServletRequest request) {
		this.configuration = configuration;
		this.sheet = sheet;
		this.request = request;
	}

	@Override
	public String getProgressKey(HttpServletRequest request) throws Exception {
		return ProgressUtil.getProgressKey(request);
	}

	@Override
	public abstract void start(HttpServletRequest request) throws Exception;

	@Override
	public abstract void startRow(Map<String, String> row) throws Exception;

	@Override
	public abstract boolean validateRow(Map<String, String> row) throws Exception;

	@Override
	public abstract void endRow(Map<String, String> row, T bean) throws Exception;

	@Override
	public abstract void end() throws Exception;

	@Override
	public abstract void exception(Exception e);

	@Override
	public void addError(String msg) {
		this.abstractImporter.addError(msg, getRowNumber(), 0);
	}

	@Override
	public List<ImportError> errorList() {
		return abstractImporter.errorList();
	}

	@Override
	public int getRowNumber() {
		return rowNumber;
	}

	@Override
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	@Override
	public void setAbstractImporter(AbstractImporter abstractImporter) {
		this.abstractImporter = abstractImporter;
	}

	@Override
	public ImportConfiguration getConfiguration() {
		return configuration;
	}

	@Override
	public Sheet getSheet() {
		return sheet;
	}

	@Override
	public HttpServletRequest getRequest() {
		return request;
	}
}
