package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.PlatformNameInformationDO;
import com.bbd.wtyh.domain.wangDaiAPI.SearchCompanyDO;
import com.bbd.wtyh.domain.wangDaiAPI.YuQingDO;
import com.bbd.wtyh.service.P2PImageService;
import com.bbd.wtyh.util.relation.StringUtils;
import com.bbd.wtyh.web.HistogramBean;
import com.bbd.wtyh.web.RadarChartBean;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * p2p行业检测平台控制层
 *
 * @author wangchenge
 * @since 2016.08.05
 */
@Controller
@RequestMapping("/P2PImage")
public class P2PImageController {
    @Autowired
    private P2PImageService p2PImageService;


    /**
     * 测试是否有”搜索公司“
     *
     * @return
     */
    @RequestMapping("/hasOrNotCompany")
    @ResponseBody
    public ResponseBean hasOrNotCompany(@RequestParam(required = true) String platName) {
        Map<String, Object> content = p2PImageService.coreDataInfo(platName);
        PlatformNameInformationDO companyInfo = p2PImageService.hasOrNotCompany(platName);
        if (content == null) {
            return ResponseBean.errorResponse(companyInfo);
        } else {
            return ResponseBean.successResponse(companyInfo);
        }
    }


    /**
     * 平台状态信息
     *
     * @return
     */
    @RequestMapping("/platFormStatus")
    @ResponseBody
    public ResponseBean platFormStatus(@RequestParam(required = true) String platName) {
        Map<String, Object> content = p2PImageService.platFormStatus(platName);
        if (null != content && content.size() != 0) {
            return ResponseBean.successResponse(content);
        } else {
            return ResponseBean.successResponse(null);
        }
    }

    /**
     * 平台舆情信息
     *
     * @return
     */
    @RequestMapping("/platFormConsensus")
    @ResponseBody
    public ResponseBean platformConsensus(@RequestParam(required = true) String platName) {
        YuQingDO content = p2PImageService.platformConsensus(platName);
        return ResponseBean.successResponse(content);
    }

    /**
     * 诉讼信息
     *
     * @return
     */
    @RequestMapping("/lawsuitMsg")
    @ResponseBody
    public ResponseBean lawsuitMsg(@RequestParam(required = true) String platName) {
        Map<String, Object> conent = p2PImageService.lawsuitMsg(platName);
        if (null != conent && conent.size() != 0) {
            return ResponseBean.successResponse(conent);
        } else {
            return ResponseBean.successResponse(null);
        }
    }

    /**
     * 雷达评分
     *
     * @return
     */
    @RequestMapping("/radarScore")
    @ResponseBody
    public ResponseBean radarScore(@RequestParam(required = true)String platName) {
        Map<String, Object> result = p2PImageService.radarScore(platName);
        RadarChartBean radarChart = new RadarChartBean<>();
        if (null != result && result.size() != 0) {
            radarChart.setIndicator(result.get("indicator"));
            radarChart.setSeries(result.get("series"));
            radarChart.setScore(result.get("sumScore"));
            radarChart.setCode(result.get("code"));
        } else {
            return ResponseBean.successResponse(null);
        }
        return ResponseBean.successResponse(radarChart);
    }

    /**
     * 基本信息
     *
     * @return
     */
    @RequestMapping("/baseInfo")
    @ResponseBody
    public ResponseBean baseInfo(@RequestParam(required = true)String platName) {
        Map<String, Object> content = p2PImageService.baseInfo(platName);
        if (null != content && content.size() != 0) {
            return ResponseBean.successResponse(content);
        } else {
            return ResponseBean.successResponse(null);
        }

    }

    /**
     * 核心数据 - 信息
     *
     * @return
     */
    @RequestMapping("/coreDataInfo")
    @ResponseBody
    public ResponseBean coreDataInfo(@RequestParam(required = true) String platName) {
        Map<String, Object> content = p2PImageService.coreDataInfo(platName);
        if (null != content && content.size() != 0) {
            return ResponseBean.successResponse(content);
        } else {
            return ResponseBean.successResponse(null);
        }
    }

    /**
     * 核心数据 - 平台成交量走势
     *
     * @return
     */
    @RequestMapping("/coreDataDealTrend")
    @ResponseBody
    public ResponseBean coreDataDealTrend(@RequestParam(required = true) String platName) {
        List<List<String>> data = p2PImageService.coreDataDealTrend(platName);
        HistogramBean<String, String> content = new HistogramBean();
        if (null != data && data.size() != 0) {
            content.setxAxis(data.get(0));
            content.setseries(data.get(1));
        } else {
            return ResponseBean.successResponse(null);
        }
        return ResponseBean.successResponse(content);
    }

    /**
     * 核心数据 - 平台利率走势
     *
     * @return
     */
    @RequestMapping("/coreDataInterestRateTrend")
    @ResponseBody
    public ResponseBean coreDataInterestRateTrend(@RequestParam(required = true) String platName) {
        List<List<String>> data = p2PImageService.coreDataInterestRateTrend(platName);
        HistogramBean<String, String> content = new HistogramBean();
        if (null != data && data.size() != 0) {
            content.setxAxis(data.get(0));
            content.setseries(data.get(1));
        } else {
            return ResponseBean.successResponse(null);
        }
        return ResponseBean.successResponse(content);
    }

    /**
     * 核心数据 - 贷款余额
     *
     * @return
     */
    @RequestMapping("/coreDataLoadOverage")
    @ResponseBody
    public ResponseBean coreDataLoadOverage(@RequestParam(required = true) String platName) {
        List<List<String>> data = p2PImageService.coreDataLoadOverage(platName);
        HistogramBean<String, String> content = new HistogramBean();
        if (null != data && data.size() != 0) {
            content.setxAxis(data.get(0));
            content.setseries(data.get(1));
        } else {
            return ResponseBean.successResponse(null);
        }
        return ResponseBean.successResponse(content);
    }

}
