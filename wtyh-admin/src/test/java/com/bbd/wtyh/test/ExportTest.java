package com.bbd.wtyh.test;

import com.bbd.wtyh.domain.ResourceDo;
import com.bbd.wtyh.excel.ExportExcel;
import com.bbd.wtyh.excel.Sheet;
import com.bbd.wtyh.service.RoleResourceService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFCellUtil;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-04-17 16:24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class ExportTest {

	@Autowired
	private RoleResourceService resourceService;

	@Test
	public void excelTest1() throws Exception {
		// 获取数据集
		List<ResourceDo> list = this.resourceService.selectAll(ResourceDo.class, "");

		ExportExcel ee = new ExportExcel("权限表");
		Sheet sheet = ee.createSheet(list);

		HSSFSheet hssfSheet = sheet.getHSSFSheet();

		String title = "权限表";
		// 合并单元格第一行
		CellRangeAddress cra = new CellRangeAddress(0, 0, 0, sheet.getDataMapKeys().length - 1);
		hssfSheet.addMergedRegion(cra);
		HSSFRow titleRow = hssfSheet.createRow(0);
		titleRow.setHeight((short) 400);
		for (int j = cra.getFirstColumn(); j <= cra.getLastColumn(); j++) {
			HSSFCell singleCell = HSSFCellUtil.getCell(titleRow, j);
			singleCell.setCellStyle(sheet.getContentStyle());
		}
		HSSFCell titleCell = HSSFCellUtil.getCell(titleRow, 0);

		HSSFFont font = ee.getNewHSSFFont();
		font.setFontName("宋体");
		font.setFontHeight((short) 300);
		font.setColor(HSSFFont.COLOR_RED);

		HSSFCellStyle hcs = ee.getNewHSSFCellStyle();
		hcs.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		hcs.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		hcs.setBorderRight(HSSFCellStyle.BORDER_THIN);
		hcs.setBorderTop(HSSFCellStyle.BORDER_THIN);
		hcs.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		hcs.setFont(font);

		titleCell.setCellStyle(hcs);
		titleCell.setCellValue(title);

		// 合并单元格第二行
		CellRangeAddress cra1 = new CellRangeAddress(1, 1, 0, sheet.getDataMapKeys().length - 1);
		hssfSheet.addMergedRegion(cra1);
		HSSFRow titleRow1 = hssfSheet.createRow(1);
		titleRow1.setHeight((short) 400);
		for (int j = cra1.getFirstColumn(); j <= cra1.getLastColumn(); j++) {
			HSSFCell singleCell = HSSFCellUtil.getCell(titleRow1, j);
			singleCell.setCellStyle(sheet.getContentStyle());
		}
		HSSFCell titleCell1 = HSSFCellUtil.getCell(titleRow1, 0);
		titleCell1.setCellValue("author:Mr.Yao");

		String file = ee.exportExcel();
		System.out.println(file);
	}

	@Test
	public void excelTest2() throws Exception {
		int i = 25;
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("name", "张三");
		dataMap.put("age", i);
		dataMap.put("date", new Date());

		// 数据集
		List<Map<String, Object>> dataList = new ArrayList<>();
		dataList.add(dataMap);

		// 列名称，注意和dataMapLeys的顺序对应
		String[] columnName = { "姓名", "年龄", "时间" };
		// 数据集的KEY，注意和columnName的顺序对应
		String[] dataMapLeys = { "name", "age", "date" };

		ExportExcel ee = new ExportExcel("Test");
		Sheet sheet = ee.createSheet("Test", columnName, dataMapLeys, dataList);

		HSSFSheet hssfSheet = sheet.getHSSFSheet();
		HSSFRow row = hssfSheet.createRow(0);
		HSSFCell cell = HSSFCellUtil.getCell(row, 0);
		cell.setCellValue("test");

		ee.exportExcel();

	}
}
