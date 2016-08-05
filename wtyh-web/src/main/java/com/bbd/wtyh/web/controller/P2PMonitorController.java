package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.service.P2PMonitorService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/P2PMonitor")
public class P2PMonitorController {
    @Autowired
    private P2PMonitorService p2PMonitorService;

    //平台状态信息
    @RequestMapping("/baseStatus")
    @ResponseBody
    public ResponseBean baseStatus() {
        Map<String , Object> content = p2PMonitorService.platFormStatus();
        return ResponseBean.successResponse(content);
    }
    //平台舆情信息
    @RequestMapping("/baseConsensus")
    @ResponseBody
    public ResponseBean baseConsensus(){
        Map<String , Object> content = p2PMonitorService.platFormConsensus();
        return ResponseBean.successResponse(content);
    }
    //诉讼信息
    @RequestMapping("/baselawsuit")
    @ResponseBody
    public ResponseBean baselawsuit(){
        Map<String , Object> conent = p2PMonitorService.lawsuitMsg();
        return ResponseBean.successResponse(conent);
    }
    //雷达评分
    @RequestMapping("/radarScore")
    @ResponseBody
    public ResponseBean radarScore(){
        Map<String , Object> score = p2PMonitorService.radarScore();
        return ResponseBean.successResponse(score);
    }

}
