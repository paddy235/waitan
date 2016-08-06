package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.service.P2PMonitorService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * p2p行业检测平台控制层
 *
 * @author wangchenge
 * @since 2016.08.05
 */
@Controller
@RequestMapping("/P2PMonitor")
public class P2PMonitorController {
    @Autowired
    private P2PMonitorService p2PMonitorService;

    /**
     * 平台状态信息
     *
     * @return
     */
    @RequestMapping("/platFormStatus")
    @ResponseBody
    public ResponseBean platFormStatus() {
        Map<String, Object> content = p2PMonitorService.platFormStatus();
        return ResponseBean.successResponse(content);
    }

    /**
     * 平台舆情信息
     *
     * @return
     */
    @RequestMapping("/platFormConsensus")
    @ResponseBody
    public ResponseBean platFormConsensus() {
        Map<String, Object> content = p2PMonitorService.platFormConsensus();
        return ResponseBean.successResponse(content);
    }

    /**
     * 诉讼信息
     *
     * @return
     */
    @RequestMapping("/lawsuitMsg")
    @ResponseBody
    public ResponseBean lawsuitMsg() {
        Map<String, Object> conent = p2PMonitorService.lawsuitMsg();
        return ResponseBean.successResponse(conent);
    }

    /**
     * 雷达评分
     *
     * @return
     */
    @RequestMapping("/radarScore")
    @ResponseBody
    public ResponseBean radarScore() {
        Map<String, Object> score = p2PMonitorService.radarScore();
        return ResponseBean.successResponse(score);
    }

    /**
     * 平台状态信息
     *
     * @return
     */
    @RequestMapping("/baseInfo")
    @ResponseBody
    public ResponseBean baseInfo() {
        Map<String, String> content = p2PMonitorService.baseInfo();
        return ResponseBean.successResponse(content);
    }
}
