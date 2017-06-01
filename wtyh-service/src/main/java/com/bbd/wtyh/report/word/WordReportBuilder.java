package com.bbd.wtyh.report.word;

import com.bbd.wtyh.util.DocxUtils;
import org.docx4j.XmlUtils;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.Part;
import org.docx4j.openpackaging.parts.PartName;
import org.docx4j.openpackaging.parts.WordprocessingML.HeaderPart;
import org.docx4j.vml.CTTextPath;
import org.docx4j.wml.CTOdso;
import org.docx4j.wml.P;
import org.docx4j.wml.Tbl;

import javax.xml.bind.JAXBContext;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/** word 版报告生成类
 * Created by cgj on 2017/5/26.
 */
public class WordReportBuilder {
    /** 报告类型枚举类*/
    public enum ReportType {
        OFFLINE_FINANCING("线下理财"),
        NETWORK_LENDING("网络借贷"),
        OTHER("其它");

        public String getName() {
            return name;
        }

        /** 枚举名称 */
        private String name;

        ReportType(String name) {
            this.name = name;
        }
    }

    /** 报告类型*/
    private ReportType reportType; // =ReportType.OTHER; //

    /** 企业名称*/
    private String companyName ="（尚未设置企业基本信息）";

    /** 企业背景*/
    private List companyBackground;

    /** 企业风险级别*/
    private String companyRiskResult;

    /** 企业类型：网络借贷、线下理财、小额贷款。。。*/
    private String companyType;

    /** 企业状态：存续或注销*/
    private String companyStatus;

    /** word 包对象*/
    private WordprocessingMLPackage wmp;

    /** 文档部件集合*/
    private Collection<?> partsColl;

    /**
     * 取主文档的段落为单位且以文档书写顺序排列的列表，会包含表格对象，此列表删除元素后会同步修改待保存的文档
     */
    private List<?> paragraphList;

    /**
     * 创建生成报告的对象
     * @param reportTemplateFileName 带路径的模板文件名
     * @param reportType 报告类型
     * @throws Docx4JException
     * @throws FileNotFoundException
     */
    public WordReportBuilder( String reportTemplateFileName, ReportType reportType )
            throws Docx4JException, FileNotFoundException {
        wmp =WordprocessingMLPackage.load(new File(reportTemplateFileName));
        /** 文档部件Map*/
        HashMap<PartName, Part> partsMap  = wmp.getParts().getParts();
        partsColl = partsMap.values();
        paragraphList = wmp.getMainDocumentPart().getContent();
        this.reportType =reportType;
    }

