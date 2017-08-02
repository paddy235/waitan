package com.bbd.bgo.service.imp.handler.prifund;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.QflpCompanyDO;
import com.bbd.wtyh.domain.dto.QflpCompanyDTO;
import com.bbd.wtyh.excel.imp.entity.ImportError;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.PrivateFundService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by lixudong on 2017/7/26.
 */
@Component
@Scope("prototype") //非单例模式
public class PriFundQflpCompanyHandler  extends AbstractImportHandler<QflpCompanyDTO> {

    final static String caption = "私募基金-QFLP试点企业";

    private Logger log = LoggerFactory.getLogger(PriFundQflpCompanyHandler.class);

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PrivateFundService privateFundService;

    private List<QflpCompanyDTO> insertList = null;
    private List<QflpCompanyDTO> updateList = null;
    String loginName = "";

    @Override
    public void start(HttpServletRequest request) throws Exception {
        loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if (null == loginName) {
            loginName = "";
        }
        log.info("开始检查" + caption);
        insertList = new LinkedList<>();
        updateList = new LinkedList<>();
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {

    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        return true;
    }

    @Override
    public void endRow(Map<String, String> row, QflpCompanyDTO bean) throws Exception {
        CompanyDO cp = companyService.getCompanyByName(bean.getCompanyName());
        if (null == cp) {
            cp = companyService.getCompanyByName(bean.getCompanyName(), true);
        }
        if (null == cp) {
            addError("未查询到此企业");
            return;
        }

        QflpCompanyDO qflpCompanyDO = privateFundService.getQflpCompanyByPrimaryKey(cp.getCompanyId());

        if (null == qflpCompanyDO) {
            insertList.add(bean);
        } else {
            updateList.add(bean);
        }
    }

    @Override
    public void end() throws Exception {
        if (errorList().size() > 0) {
            addError("用户上传的" + caption + "中的数据有误，所有数据均不予入库");
            log.warn("用户上传的" + caption + "中的数据有误，所有数据均不予入库");
            List<ImportError> list = errorList();
            return;
        }
        for(QflpCompanyDTO qflpCompanyDTO:updateList){
            CompanyDO cp = companyService.getCompanyByName(qflpCompanyDTO.getCompanyName());
            QflpCompanyDO qflpCompanyDO = privateFundService.getQflpCompanyByPrimaryKey(cp.getCompanyId());
            qflpCompanyDO.setDollorPart(qflpCompanyDTO.getDollarPart());
            qflpCompanyDO.setRmbPart(qflpCompanyDTO.getRmbTotal());
            qflpCompanyDO.setScale(qflpCompanyDTO.getTotal());
            qflpCompanyDO.setUpdateBy(loginName);
            qflpCompanyDO.setUpdateDate(new Date());
            privateFundService.updateQflpCompany(qflpCompanyDO);
        }
        for(QflpCompanyDTO qflpCompanyDTO:insertList){
            CompanyDO cp = companyService.getCompanyByName(qflpCompanyDTO.getCompanyName());
            QflpCompanyDO qflpCompanyDO = new QflpCompanyDO();
            qflpCompanyDO.setCompanyId(cp.getCompanyId());
            qflpCompanyDO.setDollorPart(qflpCompanyDTO.getDollarPart());
            qflpCompanyDO.setRmbPart(qflpCompanyDTO.getRmbTotal());
            qflpCompanyDO.setScale(qflpCompanyDTO.getTotal());
            qflpCompanyDO.setCreateBy(loginName);
            qflpCompanyDO.setCreateDate(new Date());
            privateFundService.addQflpCompany(qflpCompanyDO);
        }
        log.info(caption + "导入已完成");
    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入{}服务器异常 ", caption, e);
    }
}
