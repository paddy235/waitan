package com.bbd.bgo.service.imp.handler.company.modify.validator;


import com.bbd.wtyh.constants.JYSCoRiskLevel;
import org.apache.commons.lang3.StringUtils;

/**
 * 私募基金校验器
 */
public class PrivateFundValidator extends AbstractRiskValueValidator {

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

        return null;
    }
    @Override
    public String convertDigit(String riskValue) {
        if (StringUtils.isBlank(riskValue)) {
            return riskValue;
        }
        for (JYSCoRiskLevel level : JYSCoRiskLevel.values()) {
            if (level.desc().equals(riskValue)) {
                return level.type() + "";
            }
        }
        return riskValue;
    }
}
