package com.bbd.data.mapper;

import com.bbd.wtyh.domain.vo.OrderPO;
import org.springframework.stereotype.Component;
import java.util.Map;

/**
 * @author wangchenge
 * @since 2016.08.16
 */
@Component
public interface OrderTableMapper {
    /**
     * 此方法为根据用户名和公司名称查询订单信息
     *
     * @param params
     * @return
     */
    public OrderPO queryOrder(Map<String, Object> params);
    /**
     * 查询用户已购买订单套系
     *
     * @param params
     * @return
     */
    public String queryOrderLevel(Map<String, Object> params);
    /**
     * 通过SurveyFirmName和CustomerId返回OrderTable记录
     *
     * @param order
     * @return
     */
    public OrderTable getOrderTableBySurveyFirmNameAndCustomerId(OrderTable order);
}
