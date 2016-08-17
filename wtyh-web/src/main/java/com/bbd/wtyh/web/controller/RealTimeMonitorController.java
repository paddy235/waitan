package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.service.RealTimeMonitorService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    // TODO:光谱分析做错了！！
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

}
