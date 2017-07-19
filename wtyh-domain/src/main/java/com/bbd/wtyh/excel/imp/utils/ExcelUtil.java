package com.bbd.wtyh.excel.imp.utils;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.*;

import com.bbd.wtyh.excel.imp.constants.Alignment;
import com.bbd.wtyh.excel.imp.entity.ImportError;
import com.bbd.wtyh.excel.imp.entity.ProgressInfo;
import com.bbd.wtyh.excel.imp.entity.RowHeader;
import com.bbd.wtyh.excel.imp.entity.Style;

/**
 * excel工具类
 *
 * @author Created by LiYao on 2017-05-09 16:29.
 */
public class ExcelUtil {

	public static void generateErrorMarkFile(String progressKey, String fileName, OutputStream outputStream) throws Exception {
		Map<String, ProgressInfo> progressMap = ProgressUtil.getExcelProgress(progressKey, fileName);
		if (MapUtils.isEmpty(progressMap)) {
			return;
		}
		Workbook workbook = ExcelReadUtil.copy(fileName);
		// 得到一个POI的工具类
		CreationHelper factory = workbook.getCreationHelper();
		// ClientAnchor是附属在WorkSheet上的一个对象， 其固定在一个单元格的左上角和右下角.
		ClientAnchor anchor = factory.createClientAnchor();

		CellStyle redStyle = workbook.createCellStyle();
		redStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		redStyle.setFillForegroundColor(HSSFColor.RED.index);

		for (Map.Entry<String, ProgressInfo> map : progressMap.entrySet()) {
			ProgressInfo progress = map.getValue();
			if (progress == null || CollectionUtils.isEmpty(progress.getErrorList())) {
				continue;
			}
			Sheet sheet = workbook.getSheet(map.getKey());
			// // 绘图工具
			Drawing drawing = sheet.createDrawingPatriarch();

			List<ImportError> errorList = progress.getErrorList();
			for (ImportError errorInfo : errorList) {
				int rowNum = errorInfo.getRowNum();
				int colNum = errorInfo.getColNum();
				Row row = sheet.getRow(rowNum - 1);
				if (row == null) {
					continue;
				}

				// Excel批注
				Comment comment = drawing.createCellComment(anchor);
				RichTextString notation = factory.createRichTextString(errorInfo.getMsg());
				comment.setString(notation);

				if (colNum > 0) {
					Cell cell = row.getCell(colNum - 1);
					if (cell == null) {
						cell = row.createCell(colNum - 1);
					}
					cell.setCellStyle(redStyle);
					cell.setCellComment(comment);
				} else {
					for (int i = 0; i < progress.getMaxCol(); i++) {
						Cell cell = row.getCell(i);
						if (cell == null) {
							cell = row.createCell(i);
						}
						if (i == 0) {
							cell.setCellComment(comment);
						}
						cell.setCellStyle(redStyle);
					}
				}
			}
		}

		try {
			workbook.write(outputStream);
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}

	}

	public static void createSetMergeCell(XSSFSheet xssfSheet, RowHeader rowHeader) {

		int firstRow = rowHeader.getMergeFirstRow() - 1;
		int lastRow = rowHeader.getMergeLastRow() - 1;
		int firstCol = rowHeader.getMergeFirstCol() - 1;
		int lastCol = rowHeader.getMergeLastCol() - 1;

		CellRangeAddress cra = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol);
		xssfSheet.addMergedRegion(cra);

		XSSFCellStyle cellStyle = createCellStyle(xssfSheet.getWorkbook(), rowHeader.getStyle());

		for (int i = lastRow; i >= firstRow; i--) {
			XSSFRow titleRow = xssfSheet.getRow(i);
			if (titleRow == null) {
				titleRow = xssfSheet.createRow(i);
			}
			titleRow.setHeight((short) rowHeader.getHeight());

			for (int j = cra.getFirstColumn(); j <= cra.getLastColumn(); j++) {
				Cell singleCell = CellUtil.getCell(titleRow, j);
				singleCell.setCellStyle(cellStyle);
				singleCell.setCellValue(rowHeader.getValue());
			}
		}

		// Cell titleCell1 = CellUtil.getCell(titleRow, 0);

	}

	public static XSSFCellStyle createCellStyle(XSSFWorkbook workbook, Style style) {
		XSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);

		XSSFFont font = createFont(workbook, style);
		cellStyle.setFont(font);

		// 单元格颜色
		XSSFColor bgColor = ColorUtil.getColorByRGBOrHex(style.getBgcolor());
		if (bgColor != null) {
			cellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			cellStyle.setFillForegroundColor(bgColor);
		}

		cellStyle.setAlignment((short) Alignment.code("align_" + style.getAlign()));
		cellStyle.setVerticalAlignment((short) Alignment.code("vertical_" + style.getVertical()));
		return cellStyle;

	}

	public static XSSFFont createFont(XSSFWorkbook workbook, Style style) {
		XSSFFont font = workbook.createFont();
		font.setFontName(style.getFont());

		// 字体颜色
		XSSFColor fontColor = ColorUtil.getColorByRGBOrHex(style.getFontColor());
		if (fontColor != null) {
			font.setColor(fontColor);
		}

		// 字体大小
		if (style.getFontSize() > 0) {
			font.setFontHeightInPoints((short) style.getFontSize());
		}
		// 斜体
		font.setItalic(style.isItalic());
		// 加粗
		font.setBold(style.isBold());
		// 下划线
		if (style.isUnderline()) {
			font.setUnderline(Font.U_SINGLE);
		}
		return font;
	}

	/**
	 * 供页面展示下载名单列表使用
	 */
	public static Map<String, Map<String, String>> importList() {

		Map<String, Map<String, String>> mapLevel1 = new HashMap<>();

		// 企业评级
		Map<String, String> mapLevel21 = new HashMap<>();
		mapLevel21.put("企业评级", "company_level.xml");// 构建二级下拉
		mapLevel1.put("企业评级", mapLevel21);// 构建一级下拉

		// 小额贷款
		Map<String, String> mapLevel22 = new HashMap<>();
		mapLevel22.put("大额借款人", "Test1.xml");// 构建二级下拉
		mapLevel22.put("贷款余额", "Test2.xml");// 构建二级下拉
		mapLevel1.put("小额贷款", mapLevel22);// 构建一级下拉

		return mapLevel1;
	}

}