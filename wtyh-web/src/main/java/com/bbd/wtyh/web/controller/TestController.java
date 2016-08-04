package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.entity.Test;
import com.bbd.wtyh.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    // 获取数据
    @RequestMapping("/listData")
    @ResponseBody
    public Map<String, List> list() {

        List<Test> data = testService.list();
        Map<String, List> result = new HashMap<>();
        result.put("hello", data);
        return result;
    }
}
