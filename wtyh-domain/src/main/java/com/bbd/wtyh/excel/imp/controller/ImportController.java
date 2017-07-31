package com.bbd.wtyh.excel.imp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.LongAdder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.bbd.wtyh.common.comenum.UserType;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.excel.imp.constants.ImpRecord;
import com.bbd.wtyh.excel.imp.entity.ImportRecord;
import com.bbd.wtyh.excel.imp.exception.ImportRecordException;
import com.bbd.wtyh.excel.imp.utils.*;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.bbd.wtyh.excel.imp.entity.Excel;
import com.bbd.wtyh.excel.imp.entity.ProgressInfo;
import com.bbd.wtyh.excel.imp.entity.Sheet;
import com.bbd.wtyh.excel.imp.importer.DefaultImporter;
import com.bbd.wtyh.excel.imp.importer.ImportConfiguration;
import com.bbd.wtyh.excel.imp.importer.Importer;

/**
 * 导入控制器
 *
 * @author Created by LiYao on 2017-05-17 10:39.
 */
@Controller
@RequestMapping("/import")
public class ImportController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ImportController.class);

	@RequestMapping("/import-list-one")
	@ResponseBody
	public Object importListOne() {
		Map<String, Map<String, String>> map = ExcelUtil.importList();
		List<Map<String, String>> listMap = new ArrayList<>();

		for (String key : map.keySet()) {
			Map<String, String> returnMap = new HashMap<>();
			returnMap.put("desc", key);
			returnMap.put("key", key);
			listMap.add(returnMap);

		}
		return ResponseBean.successResponse(listMap);
	}

	@RequestMapping("/import-list-two")
	@ResponseBody
	public Object importListTwo(String key) {
		Map<String, Map<String, String>> map = ExcelUtil.importList();
		Map<String, String> level2Map = map.get(key);
		List<Map<String, String>> listMap = new ArrayList<>();
		for (Map.Entry<String, String> entry : level2Map.entrySet()) {
			Map<String, String> m = new HashMap<>();
			m.put("key", entry.getValue());
			m.put("desc", entry.getKey());
			listMap.add(m);
		}
		return ResponseBean.successResponse(listMap);
	}

	@RequestMapping("/import-template")
	public void importTemplate(@RequestParam String templateName, HttpServletRequest request, HttpServletResponse response) {
		if (!templateName.endsWith(".xml")) {
			templateName += ".xml";
		}
		Excel excelEntity = null;
		try {
			excelEntity = ExcelTemplateUtil.readExcelTemplate(templateName);
			response.setCharacterEncoding("UTF-8");
			String userAgent = request.getHeader("User-Agent");
			String filename;
			if (userAgent.toUpperCase().contains("MSIE")) {
				filename = new String(excelEntity.getName().getBytes("GBK"), "ISO-8859-1");
			} else {
				filename = new String(excelEntity.getName().getBytes("UTF-8"), "ISO-8859-1");
			}
			response.setContentType("multipart/form-data");
			response.setHeader("Content-Disposition", "attachment;fileName=" + filename + ".xlsx");
			ExcelTemplateUtil.createTemplate(excelEntity, response.getOutputStream());
		} catch (Exception e) {
			LOGGER.error("生成Excel模版【{}】失败，服务器出现异常：", templateName, e);
		}

		String logMsg = "下载导入模版【" + excelEntity.getName() + "】";
		UserLogRecord.record(logMsg, Operation.Type.DOWNLOAD, Operation.Page.blank, Operation.System.back, request);
	}

	@RequestMapping("/import-data")
	@ResponseBody
	public Object importData(@RequestParam("file") CommonsMultipartFile file, @RequestParam String templateName,
			@RequestParam Integer impType, HttpServletRequest request) {
		if (StringUtils.isBlank(templateName)) {
			return ResponseBean.errorResponse("导入模版XML不能为空");
		}
		if (!templateName.endsWith(".xml")) {
			templateName += ".xml";
		}
		String fileName = file.getOriginalFilename();
		if (isFileImportOngoing(fileName, request)) {
			return ResponseBean.errorResponse("文件：" + fileName + "，正在处理中，请等待完成后重新上传");
		}

		List<CommonsMultipartFile> untreated = new ArrayList<>();
		untreated.add(file);
		syncDealWith(untreated, templateName, impType, request);
		return ResponseBean.successResponse("上传文件成功，数据处理中");
	}

	@RequestMapping("/import-data-list")
	@ResponseBody
	public Object importDataList(@RequestParam CommonsMultipartFile[] files, @RequestParam String templateName,
			@RequestParam Integer impType, HttpServletRequest request) {
		if (StringUtils.isBlank(templateName)) {
			return ResponseBean.errorResponse("导入模版XML不能为空");
		}
		if (!templateName.endsWith(".xml")) {
			templateName += ".xml";
		}
		List<CommonsMultipartFile> untreated = new ArrayList<>();
		List<String> msgList = new ArrayList<>();

		List<String> fileNames = new ArrayList<>();
		for (CommonsMultipartFile file : files) {
			String fileName = file.getOriginalFilename();
			fileNames.add(fileName);
			if (isFileImportOngoing(fileName, request)) {
				msgList.add("文件：" + fileName + "，正在处理中，请等待完成后重新上传");
				continue;
			}
			untreated.add(file);
		}
		syncDealWith(untreated, templateName, impType, request);

		String logMsg = "导入数据【" + StringUtils.join(fileNames, ",") + "】";
		UserLogRecord.record(logMsg, Operation.Type.IMPORT, Operation.Page.blank, Operation.System.back, request);

		if (msgList.isEmpty()) {
			msgList.add("上传文件成功，数据处理中");
			return ResponseBean.successResponse(msgList);
		} else {
			return ResponseBean.successResponse(msgList);
		}

	}

	private void syncDealWith(List<CommonsMultipartFile> files, String templateName, Integer impType, HttpServletRequest request) {
		UserInfoTableDo userInfo = (UserInfoTableDo) request.getSession().getAttribute("loginUser");

		ExecutorService threadPool = Executors.newFixedThreadPool(1);
		files.forEach((CommonsMultipartFile file) -> threadPool.execute(() -> {
			String fileName = file.getOriginalFilename();
			long fileSize = file.getSize();
			ImportRecord record = ImpRecordUtil.createNewRecord(userInfo.getLoginName(), fileName, fileSize, impType);
			try {
				ImportConfiguration conf = ImportConfiguration.getConfiguration(templateName, fileName);
				conf.setFileSize(fileSize);
				conf.setRecordId(record.getId());

				Workbook workbook = ExcelReadUtil.createWorkbook(fileName, file.getInputStream());
				if (workbook == null) {
					return;
				}
				ExcelReadUtil.readExcel(workbook, conf.getExcelEntity());

				List<Sheet> sheetList = conf.getSheetList();
				ExecutorService fixedThreadPool = Executors.newFixedThreadPool(sheetList.size(), new ThreadFactory() {

					final LongAdder num = new LongAdder();

					@Override
					public Thread newThread(Runnable r) {
						num.increment();
						Thread t = new Thread(r);
						t.setName("export-excel-" + fileName + "-" + num);
						// 设置为守护线程
						t.setDaemon(true);
						return t;
					}
				});

				for (Sheet sheet : sheetList) {

					fixedThreadPool.execute(() -> {
						Importer importer = new DefaultImporter(conf, sheet, request);
						importer.importData();
					});
				}
				fixedThreadPool.shutdown();
			} catch (ImportRecordException e) {
				ImpRecordUtil.appearError(record.getId(), e.getMessage());
			} catch (Exception e) {
				ImpRecordUtil.appearError(record.getId(), "上传文件解析失败");
				LOGGER.error("处理文件【{}】失败，服务器出现异常：", fileName, e);
			}
		}));
	}

	private boolean isFileImportOngoing(String fileName, HttpServletRequest request) {
		String key = ProgressUtil.getProgressKey(request);
		Map<String, ProgressInfo> progressMap = ProgressUtil.getExcelProgress(key, fileName);
		if (progressMap == null) {
			return false;
		}
		for (Map.Entry<String, ProgressInfo> map : progressMap.entrySet()) {
			ProgressInfo progress = map.getValue();
			if (progress != null && !progress.isFinish()) {
				return true;
			}
		}
		return false;
	}

	@RequestMapping("/import-progress")
	@ResponseBody
	public Object importProgress(@RequestParam String fileName, HttpServletRequest request) throws Exception {
		String progressKey = ProgressUtil.getProgressKey(request);
		return ResponseBean.successResponse(ProgressUtil.getExcelProgress(progressKey, fileName));
	}

	@RequestMapping("/record-list")
	@ResponseBody
	public Object impRecordList(String fileName, String startDate, String endDate, String impState, @RequestParam Integer impType,
			HttpServletRequest request) throws Exception {

		UserInfoTableDo userInfo = (UserInfoTableDo) request.getSession().getAttribute("loginUser");
		String loginName = userInfo.getLoginName();
		if (UserType.SUPER_ADMIN.getTypeCode().equals(userInfo.getUserType())) {
			loginName = "";
		}
		// 用户日志记录
		String logMsg = "";
		Operation.Page p = Operation.Page.CO_LIST_EXPORT;
		if (impType.equals(1)) {
			logMsg = "搜索企业名单批量导入记录";
			p = Operation.Page.CO_LIST_EXPORT;
		}
		if (impType.equals(2)) {
			logMsg = "搜索行业数据批量导入记录";
			p = Operation.Page.INDUSTRY_MANAGE;
		}
		if (impType.equals(3)) {
			logMsg = "搜索楼宇企业批量导入记录";
			p = Operation.Page.PARK_BUILDING_MANAGE;
		}
		String tmpFileName = fileName;
		if (StringUtils.isNotBlank(tmpFileName)) {
			tmpFileName = "文件名称:" + tmpFileName + ",";
		}

		String tmpStartDate = startDate;
		if (StringUtils.isNotBlank(tmpStartDate)) {
			tmpStartDate = "开始时间:" + tmpStartDate + ",";
		}
		String tmpEndDate = endDate;
		if (StringUtils.isNotBlank(tmpEndDate)) {
			tmpEndDate = "结束时间:" + tmpEndDate + ",";
		}
		String state = "全部";
		if (StringUtils.isNotBlank(impState)) {
			state = ImpRecord.getRecord(Integer.parseInt(impState)).desc();
		}
		String conditions = ",搜索条件[%s%s%s状态:%s]";
		logMsg += String.format(conditions, tmpFileName, tmpStartDate, tmpEndDate, state);
		UserLogRecord.record(logMsg, Operation.Type.query, p, Operation.System.back, request);
		return ResponseBean.successResponse(ImpRecordUtil.recordList(loginName, fileName, startDate, endDate, impState, impType));
	}

	@RequestMapping("/download-error-file")
	public void errorFile(@RequestParam String fileName, @RequestParam String recordId, HttpServletRequest request,
			HttpServletResponse response) {

		OutputStream outputStream = null;
		InputStream input = null;
		try {
			outputStream = response.getOutputStream();
			fileName = URLDecoder.decode(fileName, "UTF-8");

			String charsetName;
			String userAgent = request.getHeader("User-Agent");
			if (userAgent.toUpperCase().contains("MSIE")) {
				charsetName = "GBK";
			} else {
				charsetName = "UTF-8";
			}

			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8");

			File file = FileUtil.getTempFile(recordId);
			if (file == null || !file.exists()) {
				String result = JSON.toJSONString(ResponseBean.errorResponse("文件不存在，可能已被删除!"));
				outputStream.write(result.getBytes());
				return;
			}

			String exportName;
			exportName = new String(fileName.getBytes(charsetName), "ISO-8859-1");

			response.setHeader("Content-disposition", "attachment; filename*=utf-8'zh_cn'" + exportName); // 设定输出文件头
			response.setContentType("application/x-download");

			input = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(input);
			workbook.write(outputStream);
			ImpRecordUtil.errorFileDownloaded(recordId);
		} catch (Exception e) {
			LOGGER.error("下载错误Excel文件【{}】失败：服务器报错!", fileName, e);
		} finally {
			FileUtil.closeResource(outputStream, input);
			String logMsg = "下载错误Excel文件【" + fileName + "】";
			UserLogRecord.record(logMsg, Operation.Type.DOWNLOAD, Operation.Page.blank, Operation.System.back, request);
		}
	}
}