    public static void main(String []argc) { //文档生成类使用示例
        String rootPath ="/docx/template/shanghai-company-anti-fraud-template.docx";
        String localPath ="D:\\bbdPrjIj\\wtyh-dv\\wtyh-web\\src\\main\\resources\\docx\\";
        String templateFile1 = localPath +"template\\shanghai-company-anti-fraud-template.docx";
        String targetPath = localPath +"target\\";
        String companyName ="上海复旦复华药业有限公司";
        try {
            WordReportBuilder wrb = new WordReportBuilder(templateFile1, ReportType.NETWORK_LENDING);
            wrb.setCompanyBaseInfo(companyName, new ArrayList<String>(){{add("民营企业");add("非上市公司");}},
            "一般关注", ReportType.OTHER.getName(), "存续" );
            wrb.setWaterMark("chenfx");
            wrb.copySignedSegment("平台信息模板", "插入平台信息", true );
            wrb.copySignedSegment("平台信息模板", "插入平台信息", true );
            wrb.copySignedSegment("平台信息模板", "插入平台信息", true );
            wrb.exportReport(targetPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置企业基本信息
     * @param companyName 企业名称
     * @param companyBackground 企业背景 （字符串列表）
     * @param companyRiskResult 企业风险级别（中文名称）
     * @param companyType 企业类型（中文名称）
     * @param companyStatus 企业状态（中文名称）
     */
    public void setCompanyBaseInfo( String companyName,
                                    List companyBackground, //mock： new ArrayList<String>(){{add("民营企业");add("非上市公司");}}
                                    String companyRiskResult,
                                    String companyType,
                                    String companyStatus ) {
        this.companyName =companyName;
        this.companyBackground =companyBackground;
        this.companyRiskResult =companyRiskResult;
        this.companyType =companyType;
        this.companyStatus =companyStatus;
    }

    /**
     * 设置水印
     * @param waterMark 水印字符串
     * @return 设置成功：true
     */
    public boolean setWaterMark (String waterMark) {
        boolean returnVal =false;
        for (Object obj : partsColl) {
            if( obj instanceof HeaderPart) {
                List<Object> lo = ((HeaderPart) obj).getContent();
                List<Object> lo2 =DocxUtils.getAllElementFromObject(lo, CTTextPath.class);
                if( lo2.size() >0 ) {
                    CTTextPath ctt =(CTTextPath) (lo2.get(0));
                    if( null !=ctt.getString() && ctt.getString().equals("watermark example") ) {
                        ctt.setString(waterMark);
                        returnVal =true;
                    }
                }
            }
        }
        return returnVal;
    }

    /** 删除文档中被标记的片段*/
    private void removeSignedSegment(String sign ) {
        List removeColl =new LinkedList();
        String startSign ="##@seg_start-" +sign;
        String endSign ="##@seg_end-" +sign;
        int step =0;
        for (  Object obj : paragraphList  ) {
            if( obj instanceof P ) {
                String tStr =obj.toString();
                if( null != tStr ) {
                    if (tStr.equals(startSign)) {
                        step = 1;
                        continue;
                    } else if (tStr.equals(endSign)) {
                        step = 2;
                        break;
                    }
                }
            }
            if( 1 ==step ) {
                removeColl.add(obj);
            }
        }
        if( 2 ==step ) {
            paragraphList.removeAll(removeColl);
        }
    }

    /** 复制文档中被标记的部分到指定位置*/
    private void copySignedSegment( String sign, String anchor, boolean front  ) {
        List copyColl =new LinkedList();
        String startSign ="##@seg_start-" +sign;
        String endSign ="##@seg_end-" +sign;
        String ahSign ="##@ah-" +anchor;
        int insIndex =-1;
        int step =0;
        for (  int listIndex =0; listIndex <paragraphList.size(); listIndex++ ) {
            Object obj = paragraphList.get(listIndex);
            if( obj instanceof P ) {
                String tStr =obj.toString();
                if( null != tStr ) {
                    if (tStr.equals(startSign)) {
                        step = 1;
                        continue;
                    } else if (tStr.equals(endSign)) {
                        step = 2;
                        if( insIndex  >=0 ) {
                            break;
                        }
                    } else if (tStr.equals(ahSign)) {
                        insIndex =listIndex;
                        if( step  >=2 ) {
                            break;
                        }
                    }
                }
            }
            if( 1 ==step ) {
                copyColl.add( XmlUtils.deepCopy(obj) );//( ) new Tbl()
            }
        }
        if( 2 ==step && insIndex >=0 ) {
            if(!front) {
                insIndex++;
            }
            paragraphList.addAll(insIndex, copyColl);
        }
    }

    /** 从段落列表搜索带特定标记的段落的序号*/
    private int indexSignInParagraphList(String anchor) {
        int insIndex =-1;
        String ahSign ="##@ah-" +anchor;
        for (  int listIndex =0; listIndex <paragraphList.size(); listIndex++ ) {
            Object obj = paragraphList.get(listIndex);
            if (obj instanceof P) {
                String tStr = obj.toString();
                if (null != tStr && tStr.equals(ahSign)) {
                    insIndex = listIndex;
                    break;
                }
            }
        }
        return insIndex;
    }

    /**
     * 报告文件导出
     * @param targetPath
     * @return 返回报告文件的存放路径
     * @throws IOException
     * @throws Docx4JException
     */
    public String exportReport(String targetPath) throws IOException, Docx4JException {

        /** 生成企业标签(例如："私企、存续、重点关注、网络借贷")*/
        Writer sw = new StringWriter();
        for( Object ob : companyBackground  ) {
            if( ob instanceof String ) {
                sw.write( (String)ob +"、" );
            }
        }
        sw.write( companyStatus +"、" );
        sw.write( companyRiskResult +"、" );
        sw.write( companyType );

        //替换一些零散的标签
        Map mp =new HashMap<String, String>() {{
            put("$$标题（企业名称及属性标签）", companyName +"（" +sw.toString() +"…）");
            put("$$报告生成日期", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));
            put("$$风险等级：", "风险等级：" +companyRiskResult );
        }};
        DocxUtils.replacePlaceholder( paragraphList, mp );

        //按文档类型删除无关的部分
        if( ReportType.OTHER == reportType ) { //文档属于其它类型
            removeSignedSegment("非其它报告");
        } else {
            if( ReportType.OFFLINE_FINANCING == reportType ) { //文档属于线下理财
                removeSignedSegment("仅网络借贷");
            } else if (ReportType.NETWORK_LENDING == reportType) { //文档属于网络借贷
                removeSignedSegment("仅线下理财");
            }
        }
        removeSignedSegment( "平台信息模板" );

        //删除所有的注释段落
        List removeColl =new LinkedList(); //待删除的对象集合
        for ( Object obj : paragraphList ) { //查找所有注释段落
            if( obj instanceof P && obj.toString().startsWith("##") ) {
                removeColl.add(obj);
            }
        }
        paragraphList.removeAll(removeColl);

        //生成文件名和存盘
        String targetFilePathAndName =targetPath +companyName +"-" +reportType.getName() +".docx";
        File f = new File(targetFilePathAndName);
        wmp.save(f);
        return targetFilePathAndName;
    }

}
