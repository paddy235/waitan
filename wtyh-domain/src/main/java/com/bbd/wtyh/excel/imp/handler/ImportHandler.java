package com.bbd.wtyh.excel.imp.handler;

import com.bbd.wtyh.excel.imp.entity.ImportError;
import com.bbd.wtyh.excel.imp.entity.Sheet;
import com.bbd.wtyh.excel.imp.importer.AbstractImporter;
import com.bbd.wtyh.excel.imp.importer.ImportConfiguration;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 导入处理器
 *
 * @author Created by LiYao on 2017-07-08 13:55.
 */
public interface ImportHandler<T> {

	void init(ImportConfiguration configuration, Sheet sheet, HttpServletRequest request);

	String getProgressKey(HttpServletRequest request) throws Exception;

	void start(HttpServletRequest request) throws Exception;

	void startRow(Map<String, String> row) throws Exception;

	/**
	 * 校验一行。检验不通过将不会进入endRow
	 *
	 * @param row
	 * @return
	 * @throws Exception
	 */
	boolean validateRow(Map<String, String> row) throws Exception;

	void endRow(Map<String, String> row, T bean) throws Exception;

	void end() throws Exception;

	void exception(Exception e);

	void addError(String msg);

	List<ImportError> errorList();

	int getRowNumber();

	void setRowNumber(int rowNumber);

	void setAbstractImporter(AbstractImporter abstractImporter);

	ImportConfiguration getConfiguration();

	Sheet getSheet();

	HttpServletRequest getRequest();
}
