package com.bbd.wtyh.web.controller;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

import com.bbd.higgs.utils.StringUtils;
import com.bbd.wtyh.constants.CreditType;
import com.bbd.wtyh.domain.dto.CompanyCreditRawInfoDTO;
import com.bbd.wtyh.domain.dto.CreditInfoDTO;
import com.bbd.wtyh.domain.dto.CreditRiskDataDTO;
import com.bbd.wtyh.service.CoCreditScoreService;
import com.bbd.wtyh.web.PageBean;
import com.bbd.wtyh.web.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公信数据展示
 *
 * @author sunliming
 * @since 2017.10.09
 */
@Controller
@RequestMapping("/creditData")
public class CreditDataController {

    Logger logger = LoggerFactory.getLogger(CreditDataController.class);

    @Autowired
    private CoCreditScoreService coCreditScoreService;

    /**
     * 公信数据统计
     *
     * @return
     */
    @RequestMapping("/countCreditData.do")
    @ResponseBody
    public ResponseBean countInvestigation(@RequestParam String companyName) throws Exception {
        Map<String, Integer> result = new HashMap<>();
        List<CreditRiskDataDTO> list=coCreditScoreService.getResourceCounts(null,companyName);
        int total=0;
        for (CreditRiskDataDTO creditRiskDataDTO:list){
            int count = creditRiskDataDTO.getCounts()==null?0:creditRiskDataDTO.getCounts();
            String type=CreditType.type(creditRiskDataDTO.getResourceName());
            if(null != type){
                result.put(type,count);
            }
            total+=count;
        }
        result.put("total",total);
        return ResponseBean.successResponse(result);
    }

    /**
     * 公信数据展示
     *
     * @return
     */
    @RequestMapping("/getCreditData.do")
    @ResponseBody
    public ResponseBean getCreditData(String companyName, String dataType, PageBean pageBean, HttpServletRequest request) throws Exception {
        if (org.apache.commons.lang3.StringUtils.isEmpty(companyName)) {
            return ResponseBean.errorResponse("请输入公司名称");
        }

        dataType=CreditType.desc(dataType);

        if (org.apache.commons.lang3.StringUtils.isEmpty(dataType)) {
            return ResponseBean.errorResponse("请输入数据类型");
        }

        List<CompanyCreditRawInfoDTO> list = coCreditScoreService.getCreditInfoByCompanyAndType(companyName, dataType, pageBean);
        Map<String, Object> result = new HashMap<>();
        result.put("data", list);
        result.put("total", pageBean.getTotalCount());
        return ResponseBean.successResponse(result);
    }
}
