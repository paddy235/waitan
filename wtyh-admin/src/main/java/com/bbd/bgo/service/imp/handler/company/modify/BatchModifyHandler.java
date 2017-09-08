package com.bbd.bgo.service.imp.handler.company.modify;

import com.bbd.bgo.service.imp.handler.CompanyLevelHandler;
import com.bbd.bgo.service.imp.handler.assist.CompanyImportAssist;
import com.bbd.bgo.service.imp.handler.company.modify.validator.GradeValidator;
import com.bbd.bgo.service.imp.handler.company.modify.validator.RiskValidatorFactory;
import com.bbd.bgo.service.imp.handler.company.modify.validator.RiskValueConverter;
import com.bbd.bgo.service.imp.handler.company.modify.validator.RiskValueValidator;
import com.bbd.wtyh.constants.CompanyType;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.dto.CoBatchModifyDTO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.CompanyInfoModifyService;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 企业批量变更
 *
 * @author Created by LiYao on 2017-09-04 9:45.
 */
@Component
@Scope("prototype")
public class BatchModifyHandler extends AbstractImportHandler<CoBatchModifyDTO> {

    private Logger log = LoggerFactory.getLogger(CompanyLevelHandler.class);
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyInfoModifyService companyInfoModify;

    private List<ModifyData> modifyDataList = new ArrayList<>();
    private List<CompanyDO> updateList = new ArrayList<>();
    private List<CompanyDO> insertList = new ArrayList<>();

