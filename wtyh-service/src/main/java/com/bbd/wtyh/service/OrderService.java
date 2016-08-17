package com.bbd.wtyh.service;

import com.bbd.data.mapper.OrderTable;
import com.bbd.data.mapper.OrderTableMapper;
import com.bbd.wtyh.domain.vo.OrderPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangchenge
 * @since 2016.08.16
 */
@Service("showOrderService")
public class OrderService {
    @Autowired
    private OrderTableMapper orderTableMapper;

    public OrderPO queryOrder(String companyName, String username) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("companyName", companyName);
        params.put("username", username);
        OrderPO orderPO = orderTableMapper.queryOrder(params);
        return orderPO;
    }

    public OrderTable getOrderTableBySurveyFirmNameAndCustomerId(String companyName, String loginName) {
        OrderTable orderTable = new OrderTable();
        orderTable.setSurveyFirmName(companyName);
        orderTable.setCustomerId(loginName);
        OrderTable order = orderTableMapper.getOrderTableBySurveyFirmNameAndCustomerId(orderTable);
        return order;
    }


}
