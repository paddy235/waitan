package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.dto.IndustryShanghaiDTO;
import com.bbd.wtyh.domain.dto.LoanBalanceDTO;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.service.*;
import com.bbd.wtyh.util.CalculateUtils;
import com.bbd.wtyh.web.HistogramBean;
import com.bbd.wtyh.web.ResponseBean;
import com.bbd.wtyh.web.XAxisSeriesBarLineBean;
import com.bbd.wtyh.web.XAxisSeriesLinesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 实时监控页面
 *
 * @author yanwenyuan
 * @since 2016.08.13
 */
@Controller
@RequestMapping("/realTimeMonitor")
public class RealTimeMonitorController {
    @Autowired
    private RealTimeMonitorService realTimeMonitorService;
    @Autowired
    private PToPMonitorService pToPMonitorService;
    @Autowired
    private PToPMonitorController pToPMonitorController;
    @Autowired
    private LoanController loanController;
    @Autowired
    private PrivateFundController privateFundController;
    @Autowired
    private MortgageController mortgageController;
    @Autowired
    private FactoringService factoringService;
    @Autowired
    private CrowdFundingController crowdFundingController;
    @Autowired
    private PrepaidCompanyController prepaidCompanyController;
    @Autowired
    private FinanceLeaseController financeLeaseController;
    @Autowired
    private ExchangeCompanyController exchangeCompanyController;
    @Autowired
    private PrivateFundService privateFundService;
    @Autowired
    private ExchangeCompanyService exchangeCompanyService;
    @Autowired
    private MortgageService mortgageService;

    /**
     * 光谱分析 - 只做标识，前端区分
     *
     * @return
     */
    @RequestMapping("/spectrumAnalysis")
    @ResponseBody
    public ResponseBean spectrumAnalysis() {
        List<List> content = realTimeMonitorService.spectrumAnalysis();
        return ResponseBean.successResponse(content);
    }

    /**
     * 光谱分析 - 重点关注
     *
     * @return
     */
    @RequestMapping("/spectrumAnalysisEmphasis")
    @ResponseBody
    public ResponseBean spectrumAnalysisEmphasis() {
        List<CompanyAnalysisResult> content = realTimeMonitorService.spectrumAnalysisEmphasis();
        return ResponseBean.successResponse(content);
    }

    /**
     * 光谱分析 - 一般关注
     *
     * @return
     */
    @RequestMapping("/spectrumAnalysisUsual")
    @ResponseBody
    public ResponseBean spectrumAnalysisUsual() {
        List<CompanyAnalysisResult> content = realTimeMonitorService.spectrumAnalysisUsual();
        return ResponseBean.successResponse(content);
    }

    /**
     * 光谱分析 - 正常
     *
     * @return
     */
    @RequestMapping("/spectrumAnalysisNormal")
    @ResponseBody
    public ResponseBean spectrumAnalysisNormal() {
        List<CompanyAnalysisResult> content = realTimeMonitorService.spectrumAnalysisNormal();
        return ResponseBean.successResponse(content);
    }

    /**
     * 光谱分析 - 已出风险
     *
     * @return
     */
    @RequestMapping("/spectrumAnalysisAlready")
    @ResponseBody
    public ResponseBean spectrumAnalysisAlready() {
        List<CompanyAnalysisResult> content = realTimeMonitorService.spectrumAnalysisAlready();
        return ResponseBean.successResponse(content);
    }

    /**
     * 全国地图
     *
     * @return
     */
    @RequestMapping("/ChinaMap")
    @ResponseBody
    public ResponseBean ChinaMap() {
        Map<String, Object> content = realTimeMonitorService.ChinaMap();
        return ResponseBean.successResponse(content);
    }

    /**
     * 上海地图
     *
     * @return
     */
    @RequestMapping("/shMap")
    @ResponseBody
    public ResponseBean shMap() {
        Map<String, Object> content = realTimeMonitorService.shMap();
        return ResponseBean.successResponse(content);
    }

