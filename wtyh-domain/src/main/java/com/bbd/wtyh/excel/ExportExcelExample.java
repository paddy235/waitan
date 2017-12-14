package com.bbd.wtyh.excel;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bbd.wtyh.domain.vo.UseHotPage;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description:Excel导出工具类
 * author:liaohao
 * date:2017/2/20 0020 10:11.
 */
public class ExportExcelExample {

    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    /**
     * @param sheetTitle excel-sheet Name
     * @param jsonStr    数据字段名称
     * @param dataset    数据集合
     * @param pattern    转换日期类型的规则 (默认 "yyyy-MM-dd")
     * @return
     */
    public static HSSFWorkbook exportExcel(HSSFWorkbook workbook,HSSFSheet sheet, String jsonStr, List dataset,
                                           String pattern,String headTitle,boolean flag,Integer [] res) {
        try {
            if (null == pattern) {
                pattern = "yyy-MM-dd";
            }
            // title集合
            List<String> titleStringList = new ArrayList<String>();
            // 列表字段集合
            List<String> fieldStringList = new ArrayList<String>();
            // 数据字段初始化
            init(jsonStr, titleStringList, fieldStringList);
            // 声明一个工作薄
//            HSSFWorkbook workbook = new HSSFWorkbook();
            // 生成一个表格
//            HSSFSheet sheet = workbook.createSheet(sheetTitle);
            // 样式声明
            HSSFCellStyle headStyle = workbook.createCellStyle();
            HSSFCellStyle headStyleTitle = workbook.createCellStyle();
            HSSFCellStyle bodyStyle = workbook.createCellStyle();
            // 初始化各种样式
            initStyle(workbook, sheet, headStyle, headStyleTitle, bodyStyle);
            // 定义注释的大小和位置,详见文档 设置注释内容和表格标题行
            // setComment(patriarch);
            // 产生表格标题行
            HSSFRow rowStart = sheet.createRow(0);
            for(int i=0;i<titleStringList.size();i++){
                HSSFCell cell = rowStart.createCell(i);
                cell.setCellStyle(headStyle);
                HSSFRichTextString text = new HSSFRichTextString("");
                cell.setCellValue(text);
            }
            HSSFCell cellS = rowStart.createCell(0);
            cellS.setCellStyle(headStyle);
            HSSFRichTextString textS = new HSSFRichTextString(headTitle);
            cellS.setCellValue(textS);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, titleStringList.size()-1));
            HSSFRow row = sheet.createRow(1);
            int tilteNum = 0;
            for (String titleFor : titleStringList) {
//                HSSFCell cell = row.createCell(tilteNum);
                HSSFCell cell = row.createCell(tilteNum);
                cell.setCellStyle(headStyle);
                HSSFRichTextString text = new HSSFRichTextString(titleFor);
                cell.setCellValue(text);
                tilteNum++;
            }
            // 产生数据开始--遍历集合数据，产生数据行
            setExcelValue(pattern, fieldStringList, workbook, sheet, bodyStyle, dataset);

            //做合计
            if(flag){
                HSSFRow rowEnd = sheet.createRow(dataset.size()+2);
                HSSFCell cellEnd1 = rowEnd.createCell(0);
                cellEnd1.setCellStyle(headStyle);
                HSSFRichTextString textE1 = new HSSFRichTextString("");
                cellEnd1.setCellValue(textE1);
                HSSFCell cellEnd = rowEnd.createCell(1);
                cellEnd.setCellStyle(headStyle);
                HSSFRichTextString textE = new HSSFRichTextString("合计");
                cellEnd.setCellValue(textE);
                for(int i=0;i<res.length;i++){
                    HSSFCell cell = rowEnd.createCell(i+2);
                    cell.setCellStyle(bodyStyle);
                    HSSFRichTextString text = new HSSFRichTextString(res[i]+"");
                    cell.setCellValue(text);
                }

            }
            // 返回excel文件 byte[]


