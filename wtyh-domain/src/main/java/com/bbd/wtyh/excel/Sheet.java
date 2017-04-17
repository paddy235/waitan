package com.bbd.wtyh.excel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.util.List;
import java.util.Map;

/**
 * Sheet
 *
 * @author Created by LiYao on 2017-04-13 11:33.
 */
public class Sheet {

	/** 标签页名称 */
	private String sheetName;

	/** 数据集 */
	private List<Map<String, Object>> dateSet;

	/** 每列的宽度 */
	private int[] columnWidth;

	/** 数据集中Map的KEY */
	private String[] dataMapKeys;

	/** 列名。注意和dataMapKeys的顺序一致 */
	private String[] columnName;

	/** 表头单元格样式。针对当前sheet，如果有大部分或全部统一，设置com.bbd.wtyh.excel.ExportExcel.headerStyle */
	private HSSFCellStyle headerStyle;

	/**
	 * 正文单元格样式。针对当前sheet，如果有大部分或全部统一，设置com.bbd.wtyh.excel.ExportExcel.contentStyle
	 */
	private HSSFCellStyle contentStyle;

	/** 工作区 */
	private HSSFSheet HSSFSheet;

	/** 行高 */
	private short rowHeight = 400;

	private Sheet() {
	}

	Sheet(String sheetName, String[] columnName, String[] dataMapKeys, List<Map<String, Object>> dateSet) {
		this.sheetName = sheetName;
		this.dateSet = dateSet;
		this.dataMapKeys = dataMapKeys;
		this.columnName = columnName;
	}

	/**
	 * 获取 标签页名称
	 *
	 * @return sheetName 标签页名称
	 */
	public String getSheetName() {
		return this.sheetName;
	}

	/**
	 * 获取 数据集
	 *
	 * @return dateSet 数据集
	 */
	public List<Map<String, Object>> getDateSet() {
		return this.dateSet;
	}

	/**
	 * 添加数据到数据集
	 *
	 * @param data
	 *            数据集
	 */
	public void addDateSet(Map<String, Object> data) {
		this.dateSet.add(data);
	}

	/**
	 * 批量添加数据到数据集
	 *
	 * @param dateSet
	 *            数据集
	 */
	public void addAllDateSet(List<Map<String, Object>> dateSet) {
		this.dateSet.addAll(dateSet);
	}

	/**
	 * 获取 数据集中Map的KEY
	 *
	 * @return dataMapKeys 数据集中Map的KEY
	 */
	public String[] getDataMapKeys() {
		return this.dataMapKeys;
	}

	/**
	 * 设置 数据集中Map的KEY
	 *
	 * @param dataMapKeys
	 *            数据集中Map的KEY
	 */
	public void setDataMapKeys(String[] dataMapKeys) {
		this.dataMapKeys = dataMapKeys;
	}

	/**
	 * 获取 列名。注意和dataMapKeys的顺序一致
	 *
	 * @return columnName 列名。注意和dataMapKeys的顺序一致
	 */
	public String[] getColumnName() {
		return this.columnName;
	}

	/**
	 * 设置 列名。注意和dataMapKeys的顺序一致
	 *
	 * @param columnName
	 *            列名。注意和dataMapKeys的顺序一致
	 */
	public void setColumnName(String[] columnName) {
		this.columnName = columnName;
	}

	/**
	 * 获取 每列的宽度
	 *
	 * @return columnWidth 每列的宽度
	 */
	public int[] getColumnWidth() {
		return this.columnWidth;
	}

	/**
	 * 设置 每列的宽度
	 *
	 * @param columnWidth
	 *            每列的宽度
	 */
	public void setColumnWidth(int[] columnWidth) {
		this.columnWidth = columnWidth;
	}

	/**
	 * 获取
	 * 表头单元格样式。针对当前sheet，如果有大部分或全部统一，设置com.bbd.wtyh.excel.ExportExcel.headerStyle
	 *
	 * @return headerStyle
	 *         表头单元格样式。针对当前sheet，如果有大部分或全部统一，设置com.bbd.wtyh.excel.ExportExcel.headerStyle
	 */
	public HSSFCellStyle getHeaderStyle() {
		return this.headerStyle;
	}

	/**
	 * 设置
	 * 表头单元格样式。针对当前sheet，如果有大部分或全部统一，设置com.bbd.wtyh.excel.ExportExcel.headerStyle
	 *
	 * @param headerStyle
	 *            表头单元格样式。针对当前sheet，如果有大部分或全部统一，设置com.bbd.wtyh.excel.ExportExcel.headerStyle
	 */
	public void setHeaderStyle(HSSFCellStyle headerStyle) {
		this.headerStyle = headerStyle;
	}

	/**
	 * 获取
	 * 正文单元格样式。针对当前sheet，如果有大部分或全部统一，设置com.bbd.wtyh.excel.ExportExcel.contentStyle
	 *
	 * @return contentStyle
	 *         正文单元格样式。针对当前sheet，如果有大部分或全部统一，设置com.bbd.wtyh.excel.ExportExcel.contentStyle
	 */
	public HSSFCellStyle getContentStyle() {
		return this.contentStyle;
	}

	/**
	 * 设置
	 * 正文单元格样式。针对当前sheet，如果有大部分或全部统一，设置com.bbd.wtyh.excel.ExportExcel.contentStyle
	 *
	 * @param contentStyle
	 *            正文单元格样式。针对当前sheet，如果有大部分或全部统一，设置com.bbd.wtyh.excel.ExportExcel.contentStyle
	 */
	public void setContentStyle(HSSFCellStyle contentStyle) {
		this.contentStyle = contentStyle;
	}

	/**
	 * 获取 工作区
	 *
	 * @return HSSFSheet 工作区
	 */
	public HSSFSheet getHSSFSheet() {
		return this.HSSFSheet;
	}

	/**
	 * 设置 工作区
	 *
	 * @param HSSFSheet
	 *            工作区
	 */
	void setHSSFSheet(HSSFSheet HSSFSheet) {
		this.HSSFSheet = HSSFSheet;
	}

	private ExportExcel exportExcel;

	public ExportExcel getExportExcel() {
		return this.exportExcel;
	}

	void setExportExcel(ExportExcel exportExcel) {
		this.exportExcel = exportExcel;
	}

	/**
	 * 获取 行高
	 *
	 * @return rowHeight 行高
	 */
	public short getRowHeight() {
		return this.rowHeight;
	}

	/**
	 * 设置 行高
	 *
	 * @param rowHeight
	 *            行高
	 */
	public void setRowHeight(short rowHeight) {
		this.rowHeight = rowHeight;
	}
}
