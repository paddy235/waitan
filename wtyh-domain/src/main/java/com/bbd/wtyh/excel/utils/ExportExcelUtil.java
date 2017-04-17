package com.bbd.wtyh.excel.utils;

import com.bbd.wtyh.excel.ExportExcel;
import com.bbd.wtyh.excel.Sheet;
import com.bbd.wtyh.util.WtyhAdminHelper;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;

import java.io.File;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-04-13 9:18.
 */
public class ExportExcelUtil {

	public static String exportExcelMethod(ExportExcel excel) throws Exception {
		// 创建Excel的工作空间， Workbook,对应到一个excel文档
		HSSFWorkbook wb = excel.getWorkbook();

		List<Sheet> sheetList = excel.getSheetSet();

		for (Sheet mySheet : sheetList) {
			// 创建Excel的工作sheet,对应到一个excel文档的tab
			HSSFSheet sheet = mySheet.getHSSFSheet();

			String[] dataMapKeys = mySheet.getDataMapKeys();

			// 列宽
			int[] columnWidth = mySheet.getColumnWidth();

			// 列名
			String[] columnNames = mySheet.getColumnName();

			// 行号
			int rowNum = sheet.getLastRowNum();
			// 存在合并区域
			if (sheet.getNumMergedRegions() > 0) {
				rowNum++;
			}

			// 创建Excel的sheet的一行。及每列的列名
			HSSFRow row = sheet.createRow(rowNum);
			row.setHeight(mySheet.getRowHeight());
			for (int i = 0; i < columnNames.length; i++) {
				// 创建一个Excel的单元格
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(mySheet.getHeaderStyle());
				cell.setCellValue(columnNames[i]);
			}
			// 填入数据
			List<Map<String, Object>> dataMapSet = mySheet.getDateSet();
			for (Map<String, Object> dataMap : dataMapSet) {
				row = sheet.createRow(++rowNum);
				row.setHeight((mySheet.getRowHeight()));
				int cellNum = 0;
				for (String dataMapKey : dataMapKeys) {
					HSSFCell cell = row.createCell(cellNum++);
					cell.setCellStyle(mySheet.getContentStyle());
					Object value = dataMap.get(dataMapKey);
					if (value == null) {
						value = "";
					}
					if (value.getClass().getSuperclass().equals(Number.class)) {
						cell.setCellValue(Double.parseDouble(value.toString()));
					} else {
						cell.setCellValue(value.toString());
					}
				}
			}
			if (ArrayUtils.isNotEmpty(columnWidth)) {
				// 设置每列的宽度
				for (int i = 0; i < columnWidth.length; i++) {
					sheet.setColumnWidth(i, columnWidth[i]);
				}
			} else {
				for (int i = 0; i < dataMapKeys.length; i++) {
					// 列宽自适应
					sheet.autoSizeColumn(i, true);
				}
			}

		}

		OutputStream out = excel.getOutputStream();
		if (out == null) {
			out = excel.createOutputStream();
		}
		try {
			wb.write(out);
			out.flush();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		return excel.getExportPath() + excel.getExcelName();
	}

	/**
	 * 处理导出文件存放路径
	 * 
	 * @param path
	 * @return
	 */
	public static String dealWithExportPath(String path) {
		if (StringUtils.isBlank(path)) {
			path = WtyhAdminHelper.exportPath;
		}

		if (StringUtils.isBlank(path)) {
			path = ExportExcel.DEFAULT_EXPORT_PATH;
		}

		if (!path.endsWith(File.separator)) {
			path += File.separator;
		}

		String osName = System.getProperty("os.name");
		if (StringUtils.isNotBlank(osName) && osName.toUpperCase().startsWith("WIN")) {
			// 处理文件分隔符
			path = path.replace("/", File.separator);

			File[] listRoots = File.listRoots();
			for (File root : listRoots) {
				if (path.toUpperCase().startsWith(root.toString().toUpperCase())) {
					if (path.endsWith(File.separator)) {
						return path;
					}
					return path + File.separator;
				}
			}
			path = listRoots[listRoots.length - 1] + path;
		}
		return path;
	}
}
