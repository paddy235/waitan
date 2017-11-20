package com.bbd.bgo.web.controller;

import com.bbd.bgo.service.task.StaticRiskUpdateService;
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
public class StaticRiskUpdateController {

    @Autowired
    private StaticRiskUpdateService staticRiskUpdateService;

    @RequestMapping("/updateStaticRiskScore.do")
    @ResponseBody
    public ResponseBean getCompanyStaticRiskScore() throws Exception {
       staticRiskUpdateService.updateStaticRiskAutomaticOperate(100);
        return null;
    }

}
