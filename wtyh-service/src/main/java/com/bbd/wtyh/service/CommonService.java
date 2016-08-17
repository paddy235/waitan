package com.bbd.wtyh.service;

import com.bbd.data.mapper.OrderTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 公共接口
 *
 * @author wangchenge
 * @since 2016.08.16
 */
@Service("commonService")
public class CommonService {
    @Autowired
    private OrderTableMapper orderTableMapper;
    /**
     * 通过用户名和公司名判断产品套系
     * 订单已购买通过订单来判断套系
     * 订单未购买通过用户所属套系来判断
     *
     * @param loginName   loginName
     * @param companyName companyName
     * @return 套系
     */
    public String powerSet(String loginName, String companyName) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", loginName);
        params.put("companyName", companyName);
        return orderTableMapper.queryOrderLevel(params);
//		if(StringUtil.isNullOrEmpty(level))
//		{
        //OrderPO order =  orderTableMapper.queryOrder(params);
        //level = order.getLevel();
//		}
    }
}
