package com.bbd.wtyh.web.controller;


import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.SysConfigService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/sysConfig")
public class SysConfigController {
    @Autowired
    private SysConfigService sysConfigService;


    @RequestMapping(value="/findByKey")
    @ResponseBody
    @LogRecord(logMsg = "网页链接")
    public ResponseBean findByKey(){
        return ResponseBean.successResponse(this.sysConfigService.findByKey("wzlj"));
    }



}
