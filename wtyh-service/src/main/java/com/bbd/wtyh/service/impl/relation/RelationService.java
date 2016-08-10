package com.bbd.wtyh.service.impl.relation;

import com.bbd.wtyh.util.relation.ListUtils;
import com.bbd.wtyh.web.relationVO.LineVO;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RelationService {
	
	@Autowired
	private RegisterUniversalFilterChainImp regImp;
	private String [] relationTitle = { "序号", "投资方", "被投资方", "职务", "投资方关联维度", "被投资方关联维度" };
	
//	/**
//	 * 创建Workbook
//	 *
//	 * @param companyName
//	 * @param dataVersion
//	 * @return
//	 * @throws Exception
//	 */
//	public Workbook createRelationExcel(String companyName, String dataVersion) throws Exception {
//		XSSFWorkbook wb = new XSSFWorkbook();
//		try {
//			CellStyle cs = this.setHeadStyle(wb);
//			XSSFSheet sheet = wb.createSheet(companyName);
//			/* 设置列宽 */
//			sheet.setColumnWidth(0, 2000);
//			sheet.setColumnWidth(1, 8000);
//			sheet.setColumnWidth(2, 8000);
//			sheet.setColumnWidth(3, 8000);
//			sheet.setColumnWidth(4, 5000);
//			sheet.setColumnWidth(5, 5000);
//			this.writeTableHeader(sheet, cs);
//			this.writeRelationExcel(wb, sheet, companyName, dataVersion);
//		    return wb;
//		} catch (Exception e) {
//			throw new Exception(e.getMessage(), e);
//		}
//	}
	
	/**
	 * 设置Excel表头样式
	 * 
	 * @param wb
	 * @return
	 */
	private CellStyle setHeadStyle(Workbook wb) {
		CellStyle cs = wb.createCellStyle();
		cs.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		cs.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		cs.setFillForegroundColor(HSSFColor.GOLD.index);
		cs.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		cs.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		cs.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		cs.setBorderRight(XSSFCellStyle.BORDER_THIN);
		cs.setBorderTop(XSSFCellStyle.BORDER_THIN);
		Font font = wb.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		cs.setFont(font);
		cs.setWrapText(true);
		return cs;
	}
	
	/**
	 * 设置Excel表头内容
	 * 
	 * @param sheet
	 * @param cs
	 */
	private void writeTableHeader(XSSFSheet sheet, CellStyle cs) {
		/* 制作表头 */
		XSSFRow row = sheet.createRow(0);
		for (int i = 0; i < relationTitle.length; i++) {
			XSSFCell cell = row.createCell(i);
			cell.setCellValue(relationTitle[i]);
			cell.setCellStyle(cs);
		}
	}
	
//	/**
//	 * 填充Excel内容
//	 * @throws Exception
//	 */
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	private void writeRelationExcel(Workbook wb, XSSFSheet sheet, String companyName, String dataVersion) throws Exception {
//		Map<String, List> map = regImp.queryRelation(companyName, dataVersion);
//		List<LineVO> list = map.get("lineList");
//		if (ListUtils.isNotEmpty(list)) {
//			CellStyle cs = wb.createCellStyle();
//			cs.setAlignment(CellStyle.ALIGN_RIGHT);
//			for (int i = 0; i < list.size(); i++) {
//				LineVO vo = list.get(i);
//				XSSFRow row = sheet.createRow(i + 1);
//				for (int j = 0; j < relationTitle.length; j++) {
//					XSSFCell cell = row.createCell(j);
//					switch (j) {
//					case 0:
//						cell.setCellValue(i + 1);
//						break;
//					case 1:
//						cell.setCellValue(vo.getOrig());
//						break;
//					case 2:
//						cell.setCellValue(vo.getTarget());
//						break;
//					case 3:
//						cell.setCellValue(vo.getType());
//						break;
//					case 4:
//						cell.setCellValue(vo.getOrigLevel());
//						break;
//					case 5:
//						cell.setCellValue(vo.getTarLevel());
//						break;
//					default:
//						break;
//					}
//				}
//			}
//		}
//	}

}
