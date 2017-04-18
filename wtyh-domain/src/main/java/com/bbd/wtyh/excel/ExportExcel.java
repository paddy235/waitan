package com.bbd.wtyh.excel;

import com.bbd.wtyh.excel.annotation.Excel;
import com.bbd.wtyh.excel.utils.ExportExcelUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * ExportExcel
 *
 * @author Created by LiYao on 2017-04-13 10:37.
 */
public class ExportExcel {

	public static final String DEFAULT_EXPORT_PATH = "export" + File.separator + "excel";

	/** excel文件名称 */
	private String excelName;

	/** sheet */
	private List<Sheet> sheetSet = new ArrayList<>();

	/** 输出流 */
	private OutputStream outputStream;

	/** 导出文件存放路径 */
	private String exportPath;

	/** Excel的工作空间， Workbook,对应到一个excel文档 */
	private HSSFWorkbook workbook;

	/** 字体样式 。整个excel统一，如果sheet有特殊要求，设置com.bbd.wtyh.excel.Sheet.font */
	private HSSFFont font;

	/** 表头单元格样式。整个excel统一，如果sheet有特殊要求，设置com.bbd.wtyh.excel.Sheet.headerStyle */
	private HSSFCellStyle headerStyle;

	/**
	 * 正文单元格样式 。整个excel统一，如果sheet有特殊要求，设置com.bbd.wtyh.excel.Sheet.contentStyle
	 */
	private HSSFCellStyle contentStyle;

	public ExportExcel() {
		this(null);
	}

	public ExportExcel(String excelName) {
		this.excelName = this.validationExcelName(excelName);
		init();
	}

	public Sheet createSheet(String[] columnName, String[] dataMapKeys, List<Map<String, Object>> dataList) throws Exception {
		return this.createSheet(null, columnName, dataMapKeys, dataList);
	}

	public Sheet createSheet(String sheetName, String[] columnName, String[] dataMapKeys, List<Map<String, Object>> dataList)
			throws Exception {
		if (sheetName == null) {
			sheetName = "Sheet" + (sheetSet.size() + 1);
		}
		// 创建Excel的工作sheet,对应到一个excel文档的tab
		HSSFSheet HSSFSheet = workbook.createSheet(sheetName);

		Sheet sheet = new Sheet(sheetName, columnName, dataMapKeys, dataList);
		sheet.setHeaderStyle(this.headerStyle);
		sheet.setContentStyle(this.contentStyle);
		sheet.setHSSFSheet(HSSFSheet);
		sheet.setExportExcel(this);
		this.sheetSet.add(sheet);
		return sheet;
	}

	public <T> Sheet createSheet(List<T> dateSet) throws Exception {
		return this.createSheet(null, dateSet);
	}

	public <T> Sheet createSheet(String sheetName, List<T> dateSet) throws Exception {
		StringBuilder dataMapKeysb = new StringBuilder();
		StringBuilder columnNameSb = new StringBuilder();
		List<Map<String, Object>> dataList = new ArrayList<>();

		boolean getKey = true;
		for (T entity : dateSet) {
			Field[] fields = entity.getClass().getDeclaredFields();
			Map<String, Object> dataMap = new HashMap<>(32);
			for (Field field : fields) {
				field.setAccessible(true);
				Excel anExcel = field.getAnnotation(Excel.class);
				if (anExcel == null) {
					continue;
				}

				if (getKey) {
					dataMapKeysb.append(",").append(field.getName());
					columnNameSb.append(",").append(anExcel.exportName());
				}

				// 获取get方法
				Method method = entity.getClass().getMethod("get" + StringUtils.capitalize(field.getName()));
				Object value = method.invoke(entity);
				if (value == null) {
					value = "";
				}

				if (value instanceof Date) {
					value = DateFormatUtils.format((Date) value, anExcel.dateFormat());
				}

				dataMap.put(field.getName(), value);
			}
			dataList.add(dataMap);
			getKey = false;
		}
		if (dataMapKeysb.length() == 0) {
			dataMapKeysb.append(",");
		}
		if (columnNameSb.length() == 0) {
			columnNameSb.append(",");
		}
		String[] dataMapKeys = dataMapKeysb.substring(1).split(",");
		String[] columnName = columnNameSb.substring(1).split(",");

		return this.createSheet(sheetName, columnName, dataMapKeys, dataList);
	}

	/**
	 * 导出excel。如果导出的数字类型变为科学计数，请自行转为String类型
	 * 
	 * @return 导出文件存放位置
	 * @throws Exception
	 */
	public String exportExcel() throws Exception {
		return ExportExcelUtil.exportExcelMethod(this);
	}

