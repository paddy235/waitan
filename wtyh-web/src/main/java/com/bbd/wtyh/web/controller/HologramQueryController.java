package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.service.HologramQueryService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 企业全息信息查询平台控制层
 *
 * @author wangchenge
 * @since 2016.08.09
 */
@Controller
@RequestMapping("/Hologram")
public class HologramQueryController {

    @Autowired
    private HologramQueryService hologramQueryService;

    /**
     * 信息查询平台搜索
     *
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public ResponseBean search() {
        Map<String, Object> result = hologramQueryService.search();
        return ResponseBean.successResponse(result);
    }

    /**
     * 信息查询平台导航栏
     *
     * @return
     */
    @RequestMapping("/guidance")
    @ResponseBody
    public ResponseBean guidance() {
        Map<String, Object> result = hologramQueryService.guidance();
        return ResponseBean.successResponse(result);
    }

    /**
     * 新闻舆情
     *
     * @return
     */
    @RequestMapping("/newsConsensus")
    @ResponseBody
    public ResponseBean newsConsensus() {
        Map<String, Object> result = hologramQueryService.newsConsensus();
        return ResponseBean.successResponse(result);
    }

}
