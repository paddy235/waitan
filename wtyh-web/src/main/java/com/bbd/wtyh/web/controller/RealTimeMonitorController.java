package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.CommercialFactoringStatisticDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.LoanBalanceDO;
import com.bbd.wtyh.domain.dto.IndustryShanghaiDTO;
import com.bbd.wtyh.domain.dto.LoanBalanceDTO;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.domain.query.CompanyQuery;
import com.bbd.wtyh.service.*;
import com.bbd.wtyh.web.HistogramBean;
import com.bbd.wtyh.web.ResponseBean;
import com.bbd.wtyh.web.XAxisSeriesBarLineBean;
import com.bbd.wtyh.web.XAxisSeriesLinesBean;
import com.google.common.collect.Lists;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 实时监控页面
 *
 * @author yanwenyuan
 * @since 2016.08.13
 */
@Controller
@RequestMapping("/realTimeMonitorController")
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

    /**
     * 光谱分析 - 只做标识，前端区分
     *
     * @return
     */
    @RequestMapping("/spectrumAnalysis")
    @ResponseBody
    public ResponseBean spectrumAnalysis() {
        List<CompanyAnalysisResult> content = realTimeMonitorService.spectrumAnalysis();
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
     * 上海地图
     *
     * @return
     */
    @RequestMapping("businessChartShow.do")
    @ResponseBody
    public ResponseBean businessChartShow() {
        //小贷
        ResponseBean loanResponseBean = loanController.balance();
        //私募
        ResponseBean privateFundResponseBean = privateFundController.capitalAmount();
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
        ResponseBean exchangeCompanyResponseBean = exchangeCompanyController.exchangeCompanyCategory();
        //众筹平台
        ResponseBean crowdFundingResponseBean = crowdFundingController.newlyProject();
        //典当
        ResponseBean mortgageResponseBean = mortgageController.statisticList();
        //商业保理
        List<CommercialFactoringStatisticDO> facList = factoringService.companyCountByYear();
        @SuppressWarnings("unchecked")
        XAxisSeriesLinesBean<Integer,Integer> dto = new XAxisSeriesLinesBean<>(
                new ArrayList<Integer>(),
                new ArrayList<Integer>());

        if (!CollectionUtils.isEmpty(facList)) {
            for (CommercialFactoringStatisticDO bean : facList) {
                dto.getxAxis().add(bean.getYear());
                dto.getSeries()[0].add(bean.getCompanyNumber());
                dto.getSeries()[1].add(bean.getTotalAmout());
            }
        }
        //预付卡
        ResponseBean prepaidCompanyResponseBean = prepaidCompanyController.amount();
        Map result = new HashedMap();
        result.put("loan", loanResponseBean.getContent());
        result.put("private", privateFundResponseBean.getContent());
        result.put("p2p", pToPMonitorResponseBean);
        result.put("finance", financeLeaseResponseBean.getContent());
        result.put("exchange", exchangeCompanyResponseBean.getContent());
        result.put("crowd", crowdFundingResponseBean.getContent());
        result.put("mortgage", mortgageResponseBean.getContent());
        result.put("factoring", dto);
        result.put("prepaid", prepaidCompanyResponseBean.getContent());
        return ResponseBean.successResponse(result);
    }

}
