package com.bbd.bgo.service.imp.handler.company.modify.validator;

/**
 * 类型校验器
 *
 * @author Created by LiYao on 2017-09-05 11:28.
 */
public interface RiskValueValidator extends RiskValueConverter {

    /**
     * 类型验证
     * 
     * @param type 类型
     * @return 错误信息。null则表示无错误。
     */
    String validate(String riskValue);
}
