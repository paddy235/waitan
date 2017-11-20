package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.service.CompanyStaticRiskScoreService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by puyuan on 2017/11/20
 */
@RestController
@RequestMapping("/staticRisk")
public class CompanyStaticRiskScoreController {

    @Autowired
    private CompanyStaticRiskScoreService CompanyStaticRiskScoreService;

    @RequestMapping("/getStaticRiskScore.do")
    @ResponseBody
    public ResponseBean getCompanyStaticRiskScore() throws Exception {
        CompanyStaticRiskScoreService.getOffLineCompany();
        return null;
    }

}
