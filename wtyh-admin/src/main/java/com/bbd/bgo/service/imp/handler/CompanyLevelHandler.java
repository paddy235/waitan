package com.bbd.bgo.service.imp.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.constants.CompanyBackgroundType;
import com.bbd.wtyh.constants.RiskChgCoSource;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.enums.CompanyLevel;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.CoRiskChgService;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 企业评级处理器
 *
 * @author Created by LiYao on 2017-07-03 14:34.
 */
@Component
@Scope("prototype")
public class CompanyLevelHandler extends AbstractImportHandler<CompanyLevelDO> {

    private Logger log = LoggerFactory.getLogger(CompanyLevelHandler.class);

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CoRiskChgService coRiskChgService;

    private List<CompanyLevelDO> insertList = null;
    private List<CompanyLevelDO> updateList = null;
    private List<RiskChgCoDo> riskChgCoList = null;

    private CompanyDO companyDO;

    private String loginName = "";

    @Override
    public void start(HttpServletRequest request) throws Exception {
        log.info("开始导入企业评级");
        insertList = new ArrayList<>();
        updateList = new ArrayList<>();
        riskChgCoList = new ArrayList<>();

        String tmpName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if (null != tmpName) {
            loginName = tmpName;
        }

    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {

    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        String companyName = row.get("companyName");
        companyDO = this.companyService.getCompanyByName(companyName);
        if (companyDO == null) {
            addError("该企业不存在，请先导入企业名单");
            return false;
        }
        Byte companyType = companyDO.getCompanyType();
        if (companyType == null) {
            addError("该企业没有行业类型，请检查");
            return false;
        }
        if (!companyType.equals(CompanyDO.TYPE_XD_2) && !companyType.equals(CompanyDO.TYPE_RZDB_3)) {
            addError("该企业不为融资担保或小额贷款行业");
            return false;
        }
        String outLevelStr = row.get("outLevel");
        String innerLevelStr = row.get("innerLevel");
        String liveLevelStr = row.get("liveLevel");
        boolean haveError = false;
        String outLevel = null;
        if (StringUtils.isNotBlank(outLevelStr)) {
            CompanyLevel companyLevel = CompanyLevel.getByValue(outLevelStr);
            if (companyLevel == null) {
                addError("外部评级格式不符合要求。");
                haveError = true;
            } else {
                outLevel = companyLevel.ordinal() + "";
            }
        }
        String innerLevel = null;
        if (StringUtils.isNotBlank(innerLevelStr)) {
            CompanyLevel companyLevel = CompanyLevel.getByValue(innerLevelStr);
            if (companyLevel == null) {
                addError("内部评级格式不符合要求。");
                haveError = true;
            } else {
                innerLevel = companyLevel.ordinal() + "";
            }
        }
        String liveLevel = null;
        if (StringUtils.isNotBlank(liveLevelStr)) {
            CompanyLevel companyLevel = CompanyLevel.getByValue(liveLevelStr);
            if (companyLevel == null) {
                addError("现场检查格式不符合要求。");
                haveError = true;
            } else {
                liveLevel = companyLevel.ordinal() + "";
            }
        }
        String companyBackgroundStr = row.get("companyBackground");
        if (StringUtils.isNotBlank(companyBackgroundStr)) {
            CompanyBackgroundType companyBackgroundType = CompanyBackgroundType.getByValue(companyBackgroundStr);
            if (companyBackgroundType == null) {
                addError("企业背景格式不符合要求。");
                haveError = true;
            }
        }
        if (haveError) {
            return false;
        }
        row.put("companyId", companyDO.getCompanyId() + "");
        row.put("outLevel", outLevel);
        row.put("innerLevel", innerLevel);
        row.put("liveLevel", liveLevel);
        return true;
    }

    private String intToString(Integer integer) {
        return integer == null ? null : integer.toString();
    }

    @Override
    public void endRow(Map<String, String> row, CompanyLevelDO bean) throws Exception {

        ModifyData modifyData = new ModifyData();
        modifyData.setName(companyDO.getName());
        modifyData.setInnerLevel(intToString(bean.getInnerLevel()));
        modifyData.setOutLevel(intToString(bean.getOutLevel()));
        modifyData.setLiveLevel(intToString(bean.getLiveLevel()));
        modifyData.setIndustry(companyDO.getCompanyType().toString());

        String createBy = loginName + "导入企业评级";
        RiskChgCoDo riskChgCoDo = coRiskChgService.generateNewRecord(modifyData, createBy, RiskChgCoSource.MANUAL_MODIFY);

        if (riskChgCoDo == null) {
            return;
        }
        bean.setUpdateBy(createBy);
        bean.setUpdateDate(new Date());
        CompanyLevelDO companyLevel = this.companyService.selectById(CompanyLevelDO.class,row.get("companyId"));
        if(null==companyLevel){
            bean.setCreateBy(createBy);
            bean.setCreateDate(new Date());
            insertList.add(bean);
        }else{
            updateList.add(bean);
        }
        this.riskChgCoList.add(riskChgCoDo);
    }

    @Override
    @Transactional
    public void end() throws Exception {
        if (errorList().isEmpty()) {
            this.companyService.insertList(insertList);
            this.companyService.updateList(updateList, false, false);
            this.companyService.insertList(riskChgCoList);
        } else {
            addError("用户上传的企业评级中的数据有误，所有数据均不予入库");
        }
        log.info("导入企业评级结束");
    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入企业评级服务器异常！", e);
    }
}
