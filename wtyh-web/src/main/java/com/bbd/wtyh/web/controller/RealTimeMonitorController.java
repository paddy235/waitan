package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.service.P2PImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 实时监控页面
 *
 * @author yanwenyuan
 * @since 2016.08.13
 */
@Controller
@RequestMapping("/RealTimeMonitorController")
public class RealTimeMonitorController {
    @Autowired
    private P2PImageService p2PImageService;

}
