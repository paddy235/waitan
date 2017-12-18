package com.bbd.bgo.web.controller;

import com.bbd.bgo.service.task.PABSentimentTaskService;
import com.bbd.bgo.service.task.StaticRiskUpdateService;
import com.bbd.bgo.service.task.SyncFileService;
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

    @Autowired
    private SyncFileService syncFileService;

    @Autowired
    private PABSentimentTaskService pABSentimentTaskService;

    @RequestMapping("/updateStaticRiskScore.do")
    @ResponseBody
    public ResponseBean getCompanyStaticRiskScore(@RequestParam("dataVersion") String dataVersion) throws Exception {
       //staticRiskUpdateService.updateOldStaticRiskAutomaticOperate(dataVersion);
       staticRiskUpdateService.updateStaticRiskManualOperate(1290,1291);
        return null;
    }

    //更新5万家白名单
    @RequestMapping("/startUpdate.do")
    @ResponseBody
    public ResponseBean updateWhiteCompanyRiskGradeService() throws Exception {
        updateWhiteCompanyRiskGradeService.startUpdate();
        return null;
    }


    //拉取线下理财数据
    @RequestMapping("/pullFile.do")
    @ResponseBody
    public ResponseBean pullFile() throws Exception {
        syncFileService.pullFile(100);
        return null;
    }

    //新增园区舆情表数据
    @RequestMapping("/saveParkPublicSentiment.do")
    @ResponseBody
    public ResponseBean saveParkPublicSentiment() throws Exception {
        pABSentimentTaskService.saveParkPublicSentiment();
        return null;
    }

    //新增楼宇舆情表数据
    @RequestMapping("/saveBuildingPublicSentiment.do")
    @ResponseBody
    public ResponseBean saveBuildingPublicSentiment() throws Exception {
        pABSentimentTaskService.saveBuildingPublicSentiment();
        return null;
    }

}
