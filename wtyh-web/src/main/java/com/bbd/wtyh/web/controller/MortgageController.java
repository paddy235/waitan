package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.service.MortgageService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Marco on 2016/8/10.
 */
@RestController
@RequestMapping("/mortgage/")
public class MortgageController {

    @Autowired
    private MortgageService mortgageService;


    /**
     * 典当统计，按年统计
     * @return
     */
    @RequestMapping("statisticList")
    public ResponseBean staticticList() {
        return ResponseBean.successResponse(mortgageService.getMortgageStatisticList());
    }


}
