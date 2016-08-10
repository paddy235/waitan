package com.bbd.wtyh.web.controller;


import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyAreaVO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyVO;
import com.bbd.wtyh.service.ExchangeCompanyService;

import com.bbd.wtyh.web.ResponseBean;
import org.apache.poi.ss.formula.functions.T;
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
 * 交易所
 * @author tracy zhou
 * @since  2016/8/10
 */
@Controller
@RequestMapping("/exchangeCompany")
public class ExchangeCompanyController {

    @Autowired
    private ExchangeCompanyService exchangeCompanyService;

    /**
     * 交易场所清理整顿分类统计
     * @return
     */
    @RequestMapping("/exchangeCompanyCategory")
    @ResponseBody
    public ResponseBean exchangeCompanyCategory() {
        List<Map> data = exchangeCompanyService.exchangeCompanyCategory();
        return ResponseBean.successResponse(data);
    }

    /**
     * 交易场所地域分布
     * @return
     */
    @RequestMapping("/exchangeCompanyArea")
    @ResponseBody
    public ResponseBean exchangeCompanyArea() {
        List<ExchangeCompanyAreaVO> data = exchangeCompanyService.exchangeCompanyArea();
        Map map = new HashMap();
        List<String> yAxis = new ArrayList<>();
        List<Long> series = new ArrayList<>();
        if (!CollectionUtils.isEmpty(data)) {
            for (int i=0; i<data.size(); i++) {
                ExchangeCompanyAreaVO exchangeCompanyAreaVO = data.get(i);
                yAxis.add(exchangeCompanyAreaVO.getName());
                series.add(exchangeCompanyAreaVO.getCount());
            }
        }
        map.put("yAxis", yAxis);
        map.put("series", series);
        return ResponseBean.successResponse(map);
    }

    /**
     * 查询不同状态的交易场所列表
     * 取得合规意见或经过会商的交易场所详细列表
     * @param status
     * @see
     * @return
     */
    @RequestMapping("/exchangeCompanyByStatus")
    @ResponseBody
    public ResponseBean exchangeCompanyByStatus(Integer status) {
        List<ExchangeCompanyVO> data = exchangeCompanyService.exchangeCompanyByStatus(status);
        return ResponseBean.successResponse(data);
    }

    /**
     * 按地区查询交易所列表
     * @param areaId
     * @return
     */
    @RequestMapping("/exchangeCompanyListByAreaId")
    @ResponseBody
    public ResponseBean exchangeCompanyListByAreaId(Integer areaId, String orderName, String orderType) {
        List<CompanyDO> data = exchangeCompanyService.exchangeCompanyListByAreaId(areaId, orderName, orderType);
        return ResponseBean.successResponse(data);
    }

}
