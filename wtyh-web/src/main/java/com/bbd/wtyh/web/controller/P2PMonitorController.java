package com.bbd.wtyh.web.controller;

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



    // 获取数据
    @RequestMapping("/baseStatus")
    @ResponseBody
    public ResponseBean list() {

        Map<String, String> content = new HashMap<>();
        content.put("hello", "world");
        content.put("hello1", "wo1rld");
        content.put("hell", "wor2ld");
        ResponseBean result = ResponseBean.successResponse(content);

        return result;
    }
}
