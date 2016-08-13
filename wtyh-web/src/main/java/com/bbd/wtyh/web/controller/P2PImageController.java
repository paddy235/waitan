package com.bbd.wtyh.web.controller;

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
     * 平台状态信息
     *
     * @return
     */
    @RequestMapping("/platFormStatus")
    @ResponseBody
    public ResponseBean platFormStatus(@RequestParam(required = true) String platName) {
        Map<String, Object> content = p2PImageService.platFormStatus(platName);
        return ResponseBean.successResponse(content);
    }

    /**
     * 平台舆情信息
     *
     * @return
     */
    @RequestMapping("/platFormConsensus")
    @ResponseBody
    public ResponseBean platformConsensus(@RequestParam(required = true, value = "plat_name") String platName) {
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
    public ResponseBean lawsuitMsg(@RequestParam(required = true) String company) {
        //TODO 公司名称乱码
        Map<String, Object> conent = p2PImageService.lawsuitMsg(company);
        return ResponseBean.successResponse(conent);
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
        if (result.size() != 0) {
            radarChart.setIndicator(result.get("indicator"));
            radarChart.setSeries(result.get("series"));
            radarChart.setScore(result.get("sumScore"));
            radarChart.setCode(result.get("code"));
        }
        return ResponseBean.successResponse(radarChart);
    }


    /**
     * 测试是否有”搜索公司“
     *
     * @return
     */
    @RequestMapping("/hasOrNotCompany")
    @ResponseBody
    public ResponseBean hasOrNotCompany(@RequestParam(required = true) String plat_name) {
        SearchCompanyDO content = p2PImageService.hasOrNotCompany(plat_name);
        if (StringUtils.isNotNullOrEmpty(content.getCompany_name())) {
            return ResponseBean.errorResponse(content);
        } else {
            return ResponseBean.successResponse(content);
        }
    }


    /**
     * 基本信息
     *
     * @return
     */
    @RequestMapping("/baseInfo")
    @ResponseBody
    public ResponseBean baseInfo(@RequestParam(required = true) String companyName, String akId , String platName) {
        // TODO: code review
//        String companyName = "攀枝花市交通旅游客运有限责任公司";
//        String akId = "0516d1c0db8d5cd1933cc2442c9f8d40";
//        String platName = "陆金所";
        //明天来修改，添加平台名称，和企业名称
        Map<String, Object> content = p2PImageService.baseInfo(companyName, akId , platName);
        return ResponseBean.successResponse(content);
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
        return ResponseBean.successResponse(content);
    }

    /**
     * 核心数据 - 平台成交量走势
     *
     * @return
     */
    @RequestMapping("/coreDataDealTrend")
    @ResponseBody
    public ResponseBean coreDataDealTrend(@RequestParam(required = true) String plat_name) {
        List<List<String>> data = p2PImageService.coreDataDealTrend(plat_name);
        HistogramBean<String, String> content = new HistogramBean();
        if (data.size() != 0) {
            content.setxAxis(data.get(0));
            content.setseries(data.get(1));
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
    public ResponseBean coreDataInterestRateTrend(@RequestParam(required = true) String plat_name) {
        List<List<String>> data = p2PImageService.coreDataInterestRateTrend(plat_name);
        HistogramBean<String, String> content = new HistogramBean();
        if (data.size() != 0) {
            content.setxAxis(data.get(0));
            content.setseries(data.get(1));
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
    public ResponseBean coreDataLoadOverage(@RequestParam(required = true) String plat_name) {
        List<List<String>> data = p2PImageService.coreDataLoadOverage(plat_name);
        HistogramBean<String, String> content = new HistogramBean();
        if (data.size() != 0) {
            content.setxAxis(data.get(0));
            content.setseries(data.get(1));
        }
        return ResponseBean.successResponse(content);
    }

    /**
     * 关联方图谱
     *
     * @return
     */
    @RequestMapping("/relativeChart")
    @ResponseBody
    public ResponseBean relativeChart() {
        // TODO
//        List<List<String>> data = p2PImageService.coreDataDealTrend();
//        return ResponseBean.successResponse(data);
        return null;
    }
}
