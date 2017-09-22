package com.bbd.bgo.service.imp.handler.company.modify.validator;

import org.apache.commons.lang3.StringUtils;

/**
 * 典当校验器
 */
public class MortgageValidator extends AbstractRiskValueValidator {

    // do nothing
    @Override
    protected String[] riskDescArray() {
        return null;
    }

    @Override
    protected boolean contains(String riskValue) {
        return true;
    }

    @Override
    protected String msgPrefix() {
        return null;
    }

    @Override
    public String validate(String riskValue) {
        if (StringUtils.isNotBlank(riskValue)) {
            return "典当风险状态为不可填项，请删除";
        }
        return null;
    }
}
