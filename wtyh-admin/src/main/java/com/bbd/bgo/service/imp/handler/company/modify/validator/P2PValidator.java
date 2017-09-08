package com.bbd.bgo.service.imp.handler.company.modify.validator;

import com.bbd.wtyh.domain.enums.WangDaiRiskLevel;

/**
 * 网络借贷校验器
 */
public class P2PValidator extends AbstractRiskValueValidator {

    private static String[] levelArray;
    static {
        WangDaiRiskLevel[] wangDaiRiskLevels = WangDaiRiskLevel.values();
        levelArray = new String[wangDaiRiskLevels.length];

        for (int i = 0; i < wangDaiRiskLevels.length; i++) {
            levelArray[i] = wangDaiRiskLevels[i].desc();
        }
    }

    @Override
    protected String[] riskDescArray() {

        return levelArray;
    }

    @Override
    protected String msgPrefix() {
        return "网络借贷风险状态";
    }

    @Override
    public String convertDigit(String riskValue) {
        return riskValue;
    }
}
