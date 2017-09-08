package com.bbd.bgo.service.imp.handler.company.modify.validator;

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
        return null;
    }
}
