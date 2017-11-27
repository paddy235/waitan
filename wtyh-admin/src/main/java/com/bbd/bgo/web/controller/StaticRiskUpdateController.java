package com.bbd.bgo.web.controller;

import com.bbd.bgo.service.task.StaticRiskUpdateService;
import com.bbd.wtyh.service.CompanyStaticRiskScoreService;
import com.bbd.wtyh.service.UpdateWhiteCompanyRiskGradeService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private UpdateWhiteCompanyRiskGradeService updateWhiteCompanyRiskGradeService;

    @RequestMapping("/updateStaticRiskScore.do")
    @ResponseBody
    public ResponseBean getCompanyStaticRiskScore(@RequestParam("dataVersion") String dataVersion) throws Exception {
       staticRiskUpdateService.updateOldStaticRiskAutomaticOperate(dataVersion);
       //staticRiskUpdateService.updateStaticRiskManualOperate(100,101);
        return null;
    }

    //更新5万家白名单
    @RequestMapping("/startUpdate.do")
    @ResponseBody
    public ResponseBean updateWhiteCompanyRiskGradeService() throws Exception {
        updateWhiteCompanyRiskGradeService.startUpdate();
        return null;
    }

}
