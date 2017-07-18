package com.bbd.wtyh.excel.imp.controller;

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

import com.bbd.wtyh.web.ResponseBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
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
import com.bbd.wtyh.excel.imp.utils.ExcelReadUtil;
import com.bbd.wtyh.excel.imp.utils.ExcelTemplateUtil;
import com.bbd.wtyh.excel.imp.utils.ExcelUtil;
import com.bbd.wtyh.excel.imp.utils.ProgressUtil;

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
		try {
			Excel excelEntity = ExcelTemplateUtil.readExcelTemplate(templateName);
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
	}

	@RequestMapping("/import-data")
	@ResponseBody
	public Object importData(@RequestParam("file") CommonsMultipartFile file, @RequestParam String templateName,
			HttpServletRequest request) {
		String fileName = file.getOriginalFilename();
		if (isFileImportOngoing(fileName, request)) {
			return ResponseBean.errorResponse("文件：" + fileName + "，正在处理中");
		}

		if (StringUtils.isBlank(templateName)) {
			return ResponseBean.errorResponse("导入模版XML不能为空");
		}

		if (!templateName.endsWith(".xml")) {
			templateName += ".xml";
		}

		try {
			ImportConfiguration conf = ImportConfiguration.getConfiguration(templateName, fileName);
			conf.setFileSize(file.getSize());

			Workbook workbook = ExcelReadUtil.createWorkbook(fileName, file.getInputStream());
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
		} catch (Exception e) {
			LOGGER.error("上传文件【{}】失败，服务器出现异常：", fileName, e);
			return ResponseBean.errorResponse("上传文件失败。服务器出现异常");
		}
		return ResponseBean.successResponse("上传文件成功");
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

	@RequestMapping("/all-progress")
	@ResponseBody
	public Object allProgress(HttpServletRequest request) throws Exception {
		String progressKey = ProgressUtil.getProgressKey(request);
		Map<String, Map<String, ProgressInfo>> allProgressMap = ProgressUtil.getAllProgress(progressKey);
		return ResponseBean.successResponse(allProgressMap);
	}

	@RequestMapping("/download-error-file")
	public void errorFile(@RequestParam String fileName, HttpServletRequest request, HttpServletResponse response) {

		OutputStream outputStream;

		try {
			outputStream = response.getOutputStream();

			fileName = URLDecoder.decode(fileName, "UTF-8");

			String userAgent = request.getHeader("User-Agent");
			String exportName;
			if (userAgent.toUpperCase().contains("MSIE")) {
				exportName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
			} else {
				exportName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			response.setCharacterEncoding("UTF-8");

			response.setHeader("Content-disposition", "attachment; filename*=utf-8'zh_cn'" + exportName); // 设定输出文件头
			response.setContentType("application/x-download");

			String progressKey = ProgressUtil.getProgressKey(request);
			ExcelUtil.generateErrorMarkFile(progressKey, fileName, outputStream);
		} catch (Exception e) {
			LOGGER.error("下载错误Excel文件【{}】失败：服务器报错!", fileName, e);
		}
	}
}
