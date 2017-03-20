package com.bbd.wtyh.web.controller;


import com.bbd.wtyh.service.LogInfoService;
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
@RequestMapping("/logInfo")
public class LogInfoController {

    @Autowired
    private LogInfoService logInfoService;

    @RequestMapping("/exportLogFile")
    @ResponseBody
    public Long exportLogFile(String date,Long counts ,HttpSession session){
        Long tempCounts=(null==counts)?new Long(1L):counts;
        return logInfoService.exportLogFileToDataBase(date,tempCounts);
    }

}
