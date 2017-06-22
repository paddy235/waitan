package com.bbd.wtyh.report.word;

import com.bbd.wtyh.report.util.DocxUtils;
import org.apache.commons.lang.StringUtils;
import org.docx4j.dml.CTBlip;
import org.docx4j.dml.chart.*;
import org.docx4j.dml.picture.Pic;
import org.docx4j.dml.wordprocessingDrawing.Inline;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.SpreadsheetMLPackage;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.DrawingML.Chart;
import org.docx4j.openpackaging.parts.Part;
import org.docx4j.openpackaging.parts.PartName;
import org.docx4j.openpackaging.parts.Parts;
import org.docx4j.openpackaging.parts.SpreadsheetML.WorksheetPart;
import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPartAbstractImage;
import org.docx4j.openpackaging.parts.WordprocessingML.EmbeddedPackagePart;
import org.docx4j.openpackaging.parts.WordprocessingML.HeaderPart;
import org.docx4j.openpackaging.parts.relationships.RelationshipsPart;
import org.docx4j.relationships.Relationship;
import org.docx4j.vml.CTTextPath;
import org.docx4j.wml.*;
import org.xlsx4j.jaxb.Context;
import org.xlsx4j.sml.*;

import javax.xml.bind.JAXBElement;
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

/** word 版报告生成类
 * Created by cgj on 2017/5/26.
 */



public class WordReportBuilder {
    /**
     * 出错记录
     * @return
     */
    public StringBuffer getErrRecord() {
        return errRecord;
    }
    /** 生成文档时的出错记录*/
    private StringBuffer errRecord = new StringBuffer();
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
    private List companyBackground =new ArrayList<String>();

    /** 企业风险级别*/
    private String companyRiskResult ="";

    /** 企业类型：网络借贷、线下理财、小额贷款、其他。。。*/
    private String companyType ="";

    /** 企业状态：存续或注销*/
    private String companyStatus ="";

    /** word 包对象*/
    private WordprocessingMLPackage wmp;

    /** 正文部件对象*/
    private Parts mainParts;

    /**
     * 正文的段落为单位且以文档书写顺序排列的列表，会包含表格对象，此列表删除元素后会同步修改待保存的文档
     */
    private List<?> mainParagraphList;

    /**
     * 正文部件关系
     * mainRelationPart.removePart(PartName partName); 删除已存的部件
     * mainRelationPart.getPart(String id); //根据id获取已存的部件
     */
    private RelationshipsPart mainRelationPart;

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
        mainParts = wmp.getParts();
        //HashMap<PartName, Part> partsMap  = wmp.getParts().getParts(); //这个暂时没啥用
        mainParagraphList = wmp.getMainDocumentPart().getContent();
        mainRelationPart =wmp.getMainDocumentPart().getRelationshipsPart();
        //List<Relationship> mainRelationList = mainRelationPart.getRelationships().getRelationship(); //这个暂时没啥用
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
            wrb.setCompanySummary(companyName, new ArrayList<String>(){{add("民营企业");add("非上市公司");}},
            "一般关注", ReportType.OTHER.getName(), "存续" );
            wrb.setWaterMark("秀派儿fx");
            wrb.setStaticRiskTable(new HashMap<String,String>(){{
                put("静态风险指数","69.5");
                put("实际控制人风险", "27.8");
                put("公司扩张风险", "33.9");}});
            wrb.setDynamicRiskTable(new HashMap<String,String>(){{
                put("动态风险指数","2016.9-2017.5");
                put("动态风险指数^r1", "27.8");
                put("传销风险", "33.9");}});
            wrb.addPlatInfo( new HashMap<String,String>(){{
                        put("平台名称", "万金贷（测试平台名称）"); //这个是必传参数
                        put("平台等级","B");
                        put("平台状态", "优良");
                        put("运营能力", "37.9");}},
                    new HashMap<String,String>(){{
                        put("累计成交量","224.5");
                        put("贷款余额", "77");
                        put("平均利率", "15.5");}},
                    null,
                    null,
                    null,
                    null );
            wrb.addPlatInfo( new HashMap<String,String>(){{
                        put("平台名称", "亿金贷（测试）"); //这个是必传参数
                        put("平台等级","B");
                        put("平台状态", "优良");
                        put("运营能力", "57.9");}},
                    null,
                    new ArrayList<List<String>>() {{
                        List<String> lst =new ArrayList<String>(){{
                            add("2017.8.9");
                            add("1389.3");}};
                        add(lst);
                        add(lst);
                        add(lst);
                    }},
                    null,
                    null,
                    new ArrayList<List<String>>() {{
                        List<String> lst =new ArrayList<String>(){{
                            add("1");
                            add("aaaa");
                            add("aaaa");
                            add("2017.8.9"); }};
                        add(lst);
                        add(lst);
                        add(lst);
                    }} );

            //test 企业全息信息
            File fl =new File("D:\\bbdPrjIj\\wtyh-dv\\wtyh-web\\src\\main\\resources\\docx\\temporary\\关联0.png");
            InputStream is =new FileInputStream("D:\\bbdPrjIj\\wtyh-dv\\wtyh-web\\src\\main\\resources\\docx\\temporary\\关联0.png");

            byte[] byt = new byte[is.available()];
            is.read(byt, 0, is.available());
            wrb.setRelatedPartyMappingInfo(byt,
                    byt,
                    null,
                    byt,
                    null);

            //企业招聘信息
            wrb.setRecruitInfo(new LinkedList<List<String>>() {{
                add(new LinkedList<String>() {{
                    add("项目经理");
                    add("本科");
                    add("14999");
                    add("2");
                    add("2017-5");
                    add("上海");
                    add("");
                }});
                add(new LinkedList<String>() {{
                    add("CFO");
                    add("硕士");
                    add("33998");
                    add("1");
                    add("2017-5");
                    add("上海");
                    add("智联招聘");
                }});   }},
                new HashMap<String,String>(){{
                    put("电力|电子信息", "0.25");
                    put("精细化工|试剂|助剂","0.55");
                    put("制药", "0.2");
                    put("IT|光通讯", "0.1");
                    put("有色金属", "0.007");
                    }},
                new LinkedHashMap<String,String>(){{
                    put("2k以下", "0.25");
                    put("2k-5k","0.55");
                    put("5k-10k", "0.791");
                    put("10k-20k", "0.1");
                    put("20k-30k", "1.2");
                    put("30k-100k", "0.1");
                    put("100k以上", "0.01");
                    }} );

