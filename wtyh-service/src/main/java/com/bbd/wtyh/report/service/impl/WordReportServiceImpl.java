package com.bbd.wtyh.report.service.impl;

import com.bbd.wtyh.dao.HologramQueryDao;
import com.bbd.wtyh.dao.P2PImageDao;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.RecruitDO;
import com.bbd.wtyh.domain.bbdAPI.*;
import com.bbd.wtyh.domain.dto.PlatCompanyDTO;
import com.bbd.wtyh.domain.vo.DynamicRiskVO;
import com.bbd.wtyh.domain.vo.StaticRiskVO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatDataDO;
import com.bbd.wtyh.domain.wangDaiAPI.YuQingDTO;
import com.bbd.wtyh.report.service.WordReportService;
import com.bbd.wtyh.report.util.DocxUtils;
import com.bbd.wtyh.report.util.DrawRelatedG2;
import com.bbd.wtyh.report.util.JoinExeService;
import com.bbd.wtyh.report.word.WordReportBuilder;
import com.bbd.wtyh.service.*;
import com.bbd.wtyh.web.relationVO.RelationDiagramVO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListSet;

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

    @Autowired
    P2PImageService p2PImageService;

    @Autowired
    private P2PImageDao p2PImageDao;

    @Autowired
    private HologramQueryService hologramQueryService;

    @Autowired
    private HologramQueryDao hologramQueryDao;

    //@Autowired
    //private CompanyMapper companyMapper;

    //
    @Override
    public Map<String, Object> reportExport( String companyName, String loginName, String areaCode ) throws Exception {
        if ( StringUtils.isBlank( companyName ) ) {
            //throw new BusinessException("用户信息表对象为空");
            return convertErrInfo("E1"); //companyName is blank !
        }
        //获取企业摘要信息
        String reportTypeName;
        String statusName;
        String analysisResultName;
        List backgroud;
        WordReportBuilder.ReportType emReportType;
        Map companyInfo =offlineFinanceService.companyInfo(companyName);
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
            return convertErrInfo("E2");//companyInfo is not found !
        }

        try {
            final int timeOuts =100; //unit:s
            boolean multithreading =true; //是否对下面所有子任务做并发执行
            ConcurrentLinkedDeque<String> expDeq =new ConcurrentLinkedDeque<>(); //异常记录队列
            JoinExeService jes =new JoinExeService(multithreading);

            //创建报告导出实例
            URL templateFileURL = WordReportService.class.getResource("/docx/template/shanghai-company-anti-fraud-template.docx");
            if( templateFileURL ==null ) {
                return convertErrInfo("E3");//Template file is not found !
            }
            final WordReportBuilder[] wrbArr = {null};
            JoinExeService.ThreadFun newWrb = ()->{
                try {
                    synchronized (wrbArr) {
                        wrbArr[0] = new WordReportBuilder(templateFileURL.getFile(), emReportType);
                    }
                } catch (Exception e) {
                    expDeq.add(e.toString());
                }
                synchronized (wrbArr) {
                    //设置企业摘要信息
                    wrbArr[0].setCompanySummary(companyName, backgroud, analysisResultName, emReportType.getName(), statusName);
                    //设置水印
                    wrbArr[0].setWaterMark(loginName);
                }
            };
            jes.runThreadFun(newWrb);

            //设置企业风险信息
            if( WordReportBuilder.ReportType.OFFLINE_FINANCING == emReportType ) {
                jes.runThreadFun( ()-> {
                    List<String> dataVersionList = relationDataService.queryDateVersion(companyName, null);
                    if (dataVersionList != null) {
                        JoinExeService riskExe =new JoinExeService(multithreading);
                        //静态风险
                        if (dataVersionList.size() > 0) {
                            riskExe.runThreadFun( ()-> {
                                String currentMonth;
                                try {
                                    currentMonth = LocalDate.parse(dataVersionList.get(0), DateTimeFormatter.ofPattern("yyyyMMdd"))
                                            .format(DateTimeFormatter.ofPattern("yyyy-MM"));
                                } catch (DateTimeParseException de) {
                                    currentMonth = LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("yyyy-MM"));
                                }
                                StaticRiskVO vo = offlineFinanceService.queryCurrentStaticRisk(companyName, currentMonth, null);
                                if (vo != null) {
                                    Map<String, String> staticRiskTable = new HashMap<String, String>() {{
                                        //put("静态风险指数", "69.5");
                                    }};
                                    staticRiskTable.put("静态风险指数", vo.getStcRiskIndex());
                                    staticRiskTable.put("实际控制人风险", vo.getRealConRisk());
                                    staticRiskTable.put("公司扩张风险", vo.getComExpRisk());
                                    staticRiskTable.put("关联方中心积聚化风险", vo.getRelInRisk());
                                    staticRiskTable.put("非法融资衍生风险", vo.getIllFinRisk());
                                    staticRiskTable.put("短期逐利风险", vo.getShortRisk());
                                    staticRiskTable.put("非法融资违规风险", vo.getIllMoneyFinRisk());
                                    staticRiskTable.put("人才结构风险", vo.getPerStructRisk());
                                    Map data = offlineFinanceService.staticRiskIndex(companyName);
                                    if (data != null && data.size() > 0) {
                                        String tmpStr;
                                        try {
                                            /*tmpStr = BigDecimal.valueOf((Float) data.get("capitalRisk"))
                                                    .setScale(2, BigDecimal.ROUND_HALF_UP).toString();*/
                                            BigDecimal bd =BigDecimal.valueOf((Float) data.get("capitalRisk"))
                                                    .setScale(2, BigDecimal.ROUND_HALF_UP);
                                            if( 0 == bd.compareTo(BigDecimal.ZERO) ) {
                                                tmpStr = "--";
                                            } else {
                                                tmpStr = bd.toString();
                                            }
                                        } catch (NumberFormatException e) {
                                            tmpStr = "--";
                                        }
                                        staticRiskTable.put("资本背景风险", tmpStr);
                                        try {
                                            BigDecimal bd =((BigDecimal) data.get("creditInfoRisk"))
                                                    .setScale(2, BigDecimal.ROUND_HALF_UP);
                                            if( 0 == bd.compareTo(BigDecimal.ZERO) ) {
                                                tmpStr = "--";
                                            } else {
                                                tmpStr = bd.toString();
                                            }
                                        } catch (NumberFormatException e) {
                                            tmpStr = "--";
                                        }
                                        staticRiskTable.put("信用信息风险", tmpStr); //
                                    }
                                    for (int iCnt = timeOuts; iCnt > 0; iCnt--) {
                                        if (null != wrbArr[0]) {
                                            synchronized (wrbArr) {
                                                wrbArr[0].setStaticRiskTable(staticRiskTable);
                                            }
                                            break;
                                        }
                                        try {
                                            Thread.sleep(1000);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                } else {
                                    logger.warn("此公司静态风险数据不完备");
                                }
                            } );
                        } else {
                            logger.warn("此公司静态风险数据不完备");
                        }

                        //动态风险
                        if (dataVersionList.size() > 1) {
                            //计算合适的比较时段
                            String currentMonth = dataVersionList.get(0);
                            LocalDate currM;
                            try {
                                currM = LocalDate.parse(currentMonth, DateTimeFormatter.ofPattern("yyyyMMdd"));
                            } catch (DateTimeParseException de) {
                                currM = LocalDate.now().minusMonths(1);
                                currentMonth = currM.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                            }
                            currM = currM.minusYears(1); //当前月份前推一年
                            String compareMonth = null;
                            LocalDate compM = LocalDate.now();
                            for (int idx = 1; idx < dataVersionList.size(); idx++) {
                                try {
                                    compM = LocalDate.parse(dataVersionList.get(idx), DateTimeFormatter.ofPattern("yyyyMMdd"));
                                } catch (DateTimeParseException de) {
                                    compM = LocalDate.now(); //使下一步的判断条件为假
                                }
                                if (compM.isBefore(currM)) {
                                    compareMonth = dataVersionList.get(idx);
                                    break;
                                }
                            }
                            if (null == compareMonth) {
                                compareMonth = dataVersionList.get(dataVersionList.size() - 1);
                                try {
                                    compM = LocalDate.parse(dataVersionList.get(dataVersionList.size() - 1),
                                            DateTimeFormatter.ofPattern("yyyyMMdd"));
                                } catch (DateTimeParseException de) {
                                    compM = LocalDate.now().minusYears(1);
                                }
                            }
                            DynamicRiskVO riskvo = relationDataService.compareDynamicRisk(companyName, null, currentMonth, compareMonth);
                            if (riskvo != null) {
                                Map<String, String> dynamicRiskTable = new HashMap<String, String>() {{
                                    //put("动态风险指数", "2016.9 - 2017.5");
                                }};
                                dynamicRiskTable.put("动态风险指数", compM.format(DateTimeFormatter.ofPattern("yyyy.MM"))
                                        + " - " + currM.format(DateTimeFormatter.ofPattern("yyyy.MM"))); //时间范围
                                dynamicRiskTable.put("动态风险指数^r1", DocxUtils.doubleToString(riskvo.getBbdTimeRiskIndex(), 1)); //指数本身
                                dynamicRiskTable.put("稳态运营风险", DocxUtils.doubleToString(riskvo.getSteadyOperationRisk(), 1));
                                dynamicRiskTable.put("核心资本运作风险", DocxUtils.doubleToString(riskvo.getCoreCapitalOperationRisk(), 1));
                                dynamicRiskTable.put("可持续性风险", DocxUtils.doubleToString(riskvo.getSustainableRisk(), 1));
                                dynamicRiskTable.put("泡沫化风险", DocxUtils.doubleToString(riskvo.getFoamRisk(), 1));
                                dynamicRiskTable.put("传销风险", DocxUtils.doubleToString(riskvo.getPyramidSellingRisk(), 1));
                                dynamicRiskTable.put("非法集资违规风险", DocxUtils.doubleToString(riskvo.getIllegalFundRaisingRisk(), 1));
                                dynamicRiskTable.put("跨区域舞弊风险", DocxUtils.doubleToString(riskvo.getSteadyStateOperationRisk(), 1)); //这个就是 跨区域舞弊风险
                                for ( int iCnt =timeOuts; iCnt >0; iCnt-- ) {
                                    if( null !=wrbArr[0] ) {
                                        synchronized (wrbArr) { wrbArr[0].setDynamicRiskTable(dynamicRiskTable); }
                                        break;
                                    }
                                    try { Thread.sleep(1000); } catch (Exception e) {e.printStackTrace();}
                                }
                            } else {
                                logger.warn("此公司动态风险数据不完备");
                            }
                        } else {
                            logger.warn("此公司动态风险数据不完备");
                        }
                        riskExe.waitJoin();
                    } else {
                        logger.warn("此公司风险数据不完备");
                    }
                } );
            }

            //添加网贷平台的信息
            if( WordReportBuilder.ReportType.NETWORK_LENDING == emReportType ) {
                jes.runThreadFun( ()-> {
                    boolean success =false;
                    List<PlatCompanyDTO> platList = pToPMonitorService.searchPlatListByCompanyName(companyName);
                    for (PlatCompanyDTO pd : platList) {
                        String platName = pd.getPlat_name();
                        if (StringUtils.isBlank(platName)) {
                            continue;
                        }

                        //对网贷平台数据获取再进一步做并行化处理
                        JoinExeService nlExe =new JoinExeService(multithreading);

                        //平台评分信息
                        Map<String, String> gradeInfo = new HashMap<String, String>() {{
                            put("平台名称", platName); //这个是必传参数
                        }};
                        nlExe.runThreadFun( ()-> {
                            Map<String, Object> platStatus = p2PImageService.platFormStatus(platName);
                            if (null != platStatus && platStatus.size() > 0) {
                                String score = (String) platStatus.get("score");
                                String status = (String) platStatus.get("status");
                                gradeInfo.put("平台等级", score != null ? score : "--");
                                gradeInfo.put("平台状态", status != null ? status : "--");
                            } else {
                                logger.warn("此平台基本数据不完备");
                            }
                            //加入：运营能力、违约成本。。。信息披露六项
                            Map<String, Object> rst1 = p2PImageService.radarScore(platName);
                            if (rst1 != null && rst1.size() > 0) {
                                Object r2 = rst1.get("indicator");
                                if (r2 instanceof List) {
                                    for (Object r3 : (List) r2) {
                                        if (r3 instanceof Map) {
                                            String name = (String) ((Map) r3).get("name");
                                            BigDecimal bD = (BigDecimal) ((Map) r3).get("max");
                                            if (StringUtils.isNotBlank(name) && bD != null) {
                                                gradeInfo.put(name, bD.toString());
                                            }
                                        }
                                    }
                                }
                            } else {
                                logger.warn("此平台评分数据不完备");
                            }
                        } );

                        //填充平台核心数据
                        Map<String, String> coreData = new HashMap<String, String>() {{
                            //put("累计成交量", "224.5");
                        }};
                        nlExe.runThreadFun( ()-> {
                            Map<String, Object> coreDataInfo = p2PImageService.coreDataInfo(platName);
                            if (null != coreDataInfo && coreDataInfo.size() > 0) {
                                MapKeyToKey_funIf1 mKtkFun = (String desKeyStr, String srcKeyStr, double dev, int scale, String unit) -> {
                                    Object obj = coreDataInfo.get(srcKeyStr);
                                    if (obj != null && obj instanceof BigDecimal) {
                                        BigDecimal bD = ((BigDecimal) obj).divide(BigDecimal.valueOf(dev),
                                                scale, BigDecimal.ROUND_HALF_UP);
                                        coreData.put(desKeyStr, bD.toString() + unit);
                                    }
                                };
                                mKtkFun.fun("累计成交量", "amount_total", 100000000D, 2, ""); //表格已有单位列
                                mKtkFun.fun("贷款余额", "money_stock", 100000000D, 2, ""); //表格已有单位列
                                mKtkFun.fun("平均利率", "interest_rate", 1D, 2, ""); //表格已有单位列
                                mKtkFun.fun("近30日净资金流入", "month_net_inflow", 10000D, 2, ""); //表格已有单位列
                                mKtkFun.fun("待收投资人数", "bid_num_stay_stil", 1D, 2, ""); //表格已有单位列
                                mKtkFun.fun("待还借款人数", "bor_num_stay_stil", 1D, 2, ""); //表格已有单位列
                                mKtkFun.fun("最大单户借款额", "top1_sum_amount", 10000D, 2, ""); //表格已有单位列
                                mKtkFun.fun("最大十户借款额", "top10_sum_amount", 10000D, 2, ""); //表格已有单位列
                            } else {
                                logger.warn("此平台核心数据不完备");
                            }
                        } );

                        List<List<String>> transferQuantityTrend = new ArrayList<>(); //平台交易量走势
                        List<List<String>> interestRateTrend = new ArrayList<>(); //平台利率走势
                        List<List<String>> loanBalance = new ArrayList<>(); //平台贷款余额
                        nlExe.runThreadFun( ()-> {
                            PlatDataDO data = p2PImageDao.getPlatData(platName);
                            if (null != data) {
                                List<PlatDataDO.PlatDataSixMonth> plat_data_six_month = data.getPlat_data_six_month();
                                LocalDate deadline = LocalDate.now().minusDays(15);
                                for (PlatDataDO.PlatDataSixMonth pdSm : plat_data_six_month) {
                                    LocalDate compDay;
                                    try {
                                        compDay = LocalDate.parse(pdSm.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                                    } catch (DateTimeParseException de) {
                                        compDay = LocalDate.now(); //使下一步的判断条件为假
                                    }
                                    if (compDay.isAfter(deadline)) {
                                        ListValToVal_funIf1 lVtv = (String date, double srcVal, double dev, int scale,
                                                                    List<List<String>> desList) -> {
                                            BigDecimal bD = BigDecimal.valueOf(srcVal).divide(BigDecimal.valueOf(dev),
                                                    scale, BigDecimal.ROUND_HALF_UP);
                                            List<String> sonList = new ArrayList<>();
                                            sonList.add(date);
                                            sonList.add(bD.toString());
                                            desList.add(sonList);
                                        };
                                        lVtv.fun(pdSm.getDate(), pdSm.getDay_amount(), 1D, 1, transferQuantityTrend);
                                        lVtv.fun(pdSm.getDate(), pdSm.getDay_interest_rate(), 1D, 1, interestRateTrend);
                                        lVtv.fun(pdSm.getDate(), pdSm.getDay_money_stock(), 1D, 1, loanBalance);
                                    }
                                }
                            } else {
                                logger.warn("此平台走势数据不完备");
                            }
                        } );

                        //填充平台舆情
                        List<List<String>> publicSentiment = new ArrayList<>();
                        nlExe.runThreadFun( ()-> {
                            YuQingDTO yuQingDTO = p2PImageDao.platformConsensus(platName);
                            if (yuQingDTO != null) {
                                List<YuQingDTO.Warning> warning = yuQingDTO.getWarning();
                                if (warning != null) {
                                    for (int idx = 0; idx < warning.size() && idx < 99; idx++) {
                                        List<String> lStr = new ArrayList<>();
                                        publicSentiment.add(lStr);
                                        YuQingDTO.Warning yw = warning.get(idx);
                                        lStr.add(Integer.toString(idx + 1)); //序号
                                        lStr.add(yw.getTitle()); //标题
                                        String summary = yw.getContent();
                                        if (summary != null && summary.length() > 25) {
                                            summary = summary.substring(0, 25) + "……";
                                        }
                                        lStr.add(summary); //“摘要”
                                        lStr.add(yw.getDate()); //发布时间
                                    }
                                }
                            } else {
                                logger.warn("此平台舆情数据不完备");
                            }
                        } );

                        nlExe.waitJoin(); //等待所有子任务完成
                        //写入到word
                        for ( int iCnt =timeOuts; iCnt >0; iCnt-- ) {
                            if( null !=wrbArr[0] ) {
                                synchronized (wrbArr) {
                                    if ( wrbArr[0].addPlatInfo(gradeInfo, coreData, transferQuantityTrend, interestRateTrend,
                                        loanBalance, publicSentiment) >=0) {
                                        success =true;
                                    }
                                }
                                break;
                            }
                            try { Thread.sleep(1000); } catch (Exception e) {e.printStackTrace();}
                        }
                    }
                    if (!success) { //当未查询到平台评评分信息时，删除平台评分表
                        for ( int iCnt =timeOuts; iCnt >0; iCnt-- ) {
                            if( null !=wrbArr[0] ) {
                                synchronized (wrbArr) {
                                    wrbArr[0].delPlatPFxxTable();
                                }
                                break;
                            }
                            try { Thread.sleep(1000); } catch (Exception e) {e.printStackTrace();}
                        }

                    }
                } );
            }

            //企业基本信息
            jes.runThreadFun( ()-> {
                Map<String, Object> biTb = hologramQueryService.businessInfo(companyName);
                if (biTb != null && biTb.size() > 2) {
                    String regNo = (String) biTb.get("工商注册号");
                    regNo = regNo != null ? regNo : "";
                    biTb.remove("工商注册号");
                    String creditCode = (String) biTb.get("统一信用代码");
                    creditCode = creditCode != null ? creditCode : "";
                    biTb.remove("统一信用代码");
                    biTb.put("工商注册号/统一信用代码", regNo + "/" + creditCode);
                    String regStatus = (String) biTb.get("状态");
                    biTb.remove("状态");
                    biTb.put("登记状态", regStatus);
                    Map<String, String> baseInfoTable = new HashMap<>();
                    for (Map.Entry<String, Object> entry : biTb.entrySet()) {
                        String val = (String) entry.getValue();
                        val = val != null ? val : "";
                        baseInfoTable.put(entry.getKey(), val);
                    }
                    //写入到word
                    for (int iCnt = timeOuts; iCnt > 0; iCnt--) {
                        if (null != wrbArr[0]) {
                            synchronized (wrbArr) { wrbArr[0].setCompanyBaseInfoTable(baseInfoTable); }
                            break;
                        }
                        try { Thread.sleep(1000); } catch (Exception e) { e.printStackTrace(); }
                    }
                } else {
                    logger.warn("企业基本信息不完备");
                }
            } );

            //企业股东信息/股东出资信息/董事、监事、高级管理人员信息/变更信息
            jes.runThreadFun( ()-> {
                List<List<String>> gdList = new LinkedList<>();
                List<List<String>> czList = new LinkedList<>();
                List<List<String>> baList = new LinkedList<>();
                List<List<String>> bgList = new LinkedList<>();
                int rstCnt = 0;
                BaseDataDO baseDataDo = hologramQueryDao.companyQyxxDataApi(companyName);
                if (baseDataDo != null && baseDataDo.getErr_code() != null && baseDataDo.getErr_code().equals("0")) {
                    List<BaseDataDO.Results> resultsList = baseDataDo.getResults();
                    if (resultsList != null) {
                        for (BaseDataDO.Results results : resultsList) {
                            if (results != null) {
                                //处理股东信息 和 股东出资信息
                                List<BaseDataDO.Gdxx> gdXx = results.getGdxx();
                                if (gdXx != null && gdXx.size() > 0) {
                                    for (BaseDataDO.Gdxx gdObj : gdXx) {
                                        List<String> gdLine = new ArrayList<>();
                                        gdList.add(gdLine);
                                        gdLine.add(gdObj.getShareholder_name());
                                        gdLine.add(gdObj.getShareholder_type());
                                        //出资信息
                                        List<String> czLine = new ArrayList<>();
                                        czList.add(czLine);
                                        czLine.add(gdObj.getShareholder_name());
                                        czLine.add(gdObj.getSubscribed_capital()); //认缴
                                        czLine.add(gdObj.getPaid_contribution()); //实缴
                                        czLine.add(gdObj.getInvest_amount()); //份额 todo 等待产品确认
                                        czLine.add(gdObj.getInvest_ratio()); //比例
                                        czLine.add(gdObj.getInvest_name()); //方式
                                    }
                                    rstCnt += 2;
                                }

                                //处理董监高信息
                                List<BaseDataDO.Baxx> baXx = results.getBaxx();
                                if (baXx != null && baXx.size() > 0) {
                                    Map<String, String> baMap = new LinkedHashMap<>();
                                    for (BaseDataDO.Baxx baObj : baXx) { //去重合并
                                        String val = baMap.get(baObj.getName());
                                        if (StringUtils.isNotBlank(val)) {
                                            val += "、" + baObj.getPosition();
                                        } else {
                                            val = baObj.getPosition();
                                        }
                                        baMap.put(baObj.getName(), val);
                                    }
                                    for (Map.Entry<String, String> entry : baMap.entrySet()) {
                                        List<String> baLine = new ArrayList<>();
                                        baList.add(baLine);
                                        baLine.add(entry.getKey());
                                        baLine.add(entry.getValue());
                                    }
                                    rstCnt++;
                                }

                                //处理变更信息
                                List<BaseDataDO.Bgxx> bgXx = results.getBgxx();
                                if (bgXx != null && bgXx.size() > 0) {
                                    for (BaseDataDO.Bgxx bgObj : bgXx) {
                                        List<String> bgLine = new ArrayList<>();
                                        bgList.add(bgLine);
                                        bgLine.add(bgObj.getChange_items());
                                        bgLine.add(bgObj.getContent_before_change());
                                        bgLine.add(bgObj.getContent_after_change());
                                        bgLine.add(bgObj.getChange_date());
                                    }
                                    rstCnt++;
                                }
                                break;
                            }
                        }
                    }
                }
                if (rstCnt < 4) {
                    logger.warn("企业股东信息不完备");
                }
                //写入到word
                for (int iCnt = timeOuts; iCnt > 0; iCnt--) {
                    if (null != wrbArr[0]) {
                        synchronized (wrbArr) {
                            wrbArr[0].setStockholderInfo(gdList);
                            wrbArr[0].setStockholderContributionInfo(czList);
                            wrbArr[0].setTrusteeSupervisorSeniorInfo(baList);
                            wrbArr[0].setCompanyChangeInfo(bgList);
                        }
                        break;
                    }
                    try { Thread.sleep(1000); } catch (Exception e) { e.printStackTrace(); }
                }
            } );

            // 企业全息信息
            jes.runThreadFun( ()-> {
                //进一步分解子任务
                JoinExeService holExe =new JoinExeService(multithreading);
                final byte[][] newestYED ={null};
                holExe.runThreadFun( () -> {
                    newestYED[0] = offlineFinanceService.createNewestYEDtoStream(companyName);
                } );

                RelationDiagramVO result = offlineFinanceService.queryRealRealation(companyName, 2);
                DrawRelatedG2 dr = new DrawRelatedG2(DrawRelatedG2.DegreeType.ONE);
                List<List<DrawRelatedG2.NodeInfo>> nodeLList = dr.relationDiagramVoToNodeListG2(result);
                final Object [] comList ={null}; //List<CompanyDO> comList =new LinkedList<>();
                JoinExeService cpyNamesJes =new JoinExeService(multithreading);
                cpyNamesJes.runThreadFun( () -> {
                    if (nodeLList != null) {
                        List<DrawRelatedG2.NodeInfo> nodeList = new ArrayList<>(nodeLList.get(1));
                        nodeList.addAll(nodeLList.get(2));
                        List<String> cpyNames = new LinkedList<>();
                        for (DrawRelatedG2.NodeInfo ni : nodeList) {
                            if (ni.companyIs) {
                                cpyNames.add(ni.companyName);
                            }
                        }
                        comList[0] = hologramQueryService.getBbdQyxxBatchAll(cpyNames); //数据平台取
                        //List<CompanyDO> comList = companyMapper.findCompanyByName( comNames ); //数据库取
                        /*if( comList.size() <( 8 *comNames.size()/10 ) ) { //数据质量太低则再从数据平台取
                            comList = hologramQueryService.getBbdQyxxBatchAll(comNames);
                        }*/
                    }
                } );
                dr.drawRelatedG2(result);
                byte[] oneDegree = dr.saveToBytes();
                dr = new DrawRelatedG2(DrawRelatedG2.DegreeType.TWO);
                dr.drawRelatedG2(result);
                byte[] twoDegree =dr.saveToBytes();
                List< List<List<String>> > distributeArr =new LinkedList<>();
                if (nodeLList != null) {
                    for (int idx = 0; idx < 2; idx++) {
                        List<List<String>> distribute = new LinkedList<>();
                        distributeArr.add(distribute);
                        List<String> comNames = new LinkedList<>();
                        for ( DrawRelatedG2.NodeInfo ni : nodeLList.get(idx + 1) ) {
                            if (ni.companyIs) {
                                comNames.add(ni.companyName);
                            }
                        }
                        cpyNamesJes.waitJoin();
                        if (comList == null) {
                            continue;
                        }
                        for (String comName : comNames) {
                            List<String> low = new ArrayList<>();
                            distribute.add(low);
                            low.add(comName);
                            for (CompanyDO cd : (List<CompanyDO>)(comList[0])) {
                                if (comName.equals(cd.getName())) {
                                    low.add(cd.getBusinessType());
                                    break;
                                }
                            }
                            if (low.size() == 1) {
                                low.add("——");
                            }
                        }
                    }
                }

                holExe.waitJoin();
                for ( int iCnt =timeOuts; iCnt >0; iCnt-- ) {
                    if( null !=wrbArr[0] ) {
                        synchronized (wrbArr) {
                            wrbArr[0].setRelatedPartyMappingInfo(newestYED[0], oneDegree, distributeArr.get(0),
                                twoDegree, distributeArr.get(1));
                        }
                        break;
                    }
                    try { Thread.sleep(1000); } catch (Exception e) {e.printStackTrace();}
                }
            } );

            //企业招聘信息
            jes.runThreadFun( ()-> {
                List<List<String>> recruitInfoList = new LinkedList<java.util.List<String>>() {{
                /*add(new LinkedList<String>() {{
                    add("项目经理");
                    add("本科");
                    add("14999");
                    add("2");
                    add("2017-5");
                    add("上海");
                    add("");
                }});*/
                }};
                Map<String, String> recruitPeopleDistribute = new HashMap<String, String>() {{
                    //put("电力|电子信息", "0.25");
                }};
                Map<String, String> recruitPeopleSalary = new LinkedHashMap<String, String>() {{
                    //put("2k以下", "0.25");
                }};
                JoinExeService recruitExe = new JoinExeService(multithreading);
                recruitExe.runThreadFun( ()->{
                    RecruitDO recruitDO = hologramQueryDao.getRecruitInfo(companyName, 1, 15);
                    if (recruitDO != null) {
                        List<RecruitDO.Recruit> recruits = recruitDO.getResults();
                        if (recruits != null) {
                            for (RecruitDO.Recruit rec : recruits) {
                                List<String> row = new ArrayList<>();
                                recruitInfoList.add(row);
                                row.add(rec.getJob_title()); //职位
                                row.add(rec.getEducation_required()); //最低学历
                                row.add(rec.getSalary()); //薪资
                                row.add(rec.getRecruit_numbers()); //人数
                                row.add(rec.getPubdate()); //时间
                                row.add(rec.getLocation()); //工作地点
                                row.add(rec.getSource()); //来源
                            }
                        }
                    }
                } );
                recruitExe.runThreadFun( ()-> {
                    RecruitPeopleDistributeDO rpdDo = hologramQueryService.recruitPeopleDistribute(companyName, null);
                    if (rpdDo != null) {
                        List<RecruitPeopleDistributeDO.Rdata> rDataList = rpdDo.getRdata();
                        if (rDataList != null) {
                            for (RecruitPeopleDistributeDO.Rdata rData : rDataList) {
                                recruitPeopleDistribute.put(rData.getName(), rData.getValue());
                            }
                        }
                    }
                } );
                RecruitPeopleSalaryDO rpsDo = hologramQueryService.recruitPeopleSalary(companyName, null);
                if (rpsDo != null) {
                    List<RecruitPeopleSalaryDO.Rdata> rDataList = rpsDo.getRdata();
                    if (rDataList != null) {
                        for (RecruitPeopleSalaryDO.Rdata rData : rDataList) {
                            recruitPeopleSalary.put(rData.getX_value(), rData.getY_value());
                        }
                    }
                }
                recruitExe.waitJoin();
                for ( int iCnt =timeOuts; iCnt >0; iCnt-- ) {
                    if( null !=wrbArr[0] ) {
                        synchronized (wrbArr) {
                            try {
                                wrbArr[0].setRecruitInfo(recruitInfoList, recruitPeopleDistribute, recruitPeopleSalary);
                            } catch (Exception e) { expDeq.add(e.toString()); }
                        }
                        break;
                    }
                    try { Thread.sleep(1000); } catch (Exception e) {e.printStackTrace();}
                }
            } );

            //企业诉讼信息
            jes.runThreadFun( ()-> {
                //进一步分解子任务
                JoinExeService lawExe =new JoinExeService(multithreading);
                List<List<String>> noCreditDebtor = new LinkedList<>();
                lawExe.runThreadFun( () -> {
                    NoCreditDebtorDO ncd = hologramQueryService.noCreditDebtor(companyName);
                    if (ncd != null) {
                        List<NoCreditDebtorDO.Results> resList = ncd.getResults();
                        if (resList != null) {
                            Integer idx = 0;
                            for (NoCreditDebtorDO.Results re : resList) {
                                List<String> row = new ArrayList<>();
                                noCreditDebtor.add(row);
                                idx++;
                                row.add(idx.toString()); //idx
                                row.add(re.getPubdate()); //date
                                row.add(re.getExe_code()); //row.add(re.getCasecode()); //case_code
                                row.add(re.getConcrete_situation()); //
                                row.add(re.getExec_court_name());
                            }
                        }
                    }
                } );

                List<List<String>> debtor = new LinkedList<>();
                lawExe.runThreadFun( () -> {
                    DebtorDO de = hologramQueryService.debtor(companyName);
                    if (de != null) {
                        List<DebtorDO.Results> resList = de.getResults();
                        if (resList != null) {
                            Integer idx = 0;
                            for (DebtorDO.Results re : resList) {
                                List<String> row = new ArrayList<>();
                                debtor.add(row);
                                idx++;
                                row.add(idx.toString()); //idx
                                row.add(re.getCase_create_time());
                                row.add(re.getCase_code());
                                row.add(re.getExec_court_name());
                                row.add(re.getExec_subject());
                                row.add(re.getCase_state());
                            }
                        }
                    }
                } );

                List<List<String>> judgeDoc = new LinkedList<>();
                lawExe.runThreadFun( () -> {
                    List<JudgeDocDO.Results> jdList = hologramQueryService.judgeDoc(companyName);
                    if (jdList != null) {
                        Integer idx = 0;
                        for (JudgeDocDO.Results re : jdList) {
                            List<String> row = new ArrayList<>();
                            judgeDoc.add(row);
                            idx++;
                            row.add(idx.toString()); //idx
                            row.add(re.getTitle());
                            row.add(re.getSentence_date());
                            row.add(re.getCasecode());
                            row.add(re.getAction_cause());
                            row.add(re.getCase_type());
                            row.add(re.getLitigant_type());
                            row.add(re.getCaseout_come());
                        }
                    }
                } );

                List<List<String>> courtAnnouncement = new LinkedList<>();
                lawExe.runThreadFun( () -> {
                    CourtAnnouncementDO ca = hologramQueryService.courtAnnouncement(companyName);
                    if (ca != null) {
                        List<CourtAnnouncementDO.Results> resList = ca.getResults();
                        if (resList != null) {
                            Integer idx = 0;
                            for (CourtAnnouncementDO.Results re : resList) {
                                List<String> row = new ArrayList<>();
                                courtAnnouncement.add(row);
                                idx++;
                                row.add(idx.toString()); //idx
                                row.add(re.getNotice_time());
                                row.add(re.getNotice_content());
                                row.add(re.getNotice_type());
                                row.add(re.getNotice_people());
                            }
                        }
                    }
                } );

                List<List<String>> openCourt = new LinkedList<>();
                //（最后这一组直接由当前线程跑）
                List<OpenCourtAnnouncementDO.Results> loc = hologramQueryService.openCourtAnnouncement(companyName);
                if (loc != null) {
                    Integer idx = 0;
                    for (OpenCourtAnnouncementDO.Results re : loc) {
                        List<String> row = new ArrayList<>();
                        openCourt.add(row);
                        idx++;
                        row.add(idx.toString()); //idx
                        row.add(re.getTrial_date());
                        row.add(re.getCase_code());
                        row.add(re.getAction_cause());
                        row.add(re.getLitigant());
                        row.add(re.getCity());
                    }
                }

                lawExe.waitJoin();
                for ( int iCnt =timeOuts; iCnt >0; iCnt-- ) {
                    if( null !=wrbArr[0] ) {
                        synchronized (wrbArr) {
                            wrbArr[0].setCompanyLawsuitInfo(noCreditDebtor, debtor, judgeDoc, courtAnnouncement, openCourt);
                        }
                        break;
                    }
                    try { Thread.sleep(1000); } catch (Exception e) {e.printStackTrace();}
                }
            } );

            //企业专利信息
            jes.runThreadFun( ()-> {
                List<List<String>> patentInfo = new LinkedList<>();
                PatentDO pd = hologramQueryService.getPatentData(companyName, 1, 100000000);
                if (pd != null) {
                    List<PatentDO.Results> resList = pd.getResults();
                    if (resList != null) {
                        Integer idx = 0;
                        for (PatentDO.Results re : resList) {
                            List<String> row = new ArrayList<>();
                            patentInfo.add(row);
                            idx++;
                            row.add(idx.toString()); //idx
                            row.add(re.getTitle());
                            row.add(re.getPatent_type());
                            row.add(re.getApplication_code());
                            row.add(re.getApplication_date());
                        }
                    }
                }
                for ( int iCnt =timeOuts; iCnt >0; iCnt-- ) {
                    if( null !=wrbArr[0] ) {
                        synchronized (wrbArr) { wrbArr[0].setCompanyPatentInfo(patentInfo); }
                        break;
                    }
                    try { Thread.sleep(1000); } catch (Exception e) {e.printStackTrace();}
                }
            } );

            //企业舆情信息
            List<List<String>> publicSentiment =new LinkedList<>();
            jes.runThreadFun( ()->{
                BaiDuYuQingDO baiDuYuQingDO = hologramQueryDao.newsConsensus(companyName);
                if (baiDuYuQingDO != null) {
                    List<BaiDuYuQingDO.Results> rstList = baiDuYuQingDO.getResults();
                    if (rstList != null) {
                        Integer idx = 0;
                        for (BaiDuYuQingDO.Results re : rstList) {
                            List<String> row = new ArrayList<>();
                            publicSentiment.add(row);
                            idx++;
                            row.add(idx.toString()); //idx
                            row.add(re.getNews_title());
                            String mainStr = re.getMain();
                            if (mainStr != null && mainStr.length() > 50) {
                                mainStr = mainStr.substring(0, 49) + "……";
                            }
                            row.add(mainStr);
                            row.add(re.getPubdate());
                            row.add(re.getBbd_url());
                        }
                    }
                }
                for ( int iCnt =timeOuts; iCnt >0; iCnt-- ) {
                    if( null !=wrbArr[0] ) {
                        synchronized (wrbArr) { wrbArr[0].setCompanyPublicSentimentInfo(publicSentiment); }
                        break;
                    }
                    try { Thread.sleep(1000); } catch (Exception e) {e.printStackTrace();}
                }
            } );

            jes.waitJoin();//等待前面所有数据处理完成
            //导出
            Map<String, Object> reportRst = wrbArr[0].exportReportToBytes();
            //wrbArr[0].delTempFile();
            if(wrbArr[0].getErrRecord().length() >0) { //检查是否有错，及打印出错信息
                logger.warn("Word_Builder_Err >> " + wrbArr[0].getErrRecord().toString());
            }
            return reportRst;
        } catch (Exception e) {
            return convertErrInfo("E4");//"Exception: " +e.toString()
        }

    }


    private Map<String, Object>convertErrInfo(String err) {
        Map errMap =new HashMap<String, Object>() {{
            put("fileName", "errInfo.txt");
            try {
                put("fileBytes", ("报告文档生成失败，错误代码：" +err).getBytes("UTF-8"));
            } catch (Exception e) {
                put("fileBytes", new byte[]{'e','r','r','!'});
            }
        }};
        return errMap;
    }


    @FunctionalInterface
    interface MapKeyToKey_funIf1 {
        void fun( String desKeyStr, String srcKeyStr, double dev, int scale, String unit );
    };

    @FunctionalInterface
    interface ListValToVal_funIf1 {
        void fun( String date, double srcVal, double dev, int scale, List<List<String>> desList );
    };
}


