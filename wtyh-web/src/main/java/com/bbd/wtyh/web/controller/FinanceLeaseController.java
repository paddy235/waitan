package com.bbd.wtyh.web.controller;


import com.bbd.wtyh.domain.CompanyDO;
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
     * 交易场所清理整顿分类统计
     * @return
     */
    @RequestMapping("/exchangeCompanyCategory")
    @ResponseBody
    public ResponseBean exchangeCompanyCategory() {
        List<Map> data = financeLeaseService.exchangeCompanyCategory();
        return ResponseBean.successResponse(data);
    }

}