            //导出
            wrb.exportReport(targetPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置企业摘要
     * @param companyName 企业名称
     * @param companyBackground 企业背景 （字符串列表）
     * @param companyRiskResult 企业风险等级（中文名称）
     * @param companyType 企业类型（中文名称）
     * @param companyStatus 企业状态（中文名称）
     */
    public void setCompanySummary(String companyName,
                                  List companyBackground, //mock： new ArrayList<String>(){{add("民营企业");add("非上市公司");}}
                                  String companyRiskResult,
                                  String companyType,
                                  String companyStatus ) {
        if( StringUtils.isNotEmpty(companyName) ) {
            this.companyName = companyName;
        } else {
            errRecord.append("指定的“企业名称”为空；");
        }
        if( companyBackground !=null ) {
            this.companyBackground = companyBackground;
        } else {
            errRecord.append("指定的“企业背景”为空；");
        }
        if(  StringUtils.isNotEmpty(companyRiskResult) ) {
            this.companyRiskResult =companyRiskResult;
        } else {
            errRecord.append("指定的“企业风险等级（中文名称）”为空；");
        }
        if(  StringUtils.isNotEmpty(companyType) ) {
            this.companyType =companyType;
        } else {
            errRecord.append("指定的“企业类型（中文名称）”为空；");
        }
        if(  StringUtils.isNotEmpty(companyStatus) ) {
            this.companyStatus =companyStatus;
        } else {
            errRecord.append("指定的“企业状态（中文名称）”为空；");
        }
    }

    /**
     * 设置水印
     * @param waterMark 水印字符串
     * @return 设置成功：true
     */
    public boolean setWaterMark (String waterMark) {
        if( StringUtils.isBlank(waterMark) ) {
            errRecord.append("水印设置失败，参数“").append("waterMark").append("”为空；");
            return false;
        }
        boolean returnVal =false;
        for ( Object obj : mainParts.getParts().values() ) {
            if( obj instanceof HeaderPart) {
                List<Object> lo = ((HeaderPart) obj).getContent();
                List<Object> lo2 =DocxUtils.getAllElementFromObject(lo, CTTextPath.class);
                if( lo2.size() >0 ) {
                    if( lo2.get(0) instanceof  CTTextPath  ) {
                        CTTextPath ctt = (CTTextPath) lo2.get(0);
                        if (null != ctt.getString() && ctt.getString().equals("watermark example")) {
                            ctt.setString(waterMark);
                            returnVal = true;
                        }
                    }
                }
            }
        }
        if( !returnVal ) {
            errRecord.append("水印设置失败；");
        }
        return returnVal;
    }

    /** 注意：这个仅线下理财才有
     * 设置静态风险表
     * @param staticRiskTable map类型，key值包含最左这一列的所有项目
     */
    public void setStaticRiskTable(Map<String,String> staticRiskTable) {
        if( reportType != ReportType.OFFLINE_FINANCING ) {
            return;
        }
        StringBuffer thisErrRecord = new StringBuffer();
        setTableSecondColumn(mainParagraphList, 0, "fengxianxinxi_jingtaifengxianbiao",
                staticRiskTable, 0, thisErrRecord);
        if(thisErrRecord.length() >0) {
            errRecord.append("设置静态风险表时出现错误：").append(thisErrRecord).append(" ");
        }
    }

    /** 注意：这个仅线下理财才有
     * 设置动态风险表：选取范围为最近一年，如果时间不足一年，则选取一年内最远的两个时间点。
     * @param dynamicRiskTable map类型，key值包含最左这一列的所有项目，其中“动态风险指数”这一行特殊处理：
     *                         {key："动态风险指数", value: "[日期区间]"}，{key："动态风险指数^r1", value: "[指数数值]"}
     *                         日期区间 样式“2016.3-2017.3”
     */
    public void setDynamicRiskTable(Map<String,String> dynamicRiskTable) {
        if( reportType != ReportType.OFFLINE_FINANCING ) {
            return;
        }
        StringBuffer thisErrRecord = new StringBuffer();
        setTableSecondColumn(mainParagraphList, 0, "fengxianxinxi_dongtaifengxianbiao",
                dynamicRiskTable, 0, thisErrRecord);
        if(thisErrRecord.length() >0) {
            errRecord.append("设置动态风险表时出现错误：").append(thisErrRecord).append(" ");
        }
    }

    /** 注意：这个仅网络借贷才有
     * 添加平台信息（涉及模板中的平台评分的一行和第二章全部内容），调用一次，加入一个平台的信息，可多次调用加入多个。
     * @param gradeInfo 平台评分信息，这里面的key:"平台名称" 是必传参数
     * @param coreData  平台核心数据
     * @param transferQuantityTrend 平台交易量走势
     * @param interestRateTrend 平台利率走势
     * @param loanBalance 平台贷款余额
     * @param publicSentiment 平台舆情
     */
    public void addPlatInfo( Map<String, String> gradeInfo,
                             Map<String, String> coreData,
                             List<List<String>> transferQuantityTrend,
                             List<List<String>> interestRateTrend,
                             List<List<String>> loanBalance,
                             List<List<String>> publicSentiment ) {
        if( reportType != ReportType.NETWORK_LENDING ) {
            return;
        }
        String errHead ="添加平台信息时出现错误：";
        StringBuffer thisErrRecord = new StringBuffer();
        String platName ="";

        //设置 平台评分信息
        if( gradeInfo ==null || gradeInfo.isEmpty() ) {
            errRecord.append(errHead).append("参数 gradeInfo 为空；");
            return;
        } else {
            platName = new String( gradeInfo.get("平台名称") );
            if( StringUtils.isBlank(platName) ) {
                errRecord.append(errHead).append("参数 gradeInfo.平台名称 为空；");
                return;
            }
            String tblAnchor ="fengxian_pingtaipingfenxinxi";
            int idx = searchAnchorFromParagraphListToIndex(mainParagraphList, 0, tblAnchor );
            if(idx <0 || (idx +1) >= mainParagraphList.size() ) {
                thisErrRecord.append("未搜索到表格“平台评分信息”；");
            } else {
                idx++; //将序号指向可能的表格对象
                if( mainParagraphList.get(idx) instanceof JAXBElement
                        && ((JAXBElement)mainParagraphList.get(idx)).getValue() instanceof Tbl  ) {
                    List<Object> trList =((Tbl) ((JAXBElement)mainParagraphList.get(idx)).getValue()).getContent();
                    if( trList.size() <2 ) {
                        thisErrRecord.append("表格“").append(tblAnchor).append("”格式不正确；");
                    } else {
                        Object decTr =trList.get(trList.size() -1); //目标行对象
                        List<Object> decTcs =DocxUtils.getAllElementFromObject( decTr, Tc.class ); //目标单元格列表
                        if( decTcs.size() >0 ){
                            String str = DocxUtils.docx4jObjectToString(decTcs.get(0));
                            if(StringUtils.isNotBlank(str) && !(str.equals("$$(行模板)")) ) {//如果不是模板行，则复制此行
                                decTr = DocxUtils.deepCopy( decTr );
                                trList.add(decTr); //加入新行
                                decTcs =DocxUtils.getAllElementFromObject( decTr, Tc.class );
                            }
                            List<Object> tblHeadTcs =DocxUtils.getAllElementFromObject(trList.get(0),Tc.class); //表头单元格列表
                            for( int gIdx =0; gIdx <tblHeadTcs.size(); gIdx++ ) {
                                Object tObj = tblHeadTcs.get(gIdx);
                                String keyStr = DocxUtils.docx4jObjectToString(tObj);
                                if( StringUtils.isNotEmpty(keyStr) ) {
                                    String valStr = gradeInfo.get(keyStr);
                                    if( StringUtils.isNotEmpty(valStr) ) {
                                        DocxUtils.modifyTextInTc( (Tc)decTcs.get(gIdx), valStr );
                                        continue;
                                    }
                                } else {
                                    thisErrRecord.append("设置“").append(keyStr).append("”失败；");
                                }
                                DocxUtils.modifyTextInTc( (Tc)decTcs.get(gIdx), "——" );
                            }
                        } else {
                            thisErrRecord.append("查找到不合规的行对象；");
                        }
                    }
                }
            }
        }
        if( thisErrRecord.length() >0 ) {
            thisErrRecord.insert(0,"设置平台评分信息Err: ");
        }

        //复制一份“平台信息”
        List newBlock = copySignedSegmentFromMainParagraphList("平台信息模板" );
        if( newBlock.isEmpty() ) {
            thisErrRecord.append("复制一份“平台信息”失败，未找到正确的模板；");
            errRecord.append(errHead).append(thisErrRecord).append(" ");
            return;
        }

        //设置 平台名称
        Map planNameMap =new HashMap<String, String>();
        planNameMap.put("$$（平台名称）", platName);
        DocxUtils.replacePlaceholder( newBlock, planNameMap );

        boolean isFront =true;

        //设置平台核心数据
        StringBuffer this1ErrRecord =new StringBuffer();
        String cdAnchor ="pingtai_pingtaihexinshuju";
        if( coreData ==null || coreData.isEmpty() ) { //表格无有效填充内容，删除表格及备注行
            isFront =false;
        } else {
            setTableSecondColumn( newBlock, 0, cdAnchor, coreData, 1, this1ErrRecord );
            isFront =true; //删除段落“……无相关信息”
        }
        delTableOrParagraphFromParagraphList(isFront, newBlock, 0, cdAnchor, this1ErrRecord);
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("设置平台核心数据Err: ").append(this1ErrRecord).append(" ");
        }

        //设置 平台交易量走势
        this1ErrRecord =new StringBuffer();
        addTableRows( newBlock, 0, "pingtai_jiaoyiliangzoushi", transferQuantityTrend,
                (transferQuantityTrend==null) ? 0 : transferQuantityTrend.size(), this1ErrRecord  );
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("设置平台交易量走势Err: ").append(this1ErrRecord).append(" ");
        }

