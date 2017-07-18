package com.bbd.wtyh.excel.imp.importer;

import javax.servlet.http.HttpServletRequest;

import com.bbd.wtyh.excel.imp.entity.Sheet;

/**
 * 默认导入器
 *
 * @author Created by LiYao on 2017-05-17 16:24.
 */
public class DefaultImporter extends AbstractImporter {

	public DefaultImporter(ImportConfiguration conf, Sheet sheet, HttpServletRequest request) {
		super(conf, sheet, request);
	}
}