            return workbook;
        } catch (Exception e) {
        }
        return null;

    }

    // 处理值到Excel中
    private static void setExcelValue(String pattern, List<String> fieldStringList,
                                      HSSFWorkbook workbook, HSSFSheet sheet,
                                      HSSFCellStyle headStyleTitle, Collection dataset) {
        Iterator<Object> it = dataset.iterator();
        HSSFRow row = null;
        int index = 1;
        HSSFFont font3 = workbook.createFont();
        // 内容颜色
        font3.setColor(HSSFColor.BLACK.index);
        font3.setFontName("微软雅黑");

        while (it.hasNext()) {
            index++;
            // 依次产生行
            row = sheet.createRow(index);
            // 获得改行所属对象
            Object t = it.next();
            // 根据配置json数组对象内容属性顺序--通过依次获取值-然后赋值
            int i = -1;
            for (String fieldFor : fieldStringList) {
                // 依次遍历一行中的单元格
                i++;
                // 获得一个单元格
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(headStyleTitle);
                String fieldName = fieldFor;
                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    // 利用反射动态获取值
                    String textValue = getValue(pattern, t, getMethodName);
                    // 放值到单元格中
                    setValue(workbook, cell, textValue == null||textValue.equals("") ? "0":textValue, font3);

                } catch (Exception e){
                    throw  new RuntimeException(e);
                }
            }

        }
    }

    // 将值放入到单元格中
    private static void setValue(HSSFWorkbook workbook, HSSFCell cell, String textValue, HSSFFont font3) {
        if (null != textValue) {
            Pattern p = Pattern.compile("^//d+(//.//d+)?$");
            Matcher matcher = p.matcher(textValue);
            if (matcher.matches()) {
                try {
                    // 保留两位小数
                    cell.setCellValue(String.valueOf(decimalFormat.parse(textValue + "")));
                } catch (ParseException e) {
                }
            } else {
                HSSFRichTextString richString = new HSSFRichTextString(textValue);
                richString.applyFont(font3);
                cell.setCellValue(richString);
            }
        }
    }

    // 获取每个单元格需要放入的值-并且进行处理
    private static String getValue(String pattern, Object t,
                                   String getMethodName) throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException {
        Class tCls = t.getClass();
        Method getMethod = tCls.getMethod(getMethodName, new Class[]{});
        Object value = getMethod.invoke(t, new Object[]{});
        //判断值的类型后进行强制类型转换
        String textValue = null;
        if (value instanceof Boolean) {
            Boolean bValue = (Boolean) value;
            textValue = bValue ? "是" : "否";
        } else if (value instanceof Date) {
            Date date = (Date) value;
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            textValue = sdf.format(date);
        } else if (value instanceof byte[]) {
            // 有图片时，设置行高为60px;
            // setPicture(workbook, sheet, patriarch, row, index, i, (byte[]) value);
        } else {
            if (null == value) {
                textValue = "";
            } else {
                //其它数据类型都当作字符串简单处理
                textValue = value.toString();
            }
        }
        return textValue;
    }

    // 数据字段初始化
    private static void init(String jsonStr, List<String> titleStringList,
                             List<String> fieldStringList) {
        JSONArray jsonArray = JSONArray.parseArray(jsonStr);
        Iterator iterator = jsonArray.iterator();
        // 遍历出初始化数据
        while (iterator.hasNext()) {
            JSONObject object = (JSONObject) iterator.next();
            // 取出列头
            titleStringList.add(object.get("value") + "");
            // 取出字段
            fieldStringList.add(object.get("key") + "");
        }
    }

    // 样式初始化
    private static void initStyle(HSSFWorkbook workbook, HSSFSheet sheet, HSSFCellStyle headStyle,
                                  HSSFCellStyle headStyleTitle, HSSFCellStyle bodyStyle) {
        sheet.setDefaultColumnWidth(20);
        // 表头样式设置
        headStyle.setFillBackgroundColor((short) 4);
        headStyle.setBorderBottom((short) 1);
        headStyle.setBorderLeft((short) 1);
        headStyle.setBorderRight((short) 1);
        headStyle.setBorderTop((short) 1);
        headStyle.setWrapText(true);
        headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        headStyle.setLocked(false);
        // 字体设置
        HSSFFont font = workbook.createFont();
        font.setColor((short) 8);
        font.setFontHeightInPoints((short) 10);
        font.setFontName("宋体");
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        headStyle.setFont(font);

        // 内容样式设置
        bodyStyle.setLocked(false);
        bodyStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        bodyStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        bodyStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        bodyStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        bodyStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        bodyStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        font2.setFontName("宋体");
        // 把字体应用到当前的样式
        bodyStyle.setFont(font2);

    }

    // 定义注释的大小和位置,详见文档 设置注释内容和表格标题行
    private static void setComment(HSSFPatriarch patriarch) {
        HSSFComment comment = patriarch
                .createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor("system");
    }

    // 处理图片
    private static void setPicture(HSSFWorkbook workbook, HSSFSheet sheet, HSSFPatriarch patriarch,
                                   HSSFRow row, int index, short i, byte[] value) {
        row.setHeightInPoints(60);
        // 设置图片所在列宽度为80px,注意这里单位的一个换算
        sheet.setColumnWidth(i, (short) (35.7 * 80));
        // sheet.autoSizeColumn(i);
        byte[] bsValue = value;
        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 255, (short) 6, index, (short) 6,
                index);
        anchor.setAnchorType(2);
        patriarch.createPicture(anchor,
                workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
    }

    public static HSSFWorkbook extraExcel(HSSFWorkbook workbook,HSSFSheet sheet, List<UseHotPage> hotPageList,
                                          String headTitle) {

        HSSFCellStyle headStyle = workbook.createCellStyle();
        HSSFCellStyle headStyleTitle = workbook.createCellStyle();
        HSSFCellStyle bodyStyle = workbook.createCellStyle();
        // 初始化各种样式
        initStyle(workbook, sheet, headStyle, headStyleTitle, bodyStyle);
        //创建单元格
        HSSFRow row = sheet.createRow(0);
        HSSFCell c0 = row.createCell(0);
        c0.setCellStyle(headStyle);
        c0.setCellValue(new HSSFRichTextString(headTitle));
        HSSFCell c1 = row.createCell(1);
        c1.setCellStyle(headStyle);
        c1.setCellValue(new HSSFRichTextString(""));
        HSSFCell c2 = row.createCell(2);
        c2.setCellStyle(headStyle);
        c2.setCellValue(new HSSFRichTextString(""));
        HSSFCell c3 = row.createCell(3);
        c3.setCellStyle(headStyle);
        c3.setCellValue(new HSSFRichTextString(""));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));

        HSSFRow row1 = sheet.createRow(1);
        HSSFCell c10 = row1.createCell(0);
        c10.setCellStyle(headStyle);
        c10.setCellValue(new HSSFRichTextString("区域"));
        HSSFCell c11 = row1.createCell(1);
        c11.setCellStyle(headStyle);
        c11.setCellValue(new HSSFRichTextString("页面"));
        HSSFCell c12 = row1.createCell(2);
        c12.setCellStyle(headStyle);
        c12.setCellValue(new HSSFRichTextString("次数"));
        HSSFCell c13 = row1.createCell(3);
        c13.setCellStyle(headStyle);
        c13.setCellValue(new HSSFRichTextString("合计"));

        String [] ss = new String[]{"name","request_desc","countCode","total"};


        Map<String,Integer> nameTotal = new HashMap<>();
        Map<String,Integer> numTotal = new HashMap<>();


        List<String> nameList = new ArrayList<>();
        for(int j=0;j<hotPageList.size();j++){
            if(!nameList.contains(hotPageList.get(j).getName())){
                nameList.add(hotPageList.get(j).getName());
            }else {
                continue;
            }
        }
        System.out.println(nameList);

        for(int j=0;j<hotPageList.size();j++){
            if(nameTotal.containsKey(hotPageList.get(j).getName())){
                nameTotal.put(hotPageList.get(j).getName(),nameTotal.get(hotPageList.get(j).getName())+1);
                numTotal.put(hotPageList.get(j).getName(),numTotal.get(hotPageList.get(j).getName())+hotPageList.get(j).getCountCode());
            }else{
                nameTotal.put(hotPageList.get(j).getName(),1);
                numTotal.put(hotPageList.get(j).getName(),hotPageList.get(j).getCountCode());
            }
        }
        System.out.println("名单统计"+nameTotal);
        System.out.println("数量统计"+numTotal);

        HSSFRow rowStart = null;
        int index =1;
        //遍历基础数据
        for(int j=0;j<hotPageList.size();j++){
            index++;
            // 依次产生行
            rowStart = sheet.createRow(index);
            int i = -1;
            for(String s:ss){
                i++;
                if(s.equals("name")){
                    HSSFCell cell = rowStart.createCell(i);
                    cell.setCellStyle(bodyStyle);
                    cell.setCellValue(new HSSFRichTextString(hotPageList.get(j).getName()));

                }
                if(s.equals("request_desc")){
                    HSSFCell cell = rowStart.createCell(i);
                    cell.setCellStyle(bodyStyle);
                    cell.setCellValue(new HSSFRichTextString(hotPageList.get(j).getRequest_desc()));
                }
                if(s.equals("countCode")){
                    HSSFCell cell = rowStart.createCell(i);
                    cell.setCellStyle(bodyStyle);
                    cell.setCellValue(new HSSFRichTextString(hotPageList.get(j).getCountCode()+""));
                }
                if(s.equals("countCode")){
                    HSSFCell cell = rowStart.createCell(i);
                    cell.setCellStyle(bodyStyle);
                    cell.setCellValue(new HSSFRichTextString(hotPageList.get(j).getCountCode()+""));
                }
                if(s.equals("total")){
                    HSSFCell cell = rowStart.createCell(i);
                    cell.setCellStyle(bodyStyle);
                    cell.setCellValue(new HSSFRichTextString(numTotal.get(hotPageList.get(j).getName())+""));
                }
            }
        }


        //合并单元格
        int start = 2;
        int end = 0;
        for(int i=0;i<nameList.size();i++){
            Integer value = nameTotal.get(nameList.get(i));
            end = start +value-1;
            sheet.addMergedRegion(new CellRangeAddress(start, end, 0, 0));
            sheet.addMergedRegion(new CellRangeAddress(start, end, 3, 3));
            start = end+1;
        }