        //设置 平台利率走势
        this1ErrRecord =new StringBuffer();
        addTableRows( newBlock, 0, "pingtai_lilvzoushi", interestRateTrend,
                Integer.MAX_VALUE, this1ErrRecord  );
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("设置平台利率走势Err: ").append(this1ErrRecord).append(" ");
        }

        //设置 平台贷款余额
        this1ErrRecord =new StringBuffer();
        addTableRows( newBlock, 0, "pingtai_daikuanyu_e", loanBalance,
                Integer.MAX_VALUE, this1ErrRecord  );
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("设置平台贷款余额Err: ").append(this1ErrRecord).append(" ");
        }

        //设置 平台舆情
        this1ErrRecord =new StringBuffer();
        addTableRows( newBlock, 0, "pingtai_pingtaiyuqing", publicSentiment,
                99, this1ErrRecord  );
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("设置平台舆情Err: ").append(this1ErrRecord).append(" ");
        }

        //将复制的“平台信息”片段插入到指定位置
        insertSegmentToParagraphListAtSigned( newBlock , "插入平台信息", true);

        if(thisErrRecord.length() >0) {
            errRecord.append(errHead).append(thisErrRecord).append(" ");
        }
    }

    /**
     * 设置企业基本信息表
     * @param baseInfoTable key：模板表格左边这一列的所有值
     */
    public void setCompanyBaseInfoTable( Map<String, String>baseInfoTable ) {
        StringBuffer thisErrRecord = new StringBuffer();
        setTableSecondColumn(mainParagraphList, 0, "qixin_jibengxinxi",
                baseInfoTable, 0, thisErrRecord);
        if(thisErrRecord.length() >0) {
            errRecord.append("设置企业基本信息表时出现错误：").append(thisErrRecord).append(" ");
        }
    }

    /**
     * 设置企业股东信息
     * @param stockholderInfo  List<List<"股东","股东类型">>
     */
    public void setStockholderInfo( List<List<String>> stockholderInfo ) {
        StringBuffer thisErrRecord = new StringBuffer();
        addTableRows( mainParagraphList, 0, "qixin_gudongxinxi", stockholderInfo,
                Integer.MAX_VALUE, thisErrRecord  );
        if(thisErrRecord.length() >0) {
            errRecord.append("设置企业股东信息表").append("时出现错误：").append(thisErrRecord).append(" ");
        }
    }

    /**
     * 设置企业出资信息
     * @param stockholderContributionInfo List<List<"股东","认缴出资额(万元)", "认缴出资时间", ...>>
     */
    public void setStockholderContributionInfo( List<List<String>> stockholderContributionInfo ) {
        StringBuffer thisErrRecord = new StringBuffer();
        addTableRows( mainParagraphList, 0, "qixin_gudongchuzi", stockholderContributionInfo,
                Integer.MAX_VALUE, thisErrRecord  );
        if(thisErrRecord.length() >0) {
            errRecord.append("设置企业出资信息表").append("时出现错误：").append(thisErrRecord).append(" ");
        }
    }

    /**
     * 设置董监高信息
     * @param trusteeSupervisorSeniorInfo  List<List<"姓名","职务">>
     */
    public void setTrusteeSupervisorSeniorInfo( List<List<String>> trusteeSupervisorSeniorInfo ) {
        StringBuffer thisErrRecord = new StringBuffer();
        addTableRows( mainParagraphList, 0, "qixin_dongjiangaoxinxi", trusteeSupervisorSeniorInfo,
                Integer.MAX_VALUE, thisErrRecord  );
        if(thisErrRecord.length() >0) {
            errRecord.append("设置董监高信息表").append("时出现错误：").append(thisErrRecord).append(" ");
        }
    }

    /**
     * 设置变更信息
     * @param changeInfo  List<List<"变更事项", "变更前", "变更后", "变更时间">>
     */
    public void setCompanyChangeInfo( List<List<String>> changeInfo ) {
        StringBuffer thisErrRecord = new StringBuffer();
        addTableRows( mainParagraphList, 0, "qixin_biangengxinxi", changeInfo,
                Integer.MAX_VALUE, thisErrRecord  );
        if(thisErrRecord.length() >0) {
            errRecord.append("设置变更信息表").append("时出现错误：").append(thisErrRecord).append(" ");
        }
    }

    /**
     * 设置企业关联方图谱信息
     * @param relatedPartyMapping 总的关联方图谱 //ByteArrayOutputStream aa =new ByteArrayOutputStream();
     * @param oneDegreeMapping 一度关联图
     * @param oneDegreeDistribute 一度关联企业行业分布列表
     * @param twoDegreeMapping 二度关联图
     * @param twoDegreeDistribute 二度关联企业行业分布列表
     */
    public void setRelatedPartyMappingInfo( byte[] relatedPartyMapping,
                                            byte[] oneDegreeMapping,
                                            List<List<String>> oneDegreeDistribute,
                                            byte[] twoDegreeMapping,
                                            List<List<String>> twoDegreeDistribute ) {
        StringBuffer thisErrRecord = new StringBuffer();
        StringBuffer this1ErrRecord =new StringBuffer();

        //关联方图谱
        replaceImage(mainParagraphList, 0, "qixin_guanlianfangtupu",
                relatedPartyMapping, null, this1ErrRecord);
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("设置关联方图谱Err: ").append(this1ErrRecord).append(" ");
        }

        //一度关联图
        this1ErrRecord =new StringBuffer();
        replaceImage(mainParagraphList, 0, "qixin_yidutupu",
                oneDegreeMapping,null,  this1ErrRecord);
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("设置一度关联图谱Err: ").append(this1ErrRecord).append(" ");
        }

        //一度关联表
        this1ErrRecord =new StringBuffer();
        addTableRows( mainParagraphList, 0, "qixin_yidubiaoge", oneDegreeDistribute,
                Integer.MAX_VALUE, this1ErrRecord  );
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("设置一度关联列表Err: ").append(this1ErrRecord).append(" ");
        }

        //二度关联图
        this1ErrRecord =new StringBuffer();
        replaceImage(mainParagraphList, 0, "qixin_edutupian",
                twoDegreeMapping, null, this1ErrRecord);
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("设置二度关联图谱Err: ").append(this1ErrRecord).append(" ");
        }

        //二度关联表
        this1ErrRecord =new StringBuffer();
        addTableRows( mainParagraphList, 0, "qixin_edubiaoge", twoDegreeDistribute,
                Integer.MAX_VALUE, this1ErrRecord  );
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("设置二度关联列表Err: ").append(this1ErrRecord).append(" ");
        }

        if(thisErrRecord.length() >0) {
            errRecord.append("设置企业关联方图谱信息").append("时出现错误：").append(thisErrRecord).append(" ");
        }
    }

    /**
     * 设置企业招聘信息 /hologram/recruitPeopleDistribute.do?company=成都数联铭品科技有限公司
     *                  /hologram/recruitPeopleSalary.do?company=成都数联铭品科技有限公司
     * @param recruitInfoList 招聘信息列表
     * @param recruitPeopleDistribute 招聘人员分布
     * @param recruitPeopleSalary 薪酬分布
     */
    public void setRecruitInfo( List<List<String>> recruitInfoList,
                                Map<String, String> recruitPeopleDistribute,
                                Map<String, String> recruitPeopleSalary) throws Exception {

        MapSort_funIf1 mSort =( Map<String, String> src )->{ //升序排序
            List<Map.Entry<Double, String>> rpLst =new ArrayList<>();
            Double sum =new Double(0);
            for (Map.Entry<String, String> entry : src.entrySet()) {
                Double keyDb;
                try {
                    keyDb =Double.valueOf(entry.getValue());
                } catch ( Exception e) {
                    keyDb = new Double(0);
                }
                sum +=keyDb;  //求和
                int iIdx =0;
                for ( ; iIdx <rpLst.size(); iIdx++ ) { //搜索插入点
                    Map.Entry<Double, String> entry1 =rpLst.get(iIdx);
                    if( keyDb <entry1.getKey() ) {
                        break;
                    }
                }
                rpLst.add( iIdx, new AbstractMap.SimpleEntry<Double, String>( keyDb, entry.getKey() ) );
            }
            rpLst.add(new AbstractMap.SimpleEntry<Double, String>(sum,"总数" ));
            return rpLst;
        };

        StringBuffer thisErrRecord = new StringBuffer();
        StringBuffer this1ErrRecord =new StringBuffer();

        //设置招聘信息列表
        int aRst =addTableRows( mainParagraphList, 0, "qixin_zhaopin_xinxi", recruitInfoList,
                Integer.MAX_VALUE, this1ErrRecord  );
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("招聘信息列表Err: ").append(this1ErrRecord).append(" ");
        }
        if ( aRst <= -2 ) { //没有招聘信息
            removeSignedSegmentFromMainParagraphList("无招聘信息时被删除的文档片段");
            if(thisErrRecord.length() >0) {
                errRecord.append("设置企业招聘信息").append("时出现错误：").append(thisErrRecord).append(" ");
            }
            return;
        }

        //招聘人员分布
        this1ErrRecord =new StringBuffer();
        if( recruitPeopleDistribute !=null && recruitPeopleDistribute.size() >0 ) {
            //生成描述文本
            List<Map.Entry<Double, String>> rpLst =mSort.fun(recruitPeopleDistribute);
            Double total =rpLst.get(rpLst.size() -1).getKey();
            rpLst.remove(rpLst.size() -1);
            StringBuffer peopleDistDes =new StringBuffer("目标公司招聘人员行业分布如下：其中");
            TextSynthesis_funIf1 pD =(StringBuffer outStr, Map.Entry<Double, String>entry, String additory, String endStr )->{
                BigDecimal perVal  =BigDecimal.valueOf(entry.getKey());
                perVal =  perVal.multiply(new BigDecimal(100));
                perVal =perVal.divide( new BigDecimal(total),2, BigDecimal.ROUND_HALF_UP );
                outStr.append(entry.getValue()).append("业").append(additory)
                        .append("占总招聘人数的") .append(perVal.toString());
                outStr.append("%").append(endStr);
            };
            int reSize =rpLst.size();
            if( reSize >0 ) {
                pD.fun(peopleDistDes, rpLst.get(reSize -1), "", reSize >1 ?"，":"。");
            }
            if( rpLst.size() >1 ) {
                pD.fun(peopleDistDes, rpLst.get(reSize -2), "", reSize >2 ?"，":"。");
            }
            if( rpLst.size() >2 ) {
                pD.fun(peopleDistDes, rpLst.get(reSize -3), "", reSize >3 ?"，":"。");
            }
            if( rpLst.size() >3 ) {
                pD.fun(peopleDistDes, rpLst.get(0), "人员最少，仅", "。");
            }
            //替换描述文字
            DocxUtils.replacePlaceholder(mainParagraphList,
                    new HashMap<String, String>() {{put("$$企业信息-招聘人员分布描述", peopleDistDes.toString());}} );
            //更新图表数据
            List<String> rIdList = new ArrayList();
            int sRst = searchPartRelationIdFromParagraphList(mainParagraphList, 0, "qixin_zhaopin_renyuantu", rIdList, this1ErrRecord);
            if (rIdList.isEmpty()) {
                this1ErrRecord.append("未搜索到指定图表");
            } else {
                addDataToChartById(rIdList, recruitPeopleDistribute, thisErrRecord);
            }
        } else {
            this1ErrRecord.append("源数据Map为空；");
        }
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("招聘人员分布Err: ").append(this1ErrRecord).append(" ");
        }

        //薪酬分布
        this1ErrRecord =new StringBuffer();
        if( recruitPeopleSalary !=null && recruitPeopleSalary.size() >0 ) {
            //生成描述文本
            StringBuffer peopleSalaryDes =new StringBuffer("目标公司招聘人员的薪酬分布");
            Object []oj= recruitPeopleSalary.keySet().toArray();
            int rpsSz =recruitPeopleSalary.size();
            if( rpsSz >1 || ((String) oj[0]).indexOf('-') >=0 ) {
                peopleSalaryDes.append("从");
                String beg = ((String) oj[0]);
                int endIdx = beg.indexOf('-');
                if (endIdx >= 0) {
                    beg = beg.substring(0, endIdx);
                }
                peopleSalaryDes.append(beg).append("到");
                String end = ((String) oj[rpsSz - 1]);
                endIdx = end.indexOf('-');
                if (endIdx >= 0 && (endIdx + 1) < end.length()) {
                    end = end.substring(endIdx + 1);
                }
                peopleSalaryDes.append(end);
            } else  {
                peopleSalaryDes.append("在").append( ((String) oj[0]) );
            }
            peopleSalaryDes.append("，");
            List<Map.Entry<Double, String>> rpLst =mSort.fun(recruitPeopleSalary);
            Double total =rpLst.get(rpLst.size() -1).getKey();
            rpLst.remove(rpLst.size() -1);
            TextSynthesis_funIf1 pS =(StringBuffer outStr, Map.Entry<Double, String>entry, String additory, String endStr )->{
                BigDecimal perVal  =BigDecimal.valueOf(entry.getKey());
                perVal =  perVal.multiply(new BigDecimal(100));
                //perVal =perVal.divide( new BigDecimal(total),2, BigDecimal.ROUND_HALF_UP );
                perVal =perVal.setScale( 2, BigDecimal.ROUND_HALF_UP );
                outStr.append(additory).append(entry.getValue()).append("(").append(perVal.toString())
                        .append("%)").append(endStr);
            };
            int reSize =rpLst.size();
            if( reSize >0 ) {
                pS.fun(peopleSalaryDes, rpLst.get(reSize -1), "大部分人员的薪资范围为", reSize >1 ?"，":"。");
            }
            if( rpLst.size() >1 ) {
                pS.fun(peopleSalaryDes, rpLst.get(reSize -2), "其次为", reSize >2 ?"、":"。");
            }
            if( rpLst.size() >2 ) {
                for (int iIdx = 3; iIdx <=reSize; iIdx++) {
                    pS.fun(peopleSalaryDes, rpLst.get(reSize - iIdx), "", reSize > iIdx ? "、" : "。");
                }
            }
            //替换描述文字
            DocxUtils.replacePlaceholder(mainParagraphList,
                    new HashMap<String, String>() {{put("$$企业信息-薪酬分布描述", peopleSalaryDes.toString());}} );
            //更新图表数据
            List<String> rIdList = new ArrayList();
            int sRst =searchPartRelationIdFromParagraphList(mainParagraphList,0, "qixin_zhaopin_xinchoutu", rIdList,this1ErrRecord);
            if (rIdList.isEmpty()) {
                this1ErrRecord.append("未搜索到指定图表");
            } else {
                addDataToChartById(rIdList, recruitPeopleSalary, thisErrRecord);
            }
        } else {
            this1ErrRecord.append("源数据Map为空；");
        }
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("薪酬分布Err: ").append(this1ErrRecord).append(" ");
        }

        if(thisErrRecord.length() >0) {
            errRecord.append("设置企业招聘信息").append("时出现错误：").append(thisErrRecord).append(" ");
        }
    }

    /**
     * 设置企业诉讼信息 （在//"/infoStatistics.do"）
     * @param noCreditDebtor 失信被执行人
     * @param debtor 被执行人
     * @param judgeDoc 裁判文书
     * @param courtAnnouncement 法院公告
     * @param openCourt 开庭公告
     */
    public void setCompanyLawsuitInfo( List<List<String>> noCreditDebtor,
                                       List<List<String>> debtor,
                                       List<List<String>> judgeDoc,
                                       List<List<String>> courtAnnouncement,
                                       List<List<String>> openCourt ) {
        StringBuffer thisErrRecord = new StringBuffer();
        StringBuffer this1ErrRecord =new StringBuffer();

        //设置失信被执行人
        //this1ErrRecord =new StringBuffer();
        addTableRows( mainParagraphList, 0, "qixin_susong_shixinbei", noCreditDebtor,
                Integer.MAX_VALUE, this1ErrRecord  );
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("失信被执行人表Err: ").append(this1ErrRecord).append(" ");
        }

        //设置被执行人
        this1ErrRecord =new StringBuffer();
        addTableRows( mainParagraphList, 0, "qixin_susong_beizhixing", debtor,
                Integer.MAX_VALUE, this1ErrRecord  );
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("被执行人表Err: ").append(this1ErrRecord).append(" ");
        }

        //裁判文书
        this1ErrRecord =new StringBuffer();
        addTableRows( mainParagraphList, 0, "qixin_susong_caiwen", judgeDoc,
                Integer.MAX_VALUE, this1ErrRecord  );
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("裁判文书表Err: ").append(this1ErrRecord).append(" ");
        }

        //法院公告
        this1ErrRecord =new StringBuffer();
        addTableRows( mainParagraphList, 0, "qixin_susong_fagao", courtAnnouncement,
                Integer.MAX_VALUE, this1ErrRecord  );
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("法院公告表Err: ").append(this1ErrRecord).append(" ");
        }

        //开庭公告
        this1ErrRecord =new StringBuffer();
        addTableRows( mainParagraphList, 0, "qixin_susong_kaigao", openCourt,
                Integer.MAX_VALUE, this1ErrRecord  );
        if( this1ErrRecord.length() >0 ) {
            thisErrRecord.append("开庭公告表Err: ").append(this1ErrRecord).append(" ");
        }

        if(thisErrRecord.length() >0) {
            errRecord.append("设置企业诉讼信息").append("时出现错误：").append(thisErrRecord).append(" ");
        }
    }

    /**
     * 设置企业专利信息 //"/infoStatistics.do"
     * @param patentInfo 专利信息列表
     */
    public void setCompanyPatentInfo( List<List<String>> patentInfo ) {
        StringBuffer thisErrRecord = new StringBuffer();
        addTableRows( mainParagraphList, 0, "qixin_zhuanlixinxi", patentInfo,
                Integer.MAX_VALUE, thisErrRecord  );
        if(thisErrRecord.length() >0) {
            errRecord.append("设置企业专利信息表").append("时出现错误：").append(thisErrRecord).append(" ");
        }
    }

    /**
     * 设置企业舆情信息  // companyNews/getCompanyNews.do
     * @param publicSentiment 舆情列表
     */
    public void setCompanyPublicSentimentInfo( List<List<String>> publicSentiment ) {
        StringBuffer thisErrRecord = new StringBuffer();
        addTableRows( mainParagraphList, 0, "qixin_qiyeyuqing", publicSentiment,
                Integer.MAX_VALUE, thisErrRecord  );
        if(thisErrRecord.length() >0) {
            errRecord.append("设置企业舆情信息表").append("时出现错误：").append(thisErrRecord).append(" ");
        }
    }

    private boolean isExportGenerate =false;
    //报告生成
    private void exportGenerate( ) {
        if( isExportGenerate ) {
            return;
        }
        isExportGenerate =true;

        /** 生成企业标签(例如："私企、存续、重点关注、网络借贷")*/
        StringBuffer sBuf = new StringBuffer();
        for( Object ob : companyBackground  ) {
            if( ob instanceof String ) {
                sBuf.append( (String)ob +"、" );
            }
        }
        sBuf.append( companyStatus +"、" ).append( companyRiskResult +"、" ).append( companyType );

        //替换一些零散的标签
        Map mp =new HashMap<String, String>() {{
            put("$$标题（企业名称及属性标签）", companyName +"（" +sBuf.toString() +"…）");
            put("$$报告生成日期", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));
            put("$$风险等级：", "风险等级：" +companyRiskResult );
        }};
        DocxUtils.replacePlaceholder(mainParagraphList, mp );

        //按文档类型删除无关的部分
        if( ReportType.OTHER == reportType ) { //文档属于其它类型
            removeSignedSegmentFromMainParagraphList("非其它报告");
        } else {
            if( ReportType.OFFLINE_FINANCING == reportType ) { //文档属于线下理财
                removeSignedSegmentFromMainParagraphList("仅网络借贷");
            } else if (ReportType.NETWORK_LENDING == reportType) { //文档属于网络借贷
                removeSignedSegmentFromMainParagraphList("仅线下理财");
            }
        }

        //删除平台信息模板
        removeSignedSegmentFromMainParagraphList( "平台信息模板" );

        //删除所有的注释段落
        List removeColl =new LinkedList(); //待删除的对象集合
        for ( Object obj : mainParagraphList) { //查找所有注释段落
            if( obj instanceof P && obj.toString().startsWith("##") ) {
                removeColl.add(obj);
            }
        }
        mainParagraphList.removeAll(removeColl);

    }

    public Map<String, Object> exportReportToBytes( ) throws Docx4JException {
        Map rstMap =new HashMap<String, Object>() {{
            String fileName =companyName +"-" +reportType.getName() +".docx";
            put( "fileName" , fileName );
            put("fileBytes" ,null);
        }};
        //报告生成
        exportGenerate( );
        ByteArrayOutputStream baos =new ByteArrayOutputStream();
        wmp.save(baos);
        rstMap.put( "fileBytes" ,baos.toByteArray() );
        return rstMap;
    }

    /**
     * 报告文件导出
     * @param targetPath
     * @return 返回报告文件的存放路径
     * @throws IOException
     * @throws Docx4JException
     */
    public String exportReport(String targetPath) throws IOException, Docx4JException {
        //报告生成
        exportGenerate( );

        //生成文件名和存盘
        String targetFilePathAndName =targetPath +companyName +"-" +reportType.getName() +".docx";
        File f = new File(targetFilePathAndName);
        wmp.save(f);
        if(getErrRecord().length() >0) { //
            System.out.println( "Word_Builder_Err >> " + getErrRecord().toString() );
        }
        return targetFilePathAndName;
    }

    /**
     * 通过rID更新图表的数据
     * @param rIdList 图表rId
     * @param dataMap 源数据
     * @param thisErrRecord 出错记录
     * @throws Exception
     */
    private void addDataToChartById( List<String> rIdList, Map<String, String> dataMap,
                                     StringBuffer thisErrRecord) throws Exception{
        if(dataMap ==null || dataMap.size() <1) {
            thisErrRecord.append("源数据Map为空；");
            return;
        }
        for ( String rId : rIdList) {
            Part pt = mainRelationPart.getPart( rId );
            if( pt != null && pt instanceof Chart) {
                Chart chart =(Chart)pt;
                List ctChartList = chart.getContents().getChart().getPlotArea().getAreaChartOrArea3DChartOrLineChart();
                String chartTitle ="";
                long mapIdx =0;
                for( Object cc : ctChartList ) {
                    if(cc instanceof ListSer) {
                        List serList = ((ListSer)cc).getSer();
                        int iii =serList.size();
                        for (Object sObj : serList ) {
                            if( sObj instanceof SerContent) {
                                SerContent sCon = (SerContent)sObj;
                                //从StrCache中获取数据标题
                                List<CTStrVal> ctsLst =sCon.getTx().getStrRef().getStrCache().getPt();
                                if( ctChartList.size() >0 ) {
                                    chartTitle = ctsLst.get(0).getV();
                                }
                                int dataSize =dataMap.size();
                                //重置Str列
                                sCon.getCat().getStrRef().setF("Sheet1!$A$2:$A$" +(dataSize +1));
                                CTStrData ctS = sCon.getCat().getStrRef().getStrCache();
                                ctS.getPtCount().setVal( dataSize ); //ctS.getPtCount().getVal()
                                ctS.getPt().clear(); //清空
                                //重置Num列
                                sCon.getVal().getNumRef().setF("Sheet1!$B$2:$B$" +(dataSize +1));
                                CTNumData ctN = sCon.getVal().getNumRef().getNumCache();
                                ctN.getPtCount().setVal( dataSize ); //ctN.getPtCount().getVal()
                                ctN.getPt().clear();
                                //填充数据
                                mapIdx =0;
                                for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                                    CTStrVal strVal = new CTStrVal();
                                    strVal.setIdx(mapIdx);
                                    strVal.setV(entry.getKey());
                                    ctS.getPt().add(strVal);
                                    CTNumVal numVal = new CTNumVal();
                                    numVal.setIdx(mapIdx);
                                    numVal.setV(entry.getValue());
                                    ctN.getPt().add(numVal);
                                    mapIdx++;
                                }
                            }
                            if(mapIdx >0) {
                                break;
                            }
                        }
                    }
                    if(mapIdx >0) {
                        break;
                    }
                }
                if( mapIdx <1 ) {
                    thisErrRecord.append("更新rId为").append(rId).append("的Cache数据失败；");
                }
                for ( Relationship rs : chart.getRelationshipsPart().getRelationships().getRelationship() ) {
                    String tgStr = rs.getTarget();
                    if( tgStr.contains("xlsx") ) {
                        Part cPt =chart.getRelationshipsPart().getPart(rs.getId());
                        if( cPt instanceof EmbeddedPackagePart ) {
                            ByteArrayOutputStream tmpBaos =new ByteArrayOutputStream();
                            EmbeddedPackagePart embPP =((EmbeddedPackagePart)cPt);
                            // 由于word中内嵌的xlsx数据文件关系结构太复杂，采用如下块注释中的代码直接修改xlsx数据然后保存
                            // 的方式得到的docx文件会有错误，无法打开；因此，后面采用了创建全新数据文件的方式来实现正确的功能。
                            /*OpcPackage objEmb = embPP.extractPackage();
                            if( objEmb instanceof SpreadsheetMLPackage ) {
                                //SpreadsheetMLPackage xlsxPkg = (SpreadsheetMLPackage) objEmb;
                                for (Object shtSart : ((SpreadsheetMLPackage)objEmb).getParts().getParts().values() ) {
                                    if( shtSart instanceof WorksheetPart ) {
                                        Worksheet ws =((WorksheetPart)shtSart).getContents();
                                        SheetData data = ws.getSheetData();
                                        //data.getRow().clear();
                                        for( Row row : data.getRow() ) {
                                            for (Cell cell : ((Row)row).getC() ) {
                                                if (cell.getT().equals(STCellType.N)) {
                                                    Object to =cell.getV();
                                                    //cell.setV("0.444");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            objEmb.save( tmpBaos );*/

                            ////创建全新数据文件
                            SpreadsheetMLPackage pkg = SpreadsheetMLPackage.createPackage();
                            WorksheetPart sheet = pkg.createWorksheetPart(new PartName("/xl/worksheets/sheet1.xml"), "Sheet1", 1);
                            SheetData sheetData = sheet.getContents().getSheetData();
                            //加入标题行
                            Row rowT = Context.getsmlObjectFactory().createRow();
                            rowT.setR( 1L );  // optional
                            sheetData.getRow().add(rowT);
                            rowT.getC().add( createCell("","A1" , STCellType.N ) );
                            rowT.getC().add( createCell(chartTitle,"B1" , STCellType.INLINE_STR ) );

                            mapIdx =2;
                            for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                                Row row = Context.getsmlObjectFactory().createRow();
                                row.setR( mapIdx );
                                sheetData.getRow().add(row);
                                row.getC().add( createCell(entry.getKey() ,"A"+mapIdx, STCellType.INLINE_STR ) );
                                row.getC().add( createCell(entry.getValue(),"B"+mapIdx, STCellType.N ) );
                                mapIdx++;
                            }
                            mapIdx -=2;
                            pkg.save(tmpBaos);
                            embPP.setBinaryData(tmpBaos.toByteArray()); //这种方式更新数据才正确
                            //embPP.getBuffer().clear();embPP.getBuffer().put(tmpBaos.toByteArray()); //这种方式更新数据是错误的
                        }
                        //chart.getRelationshipsPart().removePart(cPt.getPartName()); //不能这样删除内嵌的xlsx，删除后目标文件无法打开
                        break;
                    }
                }
                if( mapIdx <1 ) {
                    thisErrRecord.append("更新rId为").append(rId).append("的内嵌xlsx数据失败；");
                }
            }
        }
    }

    /**
     * 创建一个xlsx表的单元格，目前仅能创建数值型和字符串型单元格
     * @param value 内容
     * @param strR 单元格地址，如“C12”
     * @param cellType 内容属性STCellType.INLINE_STR为字符串、其他则为数值型
     * @return 返回创建好的单元格对象
     */
    private static Cell createCell(String value, String strR, STCellType cellType) {
        Cell cell = Context.getsmlObjectFactory().createCell();
        if( cellType !=null && cellType.equals(STCellType.INLINE_STR) ) {
            CTXstringWhitespace ctx = Context.getsmlObjectFactory().createCTXstringWhitespace();
            ctx.setValue(value);
            CTRst ctrst = new CTRst();
            ctrst.setT(ctx);
            cell.setT(STCellType.INLINE_STR);
            cell.setIs(ctrst); // add ctrst as inline string
        } else {
            cell.setV(value);
        }
        if( StringUtils.isNotBlank(strR) ) {
            cell.setR(strR);
        }
        return cell;
    }

    /**
     *
     * @param myParagraphList 指定段落列表
     * @param startIdx 指定开始搜索的起始位置
     * @param anchor "##@ah-" 的后缀
     * @param rIdList 返回搜索到的rId
     * @param thisErrRecord 出错记录
     * @return 返回目标所在的行号，<0: 搜索失败
     */
    private int searchPartRelationIdFromParagraphList( List myParagraphList, int startIdx, String anchor,
                                                          List<String> rIdList, StringBuffer thisErrRecord) {
        int idx =searchAnchorFromParagraphListToIndex(myParagraphList ,startIdx, anchor);
        if(idx <0 || (idx +1) >= myParagraphList.size()) {
            thisErrRecord.append("未搜索到指定标识“").append(anchor).append("”或合规的段落结构；");
            return -1;
        }
        idx++;
        List drawingList =DocxUtils.getAllElementFromObject(myParagraphList.get(idx), Drawing.class);
        if( drawingList.size() <1 ) {
            thisErrRecord.append("未搜索到用于修改的Drawing对象；");
            return -2;
        }
        for( Object obDr : drawingList ) {
            List inlineList = ((Drawing) obDr).getAnchorOrInline();
            for(  Object inline : inlineList ) {
                if( !(inline instanceof Inline) ) {
                    continue;
                }
                List anyList = ((Inline) inline).getGraphic().getGraphicData().getAny();
                List ctrIdList = DocxUtils.getAllElementFromObject(anyList, CTRelId.class);
                for ( Object ctrId : ctrIdList ) {
                    String rId = ((CTRelId) ctrId).getId();
                    rIdList.add( rId );
                }
            }
        }
        return idx;
    }

    /**
     * 替换指定标识位置的图片
     * @param myParagraphList 指定段落列表
     * @param startIdx 指定开始搜索的起始位置
     * @param anchor "##@ah-" 的后缀
     * @param srcBytes 存放图片的字节数组，注意：若此参数为空者使用“filePathName”参数指定的图片文件作为替换源
     * @param srcFile “srcBytes”为空时，此参数必须有效
     * @param thisErrRecord 出错记录
     * @return 返回表格所在的段落标号
     */
    private int replaceImage( List myParagraphList, int startIdx, String anchor, byte[] srcBytes,
                              File srcFile, StringBuffer thisErrRecord ) {
        if( srcBytes ==null && srcFile ==null ) {
            thisErrRecord.append("srcBytes和srcFile同时为空；");
            return -2;
        }
        int idx =searchAnchorFromParagraphListToIndex(myParagraphList ,startIdx, anchor);
        if(idx <0 || (idx +1) >= myParagraphList.size()) {
            thisErrRecord.append("未搜索到指定标识“").append(anchor).append("”或合规的段落结构；");
            return -1;
        }
        idx++;
        List drawingList =DocxUtils.getAllElementFromObject(myParagraphList.get(idx), Drawing.class);
        if( drawingList.size() <1 ) {
            thisErrRecord.append("未搜索到用于修改的Drawing对象；");
            return -3;
        }
        List inlineList = ( (Drawing)drawingList.get(0) ).getAnchorOrInline(); //忽略多于1个Drawing对象的情况
        if( inlineList.size() >0 && inlineList.get(0) instanceof Inline) { //从文档中删除此处现存的图片资源
            List anyList =((Inline)inlineList.get(0)).getGraphic().getGraphicData().getAny(); //忽略多于1个Inline对象的情况
            List picList =DocxUtils.getAllElementFromObject(anyList, Pic.class);
            if( picList.size() >0 ) {
                CTBlip ctb =((Pic) picList.get(0)).getBlipFill().getBlip(); //忽略多于1个Pic对象的情况
                String rId = ctb.getEmbed();
                if (rId.equals("")) {
                    rId = ctb.getLink();
                }
                Part pt = mainRelationPart.getPart(rId);
                if( pt != null ) {
                    mainRelationPart.removePart(pt.getPartName());
                }
            }
            inlineList.clear();
        }
        try{
            //BinaryPartAbstractImage.getImage();
            BinaryPartAbstractImage aImg = (  null != srcBytes ?
                    BinaryPartAbstractImage.createImagePart(wmp, srcBytes ) :
                    BinaryPartAbstractImage.createImagePart( wmp,  srcFile )  );
            int id = (int) (Math.random() * 100000);
            Inline inline = aImg.createImageInline("image","image",id,id +103,false);
            inlineList.add(inline);
        } catch (Exception e ) {
            thisErrRecord.append("创建Inline对象时发生了异常；");
            e.printStackTrace();
        }
        return idx;
    }

    /**
     * 将指定列表中的数据加入到被标记的表格中，且对表格所在的符合特征的文档片段做剪裁
     * @param paragraphList 目标段落列表
     * @param startIdx 指定起始段落
     * @param anchor 搜索标识
     * @param rowsData 待插入的行数据
     * @param maxRowNum 指定可插入的最大行数
     * @param thisErrRecord 出错记录
     * @return 返回表格所在的段落标号, -2:源数据参数为空
     */
    private int addTableRows( List paragraphList, int startIdx, String anchor, List<List<String>> rowsData,
                              int maxRowNum, StringBuffer thisErrRecord ) {
        if( rowsData ==null ||rowsData.isEmpty() ) {
            //thisErrRecord.append("参数“").append("rowsData").append("”为空；");
            delTableOrParagraphFromParagraphList(false, paragraphList, startIdx, anchor, thisErrRecord);
            return -2;
        }
        int idx = searchAnchorFromParagraphListToIndex(paragraphList, startIdx, anchor);
        if(idx <0 || (idx +1) >=paragraphList.size() ) {
            thisErrRecord.append("未搜索到指定标识“").append(anchor).append("”或合规的段落结构；");
            return -1;
        }
        idx++; //将序号指向可能的表格对象
        if( paragraphList.get(idx) instanceof JAXBElement
                && ((JAXBElement)paragraphList.get(idx)).getValue() instanceof Tbl  ) {
            List<Object> trList =((Tbl) ((JAXBElement)paragraphList.get(idx)).getValue()).getContent();
            if( trList.size() <2 ) {
                thisErrRecord.append("表格“").append(anchor).append("”格式不正确；");
            } else {
                Object templateTr =DocxUtils.deepCopy( trList.get(1) ); //目标行对象
                Object tmpTr =trList.get(0); //暂存表头
                trList.clear();
                trList.add(tmpTr); //放回表头
                for( int cnt =0; cnt <rowsData.size() && cnt <maxRowNum; cnt++ ) {
                    List<String> strList =rowsData.get(cnt);
                    tmpTr =DocxUtils.deepCopy(templateTr);
                    trList.add( tmpTr );
                    List<Object> decTcs =DocxUtils.getAllElementFromObject( tmpTr, Tc.class ); //目标单元格列表
                    if( strList.size() !=decTcs.size() ) {
                        thisErrRecord.append("源数据第").append(cnt).append("行格式不正确；");
                        continue;
                    }
                    for( int dIdx =0; dIdx <decTcs.size(); dIdx++ ) { //将一行数据加入到对应的单元格中
                        String valStr =strList.get(dIdx);
                        valStr =( StringUtils.isEmpty(valStr) ? "——": valStr );
                        DocxUtils.modifyTextInTc( (Tc)decTcs.get(dIdx), valStr  );
                    }
                }
            }
        }
        delTableOrParagraphFromParagraphList(true, paragraphList, startIdx, anchor, thisErrRecord); //删除前部
        return idx;
    }

    /**
     * 用于四段落文档片段（"无相关信息"、定位符、表格、备注）选择性删除定位符前或后，且当片段结构完整才删除指定部分
     * @param front 定位符前或后
     * @param myParagraphList 待操作的列表
     * @param startIdx 搜索的起始位置
     * @param anchor 定位符
     */
    private void delTableOrParagraphFromParagraphList( boolean front, List myParagraphList, int startIdx,
                                                       String anchor, StringBuffer thisErrRecord  ) {
        int idx = searchAnchorFromParagraphListToIndex(myParagraphList, startIdx, anchor);
        if( idx <1 ||(idx +1) >=myParagraphList.size() ) { //在段落列表中未搜索到指定标识
            thisErrRecord.append("未搜索到待删除的指定标识“").append(anchor).append("”或合规的段落结构；");
            return;
        }
        int effectCnt =0; //有效性计数器
        List removeColl =new LinkedList();
        //段落“……无相关信息”
        if( (myParagraphList.get(idx -1) instanceof P ) ) {
            String str = DocxUtils.docx4jObjectToString(myParagraphList.get(idx -1));
            if (StringUtils.isNotBlank(str) && str.contains("无相关信息")  ) {
                if(front) {
                    removeColl.add(myParagraphList.get(idx - 1));
                }
                effectCnt++;
            }
        }
        if( myParagraphList.get(idx +1) instanceof JAXBElement
                && ((JAXBElement)myParagraphList.get(idx +1)).getValue() instanceof Tbl  ) {
            if(!front) {
                removeColl.add(myParagraphList.get(idx + 1));
            }
            effectCnt++;
            if( (idx +2) <myParagraphList.size() && (myParagraphList.get(idx +2) instanceof P ) ) {
                String str = DocxUtils.docx4jObjectToString(myParagraphList.get(idx + 2));
                if ( StringUtils.isNotBlank(str) && str.contains("——") && str.contains("无信息") && !front ) {
                    removeColl.add( myParagraphList.get(idx +2) );
                }
            }
        }
        if( effectCnt >=2 ) { //当片段结构完整才删除指定部分
            myParagraphList.removeAll(removeColl);
        }
    }

    /**
     * 设置竖表第二列
     * @param myParagraphList 指定待搜索和修改的文档片段（广义的段落列表）
     * @param startIdx 指定从段落列表的哪一个开始搜索
     * @param anchor 用于对表格定的字符串
     * @param replaceMap 待修改的对应行，key的"^r1"后缀用于处理被合并的单元格的表示问题
     * @param startRow 指定从表的哪一行开始替换，可用于跳过标题行（从第0行开始计数）
     * @param thisErrRecord 错误记录
     * @return 返回搜索到的表格在列表中的标号，<0 or >=.size() 则搜索失败, -2:源数据参数为空
     */
    private int setTableSecondColumn( List myParagraphList, int startIdx, String anchor, Map<String,String> replaceMap,
                                       int startRow, StringBuffer thisErrRecord ) {
        if( replaceMap ==null ||replaceMap.isEmpty() ) {
            thisErrRecord.append("源数据列表为空；");
            return -2;
        }
        int idx = searchAnchorFromParagraphListToIndex(myParagraphList, startIdx, anchor);
        if(idx <0 || (idx +1) >=myParagraphList.size() ) {
            thisErrRecord.append("未搜索到指定标识“").append(anchor).append("”或合规的段落结构；");
            return -1;
        }
        idx++; //将序号指向可能的表格对象
        startRow = ( startRow <0 ? 0 : startRow );
        if( myParagraphList.get(idx)  instanceof JAXBElement ){
            Object objT =((JAXBElement)myParagraphList.get(idx)).getValue();
            if( objT instanceof Tbl ) {
                List<Object> listCtt =((Tbl)objT).getContent();
                String oldStr =""; //记录前一个行首个单元格非空字符串
                for( ; startRow < listCtt.size(); startRow++ ) {
                    Object objR =listCtt.get(startRow);
                    if( objR instanceof Tr) { //是一个行对象
                        List<Object> objC =DocxUtils.getAllElementFromObject(objR,Tc.class); //List<Object> objC =((Tr)objR).getContent();
                        if( objC.size() >=2 ){
                            String str = DocxUtils.docx4jObjectToString(objC.get(0));
                            if(StringUtils.isEmpty(str)) {
                                str =oldStr+"^r1";
                            } else {
                                oldStr =str;
                            }
                            String rlt = replaceMap.get(str);
                            if(StringUtils.isEmpty(rlt)) {
                                thisErrRecord.append("设置“").append(str).append("”失败；");
                                //DocxUtils.modifyTextInTc((Tc) objC.get(1), "——");
                            } else {
                                DocxUtils.modifyTextInTc((Tc) objC.get(1), rlt);
                            }
                        } else {
                            thisErrRecord.append("查找到不合规的行对象；");
                        }
                    } else {
                        thisErrRecord.append("查找到非行对象；");
                    }
                }
            } else {
                thisErrRecord.append("搜索到的不是表格对象；");
            }
        }
        return idx;
    }

    /**
     * 从段落列表搜索指定锚点的段落序号
     * @param myParagraphList 指定段落列表
     * @param startIdx 指定开始搜索的起始位置
     * @param anchor "##@ah-" 的后缀
     * @return 返回搜索到的结果在列表中的标号
     */
    private int searchAnchorFromParagraphListToIndex(List myParagraphList, int startIdx, String anchor) {
        int insIndex =-1;
        if( myParagraphList ==null || myParagraphList.isEmpty() || startIdx >(myParagraphList.size() -1) ) {
            return insIndex;
        }
        String ahSign ="##@ah-" +anchor;
        startIdx = ( startIdx <0 ? 0 : startIdx );
        for (  int listIndex =startIdx; listIndex <myParagraphList.size(); listIndex++ ) {
            Object obj = myParagraphList.get(listIndex);
            if (obj instanceof P) {
                String tStr = DocxUtils.docx4jObjectToString(obj);
                if (null != tStr && tStr.equals(ahSign)) {
                    insIndex = listIndex;
                    break;
                }
            }
        }
        return insIndex <myParagraphList.size() ? insIndex : -1;
    }

    /**
     * 从指定的段落列表中搜索被标记的文档片段并以列表形式返回
     * @param myParagraphList 指定段落列表
     * @param startIdx 指定开始搜索的起始位置
     * @param sign "##@seg_start-" 和 "##@seg_end-" 的后缀
     * @return List
     */
    private List searchSignFromParagraphListToSegment(List myParagraphList, int startIdx, String sign) {
        List searchColl =new LinkedList();
        String startSign ="##@seg_start-" +sign;
        String endSign ="##@seg_end-" +sign;
        int step =0;
        startIdx = ( startIdx <0 ? 0 : startIdx );
        for (  int listIndex =startIdx; listIndex <myParagraphList.size(); listIndex++ ) {
            Object obj = myParagraphList.get(listIndex);
            if( obj instanceof P ) {
                String tStr = DocxUtils.docx4jObjectToString(obj);
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
                searchColl.add(obj);
            }
        }
        return searchColl;
    }

    /**
     * 从主段落列表中复制被标记的片段
     * @param sign "##@seg_start-" 和 "##@seg_end-" 的后缀
     * @return 返回复制结果的段落集合，可用于内容修改
     */
    private List copySignedSegmentFromMainParagraphList(String sign ) {
        List srcList =searchSignFromParagraphListToSegment(mainParagraphList, 0, sign);
        List copyColl =new ArrayList();
        for( Object sObj : srcList )
        {
            Object dObj =DocxUtils.deepCopy(sObj);
            copyColl.add( dObj );
        }
        return copyColl;
    }

    /**
     * 将片段插入到主文档列表的指定位置
     * @param segment 文档片段
     * @param anchor "##@seg_end-" 的后缀
     * @param front 是否插入到 "##@seg_end-" 的前面
     */
    private void insertSegmentToParagraphListAtSigned( List segment, String anchor, boolean front ) {
        int insIndex = searchAnchorFromParagraphListToIndex(mainParagraphList,0, anchor);
        if( insIndex <0 ) {
            return;
        }
        if(!front) {
            insIndex++;
        }
        mainParagraphList.addAll(insIndex, segment);
    }

    /** 删除主段落列表中被标记的片段*/
    private void removeSignedSegmentFromMainParagraphList(String sign ) {
        mainParagraphList.removeAll( searchSignFromParagraphListToSegment(mainParagraphList, 0, sign) );
    }

    @FunctionalInterface
    interface TextSynthesis_funIf1 {
        void fun( StringBuffer outStr, Map.Entry<Double, String>entry ,String additory, String endStr );
    };

    @FunctionalInterface
    interface MapSort_funIf1 {
        List<Map.Entry<Double, String>> fun( Map<String, String> src );
    };

    //创建一个供测试用的xlsx文件
    private void xlsxCreate(ByteArrayOutputStream boaos ) throws Exception {
        SpreadsheetMLPackage pkg = SpreadsheetMLPackage.createPackage();
        WorksheetPart sheet = pkg.createWorksheetPart(new PartName("/xl/worksheets/sheet1.xml"), "Sheet1", 1);
        SheetData sheetData = sheet.getContents().getSheetData();
        String [][] xy =new String [5][];
        xy[0] = new String[]{" ","表格标题"};
        xy[1] = new String[]{"地产","0.15"};
        xy[2] = new String[]{"IT","0.45"};
        xy[3] = new String[]{"化工","0.3"};
        xy[4] = new String[]{"机械","0.1"};
        for ( int rowIdx =0; rowIdx <xy.length; rowIdx++ ) {
            // Now add
            Row row = Context.getsmlObjectFactory().createRow();
            long rowNum =rowIdx +1;
            row.setR( rowNum );  // optional
            for( int col =0; col < xy[rowIdx].length; col++ ) {
                Cell cell = Context.getsmlObjectFactory().createCell();
                cell.setV( xy[rowIdx][col] );
                cell.setR("" +((char)('A'+col)) +rowNum );  // Apple Numbers needs this, or cell content won't show
                if( (rowIdx ==0 && col ==1) || (rowIdx >0 && col ==0) ) {
                    cell = createCell(xy[rowIdx][col], null, STCellType.INLINE_STR );
                }
                row.getC().add(cell);
            }
            sheetData.getRow().add(row);
        }
        pkg.save(boaos);
        FileOutputStream fos = new FileOutputStream(
                "D:\\bbdPrjIj\\wtyh-dv\\wtyh-web\\src\\main\\resources\\docx\\temporary\\emb1.xlsx");
        pkg.save(fos);
        fos.close();
    }

}