    @Override
    public void start(HttpServletRequest request) throws Exception {
        log.info("处理企业批量变更数据开始");
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {
    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        String companyType = row.get("companyType");
        CompanyType typeEnum = CompanyType.companyType(companyType);
        if (!validateType(typeEnum)) {
            return false;
        }
        row.put("companyType", typeEnum.type().toString());

        if (!validateRisk(typeEnum, row)) {
            return false;
        }
        // 风险状态中文转为数字，网贷除外，保留中文
        convertDigit(typeEnum, row);

        String companyName = row.get("companyName");
        String creditCode = row.get("creditCode");
        String organizationCode = row.get("organizationCode");
        CompanyDO companyDO = validateCompanyCode(companyName, typeEnum, creditCode, organizationCode);
        return companyDO != null;
    }

    @Override
    public void endRow(Map<String, String> row, CoBatchModifyDTO bean) throws Exception {
        ModifyData modifyData = new ModifyData();
        modifyData.setName(bean.getCompanyName());
        modifyData.setIndustry(bean.getCompanyType());
        modifyData.setLevel(bean.getRiskLevel());
        modifyData.setOutLevel(bean.getOutLevel());
        modifyData.setInnnerLevel(bean.getInnerLevel());
        modifyData.setLiveLevel(bean.getLiveLevel());
        modifyDataList.add(modifyData);
    }

    @Override
    @Transactional
    public void end() throws Exception {
        if (!errorList().isEmpty()) {
            addError("用户上传的数据中存在错误，所有数据均不予入库");
            log.warn("用户上传的数据中存在错误，所有数据均不予入库");
            return;
        }
        if (!insertList.isEmpty()) {
            CompanyImportAssist companyImportAssist = new CompanyImportAssist(errorList(), sheet);
            companyImportAssist.processCp(insertList, true);
            companyImportAssist.save("system");
        }
        companyService.updateList(updateList);
        for (ModifyData modifyData : modifyDataList) {
            this.companyInfoModify.modify(modifyData);
        }
        log.info("处理企业批量变更数据结束");
        System.gc();
    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入企业批量更改名单时服务器异常 ", e);
    }

    private CompanyDO validateCompanyCode(String companyName, CompanyType typeEnum, String creditCode, String organizationCode) {
        // 用户填写的统一社会信用代码是否为空
        boolean userCreditCodeIsBlank = StringUtils.isBlank(creditCode);
        // 用户填写的组织机构代码是否为空
        boolean userOrganizationCodeIsBlank = StringUtils.isBlank(organizationCode);

        if (userCreditCodeIsBlank && userOrganizationCodeIsBlank) {
            addError("统一社会信用代码和组织结构代码，至少填写一个。");
            return null;
        }

        List<CompanyDO> companyList = companyService.selectAll(CompanyDO.class, "name = ?", companyName);
        // 无该公司名称对应的数据，需要新增
        if (CollectionUtils.isEmpty(companyList)) {
            CompanyDO companyDO = new CompanyDO();
            companyDO.setCompanyType(typeEnum.type().byteValue());
            companyDO.setName(companyName);
            companyDO.setCreditCode(creditCode);
            companyDO.setOrganizationCode(organizationCode);
            insertList.add(companyDO);
            return companyDO;
        }

        // 查询到多条数据，且用户没有填统一信用代码和组织机构代码。认为无法比较，要求用户填写统一信用代码或组织结构代码
        if (companyList.size() > 1 && userCreditCodeIsBlank && userOrganizationCodeIsBlank) {
            addError("无法匹配唯一数据，请填写正确的统一社会信用代码或组织结构代码后重试。");
            return null;
        }

        // 统一社会信用代码匹配元素的下标
        int creditCodeMatchingIndex = -1;
        // 统一社会信用代码匹配元素的个数
        int creditCodeMatchingNum = 0;

        // 组织机构代码匹配元素的下标
        int organizationCodeMatchingIndex = -1;
        // 组织机构代码匹配元素的个数
        int organizationCodeMatchingNum = 0;

        for (int i = 0; i < companyList.size(); i++) {
            CompanyDO companyDO = companyList.get(i);
            // 匹配统一社会信用代码
            if (!userCreditCodeIsBlank && creditCode.equals(companyDO.getCreditCode())) {
                creditCodeMatchingNum++;
                creditCodeMatchingIndex = i;
            }
            // 匹配组织机构代码
            if (!userOrganizationCodeIsBlank && organizationCode.equals(companyDO.getOrganizationCode())) {
                organizationCodeMatchingNum++;
                organizationCodeMatchingIndex = i;
            }

        }
        // 公司名+统一社会信用代码匹配到唯一，且公司名+组织机构代码匹配到唯一。比较是否是同一数据
        if ((creditCodeMatchingNum == 1 && creditCodeMatchingIndex > -1)
                && (organizationCodeMatchingNum == 1 && organizationCodeMatchingIndex > -1)) {

            CompanyDO creditCodeDO = companyList.get(creditCodeMatchingIndex);
            CompanyDO organizationCodeDO = companyList.get(organizationCodeMatchingIndex);
            // 匹配到的是同一数据，认为合理，可以直接返回
            if (creditCodeDO.getCompanyId().equals(organizationCodeDO.getCompanyId())) {
                return creditCodeDO;
            }
            // 匹配到的不是同一数据。可能是统一社会信用代码或组织机构代码填错了，也可能是数据异常。
            addError("根据统一社会信用代码和组织机构代码匹配到不同数据，请检查填写是否正确或联系管理人员。");
            return null;
        }

        // 公司名+统一社会信用代码匹配到唯一。认为统一社会信用代码匹配到合理数据，可以直接返回
        if (creditCodeMatchingNum == 1 && creditCodeMatchingIndex > -1) {
            return companyList.get(creditCodeMatchingIndex);
        }
        // 公司名+组织机构代码匹配到唯一。认为组织机构代码匹配到合理数据，可以直接返回
        if (organizationCodeMatchingNum == 1 && organizationCodeMatchingIndex > -1) {
            return companyList.get(organizationCodeMatchingIndex);
        }
        // 公司名+统一社会信用代码，或公司名+组织代码 匹配到多条数据。
        if (creditCodeMatchingNum > 1 || organizationCodeMatchingNum > 1) {

            // 公司名+统一社会信用代码匹配到多条数据。认为是统一社会信用代码填错或者DB数据出现问题，需要管理员处理
            if (creditCodeMatchingNum > 1) {
                addError("根据统一社会信用代码匹配到多条数据，请确认填写是否正确或联系管理员处理。");
            }
            // 公司名+组织机构代码匹配到多条数据。认为是组织机构代码填错或者DB数据出现问题，需要管理员处理
            if (organizationCodeMatchingNum > 1) {
                addError("根据组织机构代码匹配到多条数据，请确认填写是否正确或联系管理员处理。");
            }
            return null;
        }

        // 查询到多条数据，且用户填了统一信用代码和组织结构代码并无一匹配。
        if (companyList.size() > 1 && (!userCreditCodeIsBlank || !userOrganizationCodeIsBlank)) {
            // 认为系统无法匹配具体的公司，可能DB数据的统一社会信用代码为空或者错误，也可能是用户填错了。
            // 就需要用户确认填写的统一社会信用代码是否正确或管理人员处理数据
            if (!userCreditCodeIsBlank) {
                addError("根据公司名称匹配到多条数据但根据统一社会信用代码无法唯一匹配。请确认填写是否正确或联系管理员处理。");
            }
            // 认为系统无法匹配具体的公司，可能DB数据的组织机构代码为空或者错误，也可能是用户填错了。
            // 就需要用户确认填写的组织机构代码是否正确或管理人员处理数据
            if (!userOrganizationCodeIsBlank) {
                addError("根据公司名称匹配到多条数据但根据组织机构代码无法唯一匹配。请确认填写是否正确或联系管理员处理。");
            }
            return null;
        }

        CompanyDO companyDO = companyList.get(0);

        //原数据的统一社会信用代码不为空，且用户填了统一信用代码，且没有填写组织机构代码。认为需要确认统一社会信用代码或管理人员处理数据
        if (StringUtils.isNotBlank(companyDO.getCreditCode()) && !userCreditCodeIsBlank && userOrganizationCodeIsBlank) {
            addError("根据统一社会信用代码未匹配到数据。请确认填写是否正确或联系管理员处理。");
            return null;
        }
        //原数据的组织机构代码不为空，且用户填了组织机构代码，且没有填写统一信用代码。认为需要确认组织机构代码或管理人员处理数据
        if (StringUtils.isNotBlank(companyDO.getOrganizationCode()) && userCreditCodeIsBlank && !userOrganizationCodeIsBlank) {
            addError("根据组织机构代码未匹配到数据。请确认填写是否正确或联系管理员处理。");
            return null;
        }

        //原数据的统一社会信用代码和组织机构代码不为空，且用户填了统一信用代码和组织机构代码。认为需要确认统一社会信用代码或组织结构代码或管理人员处理数据
        if ((StringUtils.isNotBlank(companyDO.getCreditCode()) && !userCreditCodeIsBlank)
                && (StringUtils.isNotBlank(companyDO.getOrganizationCode()) && !userOrganizationCodeIsBlank)) {
            addError("根据统一社会信用代码和组织机构代码未匹配到数据。请确认填写是否正确或联系管理员处理。");
            return null;
        }

        //原数据的统一社会信用代码为空，且用户填了统一信用代码。更新为用户填写的统一信用代码
        boolean isUpdate = false;
        if (StringUtils.isBlank(companyDO.getCreditCode()) && !userCreditCodeIsBlank) {
            companyDO.setCreditCode(creditCode);
            isUpdate = true;
        }
        //原数据的组织机构代码码为空，且用户填了组织机构代码。更新为用户填写的组织机构代码
        if (StringUtils.isBlank(companyDO.getOrganizationCode()) && !userOrganizationCodeIsBlank) {
            companyDO.setOrganizationCode(organizationCode);
            isUpdate = true;
        }
        if (isUpdate) {
            CompanyDO companyUpdate = new CompanyDO();
            companyUpdate.setCompanyId(companyDO.getCompanyId());
            companyUpdate.setCreditCode(companyDO.getCreditCode());
            companyUpdate.setOrganizationCode(companyDO.getOrganizationCode());
            updateList.add(companyUpdate);
        }
        return companyDO;
    }

    private boolean validateType(CompanyType typeEnum) {
        if (typeEnum == null || typeEnum.equals(CompanyType.TYPE_JR_7) || typeEnum.equals(CompanyType.TYPE_QT_8)) {
            addError("行业类别错误!");
            return false;
        }
        return true;
    }

    private boolean validateRisk(CompanyType typeEnum, Map<String, String> row) {
        RiskValueValidator validator = RiskValidatorFactory.validator(typeEnum.desc());

        // 小额贷款、融资担保
        if (typeEnum.equals(CompanyType.TYPE_XD_2) || typeEnum.equals(CompanyType.TYPE_RZDB_3)) {
            GradeValidator gradeValidator = (GradeValidator) validator;
            boolean haveError = false;
            String outLevel = row.get("outLevel");
            String innerLevel = row.get("innerLevel");
            String liveLevel = row.get("liveLevel");

            String errorMsg = gradeValidator.validateOutLevel(outLevel);
            if (errorMsg != null) {
                haveError = true;
                addError(errorMsg);
            }
            errorMsg = gradeValidator.validateInnerLevel(innerLevel);
            if (errorMsg != null) {
                haveError = true;
                addError(errorMsg);
            }
            errorMsg = gradeValidator.validateLiveLevel(liveLevel);
            if (errorMsg != null) {
                haveError = true;
                addError(errorMsg);
            }
            if (haveError) {
                return false;
            }
        } else {
            String riskValue = row.get("riskLevel");
            String errorMsg = validator.validate(riskValue);
            if (errorMsg != null) {
                addError(errorMsg);
                return false;
            }
        }
        return true;
    }

    /**
     * 将中文转为对应的数字。网贷例外，保留中文
     *
     */
    private void convertDigit(CompanyType typeEnum, Map<String, String> row) {
        RiskValueConverter converter = RiskValidatorFactory.validator(typeEnum.desc());
        // 小额贷款、融资担保
        if (typeEnum.equals(CompanyType.TYPE_XD_2) || typeEnum.equals(CompanyType.TYPE_RZDB_3)) {
            String outLevel = row.get("outLevel");
            row.put("outLevel", converter.convertDigit(outLevel));
            String innerLevel = row.get("innerLevel");
            row.put("innerLevel", converter.convertDigit(innerLevel));
            String liveLevel = row.get("liveLevel");
            row.put("liveLevel", converter.convertDigit(liveLevel));
        } else {
            String riskValue = row.get("riskLevel");
            row.put("riskLevel", converter.convertDigit(riskValue));
        }
    }
}
