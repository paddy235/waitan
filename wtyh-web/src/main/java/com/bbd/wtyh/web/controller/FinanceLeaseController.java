package com.bbd.wtyh.web.controller;


import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.FinanceLeaseStatisticDO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyAreaVO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyVO;
import com.bbd.wtyh.service.ExchangeCompanyService;
import com.bbd.wtyh.service.FinanceLeaseService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 融资租赁
 * @author tracy zhou
 * @since  2016/8/10
 */
@Controller
@RequestMapping("/financeLease")
public class FinanceLeaseController {

    @Autowired
    private FinanceLeaseService financeLeaseService;

    /**
     * 自贸区融资租赁企业占比对比
     * @return
     */
    @RequestMapping("/leaseCompanyCategory")
    @ResponseBody
    public ResponseBean leaseCompanyCategory(Integer year) {
        Map data = financeLeaseService.leaseCompanyCategory(year);
        return ResponseBean.successResponse(data);
    }

    /**
     * 自贸区融资租赁企业余额和资产总额
     * @return
     */
    @RequestMapping("/leaseCompanyAmount")
    @ResponseBody
    public ResponseBean leaseCompanyAmount() {
        List<FinanceLeaseStatisticDO> list = financeLeaseService.leaseCompanyAmount();
        return ResponseBean.successResponse(list);
    }

    /**
     * 自贸区融资租赁企业业务发生额和不良率
     * @return
     */
    @RequestMapping("/leaseCompanyBadRatioAndAmount")
    @ResponseBody
    public ResponseBean leaseCompanyBadRatioAndAmount() {
        Map map = financeLeaseService.leaseCompanyBadRatioAndAmount();
        return ResponseBean.successResponse(map);
    }


}
