package com.bbd.bgo.service.imp.handler.company.modify.validator;

/**
 * 类型校验器
 *
 * @author Created by LiYao on 2017-09-05 11:28.
 */
public interface RiskValueConverter {

    /**
     * 将中文转为对应的数字。网贷例外，保留中文
     * 
     * @param riskValue
     * @return
     */
    String convertDigit(String riskValue);
}
