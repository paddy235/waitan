package com.bbd.bgo.service.imp.handler.company.modify.validator;

import com.bbd.wtyh.constants.JYSCoRiskLevel;
import org.apache.commons.lang3.StringUtils;

/**
 * 交易场所校验器
 */
public class ExchangeValidator extends AbstractRiskValueValidator {

    private static String[] levelArray;
    static {
        JYSCoRiskLevel[] JYSCoRiskLevels = JYSCoRiskLevel.values();
        levelArray = new String[JYSCoRiskLevels.length];

        for (int i = 0; i < JYSCoRiskLevels.length; i++) {
            levelArray[i] = JYSCoRiskLevels[i].desc();
        }
    }

    @Override
    protected String[] riskDescArray() {

        return levelArray;
    }

    @Override
    protected String msgPrefix() {
        return getTypeName() + "风险状态";
    }

    public String getTypeName() {
        return "交易场所";
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
