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
import com.bbd.wtyh.report.util.MultiExeService;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

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
    private P2PImageService p2PImageService;

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
    public Map<String, Object> reportExport( String companyName, String bbdQyxxId, String loginName, String areaCode ) throws Exception {
        if ( StringUtils.isBlank( companyName ) ) {
            //throw new BusinessException("???????????????????????????");
            return convertErrInfo("E1"); //companyName is blank !
        }
        //????????????????????????
        String reportTypeName;
        String statusName;
        String analysisResultName;
        List backgroud;
        WordReportBuilder.ReportType emReportType;
        Map companyInfo =offlineFinanceService.companyInfo(companyName, bbdQyxxId);
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
            boolean multithreading =true; //?????????????????????????????????????????????
            ConcurrentLinkedDeque<String> expDeq =new ConcurrentLinkedDeque<>(); //??????????????????
            MultiExeService jes =new MultiExeService(multithreading);

            //????????????????????????
            URL templateFileURL = WordReportService.class.getResource("/docx/template/shanghai-company-anti-fraud-template.docx");
            if( templateFileURL ==null ) {
                return convertErrInfo("E3");//Template file is not found !
            }
            final WordReportBuilder[] wrbArr = {null};
            jes.runThreadFun( ()->{
                try {
                    synchronized (wrbArr) {
                        wrbArr[0] = new WordReportBuilder(templateFileURL.getFile(), emReportType);
                    }
                } catch (Exception e) {
                    expDeq.add(e.toString());
                }
                synchronized (wrbArr) {
                    //????????????????????????
                    wrbArr[0].setCompanySummary(companyName, backgroud, analysisResultName, reportTypeName/*emReportType.getName()*/, statusName);
                    //????????????
                    wrbArr[0].setWaterMark(loginName);
                }
            } );

            //????????????????????????
            if( WordReportBuilder.ReportType.OFFLINE_FINANCING == emReportType ) {
                jes.runThreadFun( ()-> {
                    List<String> dataVersionList = relationDataService.queryDateVersion(companyName, null);
                    if (dataVersionList != null) {
                        MultiExeService riskExe =new MultiExeService(multithreading);
                        //????????????
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
                                        //put("??????????????????", "69.5");
                                    }};
                                    staticRiskTable.put("??????????????????", vo.getStcRiskIndex());
                                    staticRiskTable.put("?????????????????????", vo.getRealConRisk());
                                    staticRiskTable.put("??????????????????", vo.getComExpRisk());
                                    staticRiskTable.put("??????????????????????????????", vo.getRelInRisk());
                                    staticRiskTable.put("????????????????????????", vo.getIllFinRisk());
                                    staticRiskTable.put("??????????????????", vo.getShortRisk());
                                    staticRiskTable.put("????????????????????????", vo.getIllMoneyFinRisk());
                                    staticRiskTable.put("??????????????????", vo.getPerStructRisk());
                                    Map data = offlineFinanceService.staticRiskIndex(companyName);
                                    if (data != null && data.size() > 0) {
                                        String tmpStr;
                                        try {
                                            Object object =data.get("capitalRisk");
                                            BigDecimal bd =BigDecimal.ZERO;
                                            if( object instanceof BigDecimal ) {
                                                bd =(BigDecimal)object;
                                            } else if( object instanceof Float ) {
                                                bd = BigDecimal.valueOf((Float)object);
                                            } else if( object instanceof Double ) {
                                                bd = BigDecimal.valueOf((Double) object);
                                            }
                                            bd =bd.setScale(2, BigDecimal.ROUND_HALF_UP);
                                            if( 0 == bd.compareTo(BigDecimal.ZERO) ) {
                                                tmpStr = "--";
                                            } else {
                                                tmpStr = bd.toString();
                                            }
                                        } catch (NumberFormatException e) {
                                            tmpStr = "--";
                                        }
                                        staticRiskTable.put("??????????????????", tmpStr);
                                        try {
                                            Object object =data.get("creditInfoRisk");
                                            BigDecimal bd =BigDecimal.ZERO;
                                            if( object instanceof BigDecimal ) {
                                                bd =(BigDecimal)object;
                                            } else if( object instanceof Double ) {
                                                bd = BigDecimal.valueOf((Double) object);
                                            } else if( object instanceof Float ) {
                                                bd = BigDecimal.valueOf((Float)object);
                                            }
                                            bd =bd.setScale(2, BigDecimal.ROUND_HALF_UP);
                                            if( 0 == bd.compareTo(BigDecimal.ZERO) ) {
                                                tmpStr = "--";
                                            } else {
                                                tmpStr = bd.toString();
                                            }
                                        } catch (NumberFormatException e) {
                                            tmpStr = "--";
                                        }
                                        staticRiskTable.put("??????????????????", tmpStr); //
                                    }
                                    for (int iCnt = timeOuts; iCnt > 0; iCnt--) {
                                        if (null != wrbArr[0]) {
                                            synchronized (wrbArr) {
                                                wrbArr[0].setStaticRiskTable( staticRiskTable, dataVersionList.get(0) );
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
                                    logger.warn("????????????????????????????????????");
                                }
                            } );
                        } else {
                            logger.warn("????????????????????????????????????");
                        }

                        //????????????
                        if (dataVersionList.size() > 1) {
                            //???????????????????????????
                            String currentMonth = dataVersionList.get(0);
                            LocalDate currM;
                            try {
                                currM = LocalDate.parse(currentMonth, DateTimeFormatter.ofPattern("yyyyMMdd"));
                            } catch (DateTimeParseException de) {
                                currM = LocalDate.now().minusMonths(1);
                                currentMonth = currM.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                            }
                            LocalDate currMinusY1 =currM.minusYears(1).plusDays(1); //?????????????????????????????????
                            String compareMonth = null;
                            LocalDate compM = LocalDate.now();
                            for (int idx = 1; idx < dataVersionList.size(); idx++) {
                                try {
                                    compM = LocalDate.parse(dataVersionList.get(idx), DateTimeFormatter.ofPattern("yyyyMMdd"));
                                } catch (DateTimeParseException de) {
                                    compM = LocalDate.now(); //?????????????????????????????????
                                }
                                if (compM.isBefore(currMinusY1)) {
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
                                    //put("??????????????????", "2016.9 - 2017.5");
                                }};
                                dynamicRiskTable.put("??????????????????", compM.format(DateTimeFormatter.ofPattern("yyyy.MM"))
                                        + " - " + currM.format(DateTimeFormatter.ofPattern("yyyy.MM"))); //????????????
                                dynamicRiskTable.put("??????????????????^r1", DocxUtils.doubleToString(riskvo.getBbdTimeRiskIndex(), 1)); //????????????
                                dynamicRiskTable.put("??????????????????", DocxUtils.doubleToString(riskvo.getSteadyOperationRisk(), 1));
                                dynamicRiskTable.put("????????????????????????", DocxUtils.doubleToString(riskvo.getCoreCapitalOperationRisk(), 1));
                                dynamicRiskTable.put("??????????????????", DocxUtils.doubleToString(riskvo.getSustainableRisk(), 1));
                                dynamicRiskTable.put("???????????????", DocxUtils.doubleToString(riskvo.getFoamRisk(), 1));
                                dynamicRiskTable.put("????????????", DocxUtils.doubleToString(riskvo.getPyramidSellingRisk(), 1));
                                dynamicRiskTable.put("????????????????????????", DocxUtils.doubleToString(riskvo.getIllegalFundRaisingRisk(), 1));
                                dynamicRiskTable.put("?????????????????????", DocxUtils.doubleToString(riskvo.getSteadyStateOperationRisk(), 1)); //???????????? ?????????????????????
                                for ( int iCnt =timeOuts; iCnt >0; iCnt-- ) {
                                    if( null !=wrbArr[0] ) {
                                        synchronized (wrbArr) { wrbArr[0].setDynamicRiskTable(dynamicRiskTable); }
                                        break;
                                    }
                                    try { Thread.sleep(1000); } catch (Exception e) {e.printStackTrace();}
                                }
                            } else {
                                logger.warn("????????????????????????????????????");
                            }
                        } else {
                            logger.warn("????????????????????????????????????");
                        }
                        riskExe.waiting();
                    } else {
                        logger.warn("??????????????????????????????");
                    }
                } );
            }

            //???????????????????????????
            if( WordReportBuilder.ReportType.NETWORK_LENDING == emReportType ) {
                jes.runThreadFun( ()-> {
                    boolean success =false;
                    List<PlatCompanyDTO> platList = pToPMonitorService.searchPlatListByCompanyName(companyName);
                    for (PlatCompanyDTO pd : platList) {
                        String platName = pd.getPlat_name();
                        if (StringUtils.isBlank(platName)) {
                            continue;
                        }

                        //?????????????????????????????????????????????????????????
                        MultiExeService nlExe =new MultiExeService(multithreading);

                        //??????????????????
                        Map<String, String> gradeInfo = new HashMap<String, String>() {{
                            put("????????????", platName); //?????????????????????
                        }};
                        nlExe.runThreadFun( ()-> {
                            Map<String, Object> platStatus = p2PImageService.platFormStatus(platName);
                            if (null != platStatus && platStatus.size() > 0) {
                                String score = (String) platStatus.get("score");
                                String status = (String) platStatus.get("status");
                                gradeInfo.put("????????????", score != null ? score : "--");
                                gradeInfo.put("????????????", status != null ? status : "--");
                            } else {
                                logger.warn("??????????????????????????????");
                            }
                            //???????????????????????????????????????????????????????????????
                            Map<String, Object> rst1 = p2PImageService.radarScore(platName);
                            if (rst1 != null && rst1.size() > 0) {
                                Object r2 = rst1.get("indicator");
                                if (r2 instanceof List) {
                                    for (Object r3 : (List) r2) {
                                        if (r3 instanceof Map) {
                                            String name = (String) ((Map) r3).get("name");
                                            Object max =((Map) r3).get("max");
                                            BigDecimal bD =null;
                                            if( max instanceof Double ) {
                                                bD =BigDecimal.valueOf( (Double)max );
                                            } else if( max instanceof BigDecimal ) {
                                                bD = (BigDecimal)max;
                                            }
                                            if (StringUtils.isNotBlank(name) && bD != null) {
                                                gradeInfo.put(name, bD.toString());
                                            }
                                        }
                                    }
                                }
                            } else {
                                logger.warn("??????????????????????????????");
                            }
                        } );

                        //????????????????????????
                        Map<String, String> coreData = new HashMap<String, String>() {{
                            //put("???????????????", "224.5");
                        }};
                        nlExe.runThreadFun( ()-> {
                            Map<String, Object> coreDataInfo = p2PImageService.coreDataInfo(platName);
                            if (null != coreDataInfo && coreDataInfo.size() > 0) {
                                MapKeyToKey_funIf1 mKtkFun = (String desKeyStr, String srcKeyStr, double dev, int scale, String unit) -> {
                                    Object obj = coreDataInfo.get(srcKeyStr);
                                    BigDecimal bD =BigDecimal.valueOf(0.0);
                                    if (obj != null && obj instanceof BigDecimal) {
                                        bD = (BigDecimal) obj;
                                    } else if( obj != null && obj instanceof Double ) {
                                        bD =BigDecimal.valueOf((Double)obj);
                                    } else if( obj != null && obj instanceof Integer ) {
                                        bD =BigDecimal.valueOf((Integer)obj);
                                    }
                                    bD = bD.divide(BigDecimal.valueOf(dev),
                                            scale, BigDecimal.ROUND_HALF_UP);
                                    coreData.put(desKeyStr, bD.toString() + unit);
                                };
                                mKtkFun.fun("???????????????", "amount_total", 100000000D, 2, ""); //?????????????????????
                                mKtkFun.fun("????????????", "money_stock", 100000000D, 2, ""); //?????????????????????
                                mKtkFun.fun("????????????", "interest_rate", 1D, 2, ""); //?????????????????????
                                mKtkFun.fun("???30??????????????????", "month_net_inflow", 10000D, 2, ""); //?????????????????????
                                mKtkFun.fun("??????????????????", "bid_num_stay_stil", 1D, 2, ""); //?????????????????????
                                mKtkFun.fun("??????????????????", "bor_num_stay_stil", 1D, 2, ""); //?????????????????????
                                mKtkFun.fun("?????????????????????", "top1_sum_amount", 10000D, 2, ""); //?????????????????????
                                mKtkFun.fun("?????????????????????", "top10_sum_amount", 10000D, 2, ""); //?????????????????????
                            } else {
                                logger.warn("??????????????????????????????");
                            }
                        } );

                        List<List<String>> transferQuantityTrend = new ArrayList<>(); //?????????????????????
                        List<List<String>> interestRateTrend = new ArrayList<>(); //??????????????????
                        List<List<String>> loanBalance = new ArrayList<>(); //??????????????????
                        nlExe.runThreadFun( ()-> {
                            PlatDataDO data = p2PImageService.getPlatData(platName);
                            if (null != data) {
                                List<PlatDataDO.PlatDataSixMonth> plat_data_six_month = data.getPlat_data_six_month();
                                //LocalDate deadline = LocalDate.now().minusDays(15);
                                int idx =0;
                                for (PlatDataDO.PlatDataSixMonth pdSm : plat_data_six_month) {
                                    /*LocalDate compDay;
                                    try {
                                        compDay = LocalDate.parse(pdSm.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                                    } catch (DateTimeParseException de) {
                                        compDay = LocalDate.now(); //?????????????????????????????????
                                    }
                                    if (compDay.isAfter(deadline))*/ {
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
                                    idx++;
                                    if ( idx >=30 ) { //??????30????????????????????????????????? 20170816
                                        break;
                                    }
                                }
                            } else {
                                logger.warn("??????????????????????????????");
                            }
                        } );

                        //??????????????????
                        List<List<String>> publicSentiment = new ArrayList<>();
                        nlExe.runThreadFun( ()-> {
                            YuQingDTO yuQingDTO = p2PImageService.platformConsensus(platName);
                            if (yuQingDTO != null) {
                                List<YuQingDTO.Warning> warning = yuQingDTO.getWarning();
                                if (warning != null) {
                                    for (int idx = 0; idx < warning.size() && idx < 99; idx++) {
                                        List<String> lStr = new ArrayList<>();
                                        publicSentiment.add(lStr);
                                        YuQingDTO.Warning yw = warning.get(idx);
                                        lStr.add(Integer.toString(idx + 1)); //??????
                                        lStr.add(yw.getTitle()); //??????
                                        String summary = yw.getContent();
                                        if (summary != null && summary.length() > 45) {
                                            summary = summary.substring(0, 45) + "??????";
                                        }
                                        lStr.add(summary); //????????????
                                        lStr.add(yw.getDate()); //????????????
                                    }
                                }
                            } else {
                                logger.warn("??????????????????????????????");
                            }
                        } );

                        nlExe.waiting(); //???????????????????????????
                        //?????????word
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
                    if (!success) { //???????????????????????????????????????????????????????????????
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

            //??????????????????
            jes.runThreadFun( ()-> {
                Map<String, Object> biTb = hologramQueryService.businessInfo(companyName, bbdQyxxId);
                if (biTb != null && biTb.size() > 2) {
                    String regNo = (String) biTb.get("???????????????");
                    regNo = regNo != null ? regNo : "";
                    biTb.remove("???????????????");
                    String creditCode = (String) biTb.get("??????????????????");
                    creditCode = creditCode != null ? creditCode : "";
                    biTb.remove("??????????????????");
                    biTb.put("???????????????/??????????????????", regNo + "/" + creditCode);
                    String regStatus = (String) biTb.get("??????");
                    biTb.remove("??????");
                    biTb.put("????????????", regStatus);
                    Map<String, String> baseInfoTable = new HashMap<>();
                    for (Map.Entry<String, Object> entry : biTb.entrySet()) {
                        String val = (String) entry.getValue();
                        val = val != null ? val : "";
                        baseInfoTable.put(entry.getKey(), val);
                    }
                    //?????????word
                    for (int iCnt = timeOuts; iCnt > 0; iCnt--) {
                        if (null != wrbArr[0]) {
                            synchronized (wrbArr) { wrbArr[0].setCompanyBaseInfoTable(baseInfoTable); }
                            break;
                        }
                        try { Thread.sleep(1000); } catch (Exception e) { e.printStackTrace(); }
                    }
                } else {
                    logger.warn("???????????????????????????");
                }
            } );

            //??????????????????/??????????????????/??????????????????????????????????????????/????????????
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
                                //?????????????????? ??? ??????????????????
                                List<BaseDataDO.Gdxx> gdXx = results.getGdxx();
                                if (gdXx != null && gdXx.size() > 0) {
                                    int idx =0;
                                    for (BaseDataDO.Gdxx gdObj : gdXx) {
                                        idx++;
                                        List<String> gdLine = new ArrayList<>();
                                        gdList.add(gdLine);
                                        gdLine.add("" +idx);
                                        gdLine.add(gdObj.getShareholder_name());
                                        gdLine.add(gdObj.getShareholder_type());
                                        //????????????
                                        List<String> czLine = new ArrayList<>();
                                        czList.add(czLine);
                                        czLine.add("" +idx);
                                        czLine.add(gdObj.getShareholder_name());
                                        czLine.add(gdObj.getSubscribed_capital()); //??????
                                        czLine.add(gdObj.getPaid_contribution()); //??????
                                        czLine.add(gdObj.getInvest_amount()); //?????? todo ??????????????????
                                        czLine.add(gdObj.getInvest_ratio()); //??????
                                        czLine.add(gdObj.getInvest_name()); //??????
                                    }
                                    rstCnt += 2;
                                }

                                //?????????????????????
                                List<BaseDataDO.Baxx> baXx = results.getBaxx();
                                if (baXx != null && baXx.size() > 0) {
                                    Map<String, String> baMap = new LinkedHashMap<>();
                                    for (BaseDataDO.Baxx baObj : baXx) { //????????????
                                        String val = baMap.get(baObj.getName());
                                        if (StringUtils.isNotBlank(val)) {
                                            val += "???" + baObj.getPosition();
                                        } else {
                                            val = baObj.getPosition();
                                        }
                                        baMap.put(baObj.getName(), val);
                                    }
                                    int idx =0;
                                    for (Map.Entry<String, String> entry : baMap.entrySet()) {
                                        idx++;
                                        List<String> baLine = new ArrayList<>();
                                        baList.add(baLine);
                                        baLine.add("" +idx);
                                        baLine.add(entry.getKey());
                                        baLine.add(entry.getValue());
                                    }
                                    rstCnt++;
                                }

                                //??????????????????
                                List<BaseDataDO.Bgxx> bgXx = results.getBgxx();
                                if (bgXx != null && bgXx.size() > 0) {
                                    int idx =0;
                                    for (BaseDataDO.Bgxx bgObj : bgXx) {
                                        idx++;
                                        List<String> bgLine = new ArrayList<>();
                                        bgList.add(bgLine);
                                        bgLine.add("" +idx);
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
                    logger.warn("???????????????????????????");
                }
                //?????????word
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

            // ??????????????????
            jes.runThreadFun( ()-> {
                //????????????????????????
                MultiExeService holExe =new MultiExeService(multithreading);
                final byte[][] newestYED ={null};
                /*holExe.runThreadFun( () -> {
                    newestYED[0] = offlineFinanceService.createNewestYEDtoStream(companyName);
                } );*/ //?????????????????????????????????

                RelationDiagramVO result = offlineFinanceService.queryRealRealation(companyName, bbdQyxxId, 2);
                DrawRelatedG2 dr = new DrawRelatedG2(DrawRelatedG2.DegreeType.ONE);
                List<List<DrawRelatedG2.NodeInfo>> nodeLList = dr.relationDiagramVoToNodeListG2(result);
                final Object [] comList ={null}; //List<CompanyDO> comList =new LinkedList<>();
                MultiExeService cpyNamesJes =new MultiExeService(multithreading);
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
                        comList[0] = hologramQueryService.getBbdQyxxBatchAll(cpyNames); //???????????????
                        //List<CompanyDO> comList = companyMapper.findCompanyByName( comNames ); //????????????
                        /*if( comList.size() <( 8 *comNames.size()/10 ) ) { //??????????????????????????????????????????
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
                        cpyNamesJes.waiting();
                        if (comList == null) {
                            continue;
                        }
                        int iIdx =0;
                        for (String comName : comNames) {
                            iIdx++;
                            List<String> low = new ArrayList<>();
                            distribute.add(low);
                            low.add("" +iIdx);
                            low.add(comName);
                            for (CompanyDO cd : (List<CompanyDO>)(comList[0])) {
                                if (comName.equals(cd.getName())) {
                                    low.add(cd.getBusinessType());
                                    break;
                                }
                            }
                            if (low.size() == 2) {
                                low.add("??????");
                            }
                        }
                    }
                }

                holExe.waiting();
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

            //??????????????????
            jes.runThreadFun( ()-> {
                List<List<String>> recruitInfoList = new LinkedList<java.util.List<String>>() {{
                /*add(new LinkedList<String>() {{
                    add("????????????");
                    add("??????");
                    add("14999");
                    add("2");
                    add("2017-5");
                    add("??????");
                    add("");
                }});*/
                }};
                Map<String, String> recruitPeopleDistribute = new HashMap<String, String>() {{
                    //put("??????|????????????", "0.25");
                }};
                Map<String, String> recruitPeopleSalary = new LinkedHashMap<String, String>() {{
                    //put("2k??????", "0.25");
                }};
                MultiExeService recruitExe = new MultiExeService(multithreading);
                recruitExe.runThreadFun( ()->{
                    RecruitDO recruitDO = hologramQueryDao.getRecruitInfo(companyName, 1, 15);
                    if (recruitDO != null) {
                        List<RecruitDO.Recruit> recruits = recruitDO.getResults();
                        if (recruits != null) {
                            int idx =0;
                            for (RecruitDO.Recruit rec : recruits) {
                                idx++;
                                List<String> row = new ArrayList<>();
                                recruitInfoList.add(row);
                                row.add("" +idx); //idx
                                row.add(rec.getJob_title()); //??????
                                row.add(rec.getEducation_required()); //????????????
                                row.add(rec.getSalary()); //??????
                                row.add(rec.getRecruit_numbers()); //??????
                                row.add(rec.getPubdate()); //??????
                                row.add(rec.getLocation()); //????????????
                                row.add(rec.getSource()); //??????
                            }
                        }
                    }
                } );
                recruitExe.runThreadFun( ()-> {
                    RecruitPeopleDistributeDO rpdDo = hologramQueryService.recruitPeopleDistribute(companyName, bbdQyxxId, null);
                    if (rpdDo != null) {
                        List<RecruitPeopleDistributeDO.Rdata> rDataList = rpdDo.getRdata();
                        if (rDataList != null) {
                            for (RecruitPeopleDistributeDO.Rdata rData : rDataList) {
                                recruitPeopleDistribute.put(rData.getName(), rData.getValue());
                            }
                        }
                    }
                } );
                recruitExe.runThreadFun( ()-> {
                    RecruitPeopleSalaryDO rpsDo = hologramQueryService.recruitPeopleSalary(companyName, bbdQyxxId, null);
                    if (rpsDo != null) {
                        List<RecruitPeopleSalaryDO.Rdata> rDataList = rpsDo.getRdata();
                        if (rDataList != null) {
                            for (RecruitPeopleSalaryDO.Rdata rData : rDataList) {
                                recruitPeopleSalary.put(rData.getX_value(), rData.getY_value());
                            }
                        }
                    }
                });
                recruitExe.waiting();
                if ( recruitExe.getThreadExceptionList().size() >0 && recruitInfoList != null ) {
                    recruitInfoList.isEmpty();
                }
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

            //??????????????????
            jes.runThreadFun( ()-> {
                //????????????????????????
                MultiExeService lawExe =new MultiExeService(multithreading);
                List<List<String>> noCreditDebtor = new LinkedList<>();
                lawExe.runThreadFun( () -> {
                    NoCreditDebtorDO ncd = hologramQueryService.noCreditDebtor(companyName, bbdQyxxId,null,null);
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
                    DebtorDO de = hologramQueryService.debtor(companyName, bbdQyxxId,null,null);
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
                    List<JudgeDocDO.Results> jdList = hologramQueryService.judgeDoc(companyName, bbdQyxxId,null,null);
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
                    CourtAnnouncementDO ca = hologramQueryService.courtAnnouncement(companyName, bbdQyxxId,null,null);
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
                //?????????????????????????????????????????????
                List<OpenCourtAnnouncementDO.Results> loc = hologramQueryService.openCourtAnnouncement(companyName, bbdQyxxId,null,null);
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

                lawExe.waiting();
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

            //??????????????????
            jes.runThreadFun( ()-> {
                List<List<String>> patentInfo = new LinkedList<>();
                PatentDO pd = hologramQueryService.getPatentData(companyName, bbdQyxxId, 1, 100000000);
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

            //??????????????????
            List<List<String>> publicSentiment =new LinkedList<>();
            jes.runThreadFun( ()->{
                BaiDuYuQingDO baiDuYuQingDO = hologramQueryDao.newsConsensus(companyName, bbdQyxxId);
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
                                mainStr = mainStr.substring(0, 49) + "??????";
                            }
                            row.add(mainStr);
                            String dateStr =re.getPubdate();
                            try {
                                LocalDateTime localDateTime =LocalDateTime.parse( dateStr,
                                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") );
                                dateStr =localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                            } catch (Exception e) { dateStr =""; }
                            if ( StringUtils.isBlank(dateStr) ) {
                                try {
                                    LocalDateTime localDateTime = LocalDateTime.parse(dateStr.substring(0, dateStr.indexOf('+')));
                                    dateStr = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                                } catch (Exception e) {
                                    dateStr = "";
                                }
                            }
                            row.add(dateStr);
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

            jes.waiting();//????????????????????????????????????
            //??????
            Map<String, Object> reportRst = wrbArr[0].exportReportToBytes();
            //wrbArr[0].delTempFile();
            if(wrbArr[0].getErrRecord().length() >0) { //??????????????????????????????????????????
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
                put("fileBytes", ("??????????????????????????????????????????" +err).getBytes("UTF-8"));
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


