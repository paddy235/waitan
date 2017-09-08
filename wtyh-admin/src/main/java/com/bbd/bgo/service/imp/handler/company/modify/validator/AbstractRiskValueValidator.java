package com.bbd.bgo.service.imp.handler.company.modify.validator;

import org.apache.commons.lang3.StringUtils;

public abstract class AbstractRiskValueValidator implements RiskValueValidator {

    private String[] levelArray = null;
    private String msg = null;

    protected AbstractRiskValueValidator() {
        String[] riskDescArray = riskDescArray();
        if (riskDescArray == null) {
            return;
        }
        levelArray = riskDescArray;
        msg = "应从[" + StringUtils.join(levelArray, ",") + "]中取值";
    }

    protected abstract String[] riskDescArray();

    protected boolean contains(String riskValue) {
        if (StringUtils.isBlank(riskValue)) {
            return true;
        }
        if (levelArray == null) {
            return true;
        }
        for (String levelDesc : levelArray) {
            if (levelDesc.equals(riskValue)) {
                return true;
            }
        }
        return false;
    }

    protected abstract String msgPrefix();

    @Override
    public String validate(String riskValue) {

        if (StringUtils.isBlank(riskValue)) {
            return null;
        }
        if (contains(riskValue)) {
            return null;
        } else {
            return msgPrefix() + msg;
        }
    }

    @Override
    public String convertDigit(String riskValue) {
        return riskValue;
    }
}
