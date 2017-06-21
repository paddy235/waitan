package com.bbd.wtyh.report.service.impl;

import com.bbd.higgs.utils.DateUtils;
import com.bbd.wtyh.domain.dto.PlatCompanyDTO;
import com.bbd.wtyh.domain.vo.DynamicRiskVO;
import com.bbd.wtyh.domain.vo.StaticRiskVO;
import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.report.service.ScreenCaptureService;
import com.bbd.wtyh.report.service.WordReportService;
import com.bbd.wtyh.report.util.DocxUtils;
import com.bbd.wtyh.report.word.WordReportBuilder;
import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.service.PToPMonitorService;
import com.bbd.wtyh.service.RelationDataService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * Created by cgj on 2017/6/14.
 */

@Service("WordReportService")
public class WordReportServiceImpl implements WordReportService {

    private static Logger logger = LoggerFactory.getLogger(WordReportServiceImpl.class);

    @Autowired
    private OfflineFinanceService offlineFinanceService;

    @Autowired
    private RelationDataService relationDataService;

    @Autowired
    private PToPMonitorService pToPMonitorService;

    @Override
    public Map<String, Object> reportExport( String companyName, String loginName, String areaCode ) throws Exception {
        if ( StringUtils.isBlank( companyName ) ) {
            //throw new BusinessException("用户信息表对象为空");
            return convertErrInfo("companyName is blank !");
        }
        //获取企业摘要信息
        String reportTypeName;
        String statusName;
        String analysisResultName;
        List backgroud;
        WordReportBuilder.ReportType emReportType;
        Map<String, Object> companyInfo =offlineFinanceService.companyInfo(companyName);
        if( companyInfo != null && companyInfo.size() >0 ) {
            reportTypeName = (String)companyInfo.get("comTypeCN");
            if(StringUtils.isNotBlank( reportTypeName ) ) {
                if( reportTypeName.equals( WordReportBuilder.ReportType.NETWORK_LENDING.getName() ) ) {
                    emReportType =WordReportBuilder.ReportType.NETWORK_LENDING;
                } else if( reportTypeName.equals( WordReportBuilder.ReportType.OFFLINE_FINANCING.getName() ) ) {
                    emReportType =WordReportBuilder.ReportType.OFFLINE_FINANCING;
                } else {
                    emReportType = WordReportBuilder.ReportType.OTHER;
                }
            } else {
                emReportType = WordReportBuilder.ReportType.OTHER;
            }
            statusName =(String)companyInfo.get("status");
            analysisResultName =(String)companyInfo.get("analysisResult");
            backgroud =(List) companyInfo.get("backgroud");

        } else {
            return convertErrInfo("companyInfo is not found !");
        }

        try {
            //创建报告导出实例
            URL templateFileURL = WordReportService.class.getResource("/docx/template/shanghai-company-anti-fraud-template.docx");
            if( templateFileURL ==null ) {
                return convertErrInfo("Template file is not found !");
            }
            WordReportBuilder wrb = new WordReportBuilder(templateFileURL.getFile(), emReportType);

            //设置企业摘要信息
            wrb.setCompanySummary(companyName, backgroud, analysisResultName, emReportType.getName(), statusName );

            //设置水印
            wrb.setWaterMark(loginName);

            //设置企业风险信息
            if( WordReportBuilder.ReportType.OFFLINE_FINANCING == emReportType ) {
                List<String> dataVersionList = relationDataService.queryDateVersion(companyName, null);
                if( dataVersionList !=null) {
                    //静态风险
                    if ( dataVersionList.size() >0 ) {
                        StaticRiskVO vo = offlineFinanceService.queryCurrentStaticRisk(companyName,
                                dataVersionList.get(0), null);
                        if( vo !=null ) {
                            Map<String, String> staticRiskTable = new HashMap<String, String>() {{
                                //put("静态风险指数", "69.5");
                            }};
                            staticRiskTable.put( "静态风险指数",  vo.getStcRiskIndex() );
                            staticRiskTable.put( "实际控制人风险", vo.getRealConRisk() );
                            staticRiskTable.put( "公司扩张风险", vo.getComExpRisk() );
                            staticRiskTable.put( "关联方中心集聚化风险", vo.getRelInRisk() );
                            staticRiskTable.put( "非法融资衍生风险", vo.getIllFinRisk() );
                            staticRiskTable.put( "短期逐利风险", vo.getShortRisk() );
                            staticRiskTable.put( "非法融资违规风险", vo.getIllMoneyFinRisk() );
                            staticRiskTable.put( "人才结构风险", vo.getPerStructRisk() );
                            Map data = offlineFinanceService.staticRiskIndex(companyName);
                            if( data !=null && data.size() >0 ) {
                                BigDecimal bd =(BigDecimal) data.get("capitalRisk");
                                String tmpStr;
                                if ( bd ==null ) {
                                    tmpStr ="--";
                                } else {
                                    bd =bd.setScale(1, BigDecimal.ROUND_HALF_UP);
                                    tmpStr =bd.toString();
                                }
                                staticRiskTable.put("资本背景风险", tmpStr);
                                bd =(BigDecimal) data.get("creditInfoRisk");
                                if ( bd ==null ) {
                                    tmpStr ="--";
                                } else {
                                    bd =bd.setScale(1, BigDecimal.ROUND_HALF_UP);
                                    tmpStr =bd.toString();
                                }
                                staticRiskTable.put("信用信息风险", tmpStr); //todo 这个信息的来源产品有异议
                            }
                            wrb.setStaticRiskTable(staticRiskTable);
                        } else {
                            logger.warn("此公司静态风险数据不完备");
                        }
                    } else {
                        logger.warn("此公司静态风险数据不完备");
                    }

                    //动态风险
                    if (dataVersionList.size() > 1) {
                        //计算合适的比较时段
                        String currentMonth = dataVersionList.get(0);
                        String[] yyMM = currentMonth.split("-", 2);
                        LocalDate currM;
                        try {
                            currM = LocalDate.parse(currentMonth, DateTimeFormatter.ofPattern("yyyy-MM"));
                        } catch (DateTimeParseException de) {
                            currM = LocalDate.now().minusMonths(1);
                            currentMonth = currM.format(DateTimeFormatter.ofPattern("yyyy-MM"));
                        }
                        currM = currM.minusYears(1); //当前月份前推一年
                        String compareMonth = null;
                        for (int idx = 1; idx < dataVersionList.size(); idx++) {
                            LocalDate compM;
                            try {
                                compM = LocalDate.parse(dataVersionList.get(idx), DateTimeFormatter.ofPattern("yyyy-MM"));
                            } catch (DateTimeParseException de) {
                                compM = LocalDate.now(); //使下一步的判断条件为假
                            }
                            if (compM.isBefore(currM)) {
                                compareMonth = dataVersionList.get(idx);
                            }
                        }
                        if (null == compareMonth) {
                            compareMonth = dataVersionList.get(dataVersionList.size() - 1);
                        }
                        DynamicRiskVO riskvo = relationDataService.compareDynamicRisk(companyName, null, currentMonth, compareMonth);
                        if (riskvo != null) {
                            Map<String, String> dynamicRiskTable = new HashMap<String, String>() {{
                                //put("动态风险指数", "2016.9 - 2017.5");
                            }};
                            dynamicRiskTable.put("动态风险指数", compareMonth.replace('-', '.') + " - "
                                    + currentMonth.replace('-', '.')); //时间范围
                            dynamicRiskTable.put("动态风险指数^r1", DocxUtils.doubleToString(riskvo.getBbdTimeRiskIndex(), 1)); //指数本身
                            dynamicRiskTable.put("稳态运营风险", DocxUtils.doubleToString(riskvo.getSteadyOperationRisk(), 1));
                            dynamicRiskTable.put("核心资本运作风险", DocxUtils.doubleToString(riskvo.getCoreCapitalOperationRisk(), 1));
                            dynamicRiskTable.put("可持续性风险", DocxUtils.doubleToString(riskvo.getSustainableRisk(), 1));
                            dynamicRiskTable.put("泡沫化风险", DocxUtils.doubleToString(riskvo.getFoamRisk(), 1));
                            dynamicRiskTable.put("传销风险", DocxUtils.doubleToString(riskvo.getPyramidSellingRisk(), 1));
                            dynamicRiskTable.put("非法集资违规风险", DocxUtils.doubleToString(riskvo.getIllegalFundRaisingRisk(), 1));
                            dynamicRiskTable.put("跨区域舞弊风险", DocxUtils.doubleToString(riskvo.getSteadyStateOperationRisk(), 1)); //这个就是 跨区域舞弊风险
                            wrb.setDynamicRiskTable(dynamicRiskTable);
                        } else {
                            logger.warn("此公司动态风险数据不完备");
                        }
                    } else {
                        logger.warn("此公司动态风险数据不完备");
                    }
                } else {
                    logger.warn("此公司风险数据不完备");
                }
            }

            //添加网贷平台的信息
            if( WordReportBuilder.ReportType.NETWORK_LENDING == emReportType ) {
                List<PlatCompanyDTO> platList = pToPMonitorService.searchPlatListByCompanyName( companyName );
                for( PlatCompanyDTO pd : platList ) {

                    wrb.addPlatInfo(new HashMap<String, String>() {{
                                        put("平台名称", "万金贷（测试平台名称）"); //这个是必传参数
                                        put("平台等级", "B");
                                        put("平台状态", "优良");
                                        put("运营能力", "37.9");
                                    }},
                            new HashMap<String, String>() {{
                                put("累计成交量", "224.5");
                                put("贷款余额", "77");
                                put("平均利率", "15.5");
                            }},
                            null,
                            null,
                            null,
                            null);
                    wrb.addPlatInfo(new HashMap<String, String>() {{
                                        put("平台名称", "亿金贷（测试）"); //这个是必传参数
                                        put("平台等级", "B");
                                        put("平台状态", "优良");
                                        put("运营能力", "57.9");
                                    }},
                            null,
                            new ArrayList<java.util.List<String>>() {{
                                java.util.List<String> lst = new ArrayList<String>() {{
                                    add("2017.8.9");
                                    add("1389.3");
                                }};
                                add(lst);
                                add(lst);
                                add(lst);
                            }},
                            null,
                            null,
                            new ArrayList<java.util.List<String>>() {{
                                java.util.List<String> lst = new ArrayList<String>() {{
                                    add("1");
                                    add("aaaa");
                                    add("aaaa");
                                    add("2017.8.9");
                                }};
                                add(lst);
                                add(lst);
                                add(lst);
                            }});

                }
            }

            //企业基本信息

            // 企业全息信息
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
            wrb.setRecruitInfo(new LinkedList<java.util.List<String>>() {{
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

            if(wrb.getErrRecord().length() >0) { //
                logger.warn("Word_Builder_Err >> " + wrb.getErrRecord().toString());
            }
            //导出
            return wrb.exportReportToBytes();
        } catch (Exception e) {
            return convertErrInfo("Exception: " +e.toString());
        }
    }


    private Map<String, Object>convertErrInfo(String err) {
        Map errMap =new HashMap<String, Object>() {{
            put("fileName", "errInfo.txt");
            try {
                put("fileBytes", ("文件生成失败：" +err).getBytes("UTF-8"));
            } catch (Exception e) {
                put("fileBytes", new byte[]{'e','r','r','!'});
            }
        }};
        return errMap;
    }

    @Autowired
    private ScreenCaptureService phantomSer;


/*    private void fun(void) {
        captureImg(req, "pdfMaps?companyId="
                + URLEncoder.encode(raCompanyPO.getId(), "utf8") + "&degree=2&province=" +URLEncoder.encode(province, "utf8"),
                "780px*850px");

        captureImg(request, "pdfRadar?company="
                + URLEncoder.encode(raCompanyPO.getCompany(), "utf8") + "&keyValue=" + URLEncoder.encode(keyValue.get(i), "utf8"),
                "600px*500px");

    }*/


    //截图工具
    /**
     * 截屏
     **/
    private String captureImg(HttpServletRequest re, String url, String size) {
        //"./phantomjs rasterize.js https://www.baidu.com c.png A4"
        String plugin = getImgPath(re, "/sysplugins/./phantomjs");
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("windows")) {
            plugin = getImgPath(re, "/sysplugins/phantomjs.exe");
        }
        String js = getImgPath(re, "/sysplugins/rasterize.js");
        String img = "/";
        if (os.contains("windows")) {
            img = getImgPath(re, img) + "/temp/" + DateUtils.format(new Date(), "yyyyMMddHHmmss") + System.nanoTime() + ".png";
        } else {
            img = "/usr/local/tomcat/shareDir/generateImg/" + DateUtils.format(new Date(), "yyyyMMddHHmmss") + System.nanoTime() + ".png";
        }

        String basePath = "http://" + re.getServerName() + ":" + re.getServerPort() + re.getContextPath() + "/";

        url = basePath + url;

        logger.info(url);

        File pluginFile = new File(plugin);
        if (!pluginFile.canExecute()) {
            pluginFile.setExecutable(true);
        }

        if (!phantomSer.exec(plugin, js, url, img, size)) {
            return null;
        }
        return img;
    }

    /**
     * 获取路径
     */
    private String getImgPath(HttpServletRequest re, String path) {
        return re.getSession().getServletContext().getRealPath(path);
    }
}
