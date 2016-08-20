package com.bbd.wtyh.web.controller;


import com.bbd.wtyh.domain.vo.FinanceLeasecCompanyVO;
import com.bbd.wtyh.service.FinanceLeaseService;
import com.bbd.wtyh.service.SyncDataService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Set;

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

    @RequestMapping(value = "/receiveData")
    public ResponseBean getScanner(@RequestParam(required = false) String syncData) {

        String string = syncDataService.receiveData(syncData);

        return ResponseBean.successResponse("");
    }

}