    /**
     * 行业监测
     *
     * @return
     */
    @RequestMapping("businessChartShow.do")
    @ResponseBody
    public ResponseBean businessChartShow() {
        //小贷
        ResponseBean loanResponseBean = loanController.balance();
        List<LoanBalanceDTO> loanBalanceResult = (List<LoanBalanceDTO>)loanResponseBean.getContent();


        @SuppressWarnings("unchecked")
        XAxisSeriesLinesBean<String,String> loanDTO = new XAxisSeriesLinesBean<>(
                new ArrayList<String>(),
                new ArrayList<String>());

        for (LoanBalanceDTO loanBalanceDTO : loanBalanceResult) {
            loanDTO.getxAxis().add(loanBalanceDTO.getYear().toString());
            loanDTO.getSeries()[0].add(loanBalanceDTO.getAmount().toString());
            loanDTO.getSeries()[1].add(String.valueOf(CalculateUtils.divide(loanBalanceDTO.getAmount(), loanBalanceDTO.getCompanyAmount(), 2)));
        }

        //私募
        List<CapitalAmountDO> capitalAmountList = privateFundService.capitalAmount();
        @SuppressWarnings("unchecked")
        XAxisSeriesLinesBean<String,String> privateDTO = new XAxisSeriesLinesBean<>(
                new ArrayList<String>(),
                new ArrayList<String>());

        for (CapitalAmountDO capitalAmountDO : capitalAmountList) {
            privateDTO.getxAxis().add(privateFundService.getTypeById(capitalAmountDO.getTypeId()).getTypeName());
            privateDTO.getSeries()[0].add(capitalAmountDO.getManagedCapitalAmount().toString());
            privateDTO.getSeries()[1].add(capitalAmountDO.getPublishCompanyNumber().toString());
        }
        //p2p
        XAxisSeriesBarLineBean<Integer,String> pToPMonitorResponseBean = new XAxisSeriesBarLineBean<>();
        try {
            List<IndustryShanghaiDTO> list = pToPMonitorService.getData();
            pToPMonitorResponseBean = pToPMonitorController.newlyPlat(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //融资租赁
        ResponseBean financeLeaseResponseBean = financeLeaseController.leaseCompanyStatistic();
        //交易场所分类
        List<Map> exchangeCompanyData = exchangeCompanyService.exchangeCompanyCategory();
        HistogramBean<String,String> exchangeCompanyBean = new HistogramBean<>();

        for (Map map : exchangeCompanyData) {
            exchangeCompanyBean.getxAxis().add(map.keySet().iterator().next().toString());
            exchangeCompanyBean.getseries().add(map.values().iterator().next().toString());
        }
        //众筹平台
        ResponseBean crowdFundingResponseBean = crowdFundingController.newlyProject();
        //典当
        ResponseBean mortgageResponseBean = mortgageController.statisticList();
        List<MortgageStatisticDO> mortgageList = mortgageService.getMortgageStatisticList();
        @SuppressWarnings("unchecked")
        XAxisSeriesLinesBean<String,String> mortgageDTO = new XAxisSeriesLinesBean<>(
                new ArrayList<String>(),
                new ArrayList<String>());
        if (!CollectionUtils.isEmpty(mortgageList)) {
            for (MortgageStatisticDO mortgageStatisticDO : mortgageList) {
                mortgageDTO.getxAxis().add(mortgageStatisticDO.getYear().toString());
                mortgageDTO.getSeries()[0].add(mortgageStatisticDO.getNumber().toString());
                mortgageDTO.getSeries()[1].add(mortgageStatisticDO.getTotalAmout().toString());
            }
        }
        //商业保理
//        List<CommercialFactoringStatisticDO> facList = factoringService.companyCountByYear();
//        @SuppressWarnings("unchecked")
//        XAxisSeriesLinesBean<Integer,Integer> dto = new XAxisSeriesLinesBean<>(
//                new ArrayList<Integer>(),
//                new ArrayList<Integer>());
//
//        if (!CollectionUtils.isEmpty(facList)) {
//            for (CommercialFactoringStatisticDO bean : facList) {
//                dto.getxAxis().add(bean.getYear());
//                dto.getSeries()[0].add(bean.getCompanyNumber());
//                dto.getSeries()[1].add(bean.getTotalAmout());
//            }
//        }
        //预付卡
//        ResponseBean prepaidCompanyResponseBean = prepaidCompanyController.amount();
        Map result = new LinkedHashMap();
        result.put("loan", loanDTO);
        result.put("private", privateDTO);
        result.put("p2p", pToPMonitorResponseBean);
        result.put("finance", financeLeaseResponseBean.getContent());
        result.put("exchange", exchangeCompanyBean);
        result.put("crowd", crowdFundingResponseBean.getContent());
        result.put("mortgage", mortgageDTO);
//        result.put("factoring", dto);
        result.put("factoring", "");
//        result.put("prepaid", prepaidCompanyResponseBean.getContent());
        result.put("prepaid", "");
        return ResponseBean.successResponse(result);
    }

}
