package com.bbd.bgo.service.imp.handler.company.modify;

import com.bbd.wtyh.constants.CompanyType;
import com.bbd.wtyh.constants.JYSCoRiskLevel;
import com.bbd.wtyh.constants.PrepaidCoRiskLevel;
import com.bbd.wtyh.constants.RZZLCoRiskLevel;
import com.bbd.wtyh.domain.enums.CompanyLevel;
import com.bbd.wtyh.domain.enums.WangDaiRiskLevel;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 提示语
 *
 * @author Created by LiYao on 2017-09-04 10:35.
 */
@SuppressWarnings("unused")
public class Clues {

    /**
     * 填写说明
     * 
     * @return 填写说明
     */
    @SuppressWarnings("StringBufferReplaceableByString")
    public static String writeExplain() {
        StringBuilder writeExplain = new StringBuilder();
        writeExplain.append("填写说明（请详细阅读）：\r\n");
        writeExplain.append("\r\n");
        writeExplain.append("1、本表格不可填写Excel公式；企业名称和变更后行业类别必填，不能超过40个汉字；\r\n");
        writeExplain.append("2、行业类别必填：").append(companyTypeLimit()).append("；\r\n");
        writeExplain.append("3、典当、众筹、私募基金、商业保理，风险状态栏为不填项，若填写将报错，无法录入；\r\n");
        writeExplain.append("4、小额贷款、融资担保风险状态：外部评级、内部评级、现场检查分三列填写，风险状态一列不可填写；\r\n");
        writeExplain.append("5、网络借贷只能选填一般关注、优良、重点关注、问题及停业平台，只填入风险状态一栏；\r\n");
        writeExplain.append("6、融资租赁只能选填正常、潜在，只填入风险状态一栏；\r\n");
        writeExplain.append("7、交易场所、线下理财只能选填一般关注、已出风险、正常、重点关注，只填入风险状态一栏；\r\n");
        writeExplain.append("8、预付卡只能选填正常、潜在、已发生，只填入风险状态一栏；\r\n");
        writeExplain.append("9、纯数字超过11将自动转换为科学计数法，请注意手动转换为文本；");
        return writeExplain.toString();
    }

    /**
     * 风险状态范围限制。适用于小额贷款、融资担保之外的风险状态
     * 
     * @return string 风险状态,以逗号分开
     */
    public static String riskLevelLimit() {
        Set<String> set = new HashSet<>();

        // 网络借贷
        WangDaiRiskLevel[] wangDaiRiskLevels = WangDaiRiskLevel.values();
        for (WangDaiRiskLevel level : wangDaiRiskLevels) {
            set.add(level.desc());
        }
        //融资租赁
        RZZLCoRiskLevel[] rzzlCoRiskLevels = RZZLCoRiskLevel.values();
        for (RZZLCoRiskLevel level : rzzlCoRiskLevels) {
            set.add(level.desc());
        }
        //交易场所、线下理财
        JYSCoRiskLevel[] jysCoRiskLevels = JYSCoRiskLevel.values();
        for (JYSCoRiskLevel level : jysCoRiskLevels) {
            set.add(level.desc());
        }
        //预付卡 
        PrepaidCoRiskLevel[] prepaidCoRiskLevels = PrepaidCoRiskLevel.values();
        for (PrepaidCoRiskLevel level : prepaidCoRiskLevels) {
            set.add(level.desc());
        }

        return StringUtils.join(set, ",");
    }

    /**
     * 企业评级范围限制。适用于小额贷款、融资担保
     *
     * @return string 企业评级,以逗号分开
     */
    public static String riskRatingLimit() {
        return CompanyLevel.allValues();
    }

    /**
     * 企业类型范围限制。
     *
     * @return string 企业类型,以逗号分开
     */
    public static String companyTypeLimit() {

        CompanyType[] companyTypes = CompanyType.values();
        String[] typeArray = new String[companyTypes.length - 2];

        int offset = 0;
        for (int i = 0; i < companyTypes.length; i++) {
            CompanyType type = companyTypes[i];
            if (type.equals(CompanyType.TYPE_JR_7) || type.equals(CompanyType.TYPE_QT_8)) {
                offset++;
                continue;
            }
            typeArray[i - offset] = type.desc();
        }
        return StringUtils.join(typeArray, ",");
    }
}
