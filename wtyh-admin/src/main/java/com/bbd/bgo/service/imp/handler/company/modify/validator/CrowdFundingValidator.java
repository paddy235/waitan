package com.bbd.bgo.service.imp.handler.company.modify.validator;

import org.apache.commons.lang3.StringUtils;

/**
 * 众筹校验器
 */
public class CrowdFundingValidator extends AbstractRiskValueValidator {

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
            return "众筹风险状态为不可填项，请删除";
        }
        return null;
    }
}
