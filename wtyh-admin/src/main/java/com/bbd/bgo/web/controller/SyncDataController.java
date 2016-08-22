package com.bbd.bgo.web.controller;


import com.bbd.wtyh.service.SyncDataService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 数据同步
 * @author tracy zhou
 * @since  2016/8/20
 */
@Controller
@RequestMapping("/syncData/")
public class SyncDataController {

    @Autowired
    private SyncDataService syncDataService;

    @RequestMapping(value = "receiveData.do")
    @ResponseBody
    public ResponseBean getScanner(@RequestParam(required = false) String syncData) {
        String string = syncDataService.receiveData(syncData);
        return ResponseBean.successResponse(string);
    }

}
