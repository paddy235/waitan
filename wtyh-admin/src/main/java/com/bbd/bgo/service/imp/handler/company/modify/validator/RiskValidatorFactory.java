package com.bbd.bgo.service.imp.handler.company.modify.validator;

import com.bbd.wtyh.constants.CompanyType;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static com.bbd.wtyh.constants.CompanyType.*;

/**
 * 类型校验器工厂类
 *
 * @author Created by LiYao on 2017-09-05 16:58.
 */
public class RiskValidatorFactory {

    private static Map<String, RiskValueValidator> validatorMap;

    static {
        validatorMap = new HashMap<>();
        CompanyType[] companyTypes = values();
        for (CompanyType type : companyTypes) {
            if (type.equals(TYPE_JR_7) || type.equals(TYPE_QT_8)) {
                continue;
            }
            validator(type.desc());
        }

    }

    public static RiskValueValidator validator(String compamyType) {
        if (StringUtils.isBlank(compamyType)) {
            return null;
        }
        RiskValueValidator validator = validatorMap.get(compamyType);
        if (validator != null) {
            return validator;
        }

        if (TYPE_P2P_1.desc().equals(compamyType)) {
            validator = new P2PValidator();
            validatorMap.put(compamyType, validator);
            return validator;
        }
        if (TYPE_XD_2.desc().equals(compamyType)) {
            validator = new PettyLoanValidator();
            validatorMap.put(compamyType, validator);
            return validator;
        }
        if (TYPE_RZDB_3.desc().equals(compamyType)) {
            validator = new GuaranteeValidator();
            validatorMap.put(compamyType, validator);
            return validator;
        }
        if (TYPE_XXLC_4.desc().equals(compamyType)) {
            validator = new OfflineFinanceValidator();
            validatorMap.put(compamyType, validator);
            return validator;
        }
        if (TYPE_SMJJ_5.desc().equals(compamyType)) {
            validator = new PrivateFundValidator();
            validatorMap.put(compamyType, validator);
            return validator;
        }
        if (TYPE_ZC_6.desc().equals(compamyType)) {
            validator = new CrowdFundingValidator();
            validatorMap.put(compamyType, validator);
            return validator;
        }
        if (TYPE_JYS_9.desc().equals(compamyType)) {
            validator = new ExchangeValidator();
            validatorMap.put(compamyType, validator);
            return validator;
        }
        if (TYPE_SYBL_10.desc().equals(compamyType)) {
            validator = new FactoringValidator();
            validatorMap.put(compamyType, validator);
            return validator;
        }
        if (TYPE_YFK_11.desc().equals(compamyType)) {
            validator = new PrepaidValidator();
            validatorMap.put(compamyType, validator);
            return validator;
        }
        if (TYPE_DD_12.desc().equals(compamyType)) {
            validator = new MortgageValidator();
            validatorMap.put(compamyType, validator);
            return validator;
        }
        if (TYPE_RZZL_13.desc().equals(compamyType)) {
            validator = new FinanceLeaseValidator();
            validatorMap.put(compamyType, validator);
            return validator;
        }

        return null;
    }

}