//        Iterator it = nameTotal.entrySet().iterator();
//        int i = 0;
//        int start = 2;
//        int end = 0;
//        while (it.hasNext()){
//            Map.Entry entry = (Map.Entry) it.next();
//            String key =(String) entry.getKey();
//            Integer value = (Integer)entry.getValue();
//            System.out.println("k="+key+";"+"v="+value);
//            end = start +value-1;
//            sheet.addMergedRegion(new CellRangeAddress(start, end, 0, 0));
//            sheet.addMergedRegion(new CellRangeAddress(start, end, 3, 3));
//            start = end+1;
//            i++;
//        }

        int total = 0;
        Iterator it2 = numTotal.entrySet().iterator();
        while (it2.hasNext()){
            Map.Entry entry = (Map.Entry) it2.next();
            String key =(String) entry.getKey();
            Integer value = (Integer)entry.getValue();
            total += value;
        }
        System.out.println(total);
        HSSFRow rowEnd = sheet.createRow(2+hotPageList.size());
        HSSFCell celEnd = rowEnd.createCell(0);
        celEnd.setCellStyle(headStyle);
        celEnd.setCellValue(new HSSFRichTextString("合计"));
        HSSFCell celEnd1 = rowEnd.createCell(1);
        celEnd1.setCellStyle(headStyle);
        celEnd1.setCellValue(new HSSFRichTextString(""));
        HSSFCell celEnd2 = rowEnd.createCell(2);
        celEnd2.setCellStyle(headStyle);
        celEnd2.setCellValue(new HSSFRichTextString(total+""));
        HSSFCell celEnd3 = rowEnd.createCell(3);
        celEnd3.setCellStyle(headStyle);
        celEnd3.setCellValue(new HSSFRichTextString(""));
        sheet.addMergedRegion(new CellRangeAddress(2+hotPageList.size(), 2+hotPageList.size(), 0, 1));
        sheet.addMergedRegion(new CellRangeAddress(2+hotPageList.size(), 2+hotPageList.size(), 2, 3));

        return workbook;
    }

}
