package com.bbd.bgo.web.controller;


import com.bbd.bgo.service.task.LogInfoTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 日志信息维护
 * @author sunliming
 * @since  2017/03/20
 */
@RestController
@RequestMapping("/adminLogInfo")
public class AdminLogInfoController {

    @Autowired
    private LogInfoTaskService logInfoTaskService;
    @RequestMapping("/exportLogFile")
    @ResponseBody
    public void exportLogFile(String operDate){
        logInfoTaskService.exportLogFile(operDate);
    }

}
