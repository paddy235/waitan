package com.bbd.bgo.service.imp.handler.company.modify.validator;

import com.bbd.wtyh.constants.PrepaidCoRiskLevel;
import org.apache.commons.lang3.StringUtils;

/**
 * 预付卡校验器
 */
public class PrepaidValidator extends AbstractRiskValueValidator {

    private static String[] levelArray;
    static {
        PrepaidCoRiskLevel[] prepaidCoRiskLevels = PrepaidCoRiskLevel.values();
        levelArray = new String[prepaidCoRiskLevels.length];

        for (int i = 0; i < prepaidCoRiskLevels.length; i++) {
            levelArray[i] = prepaidCoRiskLevels[i].desc();
        }
    }

    @Override
    protected String[] riskDescArray() {
        return levelArray;
    }

    @Override
    protected String msgPrefix() {
        return "预付卡风险状态";
    }

    @Override
    public String convertDigit(String riskValue) {
        if (StringUtils.isBlank(riskValue)) {
            return riskValue;
        }
        for (PrepaidCoRiskLevel level : PrepaidCoRiskLevel.values()) {
            if (level.desc().equals(riskValue)) {
                return level.type() + "";
            }
        }
        return riskValue;
    }
}
