package com.bbd.bgo.service.imp.handler.company.modify.validator;

import com.bbd.wtyh.constants.RZZLCoRiskLevel;
import org.apache.commons.lang3.StringUtils;

/**
 * 融资租赁校验器
 */
public class FinanceLeaseValidator extends AbstractRiskValueValidator {

    private static String[] levelArray;

    static {
        RZZLCoRiskLevel[] rzzlcorisklevels = RZZLCoRiskLevel.values();
        levelArray = new String[rzzlcorisklevels.length];

        for (int i = 0; i < rzzlcorisklevels.length; i++) {
            levelArray[i] = rzzlcorisklevels[i].desc();
        }
    }

    @Override
    protected String[] riskDescArray() {
        return levelArray;
    }

    @Override
    protected String msgPrefix() {
        return "融资租赁风险状态";
    }

    @Override
    public String convertDigit(String riskValue) {
        if (StringUtils.isBlank(riskValue)) {
            return riskValue;
        }
        for (RZZLCoRiskLevel level : RZZLCoRiskLevel.values()) {
            if (level.desc().equals(riskValue)) {
                return level.type() + "";
            }
        }
        return riskValue;
    }

}
