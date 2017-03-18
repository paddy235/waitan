package com.bbd.wtyh.web.controller;


import com.bbd.wtyh.domain.vo.FinanceLeaseVO;
import com.bbd.wtyh.domain.vo.FinanceLeasecCompanyVO;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.FinanceLeaseService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 融资租赁
 * @author tracy zhou
 * @since  2016/8/10
 */
@Controller
@RequestMapping("/financeLease/")
public class FinanceLeaseController {

    @Autowired
    private FinanceLeaseService financeLeaseService;

    /**
     * 上海市融资租赁企业数
     * @return
     */
    @RequestMapping("leaseCompanyStatistic.do")
    @ResponseBody
    @LogRecord(logMsg = "浏览融资租赁页面",page = Operation.Page.financeLease)
    public ResponseBean leaseCompanyStatistic() {
//        Map data = financeLeaseService.leaseCompanyStatistic();
//        return ResponseBean.successResponse(data);
        // 上面是把周旋的注释了，下面是我加的
        Object data = financeLeaseService.companysAndMoney();
        return ResponseBean.successResponse(data);
    }


    /**
     * 上海市自贸区融资租赁企业占比对比
     * @return
     */
    @RequestMapping("leaseCompanyCategory.do")
    @ResponseBody
    public ResponseBean leaseCompanyCategory(Integer year) {
        Map data = financeLeaseService.leaseCompanyCategory(year);
        return ResponseBean.successResponse(data);


    }

    /**
     * 上海市融资租赁企业目录
     * @return
     */
    @RequestMapping("leaseCompanyList.do")
    @ResponseBody
    public ResponseBean leaseCompanyList(String areaName, Integer analysisResult, Integer riskA, Integer riskB, Integer riskC, Integer riskD) {
        if(riskA!=null || riskB!=null || riskC!=null || riskD!=null){
            analysisResult = 1;
        }
        List<FinanceLeasecCompanyVO> list = financeLeaseService.leaseCompanyList(areaName, analysisResult, riskA, riskB, riskC, riskD);
        return ResponseBean.successResponse(list);
    }

    /**
     * 获取年的记录
     * @return
     */
    @RequestMapping("getYears.do")
    @ResponseBody
    public ResponseBean getYears() {
        List<String> list = financeLeaseService.getYears();
        return ResponseBean.successResponse(list);
    }

}