	public OutputStream createOutputStream() throws Exception {
		if (outputStream != null) {
			return this.outputStream;
		}
		this.exportPath = ExportExcelUtil.dealWithExportPath(this.exportPath);
		File directory = new File(this.exportPath);
		directory.mkdirs();
		File file = new File(this.exportPath + this.excelName);
		file.createNewFile();

		this.outputStream = new FileOutputStream(file);

		return this.outputStream;
	}

	public HSSFFont createDefaultFont() {
		HSSFFont font = workbook.createFont();
		font.setFontName("宋体");
		font.setFontHeight((short) 300);
		return font;
	}

	public HSSFCellStyle createDefaultStyle() {
		HSSFCellStyle lableStyle = workbook.createCellStyle();
		lableStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		lableStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		lableStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		lableStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		lableStyle.setFont(font);
		return lableStyle;
	}

	public HSSFCellStyle createDefaultHeaderStyle() {

		HSSFFont font = workbook.createFont();
		font.setFontName("宋体");
		font.setFontHeight((short) 300);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		HSSFCellStyle lableStyle = workbook.createCellStyle();
		lableStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		lableStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		lableStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		lableStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		lableStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 单元格颜色
		lableStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		lableStyle.setFillForegroundColor(HSSFColor.YELLOW.index);

		lableStyle.setFont(font);
		return lableStyle;
	}

	private void init() {
		this.workbook = new HSSFWorkbook();
		this.font = this.createDefaultFont();
		this.headerStyle = this.createDefaultHeaderStyle();
		this.contentStyle = this.createDefaultStyle();
	}

	private String validationExcelName(String excelName) {
		if (StringUtils.isBlank(excelName)) {
			excelName = System.nanoTime() + ".xls";
		}
		if (!StringUtils.contains(excelName, ".")) {
			excelName += ".xls";
		}
		return excelName;
	}

	/**********************************************************************************
	 ***************************** getter and setter **********************************
	 **********************************************************************************/

	/**
	 * 获取 excel文件名称
	 *
	 * @return excelName excel文件名称
	 */
	public String getExcelName() {
		return this.excelName;
	}

	/**
	 * 设置 excel文件名称
	 *
	 * @param excelName
	 *            excel文件名称
	 */
	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}

	/**
	 * 获取 sheet
	 *
	 * @return sheetSet sheet
	 */
	public List<Sheet> getSheetSet() {
		return this.sheetSet;
	}

	/**
	 * 设置 sheet
	 *
	 * @param sheet
	 */
	public void addSheetSet(Sheet sheet) {
		this.sheetSet.add(sheet);
	}

	/**
	 * 设置 sheet
	 *
	 * @param sheetSet
	 */
	public void addAllSheetSet(List<Sheet> sheetSet) {
		this.sheetSet.addAll(sheetSet);
	}

	/**
	 * 获取 输出流
	 *
	 * @return outputStream 输出流
	 */
	public OutputStream getOutputStream() {
		return this.outputStream;
	}

	/**
	 * 设置 输出流
	 *
	 * @param outputStream
	 *            输出流
	 */
	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	/**
	 * 获取 Excel的工作空间， Workbook对应到一个excel文档
	 *
	 * @return workbook Excel的工作空间， Workbook对应到一个excel文档
	 */
	public HSSFWorkbook getWorkbook() {
		return this.workbook;
	}

	/**
	 * 获取 字体样式
	 *
	 * @return font 字体样式
	 */
	public HSSFFont getFont() {
		return this.font;
	}

	/**
	 * 设置 字体样式
	 *
	 * @param font
	 *            字体样式
	 */
	public void setFont(HSSFFont font) {
		this.font = font;
	}

	/**
	 * 获取 单元格样式
	 *
	 * @return headerStyle 单元格样式
	 */
	public HSSFCellStyle getHeaderStyle() {
		return this.headerStyle;
	}

	/**
	 * 设置 单元格样式
	 *
	 * @param headerStyle
	 *            单元格样式
	 */
	public void setHeaderStyle(HSSFCellStyle headerStyle) {
		this.headerStyle = headerStyle;
	}

	/**
	 * 获取
	 *
	 * @return contentStyle
	 */
	public HSSFCellStyle getContentStyle() {
		return this.contentStyle;
	}

	/**
	 * 设置
	 *
	 * @param contentStyle
	 */
	public void setContentStyle(HSSFCellStyle contentStyle) {
		this.contentStyle = contentStyle;
	}

	public HSSFCellStyle getNewHSSFCellStyle() {
		return workbook.createCellStyle();
	}

	public HSSFFont getNewHSSFFont() {
		return workbook.createFont();
	}

	/**
	 * 获取 导出文件存放路径
	 *
	 * @return exportPath 导出文件存放路径
	 */
	public String getExportPath() {
		return this.exportPath;
	}

	/**
	 * 设置 导出文件存放路径
	 *
	 * @param exportPath
	 *            导出文件存放路径
	 */
	public void setExportPath(String exportPath) {
		this.exportPath = exportPath;
	}
}
