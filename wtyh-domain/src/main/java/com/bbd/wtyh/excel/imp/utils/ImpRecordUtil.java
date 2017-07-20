package com.bbd.wtyh.excel.imp.utils;

import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.excel.imp.constants.ImpRecord;
import com.bbd.wtyh.excel.imp.entity.ImportRecord;
import com.bbd.wtyh.excel.imp.entity.ProgressInfo;
import com.bbd.wtyh.excel.imp.importer.ImportConfiguration;
import com.bbd.wtyh.util.ApplicationContextUtil;
import org.apache.commons.collections.CollectionUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 导入记录工具类
 *
 * @author Created by LiYao on 2017-07-19 15:35.
 */
public class ImpRecordUtil {

	private static BaseService baseService = (BaseService) ApplicationContextUtil.getBean("baseServiceImpl");

	public static ImportRecord createNewRecord(ImportConfiguration conf, Integer impType) throws Exception {
		ImportRecord importRecord = new ImportRecord();
		importRecord.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		importRecord.setFileName(conf.getFileName());
		importRecord.setFileSize(conf.getFileSize());
		importRecord.setImpState(ImpRecord.ING.state());
		importRecord.setImpDate(conf.getImportDate());
		importRecord.setImpType(impType);
		baseService.insert(importRecord);
		return importRecord;
	}

	public static List<ImportRecord> recordList(Integer impType) {
		return baseService.selectAll(ImportRecord.class, "imp_type = " + impType + " ORDER BY imp_date DESC");
	}

	public static void sheetEnd(String recordId, String progressKey) throws Exception {
		ImportRecord importRecord = baseService.selectById(ImportRecord.class, recordId);
		if (importRecord == null) {
			return;
		}
		String fileName = importRecord.getFileName();

		boolean isFinish = true;
		boolean haveError = false;
		boolean recordHaveError = importRecord.getImpState().equals(ImpRecord.FAIL.state());
		Map<String, ProgressInfo> excelProgress = ProgressUtil.getExcelProgress(progressKey, fileName);
		for (Map.Entry<String, ProgressInfo> entry : excelProgress.entrySet()) {
			ProgressInfo progress = entry.getValue();
			if (isFinish) {
				isFinish = progress.isFinish();
			}
			haveError = !CollectionUtils.isEmpty(progress.getErrorList());
		}

		if (haveError) {
			importRecord.setImpState(ImpRecord.FAIL.state());
			File file = FileUtil.createTempFile(importRecord.getId());
			OutputStream out = new FileOutputStream(file);
			ExcelUtil.generateErrorMarkFile(progressKey, fileName, out);

		}
		if (isFinish && !haveError && !recordHaveError) {
			importRecord.setImpState(ImpRecord.OK.state());
		}
		baseService.update(importRecord);

		if (isFinish) {
			// 把进度信息从缓存里面去了
			ProgressUtil.removeExcelProgress(progressKey, fileName);
			FileUtil.deleteTempFile(fileName);
		}
	}

	public static void errorFileDownloaded(String recordId) throws Exception {
		ImportRecord importRecord = new ImportRecord();
		importRecord.setId(recordId);
		importRecord.setRemark("报错文件已下载");
		baseService.update(importRecord);
	}

}