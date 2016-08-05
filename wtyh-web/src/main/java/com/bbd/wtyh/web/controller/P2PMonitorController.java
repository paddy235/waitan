package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.service.P2PMonitorService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/P2PMonitor")
public class P2PMonitorController {
    @Autowired
    private P2PMonitorService p2PMonitorService;
    // 获取数据
    @RequestMapping("/baseStatus")
    @ResponseBody
    public ResponseBean list() {
        Map<String , Object> content = p2PMonitorService.platFormName();
        return ResponseBean.successResponse(content);
    }
}
