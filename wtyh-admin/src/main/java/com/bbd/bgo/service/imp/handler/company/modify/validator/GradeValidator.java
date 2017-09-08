package com.bbd.bgo.service.imp.handler.company.modify.validator;

import com.bbd.wtyh.domain.enums.CompanyLevel;
import org.apache.commons.lang3.StringUtils;

/**
 * 评级校验器。用于处理外部评级，内部评级，现场检查
 *
 * @author Created by LiYao on 2017-09-05 16:22.
 */
public abstract class GradeValidator extends AbstractRiskValueValidator {

    private static String[] levelArray;
    private static String msg;

    static {
        CompanyLevel[] companyLevels = CompanyLevel.values();
        levelArray = new String[companyLevels.length];
        for (int i = 0; i < levelArray.length; i++) {
            levelArray[i] = companyLevels[i].getValue();
        }
        msg = StringUtils.join(levelArray, ",");
    }

    @Override
    protected String[] riskDescArray() {
        return levelArray;
    }

    @Override
    protected String msgPrefix() {
        return null;
    }

    @Override
    @Deprecated
    public String validate(String riskValue) {
        return null;
    }

    @Override
    public String convertDigit(String riskValue) {
        if (StringUtils.isBlank(riskValue)) {
            return riskValue;
        }
        for (CompanyLevel level : CompanyLevel.values()) {
            if (level.getValue().equals(riskValue)) {
                return level.ordinal() + "";
            }
        }
        return riskValue;
    }

    public String validateOutLevel(String level) {
        if (contains(level)) {
            return null;
        }
        return getTypeName() + "外部评级应从[" + msg + "]中取值";
    }

    public String validateInnerLevel(String level) {
        if (contains(level)) {
            return null;
        }
        return getTypeName() + "内部评级应从[" + msg + "]中取值";
    }

    public String validateLiveLevel(String level) {
        if (contains(level)) {
            return null;
        }
        return getTypeName() + "现场检查应从[" + msg + "]中取值";
    }

    public abstract String getTypeName();

}
