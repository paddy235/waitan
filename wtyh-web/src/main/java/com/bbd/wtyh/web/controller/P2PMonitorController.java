package com.bbd.wtyh.web.controller;

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



    // 获取数据
    @RequestMapping("/baseStatus")
    @ResponseBody
    public Map<String, String> list() {

//        List<Test> data = testService.list();
        Map<String, String> result = new HashMap<>();
        result.put("hello", "world");
        result.put("hello", "world");
        result.put("hello", "world");
        return result;
    }
}
