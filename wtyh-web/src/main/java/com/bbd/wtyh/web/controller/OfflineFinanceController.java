package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.util.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 线下理财
 * @author zhouxuan
 * @since 2016.08.05
 */
@Controller
@RequestMapping("/offlineFinance")
public class OfflineFinanceController {

    @Autowired
    private OfflineFinanceService offlineFinanceService;

    /**
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping("/relatedGraph")
    @ResponseBody
    public ResponseBean relatedGraph() {
        List<Map> data = offlineFinanceService.relatedGraph();
        Map<String, List> result = new HashMap<>();
        result.put("hello", data);
        return ResponseBean.successResponse(result);
    }
}
